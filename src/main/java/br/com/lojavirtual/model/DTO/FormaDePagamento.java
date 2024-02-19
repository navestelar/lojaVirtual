package br.com.lojavirtual.model.DTO;

public class FormaDePagamento {
    private int formaPagamento_id;
    private String tipo;
    public FormaDePagamento(int id, String tipo) {
        this.formaPagamento_id = id;
        this.tipo = tipo;
    }
    public FormaDePagamento() {
    }
    public int getId() {
        return formaPagamento_id;
    }
    public void setId(int id) {
        this.formaPagamento_id = id;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    @Override
    public String toString() {
        return "FormaPagamento [id=" + formaPagamento_id + ", tipo=" + tipo + "]";
    }
}
