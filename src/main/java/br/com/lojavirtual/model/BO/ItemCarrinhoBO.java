package br.com.lojavirtual.model.BO;

import java.util.List;

import br.com.lojavirtual.interfaces.DataPersistence;
import br.com.lojavirtual.interfaces.PersistenceType;
import br.com.lojavirtual.model.DAO.PersistenceFactory;
import br.com.lojavirtual.model.DTO.ItemCarrinho;

public class ItemCarrinhoBO {
  private DataPersistence<ItemCarrinho> dataPersistence;

  public ItemCarrinhoBO(PersistenceType persistenceType) {
    this.dataPersistence = PersistenceFactory.setDataPersistence(ItemCarrinho.class, persistenceType);
  }

  public void cadastrarItemCarrinho(ItemCarrinho itemCarrinho) {
    if (itemCarrinho.getId() <= 0) {
      itemCarrinho.setId(dataPersistence.getNextId());
    }
  
    dataPersistence.create(itemCarrinho);
  }

  public ItemCarrinho buscarItemCarrinho(int id) {
    return dataPersistence.read(id);
  }

  public void atualizarItemCarrinho(ItemCarrinho itemCarrinho) {
    dataPersistence.update(itemCarrinho);
  }

  public void deletarItemCarrinho(int id) {
    dataPersistence.delete(id);
  }

  public List<ItemCarrinho> listarItensCarrinho() {
    return dataPersistence.readAll();
  }
}
