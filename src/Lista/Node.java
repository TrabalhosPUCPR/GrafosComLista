package Lista;

public class Node {
    String value;
    Node next;
    Node last;
    Lista subList;

    public Lista getSubList() {
        return subList;
    }

    public String getValue() {
        return value;
    }
    public Node(String valor, Node next, Node last) {
        this.value = valor;
        this.next = next;
        this.last = last;
        this.subList = new Lista();
    }
    public int getPeso() {
        return 0;
    }
    public Node getNext() {
        return next;
    }
}
