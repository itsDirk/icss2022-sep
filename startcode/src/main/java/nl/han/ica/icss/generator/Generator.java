package nl.han.ica.icss.generator;


import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.selectors.ClassSelector;
import nl.han.ica.icss.ast.selectors.IdSelector;
import nl.han.ica.icss.ast.selectors.TagSelector;

import java.util.ArrayList;

public class Generator {

	public String generate(AST ast) {
        return generateStyleSheet(ast.root);

	}

	private String generateStyleSheet(Stylesheet stylesheet) {
		StringBuilder sb = new StringBuilder();

		for (ASTNode node : stylesheet.getChildren()) {
			if (node instanceof Stylerule) {
				sb.append(generateStyleRule((Stylerule) node));
				// Create 2 new lines for every style rule for readability 8)
				sb.append("\n\n");
			}
		}

		return sb.toString();
	}

	private String generateStyleRule(Stylerule stylerule) {
		StringBuilder sb = new StringBuilder();

		sb.append(generateSelector(stylerule.selectors));

		for (ASTNode node : stylerule.body) {
			if (node instanceof Declaration) {
				// \t is a tab
				sb.append("\t");
				sb.append(generateDeclaration((Declaration) node));
				sb.append("\n");
			}
		}

		return sb.append("}").toString();
	}

	private String generateSelector(ArrayList<Selector> selectors) {
		StringBuilder sb = new StringBuilder();

		for (Selector selector : selectors) {
			if (selector instanceof ClassSelector) {
				sb.append(((ClassSelector) selector).cls);
			} else if (selector instanceof IdSelector) {
				sb.append(((IdSelector) selector).id);
			} else if (selector instanceof TagSelector) {
				sb.append(((TagSelector) selector).tag);
			}
		}

		return sb.append(" {\n").toString();
	}

	private String generateDeclaration(Declaration declaration) {
		return declaration.property.name + ": " + declaration.expression + ";";
	}


}
