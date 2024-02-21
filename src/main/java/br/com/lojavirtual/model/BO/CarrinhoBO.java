package br.com.lojavirtual.model.BO;

import java.util.List;

import br.com.lojavirtual.interfaces.DataPersistence;
import br.com.lojavirtual.interfaces.PersistenceType;
import br.com.lojavirtual.model.DAO.PersistenceFactory;
import br.com.lojavirtual.model.DTO.Carrinho;

public class CarrinhoBO {
  private DataPersistence<Carrinho> dataPersistence;

  public CarrinhoBO(PersistenceType persistenceType) {
    this.dataPersistence = PersistenceFactory.setDataPersistence(Carrinho.class, persistenceType);
  }

  public void cadastrarCarrinho(Carrinho carrinho) {
    if (carrinho.getId() <= 0) {
      carrinho.setId(dataPersistence.getNextId());
    }
  
    dataPersistence.create(carrinho);
  }

  public Carrinho buscarCarrinho(int id) {
    return dataPersistence.read(id);
  }

  public void atualizarCarrinho(Carrinho carrinho) {
    dataPersistence.update(carrinho);
  }

  public void deletarCarrinho(int id) {
    dataPersistence.delete(id);
  }

  public List<Carrinho> listarCarrinhos() {
    return dataPersistence.readAll();
  }
}
