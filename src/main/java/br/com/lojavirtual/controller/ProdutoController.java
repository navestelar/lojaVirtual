package br.com.lojavirtual.controller;

import java.util.List;

import br.com.lojavirtual.interfaces.PersistenceType;
import br.com.lojavirtual.model.BO.ProdutoBO;
import br.com.lojavirtual.model.DTO.Produto;
import br.com.lojavirtual.view.ProdutoView;

public class ProdutoController {
  private ProdutoView tela;
  private ProdutoBO produtoBO;
  private FornecedorController fornecedorController;

  public ProdutoController(PersistenceType persistenceType, FornecedorController fornecedorController) {
    this.tela = new ProdutoView();
    this.produtoBO = new ProdutoBO(persistenceType);
    this.fornecedorController = fornecedorController;
  }

  public void executar() {
    int opcao;
    do {
      tela.mostrarMenu();
      opcao = Integer.parseInt(System.console().readLine());

      switch (opcao) {
        case 1:
          cadastrarProduto();
          break;
        case 2:
          atualizarProduto();
          break;
        case 3:
          removerProduto();
          break;
        case 4:
          listarProdutos();
          break;
        case 0:
          System.out.println("Voltando...");
          break;
        default:
          tela.mostrarMensagem("Opção inválida!");
      }
    } while (opcao != 0);
  }

  private void cadastrarProduto() {
    Produto produto = new Produto();
    produto.setNome(tela.lerNome());
    produto.setDescricao(tela.lerDescricao());
    produto.setQtdEstoque(tela.lerQuantidade());
    produto.setPreco(tela.lerPreco());
    produto.setAtivo(tela.lerAtivo());

    fornecedorController.listarFornecedors();
    produto.setFornecedor_id(tela.lerFornecedorId());

    produtoBO.cadastrarProduto(produto);

    tela.mostrarMensagem("Produto cadastrado com sucesso!");
  }

  private void atualizarProduto() {
    Produto newProduto = new Produto();

    listarProdutos();
    int id = tela.lerId();

    System.out.println("Atualizar produto: ");
    mostrarProduto(id);

    newProduto.setNome(tela.lerNome());
    newProduto.setDescricao(tela.lerDescricao());
    newProduto.setQtdEstoque(tela.lerQuantidade());
    newProduto.setPreco(tela.lerPreco());
    newProduto.setAtivo(tela.lerAtivo());

    fornecedorController.listarFornecedors();
    newProduto.setFornecedor_id(tela.lerFornecedorId());

    produtoBO.atualizarProduto(newProduto);

    tela.mostrarMensagem("Produto atualizado com sucesso!");
  }

  public void removerProduto() {
    listarProdutos();
    int id = tela.lerId();

    System.out.println("Produto a ser excluído: ");
    mostrarProduto(id);

    boolean excluir = tela.lerConfirmacao();
    
    if (excluir) {
      produtoBO.deletarProduto(id);
      System.out.println("Produto excluído com sucesso!");
    }
  }

  public void listarProdutos() {
    List<Produto> produtos = produtoBO.listarProdutos();

    for (Produto produto : produtos) {
      System.out.println(produto.toString());
    }
  }

  public void mostrarProduto(int id) {
    Produto produto = produtoBO.buscarProduto(id);

    System.out.println(produto.toString());
  }
}
