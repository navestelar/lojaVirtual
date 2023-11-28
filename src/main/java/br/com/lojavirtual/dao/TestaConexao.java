package br.com.lojavirtual.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.lojavirtual.model.Produto;

public class TestaConexao {

    public static void main(String[] args) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produto = new Produto(2, "afasfds", "isdufhsadhf", 50, 5, true);
        produtoDAO.cadastrarProduto(produto);
        System.out.println(produtoDAO.listarProdutos().get(2).getNome());
        Produto produto2 = new Produto(2, "2", "2", 2, 2, false);
        produtoDAO.atualizarProduto(produto2);
        System.out.println(produtoDAO.listarProdutos().get(2).getNome());
    }
}
