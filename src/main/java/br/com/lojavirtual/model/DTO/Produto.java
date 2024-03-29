package br.com.lojavirtual.model.DTO;

import java.math.BigDecimal;

import br.com.lojavirtual.interfaces.DefaultEntitiesInterface;

public class Produto implements DefaultEntitiesInterface {
    private int produto_id;
    private String nome;
    private String descricao;
    private int qtdEstoque;
    private BigDecimal preco;
    private boolean ativo;
    private int fornecedor_id;

    public Produto(String nome, String descricao, int qtdEstoque, double preco, boolean ativo, int fornecedor_id) {
        this.nome = nome;
        this.descricao = descricao;
        this.qtdEstoque = qtdEstoque;
        this.preco = BigDecimal.valueOf(preco);
        this.ativo = ativo;
        this.fornecedor_id = fornecedor_id;
    }

    public Produto() {
    }

    public int getId() {
        return produto_id;
    }

    public void setId(int produto_id) {
        this.produto_id = produto_id;
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

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = BigDecimal.valueOf(preco);
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public int getFornecedor_id() {
        return fornecedor_id;
    }

    public void setFornecedor_id(int fornecedor_id) {
        this.fornecedor_id = fornecedor_id;
    }

    @Override
    public String toString() {
        return "Produto [produto_id=" + produto_id + ", nome=" + nome + ", descricao=" + descricao + ", qtdEstoque="
                + qtdEstoque + ", preco=" + preco + ", ativo=" + ativo + ", fornecedor_id=" + fornecedor_id + "]";
    }
}
