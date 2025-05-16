-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //////Base de datos de Empleados, dividido por sectores(administración, soporte técnico, desarrolladores y gerentes)///////////
-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



use db_estudiantes;

insert into estudiantes (matricula, nombre, apellido, edad, genero, modalidad, tipo_estudiante, correo_electronico, numero_telefono, domicilio, anio_ingreso, promedio_ingreso) values

(20000001, 'Romina', 'Pereira', 22 , 'Femenino', 'Presencial', 'Regular', '20230001@alumnos.uady.mx', '9991234567', 'Calle 123', 2023, 8.7),
(20000002, 'Javier', 'Gonzalez', 24 , 'Masculino', 'Virtual', 'Regular', '20230002@alumnos.uady.mx', '9992345678', 'Calle 456', 2023, 7.9),
(20000003, 'Hector', 'Gomez', 30 , 'Masculino', 'Presencial', 'Regular', '20230003@alumnos.uady.mx', '9993456789', 'Calle 789', 2022, 9.2),
(20000004, 'Gabriela', 'Jimenez', 20 , 'Femenino', 'Virtual', 'Becado', '20230004@alumnos.uady.mx', '9994567890', 'Av 456', 2023, 8.3),
(20000005, 'Gustavo', 'Gomez', 23 , 'Masculino', 'Presencial', 'Regular', '20230005@alumnos.uady.mx', '9995678901', 'Av 789', 2020, 7.6),
(20000006, 'Jose', 'Perez', 23 , 'Masculino', 'Presencial', 'Becado', '20230006@alumnos.uady.mx', '9996789012', 'Av Siempre Viva 123', 2021, 9.6);

insert into matematicas (id, matricula_estudiante, nivel, programa, estatus, promedio_actual) values
(1, 20000002, 'Licenciatura', 'Ciencias de la Computación', 'Baja', 7),
(2, 20000003, 'Posgrado', 'Maestría en Matemáticas Aplicadas', 'Egresado', 9);

insert into quimica (id, matricula_estudiante, nivel, programa, estatus) values
(1, 20000005, 'Posgrado', 'Maestría en Bioquimica', 'Activo'),
(2, 20000001, 'Licenciatura', 'Ingeniería Química', 'Baja');

insert into ingenieria (id, matricula_estudiante, nivel, programa) values
(1, 20000004, 'Licenciatura', 'Ingeniería Civil');


insert into presidenteEstudiantil (id, matricula_estudiante, facultad, periodo, cantidad_proyectos) values
(1, 20000006, 'Facultad de Química', '2023-2025', 3);




