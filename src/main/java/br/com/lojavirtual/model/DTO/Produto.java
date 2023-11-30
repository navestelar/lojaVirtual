package br.com.lojavirtual.model.DTO;

public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private float preco; 
    private int qtdEstoque;
    private boolean ativo;
    
    public Produto(int id, String nome, String descricao, float preco, int qtdEstoque, boolean ativo) {
        this.setId(id);
        this.setNome(nome);
        this.setDescricao(descricao);
        this.setPreco(preco);
        this.setQtdEstoque(qtdEstoque);
        this.setAtivo(ativo);
    }

    public Produto() {
    }
    
    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        if(qtdEstoque>=0)
            this.qtdEstoque = qtdEstoque;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if(nome != null)
            this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        if(descricao != null)
            this.descricao = descricao;
    }
    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        if(preco>0)
            this.preco = preco;
    }
    public boolean isAtivo() {
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Produto {id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco
                + ", qtdEstoque=" + qtdEstoque + ", ativo=" + ativo + "}";
    }
}
