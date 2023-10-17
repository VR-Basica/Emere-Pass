package DAO;

import java.util.List;

public interface ProdutoDAO {
    public Produto buscarPorId(int id);
    public List<Produto> buscarPorCategoria(String categoria);
    public void inserir(Produto produto);
    public void atualizar(Produto produto);
    public void excluir(Produto produto);
}
