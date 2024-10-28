package nl.han.ica.icss.parser;

import nl.han.ica.datastructures.HANStack;
import nl.han.ica.datastructures.IHANStack;
import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.*;
import nl.han.ica.icss.ast.operations.AddOperation;
import nl.han.ica.icss.ast.operations.MultiplyOperation;
import nl.han.ica.icss.ast.operations.SubtractOperation;
import nl.han.ica.icss.ast.selectors.ClassSelector;
import nl.han.ica.icss.ast.selectors.IdSelector;
import nl.han.ica.icss.ast.selectors.TagSelector;

/**
 * This class extracts the ICSS Abstract Syntax Tree from the Antlr Parse tree.
 */
public class ASTListener extends ICSSBaseListener {

    //Accumulator attributes:
    private AST ast;

    //Use this to keep track of the parent nodes when recursively traversing the ast
    private IHANStack<ASTNode> currentContainer;

    public ASTListener() {
        ast = new AST();
        currentContainer = new HANStack<>();
        currentContainer.push(ast.root);
    }

    public AST getAST() {
        return ast;
    }

    // RuleAssignement
    @Override
    public void enterStyleRule(ICSSParser.StyleRuleContext ctx) {
        Stylerule stylerule = new Stylerule();
        currentContainer.push(stylerule);
    }

    @Override
    public void exitStyleRule(ICSSParser.StyleRuleContext ctx) {
        Stylerule stylerule = (Stylerule) currentContainer.pop();
        currentContainer.peek().addChild(stylerule);
    }

    // Class Selector
    @Override
    public void enterClassSelector(ICSSParser.ClassSelectorContext ctx) {
        Selector selector = new ClassSelector(ctx.getText());
        currentContainer.push(selector);
    }

    @Override
    public void exitClassSelector(ICSSParser.ClassSelectorContext ctx) {
        Selector selector = (Selector) currentContainer.pop();
        currentContainer.peek().addChild(selector);
    }

    // Tag Selector
    @Override
    public void enterTagSelector(ICSSParser.TagSelectorContext ctx) {
        Selector selector = new TagSelector(ctx.getText());
        currentContainer.push(selector);
    }

    @Override
    public void exitTagSelector(ICSSParser.TagSelectorContext ctx) {
        Selector selector = (Selector) currentContainer.pop();
        currentContainer.peek().addChild(selector);
    }

    // Id Selector
    @Override
    public void enterIdSelector(ICSSParser.IdSelectorContext ctx) {
        Selector selector = new IdSelector(ctx.getText());
        currentContainer.push(selector);
    }

    @Override
    public void exitIdSelector(ICSSParser.IdSelectorContext ctx) {
        Selector selector = (Selector) currentContainer.pop();
        currentContainer.peek().addChild(selector);
    }

    // Declaration
    @Override
    public void enterDeclaration(ICSSParser.DeclarationContext ctx) {
        Declaration declaration = new Declaration();
        currentContainer.push(declaration);
    }

    @Override
    public void exitDeclaration(ICSSParser.DeclarationContext ctx) {
        Declaration declaration = (Declaration) currentContainer.pop();
        currentContainer.peek().addChild(declaration);
    }


    // Bool Literal
    @Override
    public void enterBoolLiteral(ICSSParser.BoolLiteralContext ctx) {
        Literal literal = new BoolLiteral(ctx.getText());
        currentContainer.peek().addChild(literal);
    }

    // Color Literal
    @Override
    public void enterColorLiteral(ICSSParser.ColorLiteralContext ctx) {
        Literal literal = new ColorLiteral(ctx.getText());
        currentContainer.peek().addChild(literal);
    }

    // Pixel Literal
    @Override
    public void enterPixelLiteral(ICSSParser.PixelLiteralContext ctx) {
        Literal literal = new PixelLiteral(ctx.getText());
        currentContainer.peek().addChild(literal);
    }

    // Percentage Literal
    @Override
    public void enterPercentageLiteral(ICSSParser.PercentageLiteralContext ctx) {
        Literal literal = new PercentageLiteral(ctx.getText());
        currentContainer.peek().addChild(literal);
    }

    // Scalar Literal
    @Override
    public void enterScalarLiteral(ICSSParser.ScalarLiteralContext ctx) {
        Literal literal = new ScalarLiteral(ctx.getText());
        currentContainer.peek().addChild(literal);
    }

    // Property Name
    @Override
    public void enterPropertyName(ICSSParser.PropertyNameContext ctx) {
        PropertyName propertyName = new PropertyName(ctx.getText());
        currentContainer.push(propertyName);
    }

    @Override
    public void exitPropertyName(ICSSParser.PropertyNameContext ctx) {
        PropertyName propertyName = (PropertyName) currentContainer.pop();
        currentContainer.peek().addChild(propertyName);
    }

    // Variable Name
    @Override
    public void enterVariableReference(ICSSParser.VariableReferenceContext ctx) {
        VariableReference variableReference = new VariableReference(ctx.getText());
        currentContainer.push(variableReference);
    }

    @Override
    public void exitVariableReference(ICSSParser.VariableReferenceContext ctx) {
        VariableReference variableReference = (VariableReference) currentContainer.pop();
        currentContainer.peek().addChild(variableReference);
    }

    // Variable Assignment
    @Override
    public void enterVariableAssignment(ICSSParser.VariableAssignmentContext ctx) {
        VariableAssignment variableAssignment = new VariableAssignment();
        currentContainer.push(variableAssignment);
    }

    @Override
    public void exitVariableAssignment(ICSSParser.VariableAssignmentContext ctx) {
        VariableAssignment variableAssignment = (VariableAssignment) currentContainer.pop();
        currentContainer.peek().addChild(variableAssignment);
    }

    // All expressions
    @Override
    public void enterExpression(ICSSParser.ExpressionContext ctx) {
        if (ctx.getChildCount() == 3) {
            Operation operation;
            switch (ctx.getChild(1).getText()) {
                case "+":
                    operation = new AddOperation();
                    break;
                case "-":
                    operation = new SubtractOperation();
                    break;
                default:
                    operation = new MultiplyOperation();
                    break;
            }
        currentContainer.push(operation);
        }
    }

    @Override
    public void exitExpression(ICSSParser.ExpressionContext ctx) {
        if (ctx.PLUS() != null || ctx.MIN() != null || ctx.MUL() != null) {
            ASTNode operation = currentContainer.pop();
            currentContainer.peek().addChild(operation);
        }
    }

    // If Clause
    @Override
    public void enterIfClause(ICSSParser.IfClauseContext ctx) {
        IfClause ifClause = new IfClause();
        currentContainer.push(ifClause);
    }

    @Override
    public void exitIfClause(ICSSParser.IfClauseContext ctx) {
        IfClause ifClause = (IfClause) currentContainer.pop();
        currentContainer.peek().addChild(ifClause);
    }

    // Else Clause
    @Override
    public void enterElseClause(ICSSParser.ElseClauseContext ctx) {
        ElseClause elseClause = new ElseClause();
        currentContainer.push(elseClause);
    }

    @Override
    public void exitElseClause(ICSSParser.ElseClauseContext ctx) {
        ElseClause elseClause = (ElseClause) currentContainer.pop();
        currentContainer.peek().addChild(elseClause);
    }

}