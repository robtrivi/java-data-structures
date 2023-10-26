package tdas;

import java.util.Iterator;

public class ArrayList<E> implements List<E>{

    private E[] elements; // Se guardan los elementos
    private int efectivesize; //La cantidad de elementos actual
    private int capacity = 3; //Capacidad

    public ArrayList(){
        elements = (E[]) new Object[capacity];
    }

    @Override
    public boolean addFirst(E element) {
        return add(element, 0);
    }

    @Override
    public boolean addLast(E element) {
        return add(element, efectivesize);
    }

    @Override
    public E get(int index) {
        if (!(isValidIndex(index))){
            throw new IndexOutOfBoundsException("Indice no válido");
        }
        return elements[index];
    }
    @Override
    public E set(E element, int index){
        if (!(isValidIndex(index))){
            throw new IndexOutOfBoundsException("Indice no válido");
        }
        if (element == null){
            throw new RuntimeException("No puede setear elementos nulos");
        }
        E temp = this.get(index);
        elements[index] = element;
        return temp;
    }

    @Override
    public boolean add(E element, int index) {
        if (this.isFull()){
            addCapacity();
        }
        E tempElement = element;
        for (int i = index; i < efectivesize; i++) {
            tempElement = set(tempElement, i);
        }
        elements[efectivesize++] = tempElement;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return efectivesize == 0;
    }

    @Override
    public int size() {
        return efectivesize;
    }

    private boolean isValidIndex(int index){
        if (this.isEmpty() && index==0){
            return true;
        }
        return (index >= 0) && (index < this.size());
    }

    private boolean isFull(){
        return efectivesize == capacity;
    }

    private void addCapacity(){
        capacity *= 2;
        E[] newElements = (E[]) new Object[capacity];
        for (int i = 0; i < efectivesize; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder("[ ");
        for (int i = 0; i < efectivesize; i++) {
            String character = ", ";
            if (i == 0) {
                character = "";
            }
            cadena.append(character).append(this.get(i));
        }
        return cadena + " ]";
    }
    @Override
    public boolean addAll(List<E> otherList){
        for (E element :otherList) {
            this.addLast(element);
        }
        return true;
    }

    public ArrayList<E> concact(List<E> otherList){
        ArrayList<E> newArrayList = new ArrayList<>();
        newArrayList.addAll(this);
        newArrayList.addAll(otherList);
        return newArrayList;
    }
    @Override
    public boolean contains(E element){
        return -1!=this.indexOf(element);
    }
    @Override
    public E remove(int index){
        if (!isValidIndex(index)){
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }
        E tempElement = elements[efectivesize-1];
        for (int i = efectivesize - 1; i > index ; i--) {
            tempElement = set(tempElement, i-1);
        }
        elements[--efectivesize] = null;
        return tempElement;
    }
    @Override
    public boolean delete(E element){
        int index = this.indexOf(element);
        if (!(this.isValidIndex(index))){
            throw new RuntimeException("No se ha encontrado el elemento");
        }
        return remove(index) != null;
    }
    @Override
    public int indexOf(E element){
        for (int i = 0; i < efectivesize; i++) {
            if (elements[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    public boolean containsAllElements(List<E> otherList){

        if (otherList==null){
            return false;
        }

        for (E element: otherList) {
            if (this.contains(element)){
                return false;
            }
        }

        return true;
    }

    public boolean isSubList(List<E> subList){

        int indexvalids = 0;
        for (E element : this) {
            if (element.equals(subList.get(indexvalids))){
                indexvalids++;
            }else{
                indexvalids = 0;
            }
            if (indexvalids == subList.size()){
                return true;
            }
        }

        return false;
    }

    public ArrayList<E> sliceWithLeap(int firstIndex, int lastIndex, int leap){
        if (!isValidIndex(firstIndex) || isValidIndex(lastIndex-1)){
            throw new IndexOutOfBoundsException("No es un indice valido");
        }
        if (lastIndex < firstIndex){
            throw new RuntimeException("El indice final debe ser mayor");
        }
        ArrayList<E> newArray = new ArrayList<>();
        for (int i = firstIndex; i < lastIndex; i+=leap) {
            newArray.addLast(this.get(i));
        }
        return newArray;
    }

    public ArrayList<E> slice(int firstIndex, int lastIndex){
        return this.sliceWithLeap(firstIndex,lastIndex,1);
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {
            private int index;

            @Override
            public boolean hasNext() {
                return index < efectivesize;
            }
            @Override
            public E next() {
                return elements[index++];
            }
        };
        return it;
    }
}
