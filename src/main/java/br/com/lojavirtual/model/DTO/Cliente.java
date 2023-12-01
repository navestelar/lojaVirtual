package br.com.lojavirtual.model.DTO;

import java.util.HashMap;

public class Cliente extends Usuario {
    private int id;
    private String email;
    private String telefone;
    private String endereco;
    private String cep;
    private int userId;
    private HashMap<Integer, Carrinho> carrinhos;
    public HashMap<Integer, Carrinho> getCarrinhos() {
        return carrinhos;
    }
    public void setCarrinhos(HashMap<Integer, Carrinho> carrinhos) {
        this.carrinhos = carrinhos;
    }
    public Cliente(int id, String nome, String username, String senha, String tipo, boolean ativo, int id2,
            String email, String telefone, String endereco, String cep, int userId) {
        super(id, nome, username, senha, tipo, ativo);
        id = id2;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cep = cep;
        this.userId = userId;
    }
    public Cliente(int id, String email, String telefone, String endereco, String cep, int userId) {
        this.id = id;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cep = cep;
        this.userId = userId;
    }
    public Cliente() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
}
