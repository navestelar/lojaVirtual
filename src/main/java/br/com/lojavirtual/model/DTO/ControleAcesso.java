package br.com.lojavirtual.model.DTO;

public class ControleAcesso {
    private int id;
    private String usuario;
    private String senha;
    private String permissoes;
    public ControleAcesso(int id, String usuario, String senha, String permissoes) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
        this.permissoes = permissoes;
    }
    public ControleAcesso() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getPermissoes() {
        return permissoes;
    }
    public void setPermissoes(String permissoes) {
        this.permissoes = permissoes;
    }
    @Override
    public String toString() {
        return "ControleAcesso [id=" + id + ", usuario=" + usuario + ", senha=" + senha + ", permissoes=" + permissoes
                + "]";
    }
}
