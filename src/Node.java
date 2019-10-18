import java.util.ArrayList;
import java.util.List;

public class Node<T> {
    T data;
    int depth;
    List<Node<T>> children = new ArrayList<>();
    List<Node<T>> parents = new ArrayList<>();

    public Node(T nodeData) {
        data = nodeData;
    }

    public Node<T> getLeft() {
        if (children.size() > 0)
            return children.get(0);
        else
            return null;
    }

    public Node<T> getRight() {
        if (children.size() > 1)
            return children.get(1);
        else
            return null;
    }

    public void addLeft(Node<T> node) {
        if (children.size() == 0)
            children.add(0, node);
        else
            children.set(0, node);
    }

    public void addRight(Node<T> node) {
        if (children.size() < 1)
            children.add(null);
        children.add(1, node);
    }
}
