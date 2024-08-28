package TreeB;

public class Node {
    Integer[] data;
    
    public Node(int ordem){
        this.data = new Integer[ordem-1];
    };

    public void add(){
        if (!isFull()) {
            
        }
        
    };

    private boolean isFull(){
        int cheio = 0;
        for (int i = 0; i<data.length-1; i++) {
            if (data[i] != null) {
                cheio += 1;
            }
        }

        if (cheio < data.length) {
            return false;
        }return true;
    }

}
