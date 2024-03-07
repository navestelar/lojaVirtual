package br.com.lojavirtual.interfaces;

import java.util.List;

public interface DataPersistence<T extends DefaultEntitiesInterface> {
  boolean create(T data);
  T read(int id);
  boolean update(T data);
  boolean delete(int id);
  List<T> readAll();
  int getNextId();
}