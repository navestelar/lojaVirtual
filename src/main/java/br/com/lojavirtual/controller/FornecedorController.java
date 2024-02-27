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
          atualizarFornecedor();
          break;
        case 3:
          removerFornecedor();
          break;
        case 4:
          listarFornecedores();
          break;
        default:
          tela.mostrarMensagem("Opção inválida!");
      }
    } while (opcao != 0);
  }

  private void cadastrarFornecedor() {
    Fornecedor fornecedor = new Fornecedor();
    fornecedor.setNome(tela.lerNome());
    fornecedor.setContato(tela.lerContato());

    fornecedorBO.cadastrarFornecedor(fornecedor);

    tela.mostrarMensagem("Fornecedor salvo com sucesso!");
  }

  private void atualizarFornecedor() {
    Fornecedor newFornecedor = new Fornecedor();

    listarFornecedores();
    int id = tela.lerId();

    tela.mostrarMensagem("Atualizar fornecedor: ");
    mostrarFornecedor(id);

    newFornecedor.setId(id);
    newFornecedor.setNome(tela.lerNome());
    newFornecedor.setContato(tela.lerContato());

    fornecedorBO.atualizarFornecedor(newFornecedor);

    tela.mostrarMensagem("Fornecedor atualizado com sucesso!");
  }

  public void listarFornecedores() {
    List<Fornecedor> fornecedores = fornecedorBO.listarFornecedores();

    for (Fornecedor fornecedor : fornecedores) {
      tela.mostrarMensagem(fornecedor.toString());
    }
  }

  public void removerFornecedor() {
    listarFornecedores();
    int id = tela.lerId();

    tela.mostrarMensagem("Fornecedor a ser excluído: ");
    mostrarFornecedor(id);

    boolean excluir = tela.lerConfirmacao();

    if (excluir) {
      fornecedorBO.deletarFornecedor(id);
      tela.mostrarMensagem("Fornecedor excluído com sucesso!");
    }
  }

  public void mostrarFornecedor(int id) {
    Fornecedor fornecedor = fornecedorBO.buscarFornecedor(id);

    tela.mostrarMensagem(fornecedor.toString());
  }
}
