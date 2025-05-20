-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //////Base de datos de Empleados, dividido por sectores(administración, soporte técnico, desarrolladores y gerentes)///////////
-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

use db_estudiantes;

-- -----------SELECT----------------
-- todos los campos
select * from estudiantes;
select * from administracion;
select * from desarrolladores;
select * from soporte_tecnico;
select * from gerentes;

-- empleados por area
select * from estudiantes empl , administracion adm where empl.id = adm.id_estudiantes;
select * from estudiantes empl, desarrolladores dev where empl.id= dev.id_estudiantes;
select * from estudiantes empl, soporte_tecnico sop where empl.id= sop.id_estudiantes;
select * from estudiantes empl, gerentes ger where empl.id= ger.id_estudiantes;

-- empleados ordenados por nombre
select * from estudiantes order by nombre;

-- empleados ordenados por edad
select * from estudiantes order by edad;

-- empleados ordenados por fecha de inicio
select * from estudiantes order by fecha_inicio;

-- empleados ordenados por sueldo
select * from estudiantes order by sueldo;

-- -----------FIN SELECT----------------


-- -----------INSERT----------------
-- La insercion se realizó en el DML
-- -----------FIN INSERT----------------


-- -----------UPDATE----------------
update estudiantes set edad=33 where id=2;
update soporte_tecnico set certificaciones='Protocolos Locales, Fibra Optica' where id=4;
update desarrolladores set habilidades='Autodidacta, metodologias agiles' where id=3; 
-- -----------FIN UPDATE----------------