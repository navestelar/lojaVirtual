package br.com.lojavirtual.model.DTO;

import com.google.gson.annotations.SerializedName;

import br.com.lojavirtual.interfaces.UserType;

public class Administrador extends Usuario {
    private int administrador_id;
    @SerializedName("usuario_id_admin")
    private int usuario_id;

    public Administrador(String nome, String username, String senha, UserType tipo, boolean ativo) {
        super(nome, username, senha, tipo, ativo);
    }
    public Administrador(int userId) {
        this.usuario_id = userId;
    }
    public Administrador() {
    }
    public int getId() {
        return administrador_id;
    }
    public void setId(int id) {
        this.administrador_id = id;
    }
    public int getUserId() {
        return usuario_id;
    }
    public void setUserId(int userId) {
        this.usuario_id = userId;
    }
    @Override
    public String toString() {
        return "Administrador [id=" + administrador_id + ", Nome=" + getNome() + ", Username=" + getUsername() + ", Senha=" + getSenha() + ", Ativo=" + isAtivo() + ", userId=" + usuario_id + "]";
    }
}
