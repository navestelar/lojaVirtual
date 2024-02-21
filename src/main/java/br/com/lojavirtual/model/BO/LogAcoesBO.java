package br.com.lojavirtual.model.BO;

import java.util.List;

import br.com.lojavirtual.interfaces.DataPersistence;
import br.com.lojavirtual.interfaces.PersistenceType;
import br.com.lojavirtual.model.DAO.PersistenceFactory;
import br.com.lojavirtual.model.DTO.LogAcoes;

public class LogAcoesBO {
  private DataPersistence<LogAcoes> dataPersistence;

  public LogAcoesBO(PersistenceType persistenceType) {
    this.dataPersistence = PersistenceFactory.setDataPersistence(LogAcoes.class, persistenceType);
  }

  public void cadastrarLogAcoes(LogAcoes logAcoes) {
    if (logAcoes.getId() <= 0) {
      logAcoes.setId(dataPersistence.getNextId());
    }
  
    dataPersistence.create(logAcoes);
  }

  public LogAcoes buscarLogAcoes(int id) {
    return dataPersistence.read(id);
  }

  public void atualizarLogAcoes(LogAcoes logAcoes) {
    dataPersistence.update(logAcoes);
  }

  public void deletarLogAcoes(int id) {
    dataPersistence.delete(id);
  }

  public List<LogAcoes> listarLogAcoes() {
    return dataPersistence.readAll();
  }
}
