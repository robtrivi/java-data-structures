package tdas;

import java.util.Comparator;
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
        NodeList<E> node = new NodeList<>(element);
        if (this.isEmpty()){
            this.head = node;
            this.tail = node;
            return true;
        }
        this.tail.setNext(node);
        this.tail = node;
        return true;
    }

    @Override
    public E get(int index) {
        NodeList<E> node = this.getNode(index);
        if (node==null){
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }
        return node.getData();
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        int size = 0;
        for (E data : this) {
            size++;
        }
        return size;
    }

    @Override
    public E set(E element, int index) {
        if (element==null){
            throw new RuntimeException("No se pueden setear elementos nulos");
        }
        NodeList<E> node = this.getNode(index);
        if (node == null){
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }
        E data = node.getData();
        node.setData(element);
        return data;
    }

    private NodeList<E> getNode(int index){
        int cont = 0;
        for (NodeList<E> current = head; current != null; current = current.getNext()) {
            if (cont++ == index){
                return current;
            }
        }
        return null;
    }

    @Override
    public boolean add(E element, int index) {
        NodeList<E> node = new NodeList<>(element);
        if (this.isEmpty()){
            this.head = node;
            this.tail = node;
            return true;
        }
        if (index==0){
            this.addFirst(element);
            return true;
        }
        NodeList<E> previousNode = this.getNode(index-1);
        if (previousNode == null){
            throw new IndexOutOfBoundsException("Indice no valido");
        }
        NodeList<E> currentNode = previousNode.getNext();
        if (currentNode == null){
            this.addLast(element);
            return true;
        }

        previousNode.setNext(node);
        node.setNext(currentNode);

        return true;
    }

    @Override
    public boolean addAll(List<E> otherList) {
        for (E element :
                otherList) {
            this.addLast(element);
        }
        return true;
    }

    @Override
    public E remove(int index) {
//        NodeList<E>
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
        Iterator<E> it = new Iterator<E>() {

            private NodeList<E> current = head;
            @Override
            public boolean hasNext() {
                return current !=null;
            }

            @Override
            public E next() {
                E data = current.getData();
                current = current.getNext();
                return data;
            }
        };


        return it;
    }

    @Override
    public String toString() {

        StringBuilder cadena = new StringBuilder("[ ");
        for (E data :this) {
            String character = ", ";
            if (data == tail.getData()){
                character = "";
            }
            cadena.append(data).append(character);
        }

        return cadena.append(" ]").toString();
    }

    public LinkedList<E> findAll(Comparator<E> cmp, E object){
        LinkedList<E> elements = new LinkedList<>();
        for (E element : this) {
            if (cmp.compare(element,object) == 0){
                elements.addLast(element);
            }
        }
        return elements;
    }

    public LinkedList<E> mayorQue(Comparator<E> comparador, E referencia) {
        LinkedList<E> resultado = new LinkedList<>();
        for (E E : this ) {
            if (comparador.compare(E, referencia) > 0) {
                resultado.addLast(E);
            }
        }
        return resultado;
    }

    public LinkedList<E> menorQue( Comparator<E> comparador, E referencia) {
        LinkedList<E> resultado = new LinkedList<>();
        for (E E : this) {
            if (comparador.compare(E, referencia) < 0) {
                resultado.addLast(E);
            }
        }
        return resultado;
    }

    public LinkedList<E> entre(Comparator<E> cmp, E objetoMenor, E objetoMayor){
        LinkedList<E> resultado = new LinkedList<>();
        for (E e : this) {
            if ((cmp.compare(e, objetoMenor) > 0) && (cmp.compare(e,objetoMayor))<0){
                resultado.addLast(e);
            }
        }
        return resultado;
    }


}
