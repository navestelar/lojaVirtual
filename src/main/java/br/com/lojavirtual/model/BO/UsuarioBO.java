package br.com.lojavirtual.model.BO;

import java.util.List;

import br.com.lojavirtual.interfaces.DataPersistence;
import br.com.lojavirtual.interfaces.PersistenceType;
import br.com.lojavirtual.interfaces.UserType;
import br.com.lojavirtual.model.DAO.PersistenceFactory;
import br.com.lojavirtual.model.DTO.Usuario;

public class UsuarioBO {
  private DataPersistence<Usuario> dataPersistence;

  public UsuarioBO(PersistenceType persistenceType) {
    this.dataPersistence = PersistenceFactory.setDataPersistence(Usuario.class, persistenceType);
  }

  public boolean cadastrarUsuario(Usuario usuario) {
    if (usuario.getId() <= 0) {
      usuario.setId(dataPersistence.getNextId());
    }
  
    return dataPersistence.create(usuario);
  }

  public Usuario buscarUsuario(int id) {
    return dataPersistence.read(id);
  }

  public boolean atualizarUsuario(Usuario usuario) {
    return dataPersistence.update(usuario);
  }

  public boolean deletarUsuario(int id) {
    return dataPersistence.delete(id);
  }

  public List<Usuario> listarUsuarios() {
    return dataPersistence.readAll();
  }

  public Usuario getUsuarioByUsername(String username) {
    List<Usuario> usuarios = listarUsuarios();

    for (Usuario usuario : usuarios) {
      if (usuario.getUsername() == username) {
        return usuario;
      }
    }

    return null;
  }

  public UserType autenticar(Usuario usuario, String username, String senha) {
    if (usuario == null) {
      System.out.println("Não existe nenhum usuário com esse username em nosso sistema, cadastre-se ou tente outro username");
      return null;
    }

    if (usuario.getSenha() == senha) {
      if (usuario.getTipo() == UserType.ADMINISTRADOR.getLabel())
        return UserType.ADMINISTRADOR;
      return UserType.USUARIO;
    }

    System.out.println("");
    return null;
  }
}
