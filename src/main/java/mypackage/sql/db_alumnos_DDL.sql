-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //////Base de datos de Alumnos, dividido por sectores(administración, soporte técnico, desarrolladores y gerentes)///////////
-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

drop database if exists db_alumnos;

create database db_alumnos;

use db_alumnos;

drop table if exists alumnos;
drop table if exists desarrolladores;
drop table if exists soporte_tecnico;
drop table if exists administracion;
drop table if exists gerentes;

create table alumnos(
id					int 			auto_increment 			primary key,
nombre				varchar(40)		not null,
apellido		    varchar(40)		not null,
edad			    int(3)			not null,
genero				varchar(10)		not null,
curso				varchar(30)		not null,
matricula			varchar(15)		not null,
promedio        	double			not null,
fecha_ingreso		date			not null,
email				varchar(30)		not null
);




create table desarrolladores(

id							int 									auto_increment 	primary key,
id_alumnos				int										not null unique,
constraint					fk_id_alumnos_desarrolladores			foreign key(id_alumnos) references alumnos(id),
puesto						varchar(30)								not null,
certificaciones				varchar(80),
habilidades					varchar(60)								not null,
proyectos_en_produccion		int 									

);

create table soporte_tecnico(

id					int 									auto_increment 	primary key,
id_alumnos		int										not null unique,
constraint			fk_id_alumnos_soporte_tecnico			foreign key(id_alumnos) references alumnos(id),
puesto				varchar(30)								not null,
formacion			varchar(50),-- titulo universitario, etc
certificaciones		varchar(80)

);


create table administracion(

id					int 									auto_increment 	primary key,
id_alumnos		int										not null unique,
constraint			fk_id_alumnos_administracion			foreign key(id_alumnos) references alumnos(id),
puesto				varchar(30)								not null,
habilidades			varchar(50)								not null

);

create table gerentes(

id					int 									auto_increment 			primary key,
id_alumnos		int										not null unique,
constraint			fk_id_alumnos_gerentes				foreign key(id_alumnos) references alumnos(id),
sector				varchar(30)								not null,
formacion			varchar(60), -- titulo, etc
antiguedad			int										not  null

);



