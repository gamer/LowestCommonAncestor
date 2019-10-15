import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LowestCommonAncestorTest {
    public LowestCommonAncestorTest() {
    }

    @Test
    public void findLCATest() {
        Node<Integer> root = new Node<>(7);
        root.addRight(new Node<>(8));
        root.getRight().addRight(new Node<>(1));
        root.getRight().addLeft(new Node<>(9));
        root.addLeft(new Node<>(5));
        root.getLeft().addLeft(new Node<>(4));
        root.getLeft().getLeft().addLeft(new Node<>(2));
        root.getLeft().addRight(new Node<>(3));
        Assertions.assertEquals(root.getRight().data, LowestCommonAncestor.findLCA(root, root.getRight().getRight(), root.getRight().getLeft()).data,
                "simple 2 level sub tree expecting 8, LCA(root, 1, 9)");
        Assertions.assertEquals(root.data, LowestCommonAncestor.findLCA(root, root.getRight().getRight(), root.getLeft().getLeft().getLeft()).data,
                "furthest extent opposite sides expecting root, LCA(root, 1, 2)");
    }

    @Test
    public void findLCADAGTest() {
        Node<String> G = new Node<>("G");
        Node<String> F = new Node<>("F");
        Node<String> E = new Node<>("E");
        Node<String> D = new Node<>("D");
        Node<String> C = new Node<>("C");
        Node<String> B = new Node<>("B");
        Node<String> A = new Node<>("A");
        G.depth = 0;
        F.depth = D.depth = 1;
        E.depth = C.depth = 2;
        B.depth = 3;
        A.depth = 4;

        G.children.add(F); G.children.add(D);
        F.parents.add(G); D.parents.add(G);
        F.children.add(E);
        E.parents.add(F);
        D.children.add(C);
        C.parents.add(D);
        C.children.add(B);
        E.children.add(B);
        B.parents.add(C); B.parents.add(E);
        B.children.add(A);
        A.parents.add(B);

        Assertions.assertEquals("G", LowestCommonAncestor.findLCADAG(G,F,C).data,"LCADAG(G F C)");
        Assertions.assertEquals("G", LowestCommonAncestor.findLCADAG(G,F,C).data,"LCADAG(G E B)");
        Assertions.assertEquals("G", LowestCommonAncestor.findLCADAG(G,F,C).data,"LCADAG(G F D)");
        Assertions.assertEquals(null, LowestCommonAncestor.findLCADAG(null,null,null), "null input");
    }
}