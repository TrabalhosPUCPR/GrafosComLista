package Lista;

public class Lista {
    // o anterior do primeiro node e o proximo do ultimo sao nulo
    Node<?> firstNode; // vai armazena o primeiro node
    Node<?> lastNode; // vai armazena o ultimo node
    int size;

    public Lista() { // inicia a lista
        this.firstNode = null;
        this.lastNode = null;
        this.size = 0;
    }

    private boolean checkEmpty(){
        return firstNode == null;
    } // retorna verdadeiro caso o primeiro node for nulo (vazio)

    public void add(Node<?> node){
        if(checkEmpty()){
            firstNode = node; // caso a lista estiver vazia, iguala o primeiro node ao node sendo adicionado
        }else{
            lastNode.next = node; // faz o proximo do ulitmo node igual ao node sendo criado
            node.last = lastNode; // faz o anterior do novo node ser igual ao ultimo node
        }
        size++; // incrementa a variavel que guarda o tamanho da lista
        lastNode = node; // se a lista estiver vazia ou nao, o ultimo node da lista se torna o node sendo adicionado
    }

    public void add(Object value){ // mesma coisa que o add de cima, ele so da override pra poder adicionar direto um node so pelo valor
        Node<Object> newNode = new Node<Object>(value, null, lastNode); // ele cria o node aqui dai e ja faz o anterior dele ser o ultimo node
        if(checkEmpty()){
            firstNode = newNode;
        }else{
            lastNode.next = newNode;
        }
        size++;
        lastNode = newNode;
    }

    public Node<?> get(int index){
        if(checkEmpty() || index >= size) return null; // caso estiver vazio ou o index for maior que o tamanho da lista, retorna nulo
        if (index == size - 1) { // se o index for o do ultimo, so retorna o ultimo direto
            return lastNode;
        }
        if(index == 0) { // se o index for o do primeiro, so retorna o primeiro direto
            return firstNode;
        }
        Node<?> p = firstNode;
        for(int i = 0; p != null; i++){ // passa por todos os elementos da lista ate chegar no index desejado pra retorna o node
            if(i == index){
                return p;
            }
            p = p.next;
        }
        return null; // ele nunca vai chega aqui mas caso nao encontra o index retorna nulo
    }

    public Node<?> get(Object node){
        if(checkEmpty()) return null; // caso estiver vazio ou o index for maior que o tamanho da lista, retorna nulo
        if (node.equals(lastNode.value)) { // se o index for o do ultimo, so retorna o ultimo direto
            return lastNode;
        }
        if(node.equals(firstNode.value)) { // se o index for o do primeiro, so retorna o primeiro direto
            return firstNode;
        }
        for(Node<?> p = firstNode; p != null; p=p.next){ // passa por todos os elementos da lista ate chegar no index desejado pra retorna o node
            if(node.equals(p.value)) {
                return p;
            }
        }
        return null; // ele nunca vai chega aqui mas caso nao encontra o index retorna nulo
    }

    public int getIndex(Object node){ // faz a mesma coisa q os ultimos dois, mas retorna o index do node
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

    public void set(int index, Object value){ // pega o node pelo index e seta um novo valor
        Node p = get(index);
        p.setValue(value);
    }
    public void set(Object node, Object value){ // igual ao ultimo mas pega pelo valor
        Node p = get(node);
        p.setValue(value);
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
    public void remove(Object node){
        if(checkEmpty()) return;
        if(size == 1){
            lastNode = null;
            firstNode = null;
            size = 0;
            return;
        }
        if (node.equals(lastNode.value)){
            lastNode = lastNode.last;
            lastNode.next = null;
        }else if(node.equals(firstNode.value)) {
            firstNode = firstNode.next;
            firstNode.last = null;
        }else{
            Node<?> p = firstNode;
            for(int i = 0; p != null; i++){
                if(node.equals(p.value)){
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
