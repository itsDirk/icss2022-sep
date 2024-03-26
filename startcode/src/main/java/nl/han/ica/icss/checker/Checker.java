package nl.han.ica.icss.checker;

import nl.han.ica.datastructures.HANLinkedList;
import nl.han.ica.datastructures.IHANLinkedList;
import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.*;
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
        }
        expression.setError("Ongeldig type: TODO");
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


}
