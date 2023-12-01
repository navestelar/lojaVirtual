package br.com.lojavirtual.model.DTO;

public class FormaPagamento {
    private int id;
    private String tipo;
    public FormaPagamento(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }
    public FormaPagamento() {
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
        return "FormaPagamento [id=" + id + ", tipo=" + tipo + "]";
    }
}
