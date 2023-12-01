package br.com.lojavirtual;

import br.com.lojavirtual.model.BO.UsuarioBO;
import br.com.lojavirtual.model.DAO.ProdutoDAO;
import br.com.lojavirtual.model.BO.UsuarioBO;
import br.com.lojavirtual.model.DTO.Produto;
import br.com.lojavirtual.model.DTO.Usuario;

public class App 
{
    public static void main( String[] args )
    {
        Usuario usuario = new Usuario(1, "user", "1", "123", "adm", true);
        UsuarioBO usuarioBO = new UsuarioBO();
        System.out.println(usuarioBO.inserir(usuario));
        usuario.setNome("nome5");
        System.out.println(usuarioBO.alterar(usuario));
        System.out.println(usuarioBO.excluir(usuario));
        usuarioBO.inserir(usuario);
        System.out.println(usuarioBO.procurarPorId(usuario.getId()));
        System.out.println(usuarioBO.procurarPorUsername(usuario.getUsername()));
        System.out.println(usuarioBO.existe(usuario));
        System.out.println(usuarioBO.existePorId(usuario.getId()));
        System.out.println(usuarioBO.existePorUsername(usuario.getUsername()));
        System.out.println(usuarioBO.listarUsuarios());
        System.out.println(usuarioBO.desativarPorId(usuario.getId()));
        System.out.println(usuarioBO.ativarPorId(usuario.getId()));
        System.out.println(usuarioBO.desativarPorUsername(usuario.getUsername()));
        System.out.println(usuarioBO.ativarPorUsername(usuario.getUsername()));
        usuario.setSenha("aaaaaaaaaaaaaaaaaaaaa");
        System.out.println(usuarioBO.atualizar(usuario));
        for (Usuario u : usuarioBO.listarUsuarios().values()) {
            usuarioBO.excluir(u);
        }
    }
}
