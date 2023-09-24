package tdas;

public class NodeList<E>{
    private NodeList<E> next;
    private NodeList<E> previous;
    private E data;

    public NodeList(E data){
        this.data = data;
    }

    public NodeList<E> getNext() {
        return next;
    }

    public void setNext(NodeList<E> next) {
        this.next = next;
    }

    public NodeList<E> getPrevious() {
        return previous;
    }

    public void setPrevious(NodeList<E> previous) {
        this.previous = previous;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
