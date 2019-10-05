import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LowestCommonAncestorTest {
    public LowestCommonAncestorTest() {
    }

    @Test
    public void findLCATest() {
        Node<Integer> root = new Node<>(7);
        root.right = new Node<>(8);
        root.right.right = new Node<>(1);
        root.right.left = new Node<>(9);
        root.left = new Node<>(5);
        root.left.left = new Node<>(4);
        root.left.left.left = new Node<>(2);
        root.left.right = new Node<>(3);
        Assertions.assertEquals(root.right.data, LowestCommonAncestor.findLCA(root, root.right.right, root.right.left).data,
                "simple 2 level sub tree expecting 8, LCA(root, 1, 9)");
        Assertions.assertEquals(root.data, LowestCommonAncestor.findLCA(root, root.right.right, root.left.left.left).data,
                "furthest extent opposite sides expecting root, LCA(root, 1, 2)");
    }
}