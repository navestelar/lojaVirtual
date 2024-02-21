package br.com.lojavirtual.model.DTO;

import com.google.gson.annotations.SerializedName;

import br.com.lojavirtual.interfaces.DefaultEntitiesInterface;

public class ControleAcesso implements DefaultEntitiesInterface {
    private int controleAcesso_id;
    private String permissoes;
    @SerializedName("usuario_id_controleacesso")
    private int usuario_id;
    public ControleAcesso(String permissoes, int userId) {
        this.permissoes = permissoes;
        this.usuario_id = userId;
    }
    public ControleAcesso() {
    }
    public int getId() {
        return controleAcesso_id;
    }
    public void setId(int id) {
        this.controleAcesso_id = id;
    }
    public String getPermissoes() {
        return permissoes;
    }
    public void setPermissoes(String permissoes) {
        this.permissoes = permissoes;
    }
    public int getUserId() {
        return usuario_id;
    }
    public void setUserId(int userId) {
        this.usuario_id = userId;
    }
    @Override
    public String toString() {
        return "ControleAcesso [id=" + controleAcesso_id + ", permissoes=" + permissoes + ", userId=" + usuario_id + "]";
    }
}
