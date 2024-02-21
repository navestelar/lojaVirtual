package br.com.lojavirtual.model.BO;

import java.util.List;

import br.com.lojavirtual.interfaces.DataPersistence;
import br.com.lojavirtual.interfaces.PersistenceType;
import br.com.lojavirtual.model.DAO.PersistenceFactory;
import br.com.lojavirtual.model.DTO.FormaDePagamento;

public class FormaDePagamentoBO {
  private DataPersistence<FormaDePagamento> dataPersistence;

  public FormaDePagamentoBO(PersistenceType persistenceType) {
    this.dataPersistence = PersistenceFactory.setDataPersistence(FormaDePagamento.class, persistenceType);
  }

  public void cadastrarFormaDePagamento(FormaDePagamento formaDePagamento) {
    if (formaDePagamento.getId() <= 0) {
      formaDePagamento.setId(dataPersistence.getNextId());
    }
  
    dataPersistence.create(formaDePagamento);
  }

  public FormaDePagamento buscarFormaDePagamento(int id) {
    return dataPersistence.read(id);
  }

  public void atualizarFormaDePagamento(FormaDePagamento formaDePagamento) {
    dataPersistence.update(formaDePagamento);
  }

  public void deletarFormaDePagamento(int id) {
    dataPersistence.delete(id);
  }

  public List<FormaDePagamento> listarFormasDePagamento() {
    return dataPersistence.readAll();
  }
}
