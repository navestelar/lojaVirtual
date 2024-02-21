package br.com.lojavirtual.model.BO;

import java.util.List;

import br.com.lojavirtual.interfaces.DataPersistence;
import br.com.lojavirtual.interfaces.PersistenceType;
import br.com.lojavirtual.model.DAO.PersistenceFactory;
import br.com.lojavirtual.model.DTO.Administrador;

public class AdministradorBO {
  private DataPersistence<Administrador> dataPersistence;

  public AdministradorBO(PersistenceType persistenceType) {
    this.dataPersistence = PersistenceFactory.setDataPersistence(Administrador.class, persistenceType);
  }

  public void cadastrarAdministrador(Administrador administrador) {
    if (administrador.getId() <= 0) {
      administrador.setId(dataPersistence.getNextId());
    }
  
    dataPersistence.create(administrador);
  }

  public Administrador buscarAdministrador(int id) {
    return dataPersistence.read(id);
  }

  public void atualizarAdministrador(Administrador administrador) {
    dataPersistence.update(administrador);
  }

  public void deletarAdministrador(int id) {
    dataPersistence.delete(id);
  }

  public List<Administrador> listarAdministradores() {
    return dataPersistence.readAll();
  }
}
