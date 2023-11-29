package br.com.lojavirtual.model;

public class Cliente extends Usuario {
    private String email;
    private String telefone;
    private String endereco;
    private String cep;
    public Cliente(int id, String nome, String username, String senha, String tipo, boolean ativo, String email,
            String telefone, String endereco, String cep) {
        super(id, nome, username, senha, tipo, ativo);
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cep = cep;
    }

    public Cliente() {
    }

    public Cliente(String email, String telefone, String endereco, String cep) {
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cep = cep;
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

    @Override
    public String toString() {
        return "Cliente [email=" + email + ", telefone=" + telefone + ", endereco=" + endereco + ", cep=" + cep + "]"+super.toString();
    }
    
}
