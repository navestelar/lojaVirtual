package br.com.lojavirtual.model.DTO;

import com.google.gson.annotations.SerializedName;

import br.com.lojavirtual.interfaces.DefaultEntitiesInterface;
import br.com.lojavirtual.interfaces.UserType;

public class Usuario implements DefaultEntitiesInterface {
    @SerializedName("userId")
    private int usuario_id;
    private String nome;
    private String username;
    private String senha;
    private String tipo;
    private boolean ativo;

    public Usuario(String nome, String username, String senha, UserType tipo, boolean ativo) {
        this.nome = nome;
        this.username = username;
        this.senha = senha;
        this.tipo = tipo.getLabel();
        this.ativo = ativo;
    }

    public Usuario() {
    }

    public int getId() {
        return usuario_id;
    }

    public void setId(int id) {
        this.usuario_id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(UserType tipo) {
        this.tipo = tipo.getLabel();
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + usuario_id + ", nome=" + nome + ", username=" + username + ", senha=" + senha
                + ", tipo=" + tipo
                + ", ativo=" + ativo + "]";
    }
}