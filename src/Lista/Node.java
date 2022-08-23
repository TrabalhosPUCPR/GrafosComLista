package Lista;

public class Node<T> {
    T value;
    Node<?> next;
    Node<?> last;
    Lista subList;

    int peso;

    public Lista getSubList() {
        return subList;
    }

    public T getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = (T) value;
    }

    public Node(T valor, Node<?> next, Node<?> last) {
        this.value = valor;
        this.next = next;
        this.last = last;
        this.subList = new Lista();
    }
    public Node(T valor, Node<?> next, Node<?> last, int peso) {
        this.value = valor;
        this.next = next;
        this.last = last;
        this.subList = new Lista();
        this.peso = peso;
    }
    public int getPeso() {
        return this.peso;
    }
    public Node<?> getNext() {
        return next;
    }
}
