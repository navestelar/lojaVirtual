package br.com.lojavirtual.model.DTO;

import java.sql.Date;

public class LogAcoes {
    private int id;
    private String acao;
    private Date data;
    private int userId;
    public LogAcoes(int id, String acao, Date data, int userId) {
        this.id = id;
        this.acao = acao;
        this.data = data;
        this.userId = userId;
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
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    @Override
    public String toString() {
        return "LogAcoes [id=" + id + ", acao=" + acao + ", data=" + data + ", userId=" + userId + "]";
    }
}
