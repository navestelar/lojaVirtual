package br.com.lojavirtual.model.BO;

import java.util.List;

import br.com.lojavirtual.model.DAO.DataPersistence;
import br.com.lojavirtual.model.DAO.PersistenceFactory;
import br.com.lojavirtual.model.DAO.PersistenceType;
import br.com.lojavirtual.model.DTO.Produto;

public class ProdutoBO {
  private DataPersistence<Produto> dataPersistence;

  public ProdutoBO(PersistenceType persistenceType) {
    this.dataPersistence = PersistenceFactory.setDataPersistence(Produto.class, persistenceType);
  }

  public void cadastrarProduto(Produto produto) {
    if (dataPersistence.read(produto.getId()) == null) {
      dataPersistence.create(produto);
    } else {
      System.out.println("Já existe um produto com esse id.");
    }
  }

  public Produto buscarProduto(int id) {
    return dataPersistence.read(id);
  }

  public void atualizarProduto(Produto produto) {
    dataPersistence.update(produto);
  }

  public void deletarProduto(int id) {
    dataPersistence.delete(id);
  }

  public List<Produto> listarProdutos() {
    return dataPersistence.readAll();
  }
}
