
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectClientes {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
        String username = "seu_usuario";
        String password = "sua_senha";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM clientes";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");

                System.out.println("Nome: " + nome);
                System.out.println("Email: " + email);
                System.out.println("-----------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

