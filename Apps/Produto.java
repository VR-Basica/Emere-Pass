package Apps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public void setPreco(double preco) {
        this.preco = preco;
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

class Lanchonete {
    private Map<String, Produto> cardapio;
    private List<Pedido> pedidos;

    public Lanchonete() {
        cardapio = new HashMap<>();
        pedidos = new ArrayList<>();
    }

    public void adicionarProduto(String nome, double preco, String categoria) {
        Produto produto = new Produto(nome, preco, categoria);
        cardapio.put(nome, produto);
    }

    public void alterarPreco(String nome, double novoPreco) {
        Produto produto = cardapio.get(nome);
        if (produto != null) {
            produto.setPreco(novoPreco);
        } else {
            System.out.println("Produto não encontrado no cardápio.");
        }
    }

    public void visualizarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("Não há pedidos no momento.");
        } else {
            for (Pedido pedido : pedidos) {
                System.out.println("Ficha de Retirada: " + pedido.getNumeroFicha());
                System.out.println("Produtos:");
                List<Produto> produtosDoPedido = pedido.getProdutos();
                for (Produto produto : produtosDoPedido) {
                    System.out.println("Nome: " + produto.getNome());
                    System.out.println("Preço: R$" + produto.getPreco());
                    System.out.println("Categoria: " + produto.getCategoria());
                    System.out.println("-----------------------------");
                }
            }
        }
    }

    public void atualizarCardapio() {
        System.out.println("Cardápio:");
        for (Map.Entry<String, Produto> entry : cardapio.entrySet()) {
            Produto produto = entry.getValue();
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Preço: R$" + produto.getPreco());
            System.out.println("Categoria: " + produto.getCategoria());
            System.out.println("-----------------------------");
        }
    }
}



