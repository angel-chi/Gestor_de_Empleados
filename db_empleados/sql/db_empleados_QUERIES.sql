-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //////Base de datos de Empleados, dividido por sectores(administración, soporte técnico, desarrolladores y gerentes)///////////
-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

use db_alumnos;

-- -----------SELECT----------------
-- todos los campos
select * from alumno;
select * from administracion;
select * from desarrolladores;
select * from soporte_tecnico;
select * from gerentes;

-- alumnos por area
select * from alumno empl , administracion adm where empl.id = adm.id_alumnos;
select * from alumno empl, desarrolladores dev where empl.id= dev.id_alumnos;
select * from alumno empl, soporte_tecnico sop where empl.id= sop.id_alumnos;
select * from alumno empl, gerentes ger where empl.id= ger.id_alumnos;

-- alumnos ordenados por nombre
select * from alumno order by nombre;

-- alumnos ordenados por edad
select * from alumno order by edad;

-- alumnos ordenados por fecha de inicio
select * from alumno order by matricula;

-- alumnos ordenados por promedio
select * from alumno order by promedio;

-- -----------FIN SELECT----------------


-- -----------INSERT----------------
-- La insercion se realizó en el DML
-- -----------FIN INSERT----------------


-- -----------UPDATE----------------
update alumno set edad=33 where id=2;
update soporte_tecnico set certificaciones='Protocolos Locales, Fibra Optica' where id=4;
update desarrolladores set habilidades='Autodidacta, metodologias agiles' where id=3; 
-- -----------FIN UPDATE----------------