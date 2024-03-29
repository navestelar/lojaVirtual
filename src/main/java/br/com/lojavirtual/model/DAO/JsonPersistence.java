package br.com.lojavirtual.model.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;

import br.com.lojavirtual.interfaces.DataPersistence;
import br.com.lojavirtual.interfaces.DefaultEntitiesInterface;

class JsonPersistence<T extends DefaultEntitiesInterface> implements DataPersistence<T> {
  private Class<T> clazz;
  private File file;
  private Gson gson;

  public JsonPersistence(Class<T> clazz) {
    this.clazz = clazz;
    this.file = getFile();
    this.gson = new Gson();
  }

  private File getFile() {
    String tableName = clazz.getSimpleName().toLowerCase();
    return new File("data/json/" + tableName + ".json");
  }

  @Override
  public boolean create(T object) {
    try (FileWriter writer = new FileWriter(file, true)) {
      String json = gson.toJson(object);
      writer.write(json + "\n");
      return true;
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public T read(int id) {
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = reader.readLine()) != null) {
        T object = gson.fromJson(line, clazz);
        if (object != null && object.getId() == id) {
          return object;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return null;
  }

  @Override
  public boolean update(T object) {
    List<T> objects = readAll();

    for (int i = 0; i < objects.size(); i++) {
      T obj = objects.get(i);
      if (obj.getId() == object.getId()) {
        objects.set(i, object);
        break;
      }
    }

    return writeAll(objects);
  }

  @Override
  public boolean delete(int id) {
    List<T> objects = readAll();

    for (Iterator<T> iterator = objects.iterator(); iterator.hasNext();) {
      T obj = iterator.next();
      if (obj.getId() == id) {
        iterator.remove();
      }
    }

    return writeAll(objects);
  }

  @Override
  public List<T> readAll() {
    List<T> resultList = new ArrayList<>();
    if (file.exists() && file.length() > 0) {
      try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        String line;
        while ((line = reader.readLine()) != null) {
          T obj = gson.fromJson(line, clazz);
          resultList.add(obj);
        }
      } catch (IOException e) {
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

  private boolean writeAll(List<T> objects) {
    try (FileWriter writer = new FileWriter(file)) {
      for (T obj : objects) {
        String json = gson.toJson(obj);
        writer.write(json + "\n");
      }
      return true;
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  }

}
