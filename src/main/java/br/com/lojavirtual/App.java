package br.com.lojavirtual;

import br.com.lojavirtual.model.DAO.DataPersistence;
import br.com.lojavirtual.model.DAO.PersistenceFactory;
import br.com.lojavirtual.model.DAO.PersistenceType;
import br.com.lojavirtual.model.DTO.Produto;

public class App {
    public static void main(String[] args) {
        PersistenceType format = PersistenceType.XML;
        DataPersistence<Produto> persistence = PersistenceFactory.setDataPersistence(Produto.class, format);

        // Produto produto1 = new Produto();
        // produto1.setId(1);
        // produto1.setNome("Produto 1");
        // produto1.setDescricao("Descrição do Produto 1");
        // produto1.setQtdEstoque(10);
        // produto1.setPreco(new BigDecimal("100.00"));
        // produto1.setAtivo(true);
        // produto1.setFornecedor_id(1);

        // Produto produto2 = new Produto();
        // produto2.setId(2);
        // produto2.setNome("Produto 2");
        // produto2.setDescricao("Descrição do Produto 2");
        // produto2.setQtdEstoque(20);
        // produto2.setPreco(new BigDecimal("200.00"));
        // produto2.setAtivo(true);
        // produto2.setFornecedor_id(2);

        // Produto produto3 = new Produto();
        // produto3.setId(3);
        // produto3.setNome("Produto 3");
        // produto3.setDescricao("Descrição do Produto 3");
        // produto3.setQtdEstoque(30);
        // produto3.setPreco(new BigDecimal("300.00"));
        // produto3.setAtivo(true);
        // produto3.setFornecedor_id(3);

        // // Criar produtos no arquivo XML
        // persistence.create(produto1);
        // persistence.create(produto2);
        // persistence.create(produto3);

        // // Ler todos os produtos do arquivo XML
        // List<Produto> produtos = persistence.readAll();
        // System.out.println("Produtos lidos do arquivo XML:");
        // for (Produto produto : produtos) {
        // System.out.println(produto);
        // }

        // // Atualizar o segundo produto
        // produto2.setNome("Produto 2 Atualizado");
        // persistence.update(produto2);

        // // Ler o produto atualizado do arquivo XML
        // Produto produtoLido = persistence.read(2);
        // System.out.println("Produto 2 atualizado lido do arquivo XML:");
        // System.out.println(produtoLido);

        // // Deletar o terceiro produto
        // persistence.delete(3);

        // // Ler todos os produtos novamente após a exclusão
        // produtos = persistence.readAll();
        // System.out.println("Produtos após exclusão:");
        // for (Produto produto : produtos) {
        // System.out.println(produto);
        // }

        System.out.println(persistence.read(2));
    }
}
