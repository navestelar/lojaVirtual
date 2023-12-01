package br.com.lojavirtual.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import br.com.lojavirtual.ConexaoMYSQL.Conexao;
import br.com.lojavirtual.model.DTO.Cliente;

public class ClienteDAO {
    final String tabela = "cliente";
    private static final HashMap<String, Cliente> mapClientes = new HashMap<>();

    public boolean inserir(Cliente cliente) {
        Connection conexao = Conexao.conectar();
        String sql = " INSERT INTO " + tabela + " ( cliente_id, email, telefone, endereco, cep ) VALUES (?, ?, ?, ?, ?); ";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, cliente.getId());
            statement.setString(2, cliente.getEmail());
            statement.setString(3, cliente.getTelefone());
            statement.setString(4, cliente.getEndereco());
            statement.setString(5, cliente.getCep());
            statement.executeUpdate();
            statement.close();
            conexao.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir cliente no banco de dados.");
            return false;
        }
    }

    public boolean alterar(Cliente cliente) {
        Connection conexao = Conexao.conectar();
        String sql = " UPDATE " + tabela + " SET email = ?, telefone = ?, endereco = ?, cep = ? WHERE "+tabela+"_id = ? ";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, cliente.getEmail());
            statement.setString(2, cliente.getTelefone());
            statement.setString(3, cliente.getEndereco());
            statement.setString(4, cliente.getCep());
            statement.setInt(5, cliente.getId());
            statement.executeUpdate();
            statement.close();
            conexao.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao alterar dados do cliente no banco de dados.");
            return false;
        }
    }

    public boolean excluir(Cliente cliente) {
        Connection conexao = Conexao.conectar();
        String sql = " DELETE FROM " + tabela + "  WHERE "+tabela+"_id = ? ";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, cliente.getId());
            statement.executeUpdate();
            statement.close();
            conexao.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir cliente no banco de dados.");
            return false;
        }
    }

    public Cliente procurarPorId(int id) {
        Connection conexao = Conexao.conectar();
        String sql = " SELECT * FROM " + tabela + " WHERE "+tabela+"_id = ? ";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setId(resultSet.getInt("cliente_id"));
                    cliente.setEmail(resultSet.getString("email"));
                    cliente.setTelefone(resultSet.getString("telefone"));
                    cliente.setEndereco(resultSet.getString("endereco"));
                    cliente.setCep(resultSet.getString("cep"));
                    statement.close();
                    conexao.close();
                    return cliente;
                } else {
                    statement.close();
                    conexao.close();
                    System.err.println("cliente não encontrado para o ID: " + id);
                    return null;
                }
            }            
        } catch (SQLException e) {
            System.out.println("Erro ao alterar dados do cliente no banco de dados.");
            return null;
        }
    }

    public boolean existe(Cliente cliente) {
        Connection conexao = Conexao.conectar();
        String sql = " SELECT * FROM " + tabela +" "+tabela+"_id = ?";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, cliente.getId());
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    statement.close();
                    conexao.close();
                    return true;
                }
            }            
        } catch (SQLException e) {
            System.out.println("Erro ao verificar se existe cliente no banco de dados.");
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
            System.out.println("Erro ao verificar se existe cliente no banco de dados.");
            return false;
        }
        return false;
    }

    private void atualizarMapClientes() {
        try (Connection connection = Conexao.conectar()) {
            String sql = "SELECT * FROM cliente";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    mapClientes.clear();
                    while (resultSet.next()) {
                        Cliente cliente = new Cliente();
                       cliente.setId(resultSet.getInt("cliente_id"));
                        cliente.setEmail(resultSet.getString("email"));
                        cliente.setTelefone(resultSet.getString("telefone"));
                        cliente.setEndereco(resultSet.getString("endereco"));
                        cliente.setCep(resultSet.getString("cep"));
                        mapClientes.put(cliente.getUsername(), cliente);
                    }
                }
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar lista de clientes", e);
        }
    }

    public HashMap<String, Cliente> listarClientes() {
        atualizarMapClientes();
        return new HashMap<>(mapClientes);
    }
}
