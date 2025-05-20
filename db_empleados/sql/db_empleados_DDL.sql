-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //////Base de datos de Empleados, dividido por sectores(administración, soporte técnico, desarrolladores y gerentes)///////////
-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

drop database if exists db_alumnos;

create database db_alumnos;

use db_alumnos;

drop table if exists alumnos;
drop table if exists administradores;
drop table if exists coordinadores;
drop table if exists profesores;

create table alumnos(

id					int 			auto_increment 			primary key,
nombre				varchar(40)		not null,
apellido		    varchar(40)		not null,
edad			    int(3)			not null,
genero				varchar(10)		not null,
semestre    		int(1)		not null,
matricula       	int(50)			not null,
correo	            varchar(30)		not null,
telefono		     varchar(50),
inicio_semestre		date		not null,
fin_semestre     	date 		not null,
promedio				float			not null

);


create table administradores(

id					int 									auto_increment 	primary key,
id_alumno			int										not null unique,
constraint			fk_admin_id	 foreign key(id_alumno) references alumnos(id),
puesto				varchar(30)								not null,
formacion			varchar(80),
conocimientos		varchar(60)								not null,
area		        varchar(40) 									not null

);
create table coordinadores(


id					int 									auto_increment 	primary key,
id_alumno	    	int										not null unique,
constraint			fk_coord_id			foreign key(id_alumno) references alumnos(id),
puesto				varchar(30)								not null,
formacion			varchar(50),-- titulo universitario, etc
certificaciones		varchar(80)

);


create table profesores(

id					int 									auto_increment 	primary key,
id_alumno   		int										not null unique,
constraint			fk_prof_id			foreign key(id_alumno) references alumnos(id),
puesto				varchar(30)								not null,
habilidades			varchar(50)								not null
);




