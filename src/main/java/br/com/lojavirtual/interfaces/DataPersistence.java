package br.com.lojavirtual.interfaces;

import java.util.List;

public interface DataPersistence<T extends DefaultEntitiesInterface> {
  void create(T data);
  T read(int id);
  void update(T data);
  void delete(int id);
  List<T> readAll();
  int getNextId();
}