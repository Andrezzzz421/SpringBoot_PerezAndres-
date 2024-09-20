-- create database restaurant_management ;
-- use restaurant_management;

create table platos(
	id_platos int auto_increment primary key,
    nombre varchar(100) not null,
    precio decimal(10,2) not null,
    disponibilidad boolean not null
);

create table mesas(
	id_mesas int auto_increment primary key,
    numero_mesa int unique not null,
    ocupada boolean not null
);

select * from platos;