package br.com.lojavirtual.controller;

import java.util.List;

import br.com.lojavirtual.interfaces.PersistenceType;
import br.com.lojavirtual.model.BO.FornecedorBO;
import br.com.lojavirtual.model.DTO.Fornecedor;
import br.com.lojavirtual.view.FornecedorView;

public class FornecedorController {
  private FornecedorView tela;
  private FornecedorBO fornecedorBO;

  public FornecedorController(PersistenceType persistenceType) {
    this.tela = new FornecedorView();
    this.fornecedorBO = new FornecedorBO(persistenceType);
  }

  public void executar() {
    int opcao;
    do {
      tela.mostrarMenu();
      opcao = Integer.parseInt(System.console().readLine());

      switch (opcao) {
        case 1:
          cadastrarFornecedor();
          break;
        case 2:
          System.out.println("Saindo...");
          break;
        default:
          tela.mostrarMensagem("Opção inválida!");
      }
    } while (opcao != 0);
  }

  private void cadastrarFornecedor() {
    Fornecedor produto = new Fornecedor();
    produto.setNome(tela.lerNome());
    produto.setContato(tela.lerContato());

    fornecedorBO.cadastrarFornecedor(produto);

    tela.mostrarMensagem("Fornecedor salvo com sucesso!");
  }

  public void listarFornecedors() {
    List<Fornecedor> produtos = fornecedorBO.listarFornecedores();

    for (Fornecedor produto : produtos) {
      System.out.println(produto.toString());
    }
  }
}
