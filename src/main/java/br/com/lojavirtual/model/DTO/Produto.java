package br.com.lojavirtual.model.DTO;

import java.util.HashMap;

public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private int qtdEstoque;
    private float preco;
    private boolean ativo;
    private int fornecedorId;
    private HashMap<Integer, Imagem> imagens;
    public HashMap<Integer, Imagem> getImagens() {
        return imagens;
    }
    public void setImagens(HashMap<Integer, Imagem> imagens) {
        this.imagens = imagens;
    }
    public Produto(int id, String nome, String descricao, int qtdEstoque, float preco, boolean ativo,
            int fornecedorId) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.qtdEstoque = qtdEstoque;
        this.preco = preco;
        this.ativo = ativo;
        this.fornecedorId = fornecedorId;
    }
    public Produto() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getQtdEstoque() {
        return qtdEstoque;
    }
    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }
    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }
    public boolean isAtivo() {
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    public int getFornecedorId() {
        return fornecedorId;
    }
    public void setFornecedorId(int fornecedorId) {
        this.fornecedorId = fornecedorId;
    }
    @Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", qtdEstoque=" + qtdEstoque
                + ", preco=" + preco + ", ativo=" + ativo + ", fornecedorId=" + fornecedorId + "]";
    }
}
