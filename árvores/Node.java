public class Node {
    
    private Node bigger;
    private Node smaller;
    private int data;

    public Node(int data){
        this.data = data;
        this.bigger = null;
        this.smaller = null;
    }

    public Node getBigger() {
        return bigger;
    }

    public void setBigger(Node bigger) {
        this.bigger = bigger;
    }

    public Node getSmaller() {
        return smaller;
    }

    public void setSmaller(Node smaller) {
        this.smaller = smaller;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    

}
