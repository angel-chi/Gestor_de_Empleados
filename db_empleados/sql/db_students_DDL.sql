-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //////Base de datos de Estudiantes, dividido por sectores(administración, soporte técnico, desarrolladores y gerentes)///////////
-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

drop database if exists db_students;

create database db_students;

use db_students;

drop table if exists students;
drop table if exists desarrolladores;
drop table if exists soporte_tecnico;
drop table if exists administracion;
drop table if exists gerentes;

create table students(

id					int 			auto_increment 			primary key,
nombre				varchar(40)		not null,
apellido		    varchar(40)		not null,
edad			    int(3)			not null,
genero				varchar(10)		not null,
grado		        varchar(50)		not null,
matricula       	varchar(15)			not null,
correo_electronico	varchar(50)		not null,
numero_telefono		varchar(25)     not null,
semestre    		varchar(30)		not null,
cantidad_hs_escolares	int     	not null,
mesada				float			not null

);




create table desarrolladores(

id							int 									auto_increment 	primary key,
id_students			int										not null unique,
constraint					fk_id_students_desarrolladores			foreign key(id_students) references students(id),
puesto						varchar(30)								not null,
certificaciones				varchar(80),
habilidades					varchar(60)								not null,
proyectos_en_produccion		int 									

);

create table soporte_tecnico(

id					int 									auto_increment 	primary key,
id_students		    int										not null unique,
constraint			fk_id_students_soporte_tecnico			foreign key(id_students) references students(id),
puesto				varchar(30)								not null,
formacion			varchar(50),-- titulo universitario, etc
certificaciones		varchar(80)

);


create table administracion(

id					int 									auto_increment 	primary key,
id_students		    int										not null unique,
constraint			fk_id_students_administracion			foreign key(id_students) references students(id),
puesto				varchar(30)								not null,
habilidades			varchar(50)								not null

);

create table gerentes(

id					int 									auto_increment 			primary key,
id_students		    int										not null unique,
constraint			fk_id_students_gerentes				foreign key(id_students) references students(id),
sector				varchar(30)								not null,
formacion			varchar(60), -- titulo, etc
antiguedad			int										not  null

);



