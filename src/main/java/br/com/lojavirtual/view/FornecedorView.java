package br.com.lojavirtual.view;

public class FornecedorView {
  public void mostrarMenu() {
    System.out.println("** Menu de Fornecedor **");
    System.out.println("------------------------");
    System.out.println("1 - Cadastrar Fornecedor");
    System.out.println("2 - Atualizar Fornecedor");
    System.out.println("3 - Remover Fornecedor");
    System.out.println("4 - Listar Fornecedores");
    System.out.println("0 - Voltar");
    System.out.println("------------------------");
    System.out.print("Digite a opção: ");
  }

  public String lerNome() {
    System.out.print("Nome do produto: ");
    return System.console().readLine();
  }

  public String lerContato() {
    System.out.print("Descrição do produto: ");
    return System.console().readLine();
  }

  public void mostrarMensagem(String mensagem) {
    System.out.println(mensagem);
  }
}
