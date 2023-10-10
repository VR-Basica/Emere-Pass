
import java.util.ArrayList;
import java.util.List;

class Produto {
    private String nome;
    private double preco;
    private String categoria;

    public Produto(int i, String nome, double preco, String categoria) {
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

