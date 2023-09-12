import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLFiles {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
        String username = "seu_usuario";
        String password = "sua_senha";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            String nome = "Novo Produto";
            double preco = 9.99;
            String categoria = "Outros";

            String sql = "INSERT INTO produtos (nome, preco, categoria) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            preparedStatement.setDouble(2, preco);
            preparedStatement.setString(3, categoria);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " linha(s) inserida(s) com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


