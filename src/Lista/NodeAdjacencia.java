package Lista;

public class NodeAdjacencia extends Node{
    int peso;
    public NodeAdjacencia(String valor, Node next, Node last, int peso) {
        super(valor, next, last);
        this.peso = peso;
    }

    @Override
    public int getPeso() {
        return peso;
    }
}
