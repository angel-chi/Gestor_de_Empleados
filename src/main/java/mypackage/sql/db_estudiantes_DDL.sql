-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //////Base de datos de Estudiantes, dividido por carreras estudiadas(administración, soporte técnico, actuarios y egresados)///////////
-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

drop database if exists db_Estudiantes;

create database db_Estudiantes;

use db_Estudiantes;

drop table if exists Estudiantes;
drop table if exists actuarios;
drop table if exists lic_ciencias_computacion;
drop table if exists licIngDesSoftware;
drop table if exists egresados;

create table Estudiantes(

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
hs_de_clase	int 		not null,
calificacion				float			not null

);




create table actuarios(

id							int 									auto_increment 	primary key,
id_Estudiantes				int										not null unique,
constraint					fk_id_Estudiantes_actuarios			foreign key(id_Estudiantes) references Estudiantes(id),
semestre						varchar(30)								not null,
materias_libres_cursadas				varchar(80),
materias_debidas					varchar(60)								not null,
creditos_cursados		int

);

create table lic_ciencias_computacion(

id					int 									auto_increment 	primary key,
id_Estudiantes		int										not null unique,
constraint			fk_id_Estudiantes_lic_ciencias_computacion			foreign key(id_Estudiantes) references Estudiantes(id),
semestre				varchar(30)								not null,
optativas			varchar(50),-- titulo universitario, etc
materias_libres_cursadas		varchar(80)

);


create table licIngDesSoftware(

id					int 									auto_increment 	primary key,
id_Estudiantes		int										not null unique,
constraint			fk_id_Estudiantes_licIngDesSoftware			foreign key(id_Estudiantes) references Estudiantes(id),
semestre				varchar(30)								not null,
materias_debidas			varchar(50)								not null

);

create table egresados(

id					int 									auto_increment 			primary key,
id_Estudiantes		int										not null unique,
constraint			fk_id_Estudiantes_egresados				foreign key(id_Estudiantes) references Estudiantes(id),
carrera_estudiada				varchar(30)								not null,
optativas			varchar(60), -- titulo, etc
año_egreso			int										not  null

);



