-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //////Base de datos de estudiantes, dividido por sectores(administración, soporte técnico, Desarrolladorño y gerentes)///////////
-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

use db_estudiantes;

-- -----------SELECT----------------
-- todos los campos
select * from estudiantes;
select * from carrera;
select * from calificacion;
select * from semestre;
select * from Desarrollador;
select * from soporte_tecnico;
select * from gerentes;

-- estudiantes por area
select * from estudiantes empl , carrera adm where empl.id = adm.id_estudiantes;
select * from estudiantes empl, Desarrollador dev where empl.id= dev.id_estudiantes;
select * from estudiantes empl, soporte_tecnico sop where empl.id= sop.id_estudiantes;
select * from estudiantes empl, gerentes ger where empl.id= ger.id_estudiantes;

-- estudiantes ordenados por nombre
select * from estudiantes order by nombre;

-- estudiantes ordenados por edad
select * from estudiantes order by edad;

-- estudiantes ordenados por fecha de inicio
select * from estudiantes order by fecha_inicio;

-- estudiantes ordenados por matricula
select * from estudiantes order by matricula;

-- estudiantes ordenados por calificacion
select * from estudiantes order by calificacion;

-- estudiantes ordenados por semestre
select * from estudiantes order by semestre;

-- -----------FIN SELECT----------------


-- -----------INSERT----------------
-- La insercion se realizó en el DML
-- -----------FIN INSERT----------------


-- -----------UPDATE----------------
update estudiantes set edad=33 where id=2;
update soporte_tecnico set certificaciones='Protocolos Locales, Fibra Optica' where id=4;
update Desarrollador set habilidades='Autodidacta, metodologias agiles' where id=3;
-- -----------FIN UPDATE----------------