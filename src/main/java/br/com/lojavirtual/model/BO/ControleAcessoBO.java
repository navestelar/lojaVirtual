package br.com.lojavirtual.model.BO;

import java.util.List;

import br.com.lojavirtual.interfaces.DataPersistence;
import br.com.lojavirtual.interfaces.PersistenceType;
import br.com.lojavirtual.model.DAO.PersistenceFactory;
import br.com.lojavirtual.model.DTO.ControleAcesso;

public class ControleAcessoBO {
  private DataPersistence<ControleAcesso> dataPersistence;

  public ControleAcessoBO(PersistenceType persistenceType) {
    this.dataPersistence = PersistenceFactory.setDataPersistence(ControleAcesso.class, persistenceType);
  }

  public void cadastrarControleAcesso(ControleAcesso controleAcesso) {
    if (controleAcesso.getId() <= 0) {
      controleAcesso.setId(dataPersistence.getNextId());
    }
  
    dataPersistence.create(controleAcesso);
  }

  public ControleAcesso buscarControleAcesso(int id) {
    return dataPersistence.read(id);
  }

  public void atualizarControleAcesso(ControleAcesso controleAcesso) {
    dataPersistence.update(controleAcesso);
  }

  public void deletarControleAcesso(int id) {
    dataPersistence.delete(id);
  }

  public List<ControleAcesso> listarControlesAcesso() {
    return dataPersistence.readAll();
  }
}
