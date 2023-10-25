
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class InsertClientes {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
        String username = "seu_usuario";
        String password = "sua_senha";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            String nome = "Novo Cliente";
            String email = "novo@cliente.com";

            String sql = "INSERT INTO clientes (nome, email) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, email);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " linha(s) inserida(s) com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

