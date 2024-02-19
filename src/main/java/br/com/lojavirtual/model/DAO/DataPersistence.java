package br.com.lojavirtual.model.DAO;

import java.util.List;

import br.com.lojavirtual.model.DTO.DefaultInterface;

public interface DataPersistence<T extends DefaultInterface> {
  void create(T data);
  T read(int id);
  void update(T data);
  void delete(int id);
  List<T> readAll();
}