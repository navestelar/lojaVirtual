package br.com.lojavirtual.model.DTO;

public class Fornecedor implements DefaultInterface {
    private int fornecedor_id;
    private String nome;
    private String contato;
    public Fornecedor(int id, String nome, String contato) {
        this.fornecedor_id = id;
        this.nome = nome;
        this.contato = contato;
    }
    public Fornecedor() {
    }
    public int getId() {
        return fornecedor_id;
    }
    public void setId(int id) {
        this.fornecedor_id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getContato() {
        return contato;
    }
    public void setContato(String contato) {
        this.contato = contato;
    }
    @Override
    public String toString() {
        return "Fornecedor [id=" + fornecedor_id + ", nome=" + nome + ", contato=" + contato + "]";
    }
}
