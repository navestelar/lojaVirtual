package br.com.lojavirtual.model.DTO;

import br.com.lojavirtual.interfaces.DefaultEntitiesInterface;

public class Carrinho implements DefaultEntitiesInterface {
    private int carrinho_id;
    private int cliente_id;
    private String formaDePagamento;

    public Carrinho(int clienteId, String formaPagamento) {
        this.cliente_id = clienteId;
        this.formaDePagamento = formaPagamento;
    }
    public Carrinho() {
    }
    public int getId() {
        return carrinho_id;
    }
    public void setId(int id) {
        this.carrinho_id = id;
    }
    public int getClienteId() {
        return cliente_id;
    }
    public void setClienteId(int clienteId) {
        this.cliente_id = clienteId;
    }
    public String getFormaPagamento() {
        return formaDePagamento;
    }
    public void setFormaPagamento(String formaPagamento) {
        this.formaDePagamento = formaPagamento;
    }
    @Override
    public String toString() {
        return "Carrinho [id=" + carrinho_id + ", clienteId=" + cliente_id + ", formaPagamentoId=" + formaDePagamento + "]";
    }    
}
