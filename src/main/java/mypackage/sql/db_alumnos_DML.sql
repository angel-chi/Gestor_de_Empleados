-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //////Base de datos de Empleados, dividido por sectores(administración, soporte técnico, desarrolladores y gerentes)///////////
-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

use db_alumnos;

insert into alumnos (id, nombre, apellido, edad, genero,
                     curso, matricula, promedio, fecha_ingreso,
                     email) values

(1, 'Romina', 'Pereira', 25 , 'Femenino', 'Programación Orientada a Objetos', '37087123' ,'10.0' , '2020-09-12', 'romi2@gmail.com'),-- Adm
(2, 'Javier', 'Gonzalez', 32 , 'Masculino', 'Programación Orientada a Objetos', '26768765' , '10.0', '2019-10-02', 'javiBoquita@gmail.com'),-- Dev
(3, 'Hector', 'Gomez', 34 , 'Masculino', 'Programación Orientada a Objetos', '21765827' , '10.0', '2018-07-12', 'hectorGomez78@gmail.com'),-- Dev
(4, 'Gabriela', 'Jimenez', 22 , 'Femenino', 'Programación Orientada a Objetos', '41087123' , '10.0', '2019-03-02', 'gabriela.consultas@hotmail.com'),-- soporte
(5, 'Gustavo', 'Gomez', 30 , 'Masculino', 'Programación Orientada a Objetos', '748000221' , '10.0', '2020-07-07', 'gustavo_andaluz@gmail.com'),-- soporte
(6, 'Jose', 'Perez', 42 , 'Masculino', 'Programación Orientada a Objetos', '22287680' , '10.0', '2018-02-01', 'jose_consultasInternas@hotmail.com');-- gerente



insert into desarrolladores (id, id_alumnos, puesto, certificaciones, habilidades, proyectos_en_produccion)values

(1, 2, 'Front End Dev', 'Design UX, dev Responsive, Web Service it', 'Infraestructura, diseño Eficiente', 1), 
(2, 3, 'Back End Dev', 'Ethical Hacker, ArquitectSoftware', 'Autodidacta, Experiencia, Organizacion', 3);



insert into soporte_tecnico (id, id_alumnos, puesto, formacion, certificaciones)values

(1, 4, 'NetworkingAdmin', 'Tecnico en Redes', 'NetworkingAdvanced, Protocolos Locales'),
(2, 5, 'NetworkingEngineer', 'Licenciatura en Telecomunicaciones', 'Linux Arquitect, adminNAS, Industry 4.0');


insert into administracion (id, id_alumnos, puesto, habilidades)values

(1, 1, 'Administradora General', 'Predisposicion, Actitud, Flexibilidad');


insert into gerentes (id, id_alumnos, sector, formacion, antiguedad)values

(1, 6, 'soporte_tecnico', 'Licenciado en Administración', 2);



