package br.com.lojavirtual.model.DTO;

public class Carrinho {
    private int id;
    private int clienteId;
    private int formaPagamentoId;
    public Carrinho(int id, int clienteId, int formaPagamentoId) {
        this.id = id;
        this.clienteId = clienteId;
        this.formaPagamentoId = formaPagamentoId;
    }
    public Carrinho() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getClienteId() {
        return clienteId;
    }
    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }
    public int getFormaPagamentoId() {
        return formaPagamentoId;
    }
    public void setFormaPagamentoId(int formaPagamentoId) {
        this.formaPagamentoId = formaPagamentoId;
    }
    @Override
    public String toString() {
        return "Carrinho [id=" + id + ", clienteId=" + clienteId + ", formaPagamentoId=" + formaPagamentoId + "]";
    }    
}
