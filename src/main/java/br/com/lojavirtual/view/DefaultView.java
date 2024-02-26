package br.com.lojavirtual.view;

import br.com.lojavirtual.interfaces.PersistenceType;

public class DefaultView {
  public void mostrarMenu() {
    System.out.println("** Menu Principal **");
    System.out.println("------------------------");
    System.out.println("1 - Produto");
    System.out.println("2 - Fornecedor");
    System.out.println("0 - Sair");
    System.out.println("------------------------");
    System.out.print("Digite a opção: ");
  }

  public PersistenceType lerPersistencia() {
    System.out.println("** Escolha o tipo de persistência dos dados **");
    System.out.println("------------------------");
    for (int i = 0; i < PersistenceType.values().length; i++) {
      System.out.println(i + " - " + PersistenceType.values()[i].name());
    }
    System.out.println("------------------------");
    System.out.print("Digite a opção: ");
    int opcao = Integer.parseInt(System.console().readLine());
    return PersistenceType.values()[opcao];
  }

  public boolean lerConfirmacao() {
    System.out.print("Tem certeza?(S/N): ");
    String resposta = System.console().readLine().toUpperCase();
    return resposta.equals("S");
  }

  public void mostrarMensagem(String mensagem) {
    System.out.println(mensagem);
  }
}
