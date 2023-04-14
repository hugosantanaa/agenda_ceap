DROP DATABASE APRENDER;
CREATE DATABASE APRENDER;
USE APRENDER;

CREATE TABLE CLIENTE(
cli_cod int AUTO_INCREMENT NOT NULL,
cli_nome varchar(50) NOT NULL,
cli_end  varchar(50) NOT NULL,
cli_email varchar(30),
cli_tel bigint(15),
PRIMARY KEY(cli_cod));

INSERT INTO CLIENTE VALUES ( 001 , 'JOSÉ', 'RUA HUM' , 'jose@jose.com.br' , 11987654321);
