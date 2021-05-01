create database db_construcao;

use db_construcao;

create table pessoa(
	id int not null auto_increment primary key,
    nome varchar(200) not null,
    cpf varchar(11) not null unique,
    email varchar(200) not null unique
);

create table telefone(
	id int not null auto_increment primary key,
    codigoArea varchar(3) not null,
    DDD varchar(3) not null,
	numero varchar(10) not null,
    tipo varchar(7) not null,
    idPessoa int not null,
    constraint foreign key (idPessoa) references pessoa(id)
);
    
create table categoria(
	id int not null auto_increment primary key,
    nome varchar(40) not null,
    idPostagem int not null,
    constraint foreign key (idPostagem) references postagem(id)
);

create table curso(
	id int not null auto_increment primary key,
    nome varchar(40) not null,
    idPostagem int not null,
    constraint foreign key (idPostagem) references postagem(id)
);

create table endereco(
	id int not null auto_increment primary key,
    rua varchar(40) not null,
    numero varchar(40) not null,
    complemento varchar(40),
    bairro varchar(40) not null,
    cidade varchar(40) not null,
    estado varchar(40) not null
);

create table palestrante(
	id int not null auto_increment primary key,
    usuario varchar(40) not null unique,
    senha varchar(40) not null
);

create table postagem(
	id int not null auto_increment primary key,
    titulo varchar(40) not null,
    conteudo varchar(1000) not null,
    data date not null,
    idPalestrante int not null,
    constraint foreign key (idPalestrante) references palestrante(id)
);

create table usuario(
	id int not null auto_increment primary key,
    usuario varchar(40) not null unique,
    senha varchar(40) not null
);

INSERT INTO pessoa (nome, cpf,email) VALUES ("Enzo","11111111111","enzo@gmail.com" );
INSERT INTO pessoa (nome, cpf,email) VALUES ("Marcos","22222222222","marcos@gmail.com" );

INSERT INTO telefone (codigoArea,DDD,numero,tipo) VALUES ("+55","062","99999-9999","celular");
INSERT INTO telefone (codigoArea,DDD,numero,tipo, idPessoa) VALUES ("+55","062","3222-2222","fixo");

INSERT INTO categoria (nome) VALUES ("Geral");
INSERT INTO categoria (nome) VALUES ("Evento");

INSERT INTO curso (nome) VALUES ("Administração");
INSERT INTO curso (nome) VALUES ("Direito");

INSERT INTO endereco (rua,numero,complemento,bairro,cidade,estado) VALUES ("Rua Primeiro de Maio","40","","Bairro Clima Bom","Buritis de Minas","MG");
INSERT INTO endereco (rua,numero,complemento,bairro,cidade,estado) VALUES ("Rua Teresina","28","Ao lado do 'mercado são pão'","União","Goiânia","GO");

INSERT INTO palestrante (usuario,senha) VALUES ("admin","admin");
INSERT INTO palestrante (usuario,senha) VALUES ("palestrante","202101");

INSERT INTO postagem (titulo,conteudo,data) VALUES ("Bem-vindo","Sistema de mural academico inaugurado",2020-01-01);
INSERT INTO postagem (titulo,conteudo,data) VALUES ("Evento raid-programming","Um novo evento surgiu! Inscreva-se para maratona de programação em equipe já! link https://.com/",2020-01-01);

INSERT INTO usuario (usuario,senha) VALUES ("user","user");
INSERT INTO usuario (usuario,senha) VALUES ("enzinho","3nz01nh0");
