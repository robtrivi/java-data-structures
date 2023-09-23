package tdas;

public interface List<E> extends Iterable<E> {
    public boolean addFirst(E element);
    public boolean addLast(E element);
    public E get(int index);
    public boolean isEmpty();
    public int size();
    public E set(E element, int index);
    public boolean add(E element, int index);
    public boolean addAll(List<E> otherList);
    public E remove(int index);
    public boolean delete(E element);
    public boolean contains(E element);
    public int indexOf(E element);
}
