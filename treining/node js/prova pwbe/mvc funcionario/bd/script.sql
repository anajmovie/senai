drop database if exists funcionario;
create database funcionario;
use funcionario;

create table funcionarios(
    matricula varchar(10) not null primary key,
    nome_completo varchar(200) not null,
    data_desligamento date not null,
    ultimo_salario decimal(6,2)
);

load data INFILE 'C:/Users/Desenvolvimento/Desktop/2des/pwbe/node/mvc funcionario/bd/funcionarios.csv'
into table funcionarios
FIELDS TERMINATED by ';'
ENCLOSED by '"'
LINES TERMINATED by '\r\n'
IGNORE 1 rows;

select * from funcionarios