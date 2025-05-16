-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //////Base de datos de Empleados, dividido por sectores(administración, soporte técnico, desarrolladores y gerentes)///////////
-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



drop database if exists db_estudiantes;

create database db_estudiantes;

use db_estudiantes;

drop table if exists estudiantes;
drop table if exists ingenieria;
drop table if exists quimica;
drop table if exists matematicas;
drop table if exists presidenteEstudiantil;

create table estudiantes(

matricula			int 			not null unique 			primary key,
nombre				varchar(40)		not null,
apellido		    varchar(40)		not null,
edad			    int(3)			not null,
genero				varchar(10)		not null,
modalidad   		varchar(17)		not null,
tipo_estudiante 	varchar(15)		not null,
correo_electronico	varchar(30)		not null,
numero_telefono		varchar(25),
domicilio 		    varchar(30)		not null,
anio_ingreso    	int 	    	not null,
promedio_ingreso	float			not null

);




create table matematicas(

id							int 									    auto_increment 	primary key,
matricula_estudiante		int										    not null unique,
constraint					fk_matricula_estudiante_matematicas			foreign key(matricula_estudiante) references estudiantes(matricula),
nivel						varchar(30)								    not null,
programa			    	varchar(80),
estatus					    varchar(60)								    not null,
promedio_actual		        float

);

create table quimica(

id					    int 									auto_increment 	primary key,
matricula_estudiante	int										not null unique,
constraint			    fk_matricula_estudiante_quimica			foreign key(matricula_estudiante) references estudiantes(matricula),
nivel				    varchar(30)								not null,
programa			    varchar(50),
estatus         		varchar(80)

);


create table ingenieria(

id					    int 									    auto_increment 	primary key,
matricula_estudiante	int										    not null unique,
constraint			    fk_matricula_estudiante_ingenieria			foreign key(matricula_estudiante) references estudiantes(matricula),
nivel				    varchar(30)								    not null,
programa			    varchar(50)								    not null

);

create table presidenteEstudiantil(

id					        int 									            auto_increment 			primary key,
matricula_estudiante		int										            not null unique,
constraint			        fk_matricula_estudiante_presidenteEstudiantil		foreign key(matricula_estudiante) references estudiantes(matricula),
facultad			        varchar(30)								            not null,
periodo     		        varchar(30),
cantidad_proyectos	        int									            	not  null

);


