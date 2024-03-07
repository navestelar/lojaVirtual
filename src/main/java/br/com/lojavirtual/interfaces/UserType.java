package br.com.lojavirtual.interfaces;

public enum UserType {
  ADMINISTRADOR(1),
  USUARIO(2);

  private final int value;

  private UserType(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public String getLabel() {
    if (getValue() == 1) return "administrador";
    return "usuário";
  }
}
