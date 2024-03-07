package br.com.lojavirtual.controller;

import java.util.List;

import br.com.lojavirtual.interfaces.PersistenceType;
import br.com.lojavirtual.interfaces.UserType;
import br.com.lojavirtual.model.BO.ClienteBO;
import br.com.lojavirtual.model.BO.UsuarioBO;
import br.com.lojavirtual.model.DTO.Cliente;
import br.com.lojavirtual.model.DTO.Usuario;
import br.com.lojavirtual.view.ClienteView;

public class ClienteController {
  private ClienteView tela;
  private ClienteBO clienteBO;
  private UsuarioBO usuarioBO;

  public ClienteController(PersistenceType persistenceType, UsuarioBO usuarioBO) {
    this.usuarioBO = usuarioBO;
    this.tela = new ClienteView();
    this.clienteBO = new ClienteBO(persistenceType);
  }

  public void executar() {
    int opcao;
    do {
      tela.mostrarMenu();
      opcao = Integer.parseInt(System.console().readLine());

      switch (opcao) {
        case 1:
          cadastrarCliente();
          break;
        case 2:
          atualizarCliente();
          break;
        case 3:
          removerCliente();
          break;
        case 4:
          listarClientes();
          break;
        case 0:
          tela.mostrarMensagem("Voltando...");
          break;
        default:
          tela.mostrarMensagem("Opção inválida!");
      }
    } while (opcao != 0);
  }

  private void cadastrarCliente() {
    Usuario usuario = new Usuario();
    usuario.setNome(tela.lerNome());
    usuario.setUsername(tela.lerUsername());
    usuario.setSenha(tela.lerSenha());
    usuario.setAtivo(tela.lerAtivo());
    usuario.setTipo(UserType.USUARIO);

    if (usuarioBO.cadastrarUsuario(usuario)) {
      Cliente cliente = new Cliente(usuario.getNome(), usuario.getUsername(), usuario.getSenha(), UserType.USUARIO,
          usuario.isAtivo());

      cliente.setUserId(usuario.getId());
      cliente.setEmail(tela.lerEmail());
      cliente.setTelefone(tela.lerTelefone());
      cliente.setEndereco(tela.lerEndereco());
      cliente.setCep(tela.lerCEP());

      if (clienteBO.cadastrarCliente(cliente))
        tela.mostrarMensagem("Cliente cadastrado com sucesso!");
      else
        tela.mostrarMensagem("Erro ao cadastrar cliente");

    } else {
      tela.mostrarMensagem("Erro ao cadastrar usuário");
    }
  }

  private void atualizarCliente() {
    listarClientes();
    int id = tela.lerId();

    System.out.println("Atualizar cliente: ");
    Cliente cliente = mostrarCliente(id);

    Usuario newUsuario = new Usuario();

    newUsuario.setId(cliente.getUserId());
    newUsuario.setNome(tela.lerNome());
    newUsuario.setUsername(tela.lerUsername());
    newUsuario.setSenha(tela.lerSenha());
    newUsuario.setAtivo(tela.lerAtivo());

    if (usuarioBO.atualizarUsuario(newUsuario)) {
      Cliente newCliente = new Cliente(newUsuario.getNome(), newUsuario.getUsername(), newUsuario.getSenha(),
          UserType.USUARIO, newUsuario.isAtivo());

      newCliente.setId(id);
      newCliente.setUserId(newUsuario.getId());
      newCliente.setEmail(tela.lerEmail());
      newCliente.setTelefone(tela.lerTelefone());
      newCliente.setEndereco(tela.lerEndereco());
      newCliente.setCep(tela.lerCEP());

      if (clienteBO.atualizarCliente(newCliente))
        tela.mostrarMensagem("Usuário atualizado com sucesso!");
      else
        tela.mostrarMensagem("Erro ao cadastrar cliente");

    } else {
      tela.mostrarMensagem("Erro ao atualizar usuário");
    }
  }

  public void removerCliente() {
    listarClientes();
    int id = tela.lerId();

    System.out.println("Cliente a ser excluído: ");
    Cliente cliente = mostrarCliente(id);

    boolean excluir = tela.lerConfirmacao();

    if (excluir) {
      if (clienteBO.deletarUsuario(cliente.getUserId()) && clienteBO.deletarCliente(id))
        tela.mostrarMensagem("Cliente excluído com sucesso!");
      else
        tela.mostrarMensagem("Erro ao deletar cliente");
    }
  }

  public void listarClientes() {
    List<Cliente> clientes = clienteBO.listarClientes();

    for (Cliente cliente : clientes) {
      System.out.println(cliente.toString());
    }
  }

  public Cliente mostrarCliente(int id) {
    Cliente cliente = clienteBO.buscarCliente(id);

    tela.mostrarMensagem(cliente.toString());
    return cliente;
  }
}
