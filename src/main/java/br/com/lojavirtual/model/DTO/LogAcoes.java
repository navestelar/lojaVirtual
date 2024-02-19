package br.com.lojavirtual.model.DTO;

public class LogAcoes implements DefaultInterface {
    private int log_id;
    private String acao;
    private String log_data;
    private int usuario_id;
    
    public LogAcoes(int id, String acao, String data, int userId) {
        this.log_id = id;
        this.acao = acao;
        this.log_data = data;
        this.usuario_id = userId;
    }
    public LogAcoes() {
    }
    public int getId() {
        return log_id;
    }
    public void setId(int id) {
        this.log_id = id;
    }
    public String getAcao() {
        return acao;
    }
    public void setAcao(String acao) {
        this.acao = acao;
    }
    public int getUserId() {
        return usuario_id;
    }
    public void setUserId(int userId) {
        this.usuario_id = userId;
    }
    @Override
    public String toString() {
        return "LogAcoes [id=" + log_id + ", acao=" + acao + ", data=" + log_data + ", userId=" + usuario_id + "]";
    }
    public String getData() {
        return log_data;
    }
    public void setData(String data) {
        this.log_data = data;
    }
}
