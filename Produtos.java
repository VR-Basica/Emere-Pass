public class Produtos {
    public static void main(String[] args) {
        Lanchonete lanchonete = new Lanchonete();

        lanchonete.adicionarProduto("Bolo de Chocolate", 12.99, "Doces");
        lanchonete.adicionarProduto("Coxinha", 3.50, "Salgados");
        lanchonete.adicionarProduto("Refrigerante", 4.99, "Bebidas");

        lanchonete.visualizarPedidos();

        lanchonete.alterarPreco("Coxinha", 4.00);

        lanchonete.visualizarPedidos();

        lanchonete.atualizarCardapio();
    }
}