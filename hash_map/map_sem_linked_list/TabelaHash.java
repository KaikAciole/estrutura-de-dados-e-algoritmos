public class TabelaHash {

    private Aluno[] tabela = new Aluno[3];
    private Aluno removido = new Aluno(-1, "aluno_removido");
    private Aluno teste;

    public TabelaHash(){
        
    }

    public Aluno insertValue(int chave, String value){
        Aluno aluno = new Aluno(chave, value);
        int hash = calHash(chave);
        if(checkLength()){                        
            if(tabela[hash] == null || tabela[hash] == removido){
                tabela[hash] = aluno;
                return aluno;
            }else{
                while (tabela[hash] != null || tabela[hash] == removido) {
                    hash += 1;
                }
                tabela[hash] = aluno;
                return aluno;
            }
        }else{
            resize();
            if(tabela[hash] == null || tabela[hash] == removido){
                tabela[hash] = aluno;
                return aluno;
            }else{
                while (tabela[hash] != null || tabela[hash] == removido) {
                    hash += 1;
                }
                tabela[hash] = aluno;
                return aluno;
            }
        }      
    }

    public boolean removeValue(int chave){
        int hash = calHash(chave);
        for(int i = hash; i<tabela.length; i++){   
             teste = tabela[i];           
            if (tabela[i] != null && teste.matricula == chave) {
                tabela[i] = removido;
                return true;
            }            
        }
        return false;
    }

    public void showTabela(){
        for(int i = 0; i<tabela.length; i++){
            if (tabela[i] != null) {
                System.out.println(tabela[i].nome);

            }else{ // caso seja null na posição 
                System.out.println(tabela[i]);

            }
        }
    }

    public int calHash(int chave){
        int mod = tabela.length;
        int hash;
        if (chave == tabela.length) {
            hash = tabela.length-1;    
        }else{
            hash = (chave % mod) - 1;
        }
        return hash;
    }
    
   
    public String getValue(int chave){
        int hash = calHash(chave);
        for(int i = hash; i<tabela.length; i++){   
             teste = tabela[i];           
            if (tabela[i] != null && teste.matricula == chave) {
                return tabela[i].nome;
            }            
        }
        return "não existe";
    }


    public boolean checkLength(){
        int contador = 0;
        for(int i = 0; i<tabela.length; i++){
            if (tabela[i] != null && tabela[i] != removido) { // olha se cada posição esta preenchida
                contador ++;                                         // conta as posições preenchidas
            }
        }
        if (contador == tabela.length) { // se todas as posições tiverem preenchidas
            return false;
        }
        return true;
    }

    public void resize(){
        Aluno[] tabelaOld = tabela;
        tabela = new Aluno[tabelaOld.length*2];

        for(int i = 0; i<tabelaOld.length; i++){
            int matricula = tabelaOld[i].matricula;
            String nome = tabelaOld[i].nome;
            insertValue(matricula, nome);
        }
    }

    public static void main(String[] args) {
        TabelaHash tabela = new TabelaHash();
        tabela.insertValue(1, "kaik");
        tabela.insertValue(2, "joao");
        tabela.insertValue(3, "jose");            
        tabela.insertValue(3, "bruno");                
        tabela.insertValue(3, "loiun");   
        tabela.insertValue(9, "isaac");   
        tabela.insertValue(6, "ramon");   
        tabela.removeValue(6);
        tabela.showTabela();        
    }
}
