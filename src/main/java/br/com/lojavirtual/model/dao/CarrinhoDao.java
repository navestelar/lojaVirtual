// package br.com.lojavirtual.model.DAO;

// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.util.HashMap;

// import br.com.lojavirtual.ConexaoMYSQL.Conexao;
// import br.com.lojavirtual.model.DTO.Carrinho;

// public class CarrinhoDAO {
//     final String tabela = "carrinho";
//     private static final HashMap<String, Carrinho> mapCarrinhos = new HashMap<>();

//     public boolean inserir(Carrinho carrinho) {
//         Connection conexao = Conexao.conectar();
//         String sql = " INSERT INTO " + tabela + " ( carrinho_id, nome, username, senha, tipo, ativo ) VALUES (?); ";
//         try (PreparedStatement statement = conexao.prepareStatement(sql)) {
//             statement.setInt(1, carrinho.getId());
//             statement.setString(2, carrinho.getNome());
//             statement.setString(3, carrinho.getUsername());
//             statement.setString(4, carrinho.getSenha());
//             statement.setString(5, carrinho.getTipo());
//             statement.setBoolean(6, carrinho.isAtivo());
//             statement.executeUpdate();
//             statement.close();
//             conexao.close();
//             return true;
//         } catch (SQLException e) {
//             System.out.println("Erro ao inserir carrinho no banco de dados.");
//             return false;
//         }
//     }

//     public boolean alterar(Carrinho carrinho) {
//         Connection conexao = Conexao.conectar();
//         String sql = " UPDATE " + tabela + " SET nome = ?, username = ?, senha = ?, tipo = ?, ativo = ? WHERE "+tabela+"_id = ? ";
//         try (PreparedStatement statement = conexao.prepareStatement(sql)) {
//             statement.setString(1, carrinho.getNome());
//             statement.setString(2, carrinho.getUsername());
//             statement.setString(3, carrinho.getSenha());
//             statement.setString(4, carrinho.getTipo());
//             statement.setBoolean(5, carrinho.isAtivo());
//             statement.setInt(6, carrinho.getId());
//             statement.executeUpdate();
//             statement.close();
//             conexao.close();
//             return true;
//         } catch (SQLException e) {
//             System.out.println("Erro ao alterar dados do carrinho no banco de dados.");
//             return false;
//         }
//     }

//     public boolean excluir(Carrinho carrinho) {
//         Connection conexao = Conexao.conectar();
//         String sql = " DELETE FROM " + tabela + "  WHERE "+tabela+"_id = ? ";
//         try (PreparedStatement statement = conexao.prepareStatement(sql)) {
//             statement.setInt(1, carrinho.getId());
//             statement.executeUpdate();
//             statement.close();
//             conexao.close();
//             return true;
//         } catch (SQLException e) {
//             System.out.println("Erro ao excluir carrinho no banco de dados.");
//             return false;
//         }
//     }

//     public Carrinho procurarPorId(int id) {
//         Connection conexao = Conexao.conectar();
//         String sql = " SELECT * FROM " + tabela + " WHERE "+tabela+"_id = ? ";
//         try (PreparedStatement statement = conexao.prepareStatement(sql)) {
//             statement.setInt(1, id);
//             try (ResultSet resultSet = statement.executeQuery()) {
//                 if (resultSet.next()) {
//                     Carrinho carrinho = new Carrinho();
//                     carrinho.setId(resultSet.getInt("carrinho_id"));
//                     carrinho.setNome(resultSet.getString("nome"));
//                     carrinho.setUsername(resultSet.getString("username"));
//                     carrinho.setSenha(resultSet.getString("senha"));
//                     carrinho.setTipo(resultSet.getString("tipo"));
//                     carrinho.setAtivo(resultSet.getBoolean("ativo"));
//                     statement.close();
//                     conexao.close();
//                     return carrinho;
//                 } else {
//                     statement.close();
//                     conexao.close();
//                     System.err.println("carrinho não encontrado para o ID: " + id);
//                     return null;
//                 }
//             }            
//         } catch (SQLException e) {
//             System.out.println("Erro ao alterar dados do carrinho no banco de dados.");
//             return null;
//         }
//     }

//     public boolean existe(Carrinho carrinho) {
//         Connection conexao = Conexao.conectar();
//         String sql = " SELECT * FROM " + tabela + " WHERE "+tabela+"_id = ?";
//         try (PreparedStatement statement = conexao.prepareStatement(sql)) {
//             statement.setString(1, carrinho.getUsername());
//             statement.setInt(2, carrinho.getId());
//             try (ResultSet resultSet = statement.executeQuery()) {
//                 if (resultSet.next()) {
//                     statement.close();
//                     conexao.close();
//                     return true;
//                 }
//             }            
//         } catch (SQLException e) {
//             System.out.println("Erro ao verificar se existe carrinho no banco de dados.");
//             return false;
//         }
//         return false;
//     }

//     public boolean existePorId(int id) {
//         Connection conexao = Conexao.conectar();
//         String sql = " SELECT * FROM " + tabela + " WHERE "+tabela+"_id = ? ";
//         try (PreparedStatement statement = conexao.prepareStatement(sql)) {
//             statement.setInt(1, id);
//             try (ResultSet resultSet = statement.executeQuery()) {
//                 if (resultSet.next()) {
//                     statement.close();
//                     conexao.close();
//                     return true;
//                 }
//             }            
//         } catch (SQLException e) {
//             System.out.println("Erro ao verificar se existe carrinho no banco de dados.");
//             return false;
//         }
//         return false;
//     }

//     private void atualizarMapCarrinhos() {
//         try (Connection connection = Conexao.conectar()) {
//             String sql = "SELECT * FROM carrinho";
//             try (PreparedStatement statement = connection.prepareStatement(sql)) {
//                 try (ResultSet resultSet = statement.executeQuery()) {
//                     mapCarrinhos.clear();
//                     while (resultSet.next()) {
//                         Carrinho carrinho = new Carrinho();
//                         carrinho.setId(resultSet.getInt("carrinho_id"));
//                         carrinho.setNome(resultSet.getString("nome"));
//                         carrinho.setUsername(resultSet.getString("username"));
//                         carrinho.setSenha(resultSet.getString("senha"));
//                         carrinho.setTipo(resultSet.getString("tipo"));
//                         carrinho.setAtivo(resultSet.getBoolean("ativo"));
//                         mapCarrinhos.put(carrinho.getUsername(), carrinho);
//                     }
//                 }
//             } finally {
//                 connection.close();
//             }
//         } catch (SQLException e) {
//             throw new RuntimeException("Erro ao atualizar lista de carrinhos", e);
//         }
//     }

//     public HashMap<String, Carrinho> listarCarrinhos() {
//         atualizarMapCarrinhos();
//         return new HashMap<>(mapCarrinhos);
//     }
// }
