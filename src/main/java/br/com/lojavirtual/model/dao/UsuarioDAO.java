package br.com.lojavirtual.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import br.com.lojavirtual.ConexaoMYSQL.Conexao;
import br.com.lojavirtual.model.DTO.Usuario;

public class UsuarioDAO {
    final String tabela = "usuario";
    private static final HashMap<String, Usuario> mapUsuarios = new HashMap<>();

    public boolean inserir(Usuario usuario) {
        Connection conexao = Conexao.conectar();
        String sql = " INSERT INTO " + tabela + " ( usuario_id, nome, username, senha, tipo, ativo ) VALUES (?, ?, ?, ?, ?, ?); ";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, usuario.getId());
            statement.setString(2, usuario.getNome());
            statement.setString(3, usuario.getUsername());
            statement.setString(4, usuario.getSenha());
            statement.setString(5, usuario.getTipo());
            statement.setBoolean(6, usuario.isAtivo());
            statement.executeUpdate();
            statement.close();
            conexao.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir usuário no banco de dados.");
            return false;
        }
    }

    public boolean alterar(Usuario usuario) {
        Connection conexao = Conexao.conectar();
        String sql = " UPDATE " + tabela + " SET nome = ?, username = ?, senha = ?, tipo = ?, ativo = ? WHERE "+tabela+"_id = ? ";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getUsername());
            statement.setString(3, usuario.getSenha());
            statement.setString(4, usuario.getTipo());
            statement.setBoolean(5, usuario.isAtivo());
            statement.setInt(6, usuario.getId());
            statement.executeUpdate();
            statement.close();
            conexao.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao alterar dados do usuário no banco de dados.");
            return false;
        }
    }

    public boolean excluir(Usuario usuario) {
        Connection conexao = Conexao.conectar();
        String sql = " DELETE FROM " + tabela + "  WHERE "+tabela+"_id = ? ";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, usuario.getId());
            statement.executeUpdate();
            statement.close();
            conexao.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir usuário no banco de dados.");
            return false;
        }
    }

    public Usuario procurarPorId(int id) {
        Connection conexao = Conexao.conectar();
        String sql = " SELECT * FROM " + tabela + " WHERE "+tabela+"_id = ? ";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(resultSet.getInt("usuario_id"));
                    usuario.setNome(resultSet.getString("nome"));
                    usuario.setUsername(resultSet.getString("username"));
                    usuario.setSenha(resultSet.getString("senha"));
                    usuario.setTipo(resultSet.getString("tipo"));
                    usuario.setAtivo(resultSet.getBoolean("ativo"));
                    statement.close();
                    conexao.close();
                    return usuario;
                } else {
                    statement.close();
                    conexao.close();
                    System.err.println("usuario não encontrado para o ID: " + id);
                    return null;
                }
            }            
        } catch (SQLException e) {
            System.out.println("Erro ao alterar dados do usuário no banco de dados.");
            return null;
        }
    }

    public Usuario procurarPorUsername(String username) {
        Connection conexao = Conexao.conectar();
        String sql = " SELECT * FROM " + tabela + " WHERE username = ? ";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(resultSet.getInt("usuario_id"));
                    usuario.setNome(resultSet.getString("nome"));
                    usuario.setUsername(resultSet.getString("username"));
                    usuario.setSenha(resultSet.getString("senha"));
                    usuario.setTipo(resultSet.getString("tipo"));
                    usuario.setAtivo(resultSet.getBoolean("ativo"));
                    statement.close();
                    conexao.close();
                    return usuario;
                } else {
                    statement.close();
                    conexao.close();
                    System.err.println("usuario não encontrado para o ID: " + username);
                    return null;
                }
            }            
        } catch (SQLException e) {
            System.out.println("Erro ao alterar dados do usuário no banco de dados.");
            return null;
        }
    }

    public boolean existe(Usuario usuario) {
        Connection conexao = Conexao.conectar();
        String sql = " SELECT * FROM " + tabela + " WHERE username = ? OR "+tabela+"_id = ?";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, usuario.getUsername());
            statement.setInt(2, usuario.getId());
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

    private void atualizarMapUsuarios() {
        try (Connection connection = Conexao.conectar()) {
            String sql = "SELECT * FROM usuario";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    mapUsuarios.clear();
                    while (resultSet.next()) {
                        Usuario usuario = new Usuario();
                        usuario.setId(resultSet.getInt("usuario_id"));
                        usuario.setNome(resultSet.getString("nome"));
                        usuario.setUsername(resultSet.getString("username"));
                        usuario.setSenha(resultSet.getString("senha"));
                        usuario.setTipo(resultSet.getString("tipo"));
                        usuario.setAtivo(resultSet.getBoolean("ativo"));
                        mapUsuarios.put(usuario.getUsername(), usuario);
                    }
                }
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar lista de usuarios", e);
        }
    }

    public HashMap<String, Usuario> listarUsuarios() {
        atualizarMapUsuarios();
        return new HashMap<>(mapUsuarios);
    }

    public boolean desativarPorId(int id) {
        try (Connection connection = Conexao.conectar()) {
            String sql = "UPDATE usuario SET ativo = ? WHERE usuario_id = ?;";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setBoolean(1, false);
                statement.setInt(2, id);
                statement.executeUpdate();
                Conexao.fecharConexao(connection);
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao desativar usuário.");
            return false;
        }
    }

    public boolean ativarPorId(int id) {
        try (Connection connection = Conexao.conectar()) {
            String sql = "UPDATE usuario SET ativo = ? WHERE usuario_id = ?;";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setBoolean(1, true);
                statement.setInt(2, id);
                statement.executeUpdate();
                Conexao.fecharConexao(connection);
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao ativar usuário por id.");
            return false;
        }
    }

    public boolean desativarPorUsername(String username) {
        try (Connection connection = Conexao.conectar()) {
            String sql = "UPDATE usuario SET ativo = ? WHERE username = ?;";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setBoolean(1, false);
                statement.setString(2, username);
                statement.executeUpdate();
                Conexao.fecharConexao(connection);
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao desativar usuário.");
            return false;
        }
    }

    public boolean ativarPorUsername(String username) {
        try (Connection connection = Conexao.conectar()) {
            String sql = "UPDATE usuario SET ativo = ? WHERE username = ?;";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setBoolean(1, true);
                statement.setString(2, username);
                statement.executeUpdate();
                Conexao.fecharConexao(connection);
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao ativar usuário.");
            return false;
        }
    }

    public boolean atualizar(Usuario usuario) {
        try (Connection connection = Conexao.conectar()) {
            String sql = "UPDATE usuario SET nome = ?, username = ?, senha = ?, tipo = ?, ativo = ? WHERE usuario_id = ?;";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, usuario.getNome());
                statement.setString(2, usuario.getUsername());
                statement.setString(3, usuario.getSenha());
                statement.setString(4, usuario.getTipo());
                statement.setBoolean(5, usuario.isAtivo());
                statement.setInt(6, usuario.getId());
                statement.executeUpdate();
                Conexao.fecharConexao(connection);
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar usuário.");
            return false;
        }
    }
}
