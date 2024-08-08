public class Tree{

    Node root;

    public Tree(){        
        this.root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.getData())
            root.setSmaller(insertRec(root.getSmaller(), value));
        else if (value > root.getData()){
            root.setBigger(insertRec(root.getBigger(), value));
        }

        return root;
    }

    public int search(int data){
        return searchRec(root, data);
    }

    private int searchRec(Node node, int data){
        if (node.getData() < data) {
            Node big = node.getBigger();            
            return searchRec(big, data);
        }else if (node.getData() > data ) {
            Node small = node.getSmaller();            
            return searchRec(small, data);
        }else{
            return node.getData();
        }
        
    }

    public void show() {
        showRec(root);
    }

    private void showRec(Node root) {
        if (root != null) {
            showRec(root.getSmaller());
            System.out.print(root.getData() + " ");
            showRec(root.getBigger());
        }
    }

    public void removeMin() {
        root = removeMinRec(root);
    }

    private Node removeMinRec(Node root) {
        if (root == null) {
            return null;
        }
        if (root.getSmaller() == null) {
            return root.getBigger();
        }
        root.setSmaller(removeMinRec(root.getSmaller()));
        return root;
    }

    public void removeMax() {
        root = removeMaxRec(root);
    }

    private Node removeMaxRec(Node root) {
        if (root == null) {
            return null;
        }
        if (root.getBigger() == null) {
            return root.getSmaller();
        }
        root.setBigger(removeMaxRec(root.getBigger()));
        return root;
    }

    public static void main(String[] args) {
        Tree arvore = new Tree();
        arvore.insert(10);
        arvore.insert(11);
        arvore.insert(9);
        System.out.print(arvore.search(9));
        arvore.show();

    }
}