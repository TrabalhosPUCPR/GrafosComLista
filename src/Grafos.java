import Lista.Lista;

import java.util.ArrayList;
import java.util.Arrays;

import Lista.NodeAdjacencia;
import Lista.Node;

public class Grafos {
    Lista nodes;
    int cellWidth = 2;

    public Grafos() {
        this.nodes = new Lista();
    }

    public void addNode(String node) {
        nodes.add(node);
        if (node.length() > cellWidth) cellWidth = node.length();
    }

    public Node<?> getNode(int i) {
        return nodes.get(i);
    }

    public void setNode(String node, String newNode) {
        nodes.set(node, newNode);
        if (newNode.length() > cellWidth) cellWidth = newNode.length();
    }

    public void createAdjacencia(String node1, String node2, int peso) {
        try{
            if(!nodes.contains(node2)) throw new Exception();
            Lista sublist = nodes.get(node1).getSubList();
            sublist.add(new NodeAdjacencia(node2, null, null, peso));
        }catch (Exception e) {
            System.out.println("Node nao encontrado!");
        }
    }

    public void removeAdjacencia(String node1, String node2) {
        try{
            if(!nodes.contains(node2)) throw new Exception();
            Lista sublist = nodes.get(node1).getSubList();
            sublist.remove(node2);
        }catch (Exception e) {
            System.out.println("Node nao encontrado!");
        }
    }

    public int getAdjacencias(String node, ArrayList<String> adjacentes) {
        String[] list = nodes.get(node).getSubList().getArray();
        adjacentes.addAll(Arrays.asList(list));
        return list.length;
    }

    public void printAdjacencias(){
        Node node = nodes.getFirstNode();
        System.out.println("Todas as adjacencias: ( [valor, peso] )");
        while(node != null){
            System.out.print(node.getValue() + ": ");
            Node subNode = node.getSubList().getFirstNode();
            while(subNode != null){
                System.out.print("[" + subNode.getValue() + ", " + subNode.getPeso() + "] ");
                subNode = subNode.getNext();
            }
            System.out.println();
            node = node.getNext();
        }
    }
}
