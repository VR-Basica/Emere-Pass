import java.util.ArrayList;
import java.util.List;

class Produto {
    private String nome;
    private double preco;
    private String categoria;

    public Produto(String nome, double preco, String categoria) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getCategoria() {
        return categoria;
    }
}

class Pedido {
    private List<Produto> produtos;
    private String numeroFicha;

    public Pedido() {
        produtos = new ArrayList<>();
        numeroFicha = generateNumeroFicha();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public String getNumeroFicha() {
        return numeroFicha;
    }

    private String generateNumeroFicha() {
        // Implemente aqui a lógica para gerar um número de ficha único
        return "FICHA-001";
    }
}

public class AppPedidos {
    public static void main(String[] args) {
        Pedido pedido = new Pedido();

        Produto produto1 = new Produto("Bolo de Chocolate", 12.99, "Doces");
        Produto produto2 = new Produto("Coxinha", 3.50, "Salgados");
        Produto produto3 = new Produto("Refrigerante", 4.99, "Bebidas");

        pedido.adicionarProduto(produto1);
        pedido.adicionarProduto(produto2);
        pedido.adicionarProduto(produto3);

        List<Produto> produtosDoPedido = pedido.getProdutos();

        System.out.println("Ficha de Retirada: " + pedido.getNumeroFicha());
        System.out.println("Produtos:");
        for (Produto produto : produtosDoPedido) {
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Preço: R$" + produto.getPreco());
            System.out.println("Categoria: " + produto.getCategoria());
            System.out.println("-----------------------------");
        }
    }
}
