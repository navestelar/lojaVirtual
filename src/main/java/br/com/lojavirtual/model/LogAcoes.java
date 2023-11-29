package br.com.lojavirtual.model;

public class LogAcoes {
    private int id;
    private String acao;
    private String data;
    private int idUsuario;
    public LogAcoes(int id, String acao, String data, int idUsuario) {
        this.id = id;
        this.acao = acao;
        this.data = data;
        this.idUsuario = idUsuario;
    }
    public LogAcoes() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAcao() {
        return acao;
    }
    public void setAcao(String acao) {
        this.acao = acao;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    @Override
    public String toString() {
        return "LogAcoes [id=" + id + ", acao=" + acao + ", data=" + data + ", idUsuario=" + idUsuario + "]";
    }
}
