package br.com.lojavirtual.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import br.com.lojavirtual.ConexaoMYSQL.Conexao;
import br.com.lojavirtual.model.DTO.FormaPagamento;

public class FormaPagamentoDAO {
    final String tabela = "formapagamento";
    private static final HashMap<String, FormaPagamento> mapFormaPagamentos = new HashMap<>();

    public boolean inserir(FormaPagamento formaPagamento) {
        Connection conexao = Conexao.conectar();
        String sql = " INSERT INTO " + tabela + " ( formapagamento_id, tipo ) VALUES (?, ?); ";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, formaPagamento.getId());
            statement.setString(2, formaPagamento.getTipo());
            statement.executeUpdate();
            statement.close();
            conexao.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir usuário no banco de dados.");
            return false;
        }
    }

    public boolean alterar(FormaPagamento formaPagamento) {
        Connection conexao = Conexao.conectar();
        String sql = " UPDATE " + tabela + " SET tipo = ? WHERE "+tabela+"_id = ? ";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, formaPagamento.getTipo());
            statement.setInt(1, formaPagamento.getId());
            statement.executeUpdate();
            statement.close();
            conexao.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao alterar dados do usuário no banco de dados.");
            return false;
        }
    }

    public boolean excluir(FormaPagamento formaPagamento) {
        Connection conexao = Conexao.conectar();
        String sql = " DELETE FROM " + tabela + "  WHERE "+tabela+"_id = ? ";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, formaPagamento.getId());
            statement.executeUpdate();
            statement.close();
            conexao.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir usuário no banco de dados.");
            return false;
        }
    }

    public FormaPagamento procurarPorId(int id) {
        Connection conexao = Conexao.conectar();
        String sql = " SELECT * FROM " + tabela + " WHERE "+tabela+"_id = ? ";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    FormaPagamento formaPagamento = new FormaPagamento();
                    formaPagamento.setId(resultSet.getInt("formapagamento_id"));
                    formaPagamento.setTipo(resultSet.getString("tipo"));
                    statement.close();
                    conexao.close();
                    return formaPagamento;
                } else {
                    statement.close();
                    conexao.close();
                    System.err.println("formaPagamento não encontrado para o ID: " + id);
                    return null;
                }
            }            
        } catch (SQLException e) {
            System.out.println("Erro ao alterar dados do usuário no banco de dados.");
            return null;
        }
    }

    public FormaPagamento procurarPorTipo(String tipo) {
        Connection conexao = Conexao.conectar();
        String sql = " SELECT * FROM " + tabela + " WHERE tipo = ? ";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, tipo);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    FormaPagamento formaPagamento = new FormaPagamento();
                    formaPagamento.setId(resultSet.getInt("formapagamento_id"));
                    formaPagamento.setTipo(resultSet.getString(resultSet.getString("tipo")));
                    statement.close();
                    conexao.close();
                    return formaPagamento;
                } else {
                    statement.close();
                    conexao.close();
                    System.err.println("formaPagamento não encontrado para o ID: " + tipo);
                    return null;
                }
            }            
        } catch (SQLException e) {
            System.out.println("Erro ao alterar dados do usuário no banco de dados.");
            return null;
        }
    }

    public boolean existe(FormaPagamento formaPagamento) {
        Connection conexao = Conexao.conectar();
        String sql = " SELECT * FROM " + tabela + " WHERE tipo = ? OR "+tabela+"_id = ?";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, formaPagamento.getTipo());
            statement.setInt(2, formaPagamento.getId());
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    statement.close();
                    conexao.close();
                    return true;
                }
            }            
        } catch (SQLException e) {
            System.out.println("Erro ao verificar se existe usuário no banco de dados.");
            return false;
        }
        return false;
    }

    public boolean existePorTipo(String tipo) {
        Connection conexao = Conexao.conectar();
        String sql = " SELECT * FROM " + tabela + " WHERE tipo = ? ";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, tipo);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    statement.close();
                    conexao.close();
                    return true;
                }
            }            
        } catch (SQLException e) {
            System.out.println("Erro ao verificar se existe usuário no banco de dados.");
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
            System.out.println("Erro ao verificar se existe usuário no banco de dados.");
            return false;
        }
        return false;
    }

    private void atualizarMapFormaPagamentos() {
        try (Connection connection = Conexao.conectar()) {
            String sql = "SELECT * FROM formaPpagamento";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    mapFormaPagamentos.clear();
                    while (resultSet.next()) {
                        FormaPagamento formaPagamento = new FormaPagamento();
                        formaPagamento.setId(resultSet.getInt("formapagamento_id"));
                        formaPagamento.setTipo(resultSet.getString("tipo"));
                        mapFormaPagamentos.put(formaPagamento.getTipo(), formaPagamento);
                    }
                }
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar lista de formaPagamentos", e);
        }
    }

    public HashMap<String, FormaPagamento> listarFormaPagamentos() {
        atualizarMapFormaPagamentos();
        return new HashMap<>(mapFormaPagamentos);
    }
}
