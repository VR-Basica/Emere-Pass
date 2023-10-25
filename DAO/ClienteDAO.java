package DAO;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private List<Cliente> clientes;
    private int nextId = 1;

    public ClienteDAO() {
        clientes = new ArrayList<>();
    }

    public void create(Cliente cliente) {
        cliente.setId(nextId++);
        clientes.add(cliente);
    }

    public Cliente findById(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null; // Cliente não encontrado
    }

    public List<Cliente> findAll() {
        return clientes;
    }

    public void update(Cliente cliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == cliente.getId()) {
                clientes.set(i, cliente);
                break;
            }
        }
    }

    public void delete(int id) {
        clientes.removeIf(cliente -> cliente.getId() == id);
    }

    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();

        Cliente cliente1 = new Cliente("João", "joao@example.com", "senha123");
        Cliente cliente2 = new Cliente("Maria", "maria@example.com", "senha456");

        clienteDAO.create(cliente1);
        clienteDAO.create(cliente2);

        System.out.println("Detalhes do Cliente 1: " + clienteDAO.findById(1));
        System.out.println("Detalhes do Cliente 2: " + clienteDAO.findById(2));
    }
}
