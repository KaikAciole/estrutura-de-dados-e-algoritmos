package Linked_List_HortFrut;

import java.util.Scanner;

public class Menu {
 
    ListaEncadeada lista = new ListaEncadeada();
    Produto produto;
    Scanner sc = new Scanner(System.in);  

    public void mostrarMenu(){
        String m = "\nO que deseja fazer?\n\n1-Adicionar Produto\n2-ListarProdutos\n3-RemoverProdutos\n" 
        + "4-Checar Existencia de Produto\n5-Sair\n\nResposta(Em números): ";
        System.out.print(m);
        sc = new Scanner(System.in);
        String resposta = sc.nextLine();

        switch(resposta){
            case "1":
            adicionar();
            break;

            case "2":
            listar();
            break;

            case "3":
            remover();
            break;
            
            case "4":
            existe();
            break;

            case"5":
            return;


        }

    }

    public void adicionar(){ 
        String m = "\nPara adicionar, me diga o nome do produto:\n\nNome: ";
        System.out.print(m);
        String nome = sc.nextLine();

        m = "\nE a quantidade: ";
        System.out.print(m);
        int quantidade = sc.nextInt();        

        produto = new Produto(nome, quantidade);
        lista.addOrdered(produto);
        mostrarMenu();
    }

    public void listar(){
        lista.mostrar();
        mostrarMenu();
    }

    public void remover(){
        String m = "Digite o nome da produto a qual deseja remover: \n\nNome: ";
        System.out.print(m);
        String nome = sc.nextLine();
        
        m = "E a quantidade: ";
        System.out.print(m);
        int quantidade = sc.nextInt();

        lista.remover(nome, quantidade);

        mostrarMenu();
    }

    public void existe(){
        String m = "Digite o nome da produto a qual deseja verificar existência: \n\nNome: ";
        System.out.print(m);
        String nome = sc.nextLine();

        if (lista.existe(nome)) {
            System.out.print("\n\nExiste na lista.\n");
            mostrarMenu();
        }else{
            System.out.print("Não existe na lista.\n");
            mostrarMenu();
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu();

        menu.mostrarMenu();        
    }
}
