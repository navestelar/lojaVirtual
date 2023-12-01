package br.com.lojavirtual.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import br.com.lojavirtual.ConexaoMYSQL.Conexao;
import br.com.lojavirtual.model.DTO.Carrinho;

public class CarrinhoDAO {
    final String tabela = "carrinho";
    private static final HashMap<String, Carrinho> mapCarrinhos = new HashMap<>();

    public boolean inserir(Carrinho carrinho) {
        Connection conexao = Conexao.conectar();
        String sql = "INSERT INTO " + tabela + " (cliente_id, forma_pagamento_id) VALUES (?, ?)";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, carrinho.getClienteId());
            statement.setInt(2, carrinho.getFormaPagamentoId());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir carrinho no banco de dados.");
            return false;
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }

    public boolean alterar(Carrinho carrinho) {
        Connection conexao = Conexao.conectar();
        String sql = "UPDATE " + tabela + " SET cliente_id = ?, forma_pagamento_id = ? WHERE " + tabela + "_id = ?";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, carrinho.getClienteId());
            statement.setInt(2, carrinho.getFormaPagamentoId());
            statement.setInt(3, carrinho.getId());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao alterar dados do carrinho no banco de dados.");
            return false;
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }

    public boolean excluir(Carrinho carrinho) {
        Connection conexao = Conexao.conectar();
        String sql = "DELETE FROM " + tabela + "  WHERE " + tabela + "_id = ?";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, carrinho.getId());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir carrinho no banco de dados.");
            return false;
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }

    public Carrinho procurarPorId(int id) {
        Connection conexao = Conexao.conectar();
        String sql = "SELECT * FROM " + tabela + " WHERE " + tabela + "_id = ?";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Carrinho carrinho = new Carrinho();
                    carrinho.setId(resultSet.getInt("carrinho_id"));
                    carrinho.setClienteId(resultSet.getInt("cliente_id"));
                    carrinho.setFormaPagamentoId(resultSet.getInt("forma_pagamento_id"));
                    return carrinho;
                } else {
                    System.err.println("Carrinho não encontrado para o ID: " + id);
                    return null;
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar carrinho por ID no banco de dados.");
            return null;
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }

    public boolean existe(Carrinho carrinho) {
        Connection conexao = Conexao.conectar();
        String sql = "SELECT * FROM " + tabela + " WHERE cliente_id = ? AND forma_pagamento_id = ?";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, carrinho.getClienteId());
            statement.setInt(2, carrinho.getFormaPagamentoId());
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao verificar se existe carrinho no banco de dados.");
            return false;
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }

    public boolean existePorId(int id) {
        Connection conexao = Conexao.conectar();
        String sql = "SELECT * FROM " + tabela + " WHERE " + tabela + "_id = ?";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao verificar se existe carrinho no banco de dados.");
            return false;
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }

    private void atualizarMapCarrinhos() {
        try (Connection connection = Conexao.conectar()) {
            String sql = "SELECT * FROM " + tabela;
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    mapCarrinhos.clear();
                    while (resultSet.next()) {
                        Carrinho carrinho = new Carrinho();
                        carrinho.setId(resultSet.getInt("carrinho_id"));
                        carrinho.setClienteId(resultSet.getInt("cliente_id"));
                        carrinho.setFormaPagamentoId(resultSet.getInt("forma_pagamento_id"));
                        mapCarrinhos.put(String.valueOf(carrinho.getId()), carrinho);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar lista de carrinhos", e);
        }
    }

    public HashMap<String, Carrinho> listarCarrinhos() {
        atualizarMapCarrinhos();
        return new HashMap<>(mapCarrinhos);
    }
}
