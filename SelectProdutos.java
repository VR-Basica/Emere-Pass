import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectProdutos {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
        String username = "seu_usuario";
        String password = "sua_senha";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM produtos";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
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
