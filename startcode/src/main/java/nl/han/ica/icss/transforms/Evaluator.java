package nl.han.ica.icss.transforms;

import nl.han.ica.datastructures.HANLinkedList;
import nl.han.ica.datastructures.IHANLinkedList;
import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.BoolLiteral;
import nl.han.ica.icss.ast.literals.PercentageLiteral;
import nl.han.ica.icss.ast.literals.PixelLiteral;
import nl.han.ica.icss.ast.literals.ScalarLiteral;
import nl.han.ica.icss.ast.operations.AddOperation;
import nl.han.ica.icss.ast.operations.MultiplyOperation;
import nl.han.ica.icss.ast.operations.SubtractOperation;

import java.util.ArrayList;
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

        // Create a list of nodes to remove instead of removing them right away, because we can't remove nodes while iterating over them
        // Otherwise, the ConcurrentModificationException will be thrown
        ArrayList<ASTNode> nodesToRemove = new ArrayList<>();
        for (ASTNode node : stylesheet.getChildren()) {
            if (node instanceof VariableAssignment) {
                evaluateVariableAssignment((VariableAssignment) node);
                nodesToRemove.add(node);
            } else if (node instanceof Stylerule) {
                evaluateStylerule((Stylerule) node);
            }
        }

        // Remove the nodes that were marked for removal
        for (ASTNode node : nodesToRemove) {
            stylesheet.removeChild(node);
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

    private int getLiteralAsInt(Literal literal) {
        if (literal instanceof PercentageLiteral) {
            return ((PercentageLiteral) literal).value;
        } else if (literal instanceof PixelLiteral) {
            return ((PixelLiteral) literal).value;
        } else if (literal instanceof ScalarLiteral) {
            return ((ScalarLiteral) literal).value;
        }
        return 0;
    }

    private void evaluateStylerule(Stylerule stylerule) {
        variableValues.addFirst(new HashMap<>());
        ArrayList<ASTNode> declarations = new ArrayList<>();
        // Use a list of children to remove for the same reason as in evaluateStylesheet
        for (ASTNode child : stylerule.getChildren()) {
            if (child instanceof VariableAssignment) {
                evaluateVariableAssignment((VariableAssignment) child);
            } else if (child instanceof Declaration) {
                evaluateDeclaration((Declaration) child);
                declarations.add(child);
            } else if (child instanceof IfClause) {
                var output = evaluateIfClause((IfClause) child);
                for (ASTNode node : output) {
                    declarations.add(node);
                }
            } else if (child instanceof Comment) {
                declarations.add(child);
            }

        }
        stylerule.body = declarations;
        variableValues.removeFirst();
    }

    private void evaluateDeclaration(Declaration declaration) {
        if (declaration.expression instanceof VariableReference) {
            declaration.expression = evaluateVariableLiteral(((VariableReference) declaration.expression).name);
        } else if (declaration.expression instanceof Operation) {
            declaration.expression = evaluateOperation((Operation) declaration.expression);
        }
    }

    private ArrayList<ASTNode> evaluateIfClause(IfClause ifClause) {
        ArrayList<ASTNode> declarations = new ArrayList<>();
        if (evaluateIfClauseCondition(ifClause)) {
            evaluateIfClauseBody(ifClause.body, declarations);
        } else if (ifClause.elseClause != null) {
            evaluateIfClauseBody(ifClause.elseClause.body, declarations);
        }
        return declarations;
    }

    private boolean evaluateIfClauseCondition(IfClause ifClause) {
        if (ifClause.conditionalExpression instanceof VariableReference) {
            var boolLiteral = evaluateVariableLiteral(((VariableReference) ifClause.conditionalExpression).name);
            return ((BoolLiteral) boolLiteral).value;
        } else if (ifClause.conditionalExpression instanceof BoolLiteral) {
            return ((BoolLiteral) ifClause.conditionalExpression).value;
        }
        return false;
    }

    private void evaluateIfClauseBody(ArrayList<ASTNode> body, ArrayList<ASTNode> declarations) {
        for (ASTNode child : body) {
            if (child instanceof VariableAssignment) {
                evaluateVariableAssignment((VariableAssignment) child);
            } else if (child instanceof Declaration) {
                evaluateDeclaration((Declaration) child);
                declarations.add(child);
            } else if (child instanceof IfClause) {
                var output = evaluateIfClause((IfClause) child);
                for (ASTNode node : output) {
                    declarations.add(node);
                }
            } else if (child instanceof Comment) {
                declarations.add(child);
            }
        }
    }
}
