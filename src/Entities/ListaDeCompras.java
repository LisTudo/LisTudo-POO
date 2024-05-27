package Entities;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaDeCompras {
    private static ArrayList<Produto> listaDeCompras = new ArrayList<Produto>();
    private static double precoTotal;

    Scanner scanner = new Scanner(System.in);

    public static void adicionarProduto() {

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < listaDeCompras.size(); i++) { // exibindo a lista para o usuário
            System.out.println((i + 1) + " " + listaDeCompras.get(i).getNome());
        }

        while (true) {
            System.out.println("INFORME O NOME DO PRODUTO " + (listaDeCompras.size() + 1) + ": ");
            String nomeDoProduto = scanner.nextLine();
            int quantidade = 0;
            if (!nomeDoProduto.equalsIgnoreCase("Q")) {

                System.out.println("INFORME A QUANTIDADE: ");
                quantidade = scanner.nextInt();
                scanner.nextLine(); // Consumir a linha após o nextInt()
            }
            else
                break;
            listaDeCompras.add(new Produto(nomeDoProduto, quantidade));
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
        String opcao = "";

        System.out.println("DESEJA ADICIONAR OS ITENS BÁSICOS ABAIXO?" +
                "\nARROZ" +
                "\nFEIJÃO" +
                "\nÓLEO" +
                "\nAÇÚCAR" +
                "\nCAFÉ" +
                "\nSAL" +
                "\nMACARRÃO" +
                "\nLEITE");
        opcao = scanner.nextLine();

        if (opcao.equalsIgnoreCase("s")) {
            listaDeCompras.add(new Produto("Arroz", 1));
            listaDeCompras.add(new Produto("Feijão", 1));
            listaDeCompras.add(new Produto("Óleo", 1));
            listaDeCompras.add(new Produto("Açúcar", 1));
            listaDeCompras.add(new Produto("Café", 1));
            listaDeCompras.add(new Produto("Sal", 1));
            listaDeCompras.add(new Produto("Macarrão", 1));
            listaDeCompras.add(new Produto("Leite", 1));
        }

        exibirLista();
        System.out.println("Deseja adicionar mais itens?");
        opcao = scanner.nextLine();

        if (opcao.equalsIgnoreCase("s")) {
            ListaDeCompras.adicionarProduto();
        }
    }

    public static void exibirLista() {
        Scanner scanner = new Scanner(System.in);

        if (!listaDeCompras.isEmpty()) { // Método para verificar se a lista está vazia
            for (int i = 0; i < listaDeCompras.size(); i++) {
                System.out.println((i + 1) + " " + listaDeCompras.get(i).toString());
            }
        } else {
            System.out.println("NENHUM ITEM ADICIONADO. DESEJA ADICIONAR?");
            String opcao = scanner.nextLine();

            if (opcao.equalsIgnoreCase("S")) {
                adicionarProduto();


            }
        }

    }

    public static void irAoMercado() {
        Scanner sacnner = new Scanner(System.in);

        System.out.println("INFORME O PREÇO ENCONTRADO PARA OS ITENS DA LISTA");
        for (int i = 0; i < listaDeCompras.size(); i++) {
            System.out.println(listaDeCompras.get(i) + ": R$ ");
            double preco = sacnner.nextDouble();
            listaDeCompras.get(i).definirPreco(preco);
        }
        double precoTotal = 0;
        for (int j = 0; j < listaDeCompras.size(); j++) {
            precoTotal += listaDeCompras.get(j).getPreco();
            ListaDeCompras.setPrecoTotal(precoTotal);
        }
        System.out.printf("PREÇO TOTAL: R$ %.2f \nPAGUE NO CAIXA\n" , ListaDeCompras.getPrecoTotal());
    }

    public static double getPrecoTotal() {
        return precoTotal;
    }

    public static void setPrecoTotal(double precoTotal) {
        ListaDeCompras.precoTotal = precoTotal;
    }
}
