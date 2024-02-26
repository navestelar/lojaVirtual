package br.com.lojavirtual.view;

public class ProdutoView {
  public void mostrarMenu() {
    System.out.println("** Menu de Produto **");
    System.out.println("------------------------");
    System.out.println("1 - Cadastrar Produto");
    System.out.println("2 - Atualizar Produto");
    System.out.println("3 - Excluir Produto");
    System.out.println("4 - Listar Produtos");
    System.out.println("0 - Voltar");
    System.out.println("------------------------");
    System.out.print("Digite a opção: ");
  }

  public int lerId() {
    System.out.print("Id do produto: ");
    return Integer.parseInt(System.console().readLine());
  }

  public String lerNome() {
    System.out.print("Nome do produto: ");
    return System.console().readLine();
  }

  public String lerDescricao() {
    System.out.print("Descrição do produto: ");
    return System.console().readLine();
  }

  public double lerPreco() {
    System.out.print("Preço do produto: ");
    return Double.parseDouble(System.console().readLine());
  }

  public int lerQuantidade() {
    System.out.print("Quantidade de produtos: ");
    return Integer.parseInt(System.console().readLine());
  }

  public boolean lerAtivo() {
    System.out.print("Produto ativo (S/N): ");
    String resposta = System.console().readLine().toUpperCase();
    return resposta.equals("S");
  }

  public int lerFornecedorId() {
    System.out.print("Id do fornecedor: ");
    return Integer.parseInt(System.console().readLine());
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
