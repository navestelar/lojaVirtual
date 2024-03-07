package br.com.lojavirtual.model.DTO;

import com.google.gson.annotations.SerializedName;

import br.com.lojavirtual.interfaces.UserType;

public class Cliente extends Usuario {
    private int cliente_id;
    private String email;
    private String telefone;
    private String endereco;
    private String cep;
    @SerializedName("usuario_id_cliente")
    private int usuario_id;

    public Cliente(String nome, String username, String senha, UserType tipo, boolean ativo) {
      super(nome, username, senha, tipo, ativo);
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

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public String getSenha() {
        return super.getSenha();
    }

    @Override
    public String getTipo() {
        return super.getTipo();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public boolean isAtivo() {
        return super.isAtivo();
    }

    @Override
    public void setAtivo(boolean ativo) {
        super.setAtivo(ativo);
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }

    @Override
    public void setSenha(String senha) {
        super.setSenha(senha);
    }

    @Override
    public void setTipo(UserType tipo) {
        super.setTipo(tipo);
    }

    @Override
    public void setUsername(String username) {
        super.setUsername(username);
    }

    @Override
    public String toString() {
        return "Cliente [id=" + cliente_id + ", nome="+ getNome() + ", username=" + getUsername() + ", ativo=" + isAtivo() + ", email=" + email + ", telefone=" + telefone + ", endereco="
                + endereco + ", cep=" + cep + ", user id=" + usuario_id + "]";
    }
}
