-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //////Base de datos de Estudiantes, dividido por carreras estudiadas(administración, soporte técnico, actuarios y egresados)///////////
-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

use db_Estudiantes;

-- -----------SELECT----------------
-- todos los campos
select * from Estudiantes;
select * from licIngDesSoftware;
select * from actuarios;
select * from ;
select * from egresados;

-- Estudiantes por area
select * from Estudiantes empl , licIngDesSoftware adm where empl.id = adm.id_Estudiantes;
select * from Estudiantes empl, actuarios dev where empl.id= dev.id_Estudiantes;
select * from Estudiantes empl, licCienciasComputacion sop where empl.id= sop.id_Estudiantes;
select * from Estudiantes empl, egresados ger where empl.id= ger.id_Estudiantes;

-- Estudiantes ordenados por nombre
select * from Estudiantes order by nombre;

-- Estudiantes ordenados por edad
select * from Estudiantes order by edad;

-- Estudiantes ordenados por fecha de inicio
select * from Estudiantes order by fecha_inicio;

-- Estudiantes ordenados por calificacion
select * from Estudiantes order by calificacion;

-- -----------FIN SELECT----------------


-- -----------INSERT----------------
-- La insercion se realizó en el DML
-- -----------FIN INSERT----------------


-- -----------UPDATE----------------
update Estudiantes set edad=33 where id=2;
update licCienciasComputacion set materias_libres_cursadas='Protocolos Locales, Fibra Optica' where id=4;
update actuarios set materias_debidas='Autodidacta, metodologias agiles' where id=3;
-- -----------FIN UPDATE----------------