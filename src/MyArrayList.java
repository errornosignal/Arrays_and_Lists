import java.util.Arrays;

public class MyArrayList<E> implements MyList<E> {

    private E[] elements;
    private int size = 0;
    
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    
    private void ensureCapacity(int minCapacity) {
        int oldCapacity = this.elements.length;
        
        if (oldCapacity <= minCapacity) {
            E oldElements[] = this.elements;
            int newCapacity = (oldCapacity * 3) / 2 + 1;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            else {/*doNothing*/} // else, we are fine with the new capacity

            this.elements = Arrays.copyOf(oldElements, newCapacity);
        }
        else {/*doNothing*/} //else the capacity is currently fine
    }

    private void ensureRange (int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("Invalid index");
        }
        else{/*doNothing*/} //else, the index is valid
    }

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        //The elements array will contain only E instances from 
        //add, insert, set. This is sufficient to ensure type
        //safety, but the runtime type of the array will not be E[],
        //it will always be an Object[]
        this.elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }
    
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
        this.ensureCapacity(this.size +1);
        this.elements[this.size] = element;
        this.size++;
        return true;
    }

    @Override
    public E get(int index) {
        this.ensureRange(index);
        return this.elements[index];
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public boolean set(int index, E element) {
        return false;
    }

    @Override
    public boolean insert(int index, E element) {
        return false;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }
}
