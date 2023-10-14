package DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FichaDAO {
    private List<Ficha> fichas;
    private int nextId = 1;

    public FichaDAO() {
        fichas = new ArrayList<>();
    }

    public void create(Ficha ficha) {
        ficha.setId(nextId++);
        fichas.add(ficha);
    }

    public Ficha findById(int id) {
        for (Ficha ficha : fichas) {
            if (ficha.getId() == id) {
                return ficha;
            }
        }
        return null; // Ficha não encontrada
    }

    public void update(Ficha ficha) {
        for (int i = 0; i < fichas.size(); i++) {
            if (fichas.get(i).getId() == ficha.getId()) {
                fichas.set(i, ficha);
                break;
            }
        }
    }

    public void delete(int id) {
        fichas.removeIf(ficha -> ficha.getId() == id);
    }

    public List<Ficha> findAll() {
        return fichas;
    }

    public static void main(String[] args) {
        FichaDAO fichaDAO = new FichaDAO();

        Ficha ficha1 = new Ficha(1, new Date(), 10, "Compra de produtos");
        Ficha ficha2 = new Ficha(2, new Date(), 5, "Serviços de manutenção");

        fichaDAO.create(ficha1);
        fichaDAO.create(ficha2);

        System.out.println("Detalhes da Ficha 1: " + fichaDAO.findById(1));
        System.out.println("Detalhes da Ficha 2: " + fichaDAO.findById(2));

        Ficha fichaAtualizada = new Ficha(2, new Date(), 7, "Serviços de manutenção atualizados");
        fichaDAO.update(fichaAtualizada);

        System.out.println("Ficha 2 Atualizada: " + fichaDAO.findById(2));

        fichaDAO.delete(1);
        System.out.println("Lista de Fichas: " + fichaDAO.findAll());
    }
}
