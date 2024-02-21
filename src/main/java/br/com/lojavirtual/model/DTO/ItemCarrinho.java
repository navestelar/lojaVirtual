package br.com.lojavirtual.model.DTO;

import br.com.lojavirtual.interfaces.DefaultEntitiesInterface;

public class ItemCarrinho implements DefaultEntitiesInterface {
    private int itemcarrinho_id;
    private int quantidade;
    private int produto_id;
    private int carrinho_id;

    public ItemCarrinho(int quantidade, int produtoId, int carrinhoId) {
        this.quantidade = quantidade;
        this.produto_id = produtoId;
        this.carrinho_id = carrinhoId;
    }
    public ItemCarrinho() {
    }
    public int getId() {
        return itemcarrinho_id;
    }
    public void setId(int id) {
        this.itemcarrinho_id = id;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public int getProdutoId() {
        return produto_id;
    }
    public void setProdutoId(int produtoId) {
        this.produto_id = produtoId;
    }
    public int getCarrinhoId() {
        return carrinho_id;
    }
    public void setCarrinhoId(int carrinhoId) {
        this.carrinho_id = carrinhoId;
    }
    @Override
    public String toString() {
        return "ItemCarrinho [id=" + itemcarrinho_id + ", quantidade=" + quantidade + ", produtoId=" + produto_id + ", carrinhoId="
                + carrinho_id + "]";
    }
}
