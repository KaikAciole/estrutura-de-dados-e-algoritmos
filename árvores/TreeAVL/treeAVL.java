public class treeAVL {
    
    Node root;
    
    private int calcAltura(Node node){
        if (node == null) {
            return 0;
        } 
        return node.getAltura();
    }

    private int fatorBalanceamento(Node node){
        if (node == null) {
            return 0;
        }
        return calcAltura(node.getLeft()) - calcAltura(node.getRight());
    }

    private Node rotacaoDireita(Node node){
        Node x = node.getLeft();
        Node T2 = node.getRight();

        x.setRight(node);
        node.setLeft(T2);

        node.setAltura(Math.max(calcAltura(node.getLeft()),calcAltura(node.getRight())));
        x.setAltura(Math.max(calcAltura(x.getLeft()),calcAltura(x.getRight())));

        return x;
    }

    private Node rotacaoEsquerda(Node x) {
        Node y = x.getRight();
        Node T2 = y.getLeft();

        y.setLeft(x);
        x.setRight(T2);

        x.setAltura(Math.max(calcAltura(x.getLeft()), calcAltura(x.getRight())) + 1);
        y.setAltura(Math.max(calcAltura(y.getLeft()), calcAltura(y.getRight())) + 1);

        return y;
    }

    private Node inserir(Node node, int valor) {
        if (node == null) {
            return new Node(valor);
        }

        if (valor < node.getData()) {
            node.setLeft(inserir(node.getLeft(), valor));
        } else if (valor > node.getData()) {
            node.setRight(inserir(node.getRight(), valor));
        } else {
            return node; // Valores duplicados não são permitidos
        }

        node.setAltura(1 + Math.max(calcAltura(node.getLeft()), calcAltura(node.getRight())));

        int balanceamento = fatorBalanceamento(node);

        // Rotação LL
        if (balanceamento > 1 && valor < node.getLeft().getData()) {
            return rotacaoDireita(node);
        }

        // Rotação RR
        if (balanceamento < -1 && valor > node.getRight().getData()) {
            return rotacaoEsquerda(node);
        }

        // Rotação LR
        if (balanceamento > 1 && valor > node.getLeft().getData()) {
            node.setLeft(rotacaoEsquerda(node.getLeft()));
            return rotacaoDireita(node);
        }

        // Rotação RL
        if (balanceamento < -1 && valor < node.getRight().getData()) {
            node.setRight(rotacaoDireita(node.getRight()));
            return rotacaoEsquerda(node);
        }

        return node;
    }

    public void inserir(int valor){
        root = inserir(root, valor);
    }
    
    public void printOrdered(){
        printOrderedRec(root);
    }

    private void printOrderedRec(Node root){
        if (root != null) {
            printOrderedRec(root.getLeft());
            System.out.println(root.getData() + " ");
            printOrderedRec(root.getRight());
        }
    }

    public Node nodoComMenorValor(Node nodo) {
        Node atual = nodo;

        while (atual.getLeft() != null)
            atual = atual.getLeft();

        return atual;
    }

    public void remover(int data){
        remover(root, data);
    }

    private Node remover(Node raiz, int data) {
        if (raiz == null)
            return raiz;

        if (data < raiz.getData())
            raiz.setLeft(remover(raiz.getLeft(), data));
        else if (data > raiz.getData())
            raiz.setRight(remover(raiz.getRight(), data));
        else {
            if ((raiz.getLeft() == null) || (raiz.getRight() == null)) {
                Node temp = null;
                if (temp == raiz.getLeft())
                    temp = raiz.getRight();
                else
                    temp = raiz.getLeft();

                if (temp == null) {
                    temp = raiz;
                    raiz = null;
                } else
                    raiz = temp;
            } else {
                Node temp = nodoComMenorValor(raiz.getRight());

                raiz.setData(temp.getData());

                raiz.setRight(remover(raiz.getRight(), temp.getData()));
            }
        }

        if (raiz == null)
            return raiz;

        raiz.setAltura(Math.max(calcAltura(raiz.getLeft()), calcAltura(raiz.getRight())) + 1);

        int balance = fatorBalanceamento(raiz);

        if (balance > 1 && fatorBalanceamento(raiz.getLeft()) >= 0)
            return rotacaoDireita(raiz);

        if (balance > 1 && fatorBalanceamento(raiz.getLeft()) < 0) {
            raiz.setLeft(rotacaoEsquerda(raiz.getLeft()));
            return rotacaoDireita(raiz);
        }

        if (balance < -1 && fatorBalanceamento(raiz.getRight()) <= 0)
            return rotacaoEsquerda(raiz);

        if (balance < -1 && fatorBalanceamento(raiz.getRight()) > 0) {
            raiz.setRight(rotacaoDireita(raiz.getRight()));
            return rotacaoEsquerda(raiz);
        }

        return raiz;
    }

    public static void main(String[] args) {
        treeAVL arvore = new treeAVL();
        arvore.inserir(11);        
        arvore.inserir(12);        
        arvore.inserir(13);        
        arvore.inserir(10);        
        arvore.inserir(9);        
        arvore.remover( 9);
        arvore.printOrdered();
    }

}