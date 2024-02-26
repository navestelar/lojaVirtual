package br.com.lojavirtual;

import br.com.lojavirtual.controller.DefaultController;

public class App {
    public static void main(String[] args) {
        DefaultController tela = new DefaultController();

        tela.executar();
    }
}
