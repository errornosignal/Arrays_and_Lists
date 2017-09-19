
public interface MyList<E extends Comparable<? super E>>{
    int size();
    boolean isEmpty();
    boolean add(E element);
    E get (int index);
    E remove (int index);
    boolean set (int index, E element); //update
    boolean insert(int index, E element); //add with style
    int indexOf(E element);

}
