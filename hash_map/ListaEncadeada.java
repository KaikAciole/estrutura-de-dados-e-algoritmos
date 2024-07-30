public class ListaEncadeada {
    Node head;
    Node foot;

    public void addLast(Aluno data){
        Node novo = new Node(data);

        if(head == null){
            foot = novo;
            head = novo;
        }else{
            Node corrente = head;
            while (corrente.getNext() != null) {
                corrente = corrente.getNext();
            }
            corrente.setNext(novo);
            novo.setPrev(corrente);
            foot = novo;
        }
    }

    public boolean remove(int chave) {
        if (head == null) { 
            return false;
        }   

        Node corrente = head;    
        
        while (corrente != null && corrente.getData().getMatricula() != chave) {
            corrente = corrente.getNext();
        }
    
        if (corrente == null) { 
            return false;
        }
    
        if (corrente == head) { 
            head = corrente.getNext();
            if (head != null) {
                head.setPrev(null);
            } else {
                foot = null;
            }
        } else if (corrente == foot) { 
            foot = corrente.getPrev();
            if (foot != null) {
                foot.setNext(null);
            } else {
                head = null;
            }
        } else { 
            Node prev = corrente.getPrev();
            Node next = corrente.getNext();
            prev.setNext(next);
            next.setPrev(prev);
        }
    
        return true;
    }

    public String getValue(int chave){
        if (head == null) { 
            return "não existe";
        }   

        Node corrente = head;    
        
        while (corrente != null && corrente.getData().getMatricula() != chave) {
            corrente = corrente.getNext();
        }
    
        if (corrente == null) { 
            return "não encontrado";
        }
        return corrente.getData().getNomeAluno();
    }
    
    public void show(){
        Node corrente = head;
        if (corrente == null) {
            System.out.print(" ");            
        }else{            
            while (corrente.getNext() != null) {
                System.out.print(corrente.getData().getNomeEMatricula() + ", ");  
                corrente = corrente.getNext();                    
            }
            System.out.print(corrente.getData().getNomeEMatricula());
        }
        
    }

    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();
        Aluno aluno1 = new Aluno("kaik", 123);
        Aluno aluno2 = new Aluno("jef", 321);
        lista.addLast(aluno1);
        lista.addLast(aluno2);
        

    }
}
