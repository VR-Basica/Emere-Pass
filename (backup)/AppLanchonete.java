
import java.util.List;

public class AppLanchonete {
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
