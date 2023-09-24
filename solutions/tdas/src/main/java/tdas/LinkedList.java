package tdas;

import java.util.Iterator;

public class LinkedList<E> implements List<E>{
    private NodeList<E> head;
    private NodeList<E> tail;
    @Override
    public boolean addFirst(E element) {
        NodeList<E> node = new NodeList<>(element);
        if (this.isEmpty()){
            this.tail = node;
        }
        node.setNext(head);
        this.head = node;
        return true;
    }

    @Override
    public boolean addLast(E element) {
        return false;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public E set(E element, int index) {
        return null;
    }

    @Override
    public boolean add(E element, int index) {
        return false;
    }

    @Override
    public boolean addAll(List<E> otherList) {
        return false;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public boolean delete(E element) {
        return false;
    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public String toString() {

        String cadena = "";
        for (NodeList<E> nodeTemp = head; nodeTemp != null ; nodeTemp = nodeTemp.getNext()) {
            cadena += nodeTemp.getData() + ", ";
        }

        return cadena;
    }
}
