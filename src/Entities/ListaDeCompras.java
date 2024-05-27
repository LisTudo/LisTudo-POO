package Entities;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaDeCompras {
    private static ArrayList<Produto> listaDeCompras = new ArrayList<Produto>();

    Scanner scanner = new Scanner(System.in);

    public static void adicionarProduto() {

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < listaDeCompras.size(); i++) { // exibindo a lista para o usuário
            System.out.println((i + 1) + " " + listaDeCompras.get(i).getNome());
        }

        while (true) {
            System.out.println("INFORME O NOME DO PRODUTO" + (listaDeCompras.size() + 1) + ":");
            String nomeDoProduto = scanner.nextLine();
            if (!nomeDoProduto.equalsIgnoreCase("Q")) {
                listaDeCompras.add(new Produto(nomeDoProduto));
                System.out.println("INFORME A QUANTIDADE DO PRODUTO" + (listaDeCompras.size() + 1) + ":");
                listaDeCompras.get()
            }
            else
                break;
        }
    }

    public static void excluirItem() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o número do item que deseja excluir: ");
        int numeroItem = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        listaDeCompras.remove(numeroItem - 1);

    }

    public static void listaPronta() {
        Scanner scanner = new Scanner(System.in);

        listaDeCompras.add(new Produto("Arroz"));
        listaDeCompras.add(new Produto("Feijão"));
        listaDeCompras.add(new Produto("Óleo"));
        listaDeCompras.add(new Produto("Açúcar"));
        listaDeCompras.add(new Produto("Café"));
        listaDeCompras.add(new Produto("Sal"));
        listaDeCompras.add(new Produto("Macarrão"));
        listaDeCompras.add(new Produto("Leite"));

        exibirLista();
        System.out.println("Deseja adicionar mais itens?");
        String opcao = scanner.nextLine();

        if (opcao.equalsIgnoreCase("sim")) {

        }
    }

    public static void exibirLista() {
        Scanner scanner = new Scanner(System.in);

        if (listaDeCompras.size() > 0) {
            for (int i = 0; i < listaDeCompras.size(); i++) {
                System.out.println((i + 1) + " " + listaDeCompras.get(i).getNome());
            }
        } else {
            System.out.println("NENHUM ITEM ADICIONADO. DESEJA ADICIONAR?");
            String opcao = scanner.nextLine();

            if (opcao.equalsIgnoreCase("S")) {
                adicionarProduto();


            }
        }

    }

}
