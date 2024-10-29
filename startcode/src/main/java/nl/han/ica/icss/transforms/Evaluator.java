package nl.han.ica.icss.transforms;

import nl.han.ica.datastructures.HANLinkedList;
import nl.han.ica.datastructures.IHANLinkedList;
import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.PercentageLiteral;
import nl.han.ica.icss.ast.literals.PixelLiteral;
import nl.han.ica.icss.ast.literals.ScalarLiteral;
import nl.han.ica.icss.ast.operations.AddOperation;
import nl.han.ica.icss.ast.operations.MultiplyOperation;
import nl.han.ica.icss.ast.operations.SubtractOperation;

import java.util.HashMap;

public class Evaluator implements Transform {

    private IHANLinkedList<HashMap<String, Literal>> variableValues;

    public Evaluator() {
        variableValues = new HANLinkedList<>();
    }

    @Override
    public void apply(AST ast) {
        evaluateStylesheet(ast.root);
    }

    private void evaluateStylesheet(Stylesheet stylesheet) {
        variableValues.addFirst(new HashMap<>());
        for (ASTNode node : stylesheet.getChildren()) {
            if (node instanceof VariableAssignment) {
                evaluateVariableAssignment((VariableAssignment) node);
                stylesheet.removeChild(node);
            } else if (node instanceof Stylerule) {
                evaluateStylerule((Stylerule) node);
            }
        }

        variableValues.removeFirst();
    }

    private void evaluateVariableAssignment(VariableAssignment variableAssignment) {
        Literal value = null;

        if (variableAssignment.expression instanceof Literal) {
            value = (Literal) variableAssignment.expression;
        } else if (variableAssignment.expression instanceof VariableReference) {
            value = evaluateVariableLiteral(((VariableReference) variableAssignment.expression).name);
        } else if (variableAssignment.expression instanceof Operation) {
            value = evaluateOperation((Operation) variableAssignment.expression);
        }

        variableValues.getFirst().put(variableAssignment.name.name, value);
    }

    private Literal evaluateVariableLiteral(String variableName) {
        for (int i = 0; i < variableValues.getSize(); i++) {
            var value = variableValues.get(i).get(variableName);
            if (value != null) {
                return value;
            }
        }
        return null;
    }

    private Literal evaluateOperation(Operation operation) {
        Literal leftHandSide;
        Literal rightHandSide;

        if (operation.lhs instanceof Operation) {
            leftHandSide = evaluateOperation((Operation) operation.lhs);
        } else if (operation.lhs instanceof VariableReference) {
            leftHandSide = evaluateVariableLiteral(((VariableReference) operation.lhs).name);
        } else {
            leftHandSide = (Literal) operation.lhs;
        }

        if (operation.rhs instanceof Operation) {
            rightHandSide = evaluateOperation((Operation) operation.rhs);
        } else if (operation.rhs instanceof VariableReference) {
            rightHandSide = evaluateVariableLiteral(((VariableReference) operation.rhs).name);
        } else {
            rightHandSide = (Literal) operation.rhs;
        }

        if (operation instanceof MultiplyOperation) {
            return evaluateMultiplyOperation(leftHandSide, rightHandSide);
        } else if (operation instanceof AddOperation) {
            return evaluateAddOperation(leftHandSide, rightHandSide);
        } else if (operation instanceof SubtractOperation) {
            return evaluateSubtractOperation(leftHandSide, rightHandSide);
        }

        return null;
    }

    private Literal evaluateMultiplyOperation(Literal leftHandSide, Literal rightHandSide) {
        int leftHandValue = getLiteralAsInt(leftHandSide);
        int rightHandValue = getLiteralAsInt(rightHandSide);
        int result = leftHandValue * rightHandValue;

        if (leftHandSide instanceof PercentageLiteral || rightHandSide instanceof PercentageLiteral) {
            return new PercentageLiteral(result);
        } else if (leftHandSide instanceof PixelLiteral || rightHandSide instanceof PixelLiteral) {
            return new PixelLiteral(result);
        } else {
            return new ScalarLiteral(result);
        }
    }

    private Literal evaluateAddOperation(Literal leftHandSide, Literal rightHandSide) {
        int leftHandValue = getLiteralAsInt(leftHandSide);
        int rightHandValue = getLiteralAsInt(rightHandSide);
        int result = leftHandValue + rightHandValue;

        if (leftHandSide instanceof PercentageLiteral || rightHandSide instanceof PercentageLiteral) {
            return new PercentageLiteral(result);
        } else if (leftHandSide instanceof PixelLiteral || rightHandSide instanceof PixelLiteral) {
            return new PixelLiteral(result);
        } else {
            return new ScalarLiteral(result);
        }
    }

    private Literal evaluateSubtractOperation(Literal leftHandSide, Literal rightHandSide) {
        int leftHandValue = getLiteralAsInt(leftHandSide);
        int rightHandValue = getLiteralAsInt(rightHandSide);
        int result = leftHandValue - rightHandValue;

        if (leftHandSide instanceof PercentageLiteral || rightHandSide instanceof PercentageLiteral) {
            return new PercentageLiteral(result);
        } else if (leftHandSide instanceof PixelLiteral || rightHandSide instanceof PixelLiteral) {
            return new PixelLiteral(result);
        } else {
            return new ScalarLiteral(result);
        }
    }

    private int getLiteralAsInt(Literal leftHandSide) {
        if (leftHandSide instanceof PercentageLiteral) {
            return ((PercentageLiteral) leftHandSide).value;
        } else if (leftHandSide instanceof PixelLiteral) {
            return ((PixelLiteral) leftHandSide).value;
        } else if (leftHandSide instanceof ScalarLiteral) {
            return ((ScalarLiteral) leftHandSide).value;
        }
        return 0;
    }

    private void evaluateStylerule(Stylerule node) {
        variableValues.addFirst(new HashMap<>());
        for (ASTNode child : node.getChildren()) {
            if (child instanceof VariableAssignment) {
                evaluateVariableAssignment((VariableAssignment) child);
                node.removeChild(child);
            } else if (child instanceof Declaration) {
                evaluateDeclaration((Declaration) child);
            } else if (child instanceof IfClause) {
                evaluateIfClause((IfClause) child);
            }
        }
        variableValues.removeFirst();
    }
}
