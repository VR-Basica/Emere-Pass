package DAO;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    private List<Funcionario> funcionarios;
    private int nextId = 1;

    public FuncionarioDAO() {
        funcionarios = new ArrayList<>();
    }

    public void create(Funcionario funcionario) {
        funcionario.setId(nextId++);
        funcionarios.add(funcionario);
    }

    public void delete(int id) {
        funcionarios.removeIf(funcionario -> funcionario.getId() == id);
    }

    public Funcionario findById(int id) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId() == id) {
                return funcionario;
            }
        }
        return null; // Funcionário não encontrado
    }

    public void update(Funcionario funcionario) {
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getId() == funcionario.getId()) {
                funcionarios.set(i, funcionario);
                break;
            }
        }
    }

    public List<Funcionario> findAll() {
        return funcionarios;
    }

    public static void main(String[] args) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        Funcionario funcionario1 = new Funcionario("Lucas", "lucas@email.com", "senha123");
        Funcionario funcionario2 = new Funcionario("Clara", "clara@email.com", "senha456");

        funcionarioDAO.create(funcionario1);
        funcionarioDAO.create(funcionario2);

        System.out.println("Detalhes do Funcionário 1: " + funcionarioDAO.findById(1));
        System.out.println("Detalhes do Funcionário 2: " + funcionarioDAO.findById(2));

        Funcionario funcionarioAtualizado = new Funcionario(2, "Clara Atualizada", "clara@email.com", "senha789");
        funcionarioDAO.update(funcionarioAtualizado);

        System.out.println("Funcionário 2 Atualizado: " + funcionarioDAO.findById(2));

        funcionarioDAO.delete(1);
        System.out.println("Lista de Funcionários: " + funcionarioDAO.findAll());
    }
}

