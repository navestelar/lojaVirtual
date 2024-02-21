package br.com.lojavirtual.model.DTO;

import com.google.gson.annotations.SerializedName;

public class Administrador extends Usuario {
    private int administrador_id;
    @SerializedName("usuario_id_admin")
    private int usuario_id;
    public Administrador(String nome, String username, String senha, String tipo, boolean ativo, int id2,
            int userId) {
        super(nome, username, senha, tipo, ativo);
        this.usuario_id = userId;
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
        return "Administrador [id=" + administrador_id + ", userId=" + usuario_id + "]";
    }
}
