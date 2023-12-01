package br.com.lojavirtual.model.DTO;

public class Imagem {
    private int id;
    private String url;
    private String descricao;
    private int produtoId;
    public Imagem(int id, String url, String descricao, int produtoId) {
        this.id = id;
        this.url = url;
        this.descricao = descricao;
        this.produtoId = produtoId;
    }
    public Imagem() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getProdutoId() {
        return produtoId;
    }
    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }
    @Override
    public String toString() {
        return "Imagem [id=" + id + ", url=" + url + ", descricao=" + descricao + ", produtoId=" + produtoId + "]";
    }
}
