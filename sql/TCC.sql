create database passeio collate Latin1_General_CI_AS

use passeio

create table Aluno(
ID_aluno int primary key identity(1,1),
RM int ,
Nome_alu nvarchar(255) not null,
Email_alu nvarchar(255)not null,
Senha_alu nvarchar(10) not null,
Turma nvarchar(255) not null,
);

create table Professor (
ID_professor int primary key identity(1,1),
RM_Prof int not null ,
Nome_prof nvarchar(255) not null,
Email_prof nvarchar(255)not null,
Senha_prof nvarchar(10) not null,
);

create table Passeio(
ID_pass int primary key identity(1,1),
nome_pass nvarchar(255) not null,
local_do_passeio nvarchar(255) not null,
);


create table Presenca(
ID_presenca int primary key identity(1,1),
ID_ALUNO int ,
ID_PROF int ,
ID_PASS int,
DT_PASS datetime,

foreign key (ID_PROF) references Professor (ID_professor),
foreign key (ID_ALUNO) references Aluno (ID_aluno),
foreign key (ID_PASS) references Passeio (ID_pass)

);

create table Contato(
ID_contato int primary key identity(1,1),
Email_contato nvarchar(255) not null,
Mensagem nvarchar(255) not null,
)





select * from aluno


select * from Professor


use master
drop table aluno
drop table professor
drop table passeio
drop table presenca


select * from Contato

select * from Aluno

use passeio

select * from Professor

drop database passeio

