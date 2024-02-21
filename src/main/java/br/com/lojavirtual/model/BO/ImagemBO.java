package br.com.lojavirtual.model.BO;

import java.util.List;

import br.com.lojavirtual.interfaces.DataPersistence;
import br.com.lojavirtual.interfaces.PersistenceType;
import br.com.lojavirtual.model.DAO.PersistenceFactory;
import br.com.lojavirtual.model.DTO.Imagem;

public class ImagemBO {
  private DataPersistence<Imagem> dataPersistence;

  public ImagemBO(PersistenceType persistenceType) {
    this.dataPersistence = PersistenceFactory.setDataPersistence(Imagem.class, persistenceType);
  }

  public void cadastrarImagem(Imagem imagem) {
    if (imagem.getId() <= 0) {
      imagem.setId(dataPersistence.getNextId());
    }
  
    dataPersistence.create(imagem);
  }

  public Imagem buscarImagem(int id) {
    return dataPersistence.read(id);
  }

  public void atualizarImagem(Imagem imagem) {
    dataPersistence.update(imagem);
  }

  public void deletarImagem(int id) {
    dataPersistence.delete(id);
  }

  public List<Imagem> listarImagens() {
    return dataPersistence.readAll();
  }
}
