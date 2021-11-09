-- DDL (Desenvolvimento)
drop database if exists spicemercado;
create database spicemercado charset=UTF8 collate utf8_general_ci;
use spicemercado;

create table operadores(
    id_caixa integer not null primary key auto_increment,
    id_funcionario integer not null,
    nome_completo varchar(70) not null,
    cpf varchar(12)
);

create table entregadores(
    id_entregador integer not null primary key auto_increment,
    nome_completo varchar(50) not null,
    veiculo varchar(50)
);

create table clientes(
    id_cliente integer not null primary key auto_increment,
    nome_completo  varchar(50) not null,
    cpf varchar(12),
    email varchar(70),
    telefone varchar(15) not null,
    senha varchar(100),
    endereco varchar(255)
);

create table produtos(
    id_produto integer not null primary key auto_increment,
    nome varchar(60) not null,
    descricao varchar (100),
    preco decimal(8,2)
);

create table itens(
    id_pedido integer not null primary key auto_increment,
    id_produto integer not null,
    quantidade integer not null,
    subtotal decimal(8,2)
);

create table pedidos(
    id_pedido integer not null primary key auto_increment,
    id_cliente integer not null,
    id_entregador integer not null,
    id_caixa integer not null,
    data date,
    hora_pedido Time,
    hora_inicio Time,
    hora_fim Time
);

alter table pedidos add
constraint fk_opera foreign key (id_caixa)
references operadores(id_caixa);

alter table pedidos add
constraint fk_entrega foreign key (id_entregador)
references entregadores(id_entregador);

alter table pedidos add
constraint fk_pede foreign key (id_cliente)
references clientes(id_cliente);

alter table itens add
constraint fk_itens_pedido foreign key (id_pedido)
references pedidos(id_pedido);

alter table itens add
constraint fk_item_produto foreign key (id_produto)
references produtos(id_produto);

describe operadores;
describe entregadores;
describe clientes;
describe produtos;
describe itens;
describe pedidos;
show tables;

LOAD DATA INFILE 'C:/Users/Desenvolvimento/Desktop/projeto - banco/clientes.csv'
INTO TABLE clientes
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 ROWS;

LOAD DATA INFILE 'C:/Users/Desenvolvimento/Desktop/projeto - banco/entregadores.csv'
INTO TABLE entregadores
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 ROWS;

LOAD DATA INFILE 'C:/Users/Desenvolvimento/Desktop/projeto - banco/operadores.csv'
INTO TABLE operadores
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 ROWS;

LOAD DATA INFILE 'C:/Users/Desenvolvimento/Desktop/projeto - banco/pedidos.csv'
INTO TABLE pedidos
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 ROWS;

LOAD DATA INFILE 'C:/Users/Desenvolvimento/Desktop/projeto - banco/produtos.csv'
INTO TABLE produtos
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 ROWS;

-------------------- dados para teste --------------------------------------

insert into produtos(nome, descricao, preco) values
("Sabonete", "Palmolive Tamanho Família 150g", 2.89),
("Creme Dental", "Colgate Sorriso Mais Branco", 4.97),
("Enxaguante Bucal", "Listerine Menta", 13.25),
("Fio Dental", "Frescor e Mais Fino", 2.36);

insert into entregadores(nome_completo, veiculo) values
("Osvaldo Silva", "moto, ABC1D34"),
("Murilo Bueno", "moto, CCV3F45"),
("Vinicius Mello", "bicicleta"),
("Bruno Vieira", "moto, HJL9Y76");

insert into operadores(id_funcionario, nome_completo, cpf) values 
(1, "Franciely Souza", "12345678901"),
(2, "Marcia Nogueira", "25412565841"),
(3, "Gabrielly Mendes", "81453156362"),
(4, "Bruna Mello", "32415569874");

insert into clientes(nome_completo, cpf, email, telefone, senha, endereco) values
("Akeme Dias", "21651521245", "akeme1@gmail.com", "19989878556", "akeme123", "Rua Pedro Lana, 333"),
("Alana Ferreira", "35565599632", "alana1@gmail.com", "11547843269", "alana123", "Rua José Alves Silva, 55"),
("Abna Farias", "20136314188", "abna1@gmail.com", "19845632203", "abna123", "Rua Dom Juan, 778"),
("Augusto Justus", "33625632541", "augusto1@gmail.com", "11488745223", "augusto123", "Rua Moneda, 43");

insert into pedidos(id_cliente, id_entregador, id_caixa, data, hora_pedido, hora_inicio, hora_fim) values
(1, 2, 2, curdate(), curtime(), "10:40", "11:20"),
(2, 1, 4, curdate(), curtime(), "10:45", "11:25"),
(3, 3, 3, curdate(), curtime(), "10:35", "11:15"),
(4, 4, 1, curdate(), curtime(), "10:50", "11:30");

insert into itens(id_produto, quantidade) values
(3, 7),
(2, 10),
(4, 3),
(1, 5);

select * from clientes;
select * from entregadores;
select * from operadores;
select * from pedidos;
select * from produtos;
select * from itens;