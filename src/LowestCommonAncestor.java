public class LowestCommonAncestor {
    public static void main(String[] args) {
    }
    public Node findLCA(Node root, Node n1, Node n2) {
        if (root == null)
            return null;

        if (root.data == n1.data || root.data == n2.data) {
            return root;
        }

        if (root.left == null && root.right == null) {
            return null;
        }

        Node left = findLCA(root.left, n1, n2);
        Node right = findLCA(root.right, n1, n2);

        if (left != null && right != null) {
            return root;
        }

        if (left == null)
            return right;
        else
            return left;
    }
}
