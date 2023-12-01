package br.com.lojavirtual.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import br.com.lojavirtual.ConexaoMYSQL.Conexao;
import br.com.lojavirtual.model.DTO.Administrador;

public class AdministradorDAO {
    final String tabela = "administrador";
    private static final HashMap<String, Administrador> mapAdministradors = new HashMap<>();

    public boolean inserir(Administrador administrador) {
        Connection conexao = Conexao.conectar();
        String sql = " INSERT INTO " + tabela + " ( administrador_id, nome, username, senha, tipo, ativo ) VALUES (?, ?, ?, ?, ?, ?); ";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, administrador.getId());
            statement.setString(2, administrador.getNome());
            statement.setString(3, administrador.getUsername());
            statement.setString(4, administrador.getSenha());
            statement.setString(5, administrador.getTipo());
            statement.setBoolean(6, administrador.isAtivo());
            statement.executeUpdate();
            statement.close();
            conexao.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir administrador no banco de dados.");
            return false;
        }
    }

    public boolean alterar(Administrador administrador) {
        Connection conexao = Conexao.conectar();
        String sql = " UPDATE " + tabela + " SET nome = ?, username = ?, senha = ?, tipo = ?, ativo = ? WHERE "+tabela+"_id = ? ";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, administrador.getNome());
            statement.setString(2, administrador.getUsername());
            statement.setString(3, administrador.getSenha());
            statement.setString(4, administrador.getTipo());
            statement.setBoolean(5, administrador.isAtivo());
            statement.setInt(6, administrador.getId());
            statement.executeUpdate();
            statement.close();
            conexao.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao alterar dados do administrador no banco de dados.");
            return false;
        }
    }

    public boolean excluir(Administrador administrador) {
        Connection conexao = Conexao.conectar();
        String sql = " DELETE FROM " + tabela + "  WHERE "+tabela+"_id = ? ";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, administrador.getId());
            statement.executeUpdate();
            statement.close();
            conexao.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir administrador no banco de dados.");
            return false;
        }
    }

    public Administrador procurarPorId(int id) {
        Connection conexao = Conexao.conectar();
        String sql = " SELECT * FROM " + tabela + " WHERE "+tabela+"_id = ? ";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Administrador administrador = new Administrador();
                    administrador.setId(resultSet.getInt("administrador_id"));
                    administrador.setNome(resultSet.getString("nome"));
                    administrador.setUsername(resultSet.getString("username"));
                    administrador.setSenha(resultSet.getString("senha"));
                    administrador.setTipo(resultSet.getString("tipo"));
                    administrador.setAtivo(resultSet.getBoolean("ativo"));
                    statement.close();
                    conexao.close();
                    return administrador;
                } else {
                    statement.close();
                    conexao.close();
                    System.err.println("administrador não encontrado para o ID: " + id);
                    return null;
                }
            }            
        } catch (SQLException e) {
            System.out.println("Erro ao alterar dados do administrador no banco de dados.");
            return null;
        }
    }

    public Administrador procurarPorUsername(String username) {
        Connection conexao = Conexao.conectar();
        String sql = " SELECT * FROM " + tabela + " WHERE username = ? ";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Administrador administrador = new Administrador();
                    administrador.setId(resultSet.getInt("administrador_id"));
                    administrador.setNome(resultSet.getString("nome"));
                    administrador.setUsername(resultSet.getString("username"));
                    administrador.setSenha(resultSet.getString("senha"));
                    administrador.setTipo(resultSet.getString("tipo"));
                    administrador.setAtivo(resultSet.getBoolean("ativo"));
                    statement.close();
                    conexao.close();
                    return administrador;
                } else {
                    statement.close();
                    conexao.close();
                    System.err.println("administrador não encontrado para o ID: " + username);
                    return null;
                }
            }            
        } catch (SQLException e) {
            System.out.println("Erro ao alterar dados do administrador no banco de dados.");
            return null;
        }
    }

    public boolean existe(Administrador administrador) {
        Connection conexao = Conexao.conectar();
        String sql = " SELECT * FROM " + tabela + " WHERE username = ? OR "+tabela+"_id = ?";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, administrador.getUsername());
            statement.setInt(2, administrador.getId());
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    statement.close();
                    conexao.close();
                    return true;
                }
            }            
        } catch (SQLException e) {
            System.out.println("Erro ao verificar se existe administrador no banco de dados.");
            return false;
        }
        return false;
    }

    public boolean existePorUsername(String username) {
        Connection conexao = Conexao.conectar();
        String sql = " SELECT * FROM " + tabela + " WHERE username = ? ";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    statement.close();
                    conexao.close();
                    return true;
                }
            }            
        } catch (SQLException e) {
            System.out.println("Erro ao verificar se existe administrador no banco de dados.");
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
            System.out.println("Erro ao verificar se existe administrador no banco de dados.");
            return false;
        }
        return false;
    }

    private void atualizarMapAdministradors() {
        try (Connection connection = Conexao.conectar()) {
            String sql = "SELECT * FROM administrador";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    mapAdministradors.clear();
                    while (resultSet.next()) {
                        Administrador administrador = new Administrador();
                        administrador.setId(resultSet.getInt("administrador_id"));
                        administrador.setNome(resultSet.getString("nome"));
                        administrador.setUsername(resultSet.getString("username"));
                        administrador.setSenha(resultSet.getString("senha"));
                        administrador.setTipo(resultSet.getString("tipo"));
                        administrador.setAtivo(resultSet.getBoolean("ativo"));
                        mapAdministradors.put(administrador.getUsername(), administrador);
                    }
                }
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar lista de administradors", e);
        }
    }

    public HashMap<String, Administrador> listarAdministradors() {
        atualizarMapAdministradors();
        return new HashMap<>(mapAdministradors);
    }

    public boolean desativarPorId(int id) {
        try (Connection connection = Conexao.conectar()) {
            String sql = "UPDATE administrador SET ativo = ? WHERE administrador_id = ?;";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setBoolean(1, false);
                statement.setInt(2, id);
                statement.executeUpdate();
                Conexao.fecharConexao(connection);
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao desativar administrador.");
            return false;
        }
    }

    public boolean ativarPorId(int id) {
        try (Connection connection = Conexao.conectar()) {
            String sql = "UPDATE administrador SET ativo = ? WHERE administrador_id = ?;";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setBoolean(1, true);
                statement.setInt(2, id);
                statement.executeUpdate();
                Conexao.fecharConexao(connection);
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao ativar administrador por id.");
            return false;
        }
    }

    public boolean desativarPorUsername(String username) {
        try (Connection connection = Conexao.conectar()) {
            String sql = "UPDATE administrador SET ativo = ? WHERE username = ?;";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setBoolean(1, false);
                statement.setString(2, username);
                statement.executeUpdate();
                Conexao.fecharConexao(connection);
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao desativar administrador.");
            return false;
        }
    }

    public boolean ativarPorUsername(String username) {
        try (Connection connection = Conexao.conectar()) {
            String sql = "UPDATE administrador SET ativo = ? WHERE username = ?;";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setBoolean(1, true);
                statement.setString(2, username);
                statement.executeUpdate();
                Conexao.fecharConexao(connection);
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao ativar administrador.");
            return false;
        }
    }
}
