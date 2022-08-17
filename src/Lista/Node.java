package Lista;

public class Node<T> {
    T value;
    Node<?> next;
    Node<?> last;
    Lista subList;

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
    public int getPeso() {
        return 0;
    }
    public Node<?> getNext() {
        return next;
    }
}
