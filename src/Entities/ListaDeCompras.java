package Entities;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * Esta classe e a abstracao da lista de compras que sera construida e alterada pelo usuario. Possui os metodos necessarios para
 * manipulacao da lista e dos objetos da classe Produto que forem armazenados nela.
 */
public class ListaDeCompras {
    private final ArrayList<Produto> listaDeProdutos = new ArrayList<>();
    private double precoTotal;


    /**
     * Metodo responsavel por instanciar os objetos da clsse Produto através de seu metodo construtor. Apos instanciado o objeto é adicionado
     * ao atributo listaDeProdutos da classe ListaDeCompras.
     * @param nomeDoProduto String passado como parametro para o construtor da clase Produto.
     * @param quantidade int passado como parametro para o construtor da clase Produto.
     */
    public void adicionarProduto(String nomeDoProduto, int quantidade) {

        listaDeProdutos.add(new Produto(nomeDoProduto, quantidade));

    }

    /**
     * Metodo utilizado para remover um produto quando o usuario aciona o metodo excluirItem() da classe Sistema.
     * @param indiceItem E passado como parametro um valor int para representar o indice do produto a ser excluido do ArrayList
     *                   listaDeProdutos.
     */
    public void removerProduto(int indiceItem) {
        listaDeProdutos.remove(indiceItem);
        atualizarPrecoTotal();
    }

    /**
     * Metodo utilizado para atribuir o preco do produto a partir do metodo setter da classe Produto.
     * @param indiceProduto E passado como parametro um valor int para identificar a posicao do item a ter seu preco atribuido.
     * @param preco E passado um valor double para definir o valor do produto a ser atribuido.
     */
    public void precificarProduto(int indiceProduto, double preco) {
        listaDeProdutos.get(indiceProduto).setPreco(preco);
    }

    /**
     * Metodo responsavel por atualizar o calculo utilizado para definir o valor total da compra do cliente. Realiza o calculo do valor total
     * de cada produto multiplicando as quantidades pelos valores unitarios.
     */
    public void atualizarPrecoTotal() {
        double precoTotal = 0;
        for (int j = 0; j < listaDeProdutos.size(); j++) {
            precoTotal += (listaDeProdutos.get(j).getPreco()) * (listaDeProdutos.get(j).getQuantidade());
        }
        this.precoTotal = precoTotal;
    }

    /**
     * Metodo getter para o atributo preco total dos objetos da classe Produto.
     * @return Retorna um valor double que representa o preco total calculado para a compra do usuario.
     */
    public double getPrecoTotal() {
        return precoTotal;
    }


    /**
     *
     * @return
     */
    public int tamanhoLista() {
        return listaDeProdutos.size();
    }

    /**
     *
     * @return
     */
    public ArrayList getListaDeProdutos() {
        return listaDeProdutos;
    }

    /**
     *
     * @param indiceProduto
     * @return
     */
    public Produto retornarProduto(int indiceProduto) {
        return listaDeProdutos.get(indiceProduto);
    }

}
