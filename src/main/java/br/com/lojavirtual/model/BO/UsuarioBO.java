package br.com.lojavirtual.model.BO;

import java.util.HashMap;

import br.com.lojavirtual.model.DAO.UsuarioDAO;
import br.com.lojavirtual.model.DTO.Usuario;

public class UsuarioBO {
    public boolean inserir(Usuario usuario) {
        if  (!existe(usuario)) {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            return usuarioDAO.inserir(usuario);
        }
        return false;
    }

    public boolean alterar(Usuario usuario) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.alterar(usuario);
    }

    public boolean excluir(Usuario usuario) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.excluir(usuario);
    }

    public Usuario procurarPorId(int id) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.procurarPorId(id);
    }

    public Usuario procurarPorUsername(String username) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.procurarPorUsername(username);
    }

    public boolean existe(Usuario usuario) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.existe(usuario);
    }

    public boolean existePorId(int id) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.existePorId(id);
    }

    public boolean existePorUsername(String username) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.existePorUsername(username);
    }

    public HashMap<String, Usuario> listarUsuarios() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.listarUsuarios();
    }
}
