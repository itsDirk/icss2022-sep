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

//	public void enterStylesheet(ICSSParser.StylesheetContext ctx) {
//		Stylesheet stylesheet = new Stylesheet();
////		ast.root.addChild(stylesheet);
//		currentContainer.push(stylesheet);
//	}
//
//	public void exitStylesheet(ICSSParser.StylesheetContext ctx) {
//		Stylesheet stylesheet = (Stylesheet) currentContainer.pop();
////		currentContainer.peek().addChild(stylesheet);
//		currentContainer.pop();
//	}

    // RuleAssignement
    @Override
    public void enterRuleAssignment(ICSSParser.RuleAssignmentContext ctx) {
        Stylerule stylerule = new Stylerule();
        currentContainer.push(stylerule);
    }

    @Override
    public void exitRuleAssignment(ICSSParser.RuleAssignmentContext ctx) {
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
        currentContainer.push(literal);
    }

    @Override
    public void exitBoolLiteral(ICSSParser.BoolLiteralContext ctx) {
        Literal literal = (Literal) currentContainer.pop();
        currentContainer.peek().addChild(literal);
    }

    // Color Literal
    @Override
    public void enterColorLiteral(ICSSParser.ColorLiteralContext ctx) {
        Literal literal = new ColorLiteral(ctx.getText());
        currentContainer.push(literal);
    }

    @Override
    public void exitColorLiteral(ICSSParser.ColorLiteralContext ctx) {
        Literal literal = (Literal) currentContainer.pop();
        currentContainer.peek().addChild(literal);
    }

    // Pixel Literal
    @Override
    public void enterPixelLiteral(ICSSParser.PixelLiteralContext ctx) {
        Literal literal = new PixelLiteral(ctx.getText());
        currentContainer.push(literal);
    }

    @Override
    public void exitPixelLiteral(ICSSParser.PixelLiteralContext ctx) {
        Literal literal = (Literal) currentContainer.pop();
        currentContainer.peek().addChild(literal);
    }

    // Percentage Literal
    @Override
    public void enterPercentageLiteral(ICSSParser.PercentageLiteralContext ctx) {
        Literal literal = new PercentageLiteral(ctx.getText());
        currentContainer.push(literal);
    }

    @Override
    public void exitPercentageLiteral(ICSSParser.PercentageLiteralContext ctx) {
        Literal literal = (Literal) currentContainer.pop();
        currentContainer.peek().addChild(literal);
    }

    // Scalar Literal
    @Override
    public void enterScalarLiteral(ICSSParser.ScalarLiteralContext ctx) {
        Literal literal = new ScalarLiteral(ctx.getText());
        currentContainer.push(literal);
    }

    @Override
    public void exitScalarLiteral(ICSSParser.ScalarLiteralContext ctx) {
        Literal literal = (Literal) currentContainer.pop();
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
    public void enterVariableName(ICSSParser.VariableNameContext ctx) {
        VariableReference variableReference = new VariableReference(ctx.getText());
        currentContainer.push(variableReference);
    }

    @Override
    public void exitVariableName(ICSSParser.VariableNameContext ctx) {
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

    // Add Expression
    @Override
    public void enterAddExpression(ICSSParser.AddExpressionContext ctx) {
        AddOperation addOperation = new AddOperation();
        currentContainer.push(addOperation);
    }

    @Override
    public void exitAddExpression(ICSSParser.AddExpressionContext ctx) {
        AddOperation addOperation = (AddOperation) currentContainer.pop();
        currentContainer.peek().addChild(addOperation);
    }

    // Subtract Expression
    @Override
    public void enterSubtractExpression(ICSSParser.SubtractExpressionContext ctx) {
        SubtractOperation subtractOperation = new SubtractOperation();
        currentContainer.push(subtractOperation);
    }

    @Override
    public void exitSubtractExpression(ICSSParser.SubtractExpressionContext ctx) {
        SubtractOperation subtractOperation = (SubtractOperation) currentContainer.pop();
        currentContainer.peek().addChild(subtractOperation);
    }

    // Multiply Expression
    @Override
    public void enterMultiplyExpression(ICSSParser.MultiplyExpressionContext ctx) {
        MultiplyOperation multiplyOperation = new MultiplyOperation();
        currentContainer.push(multiplyOperation);
    }

    @Override
    public void exitMultiplyExpression(ICSSParser.MultiplyExpressionContext ctx) {
        MultiplyOperation multiplyOperation = (MultiplyOperation) currentContainer.pop();
        currentContainer.peek().addChild(multiplyOperation);
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