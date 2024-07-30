package LinkedListDoubleLined;

public class LinkedListDoubleLinedOrdened {
    Node head;
    Node foot;

    public void addOrdered(int data) {
        Node novo = new Node(data);
        if (head == null) {
            head = novo;
            foot = novo;
        } else if (data <= head.data) {
            novo.next = head;
            head.prev = novo;
            head = novo;
        } else if (data >= foot.data) {
            foot.next = novo;
            novo.prev = foot;
            foot = novo;
        } else {
            Node corrente = head;
            while (corrente.next != null && corrente.next.data < data) {
                corrente = corrente.next;
            }
            novo.next = corrente.next;
            corrente.next.prev = novo;
            corrente.next = novo;
            novo.prev = corrente;
        }
    }

    public int pop() {
        if (head == null) {
            return 1;
        } else if (head == foot) {
            head = null;
            foot = null;
            return 0;
        }
            head = head.next;
            head.prev = null;
            return 0;
    }


    public int popIndex(int posicao){
        int i = 0;
        Node corrente = head;
        if (posicao>getSize()){
            return 1;
        }
        while (i<posicao){
            corrente = corrente.next;
            i += 1;

        }if(corrente.next != null) {
            Node temp = corrente.prev;
            corrente = corrente.next;
            corrente.prev = temp;
            temp.next = corrente;
            return 0;

        }
            corrente = corrente.prev;
            corrente.next = null;
            return 0;
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

    public int getSize(){
        int count = 0;
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
            count += 1;
        }
        return count;
    }

    public Node getNode(int index) {
        int i = 0;
        Node corrente = head;
        if (index > getSize()) {
            return null;
        }
        while (i < index) {
            corrente = corrente.next;
            i += 1;
        }
            return corrente;
    }

    public static void main(String[] args) {
        LinkedListDoubleLinedOrdened list = new LinkedListDoubleLinedOrdened();
        list.addOrdered(4);
        list.addOrdered(3);
        list.addOrdered(1);
        list.addOrdered(2);
        list.mostrar();
        System.out.println(list.pop());
        System.out.println(list.popIndex(3));
        list.mostrar();
        System.out.println(list.getNode(3).data);
    }
}
