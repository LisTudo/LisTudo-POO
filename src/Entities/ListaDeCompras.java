package Entities;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaDeCompras {
    private ArrayList<Produto> itens = new ArrayList<>();

    public void adicionarProduto(Scanner scanner) {
        while (true) {
            System.out.println("Informe o produto " + (itens.size() + 1) + ":");
            String nomeDoProduto = scanner.nextLine();
            if (!nomeDoProduto.equalsIgnoreCase("Q"))
                itens.add(new Produto(nomeDoProduto));
            else
                break;
        }
    }

    public void excluirItem(int numeroItem) {
        itens.remove(numeroItem - 1);
    }

    public void listaPronta() {
        itens.add(new Produto("Arroz"));
        itens.add(new Produto("Feijão"));
        itens.add(new Produto("Óleo"));
        itens.add(new Produto("Açúcar"));
        itens.add(new Produto("Café"));
        itens.add(new Produto("Sal"));
        itens.add(new Produto("Macarrão"));
        itens.add(new Produto("Leite"));

        exibirLista();
        System.out.println("Deseja adicionar mais itens?");
        String opcao = new Scanner(System.in).nextLine();

        if (opcao.equalsIgnoreCase("sim")) {

        }
    }

    public void exibirLista() {
        for (int i = 0; i < itens.size(); i++) {
            System.out.println((i+1) + " " + itens.get(i).getNome());
        }
    }


}
