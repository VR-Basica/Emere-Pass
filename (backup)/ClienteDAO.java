


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    
    public Cliente create(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO clientes (nome, email, senha) VALUES (?, ?, ?);";

        try (Connection connection = Conexao.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getEmail());
            preparedStatement.setString(3, cliente.getSenha());

            int linhasAfetadas = preparedStatement.executeUpdate();

            if (linhasAfetadas > 0) {
                ResultSet rs = preparedStatement.getGeneratedKeys();
                if (rs.next()) {
                    cliente.setId(rs.getInt(1));
                }
                rs.close();
                return cliente;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao criar cliente", e);
        }
    }

    public Cliente update(Cliente cliente) throws SQLException {
        String sql = "UPDATE clientes SET nome = ?, email = ?, senha = ? WHERE id = ?;";

        try (Connection connection = Conexao.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getEmail());
            statement.setString(3, cliente.getSenha());
            statement.setInt(4, cliente.getId());

            int linhasAfetadas = statement.executeUpdate();

            if (linhasAfetadas > 0) {
                return cliente;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar cliente", e);
        }
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM clientes WHERE id = ?;";

        try (Connection connection = Conexao.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao excluir cliente", e);
        }
    }

    public Cliente findById(Integer id) {
        String sql = "SELECT * FROM clientes WHERE id = ?;";

        try (Connection connection = Conexao.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return resultSetToCliente(rs);
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar cliente por ID", e);
        }

        return null;
    }

    public List<Cliente> findAll() {
        String sql = "SELECT * FROM clientes;";
        List<Cliente> clientes = new ArrayList<>();

        try (Connection connection = Conexao.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                clientes.add(resultSetToCliente(rs));
            }

            return clientes;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar todos os clientes", e);
        }
    }

    private Cliente resultSetToCliente(ResultSet rs) throws SQLException {
        return new Cliente(
            rs.getInt("id"),
            rs.getString("nome"),
            rs.getString("email"),
            rs.getString("senha")
        );
    }
}
