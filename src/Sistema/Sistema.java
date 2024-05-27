package Sistema;

import Entities.ListaDeCompras;

import java.util.Scanner;

public class Sistema {

    public static void menuInicial(Scanner scanner) {
        while (true) {
            System.out.println("MENU" +
                    "\n1 - ADICIONAR ITENS" +
                    "\n2 - EXIBIR LISTA" +
                    "\n3 - ADICIONAR CESTA BÁSICA" +
                    "\n4 - IR AO MERCADO" +
                    "\n5 - SAIR");
            System.out.print("INFORME: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    ListaDeCompras.adicionarProduto();
                    break;
                case 2:
                    ListaDeCompras.exibirLista();
                    break;
                case 3:
                    ListaDeCompras.listaPronta();
                    break;
                case 4:
                    ListaDeCompras.irAoMercado();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Informe uma das opções válidas.");
            }
        }
    }
}
