import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Produto {
    private int id;
    private String nome;
    private double preco;
    private String categoria;

    public Produto(int id, String nome, double preco, String categoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
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
    private int id;
    private List<Produto> produtos;
    private String numeroFicha;

    public Pedido(int id) {
        this.id = id;
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
    private Connection connection;

    public Lanchonete(Connection connection) {
        this.connection = connection;
    }

    public void adicionarProduto(String nome, double preco, String categoria) {
        try {
            String sql = "INSERT INTO produtos (nome, preco, categoria) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nome);
            statement.setDouble(2, preco);
            statement.setString(3, categoria);
            statement.executeUpdate();
            System.out.println("Produto adicionado com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterarPreco(String nome, double novoPreco) {
        try {
            String sql = "UPDATE produtos SET preco = ? WHERE nome = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, novoPreco);
            statement.setString(2, nome);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Preço do produto atualizado com sucesso.");
            } else {
                System.out.println("Produto não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void visualizarPedidos() {
        try {
            String sql = "SELECT * FROM pedidos";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int pedidoId = resultSet.getInt("id");
                String numeroFicha = resultSet.getString("numero_ficha");
                System.out.println("Ficha de Retirada: " + numeroFicha);
                System.out.println("Produtos:");
                List<Produto> produtosDoPedido = getProdutosDoPedido(pedidoId);
                for (Produto produto : produtosDoPedido) {
                    System.out.println("Nome: " + produto.getNome());
                    System.out.println("Preço: R$" + produto.getPreco());
                    System.out.println("Categoria: " + produto.getCategoria());
                    System.out.println("-----------------------------");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<Produto> getProdutosDoPedido(int pedidoId) {
        List<Produto> produtos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM pedidos_produtos WHERE pedido_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, pedidoId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int produtoId = resultSet.getInt("produto_id");
                Produto produto = getProdutoById(produtoId);
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
    }

    private Produto getProdutoById(int id) {
        try {
            String sql = "SELECT * FROM produtos WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                double preco = resultSet.getDouble("preco");
                String categoria = resultSet.getString("categoria");
                return new Produto(id, nome, preco, categoria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void atualizarCardapio() {
        try {
            String sql = "SELECT * FROM produtos";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println("Cardápio:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                double preco = resultSet.getDouble("preco");
                String categoria = resultSet.getString("categoria");
                System.out.println("Nome: " + nome);
                System.out.println("Preço: R$" + preco);
                System.out.println("Categoria: " + categoria);
                System.out.println("-----------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

public class AppLanchonete {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/lanchonete_db";
        String username = "seu_usuario";
        String password = "sua_senha";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            Lanchonete lanchonete = new Lanchonete(connection);

            lanchonete.adicionarProduto("Bolo de Chocolate", 12.99, "Doces");
            lanchonete.adicionarProduto("Coxinha", 3.50, "Salgados");
            lanchonete.adicionarProduto("Refrigerante", 4.99, "Bebidas");

            lanchonete.visualizarPedidos();

            lanchonete.alterarPreco("Coxinha", 4.00);

            lanchonete.visualizarPedidos();

            lanchonete.atualizarCardapio();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
