
public class Node<E> {

    public E value;
    public Node<E> next;
    public Node<E> previous;

    public Node(E value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s ", this.value.toString());
    }
}
