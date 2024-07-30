package Linked_List_HortFrut;

public class ListaEncadeada {
    Node head;
    Node foot;
	
    public void addOrdered(Produto produto) {
        Node novo = new Node(produto);    
                  
        if (head == null) {            
            head = novo;          
        } else{
            Node corrente = head;
            while (corrente != null && corrente.produto.nomeProduto.compareToIgnoreCase(produto.nomeProduto) < 0) {
                corrente = corrente.next;
            }

            if (corrente == null) { 
                Node last = head;
                while (last.next != null) {
                    last = last.next;
                }
                last.next = novo;
                novo.prev = last;
            } else if (corrente == head) { 
                novo.next = head;
                head.prev = novo;
                head = novo;
            } else {
                Node prevNode = corrente.prev;
                novo.next = corrente;
                novo.prev = prevNode;
                prevNode.next = novo;
                corrente.prev = novo;
            }

        }
    }

    public void remover(String nome, int quantidade) {
        if (head == null) {
            System.out.println("A lista está vazia : (\n\n");
            return;
        }else{
            Node corrente = head;
            int i = 0;
            while (corrente != null && !corrente.produto.nomeProduto.equals(nome)) {
                corrente = corrente.next;
                i++;
            }
            if (i<2) {
                head = null;       
            }
            if (quantidade > corrente.produto.quantidade) {
                
                corrente.produto.quantidade = 0;
                Node temp = corrente.prev;
                corrente = corrente.next;
                corrente.prev = temp;
                temp.next = corrente;
                System.out.println("\nA lista esta vazia :(");

            }else{
                corrente.produto.quantidade -= quantidade;
            }
            
        }
        
    }

    public boolean existe(String nome){
        if (head == null) {
            return false;
        }else{
            Node corrente = head;        
            while (corrente != null && !corrente.produto.nomeProduto.equals(nome)) {                
                corrente = corrente.next;
            }

            if (!corrente.produto.nomeProduto.equals("none")) {
                return true;
            }else{
                return false;
            }
            
        }
    }

    public void mostrar(){
        Node corrente = head;
        if (corrente == null) {
            System.out.println("\n\nA lista esta vazia. :(\n\n");
            return;
        }
        System.out.print("\n\nLista atual: ");
        while (corrente.next != null) {
            System.out.print(corrente.produto.nomeProduto + "(" + corrente.produto.quantidade +")"+ " ");
            corrente = corrente.next;
        }
        
        System.out.print(corrente.produto.nomeProduto + "(" + corrente.produto.quantidade +")"+ " ");
    }

    public static void main(String[] args) {  /////////////teste

        Produto produto = new Produto("maca", 1);
        Produto produto2 = new Produto("banana", 1);
        Produto produto3 = new Produto("kiwi", 1);
        Produto produto4 = new Produto("ziwi", 2);


        ListaEncadeada list = new ListaEncadeada();
        list.addOrdered(produto);
        list.addOrdered(produto2);
        list.addOrdered(produto3);
        list.addOrdered(produto4);
        list.mostrar();        
    }
}

