package br.com.lojavirtual.model.BO;

import java.util.List;

import br.com.lojavirtual.interfaces.DataPersistence;
import br.com.lojavirtual.interfaces.PersistenceType;
import br.com.lojavirtual.model.DAO.PersistenceFactory;
import br.com.lojavirtual.model.DTO.Imagem;
import br.com.lojavirtual.model.DTO.ItemCarrinho;
import br.com.lojavirtual.model.DTO.Produto;

public class ProdutoBO {
  private DataPersistence<Produto> dataPersistence;
  private ImagemBO imagemBO;
  private ItemCarrinhoBO itemCarrinhoBO;

  public ProdutoBO(PersistenceType persistenceType) {
    this.dataPersistence = PersistenceFactory.setDataPersistence(Produto.class, persistenceType);
    this.imagemBO = new ImagemBO(persistenceType);
    this.itemCarrinhoBO = new ItemCarrinhoBO(persistenceType);
  }

  public void cadastrarProduto(Produto produto) {
    if (produto.getId() <= 0) {
      produto.setId(dataPersistence.getNextId());
    }

    dataPersistence.create(produto);
  }

  public Produto buscarProduto(int id) {
    return dataPersistence.read(id);
  }

  public void atualizarProduto(Produto produto) {
    dataPersistence.update(produto);
  }

  public void deletarProduto(int id) {
    List<Imagem> imagens = imagemBO.listarImagens();
    for (Imagem imagem : imagens) {
      if (imagem.getProdutoId() == id) {
        imagem.setProdutoId(null);
        imagemBO.atualizarImagem(imagem);
      }
    }

    List<ItemCarrinho> itensCarrinho = itemCarrinhoBO.listarItensCarrinho();
    for (ItemCarrinho itemCarrinho : itensCarrinho) {
      if (itemCarrinho.getProdutoId() == id) {
        itemCarrinhoBO.deletarItemCarrinho(id);
      }
    }

    dataPersistence.delete(id);
  }

  public List<Produto> listarProdutos() {
    return dataPersistence.readAll();
  }
}
