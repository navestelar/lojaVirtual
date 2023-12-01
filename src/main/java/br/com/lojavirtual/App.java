package br.com.lojavirtual;

import br.com.lojavirtual.model.DAO.ProdutoDAO;
import br.com.lojavirtual.model.DAO.UsuarioDAO;
import br.com.lojavirtual.model.DTO.Produto;
import br.com.lojavirtual.model.DTO.Usuario;

public class App 
{
    public static void main( String[] args )
    {
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
        usuarioDAO.inserir(usuario);
        System.out.println(usuarioDAO.procurarPorId(1).toString());
        usuario.setSenha("aaaaaaaaaaa");
        System.out.println(usuario.getUsername());
        usuarioDAO.alterar(usuario);
        System.out.println(usuarioDAO.procurarPorId(1).toString());
        usuarioDAO.desativarPorId(1);
        System.out.println(usuarioDAO.procurarPorId(1).toString());
        usuarioDAO.ativarPorId(1);
        System.out.println(usuarioDAO.procurarPorId(1).toString());
        usuarioDAO.desativarPorUsername("1");
        System.out.println(usuarioDAO.procurarPorId(1).toString());
        System.out.println(usuarioDAO.procurarPorUsername("1").toString());
        for (Usuario user : usuarioDAO.listarUsuarios().values()) {
            System.out.println(user);
        }
    }
}
