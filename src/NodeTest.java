import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    public void initNode() {
        Node<String> tester = new Node<>("This is a test.");
        assertEquals("This is a test.", tester.data, "Assert that the data of the node is the same" +
                " as the data given (String: \"This is a test.\")");
    }

    @Test
    public void initTree() {
        Node<String> root = new Node<>("This is the root node.");
        root.addLeft(new Node<>("This is the left node."));
        root.addRight(new Node<>("This is the right node."));
        root.getRight().addRight(new Node<>("This is the 2nd level right node."));

        assertEquals("This is the root node.", root.data, "Assert that the tree's " +
                "root node data is as initialised");
        assertEquals("This is the left node.", root.getLeft().data, "Assert that the tree's " +
                "left node data is as initialised");
        assertEquals("This is the right node.", root.getRight().data, "Assert that the tree's " +
                "right node data is as initialised");
        assertEquals("This is the 2nd level right node.", root.getRight().getRight().data, "Assert that the tree's " +
                "2nd level right node data is as initialised");
    }
}