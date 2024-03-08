package br.com.lojavirtual.controller;

import br.com.lojavirtual.interfaces.PersistenceType;
import br.com.lojavirtual.interfaces.UserType;
import br.com.lojavirtual.model.BO.UsuarioBO;
import br.com.lojavirtual.view.DefaultView;

public class DefaultController {
  private DefaultView tela;
  private String userType;
  private LoginController loginController;
  private FornecedorController fornecedorController;
  private ProdutoController produtoController;
  private UsuarioBO usuarioBO;
  private ClienteController clienteController;
  private AdministradorController administradorController;
  private PersistenceType persistenceType;

  public DefaultController() {
    tela = new DefaultView();

    persistenceType = tela.lerPersistencia();

    tela.mostrarMensagem("Usando persistência " + persistenceType);
    usuarioBO = new UsuarioBO(persistenceType);
    loginController = new LoginController(usuarioBO);

    userType = loginController.executar();

    fornecedorController = new FornecedorController(persistenceType);
    produtoController = new ProdutoController(persistenceType, fornecedorController);
    clienteController = new ClienteController(persistenceType, usuarioBO);
    administradorController = new AdministradorController(persistenceType, usuarioBO);
  }

  public void executar() {
    int opcao;

    while (userType == null) {
      tela.mostrarMensagem("Tente novamente");
      userType = loginController.executar();
    }

    if (userType.equals(UserType.ADMINISTRADOR.getValue())) {
      do {
        tela.mostrarMenu();
        opcao = Integer.parseInt(System.console().readLine());

        switch (opcao) {
          case 1:
            produtoController.executar();
            break;
          case 2:
            fornecedorController.executar();
            break;
          case 3:
            clienteController.executar();
            break;
          case 4:
            administradorController.executar();
            break;
          case 0:
            tela.mostrarMensagem("Volte sempre!");
            tela.mostrarMensagem("Saindo...");
            break;
          default:
            tela.mostrarMensagem("Opção inválida!");
        }
      } while (opcao != 0);
    } else if (userType.equals(UserType.USUARIO.getValue())) {
      tela.mostrarMensagem("User area");
    } else {
      tela.mostrarMensagem("Não foi possível realizar o login");
    }
  }
}
