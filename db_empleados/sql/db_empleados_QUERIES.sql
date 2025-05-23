-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //////Base de datos de Empleados, dividido por sectores(administración, soporte técnico, desarrolladores y gerentes)///////////
-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

use db_alumnos;

-- -----------SELECT----------------
-- todos los campos
select * from alumnos;
select * from administradores;
select * from coordinadores;
select * from profesores;

-- empleados por area
select * from alumnos empl , administradores adm where empl.id = adm.id_alumno;
select * from alumnos empl, coordinadores dev where empl.id= dev.id_alumno;
select * from alumnos empl, profesores sop where empl.id= sop.id_alumno;

-- alumnos ordenados por nombre
select * from alumnos order by nombre;

-- alumnos ordenados por edad
select * from alumnos order by edad;

-- alumnos ordenados por fecha de inicio
select * from alumnos order by fecha_inicio;

-- alumnos ordenados por sueldo
select * from alumnos order by promedio;

-- -----------FIN SELECT----------------


-- -----------INSERT----------------
-- La insercion se realizó en el DML
-- -----------FIN INSERT----------------


-- -----------UPDATE----------------
update empleados set edad=33 where id=2;
update soporte_tecnico set certificaciones='Protocolos Locales, Fibra Optica' where id=4;
update desarrolladores set habilidades='Autodidacta, metodologias agiles' where id=3; 
-- -----------FIN UPDATE----------------