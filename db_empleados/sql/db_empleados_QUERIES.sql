-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //////Base de datos de students, dividido por sectores(administración, soporte técnico, desarrolladores y gerentes)///////////
-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

use db_students;

-- -----------SELECT----------------
-- todos los campos
select * from student;
select * from administracion;
select * from desarrolladores;
select * from soporte_tecnico;
select * from gerentes;

-- students por area
select * from student empl , administracion adm where empl.id = adm.id_students;
select * from student empl, desarrolladores dev where empl.id= dev.id_students;
select * from student empl, soporte_tecnico sop where empl.id= sop.id_students;
select * from student empl, gerentes ger where empl.id= ger.id_students;

-- students ordenados por nombre
select * from student order by nombre;

-- students ordenados por edad
select * from student order by edad;

-- students ordenados por fecha de inicio
select * from student order by matricula;

-- students ordenados por sueldo
select * from student order by semestre;

-- -----------FIN SELECT----------------


-- -----------INSERT----------------
-- La insercion se realizó en el DML
-- -----------FIN INSERT----------------


-- -----------UPDATE----------------
update student set edad=33 where id=2;
update soporte_tecnico set certificaciones='Protocolos Locales, Fibra Optica' where id=4;
update desarrolladores set habilidades='Autodidacta, metodologias agiles' where id=3; 
-- -----------FIN UPDATE----------------