package br.com.lojavirtual.view;

import br.com.lojavirtual.interfaces.PersistenceType;

public class PersistenceView {
  public void mostrarMenu() {
    System.out.println("** Escolha o tipo de persistência dos dados **");
    System.out.println("------------------------");
    for (int i = 0; i < PersistenceType.values().length; i++) {
      System.out.println(i + " - " + PersistenceType.values()[i].name());
    }
    System.out.println("------------------------");
  }

  public PersistenceType lerPersistencia() {
    System.out.print("Digite a opção: ");
    int opcao = Integer.parseInt(System.console().readLine());
    return PersistenceType.values()[opcao];
  }

  public void mostrarMensagem(String mensagem) {
    System.out.println(mensagem);
  }
}
