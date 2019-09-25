public class Node<T> {
    T data;
    Node<T> left, right, previous;

    public Node(T nodeData) {
        data = nodeData;
        left = null;
        right = null;
        previous = null;
    }
}
