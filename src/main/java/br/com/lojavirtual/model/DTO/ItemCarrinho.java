package br.com.lojavirtual.model.DTO;

public class ItemCarrinho {
    private int id;
    private int quantidade;
    private int produtoId;
    private int carrinhoId;
    public ItemCarrinho(int id, int quantidade, int produtoId, int carrinhoId) {
        this.id = id;
        this.quantidade = quantidade;
        this.produtoId = produtoId;
        this.carrinhoId = carrinhoId;
    }
    public ItemCarrinho() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public int getProdutoId() {
        return produtoId;
    }
    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }
    public int getCarrinhoId() {
        return carrinhoId;
    }
    public void setCarrinhoId(int carrinhoId) {
        this.carrinhoId = carrinhoId;
    }
    @Override
    public String toString() {
        return "ItemCarrinho [id=" + id + ", quantidade=" + quantidade + ", produtoId=" + produtoId + ", carrinhoId="
                + carrinhoId + "]";
    }
}
