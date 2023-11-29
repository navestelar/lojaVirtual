package br.com.lojavirtual.model;

public class FormasPagamento {
    private int id;
    private String tipo;
    public FormasPagamento(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }
    public FormasPagamento() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    @Override
    public String toString() {
        return "FormasPagamento [id=" + id + ", tipo=" + tipo + "]";
    }
}
