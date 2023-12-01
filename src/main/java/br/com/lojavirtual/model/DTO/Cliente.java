package br.com.lojavirtual.model.DTO;

public class Cliente extends Usuario {
    private int id;
    private String email;
    private Number telefone;
    private String endereco;
    private String cep;
    private int userId;
    public Cliente(int id, String nome, String username, String senha, String tipo, boolean ativo, int id2,
            String email, Number telefone, String endereco, String cep, int userId) {
        super(id, nome, username, senha, tipo, ativo);
        id = id2;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cep = cep;
        this.userId = userId;
    }
    public Cliente(int id, String email, Number telefone, String endereco, String cep, int userId) {
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
    public Number getTelefone() {
        return telefone;
    }
    public void setTelefone(Number telefone) {
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
    @Override
    public String toString() {
        return "Cliente [id=" + id + ", email=" + email + ", telefone=" + telefone + ", endereco=" + endereco + ", cep="
                + cep + ", userId=" + userId + "]";
    }
}
