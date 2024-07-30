package LinkedListDoubleLined;

public class LinkedListDoubleLined {
    Node head;
    Node foot;

    public void addLast(int data) {
        Node novo = new Node(data);
        if (head == null) {
            head = novo;
        } else {
            Node corrente = head;
            while (corrente.next != null){
                corrente = corrente.next;
            }
            corrente.next = novo;
            novo.prev = corrente;
            foot = novo;
        }
    }

    public void addIndice(int data, int indice){
        Node novo = new Node(data);
        try {
            int i = 0;
            Node corrente = head;
            while (i<indice-1){
                corrente = corrente.next;
                i += 1;
            }
            Node next = corrente.next;
            next.prev = novo;
            novo.next = next;
            novo.prev = corrente;
            corrente.next = novo;
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void mostrar(){
        Node corrente = head;
        System.out.print("Lista atual: ");
        while (corrente.next != null) {
            System.out.print(corrente.data + " ");
            corrente = corrente.next;
        }
        System.out.println(corrente.data + " ");
    }

    public static void main(String[] args) {
        LinkedListDoubleLined list = new LinkedListDoubleLined();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addIndice(7, 5);
        list.mostrar();
    }
}
