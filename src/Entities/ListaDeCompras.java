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


    Scanner scanner = new Scanner(System.in);

    public void adicionarProduto(String nomeDoProduto, int quantidade) {

        listaDeProdutos.add(new Produto(nomeDoProduto, quantidade));

    }

    public void removerProduto(int indiceItem) {
        listaDeProdutos.remove(indiceItem);
        atualizarPrecoTotal();
    }

    public void precificarProduto(int indiceProduto, double preco) {
        listaDeProdutos.get(indiceProduto).setPreco(preco);
    }

    public void atualizarPrecoTotal() {
        double precoTotal = 0;
        for (int j = 0; j < listaDeProdutos.size(); j++) {
            precoTotal += (listaDeProdutos.get(j).getPreco()) * (listaDeProdutos.get(j).getQuantidade());
        }
        this.precoTotal = precoTotal;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public int tamanhoLista() {
        return listaDeProdutos.size();
    }

    public ArrayList getListaDeProdutos() {
        return listaDeProdutos;
    }

    public Produto retornarProduto(int i) {
        return listaDeProdutos.get(i);
    }

}
