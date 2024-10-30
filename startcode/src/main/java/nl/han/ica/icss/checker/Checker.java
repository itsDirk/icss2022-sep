package nl.han.ica.icss.checker;

import nl.han.ica.datastructures.HANLinkedList;
import nl.han.ica.datastructures.IHANLinkedList;
import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.*;
import nl.han.ica.icss.ast.operations.AddOperation;
import nl.han.ica.icss.ast.operations.MultiplyOperation;
import nl.han.ica.icss.ast.operations.SubtractOperation;
import nl.han.ica.icss.ast.selectors.ClassSelector;
import nl.han.ica.icss.ast.selectors.IdSelector;
import nl.han.ica.icss.ast.selectors.TagSelector;
import nl.han.ica.icss.ast.types.ExpressionType;

import java.util.HashMap;


public class Checker {

    private IHANLinkedList<HashMap<String, ExpressionType>> variableTypes;

    public void check(AST ast) {
        variableTypes = new HANLinkedList<>();
        checkStylesheet(ast.root);
    }

    private void checkStylesheet(Stylesheet stylesheet) {
        variableTypes.addFirst(new HashMap<>());
        for (ASTNode node : stylesheet.getChildren()) {
            if (node instanceof VariableAssignment) {
                checkVariableAssignment((VariableAssignment) node);
            } else if (node instanceof Stylerule) {
                checkStyleRule((Stylerule) node);
            } else if (node instanceof Comment) {
                // Do nothing, we can ignore comments :D
            } else {
                node.setError("Ongeldig type: Stylerule");
            }
        }
        variableTypes.removeFirst();
    }

    private void checkVariableAssignment(VariableAssignment variableAssignment) {
        if (variableAssignment.expression instanceof BoolLiteral) {
            variableTypes.getFirst().put(variableAssignment.name.name, ExpressionType.BOOL);
        } else if (variableAssignment.expression instanceof ColorLiteral) {
            variableTypes.getFirst().put(variableAssignment.name.name, ExpressionType.COLOR);
        } else if (variableAssignment.expression instanceof PixelLiteral) {
            variableTypes.getFirst().put(variableAssignment.name.name, ExpressionType.PIXEL);
        } else if (variableAssignment.expression instanceof PercentageLiteral) {
            variableTypes.getFirst().put(variableAssignment.name.name, ExpressionType.PERCENTAGE);
        } else if (variableAssignment.expression instanceof ScalarLiteral) {
            variableTypes.getFirst().put(variableAssignment.name.name, ExpressionType.SCALAR);
        } else if (variableAssignment.expression instanceof Expression) {
            variableTypes.getFirst().put(variableAssignment.name.name, checkExpression(variableAssignment.expression));
        } else {
            variableAssignment.setError("Ongeldig type: verwachtte Bool, Color, Pixel, Percentage of Scalar");
        }
    }

    private void checkStyleRule(Stylerule stylerule) {
        variableTypes.addFirst(new HashMap<>());

        for (ASTNode node : stylerule.getChildren()) {
            if (node instanceof TagSelector) {
                checkSelector((Selector) node);
            } else if (node instanceof Declaration) {
                checkDeclaration((Declaration) node);
            } else if (node instanceof IfClause) {
                checkIfClause((IfClause) node);
            } else if (node instanceof VariableAssignment) {
                checkVariableAssignment((VariableAssignment) node);

            }
        }
        variableTypes.removeFirst();
    }

    private void checkSelector(Selector selector) {
        // No further checking needed for ClassSelectors and IdSelectors
        if (selector instanceof ClassSelector || selector instanceof IdSelector) {
            return;
        } else if (selector instanceof TagSelector) {
            checkTagSelector((TagSelector) selector);
        } else {
            selector.setError("Ongeldig type: verwachtte TagSelector");
        }
    }

    private void checkTagSelector(TagSelector tagSelector) {
        // List of all valid tag selectors
        String[] validTagSelectors = {"p", "a", "h1"};

        for (String validTagSelector : validTagSelectors) {
            if (tagSelector.tag.equals(validTagSelector)) {
                return;
            }
        }
        tagSelector.setError("Ongeldige tag: " + tagSelector.tag);
    }

