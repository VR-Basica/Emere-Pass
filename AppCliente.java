
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AppCliente {
    public static void main(String[] args) {

       Cliente cliente = new Cliente("pedro", "pedro@email.com", "pedro123456" );
       ClienteDAO

        //List<Produto> cardapio = new ArrayList<>();
        //cardapio.add(new Produto("Bolo de Chocolate", 12.99, "Doces"));
        //cardapio.add(new Produto("Coxinha", 3.50, "Salgados"));
        //cardapio.add(new Produto("Refrigerante", 4.99, "Bebidas"));

        // Scanner scanner = new Scanner(System.in);
        // System.out.print("Digite seu nome: ");
        // String nomeCliente = scanner.nextLine();

        // Cliente cliente = new Cliente(nomeCliente);

        // System.out.println("Bem-vindo, " + cliente.getNome() + "!");
        // System.out.println("Cardápio:");
        // for (Produto produto : cardapio) {
        //     System.out.println("Nome: " + produto.getNome());
        //     System.out.println("Preço: R$" + produto.getPreco());
        //     System.out.println("Categoria: " + produto.getCategoria());
        //     System.out.println("-----------------------------");
        // }

        // boolean continuarPedido = true;
        // while (continuarPedido) {
        //     System.out.print("Digite o nome do produto que deseja adicionar ao carrinho (ou 'sair' para finalizar): ");
        //     String produtoEscolhido = scanner.nextLine();
            
        //     if (produtoEscolhido.equalsIgnoreCase("sair")) {
        //         continuarPedido = false;
        //         break;
        //     }
            
        //     Produto produtoSelecionado = null;
        //     for (Produto produto : cardapio) {
        //         if (produto.getNome().equalsIgnoreCase(produtoEscolhido)) {
        //             produtoSelecionado = produto;
        //             break;
        //         }
        //     }
            
        //     if (produtoSelecionado != null) {
        //         cliente.adicionarProdutoAoCarrinho(produtoSelecionado);
        //         System.out.println("Produto adicionado ao carrinho!");
        //     } else {
        //         System.out.println("Produto não encontrado no cardápio.");
        //     }
        // }

        // System.out.println("Seu carrinho de compras:");
        // List<Produto> carrinhoDoCliente = cliente.getCarrinho();
        // for (Produto produto : carrinhoDoCliente) {
        //     System.out.println("Nome: " + produto.getNome());
        //     System.out.println("Preço: R$" + produto.getPreco());
        //     System.out.println("Categoria: " + produto.getCategoria());
        //     System.out.println("-----------------------------");
        // }
    }
}