package br.com.lojavirtual.view;

public class AdministradorView {
  public void mostrarMenu() {
    System.out.println("** Menu de Administrador **");
    System.out.println("------------------------");
    System.out.println("1 - Cadastrar Administrador");
    System.out.println("2 - Atualizar Administrador");
    System.out.println("3 - Excluir Administrador");
    System.out.println("4 - Listar Administradores");
    System.out.println("0 - Voltar");
    System.out.println("------------------------");
    System.out.print("Digite a opção: ");
  }

  public int lerId() {
    System.out.print("Id do administrador: ");
    return Integer.parseInt(System.console().readLine());
  }

  public String lerNome() {
    System.out.print("Nome: ");
    return System.console().readLine();
  }

  public String lerUsername() {
    System.out.print("Username: ");
    return System.console().readLine();
  }

  public String lerSenha() {
    System.out.print("Senha: ");
    return System.console().readLine();
  }

  public boolean lerAtivo() {
    System.out.print("Usuário ativo (S/N): ");
    String resposta = System.console().readLine().toUpperCase();
    return resposta.equals("S");
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
