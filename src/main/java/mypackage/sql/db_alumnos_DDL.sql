-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //////Base de datos de Empleados, dividido por sectores(administración, soporte técnico, desarrolladores y gerentes)///////////
-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

drop database if exists db_alumnos;

create database db_alumnos;

use db_alumnos;

drop table if exists alumnos;
drop table if exists administracion;
drop table if exists coordinadores;
drop table if exists profesores;

create table alumnos(

id					int 			auto_increment 			primary key,
nombre				varchar(40)		not null,
apellido		    varchar(40)		not null,
edad			    int(3)			not null,
genero				varchar(10)		not null,
semestre 	     	int(17)		not null,
matricula	        int(15)			not null,
correo          	varchar(30)		not null,
telefono	 	varchar(25),
inicio_semestre		date		not null,
fin_semestre	    int 		not null,
promedio				float			not null

);




create table administradores(

id							int 									auto_increment 	primary key,
id_alumnos				int										not null unique,
constraint					fk_id_empleados_desarrolladores			foreign key(id_empleados) references empleados(id),
puesto						varchar(30)								not null,
formacion				varchar(80),
conocimientos					varchar(60)								not null,
area		int

);

create table coordinadores(

id					int 									auto_increment 	primary key,
id_alumno		int										not null unique,
constraint			fk_id_empleados_soporte_tecnico			foreign key(id_empleados) references empleados(id),
puesto				varchar(30)								not null,
formacion			varchar(50),-- titulo universitario, etc
certificaciones		varchar(80)

);


create table profesores(

id					int 									auto_increment 	primary key,
id_empleados		int										not null unique,
constraint			fk_id_empleados_administracion			foreign key(id_empleados) references empleados(id),
puesto				varchar(30)								not null,
habilidades			varchar(50)								not null

);




