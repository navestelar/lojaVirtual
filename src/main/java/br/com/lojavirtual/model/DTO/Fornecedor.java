package br.com.lojavirtual.model.DTO;

public class Fornecedor {
    private int id;
    private String nome;
    private String contato;
    public Fornecedor(int id, String nome, String contato) {
        this.id = id;
        this.nome = nome;
        this.contato = contato;
    }
    public Fornecedor() {
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
    public String getContato() {
        return contato;
    }
    public void setContato(String contato) {
        this.contato = contato;
    }
    @Override
    public String toString() {
        return "Fornecedor [id=" + id + ", nome=" + nome + ", contato=" + contato + "]";
    }
}
