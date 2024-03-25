package nl.han.ica.icss.parser;

import nl.han.ica.datastructures.HANStack;
import nl.han.ica.datastructures.IHANStack;
import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.BoolLiteral;
import nl.han.ica.icss.ast.literals.ColorLiteral;
import nl.han.ica.icss.ast.literals.PixelLiteral;
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
    public void enterRuleAssignement(ICSSParser.RuleAssignementContext ctx) {
        Stylerule stylerule = new Stylerule();
        currentContainer.push(stylerule);
    }

    @Override
    public void exitRuleAssignement(ICSSParser.RuleAssignementContext ctx) {
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
        Literal literal = new PixelLiteral(ctx.getText());
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
        Literal literal = new PixelLiteral(ctx.getText());
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
        Declaration declaration = new Declaration(ctx.getText());
        currentContainer.push(declaration);
    }

    @Override
    public void exitPropertyName(ICSSParser.PropertyNameContext ctx) {
        Declaration declaration = (Declaration) currentContainer.pop();
        currentContainer.peek().addChild(declaration);
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
//    //RuleBody
//    @Override
//    public void enterRuleBody(ICSSParser.RuleBodyContext ctx) {
//        Stylerule stylerule = new Stylerule();
//        currentContainer.push(stylerule);
//    }
//
//    @Override
//    public void exitRuleBody(ICSSParser.RuleBodyContext ctx) {
//        RuleBody ruleBody = (RuleBody) currentContainer.pop();
//        currentContainer.peek().addChild(ruleBody);
//    }

//    public void checkStyleRule(Stylerule rule) {
//        for (ASTNode child : rule.getChildren()){
//            if (child instanceof Declaration){
//
//            }
//        }
//    }
//
//    private void checkDeclaration(Declaration declaration) {
//        if (declaration.property.equals("width")){
//            if(!(declaration.expression.equals(PixelLiteral))){
//                declaration.setError("Width must be a pixel literal");
//            }
//        }
//    }
}