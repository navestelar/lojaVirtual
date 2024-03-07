package br.com.lojavirtual.controller;

import java.util.List;

import br.com.lojavirtual.interfaces.PersistenceType;
import br.com.lojavirtual.interfaces.UserType;
import br.com.lojavirtual.model.BO.AdministradorBO;
import br.com.lojavirtual.model.BO.UsuarioBO;
import br.com.lojavirtual.model.DTO.Administrador;
import br.com.lojavirtual.model.DTO.Usuario;
import br.com.lojavirtual.view.AdministradorView;

public class AdministradorController {
  private AdministradorView tela;
  private AdministradorBO administradorBO;
  private UsuarioBO usuarioBO;

  public AdministradorController(PersistenceType persistenceType, UsuarioBO usuarioBO) {
    this.usuarioBO = usuarioBO;
    this.tela = new AdministradorView();
    this.administradorBO = new AdministradorBO(persistenceType);
  }

  public void executar() {
    int opcao;
    do {
      tela.mostrarMenu();
      opcao = Integer.parseInt(System.console().readLine());

      switch (opcao) {
        case 1:
          cadastrarAdministrador();
          break;
        case 2:
          atualizarAdministrador();
          break;
        case 3:
          removerAdministrador();
          break;
        case 4:
          listarAdministradores();
          break;
        case 0:
          tela.mostrarMensagem("Voltando...");
          break;
        default:
          tela.mostrarMensagem("Opção inválida!");
      }
    } while (opcao != 0);
  }

  private void cadastrarAdministrador() {
    Usuario usuario = new Usuario();
    usuario.setNome(tela.lerNome());
    usuario.setUsername(tela.lerUsername());
    usuario.setSenha(tela.lerSenha());
    usuario.setAtivo(tela.lerAtivo());
    usuario.setTipo(UserType.USUARIO);

    if (usuarioBO.cadastrarUsuario(usuario)) {
      Administrador administrador = new Administrador(usuario.getNome(), usuario.getUsername(), usuario.getSenha(), UserType.USUARIO,
          usuario.isAtivo());

      administrador.setUserId(usuario.getId());

      if (administradorBO.cadastrarAdministrador(administrador))
        tela.mostrarMensagem("Administrador cadastrado com sucesso!");
      else
        tela.mostrarMensagem("Erro ao cadastrar administrador");

    } else {
      tela.mostrarMensagem("Erro ao cadastrar usuário");
    }
  }

  private void atualizarAdministrador() {
    listarAdministradores();
    int id = tela.lerId();

    System.out.println("Atualizar administrador: ");
    Administrador administrador = mostrarAdministrador(id);

    Usuario newUsuario = new Usuario();

    newUsuario.setId(administrador.getUserId());
    newUsuario.setNome(tela.lerNome());
    newUsuario.setUsername(tela.lerUsername());
    newUsuario.setSenha(tela.lerSenha());
    newUsuario.setAtivo(tela.lerAtivo());

    if (usuarioBO.atualizarUsuario(newUsuario)) {
      Administrador newAdministrador = new Administrador(newUsuario.getNome(), newUsuario.getUsername(), newUsuario.getSenha(),
          UserType.USUARIO, newUsuario.isAtivo());

      newAdministrador.setId(id);
      newAdministrador.setUserId(newUsuario.getId());

      if (administradorBO.atualizarAdministrador(newAdministrador))
        tela.mostrarMensagem("Usuário atualizado com sucesso!");
      else
        tela.mostrarMensagem("Erro ao cadastrar administrador");

    } else {
      tela.mostrarMensagem("Erro ao atualizar usuário");
    }
  }

  public void removerAdministrador() {
    listarAdministradores();
    int id = tela.lerId();

    System.out.println("Administrador a ser excluído: ");
    Administrador administrador = mostrarAdministrador(id);

    boolean excluir = tela.lerConfirmacao();

    if (excluir) {
      if (administradorBO.deletarUsuario(administrador.getUserId()) && administradorBO.deletarAdministrador(id))
        tela.mostrarMensagem("Administrador excluído com sucesso!");
      else
        tela.mostrarMensagem("Erro ao deletar administrador");
    }
  }

  public void listarAdministradores() {
    List<Administrador> administradores = administradorBO.listarAdministradores();

    for (Administrador administrador : administradores) {
      System.out.println(administrador.toString());
    }
  }

  public Administrador mostrarAdministrador(int id) {
    Administrador administrador = administradorBO.buscarAdministrador(id);

    tela.mostrarMensagem(administrador.toString());
    return administrador;
  }
}
