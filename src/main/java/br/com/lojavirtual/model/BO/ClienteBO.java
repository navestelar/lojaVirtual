package br.com.lojavirtual.model.BO;

import java.util.List;

import br.com.lojavirtual.interfaces.DataPersistence;
import br.com.lojavirtual.interfaces.PersistenceType;
import br.com.lojavirtual.model.DAO.PersistenceFactory;
import br.com.lojavirtual.model.DTO.Cliente;

public class ClienteBO extends UsuarioBO {
  private DataPersistence<Cliente> dataPersistence;

  public ClienteBO(PersistenceType persistenceType) {
    super(persistenceType);
    this.dataPersistence = PersistenceFactory.setDataPersistence(Cliente.class, persistenceType);
  }

  public boolean cadastrarCliente(Cliente cliente) {
    if (cliente.getId() <= 0) {
      cliente.setId(dataPersistence.getNextId());
    }
  
    return dataPersistence.create(cliente);
  }

  public Cliente buscarCliente(int id) {
    return dataPersistence.read(id);
  }

  public boolean atualizarCliente(Cliente cliente) {
    return dataPersistence.update(cliente);
  }

  public boolean deletarCliente(int id) {
    return dataPersistence.delete(id);
  }

  public List<Cliente> listarClientes() {
    return dataPersistence.readAll();
  }
}
