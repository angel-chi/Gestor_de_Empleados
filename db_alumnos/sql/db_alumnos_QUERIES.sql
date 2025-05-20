-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //////Base de datos de Empleados, dividido por sectores(administración, soporte técnico, desarrolladores y gerentes)///////////
-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

use db_alumnos;

-- -----------SELECT----------------
-- todos los campos
select * from alumnos;
select * from administracion;
select * from desarrolladores;
select * from soporte_tecnico;
select * from gerentes;

-- alumnos por area
select * from alumnos empl , administracion adm where empl.id = adm.id_alumnos;
select *from alumnos empl,desarrolladores dev where empl.id= dev.id_alumnos;
select *from alumnos empl,soporte_tecnico sop where empl.id= sop.id_alumnos;
select *from alumnos empl,gerentes ger where empl.id= ger.id_alumnos;

-- alumnos ordenados por nombre
select * from alumnos order by nombre;

-- alumnos ordenados por edad
select * from alumnos order by edad;

-- alumnos ordenados por fecha de inicio
select * from alumnos order by fecha_ingreso;

-- alumnos ordenados por curso
select * from alumnos order by curso;

-- -----------FIN SELECT----------------


-- -----------INSERT----------------
-- La insercion se realizó en el DML
-- -----------FIN INSERT----------------


-- -----------UPDATE----------------
update alumnos set edad=33 where id=2;
update soporte_tecnico set certificaciones='Protocolos Locales, Fibra Optica' where id=4;
update desarrolladores set habilidades='Autodidacta, metodologias agiles' where id=3; 
-- -----------FIN UPDATE----------------