

public class LinkedListSimpleLinedCircular {
    Node head;
    Node tail;

    public LinkedListSimpleLinedCircular() {
        this.head = null;
        this.tail = null;
    }

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head; 
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("A lista está vazia");
            return;
        }
        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }
    
    public static void main(String[] args) {
        LinkedListSimpleLinedCircular lista = new LinkedListSimpleLinedCircular();
        lista.append(1);
        lista.append(2);
        lista.append(3);
        lista.append(4);
        lista.display();
    }
}

