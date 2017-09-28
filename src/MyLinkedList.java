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
            E data = this.first.value;
            this.first = null;
            this.last = null;
            this.size--;
            return data;
        }//more than one element in the list doNothing()

        E data = current.value;
        if (current == this.first) {
            Node<E> next = this.first.next;
            Node<E> oldFirst = this.first;
            this.first = next;
            this.first.previous = null;
            oldFirst.next = null;
            //remove the first element
        }

        else if (current == this.last) {
            Node<E> previous = this.last.previous;
            Node<E> oldLast = this.last;
            this.last = previous;
            this.last.next = null;
            oldLast.previous = null;
            //remove the last element
        }

        else {
            current.next.previous = current.previous;
            current.previous.next = current.next;
            current.next = null;
            current.previous = null;
            //remove the nth element of the list
        }
        this.size--;
        return data;
    }

    @Override
    public boolean set(int index, E element) {
        this.getNode(index).value = element;
        return false;
    }

    @Override
    public boolean insert(int index, E element) {
        Node<E> newNode = new Node<>(element);
        Node<E> current = this.getNode(index);

        if (current == this.first || this.size == 1){
            //we know if the size is 1, first and last are the same
            this.first.previous = newNode;
            newNode.next = this.first;
            newNode.previous = null;
            this.first = newNode;
        }
        else{
            newNode.next = current;
            newNode.previous = current.previous;
            current.previous = newNode;
            newNode.previous.next = newNode;
        }
        this.size++;
        return true;
    }

    @Override
    public int indexOf(E element) {
        Node<E> current = this.first;
        int index = 0;
        while(!current.value.equals(element) && index < this.size) {
            if(current.value.equals(element)){
                return index;
            }//lse, not the value for which we are looking doNothing();
            index++;
            current = current.next;
        }
        return -1;

    }
    @Override
    public void clear() {
        Node<E> element = this.first.next;
        while (element != null) {
            Node<E> next = element.next;
            element.next = element.previous = null;
            element.value = null;
            element = next;
        }
        this.first.value = null;
        this.first.next = this.first.previous = this.first;
        this.size = 0;
    }


}
