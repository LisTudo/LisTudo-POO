package Entities;

/**
 * Esta classe representa os produtos que serão criados pelo usuario para serem adicionados a lista de compras.
 */
public class Produto {

    private String nome;
    private double preco;
    private int quantidade;

    /**
     * Metodo construtor do objeto produto, recebe como parâmetros o nome e a quantidade do item.
     * @param nome Representa o nome do produto que será criado.
     * @param quantidade Representa a quantidade física do produto a ser criado
     */
    public Produto(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    /**
     * Metodo getter para o atributo nome dos objetos da classe Produto.
     * @return Retorna uma String, nome previamente definido pleo usuario para o objeto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo getter para o atriburo preco dos objetos da classe Produto. E utilizado para retornar o valor dos produtos e realizar o
     * calculo total de cada produto e da compra total do usuario.
     * @return Retorna um valor double, o ultimo preco definido pelo usuario.
     */
    public double getPreco() {
        return preco;
    }


    /**
     * Metodo setter utilizado para definir o preco do produto a partir do metodo precificarProduto() da classe ListaDeCompras e irAoMercado()
     * da classe Sistema.
     * @param preco O usuario deve passar um valor double como parametro a ser atribuido como o preco do produto.
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Metodo getter do atributo quantidade dos objetos da classe Produto.
     * @return Retorna um valor int que representa a quantidade de cada produto, informado pelo usuario ao construir o objeto.
     */
    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        String texto = "";
        if (this.preco != 0) { // Condicional para verificar quando o preco ainda nao foi incluido nos itens da lista
            texto =  this.nome + " x" + this.quantidade + " | R$ " + (this.preco * this.quantidade);
        } else {
            texto =  this.nome + " x" + this.quantidade;
        }
        return texto;
    }
}
