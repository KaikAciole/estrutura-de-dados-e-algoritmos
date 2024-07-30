package map_com_linked_list;
public class Aluno{
    
    private String nomeAluno;
    private int matricula;
    
    public Aluno(String nomeAluno, int matricula){
        this.matricula = matricula;
        this.nomeAluno = nomeAluno;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public String getNomeEMatricula(){
        String aluno = String.valueOf(matricula) + ":" + getNomeAluno();
        return aluno;
    }
}