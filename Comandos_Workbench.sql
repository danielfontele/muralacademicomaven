#drop database db_muralacademico;

create database db_muralacademico;

use db_muralacademico;

create table endereco(
	id int not null auto_increment primary key,
    rua varchar(40) not null,
    numero varchar(40) not null,
    complemento varchar(40),
    bairro varchar(40) not null,
    cidade varchar(40) not null,
    estado varchar(40) not null
);

create table pessoa(
	id int not null auto_increment primary key,
    nome varchar(200) not null,
    cpf varchar(14) not null unique,
    email varchar(200) not null unique,
    idEndereco int,
    constraint foreign key (idEndereco) references endereco(id)
);

create table telefone(
	id int not null auto_increment primary key,
    codigoArea varchar(3) not null,
    DDD varchar(3) not null,
	numero varchar(10) not null,
    tipo varchar(7) not null,
    idPessoa int,
    constraint foreign key (idPessoa) references pessoa(id)
);

create table palestrante(
	id int not null auto_increment primary key,
    usuario varchar(40) not null unique,
    senha varchar(40) not null,
    idPessoa int,
    constraint foreign key (idPessoa) references pessoa(id)
);

create table usuario(
	id int not null auto_increment primary key,
    usuario varchar(40) not null unique,
    senha varchar(40) not null,
    idPessoa int,
    constraint foreign key (idPessoa) references pessoa(id)
);

create table postagem(
	id int not null auto_increment primary key,
    titulo varchar(40) not null,
    conteudo varchar(1000) not null,
    data date not null,
    idPalestrante int,
    constraint foreign key (idPalestrante) references palestrante(id)
);

create table categoria(
	id int not null auto_increment primary key,
    nome varchar(40) not null,
    idPostagem int,
    constraint foreign key (idPostagem) references postagem(id)
);

create table curso(
	id int not null auto_increment primary key,
    nome varchar(40) not null,
    idPostagem int,
    constraint foreign key (idPostagem) references postagem(id)
);

INSERT INTO endereco (rua,numero,complemento,bairro,cidade,estado) VALUES ("Rua Primeiro de Maio","40","","Bairro Clima Bom","Buritis de Minas","MG");
INSERT INTO endereco (rua,numero,complemento,bairro,cidade,estado) VALUES ("Rua Teresina","28","Ao lado do 'mercado são pão'","União","Goiânia","GO");

INSERT INTO pessoa (nome,cpf,email,idEndereco) VALUES ("Enzo","95825029834","enzo@gmail.com",1);
INSERT INTO pessoa (nome,cpf,email,idEndereco) VALUES ("Marcos","44977923740","marcos@gmail.com",2);

INSERT INTO telefone (codigoArea,DDD,numero,tipo,idPessoa) VALUES ("+55","062","99999-9999","Celular",1);
INSERT INTO telefone (codigoArea,DDD,numero,tipo,idPessoa) VALUES ("+55","062","3222-2222","Fixo",2);

INSERT INTO palestrante (usuario,senha,idPessoa) VALUES ("admin","admin",1);
INSERT INTO palestrante (usuario,senha,idPessoa) VALUES ("palestrante","202101",2);

INSERT INTO usuario (usuario,senha,idPessoa) VALUES ("user","user",1);
INSERT INTO usuario (usuario,senha,idPessoa) VALUES ("enzinho","3nz01nh0",2);

INSERT INTO postagem (titulo,conteudo,data,idPalestrante) VALUES ("Bem-vindo","Sistema de mural academico inaugurado","2020-01-01",1);
INSERT INTO postagem (titulo,conteudo,data,idPalestrante) VALUES ("Evento raid-programming","Um novo evento surgiu! Inscreva-se para maratona de programação em equipe já! link https://.com/","2020-01-01",2);

INSERT INTO categoria (nome,idPostagem) VALUES ("Geral",1);
INSERT INTO categoria (nome,idPostagem) VALUES ("Evento",2);

INSERT INTO curso (nome,idPostagem) VALUES ("Administração",1);
INSERT INTO curso (nome,idPostagem) VALUES ("Direito",2);