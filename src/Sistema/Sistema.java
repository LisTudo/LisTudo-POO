package Sistema;

import Entities.ListaDeCompras;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Sistema {

    public static void menuInicial(Scanner scanner) {
        while (true) {

            System.out.println("\nMENU" +
                    "\n1 - ADICIONAR ITENS" +
                    "\n2 - EXIBIR LISTA" +
                    "\n3 - ADICIONAR CESTA BÁSICA" +
                    "\n4 - IR AO MERCADO" +
                    "\n5 - EXCLUIR ITEM" +
                    "\n6 - SAIR");
            System.out.print("INFORME: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    try { // Tratamento de excecoes para caso o usuario digite um valor que não seja int para a quantidade
                        ListaDeCompras.adicionarProduto();
                    }catch (InputMismatchException e) {
                        System.out.println("ENTRADA INVÁLIDA");
                    }catch (Exception exception) {
                        System.out.println(exception.getMessage());
                        exception.printStackTrace();
                    }
                    break;
                case 2:
                    ListaDeCompras.exibirLista();
                    break;
                case 3:
                    ListaDeCompras.listaPronta();
                    break;
                case 4:
                    try { // Tratamento de excecoes para caso o usuario digite um valor que não seja int para a quantidade
                        ListaDeCompras.irAoMercado();
                    }catch (InputMismatchException e) {
                        System.out.println("ENTRADA INVÁLIDA");
                    }catch (Exception exception) {
                        System.out.println(exception.getMessage());
                        exception.printStackTrace();
                    }
                    break;
                case 5:
                    try {
                        ListaDeCompras.excluirItem();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Informe uma das opções válidas.");
            }
        }
    }
}
