package Sistema;

import Entities.ListaDeCompras;

import java.util.Scanner;

public class Sistema {

    public static void menuInicial(Scanner scanner) {
        while (true) {
            System.out.println("MENU" +
                    "\n1 - ADICIONAR ITENS" +
                    "\n2 - EXIBIR LISTA" +
                    "\n3 - IR AO MERCADO" +
                    "\n4 - SAIR");
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
                    System.out.println("opcao 3");
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Informe uma das opções válidas.");
            }
        }
    }
}
