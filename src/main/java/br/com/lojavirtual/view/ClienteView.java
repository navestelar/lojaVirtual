package br.com.lojavirtual.view;

public class ClienteView {
  public void mostrarMenu() {
    System.out.println("** Menu de Cliente **");
    System.out.println("------------------------");
    System.out.println("1 - Cadastrar Cliente");
    System.out.println("2 - Atualizar Cliente");
    System.out.println("3 - Excluir Cliente");
    System.out.println("4 - Listar Clientes");
    System.out.println("0 - Voltar");
    System.out.println("------------------------");
    System.out.print("Digite a opção: ");
  }

  public int lerId() {
    System.out.print("Id do cliente: ");
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

  public String lerEmail() {
    System.out.print("Email: ");
    return System.console().readLine();
  }

  public String lerTelefone() {
    System.out.print("Telefone: ");
    return System.console().readLine();
  }

  public String lerEndereco() {
    System.out.print("Endereço: ");
    return System.console().readLine();
  }

  public String lerCEP() {
    System.out.print("CEP: ");
    return System.console().readLine();
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
