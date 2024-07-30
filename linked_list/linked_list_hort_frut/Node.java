package Linked_List_HortFrut;

public class Node {
    Produto produto;
    Node prev;
    Node next;

    public Node(Produto produto){
        this.produto = produto;
        this.next = null;
        this.prev = null;
    }
}
