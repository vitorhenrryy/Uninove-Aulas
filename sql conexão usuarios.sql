CREATE DATABASE usuarios;
USE usuarios;
CREATE TABLE usuario(
codigo  int primary key auto_increment,
nome varchar(50) not null,
login varchar(50) not null,
senha varchar(50) not null
);



 
CREATE TABLE departamento(
ID varchar(50) primary key,
NOME varchar(50) not null,
TELEFONE varchar(50) not null,
CIDADE varchar(50) not null
); 

drop database empresa;

insert into usuario(nome,login,senha) values('Maria silvia','lakers','123');
insert into usuario(nome,login,senha) values('Diego Santos','Mdiego','587');
insert into usuario(nome,login,senha) values('Douglas brida','mDouglas','214');
insert into usuario(nome,login,senha) values('Brida novata','mbrida','54789');
insert into usuario(nome,login,senha) values('Diego rochas','mrocha','12445');
insert into usuario(nome,login,senha) values('Paulo Camopos','campos','11656');

select nome,login from usuario;
select *from usuario where bine='maria silva';
select * from usuario where codigo>3;
select * from usuario where nome like 'm%';
select * from usuario;

update usuario set nome='pedro camargo' , login='leno' where codigo=6;
delete from usuario where codigo=6;