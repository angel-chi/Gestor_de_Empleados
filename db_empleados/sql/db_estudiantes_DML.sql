-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //////Base de datos de Empleados, dividido por sectores(administración, soporte técnico, desarrolladores y gerentes)///////////
-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

use db_estudiantes;

insert into estudiantes (id,
                         matricula,
                         nombre,
                         apellido_primero,
                         apellido_segundo,
                         edad,
                         genero,
                         correo_electronico,
                         numero_telefono,
                         horas_semanales,
                         fecha_inicio,
                         num_clases
                         ) values

(1, '12345678', 'Romina', 'Pereira', '', 25,'Femenino', 'romi2@gmail.com', '1123467895', 12, '2020-09-12', 48 ),-- Adm
(2, '12345678', 'Javier', 'Gonzalez', '', 32 , 'Masculino', 'javiBoquita@gmail.com', '1163464891', 12, '2019-10-02', 48 ),-- Dev
(3, '12345678', 'Hector', 'Gomez', '', 34 , 'Masculino', 'hectorGomez78@gmail.com', '1153467892', 12, '2018-07-12', 46 ),-- Dev
(4, '12345678', 'Gustavo', 'Gomez', '', 30 , 'Masculino', 'gustavo_andaluz@gmail.com', '116376189', 12, '2020-07-07', 49 ),-- soporte
(5, '12345678', 'Jose', 'Perez', '', 42 , 'Masculino', 'jose_consultasInternas@hotmail.com', '1167543490', 12, '2018-02-01', 52 );-- gerente



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



