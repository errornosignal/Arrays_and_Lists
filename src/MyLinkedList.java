public class MyLinkedList <E> implements MyList<E> {

    private int size;
    private Node<E> first;
    private Node<E> last;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean add(E element) {

        Node<E> newNode = new Node<>(element);
        if(this.isEmpty()) {

            this.first = newNode;
        }
        else {
            this.last.next = newNode;
        }

        this.last = newNode;
        this.size++;
        return true;
    }

    private void ensureRange (int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("Invalid index");
        }
        else{/*doNothing*/} //else, the index is valid
    }

    private Node<E> getNode(int index) {
        this.ensureRange(index);
        Node<E> current = this.first;
        for (int counter = 0; counter < index; counter++)
        {
            current = current.next;
        }
        return current;
    }

    @Override
    public E get(int index) {
        return getNode(index).value;
    }

    @Override
    public E remove(int index) {
        Node<E> current = this.getNode(index);

        if (this.size == 1) {

        }//more than one element in the list doNothing()

        if (current == this.first) {
            //remove the first element
        }
        else if (current == this.last) {
            //remove the last element
        }
        else {
            //remove the nth element of the list
        }

    }

    @Override
    public boolean set(int index, Comparable element) {
        return false;
    }

    @Override
    public boolean insert(int index, Comparable element) {
        return false;
    }

    @Override
    public int indexOf(Comparable element) {
        return 0;
    }
}
