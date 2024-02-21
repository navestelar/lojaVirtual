package br.com.lojavirtual.model.BO;

import java.util.List;

import br.com.lojavirtual.interfaces.DataPersistence;
import br.com.lojavirtual.interfaces.PersistenceType;
import br.com.lojavirtual.model.DAO.PersistenceFactory;
import br.com.lojavirtual.model.DTO.Fornecedor;

public class FornecedorBO {
  private DataPersistence<Fornecedor> dataPersistence;

  public FornecedorBO(PersistenceType persistenceType) {
    this.dataPersistence = PersistenceFactory.setDataPersistence(Fornecedor.class, persistenceType);
  }

  public void cadastrarFornecedor(Fornecedor fornecedor) {
    if (fornecedor.getId() <= 0) {
      fornecedor.setId(dataPersistence.getNextId());
    }
  
    dataPersistence.create(fornecedor);
  }

  public Fornecedor buscarFornecedor(int id) {
    return dataPersistence.read(id);
  }

  public void atualizarFornecedor(Fornecedor fornecedor) {
    dataPersistence.update(fornecedor);
  }

  public void deletarFornecedor(int id) {
    dataPersistence.delete(id);
  }

  public List<Fornecedor> listarFornecedores() {
    return dataPersistence.readAll();
  }
}
