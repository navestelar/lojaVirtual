package br.com.lojavirtual.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import br.com.lojavirtual.ConexaoMYSQL.Conexao;
import br.com.lojavirtual.model.DTO.ControleAcesso;

public class ControleAcessoDAO {
    final String tabela = "controleacesso";
    private static final HashMap<Integer, ControleAcesso> mapControleAcessos = new HashMap<>();

    public boolean inserir(ControleAcesso controleAcesso) {
        Connection conexao = Conexao.conectar();
        String sql = " INSERT INTO " + tabela + " ( controleacesso_id, permissoes ) VALUES (?, ?); ";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, controleAcesso.getId());
            statement.setString(2, controleAcesso.getPermissoes());
            statement.executeUpdate();
            statement.close();
            conexao.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir controleAcesso no banco de dados.");
            return false;
        }
    }

    public boolean alterar(ControleAcesso controleAcesso) {
        Connection conexao = Conexao.conectar();
        String sql = " UPDATE " + tabela + " SET permissoes = ?,  WHERE "+tabela+"_id = ? ";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, controleAcesso.getPermissoes());
            statement.setInt(2, controleAcesso.getId());
            statement.executeUpdate();
            statement.close();
            conexao.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao alterar dados do controleAcesso no banco de dados.");
            return false;
        }
    }

    public boolean excluir(ControleAcesso controleAcesso) {
        Connection conexao = Conexao.conectar();
        String sql = " DELETE FROM " + tabela + "  WHERE "+tabela+"_id = ? ";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, controleAcesso.getId());
            statement.executeUpdate();
            statement.close();
            conexao.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir controleAcesso no banco de dados.");
            return false;
        }
    }

    public ControleAcesso procurarPorId(int id) {
        Connection conexao = Conexao.conectar();
        String sql = " SELECT * FROM " + tabela + " WHERE "+tabela+"_id = ? ";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    ControleAcesso controleAcesso = new ControleAcesso();
                    controleAcesso.setId(resultSet.getInt("controleacesso_id"));
                    controleAcesso.setPermissoes(resultSet.getString("permissoes"));
                    controleAcesso.setUserId(resultSet.getInt("usuario_id"));
                    statement.close();
                    conexao.close();
                    return controleAcesso;
                } else {
                    statement.close();
                    conexao.close();
                    System.err.println("controleAcesso não encontrado para o ID: " + id);
                    return null;
                }
            }            
        } catch (SQLException e) {
            System.out.println("Erro ao alterar dados do controleAcesso no banco de dados.");
            return null;
        }
    }

    public boolean existe(ControleAcesso controleAcesso) {
        Connection conexao = Conexao.conectar();
        String sql = " SELECT * FROM " + tabela + " WHERE "+tabela+"_id = ?";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, controleAcesso.getId());
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    statement.close();
                    conexao.close();
                    return true;
                }
            }            
        } catch (SQLException e) {
            System.out.println("Erro ao verificar se existe controleAcesso no banco de dados.");
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
            System.out.println("Erro ao verificar se existe controleAcesso no banco de dados.");
            return false;
        }
        return false;
    }

    private void atualizarMapControleAcessos() {
        try (Connection connection = Conexao.conectar()) {
            String sql = "SELECT * FROM controleacesso";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    mapControleAcessos.clear();
                    while (resultSet.next()) {
                        ControleAcesso controleAcesso = new ControleAcesso();
                        controleAcesso.setId(resultSet.getInt("controleacesso_id"));
                        controleAcesso.setPermissoes(resultSet.getString("permissoes"));
                        controleAcesso.setUserId(resultSet.getInt("usuario_id"));
                        mapControleAcessos.put(controleAcesso.getId(), controleAcesso);
                    }
                }
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar lista de controleAcessos", e);
        }
    }

    public HashMap<Integer, ControleAcesso> listarControleAcessos() {
        atualizarMapControleAcessos();
        return new HashMap<>(mapControleAcessos);
    }
}
