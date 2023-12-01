package br.com.lojavirtual.model.DTO;

public class ControleAcesso {
    private int id;
    private String permissoes;
    private int userId;
    public ControleAcesso(int id, String permissoes, int userId) {
        this.id = id;
        this.permissoes = permissoes;
        this.userId = userId;
    }
    public ControleAcesso() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPermissoes() {
        return permissoes;
    }
    public void setPermissoes(String permissoes) {
        this.permissoes = permissoes;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    @Override
    public String toString() {
        return "ControleAcesso [id=" + id + ", permissoes=" + permissoes + ", userId=" + userId + "]";
    }
}
