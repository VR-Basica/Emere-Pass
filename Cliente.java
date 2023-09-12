import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private List<Produto> carrinho;
    
    public Cliente(String nome) {
        this.nome = nome;
        carrinho = new ArrayList<>();
    }

    public void adicionarProdutoAoCarrinho(Produto produto) {
        carrinho.add(produto);
    }

    public List<Produto> getCarrinho() {
        return carrinho;
    }

    public String getNome() {
        return nome;
    }
}