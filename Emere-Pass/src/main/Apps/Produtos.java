package src.Apps;
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

    public String getNome() {
        return null;
    }

    public int getId() {
        return 0;
    }

    public String getNome() {
        return null;
    }

    public double getPreco() {
        return 0;
    }

    public String getCategoria() {
        return null;
    }

    public void setId(int int1) {
    }

    public void setNome(String string) {
    }

    public void setPreco(double double1) {
    }

    public void setCategoria(String string) {
    }
}