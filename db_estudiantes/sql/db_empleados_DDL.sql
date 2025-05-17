-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //////Base de datos de Empleados, dividido por sectores(administración, soporte técnico, desarrolladores y gerentes)///////////
-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

drop database if exists db_empleados;

create database db_empleados;

use db_empleados;

drop table if exists empleados;
drop table if exists desarrolladores;
drop table if exists soporte_tecnico;
drop table if exists administracion;
drop table if exists gerentes;

create table empleados(

id					int 			auto_increment 			primary key,
nombre				varchar(40)		not null,
apellido		    varchar(40)		not null,
edad			    int(3)			not null,
genero				varchar(10)		not null,
tipo_documento 		varchar(17)		not null,
numero_documento	varchar(15)			not null,
correo_electronico	varchar(30)		not null,
numero_telefono		varchar(25),
fecha_inicio		date		not null,
cantidad_hs_semanales	int 		not null,
sueldo				float			not null

);




create table desarrolladores(

id							int 									auto_increment 	primary key,
id_empleados				int										not null unique,
constraint					fk_id_empleados_desarrolladores			foreign key(id_empleados) references empleados(id),
puesto						varchar(30)								not null,
certificaciones				varchar(80),
habilidades					varchar(60)								not null,
proyectos_en_produccion		int 									

);

create table soporte_tecnico(

id					int 									auto_increment 	primary key,
id_empleados		int										not null unique,
constraint			fk_id_empleados_soporte_tecnico			foreign key(id_empleados) references empleados(id),
puesto				varchar(30)								not null,
formacion			varchar(50),-- titulo universitario, etc
certificaciones		varchar(80)

);


create table administracion(

id					int 									auto_increment 	primary key,
id_empleados		int										not null unique,
constraint			fk_id_empleados_administracion			foreign key(id_empleados) references empleados(id),
puesto				varchar(30)								not null,
habilidades			varchar(50)								not null

);

create table gerentes(

id					int 									auto_increment 			primary key,
id_empleados		int										not null unique,
constraint			fk_id_empleados_gerentes				foreign key(id_empleados) references empleados(id),
sector				varchar(30)								not null,
formacion			varchar(60), -- titulo, etc
antiguedad			int										not  null

);



