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

(1, '20210001', 'Romina', 'Pereira', 'Lopez', 25, 'Femenino', 'romina.pereira@gmail.com', '1123456789', 20, '2021-03-15', 5),
(2, '20210002', 'Javier', 'Gonzalez', 'Martinez', 32, 'Masculino', 'javier.gonzalez@gmail.com', '1167891234', 15, '2020-08-20', 6),
(3, '20210003', 'Hector', 'Gomez', 'Ramirez', 34, 'Masculino', 'hector.gomez@gmail.com', '1156789123', 18, '2019-05-10', 4),
(4, '20210004', 'Gustavo', 'Gomez', 'Fernandez', 30, 'Masculino', 'gustavo.gomez@gmail.com', '1167894561', 22, '2021-01-25', 7),
(5, '20210005', 'Jose', 'Perez', 'Sanchez', 42, 'Masculino', 'jose.perez@gmail.com', '1161234567', 25, '2018-11-30', 8),
(6, '20210006', 'Ana', 'Martinez', 'Hernandez', 28, 'Femenino', 'ana.martinez@gmail.com', '1134567890', 30, '2022-02-10', 6),
(7, '20210007', 'Luis', 'Ramirez', 'Lopez', 35, 'Masculino', 'luis.ramirez@gmail.com', '1178901234', 25, '2020-09-15', 7),
(8, '20210008', 'Carla', 'Fernandez', 'Gomez', 29, 'Femenino', 'carla.fernandez@gmail.com', '1145678901', 20, '2021-06-20', 4),
(9, '20210009', 'Miguel', 'Sanchez', 'Perez', 40, 'Masculino', 'miguel.sanchez@gmail.com', '1189012345', 35, '2019-03-05', 8),
(10, '20210010', 'Laura', 'Lopez', 'Martinez', 33, 'Femenino', 'laura.lopez@gmail.com', '1123456780', 28, '2021-11-12', 5);


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



