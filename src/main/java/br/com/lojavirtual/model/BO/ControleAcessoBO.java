package br.com.lojavirtual.model.BO;

import java.util.HashMap;

import br.com.lojavirtual.model.DAO.ControleAcessoDAO;
import br.com.lojavirtual.model.DTO.ControleAcesso;

public class ControleAcessoBO {
    public boolean inserir(ControleAcesso controleAcesso) {
        if  (!existe(controleAcesso)) {
            ControleAcessoDAO controleAcessoDAO = new ControleAcessoDAO();
            return controleAcessoDAO.inserir(controleAcesso);
        }

        return false;
    }

    public boolean alterar(ControleAcesso controleAcesso) {
        if (existe(controleAcesso)) {
            ControleAcessoDAO controleAcessoDAO = new ControleAcessoDAO();
            return controleAcessoDAO.alterar(controleAcesso);
        }
        System.err.println("Esse usuário não existe");
        return false;
    }

    public boolean excluir(ControleAcesso controleAcesso) {
        ControleAcessoDAO controleAcessoDAO = new ControleAcessoDAO();
        return controleAcessoDAO.excluir(controleAcesso);
    }

    public ControleAcesso procurarPorId(int id) {
        ControleAcessoDAO controleAcessoDAO = new ControleAcessoDAO();
        return controleAcessoDAO.procurarPorId(id);
    }

    public boolean existe(ControleAcesso controleAcesso) {
        ControleAcessoDAO controleAcessoDAO = new ControleAcessoDAO();
        return controleAcessoDAO.existe(controleAcesso);
    }

    public boolean existePorId(int id) {
        ControleAcessoDAO controleAcessoDAO = new ControleAcessoDAO();
        return controleAcessoDAO.existePorId(id);
    }

    public HashMap<Integer, ControleAcesso> listarControleAcessos() {
        ControleAcessoDAO controleAcessoDAO = new ControleAcessoDAO();
        return controleAcessoDAO.listarControleAcessos();
    }
}
