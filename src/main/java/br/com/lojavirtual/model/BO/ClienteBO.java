package br.com.lojavirtual.model.BO;

import java.util.List;

import br.com.lojavirtual.interfaces.DataPersistence;
import br.com.lojavirtual.interfaces.PersistenceType;
import br.com.lojavirtual.model.DAO.PersistenceFactory;
import br.com.lojavirtual.model.DTO.Cliente;

public class ClienteBO {
  private DataPersistence<Cliente> dataPersistence;

  public ClienteBO(PersistenceType persistenceType) {
    this.dataPersistence = PersistenceFactory.setDataPersistence(Cliente.class, persistenceType);
  }

  public void cadastrarCliente(Cliente cliente) {
    if (cliente.getId() <= 0) {
      cliente.setId(dataPersistence.getNextId());
    }
  
    dataPersistence.create(cliente);
  }

  public Cliente buscarCliente(int id) {
    return dataPersistence.read(id);
  }

  public void atualizarCliente(Cliente cliente) {
    dataPersistence.update(cliente);
  }

  public void deletarCliente(int id) {
    dataPersistence.delete(id);
  }

  public List<Cliente> listarClientes() {
    return dataPersistence.readAll();
  }
}
