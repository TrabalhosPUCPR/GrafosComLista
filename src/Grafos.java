import Lista.Lista;

import java.util.ArrayList;
import java.util.Arrays;

import Lista.NodeAdjacencia;
import Lista.Node;

public class Grafos {
    Lista nodes;

    public Grafos() {
        this.nodes = new Lista();
    } // so cria a lista que vai armazena os vertices

    public void addNode(Object node) { // adiciona na lista o novo node
        nodes.add(node);
    }

    public Node<?> getNode(int i) {
        return nodes.get(i);
    } // retorna o node que ta no index

    public void setNode(String node, String newNode) { // seta um novo valor pro node
        nodes.set(node, newNode);
    }

    public void createAdjacencia(String node1, String node2, int peso) {
        try{
            if(!nodes.contains(node2)) throw new Exception(); // caso o node2 nao existi no grafo, da erro
            Lista sublist = nodes.get(node1).getSubList(); // pega a lista de adjacencias do node, se o node1 nao existe da erro
            sublist.add(new NodeAdjacencia(node2, null, null, peso)); // adiciona na lista de adjacencias o node a ser conectado
        }catch (Exception e) {
            System.out.println("Node nao encontrado!"); // printa qnd der erro
        }
    }

    public void removeAdjacencia(String node1, String node2) { // mesma logica que o de cima, mas remove o node das adjacencias
        try{
            if(!nodes.contains(node2)) throw new Exception();
            Lista sublist = nodes.get(node1).getSubList();
            sublist.remove(node2);
        }catch (Exception e) {
            System.out.println("Node nao encontrado!");
        }
    }

    public int getAdjacencias(String node, ArrayList<String> adjacentes) { // adiciona a lista de adjacencias no array list e retorna a qntd de adjacencias
        String[] list = nodes.get(node).getSubList().getArray();
        adjacentes.addAll(Arrays.asList(list));
        return list.length;
    }

    public void printAdjacencias(){
        Node node = nodes.getFirstNode();
        System.out.println("Todas as adjacencias: ( [valor, peso] )");
        while(node != null){ // passa por todos os nodes printando o valor dele e suas adjacencias com o peso
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
