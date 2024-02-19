package br.com.lojavirtual.model.DTO;

public class Imagem implements DefaultInterface {
    private int imagem_id;
    private String url;
    private String descricao;
    private int produto_id;
    public Imagem(int id, String url, String descricao, int produtoId) {
        this.imagem_id = id;
        this.url = url;
        this.descricao = descricao;
        this.produto_id = produtoId;
    }
    public Imagem() {
    }
    public int getId() {
        return imagem_id;
    }
    public void setId(int id) {
        this.imagem_id = id;
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
        return produto_id;
    }
    public void setProdutoId(int produtoId) {
        this.produto_id = produtoId;
    }
    @Override
    public String toString() {
        return "Imagem [id=" + imagem_id + ", url=" + url + ", descricao=" + descricao + ", produtoId=" + produto_id + "]";
    }
}
