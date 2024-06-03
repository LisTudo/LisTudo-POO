package Entities;

public class Produto {

    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }


    public void definirPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        String texto = "";
        if (preco != 0) { // Condicional para verificar quando o preco ainda nao foi incluido nos itens da lista
            texto =  this.nome + " x" + quantidade + " | R$ " + (preco * quantidade);
        } else {
            texto =  this.nome + " x" + quantidade;
        }
        return texto;
    }
}
