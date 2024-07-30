public class TabelaHash {
    
    private ListaEncadeada lista1 = new ListaEncadeada();
    private ListaEncadeada lista2 = new ListaEncadeada();
    private ListaEncadeada lista3 = new ListaEncadeada();
    private ListaEncadeada lista4 = new ListaEncadeada();

    private ListaEncadeada lista5 = new ListaEncadeada();

    public void mostrar(){
        System.out.print("map: { ");
        lista1.show();        
        lista2.show();
        lista3.show();
        lista4.show();
        lista5.show();
        System.out.print(" }\n");
        
    }

    public void addMap(int key, String value){
        int hash = calculateHash(key);
        Aluno aluno;
        switch (hash) {

            case 0:
                aluno = new Aluno(value, key);
                lista1.addLast(aluno);
                break;

            case 1: 
                aluno = new Aluno(value, key);
                lista2.addLast(aluno);
                break;
            
            case 2:
                aluno = new Aluno(value, key);
                lista3.addLast(aluno);
                break;

            case 3:
                aluno = new Aluno(value, key);
                lista4.addLast(aluno);
                break;

            case 4:
                aluno = new Aluno(value, key);
                lista5.addLast(aluno); 
                break;     
        
            default:
                break;
        }
    }

    public boolean removeMap(int key){
        int hash = calculateHash(key);

        switch (hash){

            case 0:                
                return lista1.remove(key);
                
            case 1:             
                return lista2.remove(key);
                
            case 2:                
                return lista3.remove(key);
                
            case 3:                
                return lista4.remove(key);
                
            case 4:                
                return lista5.remove(key); 
                           
            default:
            return false;

        }
    }

    public String getValue(int chave){
        int hash = calculateHash(chave);

        switch (hash){

            case 0:                
                return lista1.getValue(chave);

            case 1:             
                return lista2.getValue(chave);
                            
            case 2:                
                return lista3.getValue(chave);                

            case 3:                
                return lista4.getValue(chave);                

            case 4:                
                return lista5.getValue(chave);
        
            default:
                return "Erro no getValue()";
                
        }
    }
    
    private int calculateHash(int key){
        int hash = key % 5;
        return hash;
    }

    public static void main(String[] args) {
        
    }
}
