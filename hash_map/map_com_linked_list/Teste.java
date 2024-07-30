package map_com_linked_list;
public class Teste {
    public static void main(String[] args) {
        TabelaHash tabela = new TabelaHash();
        
        tabela.addMap(123, "kaik");
        tabela.addMap(321, "jose");
        tabela.addMap(213, "vini");
        tabela.addMap(423, "teste");
        tabela.mostrar();
        System.out.println(tabela.getValue(123));
        
    }
}
