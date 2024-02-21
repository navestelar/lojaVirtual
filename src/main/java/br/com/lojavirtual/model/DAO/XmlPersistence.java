package br.com.lojavirtual.model.DAO;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.com.lojavirtual.interfaces.DataPersistence;
import br.com.lojavirtual.interfaces.DefaultEntitiesInterface;

class XmlPersistence<T extends DefaultEntitiesInterface> implements DataPersistence<T> {
  private Class<T> clazz;
  private File file;

  public XmlPersistence(Class<T> clazz) {
    this.clazz = clazz;
    this.file = getFile();
  }

  private File getFile() {
    String tableName = clazz.getSimpleName().toLowerCase();
    return new File("data/xml/" + tableName + ".xml");
  }

  @Override
  public void create(T object) {
    List<T> objects = readAll();
    objects.add(object);
    writeAll(objects);
  }

  @Override
  public T read(int id) {
    List<T> objects = readAll();
    for (T obj : objects) {
      if (obj.getId() == id) {
        return obj;
      }
    }
    return null;
  }

  @Override
  public void update(T object) {
    List<T> objects = readAll();
    for (int i = 0; i < objects.size(); i++) {
      T obj = objects.get(i);
      if (obj.getId() == object.getId()) {
        objects.set(i, object);
        break;
      }
    }
    writeAll(objects);
  }

  @Override
  public void delete(int id) {
    List<T> objects = readAll();
    Iterator<T> iterator = objects.iterator();
    while (iterator.hasNext()) {
      T obj = iterator.next();
      if (obj.getId() == id) {
        iterator.remove();
      }
    }
    writeAll(objects);
  }

  @Override
  public List<T> readAll() {
    List<T> resultList = new ArrayList<>();
    if (file.exists() && file.length() > 0) {
      try {
        JAXBContext jaxbContext = JAXBContext.newInstance(XmlItems.class, clazz);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        @SuppressWarnings("unchecked")
        XmlItems<T> xmlItems = (XmlItems<T>) jaxbUnmarshaller.unmarshal(file);
        resultList = xmlItems.getItems();
      } catch (JAXBException e) {
        e.printStackTrace();
      }
    }
    return resultList;
  }

  @Override
  public int getNextId() {
    List<T> objects = this.readAll();
    int maxId = 0;
  
    for (T object : objects) {
      if (object.getId() > maxId) {
        maxId = object.getId();
      }
    }
  
    return maxId + 1;
  }
  
  public void writeAll(List<T> objects) {
    XmlItems<T> xmlItems = new XmlItems<>();
    xmlItems.setItems(objects);

    try {
      JAXBContext jaxbContext = JAXBContext.newInstance(XmlItems.class, clazz);
      Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      jaxbMarshaller.marshal(xmlItems, file);
    } catch (JAXBException e) {
      e.printStackTrace();
    }
  }
}
