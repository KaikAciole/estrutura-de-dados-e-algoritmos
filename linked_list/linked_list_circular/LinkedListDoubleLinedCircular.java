package LinkedListCircular;

public class LinkedListDoubleLinedCircular {
    Node head;
    Node tail;

    public LinkedListDoubleLinedCircular() {
        this.head = null;
        this.tail = null;
    }

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) { // Se a lista estiver vazia
            head = newNode;
            tail = newNode;
            newNode.prev = newNode;
            newNode.next = newNode;
        } else {
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
            tail.next = newNode;
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
}


