package br.com.lojavirtual.model;

public class Imagem {
    private int id;
    private String url;
    private String descricao;

    public Imagem() {
    }
    public Imagem(int id, String url, String descricao) {
        this.setId(id);
        this.setUrl(url);
        this.setDescricao(descricao);
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
        if (url != null)
            this.url = url;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        if (descricao != null)
            this.descricao = descricao;
    }
    @Override
    public String toString() {
        return "Imagem [id=" + id + ", url=" + url + ", descricao=" + descricao + "]";
    }
}
