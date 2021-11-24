drop database if exists academia;
create database academia;
use academia;

create table alunos (
id integer not null primary key auto_increment,
nome varchar(255) not null,
peso decimal(5,2) not null,
altura decimal(3,2) not null,
nascimento date not null
);

-- importando dados de academia.csv --
load data INFILE 'C:/Users/Desenvolvimento/Desktop/node/bd/academia.csv'
into table alunos
FIELDS TERMINATED by ';'
ENCLOSED by '"'
LINES TERMINATED by '\r\n'
IGNORE 1 rows;

select * from alunos;