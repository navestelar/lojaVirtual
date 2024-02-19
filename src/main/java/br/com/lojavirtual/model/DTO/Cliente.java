package br.com.lojavirtual.model.DTO;

public class Cliente extends Usuario {
    private int cliente_id;
    private String email;
    private String telefone;
    private String endereco;
    private String cep;
    private int usuario_id;

    public Cliente(int id, String nome, String username, String senha, String tipo, boolean ativo, int id2,
            String email, String telefone, String endereco, String cep, int userId) {
        super(id, nome, username, senha, tipo, ativo);
        id = id2;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cep = cep;
        this.usuario_id = userId;
    }
    public Cliente(int id, String email, String telefone, String endereco, String cep, int userId) {
        this.cliente_id = id;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cep = cep;
        this.usuario_id = userId;
    }
    public Cliente() {
    }
    public int getId() {
        return cliente_id;
    }
    public void setId(int id) {
        this.cliente_id = id;
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
        return usuario_id;
    }
    public void setUserId(int userId) {
        this.usuario_id = userId;
    }
}
