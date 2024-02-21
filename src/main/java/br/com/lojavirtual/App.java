package br.com.lojavirtual;

import java.util.List;

import br.com.lojavirtual.interfaces.PersistenceType;
import br.com.lojavirtual.model.BO.AdministradorBO;
import br.com.lojavirtual.model.BO.CarrinhoBO;
import br.com.lojavirtual.model.BO.ClienteBO;
import br.com.lojavirtual.model.BO.ControleAcessoBO;
import br.com.lojavirtual.model.BO.FormaDePagamentoBO;
import br.com.lojavirtual.model.BO.FornecedorBO;
import br.com.lojavirtual.model.BO.ImagemBO;
import br.com.lojavirtual.model.BO.ItemCarrinhoBO;
import br.com.lojavirtual.model.BO.LogAcoesBO;
import br.com.lojavirtual.model.BO.ProdutoBO;
import br.com.lojavirtual.model.BO.UsuarioBO;
import br.com.lojavirtual.model.DTO.Administrador;
import br.com.lojavirtual.model.DTO.Carrinho;
import br.com.lojavirtual.model.DTO.Cliente;
import br.com.lojavirtual.model.DTO.ControleAcesso;
import br.com.lojavirtual.model.DTO.FormaDePagamento;
import br.com.lojavirtual.model.DTO.Fornecedor;
import br.com.lojavirtual.model.DTO.Imagem;
import br.com.lojavirtual.model.DTO.ItemCarrinho;
import br.com.lojavirtual.model.DTO.LogAcoes;
import br.com.lojavirtual.model.DTO.Produto;
import br.com.lojavirtual.model.DTO.Usuario;

public class App {
    public static void main(String[] args) {
        System.out.println("sssssssssss");
        PersistenceType dataPersistence = PersistenceType.JSON;
        
        ClienteBO clienteBO = new ClienteBO(dataPersistence);
        FornecedorBO fornecedorBO = new FornecedorBO(dataPersistence);
        ProdutoBO produtoBO = new ProdutoBO(dataPersistence);
        ImagemBO imagemBO = new ImagemBO(dataPersistence);
        FormaDePagamentoBO formaDePagamentoBO = new FormaDePagamentoBO(dataPersistence);
        CarrinhoBO carrinhoBO = new CarrinhoBO(dataPersistence);
        LogAcoesBO logAcoesBO = new LogAcoesBO(dataPersistence);
        ControleAcessoBO controleAcessoBO = new ControleAcessoBO(dataPersistence);
        AdministradorBO administradorBO = new AdministradorBO(dataPersistence);
        ItemCarrinhoBO itemCarrinhoBO = new ItemCarrinhoBO(dataPersistence);
        UsuarioBO usuarioBO = new UsuarioBO(dataPersistence);

        // Exemplos de objetos para inserção
        Usuario usuario1 = new Usuario("Nome1", "username1", "senha1", "tipo1", true);
        Usuario usuario2 = new Usuario("Nome2", "username2", "senha2", "tipo2", true);
        usuarioBO.cadastrarUsuario(usuario1);
        usuarioBO.cadastrarUsuario(usuario2);

        Cliente cliente1 = new Cliente("email1", "telefone1", "endereco1", "cep1", usuario1.getId());
        Cliente cliente2 = new Cliente("email2", "telefone2", "endereco2", "cep2", usuario2.getId());
        clienteBO.cadastrarCliente(cliente1);
        clienteBO.cadastrarCliente(cliente2);

        Fornecedor fornecedor1 = new Fornecedor("NomeFornecedor1", "ContatoFornecedor1");
        Fornecedor fornecedor2 = new Fornecedor("NomeFornecedor2", "ContatoFornecedor2");
        fornecedorBO.cadastrarFornecedor(fornecedor1);
        fornecedorBO.cadastrarFornecedor(fornecedor2);

        Produto produto1 = new Produto("NomeProduto1", "DescricaoProduto1", 10, 100.00, true, 1);
        Produto produto2 = new Produto("NomeProduto2", "DescricaoProduto2", 20, 200.00, true, 2);
        produtoBO.cadastrarProduto(produto1);
        produtoBO.cadastrarProduto(produto2);

        Imagem imagem1 = new Imagem("url1", "descricao1", produto1.getId());
        Imagem imagem2 = new Imagem("url2", "descricao2", produto2.getId());
        imagemBO.cadastrarImagem(imagem1);
        imagemBO.cadastrarImagem(imagem2);

        FormaDePagamento formaPagamento1 = new FormaDePagamento("TipoPagamento1");
        FormaDePagamento formaPagamento2 = new FormaDePagamento("TipoPagamento2");
        formaDePagamentoBO.cadastrarFormaDePagamento(formaPagamento1);
        formaDePagamentoBO.cadastrarFormaDePagamento(formaPagamento2);

        Carrinho carrinho1 = new Carrinho(cliente1.getId(), formaPagamento1.getId());
        Carrinho carrinho2 = new Carrinho(cliente2.getId(), formaPagamento2.getId());
        carrinhoBO.cadastrarCarrinho(carrinho1);
        carrinhoBO.cadastrarCarrinho(carrinho2);

        LogAcoes LogAcoes1 = new LogAcoes("acao1", usuario1.getId());
        LogAcoes LogAcoes2 = new LogAcoes("acao2", usuario2.getId());
        logAcoesBO.cadastrarLogAcoes(LogAcoes1);
        logAcoesBO.cadastrarLogAcoes(LogAcoes2);

        ControleAcesso controleAcesso1 = new ControleAcesso("permissoes1", usuario1.getId());
        ControleAcesso controleAcesso2 = new ControleAcesso("permissoes2", usuario2.getId());
        controleAcessoBO.cadastrarControleAcesso(controleAcesso1);
        controleAcessoBO.cadastrarControleAcesso(controleAcesso2);

        Administrador administrador1 = new Administrador(usuario1.getId());
        Administrador administrador2 = new Administrador(usuario2.getId());
        administradorBO.cadastrarAdministrador(administrador1);
        administradorBO.cadastrarAdministrador(administrador2);

        ItemCarrinho itemCarrinho1 = new ItemCarrinho(1, produto1.getId(), carrinho1.getId());
        ItemCarrinho itemCarrinho2 = new ItemCarrinho(2, produto2.getId(), carrinho2.getId());
        itemCarrinhoBO.cadastrarItemCarrinho(itemCarrinho1);
        itemCarrinhoBO.cadastrarItemCarrinho(itemCarrinho2);

        // Exemplos de objetos para atualização
        usuario1.setNome("Nome1 atualizado");
        usuarioBO.atualizarUsuario(usuario1);

        produto1.setNome("NomeProduto1 atualizado");
        produtoBO.atualizarProduto(produto1);

        // Exemplos de objetos para exclusão

        // Exemplos de busca
        List<Usuario> usuarios = usuarioBO.listarUsuarios();
        List<Produto> produtos = produtoBO.listarProdutos();

        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }

        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }
}
