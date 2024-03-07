package br.com.lojavirtual.model.BO;

import java.util.List;

import br.com.lojavirtual.interfaces.DataPersistence;
import br.com.lojavirtual.interfaces.PersistenceType;
import br.com.lojavirtual.model.DAO.PersistenceFactory;
import br.com.lojavirtual.model.DTO.Administrador;

public class AdministradorBO extends UsuarioBO {
  private DataPersistence<Administrador> dataPersistence;

  public AdministradorBO(PersistenceType persistenceType) {
    super(persistenceType);
    this.dataPersistence = PersistenceFactory.setDataPersistence(Administrador.class, persistenceType);
  }

  public boolean cadastrarAdministrador(Administrador administrador) {
    if (administrador.getId() <= 0) {
      administrador.setId(dataPersistence.getNextId());
    }

    if (dataPersistence.create(administrador))
      return true;
    return false;
  }

  public Administrador buscarAdministrador(int id) {
    return dataPersistence.read(id);
  }

  public boolean atualizarAdministrador(Administrador administrador) {
    if (dataPersistence.update(administrador))
      return true;
    return false;
  }

  public boolean deletarAdministrador(int id) {
    if (dataPersistence.delete(id))
      return true;
    return false;
  }

  public List<Administrador> listarAdministradores() {
    return dataPersistence.readAll();
  }
}
