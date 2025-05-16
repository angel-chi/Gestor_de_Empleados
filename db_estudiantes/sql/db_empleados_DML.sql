-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //////Base de datos de Empleados, dividido por sectores(administración, soporte técnico, desarrolladores y gerentes)///////////
-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

use db_empleados;

insert into empleados (id, nombre, apellido, edad, genero,
 tipo_documento, numero_documento, correo_electronico, numero_telefono,
 fecha_inicio, cantidad_hs_semanales, sueldo ) values

(1, 'Romina', 'Pereira', 25 , 'Femenino', 'DNI', '37087123' , 'romi2@gmail.com', '1123467895', '2020-09-12',  48 , 32000 ),-- Adm
(2, 'Javier', 'Gonzalez', 32 , 'Masculino', 'DNI', '26768765' , 'javiBoquita@gmail.com', '1163464891', '2019-10-02',  48 , 33000 ),-- Dev
(3, 'Hector', 'Gomez', 34 , 'Masculino', 'DNI', '21765827' , 'hectorGomez78@gmail.com', '1153467892', '2018-07-12',  46 , 46000 ),-- Dev
(4, 'Gabriela', 'Jimenez', 22 , 'Femenino', 'DNI', '41087123' , 'gabriela.consultas@hotmail.com', '1198765816', '2019-03-02',  48 , 35000 ),-- soporte
(5, 'Gustavo', 'Gomez', 30 , 'Masculino', 'PASAPORTE', '748000221' , 'gustavo_andaluz@gmail.com', '116376189', '2020-07-07',  49 , 33000 ),-- soporte
(6, 'Jose', 'Perez', 42 , 'Masculino', 'DNI', '22287680' , 'jose_consultasInternas@hotmail.com', '1167543490', '2018-02-01',  52 , 49000 );-- gerente



insert into desarrolladores (id, id_empleados, puesto, certificaciones, habilidades, proyectos_en_produccion) values

(1, 2, 'Front End Dev', 'Design UX, dev Responsive, Web Service it', 'Infraestructura, diseño Eficiente', 1), 
(2, 3, 'Back End Dev', 'Ethical Hacker, ArquitectSoftware', 'Autodidacta, Experiencia, Organizacion', 3);



insert into soporte_tecnico (id, id_empleados, puesto, formacion, certificaciones) values

(1, 4, 'NetworkingAdmin', 'Tecnico en Redes', 'NetworkingAdvanced, Protocolos Locales'),
(2, 5, 'NetworkingEngineer', 'Licenciatura en Telecomunicaciones', 'Linux Arquitect, adminNAS, Industry 4.0');


insert into administracion (id, id_empleados, puesto, habilidades) values

(1, 1, 'Administradora General', 'Predisposicion, Actitud, Flexibilidad');


insert into gerentes (id, id_empleados, sector, formacion, antiguedad) values

(1, 6, 'soporte_tecnico', 'Licenciado en Administración', 2);



