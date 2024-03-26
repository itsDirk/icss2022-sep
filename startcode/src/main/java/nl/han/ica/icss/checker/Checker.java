package nl.han.ica.icss.checker;

import nl.han.ica.datastructures.HANLinkedList;
import nl.han.ica.datastructures.IHANLinkedList;
import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.*;
import nl.han.ica.icss.ast.operations.AddOperation;
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
                checkStylerule((Stylerule) node);
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

    private void checkStylerule(Stylerule stylerule) {
        variableTypes.addFirst(new HashMap<>());
        for (ASTNode node : stylerule.getChildren()) {
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



}
