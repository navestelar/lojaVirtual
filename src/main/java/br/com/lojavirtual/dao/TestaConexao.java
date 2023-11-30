package br.com.lojavirtual.dao;

import br.com.lojavirtual.model.Produto;
import br.com.lojavirtual.model.Usuario;
public class TestaConexao {
    public static void main(String[] args) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produto = new Produto(2, "afasfds", "isdufhsadhf", 50, 5, true);
        produtoDAO.cadastrarProduto(produto);
        System.out.println(produtoDAO.listarProdutos().get(2).getNome());
        Produto produto2 = new Produto(2, "2", "2", 2, 2, false);
        produtoDAO.atualizarProduto(produto2);
        System.out.println(produtoDAO.listarProdutos().get(2).getNome());
        Produto busca = produtoDAO.buscarProdutoPorId(2);
        System.out.println(busca.toString());

        Usuario usuario = new Usuario(1, "user", "1", "123", "adm", true);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.criarUsuario(usuario);
        System.out.println(usuarioDAO.buscarUsuarioPorId(1).toString());
        usuario.setSenha("aaaaaaaaaaa");
        System.out.println(usuario.getUsername());
        usuarioDAO.atualizarUsuario(usuario);
        System.out.println(usuarioDAO.buscarUsuarioPorId(1).toString());
        usuarioDAO.desativarUsuarioPorId(1);
        System.out.println(usuarioDAO.buscarUsuarioPorId(1).toString());
        usuarioDAO.ativarUsuarioPorId(1);
        System.out.println(usuarioDAO.buscarUsuarioPorId(1).toString());
        usuarioDAO.desativarUsuarioPorUsername("1");
        System.out.println(usuarioDAO.buscarUsuarioPorId(1).toString());
        System.out.println(usuarioDAO.buscarUsuarioPorUsername("1").toString());
        for (Usuario user : usuarioDAO.listarUsuarios().values()) {
            System.out.println(user);
        }
    }
}
