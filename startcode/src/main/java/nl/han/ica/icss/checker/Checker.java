package nl.han.ica.icss.checker;

import nl.han.ica.datastructures.HANLinkedList;
import nl.han.ica.datastructures.IHANLinkedList;
import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.*;
import nl.han.ica.icss.ast.operations.AddOperation;
import nl.han.ica.icss.ast.operations.MultiplyOperation;
import nl.han.ica.icss.ast.operations.SubtractOperation;
import nl.han.ica.icss.ast.types.ExpressionType;

import java.util.HashMap;


public class Checker {

    private IHANLinkedList<HashMap<String, ExpressionType>> variableTypes;

    public void check(AST ast) {
        variableTypes = new HANLinkedList<>();
        checkStylesheet(ast.root);
    }

    private void checkStylesheet(Stylesheet Stylesheet) {
        variableTypes.addFirst(new HashMap<>());
        for (ASTNode node : Stylesheet.getChildren()) {
            if (node instanceof VariableAssignment) {
                checkVariableAssignment((VariableAssignment) node);
            } else if (node instanceof Stylerule) {
                checkRuleAssignement((Stylerule) node);
            } else {
                node.setError("Ongeldig type: verwachtte VariableAssignment of Stylerule");
            }
        }
        variableTypes.removeFirst();
    }

    private void checkVariableAssignment(VariableAssignment variableAssignment) {
        checkVariableName(variableAssignment.name);

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
        } else {
            variableAssignment.setError("Ongeldig type: verwachtte Bool, Color, Pixel, Percentage of Scalar");
        }
    }

    private void checkVariableName(VariableReference name) {
        if (!variableTypes.getFirst().containsKey(name.name)) {
            name.setError("Variabele niet gedefinieerd: " + name.name);
        }
    }

    private void checkRuleAssignement(Stylerule stylerule) {
        variableTypes.addFirst(new HashMap<>());
        for (ASTNode node : stylerule.body) {
            if (node instanceof VariableAssignment) {
                checkVariableAssignment((VariableAssignment) node);
            } else if (node instanceof Declaration) {
                checkDeclaration((Declaration) node);
            } else {
                node.setError("Ongeldig type: verwachtte VariableAssignment of Declaration");
            }
        }
        variableTypes.removeFirst();
    }

    private void checkDeclaration(Declaration declaration) {
//        PropertyName propertyName = checkPropertyName(declaration.property);
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


    //    private PropertyName checkPropertyName(PropertyName property) {
//        String[] validProperties = {"width", "height", "color", "background-color"};
//        for (String validProperty : validProperties) {
//            if (property.name.equals(validProperty)) {
//                return property;
//            }
//        }
//        property.setError("Ongeldige eigenschap: " + property.name);
//        return null;
//    }

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
        ExpressionType leftType = checkExpression(operation.lhs);
        ExpressionType rightType = checkExpression(operation.rhs);

        if (leftType == rightType) {
            return leftType;
        } else {
            operation.setError("Ongeldige operatie: " + leftType + " * " + rightType);
            return ExpressionType.UNDEFINED;
        }
    }

    private ExpressionType checkAddOperation(AddOperation operation) {
        ExpressionType leftType = checkExpression(operation.lhs);
        ExpressionType rightType = checkExpression(operation.rhs);

        if (leftType == rightType) {
            return leftType;
        } else {
            operation.setError("Ongeldige operatie: " + leftType + " + " + rightType);
            return ExpressionType.UNDEFINED;
        }
    }

    private ExpressionType checkSubtractOperation(SubtractOperation operation) {
        ExpressionType leftType = checkExpression(operation.lhs);
        ExpressionType rightType = checkExpression(operation.rhs);

        if (leftType == rightType) {
            return leftType;
        } else {
            operation.setError("Ongeldige operatie: " + leftType + " - " + rightType);
            return ExpressionType.UNDEFINED;
        }
    }




}
