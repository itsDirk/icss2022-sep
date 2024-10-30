package nl.han.ica.icss.ast;

public class Comment extends ASTNode {
    public String content;

    public Comment() {
    }

    @Override
    public String getNodeLabel() {
        return "Comment";
    }

    @Override
    public String toString() {
        return "Comment: " + content;
    }
}
