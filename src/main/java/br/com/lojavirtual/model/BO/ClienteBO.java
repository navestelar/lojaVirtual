package br.com.lojavirtual.model.BO;

import java.util.HashMap;

import br.com.lojavirtual.model.DAO.ClienteDAO;
import br.com.lojavirtual.model.DTO.Cliente;

public class ClienteBO {
    public boolean inserir(Cliente cliente) {
        if  (!existe(cliente)) {
            ClienteDAO clienteDAO = new ClienteDAO();
            return clienteDAO.inserir(cliente);
        } 

        return false;
    }

    public boolean alterar(Cliente cliente) {
        if (existe(cliente)) {
            ClienteDAO clienteDAO = new ClienteDAO();
            return clienteDAO.alterar(cliente);
        }
        System.err.println("Esse cliente não existe");
        return false;
    }

    public boolean excluir(Cliente cliente) {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.excluir(cliente);
    }

    public Cliente procurarPorId(int id) {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.procurarPorId(id);
    }

    public boolean existe(Cliente cliente) {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.existe(cliente);
    }

    public boolean existePorId(int id) {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.existePorId(id);
    }

    public HashMap<String, Cliente> listarClientes() {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.listarClientes();
    }
}
