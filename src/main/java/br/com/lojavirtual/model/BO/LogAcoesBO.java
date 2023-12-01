package br.com.lojavirtual.model.BO;

import java.util.HashMap;

import br.com.lojavirtual.model.DAO.LogAcoesDAO;
import br.com.lojavirtual.model.DTO.LogAcoes;

public class LogAcoesBO {
    public boolean inserir(LogAcoes logAcoes) {
        if  (!existe(logAcoes)) {
            LogAcoesDAO logAcoesDAO = new LogAcoesDAO();
            return logAcoesDAO.inserir(logAcoes);
        } 
        
        if (existePorAcao(logAcoes.getAcao())) {
            System.out.println("Já existe um usuário com esse acao");
        }

        return false;
    }

    public boolean alterar(LogAcoes logAcoes) {
        if (existe(logAcoes)) {
            LogAcoesDAO logAcoesDAO = new LogAcoesDAO();
            return logAcoesDAO.alterar(logAcoes);
        }
        System.err.println("Esse usuário não existe");
        return false;
    }

    public boolean excluir(LogAcoes logAcoes) {
        LogAcoesDAO logAcoesDAO = new LogAcoesDAO();
        return logAcoesDAO.excluir(logAcoes);
    }

    public LogAcoes procurarPorId(int id) {
        LogAcoesDAO logAcoesDAO = new LogAcoesDAO();
        return logAcoesDAO.procurarPorId(id);
    }

    public LogAcoes procurarPorAcao(String acao) {
        LogAcoesDAO logAcoesDAO = new LogAcoesDAO();
        return logAcoesDAO.procurarPorAcao(acao);
    }

    public boolean existe(LogAcoes logAcoes) {
        LogAcoesDAO logAcoesDAO = new LogAcoesDAO();
        return logAcoesDAO.existe(logAcoes);
    }

    public boolean existePorId(int id) {
        LogAcoesDAO logAcoesDAO = new LogAcoesDAO();
        return logAcoesDAO.existePorId(id);
    }

    public boolean existePorAcao(String acao) {
        LogAcoesDAO logAcoesDAO = new LogAcoesDAO();
        return logAcoesDAO.existePorAcao(acao);
    }

    public HashMap<String, LogAcoes> listarLogAcoess() {
        LogAcoesDAO logAcoesDAO = new LogAcoesDAO();
        return logAcoesDAO.listarLogAcoess();
    }
}
