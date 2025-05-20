-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //////Base de datos de Empleados, dividido por sectores(administración, soporte técnico, desarrolladores y gerentes)///////////
-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

use db_alumnos;

insert into alumno (id, nombre, apellido, edad, genero,
 semestre, correo_electronico, numero_telefono, matricula, promedio ) values

(1, 'Romina', 'Pereira', 25 , 'Femenino', '2', '37087123@gmail.com' , '34834778', 48 , 32000 ),-- Adm
(2, 'Javier', 'Gonzalez', 32 , 'Masculino', '1', '26768765@gmail.com' , '34834779', 48 , 33000 ),-- Dev
(3, 'Hector', 'Gomez', 34 , 'Masculino', '5', '21765827@gmail.com' , '34834771', 46 , 46000 ),-- Dev
(4, 'Gabriela', 'Jimenez', 22 , 'Femenino', '2', '41087123@gmail.com' , '34834772', 48 , 35000 ),-- soporte
(5, 'Gustavo', 'Gomez', 30 , 'Masculino', '3', '748000221@gmail.com' , '34834774', 49 , 33000 ),-- soporte
(6, 'Jose', 'Perez', 42 , 'Masculino', '5', '22287680@gmail.com' , '3483477', 52 , 49000 );-- gerente



insert into desarrolladores (id, id_alumnos, puesto, certificaciones, habilidades, proyectos_en_produccion) values

(1, 2, 'Front End Dev', 'Design UX, dev Responsive, Web Service it', 'Infraestructura, diseño Eficiente', 1), 
(2, 3, 'Back End Dev', 'Ethical Hacker, ArquitectSoftware', 'Autodidacta, Experiencia, Organizacion', 3);



insert into soporte_tecnico (id, id_alumnos, puesto, formacion, certificaciones) values

(1, 4, 'NetworkingAdmin', 'Tecnico en Redes', 'NetworkingAdvanced, Protocolos Locales'),
(2, 5, 'NetworkingEngineer', 'Licenciatura en Telecomunicaciones', 'Linux Arquitect, adminNAS, Industry 4.0');


insert into administracion (id, id_alumnos, puesto, habilidades) values

(1, 1, 'Administradora General', 'Predisposicion, Actitud, Flexibilidad');


insert into gerentes (id, id_alumnos, sector, formacion, antiguedad) values

(1, 6, 'soporte_tecnico', 'Licenciado en Administración', 2);



