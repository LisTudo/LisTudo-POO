package Sistema;

import Entities.ListaDeCompras;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Esta e a classe responsavel pelas exibicoes e leitura de dados ao usuario. Contem os metodos necessarios para fornecer
 * os parametros necessarios para as classes Produto e ListaDeCompras para realizar as manipulacoes de seus respectivos objetos.
 */
public class Sistema {


    /**
     * Instancia da classe ListaDeCompras para construir o objeto onde serao armazenados os objetos da classe Produto.
     */
    ListaDeCompras listagem = new ListaDeCompras();
    Scanner scanner = new Scanner(System.in);

    /**
     * Metodo responsavel por dar as boas vindas ao usuario, sinalizando o inicio do programa.
     */
    public void boasVindas() {
        System.out.println("BOAS VINDAS!");
    }

    /**
     * Metodo responsavel pela exibição dos itens da lista. Utiliza um laco de repeticao for para percorrer o ArrayList de
     * produtos.
     */
    public void exibirLista() {
        for (int i = 0; i < listagem.tamanhoLista(); i++) { // exibindo a lista para o usuário
            System.out.println((i + 1) + " " + listagem.retornarProduto(i));
        }
    }

    /**
     * Meto responsavel por realizar a impressão da lista, incluindo o preco total da compra. Ao final da impressao, o programa
     * pergunta se o usuario deseja adicionar mais itens, caso sim, entra no metodo lerProdutos().
     */
    public void apresentarLista() {
        if (!listagem.getListaDeProdutos().isEmpty()) {
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

    /**
     * Metodo responsavel por realizar a leitura e transmissao dos parametros necessarios para a construcao dos objetos
     * da classe Produto para a classe ListaDeCompras. E utilizado um loop while para que o usuario possa informar varios
     * produtos antes de retornar ao menu inicial.
     */
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

    /**
     * Este metodo tem a funcao de apresentar uma lista pre-definida de produtos considerados "esenciais", para que o usuario
     * consiga adiciona-los de uma vez. Antes de finalizar a execucao do metodo, o progama pergunta ao usuario se deseja
     * adicionar mais algum item personalizado na lista, atraves do metodo adicionarProduto().
     */
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

    /**
     * Atraves da execucao deste metodo, o usuario consegue adicionar a cada produto o preco encontrado. A partir desta entrada
     * o programa calcula o preco total de cada produto e o preco total da compra do usuario.
     */
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


    /**
     * Atraves deste metodo, o usuario consegue excluir os itens dos quais nao ira mais precisar. E realizada a leitura do
     * indice do item atraves do Scanner() removendo o respectivo objeto da classe Produto do ArrayList listaDeProdutos.
     * Após isso, o programa realizar a atualizacao do preco total da compra atraves do metodo atualizarPrecoTotal() da Classe
     * ListaDeCompras.
     */
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

    /**
     * Este metodo e responsavel por exibir o menu inicial e ler a opcao escolhida pelo usuario, redirecionando-o para o metodo
     * responsavel pela acao escolhida.
     */
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
            int opcao = 0;
            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("ENTRADA INVALIDA. INFORME UM NUMERO INTEIRO.");
                scanner.nextLine(); // Consumindo a proxima linha no buffer
                continue; //Retornando ao inicio do loop
            }

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
                        System.out.println("ENTRADA INVÁLIDA. INFORME UM NUMERO INTEIRO.");
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
