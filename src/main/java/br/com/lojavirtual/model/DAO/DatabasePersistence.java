package br.com.lojavirtual.model.DAO;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.lojavirtual.ConexaoMYSQL.Conexao;
import br.com.lojavirtual.model.DTO.DefaultInterface;

public class DatabasePersistence<T extends DefaultInterface> implements DataPersistence<T> {
  private Class<T> clazz;

  public DatabasePersistence(Class<T> clazz) {
    this.clazz = clazz;
  }

  @Override
  public void create(T object) {
    String tableName = clazz.getSimpleName().toLowerCase();
    String sql = "INSERT INTO " + tableName + " (";
    String values = " VALUES (";
    Field[] fields = clazz.getDeclaredFields();

    List<Object> valuesList = new ArrayList<>();
    for (Field field : fields) {
      field.setAccessible(true);
      String fieldName = field.getName();
      try {
        Object value = field.get(object);
        if ((value instanceof Integer && (Integer) value == 0)
            || (value instanceof String && ((String) value).isEmpty())) {
          continue;
        }
        sql += fieldName + ", ";
        values += "?, ";
        valuesList.add(value);
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }
    }
    // Remove a última vírgula e espaço em branco das strings SQL
    if (sql.endsWith(", ")) {
      sql = sql.substring(0, sql.length() - 2);
    }
    if (values.endsWith(", ")) {
      values = values.substring(0, values.length() - 2);
    }
    sql += ")";
    values += ")";
    sql += values;

    try (Connection connection = Conexao.conectar();
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
      int paramIndex = 1;
      for (Object value : valuesList) {
        statement.setObject(paramIndex++, value);
      }
      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public T read(int id) {
    String tableName = clazz.getSimpleName().toLowerCase();
    String sql = "SELECT * FROM " + tableName + " WHERE " + tableName + "_id = ?";
    try (Connection connection = Conexao.conectar();
        PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setInt(1, id);
      try (ResultSet resultSet = statement.executeQuery()) {
        if (resultSet.next()) {
          T object = clazz.getDeclaredConstructor().newInstance();
          Field[] fields = clazz.getDeclaredFields();
          for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = resultSet.getObject(fieldName);
            if (value != null) {
              field.set(object, value);
            }
          }
          return object;
        }
      }
    } catch (SQLException | InstantiationException | IllegalAccessException | NoSuchMethodException
        | InvocationTargetException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public void update(T object) {
    String tableName = clazz.getSimpleName().toLowerCase();
    String sql = "UPDATE " + tableName + " SET ";
    Field[] fields = clazz.getDeclaredFields();

    List<Object> valuesList = new ArrayList<>();
    String idFieldName = "";
    Object idValue = null;

    for (Field field : fields) {
      field.setAccessible(true);
      String fieldName = field.getName();
      try {
        Object value = field.get(object);
        if (fieldName.endsWith("_id") && fieldName.equals(tableName.toLowerCase() + "_id")) {
          idFieldName = fieldName;
          idValue = value;
        } else {
          sql += fieldName + " = ?, ";
          valuesList.add(value);
        }
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }
    }

    // Remove a última vírgula e espaço em branco da string SQL
    if (sql.endsWith(", ")) {
      sql = sql.substring(0, sql.length() - 2);
    }

    sql += " WHERE " + idFieldName + " = ?";

    try (Connection connection = Conexao.conectar();
        PreparedStatement statement = connection.prepareStatement(sql)) {
      int paramIndex = 1;
      for (Object value : valuesList) {
        statement.setObject(paramIndex++, value);
      }
      // Define o valor do parâmetro para a cláusula WHERE
      statement.setObject(paramIndex, idValue);
      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void delete(int id) {
    String tableName = clazz.getSimpleName().toLowerCase();
    String sql = "DELETE FROM " + tableName + " WHERE " + tableName + "_id = ?";
    try (Connection connection = Conexao.conectar();
        PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setInt(1, id);
      int rowsAffected = statement.executeUpdate();
      if (rowsAffected == 0) {
        System.out.println("Nenhum registro foi excluído com o ID: " + id);
      } else {
        System.out.println("Registro excluído com sucesso!");
      }
    } catch (SQLException e) {
      System.out.println("Erro ao tentar excluir o registro com o ID: " + id);
      e.printStackTrace();
    }
  }

  @Override
  public List<T> readAll() {
    String tableName = clazz.getSimpleName().toLowerCase();
    String sql = "SELECT * FROM " + tableName;
    List<T> resultList = new ArrayList<>();
    try (Connection connection = Conexao.conectar();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery()) {
      while (resultSet.next()) {
        T object = clazz.getDeclaredConstructor().newInstance();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
          field.setAccessible(true);
          String fieldName = field.getName();
          Object value = resultSet.getObject(fieldName);
          if (value != null) {
            field.set(object, value);
          }
        }
        resultList.add(object);
      }
    } catch (SQLException | InstantiationException | IllegalAccessException | NoSuchMethodException
        | InvocationTargetException e) {
      e.printStackTrace();
    }
    return resultList;
  }
}