package br.com.lojavirtual.interfaces;

public enum UserType {
  ADMINISTRADOR("administrador"),
  USUARIO("usuário");

  private final String name;

  private UserType(String userTypeName) {
    name = userTypeName;
  }

  public boolean equalsName(String userType) {
    return name.equals(userType);
  }

  public String toString() {
    return this.name;
  }
}