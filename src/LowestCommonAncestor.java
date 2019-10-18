import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {
    public static void main(String[] args) {
    }
    public static Node findLCA(Node root, Node n1, Node n2) {
        if (root == null)
            return null;

        if (root.data == n1.data || root.data == n2.data) {
            return root;
        }

        if (root.getLeft() == null && root.getRight() == null) {
            return null;
        }

        Node left = findLCA(root.getLeft(), n1, n2);
        Node right = findLCA(root.getRight(), n1, n2);

        if (left != null && right != null) {
            return root;
        }

        if (left == null)
            return right;
        else
            return left;
    }

    public static Node findLCADAG(Node root, Node n1, Node n2) {
        if (root == null)
            return null;

        if (root.data == n1.data || root.data == n2.data) {
            return root;
        }

        if (root.getLeft() == null && root.getRight() == null) {
            return null;
        }

        List<Object> ancestors = new ArrayList<>();


        for (int i = 0; i < n1.parents.size(); i++) {
            for (int j = 0; j < n2.parents.size(); j++) {
                if (n1.parents.get(i) == n2.parents.get(j))
                    ancestors.add(n1.parents.get(i));
            }
        }

        if (ancestors.size() == 0) {
            if (n1.depth < n2.depth) {
                for (int i = 0; i < n1.parents.size(); i++) {
                    ancestors.add(findLCADAG(root, (Node) n1.parents.get(i), n2));
                }
            } else {
                for (int i = 0; i < n2.parents.size(); i++) {
                    ancestors.add(findLCADAG(root, (Node) n2.parents.get(i), n2));
                }
            }
        }
        return (Node) ancestors.get(0);
    }
}
