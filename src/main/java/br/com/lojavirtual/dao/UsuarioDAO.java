package br.com.lojavirtual.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.lojavirtual.model.Usuario;

public class UsuarioDAO {
    private static final Logger logger = LoggerFactory.getLogger(UsuarioDAO.class);
    private static final HashMap<String, Usuario> mapUsuarios = new HashMap<>();

    public void criarUsuario(Usuario usuario) {
        if (!mapUsuarios.containsKey(usuario.getUsername()) ) {
            try (Connection connection = ConexaoMySQL.conectar()) {
                String sql = "INSERT INTO usuario (nome, username, senha, tipo, ativo) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, usuario.getNome());
                    statement.setString(2, usuario.getUsername());
                    statement.setString(3, usuario.getSenha());
                    statement.setString(4, usuario.getTipo());
                    statement.setBoolean(5, usuario.isAtivo());
                    statement.executeUpdate();
                } finally {
                    ConexaoMySQL.fecharConexao(connection);
                }
            } catch (SQLException e) {
                logger.error("Erro ao criar usuário: " + e.getMessage());
                throw new RuntimeException("Erro ao criar usuário", e);
            }
        } else {
            logger.error("Já existe um usuário com esse username");
        }
    }

    private void atualizarMapUsuarios() {
        try (Connection connection = ConexaoMySQL.conectar()) {
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
            logger.error("Erro ao atualizar lista de usuarios: ", e.getMessage());
            throw new RuntimeException("Erro ao atualizar lista de usuarios", e);
        }
    }

    public HashMap<String, Usuario> listarUsuarios() {
        atualizarMapUsuarios();
        return new HashMap<>(mapUsuarios);
    }

    public void desativarUsuarioPorId(int id) {
        try (Connection connection = ConexaoMySQL.conectar()) {
            String sql = "UPDATE usuario SET ativo = ? WHERE usuario_id = ?;";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setBoolean(1, false);
                statement.setInt(2, id);
                statement.executeUpdate();
            } finally {
                ConexaoMySQL.fecharConexao(connection);
            }
        } catch (SQLException e) {
            logger.error("Erro ao desativar usuário: " + e.getMessage());
            throw new RuntimeException("Erro ao desativar usuário", e);
        }
    }

    public void ativarUsuarioPorId(int id) {
        try (Connection connection = ConexaoMySQL.conectar()) {
            String sql = "UPDATE usuario SET ativo = ? WHERE usuario_id = ?;";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setBoolean(1, true);
                statement.setInt(2, id);
                statement.executeUpdate();
            } finally {
                ConexaoMySQL.fecharConexao(connection);
            }
        } catch (SQLException e) {
            logger.error("Erro ao desativar usuário: " + e.getMessage());
            throw new RuntimeException("Erro ao desativar usuário", e);
        }
    }

    public void desativarUsuarioPorUsername(String username) {
        try (Connection connection = ConexaoMySQL.conectar()) {
            String sql = "UPDATE usuario SET ativo = ? WHERE username = ?;";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setBoolean(1, false);
                statement.setString(2, username);
                statement.executeUpdate();
            } finally {
                ConexaoMySQL.fecharConexao(connection);
            }
        } catch (SQLException e) {
            logger.error("Erro ao desativar usuário: " + e.getMessage());
            throw new RuntimeException("Erro ao desativar usuário", e);
        }
    }

    public void ativarUsuarioPorUsername(String username) {
        try (Connection connection = ConexaoMySQL.conectar()) {
            String sql = "UPDATE usuario SET ativo = ? WHERE username = ?;";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setBoolean(1, true);
                statement.setString(2, username);
                statement.executeUpdate();
            } finally {
                ConexaoMySQL.fecharConexao(connection);
            }
        } catch (SQLException e) {
            logger.error("Erro ao desativar usuário: " + e.getMessage());
            throw new RuntimeException("Erro ao desativar usuário", e);
        }
    }

    public void atualizarUsuario(Usuario usuario) {
        try (Connection connection = ConexaoMySQL.conectar()) {
            String sql = "UPDATE usuario SET nome = ?, username = ?, senha = ?, tipo = ?, ativo = ? WHERE usuario_id = ?;";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, usuario.getNome());
                statement.setString(2, usuario.getUsername());
                statement.setString(3, usuario.getSenha());
                statement.setString(4, usuario.getTipo());
                statement.setBoolean(5, usuario.isAtivo());
                statement.setInt(6, usuario.getId());
                statement.executeUpdate();
            } finally {
                ConexaoMySQL.fecharConexao(connection);
            }
        } catch (SQLException e) {
            logger.error("Erro ao atualizar usuário: " + e.getMessage());
            throw new RuntimeException("Erro ao atualizar usuário", e);
        }
    }

    public Usuario buscarUsuarioPorId(int id) {
        Usuario usuario = new Usuario();
        try (Connection connection = ConexaoMySQL.conectar()) {
            String sql = "SELECT * FROM usuario WHERE usuario_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        usuario.setId(resultSet.getInt("usuario_id"));
                        usuario.setNome(resultSet.getString("nome"));
                        usuario.setUsername(resultSet.getString("username"));
                        usuario.setSenha(resultSet.getString("senha"));
                        usuario.setTipo(resultSet.getString("tipo"));
                        usuario.setAtivo(resultSet.getBoolean("ativo"));
                    } else {
                        logger.warn("usuario não encontrado para o ID: " + id);
                    }
                }
            } finally {
                ConexaoMySQL.fecharConexao(connection);
            }
        } catch (SQLException e) {
            logger.error("Erro ao buscar usuário por id: " + e.getMessage());
            throw new RuntimeException("Erro ao buscar usuário por id", e);
        }
        return usuario;
    }

    public Usuario buscarUsuarioPorUsername(String username) {
        Usuario usuario = new Usuario();
        try (Connection connection = ConexaoMySQL.conectar()) {
            String sql = "SELECT * FROM usuario WHERE username = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, username);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        usuario.setId(resultSet.getInt("usuario_id"));
                        usuario.setNome(resultSet.getString("nome"));
                        usuario.setUsername(resultSet.getString("username"));
                        usuario.setSenha(resultSet.getString("senha"));
                        usuario.setTipo(resultSet.getString("tipo"));
                        usuario.setAtivo(resultSet.getBoolean("ativo"));
                    } else {
                        logger.warn("usuario não encontrado para o username: " + username);
                    }
                }
            } finally {
                ConexaoMySQL.fecharConexao(connection);
            }
        } catch (SQLException e) {
            logger.error("Erro ao buscar usuário por id: " + e.getMessage());
            throw new RuntimeException("Erro ao buscar usuário por id", e);
        }
        return usuario;
    }
}
