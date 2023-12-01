package br.com.lojavirtual.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import br.com.lojavirtual.ConexaoMYSQL.Conexao;
import br.com.lojavirtual.model.DTO.LogAcoes;

public class LogAcoesDAO {
    final String tabela = "logacoes";
    private static final HashMap<String, LogAcoes> mapLogAcoess = new HashMap<>();

    public boolean inserir(LogAcoes logAcoes) {
        Connection conexao = Conexao.conectar();
        String sql = " INSERT INTO " + tabela + " ( logacoes_id, acao, data, usuario_id ) VALUES (?, ?, ?, ?); ";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, logAcoes.getId());
            statement.setString(2, logAcoes.getAcao());
            statement.setString(3, logAcoes.getData());
            statement.setInt(4, logAcoes.getUserId());
            statement.executeUpdate();
            statement.close();
            conexao.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir usuário no banco de dados.");
            return false;
        }
    }

    public boolean alterar(LogAcoes logAcoes) {
        Connection conexao = Conexao.conectar();
        String sql = " UPDATE " + tabela + " SET acao = ?, data = ?, usuario_id = ? WHERE "+tabela+"_id = ? ";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, logAcoes.getAcao());
            statement.setString(2, logAcoes.getData());
            statement.setInt(3, logAcoes.getUserId());
            statement.setInt(4, logAcoes.getId());
            statement.executeUpdate();
            statement.close();
            conexao.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao alterar dados do usuário no banco de dados.");
            return false;
        }
    }

    public boolean excluir(LogAcoes logAcoes) {
        Connection conexao = Conexao.conectar();
        String sql = " DELETE FROM " + tabela + "  WHERE "+tabela+"_id = ? ";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, logAcoes.getId());
            statement.executeUpdate();
            statement.close();
            conexao.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir usuário no banco de dados.");
            return false;
        }
    }

    public LogAcoes procurarPorId(int id) {
        Connection conexao = Conexao.conectar();
        String sql = " SELECT * FROM " + tabela + " WHERE "+tabela+"_id = ? ";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    LogAcoes logAcoes = new LogAcoes();
                    statement.setString(1, logAcoes.getAcao());
                    statement.setString(2, logAcoes.getData());
                    statement.setInt(3, logAcoes.getUserId());
                    statement.setInt(4, logAcoes.getId());
                    statement.close();
                    conexao.close();
                    return logAcoes;
                } else {
                    statement.close();
                    conexao.close();
                    System.err.println("logAcoes não encontrado para o ID: " + id);
                    return null;
                }
            }            
        } catch (SQLException e) {
            System.out.println("Erro ao alterar dados do usuário no banco de dados.");
            return null;
        }
    }

    public LogAcoes procurarPorAcao(String acao) {
        Connection conexao = Conexao.conectar();
        String sql = " SELECT * FROM " + tabela + " WHERE acao = ? ";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, acao);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    LogAcoes logAcoes = new LogAcoes();
                    logAcoes.setId(resultSet.getInt("logacoes_id"));
                    logAcoes.setAcao(resultSet.getString("acao"));
                    logAcoes.setData(resultSet.getString("data"));
                    logAcoes.setUserId(resultSet.getInt("usuario_id"));
                    statement.close();
                    conexao.close();
                    return logAcoes;
                } else {
                    statement.close();
                    conexao.close();
                    System.err.println("logAcoes não encontrado para o ID: " + acao);
                    return null;
                }
            }            
        } catch (SQLException e) {
            System.out.println("Erro ao alterar dados do usuário no banco de dados.");
            return null;
        }
    }

    public boolean existe(LogAcoes logAcoes) {
        Connection conexao = Conexao.conectar();
        String sql = " SELECT * FROM " + tabela + " WHERE acao = ? OR "+tabela+"_id = ?";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, logAcoes.getAcao());
            statement.setInt(2, logAcoes.getId());
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

    public boolean existePorAcao(String acao) {
        Connection conexao = Conexao.conectar();
        String sql = " SELECT * FROM " + tabela + " WHERE acao = ? ";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, acao);
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

    private void atualizarMapLogAcoess() {
        try (Connection connection = Conexao.conectar()) {
            String sql = "SELECT * FROM logacoes";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    mapLogAcoess.clear();
                    while (resultSet.next()) {
                        LogAcoes logAcoes = new LogAcoes();
                        logAcoes.setId(resultSet.getInt("logacoes_id"));
                        logAcoes.setAcao(resultSet.getString("acao"));
                        logAcoes.setData(resultSet.getString("data"));
                        logAcoes.setUserId(resultSet.getInt("usuario_id"));
                        mapLogAcoess.put(logAcoes.getAcao(), logAcoes);
                    }
                }
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar lista de logAcoes", e);
        }
    }

    public HashMap<String, LogAcoes> listarLogAcoess() {
        atualizarMapLogAcoess();
        return new HashMap<>(mapLogAcoess);
    }

}
