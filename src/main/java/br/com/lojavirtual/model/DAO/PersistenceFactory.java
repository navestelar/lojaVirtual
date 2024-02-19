
package br.com.lojavirtual.model.DAO;

import br.com.lojavirtual.model.DTO.DefaultInterface;

public class PersistenceFactory {
  public static <T extends DefaultInterface> DataPersistence<T> setDataPersistence(Class<T> clazz, PersistenceType format) {
    switch (format) {
      case DATABASE:
        return new DatabasePersistence<>(clazz);
      case JSON:
        return new JsonPersistence<>(clazz);
      case XML:
        return new XmlPersistence<>(clazz);
      default:
        throw new IllegalArgumentException("Formato de persistência inválido: " + format);
    }
  }
}