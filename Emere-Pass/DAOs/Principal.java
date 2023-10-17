package DAO;


import java.sql.SQLException;

public class Principal {

    public static void main(String[] args) throws SQLException {
        ClienteDAO ClienteDao = new ClienteDAO();
        
        Cliente cliente = new Cliente("Pedro", "pedro@email.com", "123456");

        Cliente ClienteCriado = clienteDAO.create(cliente);

        System.out.println(ClienteCriado.getId());

        System.out.println(ClienteDao.findById(2));
    }
    
}
