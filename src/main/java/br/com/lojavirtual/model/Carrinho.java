package br.com.lojavirtual.model;

public class Carrinho {
    private int id;
    private Cliente cliente;
    private FormasPagamento formaPagamento;
    public Carrinho(int id, Cliente cliente, FormasPagamento formaPagamento) {
        this.id = id;
        this.cliente = cliente;
        this.formaPagamento = formaPagamento;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public FormasPagamento getFormaPagamento() {
        return formaPagamento;
    }
    public void setFormaPagamento(FormasPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    @Override
    public String toString() {
        return "Carrinho [id=" + id + ", cliente=" + cliente + ", formaPagamento=" + formaPagamento + "]";
    }
}
