-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //////Base de datos de Empleados, dividido por sectores(administración, soporte técnico, desarrolladores y gerentes)///////////
-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

use db_students;

-- -----------SELECT----------------
-- todos los campos
select * from students;
select * from administracion;
select * from desarrolladores;
select * from soporte_tecnico;
select * from gerentes;

-- estudiantes por area
select * from students empl , administracion adm where empl.id = adm.id_students;
select * from students empl, desarrolladores dev where empl.id= dev.id_students;
select * from students empl, soporte_tecnico sop where empl.id= sop.id_students;
select * from students empl, gerentes ger where empl.id= ger.id_students;

-- empleados ordenados por nombre
select * from students order by nombre;

-- empleados ordenados por edad
select * from students order by edad;

-- empleados ordenados por fecha de inicio
select * from students order by semestre;

-- empleados ordenados por mesada
select * from students order by mesada;

-- -----------FIN SELECT----------------


-- -----------INSERT----------------
-- La insercion se realizó en el DML
-- -----------FIN INSERT----------------


-- -----------UPDATE----------------
update students set edad=33 where id=2;
update soporte_tecnico set certificaciones='Protocolos Locales, Fibra Optica' where id=4;
update desarrolladores set habilidades='Autodidacta, metodologias agiles' where id=3; 
-- -----------FIN UPDATE----------------