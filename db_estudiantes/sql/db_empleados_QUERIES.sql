-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //////Base de datos de Empleados, dividido por sectores(administración, soporte técnico, desarrolladores y gerentes)///////////
-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

use db_empleados;

-- -----------SELECT----------------
-- todos los campos
select * from empleados;
select * from administracion;
select * from desarrolladores;
select * from soporte_tecnico;
select * from gerentes;

-- empleados por area
select * from empleados empl , administracion adm where empl.id = adm.id_empleados;
select * from empleados empl, desarrolladores dev where empl.id= dev.id_empleados;
select * from empleados empl, soporte_tecnico sop where empl.id= sop.id_empleados;
select * from empleados empl, gerentes ger where empl.id= ger.id_empleados;

-- empleados ordenados por nombre
select * from empleados order by nombre;

-- empleados ordenados por edad
select * from empleados order by edad;

-- empleados ordenados por fecha de inicio
select * from empleados order by fecha_inicio;

-- empleados ordenados por sueldo
select * from empleados order by sueldo;

-- -----------FIN SELECT----------------


-- -----------INSERT----------------
-- La insercion se realizó en el DML
-- -----------FIN INSERT----------------


-- -----------UPDATE----------------
update empleados set edad=33 where id=2;
update soporte_tecnico set certificaciones='Protocolos Locales, Fibra Optica' where id=4;
update desarrolladores set habilidades='Autodidacta, metodologias agiles' where id=3; 
-- -----------FIN UPDATE----------------