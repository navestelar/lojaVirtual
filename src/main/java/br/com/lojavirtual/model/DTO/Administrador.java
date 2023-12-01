package br.com.lojavirtual.model.DTO;

public class Administrador extends Usuario {
    private int id;
    private int userId;
    public Administrador(int id, String nome, String username, String senha, String tipo, boolean ativo, int id2,
            int userId) {
        super(id, nome, username, senha, tipo, ativo);
        id = id2;
        this.userId = userId;
    }
    public Administrador(int id, int userId) {
        this.id = id;
        this.userId = userId;
    }
    public Administrador() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    @Override
    public String toString() {
        return "Administrador [id=" + id + ", userId=" + userId + "]";
    }
}
