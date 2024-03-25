package nl.han.ica.icss.checker;

import nl.han.ica.datastructures.HANLinkedList;
import nl.han.ica.datastructures.IHANLinkedList;
import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.PercentageLiteral;
import nl.han.ica.icss.ast.literals.PixelLiteral;
import nl.han.ica.icss.ast.literals.ScalarLiteral;
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
        for (ASTNode node : Stylesheet.getChildren()) {
            if (node instanceof Stylerule) {
                checkStylerule((Stylerule) node);
            }
        }
    }

    private void checkStylerule(Stylerule stylerule) {
        for (ASTNode node : stylerule.getChildren()) {
            if (node instanceof Declaration) {
                checkDeclaration((Declaration) node);
            }
        }
    }

    private void checkDeclaration(Declaration declaration) {
        if (declaration.expression instanceof Literal) {
            declaration.expression = (Literal) declaration.expression;
        } else {
            declaration.expression = checkAddOperation((AddOperation) declaration.expression);
        }
    }

private Expression checkAddOperation(AddOperation expression) {
        if (expression.lhs instanceof PixelLiteral && expression.rhs instanceof PixelLiteral) {
            return new PixelLiteral(((PixelLiteral) expression.lhs).value + ((PixelLiteral) expression.rhs).value);
        } else if (expression.lhs instanceof PercentageLiteral && expression.rhs instanceof PercentageLiteral) {
            return new PercentageLiteral(((PercentageLiteral) expression.lhs).value + ((PercentageLiteral) expression.rhs).value);
        } else if (expression.lhs instanceof ScalarLiteral && expression.rhs instanceof ScalarLiteral) {
            return new ScalarLiteral(((ScalarLiteral) expression.lhs).value + ((ScalarLiteral) expression.rhs).value);
        } else {
            return null;
        }
    }





    
}
