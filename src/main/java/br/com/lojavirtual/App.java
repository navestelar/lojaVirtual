package br.com.lojavirtual;

import br.com.lojavirtual.model.BO.ProdutoBO;
import br.com.lojavirtual.model.DAO.ProdutoDAO;
import br.com.lojavirtual.model.BO.ProdutoBO;
import br.com.lojavirtual.model.DTO.Produto;
import br.com.lojavirtual.model.DTO.Produto;

public class App 
{
    public static void main( String[] args )
    {
        Produto produto = new Produto(1, "produto", "descrição", 12, 15.5f, true, 5);
        ProdutoBO produtoBO = new ProdutoBO();
        System.out.println(produtoBO.inserir(produto));
        produto.setNome("nome5");
        System.out.println(produtoBO.alterar(produto));
        System.out.println(produtoBO.excluir(produto));
        produtoBO.inserir(produto);
        System.out.println(produtoBO.procurarPorId(produto.getId()));
        System.out.println(produtoBO.existe(produto));
        System.out.println(produtoBO.existePorId(produto.getId()));
        System.out.println(produtoBO.listarProdutos());
        System.out.println(produtoBO.existePorNome(produto.getNome()));
        System.out.println(produtoBO.desativarPorId(produto.getId()));
        System.out.println(produtoBO.procurarPorNome(produto.getNome()));
        System.out.println(produtoBO.ativarPorId(produto.getId()));
        System.out.println(produtoBO.desativarPorNome(produto.getNome()));
        System.out.println(produtoBO.ativarPorNome(produto.getNome()));
        produto.setDescricao("aaaaaaaaaaaaaaaaaaaaa");
    }
}
