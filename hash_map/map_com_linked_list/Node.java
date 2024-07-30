package map_com_linked_list;
public class Node {
    private Node prev;
    private Node next;
    private Aluno data;

    public Node (Aluno data){
        this.prev = null;
        this.next = null;
        this.data = data;
    }

    public Node getPrev() {
        return prev;
    }

    public Node getNext() {
        return next;
    }

    public Aluno getData() {
        return data;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setData(Aluno data) {
        this.data = data;
    }
    
}
