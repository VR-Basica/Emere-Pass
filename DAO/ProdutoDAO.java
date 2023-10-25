package DAO;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private List<Produto> produtos;
    private int nextId = 1;

    public ProdutoDAO() {
        produtos = new ArrayList<>();
    }

    public void create(Produto produto) {
        produto.setId(nextId++);
        produtos.add(produto);
    }

    public void delete(int id) {
        produtos.removeIf(produto -> produto.getId() == id);
    }

    public Produto findById(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null; // Produto não encontrado
    }

    public void update(Produto produto) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId() == produto.getId()) {
                produtos.set(i, produto);
                break;
            }
        }
    }

    public List<Produto> findAll() {
        return produtos;
    }

    public static void main(String[] args) {
        ProdutoDAO produtoDAO = new ProdutoDAO();

        Produto produto1 = new Produto("Produto A", 29.99, "Eletrônicos");
        Produto produto2 = new Produto("Produto B", 19.99, "Roupas");

        produtoDAO.create(produto1);
        produtoDAO.create(produto2);

        System.out.println("Detalhes do Produto 1: " + produtoDAO.findById(1));
        System.out.println("Detalhes do Produto 2: " + produtoDAO.findById(2));

        Produto produtoAtualizado = new Produto(2, "Produto B Atualizado", 24.99, "Roupas");
        produtoDAO.update(produtoAtualizado);

        System.out.println("Produto 2 Atualizado: " + produtoDAO.findById(2));

        produtoDAO.delete(1);
        System.out.println("Lista de Produtos: " + produtoDAO.findAll());
    }
}

