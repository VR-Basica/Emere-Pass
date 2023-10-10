package src.Apps;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class SelectPedidos {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
        String username = "seu_usuario";
        String password = "sua_senha";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM pedidos";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String numeroFicha = resultSet.getString("numero_ficha");

                System.out.println("Número de Ficha: " + numeroFicha);
                System.out.println("-----------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

