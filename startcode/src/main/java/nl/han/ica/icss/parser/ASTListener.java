package nl.han.ica.icss.parser;

import nl.han.ica.datastructures.HANStack;
import nl.han.ica.datastructures.IHANStack;
import nl.han.ica.icss.ast.*;
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