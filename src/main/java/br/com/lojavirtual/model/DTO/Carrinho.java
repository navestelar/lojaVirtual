package br.com.lojavirtual.model.DTO;

import br.com.lojavirtual.interfaces.DefaultEntitiesInterface;

public class Carrinho implements DefaultEntitiesInterface {
    private int carrinho_id;
    private int cliente_id;
    private int formaPagamento_id;

    public Carrinho(int clienteId, int formaPagamentoId) {
        this.cliente_id = clienteId;
        this.formaPagamento_id = formaPagamentoId;
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
    public int getFormaPagamentoId() {
        return formaPagamento_id;
    }
    public void setFormaPagamentoId(int formaPagamentoId) {
        this.formaPagamento_id = formaPagamentoId;
    }
    @Override
    public String toString() {
        return "Carrinho [id=" + carrinho_id + ", clienteId=" + cliente_id + ", formaPagamentoId=" + formaPagamento_id + "]";
    }    
}
