package br.com.lojavirtual.model.BO;

import java.util.List;

import br.com.lojavirtual.interfaces.DataPersistence;
import br.com.lojavirtual.interfaces.PersistenceType;
import br.com.lojavirtual.model.DAO.PersistenceFactory;
import br.com.lojavirtual.model.DTO.Usuario;

public class UsuarioBO {
  private DataPersistence<Usuario> dataPersistence;

  public UsuarioBO(PersistenceType persistenceType) {
    this.dataPersistence = PersistenceFactory.setDataPersistence(Usuario.class, persistenceType);
  }

  public void cadastrarUsuario(Usuario usuario) {
    if (usuario.getId() <= 0) {
      usuario.setId(dataPersistence.getNextId());
    }
  
    dataPersistence.create(usuario);
  }

  public Usuario buscarUsuario(int id) {
    return dataPersistence.read(id);
  }

  public void atualizarUsuario(Usuario usuario) {
    dataPersistence.update(usuario);
  }

  public void deletarUsuario(int id) {
    dataPersistence.delete(id);
  }

  public List<Usuario> listarUsuarios() {
    return dataPersistence.readAll();
  }
}
