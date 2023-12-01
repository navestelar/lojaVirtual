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
        
        if (existePorUsername(usuario.getUsername())) {
            System.out.println("Já existe um usuário com esse username");
        }

        return false;
    }

    public boolean alterar(Usuario usuario) {
        if (existe(usuario)) {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            return usuarioDAO.alterar(usuario);
        }
        System.err.println("Esse usuário não existe");
        return false;
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

    public boolean desativarPorId(int id) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.desativarPorId(id);
    }

    public boolean ativarPorId(int id) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.ativarPorId(id);
    }

    public boolean desativarPorUsername(String username) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.desativarPorUsername(username);
    }

    public boolean ativarPorUsername(String username) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.ativarPorUsername(username);
    }
    
    public boolean atualizar(Usuario usuario) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.atualizar(usuario);
    }
}