    private void checkDeclaration(Declaration declaration) {
        ExpressionType expressionType = checkExpression(declaration.expression);

        if (expressionType != ExpressionType.UNDEFINED) {
            switch (declaration.property.name) {
                case "width":
                    if (expressionType != ExpressionType.PIXEL && expressionType != ExpressionType.PERCENTAGE) {
                        declaration.setError("Width moet een pixel of percentage zijn");
                    }
                    break;
                case "height":
                    if (expressionType != ExpressionType.PIXEL && expressionType != ExpressionType.PERCENTAGE) {
                        declaration.setError("Height moet een pixel of percentage zijn");
                    }
                    break;
                case "color":
                    if (expressionType != ExpressionType.COLOR) {
                        declaration.setError("Color moet een kleur zijn");
                    }
                    break;
                case "background-color":
                    if (expressionType != ExpressionType.COLOR) {
                        declaration.setError("Background-color moet een kleur zijn");
                    }
                    break;
                default:
                    declaration.setError("Ongeldige eigenschap: " + declaration.property.name);
            }
        }
    }

    private ExpressionType checkExpression(Expression expression) {
        if (expression instanceof Literal) {
            return checkLiteral((Literal) expression);
        } else if (expression instanceof VariableReference) {
            return checkVariableReference((VariableReference) expression);
        } else if (expression instanceof Operation) {
            return checkOperation((Operation) expression);
        }
        expression.setError("Ongeldige expressie: " + expression.getClass().getSimpleName());
        return ExpressionType.UNDEFINED;
    }

    private ExpressionType checkLiteral(Literal literal) {
        if (literal instanceof BoolLiteral) {
            return ExpressionType.BOOL;
        } else if (literal instanceof ColorLiteral) {
            return ExpressionType.COLOR;
        } else if (literal instanceof PixelLiteral) {
            return ExpressionType.PIXEL;
        } else if (literal instanceof PercentageLiteral) {
            return ExpressionType.PERCENTAGE;
        } else if (literal instanceof ScalarLiteral) {
            return ExpressionType.SCALAR;
        }
        literal.setError("Ongeldig type: verwachtte Bool, Color, Pixel, Percentage of Scalar");
        return ExpressionType.UNDEFINED;
    }

    private ExpressionType checkVariableReference(VariableReference variableReference) {
        for (HashMap<String, ExpressionType> currentScope : variableTypes) {
            if (currentScope.containsKey(variableReference.name)) {
                return currentScope.get(variableReference.name);
            }
        }
        variableReference.setError("Variabele niet gedefinieerd: " + variableReference.name);
        return ExpressionType.UNDEFINED;
    }

    private ExpressionType checkOperation(Operation operation) {
        for (ASTNode child : operation.getChildren()) {
            if (child instanceof BoolLiteral || child instanceof ColorLiteral) {
                child.setError("Ongeldig operatietype: " + child.getClass().getSimpleName());
                return ExpressionType.UNDEFINED;
            }
        }

        if (operation instanceof MultiplyOperation) {
            return checkMultiplyOperation((MultiplyOperation) operation);
        } else if (operation instanceof AddOperation) {
            return checkAddOperation((AddOperation) operation);
        } else if (operation instanceof SubtractOperation) {
            return checkSubtractOperation((SubtractOperation) operation);
        }
        operation.setError("Ongeldig operatietype: " + operation.getClass().getSimpleName());
        return ExpressionType.UNDEFINED;
    }

    private ExpressionType checkMultiplyOperation(MultiplyOperation operation) {
        ExpressionType leftHandType = checkExpression(operation.lhs);
        ExpressionType rightHandType = checkExpression(operation.rhs);

        if (leftHandType == ExpressionType.SCALAR || rightHandType == ExpressionType.SCALAR) {
            return leftHandType == ExpressionType.SCALAR ? rightHandType : leftHandType;
        } else if (leftHandType == ExpressionType.UNDEFINED || rightHandType == ExpressionType.UNDEFINED) {
            operation.setError("Ongeldige operatie: " + leftHandType + " * " + rightHandType + "; kan niet vermenigvuldigen met ongedefinieerde types");
            return ExpressionType.UNDEFINED;
        } else if (leftHandType == rightHandType) {
            operation.setError("Ongeldige operatie: " + leftHandType + " * " + rightHandType + "; kan gelijke types niet vermenigvuldigen");
            return ExpressionType.UNDEFINED;
        }

        operation.setError("Ongeldige operatie: " + leftHandType + " * " + rightHandType);
        return ExpressionType.UNDEFINED;
    }

