package br.com.lojavirtual.model.DTO;

import br.com.lojavirtual.interfaces.DefaultEntitiesInterface;

public class FormaDePagamento implements DefaultEntitiesInterface {
    private int formaPagamento_id;
    private String tipo;
    public FormaDePagamento(String tipo) {
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
