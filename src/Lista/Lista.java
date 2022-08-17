package Lista;

import java.util.Objects;

public class Lista {
    Node<?> firstNode;
    Node<?> lastNode;
    int size;

    public Lista() {
        this.firstNode = null;
        this.lastNode = null;
        this.size = 0;
    }

    private boolean checkEmpty(){
        return firstNode == null;
    }

    public void add(Node<?> node){
        if(checkEmpty()){
            firstNode = node;
        }else{
            lastNode.next = node;
            node.last = lastNode;
        }
        size++;
        lastNode = node;
    }

    public void add(Object value){
        Node<Object> newNode = new Node<Object>(value, null, lastNode);
        if(checkEmpty()){
            firstNode = newNode;
        }else{
            lastNode.next = newNode;
        }
        size++;
        lastNode = newNode;
    }

    public Node<?> get(int index){
        if(checkEmpty() || index >= size) return null;
        if (index == size - 1) {
            return lastNode;
        }
        if(index == 0) {
            return firstNode;
        }
        Node<?> p = firstNode;
        for(int i = 0; p != null; i++){
            if(i == index){
                return p;
            }
            p = p.next;
        }
        return null;
    }

    public int getIndex(String node){
        if(checkEmpty()) return -1;
        if (node.equals(firstNode.value)) {
            return 0;
        }
        if(node.equals(lastNode.value)) {
            return size - 1;
        }
        Node<?> p = firstNode;
        for(int i = 0; p != null; i++){
            if(node.equals(p.value)){
                return i;
            }
            p = p.next;
        }
        return -1;
    }

    public void set(int index, Object value){
        if(checkEmpty() || index >= size) return;
        if (index == size - 1) {
            lastNode.setValue(value);
            return;
        }
        if(index == 1) {
            firstNode.setValue(value);
            return;
        }
        Node<?> p = firstNode;
        for(int i = 0; p != null; i++){
            if(i == index){
                p.setValue(value);
                return;
            }
            p = p.next;
        }
    }

    public void remove(int index){
        if(checkEmpty() || index >= size) return;
        if(size == 1){
            lastNode = null;
            firstNode = null;
            size = 0;
            return;
        }
        if (index == size - 1){
            lastNode = lastNode.last;
            lastNode.next = null;
        }else if(index == 0) {
            firstNode = firstNode.next;
            firstNode.last = null;
        }else{
            Node<?> p = firstNode;
            for(int i = 0; p != null; i++){
                if(i == index){
                    Node<?> temp = p.next;
                    p = temp;
                    temp.last = p;
                    temp.last.next = p;
                    break;
                }
                p = p.next;
            }
        }
        size--;
    }

    public Node<?> getFirstNode() {
        return firstNode;
    }

    public Node<?> getLastNode() {
        return lastNode;
    }

    public int getSize() {
        return size;
    }

    public boolean contains(Object node){
        Node<?> p = firstNode;
        while(p != null){
            if(p.value.equals(node)) return true;
            p = p.next;
        }
        return false;
    }

    public String[] getArray(){
        String[] array = new String[size];
        Node<?> p = firstNode;
        for(int i = 0; p != null; i++){
            array[i] = (String) p.value;
            p = p.next;
        }
        return array;
    }

    @Override
    public String toString() {
        String lista = "[";
        Node<?> p = firstNode;
        for(int i = 0; p != null; i++){
            lista += p.value;
            if(p.next != null) lista += ", ";
            p = p.next;
        }
        return lista + "]";
    }
}
