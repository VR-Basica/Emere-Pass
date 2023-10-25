package DAO;

import java.util.Date;

public class Ficha {
    private int id;
    private Date dataDaCompra;
    private int quantidade;
    private String historico;

    public Ficha(int id, Date dataDaCompra, int quantidade, String historico) {
        this.id = id;
        this.dataDaCompra = dataDaCompra;
        this.quantidade = quantidade;
        this.historico = historico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataDaCompra() {
        return dataDaCompra;
    }

    public void setDataDaCompra(Date dataDaCompra) {
        this.dataDaCompra = dataDaCompra;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    @Override
    public String toString() {
        return "Ficha [id=" + id + ", dataDaCompra=" + dataDaCompra + ", quantidade=" + quantidade + ", historico=" + historico + "]";
    }

    public static void main(String[] args) {
        Ficha ficha1 = new Ficha(1, new Date(), 10, "Compra de produtos");
        Ficha ficha2 = new Ficha(2, new Date(), 5, "Serviços de manutenção");

        System.out.println("Detalhes da Ficha 1: " + ficha1);
        System.out.println("Detalhes da Ficha 2: " + ficha2);
    }
}
