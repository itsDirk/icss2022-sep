package nl.han.ica.icss.generator;


import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.ColorLiteral;
import nl.han.ica.icss.ast.literals.PercentageLiteral;
import nl.han.ica.icss.ast.literals.PixelLiteral;
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
                // Create 2 new lines for every style rule for readability
                sb.append("\n\n");
            } else if (node instanceof Comment) {
                sb.append("/* ");
                sb.append(((Comment) node).content);
                sb.append(" */");
                sb.append("\n");
            }
        }

        return sb.toString();
    }

    private String generateStyleRule(Stylerule stylerule) {
        StringBuilder sb = new StringBuilder();

        sb.append(generateSelector(stylerule.selectors));
        sb.append(generateRuleBody(stylerule.body));

        return sb.append("}").toString();
    }

    private String generateRuleBody(ArrayList<ASTNode> body) {
        StringBuilder sb = new StringBuilder();

        for (ASTNode node : body) {
            if (node instanceof Declaration) {
                // \t is a tab
                sb.append("\t");
                sb.append(generateDeclaration((Declaration) node));
                sb.append("\n");
            } else if (node instanceof IfClause) {
                sb.append(generateIfClause((IfClause) node));
            } else if (node instanceof Comment) {
                sb.append("\t");
                sb.append("/* ");
                sb.append(((Comment) node).content);
                sb.append(" */");
                sb.append("\n");
            }
        }

        return sb.toString();
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
        StringBuilder sb = new StringBuilder();
        sb.append(declaration.property.name).append(": ");

        if (declaration.expression instanceof ColorLiteral) {
            sb.append(((ColorLiteral) declaration.expression).value);
        } else if (declaration.expression instanceof PixelLiteral) {
            sb.append(((PixelLiteral) declaration.expression).value).append("px");
        } else if (declaration.expression instanceof PercentageLiteral) {
            sb.append(((PercentageLiteral) declaration.expression).value).append("%");
        }

        sb.append(";");
        return sb.toString();
    }

    private String generateIfClause(IfClause ifClause) {
        StringBuilder sb = new StringBuilder();

        if (ifClause.body != null) {
            sb.append(generateRuleBody(ifClause.body));
        } else if (ifClause.elseClause != null) {
            sb.append(generateElseClause(ifClause.elseClause));
        }

        return sb.toString();
    }

    private String generateElseClause(ElseClause elseClause) {
        return generateRuleBody(elseClause.body);
    }
}
