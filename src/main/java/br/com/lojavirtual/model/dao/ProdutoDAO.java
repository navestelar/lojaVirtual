package br.com.lojavirtual.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import br.com.lojavirtual.ConexaoMYSQL.Conexao;
import br.com.lojavirtual.model.DTO.Produto;

public class ProdutoDAO {
    final String tabela = "produto";
    private static final HashMap<String, Produto> mapProdutos = new HashMap<>();

    public boolean inserir(Produto produto) {
        Connection conexao = Conexao.conectar();
        String sql = " INSERT INTO " + tabela + " ( produto_id, nome, descricao, qtdEstoque, preco, ativo ) VALUES (?, ?, ?, ?, ?, ?); ";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, produto.getId());
            statement.setString(2, produto.getNome());
            statement.setString(3, produto.getDescricao());
            statement.setInt(4, produto.getQtdEstoque());
            statement.setFloat(5, produto.getPreco());
            statement.setBoolean(6, produto.isAtivo());
            statement.executeUpdate();
            statement.close();
            conexao.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir produto no banco de dados."+e);
            return false;
        }
    }

    public boolean alterar(Produto produto) {
        Connection conexao = Conexao.conectar();
        String sql = " UPDATE " + tabela + " SET produto_id = ?, nome = ?, descricao = ?, qtdEstoque = ?, preco = ?, ativo = ? WHERE "+tabela+"_id = ? ";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, produto.getId());
            statement.setString(2, produto.getNome());
            statement.setString(3, produto.getDescricao());
            statement.setInt(4, produto.getQtdEstoque());
            statement.setFloat(5, produto.getPreco());
            statement.setBoolean(6, produto.isAtivo());
            statement.setInt(7, produto.getId());
            statement.executeUpdate();
            statement.close();
            conexao.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao alterar dados do produto no banco de dados.");
            return false;
        }
    }

    public boolean excluir(Produto produto) {
        Connection conexao = Conexao.conectar();
        String sql = " DELETE FROM " + tabela + "  WHERE "+tabela+"_id = ? ";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, produto.getId());
            statement.executeUpdate();
            statement.close();
            conexao.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir produto no banco de dados.");
            return false;
        }
    }

    public Produto procurarPorId(int id) {
        Connection conexao = Conexao.conectar();
        String sql = " SELECT * FROM " + tabela + " WHERE "+tabela+"_id = ? ";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Produto produto = new Produto();
                    produto.setId(resultSet.getInt("produto_id"));
                    produto.setNome(resultSet.getString("nome"));
                    produto.setDescricao(resultSet.getString("descricao"));
                    produto.setQtdEstoque(resultSet.getInt("qtdEstoque"));
                    produto.setPreco(resultSet.getFloat("preco"));
                    produto.setAtivo(resultSet.getBoolean("ativo"));
                    produto.setFornecedorId(resultSet.getInt("fornecedor_id"));
                    statement.close();
                    conexao.close();
                    return produto;
                } else {
                    statement.close();
                    conexao.close();
                    System.err.println("produto não encontrado para o ID: " + id);
                    return null;
                }
            }            
        } catch (SQLException e) {
            System.out.println("Erro ao alterar dados do produto no banco de dados.");
            return null;
        }
    }

    public Produto procurarPorNome(String nome) {
        Connection conexao = Conexao.conectar();
        String sql = " SELECT * FROM " + tabela + " WHERE nome = ? ";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, nome);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Produto produto = new Produto();
                    produto.setId(resultSet.getInt("produto_id"));
                    produto.setNome(resultSet.getString("nome"));
                    produto.setDescricao(resultSet.getString("descricao"));
                    produto.setQtdEstoque(resultSet.getInt("qtdEstoque"));
                    produto.setPreco(resultSet.getFloat("preco"));
                    produto.setAtivo(resultSet.getBoolean("ativo"));
                    produto.setFornecedorId(resultSet.getInt("fornecedor_id"));
                    statement.close();
                    conexao.close();
                    return produto;
                } else {
                    statement.close();
                    conexao.close();
                    System.err.println("produto não encontrado para o ID: " + nome);
                    return null;
                }
            }            
        } catch (SQLException e) {
            System.out.println("Erro ao alterar dados do produto no banco de dados.");
            return null;
        }
    }

    public boolean existe(Produto produto) {
        Connection conexao = Conexao.conectar();
        String sql = " SELECT * FROM " + tabela + " WHERE nome = ? OR "+tabela+"_id = ?";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, produto.getNome());
            statement.setInt(2, produto.getId());
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    statement.close();
                    conexao.close();
                    return true;
                }
            }            
        } catch (SQLException e) {
            System.out.println("Erro ao verificar se existe produto no banco de dados.");
            return false;
        }
        return false;
    }

    public boolean existePorNome(String nome) {
        Connection conexao = Conexao.conectar();
        String sql = " SELECT * FROM " + tabela + " WHERE nome = ? ";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, nome);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    statement.close();
                    conexao.close();
                    return true;
                }
            }            
        } catch (SQLException e) {
            System.out.println("Erro ao verificar se existe produto no banco de dados.");
            return false;
        }
        return false;
    }

    public boolean existePorId(int id) {
        Connection conexao = Conexao.conectar();
        String sql = " SELECT * FROM " + tabela + " WHERE "+tabela+"_id = ? ";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    statement.close();
                    conexao.close();
                    return true;
                }
            }            
        } catch (SQLException e) {
            System.out.println("Erro ao verificar se existe produto no banco de dados.");
            return false;
        }
        return false;
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
                        produto.setQtdEstoque(resultSet.getInt("qtdEstoque"));
                        produto.setPreco(resultSet.getFloat("preco"));
                        produto.setAtivo(resultSet.getBoolean("ativo"));
                        produto.setFornecedorId(resultSet.getInt("fornecedor_id"));
                        mapProdutos.put(produto.getNome(), produto);
                    }
                }
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar lista de produtos", e);
        }
    }

    public HashMap<String, Produto> listarProdutos() {
        atualizarMapProdutos();
        return new HashMap<>(mapProdutos);
    }

    public boolean desativarPorId(int id) {
        try (Connection connection = Conexao.conectar()) {
            String sql = "UPDATE produto SET ativo = ? WHERE produto_id = ?;";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setBoolean(1, false);
                statement.setInt(2, id);
                statement.executeUpdate();
                Conexao.fecharConexao(connection);
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao desativar produto.");
            return false;
        }
    }

    public boolean ativarPorId(int id) {
        try (Connection connection = Conexao.conectar()) {
            String sql = "UPDATE produto SET ativo = ? WHERE produto_id = ?;";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setBoolean(1, true);
                statement.setInt(2, id);
                statement.executeUpdate();
                Conexao.fecharConexao(connection);
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao ativar produto por id.");
            return false;
        }
    }

    public boolean desativarPorNome(String nome) {
        try (Connection connection = Conexao.conectar()) {
            String sql = "UPDATE produto SET ativo = ? WHERE nome = ?;";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setBoolean(1, false);
                statement.setString(2, nome);
                statement.executeUpdate();
                Conexao.fecharConexao(connection);
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao desativar produto.");
            return false;
        }
    }

    public boolean ativarPorNome(String nome) {
        try (Connection connection = Conexao.conectar()) {
            String sql = "UPDATE produto SET ativo = ? WHERE nome = ?;";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setBoolean(1, true);
                statement.setString(2, nome);
                statement.executeUpdate();
                Conexao.fecharConexao(connection);
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao ativar produto.");
            return false;
        }
    }

}
