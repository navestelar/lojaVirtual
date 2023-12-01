package br.com.lojavirtual.model.BO;

import java.util.HashMap;

import br.com.lojavirtual.model.DAO.ProdutoDAO;
import br.com.lojavirtual.model.DTO.Produto;

public class ProdutoBO {
    public boolean inserir(Produto produto) {
        if  (!existe(produto)) {
            ProdutoDAO produtoDAO = new ProdutoDAO();
            return produtoDAO.inserir(produto);
        } 
        
        if (existePorNome(produto.getNome())) {
            System.out.println("Já existe um produto com esse nome");
        }

        return false;
    }

    public boolean alterar(Produto produto) {
        if (existe(produto)) {
            ProdutoDAO produtoDAO = new ProdutoDAO();
            return produtoDAO.alterar(produto);
        }
        System.err.println("Esse produto não existe");
        return false;
    }

    public boolean excluir(Produto produto) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.excluir(produto);
    }

    public Produto procurarPorId(int id) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.procurarPorId(id);
    }

    public Produto procurarPorNome(String nome) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.procurarPorNome(nome);
    }

    public boolean existe(Produto produto) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.existe(produto);
    }

    public boolean existePorId(int id) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.existePorId(id);
    }

    public boolean existePorNome(String nome) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.existePorNome(nome);
    }

    public HashMap<String, Produto> listarProdutos() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.listarProdutos();
    }

    public boolean desativarPorId(int id) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.desativarPorId(id);
    }

    public boolean ativarPorId(int id) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.ativarPorId(id);
    }

    public boolean desativarPorNome(String nome) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.desativarPorNome(nome);
    }

    public boolean ativarPorNome(String nome) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.ativarPorNome(nome);
    }
}
