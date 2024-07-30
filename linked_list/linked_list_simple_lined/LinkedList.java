package LinkedListSimpleLined;
public class LinkedList {
    Node head;

    public void add(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
        }else{
            Node corrente = head;
            while (corrente.next != null){  /* Faz com que seja adicionado só na */
                corrente = corrente.next;   /* última posição da linkedlist*/
            }
            corrente.next = newNode;
        }
    }

    public void addIndice(int data, int indice){
        Node newNode = new Node(data);
        try {
            if(head==null){
                head = newNode;
            }else{
                int i = 0;
                Node corrente = head;
                while (i<indice-1){
                    corrente = corrente.next;
                    i += 1;
                }
                Node next = corrente.next;
                corrente.next = newNode;
                newNode.next = next;
            }
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    public void mostrar(){
        Node corrente = head;
        System.out.print("Lista atual: ");
        while (corrente != null) {
            System.out.print(corrente.data + " ");
            corrente = corrente.next;
        }
        System.out.println();
    }



    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.addIndice(5, 4);
        list.mostrar();
    }
}
