
package br.com.lojavirtual.model.DAO;

import br.com.lojavirtual.interfaces.DataPersistence;
import br.com.lojavirtual.interfaces.DefaultEntitiesInterface;
import br.com.lojavirtual.interfaces.PersistenceType;

public class PersistenceFactory {
  public static <T extends DefaultEntitiesInterface> DataPersistence<T> setDataPersistence(Class<T> clazz, PersistenceType format) {
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