package br.com.lojavirtual.dao;

import br.com.lojavirtual.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProdutoDAO {
    private static final Logger logger = LoggerFactory.getLogger(ProdutoDAO.class);
    public void cadastrarProduto(Produto produto) {
        if (!this.listarProdutos().containsKey(produto.getId()) ) {
            try (Connection connection = ConexaoMySQL.conectar()) {
                String sql = "INSERT INTO produto (produto_id, nome, descricao, preco, qtdEstoque, ativo) VALUES (?, ?, ?, ?, ?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setInt(1, produto.getId());
                    statement.setString(2, produto.getNome());
                    statement.setString(3, produto.getDescricao());
                    statement.setFloat(4, produto.getPreco());
                    statement.setInt(5, produto.getQtdEstoque());
                    statement.setBoolean(6, produto.isAtivo());
                    statement.executeUpdate();
                } finally {
                    ConexaoMySQL.fecharConexao(connection);
                }
            } catch (SQLException e) {
                logger.error("Erro ao cadastrar produto: " + e.getMessage());
                throw new RuntimeException("Erro ao cadastrar produto", e);
            }
        } else {
            logger.error("Já existe um produto com esse id");
        }
    }

    public HashMap<Integer, Produto> listarProdutos() {
        HashMap<Integer, Produto> produtos = new HashMap<Integer, Produto>();
        try (Connection connection = ConexaoMySQL.conectar()) {
            String sql = "SELECT * FROM produto";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Produto produto = new Produto();
                        produto.setId(resultSet.getInt("produto_id"));
                        produto.setNome(resultSet.getString("nome"));
                        produto.setDescricao(resultSet.getString("descricao"));
                        produto.setPreco(resultSet.getFloat("preco"));
                        produto.setQtdEstoque(resultSet.getInt("qtdEstoque"));
                        produto.setAtivo(resultSet.getBoolean("ativo"));
                        produtos.put(produto.getId(), produto);
                    }
                }
            } finally {
                ConexaoMySQL.fecharConexao(connection);
            }
        } catch (SQLException e) {
            logger.error("Erro ao listar produto: " + e.getMessage());
            throw new RuntimeException("Erro ao listar produtos", e);
        }
        return produtos;
    }

    public void excluirProduto(int id) {
        try (Connection connection = ConexaoMySQL.conectar()) {
            String sql = "DELETE FROM produto WHERE produto_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            } finally {
                ConexaoMySQL.fecharConexao(connection);
            }
        } catch (SQLException e) {
            logger.error("Erro ao excluir produto: " + e.getMessage());
            throw new RuntimeException("Erro ao excluir produto", e);
        } finally {
            logger.warn("Produto excluído com sucesso");
        }
    }

    public void atualizarProduto(Produto produto) {
        try (Connection connection = ConexaoMySQL.conectar()) {
            String sql = "UPDATE produto SET produto_id = ?, nome = ?, descricao = ?, preco = ?, qtdEstoque = ?, ativo = ? WHERE produto_id = ?;";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, produto.getId());
                statement.setString(2, produto.getNome());
                statement.setString(3, produto.getDescricao());
                statement.setFloat(4, produto.getPreco());
                statement.setInt(5, produto.getQtdEstoque());
                statement.setBoolean(6, produto.isAtivo());
                statement.setInt(7, produto.getId());
                statement.executeUpdate();
            } finally {
                ConexaoMySQL.fecharConexao(connection);
            }
        } catch (SQLException e) {
            logger.error("Erro ao atualizar produto: " + e.getMessage());
            throw new RuntimeException("Erro ao atualizar produto", e);
        }
    }

    public Produto buscarProdutoPorId(int id) {
        Produto produto = new Produto();
        try (Connection connection = ConexaoMySQL.conectar()) {
            String sql = "SELECT * FROM produto WHERE produto_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        produto.setId(resultSet.getInt("produto_id"));
                        produto.setNome(resultSet.getString("nome"));
                        produto.setDescricao(resultSet.getString("descricao"));
                        produto.setPreco(resultSet.getFloat("preco"));
                        produto.setQtdEstoque(resultSet.getInt("qtdEstoque"));
                        produto.setAtivo(resultSet.getBoolean("ativo"));
                    } else {
                        logger.warn("Produto não encontrado para o ID: " + id);
                    }
                }
            }
        } catch (SQLException e) {
            logger.error("Erro ao buscar produto por id: " + e.getMessage());
            throw new RuntimeException("Erro ao buscar produto por id", e);
        }
        return produto;
    }
}