-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //////Base de datos de Estudiantes, dividido por carreras estudiadas(administración, soporte técnico, actuarios y egresados)///////////
-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

use db_Estudiantes;

insert into Estudiantes (id, nombre, apellido, edad, genero,
 tipo_documento, numero_documento, correo_electronico, numero_telefono,
 fecha_inicio, hs_de_clase, calificacion ) values

(1, 'Romina', 'Pereira', 21 , 'Femenino', 'DNI', '37087123' , 'romi2@gmail.com', '1123467895', '2020-09-12',  48 , 100 ),-- Adm
(2, 'Javier', 'Gonzalez', 19 , 'Masculino', 'DNI', '26768765' , 'javiBoquita@gmail.com', '1163464891', '2019-10-02',  48 , 80),-- Dev
(3, 'Hector', 'Gomez', 20, 'Masculino', 'DNI', '21765827' , 'hectorGomez78@gmail.com', '1153467892', '2018-07-12',  46 , 76),-- Dev
(4, 'Gabriela', 'Jimenez', 19 , 'Femenino', 'DNI', '41087123' , 'gabriela.consultas@hotmail.com', '1198765816', '2019-03-02',  48 , 95 ),-- soporte
(5, 'Gustavo', 'Gomez', 22 , 'Masculino', 'PASAPORTE', '748000221' , 'gustavo_andaluz@gmail.com', '116376189', '2020-07-07',  49 , 62 ),-- soporte
(6, 'Jose', 'Perez', 25 , 'Masculino', 'DNI', '22287680' , 'jose_consultasInternas@hotmail.com', '1167543490', '2018-02-01',  52 , 70 );-- Egresado



insert into actuarios (id, id_Estudiantes, semestre, materias_libres_cursadas, materias_debidas, creditos_cursados) values

(1, 2, 'Tercero', 'Literatura, Análisis de datos', 'Álgebra lineal, diseño Eficiente', 45),
(2, 3, 'Primero', '-', '-', 0);



insert into licCienciasComputacion (id, id_Estudiantes, semestre, optativas, materias_libres_cursadas) values

(1, 4, 'Tercero', 'Tecnico en Redes', 'Futbol'),
(2, 5, 'Tercero', 'Modelado 3D', 'Fotografía, Taller de redacción');


insert into licIngDesSoftware (id, id_Estudiantes, semestre, materias_debidas) values

(1, 1, 'Quinto', 'Probabilidad, Sistemas operativos');


insert into egresados (id, id_Estudiantes, carrera_estudiada, optativas, año_egreso) values

(1, 6, 'licenciatura en ciencias de la computacion', 'Modelado 3D, Bases de datos con Julia, Data Science, IA', 2020);



