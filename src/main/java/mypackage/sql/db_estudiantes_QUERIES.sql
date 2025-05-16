-- //////////////////////////////////////////////////////////////////////////////////////////////////
-- //////Base de datos de Estudiantes, dividido por facultades (matemáticas, química, ingeniería, presidente estudiantil)////////
-- //////////////////////////////////////////////////////////////////////////////////////////////////

use db_estudiantes;

-- -----------SELECT----------------

-- Todos los campos
select * from estudiantes;
select * from matematicas;
select * from quimica;
select * from ingenieria;
select * from presidenteEstudiantil;

-- estudiantes por área (respetando sintaxis original con coma y where)
select * from estudiantes est, matematicas mat where est.matricula = mat.matricula_estudiante;
select * from estudiantes est, quimica qui where est.matricula = qui.matricula_estudiante;
select * from estudiantes est, ingenieria ing where est.matricula = ing.matricula_estudiante;
select * from estudiantes est, presidenteEstudiantil pre where est.matricula = pre.matricula_estudiante;

-- estudiantes ordenados por nombre
select * from estudiantes order by nombre;

-- estudiantes ordenados por edad
select * from estudiantes order by edad;

-- estudiantes ordenados por año de ingreso
select * from estudiantes order by anio_ingreso;

-- estudiantes ordenados por promedio de ingreso
select * from estudiantes order by promedio_ingreso;

-- -----------FIN SELECT----------------


-- -----------INSERT----------------
-- La insercion se realizó en el DML
-- -----------FIN INSERT----------------

-- -----------UPDATE----------------
update estudiantes set edad = 25 where matricula = 20000002;
update quimica set estatus = 'Egresado' where id = 1;
update matematicas set promedio_actual = 9 where id = 2;
-- -----------FIN UPDATE----------------


