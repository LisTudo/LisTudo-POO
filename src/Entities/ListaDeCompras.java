package Entities;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ListaDeCompras {
    private final ArrayList<Produto> listaDeCompras = new ArrayList<>();
    private double precoTotal;


    Scanner scanner = new Scanner(System.in);

    public void adicionarProduto() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("PRESSIONE \"Q\"" +  " PARA SAIR");
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

    public void excluirItem() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("INFORME O NÚMERO DO ITEM QUE DESEJA EXCLUIR: ");
        int numeroItem = scanner.nextInt();
        if (numeroItem > listaDeCompras.size()) {
            throw new IndexOutOfBoundsException("O ITEM NÃO EXISTE NA LISTA.");
        }
        scanner.nextLine();
        System.out.println();
        listaDeCompras.remove(numeroItem - 1);

        double precoTotal = 0;
        for (int j = 0; j < listaDeCompras.size(); j++) {
            precoTotal += (listaDeCompras.get(j).getPreco()) * (listaDeCompras.get(j).getQuantidade());
            setPrecoTotal(precoTotal);
        }


    }

    public void listaPronta() {
        Scanner scanner = new Scanner(System.in);
        String opcao = "";

        System.out.println("\nARROZ" +
                "\nFEIJÃO" +
                "\nÓLEO" +
                "\nAÇÚCAR" +
                "\nCAFÉ" +
                "\nSAL" +
                "\nMACARRÃO" +
                "\nLEITE" +
                "\n\nDESEJA ADICIONAR OS ITENS BÁSICOS ACIMA? (\"S\" PARA CONFIRMAR)");
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
        System.out.println("DESEJA ADICIONAR MAIS ITENS? (\"S\" PARA CONFIRMAR)");
        opcao = scanner.nextLine();

        if (opcao.equalsIgnoreCase("s")) {
            adicionarProduto();
        }
    }

    public void exibirLista() {
        Scanner scanner = new Scanner(System.in);

        if (!listaDeCompras.isEmpty()) { // Método para verificar se a lista está vazia
            for (int i = 0; i < listaDeCompras.size(); i++) {
                System.out.println((i + 1) + " " + listaDeCompras.get(i).toString());
            }
            if (getPrecoTotal() != 0) {
                System.out.printf("\nPRECO TOTAL = R$ %.2f" , getPrecoTotal());
            }
        } else {
            System.out.println("NENHUM ITEM ADICIONADO. DESEJA ADICIONAR? (\"S\" PARA CONFIRMAR):");
            String opcao = scanner.nextLine();

            if (opcao.equalsIgnoreCase("S")) {
                adicionarProduto();

            }
        }

    }

    public void irAoMercado() {
        Scanner sacnner = new Scanner(System.in);

        System.out.println("INFORME O PREÇO ENCONTRADO PARA OS ITENS DA LISTA");
        for (int i = 0; i < listaDeCompras.size(); i++) {
            System.out.println(listaDeCompras.get(i) + ": R$ ");
            double preco = sacnner.nextDouble();
            listaDeCompras.get(i).definirPreco(preco);
        }
        double precoTotal = 0;
        for (int j = 0; j < listaDeCompras.size(); j++) {
            precoTotal += (listaDeCompras.get(j).getPreco()) * (listaDeCompras.get(j).getQuantidade());

        }
        setPrecoTotal(precoTotal);
        System.out.printf("PREÇO TOTAL: R$ %.2f \nPAGUE NO CAIXA\n" , getPrecoTotal());
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

}
