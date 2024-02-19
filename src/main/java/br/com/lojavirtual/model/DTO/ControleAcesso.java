package br.com.lojavirtual.model.DTO;

public class ControleAcesso implements DefaultInterface {
    private int controleAcesso_id;
    private String permissoes;
    private int usuario_id;
    public ControleAcesso(int id, String permissoes, int userId) {
        this.controleAcesso_id = id;
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
