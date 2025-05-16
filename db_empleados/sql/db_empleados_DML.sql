-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //////Base de datos de students, dividido por sectores(administración, soporte técnico, desarrolladores y gerentes)///////////
-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

use db_students;

insert into student (id,nombre, apellido, edad, genero, cantidad_materias, numero_telefono, correo_electronico, matricula, semestre) values

(1, 'Romina', 'Pereira', 25 , 'Femenino', 5, 37087123 , 'romi2@gmail.com', 1123467895, 5 ),-- Adm
(2, 'Javier', 'Gonzalez', 32 , 'Masculino', 4, 26768765 , 'javiBoquita@gmail.com', 1163464891, 6),-- Dev
(3, 'Hector', 'Gomez', 34 , 'Masculino', 6, 21765827 , 'hectorGomez78@gmail.com', 1153467892, 8),-- Dev
(4, 'Gabriela', 'Jimenez', 22 , 'Femenino', 7, 41087123 , 'gabriela.consultas@hotmail.com', 1198765816, 3),-- soporte
(5, 'Gustavo', 'Gomez', 30 , 'Masculino', 2, 748000221 , 'gustavo_andaluz@gmail.com', 116376189, 2),-- soporte
(6, 'Jose', 'Perez', 42 , 'Masculino', 1, 22287680 , 'jose_Internas@hotmail.com', 1167543490, 2);-- gerente



insert into desarrolladores (id, id_students, puesto, certificaciones, habilidades, proyectos_en_produccion) values

(1, 2, 'Front End Dev', 'Design UX, dev Responsive, Web Service it', 'Infraestructura, diseño Eficiente', 1), 
(2, 3, 'Back End Dev', 'Ethical Hacker, ArquitectSoftware', 'Autodidacta, Experiencia, Organizacion', 3);



insert into soporte_tecnico (id, id_students, puesto, formacion, certificaciones) values

(1, 4, 'NetworkingAdmin', 'Tecnico en Redes', 'NetworkingAdvanced, Protocolos Locales'),
(2, 5, 'NetworkingEngineer', 'Licenciatura en Telecomunicaciones', 'Linux Arquitect, adminNAS, Industry 4.0');


insert into administracion (id, id_students, puesto, habilidades) values

(1, 1, 'Administradora General', 'Predisposicion, Actitud, Flexibilidad');


insert into gerentes (id, id_students, sector, formacion, antiguedad) values

(1, 6, 'soporte_tecnico', 'Licenciado en Administración', 2);



