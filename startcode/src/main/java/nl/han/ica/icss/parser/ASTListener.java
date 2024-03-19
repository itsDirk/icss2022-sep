package nl.han.ica.icss.parser;

import java.util.Stack;


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
import org.antlr.v4.runtime.tree.ParseTree;

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
		// ERGENS een ctx.getText() ofzo
		currentContainer.push(stylerule);
	 }
	 @Override
	 public void exitRuleAssignement(ICSSParser.RuleAssignementContext ctx) {
		Stylerule stylerule = (Stylerule) currentContainer.pop();
		currentContainer.peek().addChild(stylerule);
	 }

	// Selector
	@Override
	public void enterSelector(ICSSParser.SelectorContext ctx) {
		//if ctx . is class dinv
		//then n

//		ParseTree selector = ctx.getChild(0);

		if (ctx.getChild(0) instanceof TagSelector) {
			TagSelector tagSelector = new TagSelector(ctx.getChild(0).getText());
			currentContainer.push(tagSelector);
		}
		else if (ctx.getChild(0) instanceof IdSelector) {
			IdSelector idSelector = new IdSelector(ctx.getChild(0).getText());
			currentContainer.push(idSelector);
		}
		else if (ctx.getChild(0) instanceof ClassSelector) {
			ClassSelector classSelector = new ClassSelector(ctx.getChild(0).getText());
			currentContainer.push(classSelector);
		}
	}
	@Override
	public void exitSelector(ICSSParser.SelectorContext ctx) {
		Selector selector = (Selector) currentContainer.pop();
		currentContainer.peek().addChild(selector);
	}
}