    private ExpressionType checkAddOperation(AddOperation operation) {
        ExpressionType leftHandType = checkExpression(operation.lhs);
        ExpressionType rightHandType = checkExpression(operation.rhs);

        if (leftHandType == rightHandType) {
            return leftHandType;
        } else if (leftHandType == ExpressionType.UNDEFINED || rightHandType == ExpressionType.UNDEFINED) {
            operation.setError("Ongeldige operatie: " + leftHandType + " + " + rightHandType + "; kan ongedefinieerde types niet bij elkaar optellen");
            return ExpressionType.UNDEFINED;
        } else {
            operation.setError("Ongeldige operatie: " + leftHandType + " + " + rightHandType + "; kan ongelijke types niet optellen");
            return ExpressionType.UNDEFINED;
        }
    }

    private ExpressionType checkSubtractOperation(SubtractOperation operation) {
        ExpressionType leftHandType = checkExpression(operation.lhs);
        ExpressionType rightHandType = checkExpression(operation.rhs);

        if (leftHandType == rightHandType) {
            return leftHandType;
        } else if (leftHandType == ExpressionType.UNDEFINED || rightHandType == ExpressionType.UNDEFINED) {
            operation.setError("Ongeldige operatie: " + leftHandType + " - " + rightHandType + "; kan ongedefinieerde types niet van elkaar aftrekken");
            return ExpressionType.UNDEFINED;
        } else {
            operation.setError("Ongeldige operatie: " + leftHandType + " - " + rightHandType + "; kan ongelijke types niet van elkaar aftrekken");
            return ExpressionType.UNDEFINED;
        }
    }

    private void checkIfClause(IfClause ifClause) {
        variableTypes.addFirst(new HashMap<>());
        if (ifClause.conditionalExpression instanceof BoolLiteral) {
            checkLiteral((BoolLiteral) ifClause.conditionalExpression);
        } else if (ifClause.conditionalExpression instanceof VariableReference) {
            if (checkVariableReference((VariableReference) ifClause.conditionalExpression) != ExpressionType.BOOL) {
                ifClause.conditionalExpression.setError("Ongeldige expressie: " + ifClause.conditionalExpression.getClass().getSimpleName() + "; verwachtte Boolean");
            }
        } else {
            ifClause.conditionalExpression.setError("Ongeldige expressie: " + ifClause.conditionalExpression.getClass().getSimpleName() + "; verwachtte Boolean");
        }

        for (ASTNode node : ifClause.body) {
            if (node instanceof VariableAssignment) {
                checkVariableAssignment((VariableAssignment) node);
            } else if (node instanceof Declaration) {
                checkDeclaration((Declaration) node);
            } else if (node instanceof IfClause) {
                checkIfClause((IfClause) node);
            } else if (node instanceof Comment) {
                // Do nothing, we can ignore comments
            } else {
                node.setError("Ongeldige expressie: " + node.getClass().getSimpleName() + ", verwachtte VariableAssignment, Declaration, If Clause of Else Clause");
            }
        }

        if (ifClause.elseClause instanceof ElseClause) {
            checkElseClause(ifClause.elseClause);
        }
        variableTypes.removeFirst();
    }

    private void checkElseClause(ElseClause elseClause) {
        variableTypes.addFirst(new HashMap<>());
        for (ASTNode node : elseClause.body) {
            if (node instanceof VariableAssignment) {
                checkVariableAssignment((VariableAssignment) node);
            } else if (node instanceof Declaration) {
                checkDeclaration((Declaration) node);
            } else if (node instanceof Comment) {
                // Do nothing, we can ignore comments
            } else {
                node.setError("Else clause kan alleen worden gebruikt met declaraties en variabele toewijzingen");
            }
        }
        variableTypes.removeFirst();
    }
}
