package br.com.lojavirtual.controller;

import br.com.lojavirtual.model.BO.UsuarioBO;
import br.com.lojavirtual.view.LoginView;

public class LoginController {
  private UsuarioBO usuarioBO;
  private LoginView tela;

  public LoginController(UsuarioBO usuarioBO) {
    this.usuarioBO = usuarioBO;
    this.tela = new LoginView();
  }

  public String executar() {
    tela.mostrarMenu();
    return usuarioBO.autenticar(tela.lerUsername(), tela.lerSenha());
  }
}
