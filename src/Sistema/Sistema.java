package Sistema;

import Entities.ListaDeCompras;
import Entities.Produto;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Sistema {

    ListaDeCompras listagem = new ListaDeCompras();
    Scanner scanner = new Scanner(System.in);


    public void boasVindas() {
        System.out.println("Boas Vindas!");
    }

    /**
     * Metodo responsavel
     */
    public void exibirLista() {
        for (int i = 0; i < listagem.tamanhoLista(); i++) { // exibindo a lista para o usuário
            System.out.println((i + 1) + " " + listagem.retornarProduto(i));
        }
    }

    public void apresentarLista() {
        if (!listagem.getListaDeProdutos().isEmpty()) { // Método para verificar se a lista está vazia
            exibirLista();
            if (listagem.getPrecoTotal() != 0) {
                System.out.printf("\nPRECO TOTAL = R$ %.2f" , listagem.getPrecoTotal());
            }
        } else {
            System.out.println("NENHUM ITEM ADICIONADO. DESEJA ADICIONAR? (\"S\" PARA CONFIRMAR):");
            String opcao = scanner.nextLine();

            if (opcao.equalsIgnoreCase("S")) {
                lerProdutos();
            }
        }
    }

    public void lerProdutos() {

        while (true) {
            System.out.println("INFORME O NOME DO PRODUTO " + (listagem.tamanhoLista() + 1) + ": ");
            scanner.nextLine();
            String nomeDoProduto = scanner.nextLine();
            int quantidade = 0;

            if (!nomeDoProduto.equalsIgnoreCase("Q")) {
                System.out.println("INFORME A QUANTIDADE: ");
                quantidade = scanner.nextInt();
            }
            else
                break;
            listagem.adicionarProduto(nomeDoProduto, quantidade);
        }
    }

    public void exibirCestaBasica() {
        System.out.println("DESEJA ADICIONAR OS ITENS ABAIXO?");
        System.out.println("\nARROZ" +
                "\nFEIJÃO" +
                "\nÓLEO" +
                "\nAÇÚCAR" +
                "\nCAFÉ" +
                "\nSAL" +
                "\nMACARRÃO" +
                "\nLEITE" +
                "\n\nDESEJA ADICIONAR OS ITENS BÁSICOS ACIMA? (\"S\" PARA CONFIRMAR)");

        String opcao = scanner.nextLine();

        if (opcao.equalsIgnoreCase("s")) {
            listagem.adicionarProduto("Arroz", 1);
            listagem.adicionarProduto("Feijão", 1);
            listagem.adicionarProduto("Óleo", 1);
            listagem.adicionarProduto("Açúcar", 1);
            listagem.adicionarProduto("Café", 1);
            listagem.adicionarProduto("Sal", 1);
            listagem.adicionarProduto("Macarrão", 1);
            listagem.adicionarProduto("Leite", 1);
        }

        exibirLista();
        System.out.println("DESEJA ADICIONAR MAIS ITENS? (\"S\" PARA CONFIRMAR)");
        opcao = scanner.nextLine();

        if (opcao.equalsIgnoreCase("s")) {
            lerProdutos();
        }
    }

    public void irAoMercado() {
        System.out.println("INFORME O PREÇO ENCONTRADO PARA OS ITENS DA LISTA");
        for (int i = 0; i < listagem.tamanhoLista(); i++) {
            System.out.println((i + 1) + " " + listagem.retornarProduto(i).getNome() + ": R$ ");
            double preco = scanner.nextDouble();
            listagem.precificarProduto(i, preco);
        }
        listagem.atualizarPrecoTotal();
        System.out.printf("PREÇO TOTAL: R$ %.2f \nPAGUE NO CAIXA\n" , listagem.getPrecoTotal());
    }


    public void excluirItem() {
        exibirLista();
        System.out.println();
        System.out.print("INFORME O NÚMERO DO ITEM QUE DESEJA EXCLUIR: ");
        int numeroItem = scanner.nextInt();
        if (numeroItem > listagem.tamanhoLista()) {
            throw new IndexOutOfBoundsException("O ITEM NÃO EXISTE NA LISTA.");
        }
        scanner.nextLine();
        System.out.println();
        listagem.removerProduto(numeroItem - 1);
        apresentarLista();
    }


    public void menuInicial() {
        while (true) {

            System.out.println("\nMENU" +
                    "\n1 - ADICIONAR ITENS" +
                    "\n2 - EXIBIR LISTA" +
                    "\n3 - ADICIONAR CESTA BÁSICA" +
                    "\n4 - IR AO MERCADO" +
                    "\n5 - EXCLUIR ITEM" +
                    "\n6 - SAIR");
            System.out.print("INFORME: ");
            System.out.println();
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    try { // Tratamento de excecoes para caso o usuario digite um valor que não seja int para a quantidade
                        exibirLista();
                        lerProdutos();
                    }catch (InputMismatchException e) {
                        System.out.println("ENTRADA INVÁLIDA");
                    }catch (Exception exception) {
                        System.out.println(exception.getMessage());
                        exception.printStackTrace();
                    }
                    break;
                case 2:
                    apresentarLista();
                    break;
                case 3:
                    exibirCestaBasica();
                    break;
                case 4:
                    try { // Tratamento de excecoes para caso o usuario digite um valor que não seja int para a quantidade
                        irAoMercado();
                    }catch (InputMismatchException e) {
                        System.out.println("ENTRADA INVÁLIDA");
                    }catch (Exception exception) {
                        System.out.println(exception.getMessage());
                        exception.printStackTrace();
                    }
                    break;
                case 5:
                    try {
                        excluirItem();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("ENTRADA INVALIDA. ESCOLHA UMA DAS OPCOES ABAIXO:");
            }
        }
    }
}
