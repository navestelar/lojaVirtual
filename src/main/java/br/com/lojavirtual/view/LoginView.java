package br.com.lojavirtual.view;

public class LoginView {
  public void mostrarMenu() {
    System.out.println("** Tela de Login **");
  }

  public String lerUsername() {
    System.out.print("Username: ");
    return System.console().readLine();
  }

  public String lerSenha() {
    System.out.print("Senha: ");
    return System.console().readLine();
  }

  public void mostrarMensagem(String mensagem) {
    System.out.println(mensagem);
  }
}
