package br.com.lojavirtual.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.lojavirtual.ConexaoMYSQL.Conexao;
import br.com.lojavirtual.model.DTO.Produto;

public class ProdutoDAO {
    private static final Logger logger = LoggerFactory.getLogger(ProdutoDAO.class);
    private static final HashMap<Integer, Produto> mapProdutos = new HashMap<>();

    public void cadastrarProduto(Produto produto) {
        atualizarMapProdutos();
        if (!mapProdutos.containsKey(produto.getId()) ) {
            try (Connection connection = Conexao.conectar()) {
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
                    Conexao.fecharConexao(connection);
                }
            } catch (SQLException e) {
                logger.error("Erro ao cadastrar produto: " + e.getMessage());
                throw new RuntimeException("Erro ao cadastrar produto", e);
            }
        } else {
            logger.error("Já existe um produto com esse id");
        }
    }

    private void atualizarMapProdutos() {
        try (Connection connection = Conexao.conectar()) {
            String sql = "SELECT * FROM produto";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    mapProdutos.clear();
                    while (resultSet.next()) {
                        Produto produto = new Produto();
                        produto.setId(resultSet.getInt("produto_id"));
                        produto.setNome(resultSet.getString("nome"));
                        produto.setDescricao(resultSet.getString("descricao"));
                        produto.setPreco(resultSet.getFloat("preco"));
                        produto.setQtdEstoque(resultSet.getInt("qtdEstoque"));
                        produto.setAtivo(resultSet.getBoolean("ativo"));
                        mapProdutos.put(produto.getId(), produto);
                    }
                }
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            logger.error("Erro ao atualizar lista de produtos: ", e.getMessage());
            throw new RuntimeException("Erro ao atualizar lista de produtos", e);
        }
    }

    public HashMap<Integer, Produto> listarProdutos() {
        atualizarMapProdutos();
        return new HashMap<>(mapProdutos);
    }

    public void excluirProduto(int id) {
        try (Connection connection = Conexao.conectar()) {
            String sql = "DELETE FROM produto WHERE produto_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            } finally {
                Conexao.fecharConexao(connection);
            }
        } catch (SQLException e) {
            logger.error("Erro ao excluir produto: " + e.getMessage());
            throw new RuntimeException("Erro ao excluir produto", e);
        }
    }

    public void atualizarProduto(Produto produto) {
        try (Connection connection = Conexao.conectar()) {
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
                Conexao.fecharConexao(connection);
            }
        } catch (SQLException e) {
            logger.error("Erro ao atualizar produto: " + e.getMessage());
            throw new RuntimeException("Erro ao atualizar produto", e);
        }
    }

    public Produto buscarProdutoPorId(int id) {
        Produto produto = new Produto();
        try (Connection connection = Conexao.conectar()) {
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
            } finally {
                Conexao.fecharConexao(connection);
            }
        } catch (SQLException e) {
            logger.error("Erro ao buscar produto por id: " + e.getMessage());
            throw new RuntimeException("Erro ao buscar produto por id", e);
        }
        return produto;
    }
}