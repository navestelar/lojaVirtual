package br.com.lojavirtual.model.DTO;

import br.com.lojavirtual.interfaces.DefaultEntitiesInterface;

public class Imagem implements DefaultEntitiesInterface {
    private int imagem_id;
    private String url;
    private String descricao;
    private Integer produto_id;
    public Imagem(String url, String descricao, Integer produtoId) {
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
    public Integer getProdutoId() {
        return produto_id;
    }
    public void setProdutoId(Integer produtoId) {
        this.produto_id = produtoId;
    }
    @Override
    public String toString() {
        return "Imagem [id=" + imagem_id + ", url=" + url + ", descricao=" + descricao + ", produtoId=" + produto_id + "]";
    }
}
