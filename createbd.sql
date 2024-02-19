drop database lojavirtual;
create database lojavirtual;

use lojavirtual;

create table usuario(
	usuario_id int primary key auto_increment,
	nome varchar(255) not null,
    username varchar(255) not null unique,
    senha varchar(255) not null,
    tipo varchar(30) not null,
    ativo TINYINT(1)
);

create table cliente(
	cliente_id int primary key auto_increment,
    email varchar(255),
    telefone varchar(14),
    endereco varchar(255),
    cep varchar(10) not null,
    usuario_id int unique,
    foreign key (usuario_id) references usuario(usuario_id)
);

CREATE TABLE fornecedor (
    fornecedor_id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    contato VARCHAR(255)
);

CREATE TABLE produto (
    produto_id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    qtdEstoque int,
    preco decimal(12,2),
    ativo TINYINT(1),
    fornecedor_id int,
    foreign key (fornecedor_id) references fornecedor(fornecedor_id)
);

CREATE TABLE imagem (
	imagem_id int primary key auto_increment,
    url varchar(255),
    descricao varchar(255),
    produto_id int,
    foreign key (produto_id) references produto(produto_id)
);

CREATE TABLE formadepagamento (
    formaPagamento_id INT PRIMARY KEY AUTO_INCREMENT,
    tipo VARCHAR(255) NOT NULL
);

CREATE TABLE carrinho (
    carrinho_id INT PRIMARY KEY AUTO_INCREMENT,
    cliente_id INT,
    formaPagamento_id INT,
    FOREIGN KEY (cliente_id) REFERENCES cliente(cliente_id),
    FOREIGN KEY (formaPagamento_id) REFERENCES formadepagamento(formaPagamento_id)
);

CREATE TABLE logacoes (
    log_id INT PRIMARY KEY AUTO_INCREMENT,
    acao VARCHAR(255) NOT NULL,
    log_data TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    usuario_id INT,
    FOREIGN KEY (usuario_id) REFERENCES Usuario(usuario_id)
);

CREATE TABLE controleacesso (
    controleAcesso_id INT PRIMARY KEY AUTO_INCREMENT,
    permissoes VARCHAR(255),
    usuario_id INT,
    FOREIGN KEY (usuario_id) REFERENCES Usuario(usuario_id)
);

create table administrador (
	administrador_id int primary key auto_increment,
    usuario_id int,
    foreign key (usuario_id) references usuario(usuario_id)
);

create table itemcarrinho (
	itemcarrinho_id int primary key auto_increment,
    quantidade int,
    produto_id int,
    carrinho_id int,
    foreign key (produto_id) references produto(produto_id),
    foreign key (carrinho_id) references carrinho(carrinho_id)
);

select * from lojavirtual.usuario;