-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //////Base de datos de Estudiantes, dividido por sectores(administración, soporte técnico, desarrolladores y gerentes)////////
-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

USE db_estudiantes;

INSERT INTO estudiantes (id, nombre, apellido, edad, genero,
                         matricula, semestre, correo_electronico, numero_telefono,
                         fecha_inicio, facultad,hrsclases, gastada ) VALUES

                                                                         (1, 'Romina', 'Pereira', 25, 'Femenino', '232164', 3, 'romina.pereira@gmail.com', '1123467895', '2020-09-12', 'Administración', 48, 32000),
                                                                         (2, 'Javier', 'Gonzalez', 32, 'Masculino', '346543', 6, 'javier.gonzalez@gmail.com', '1163464891', '2019-10-02', 'Desarrollo de Software', 48, 33000),
                                                                         (3, 'Héctor', 'Gómez', 34, 'Masculino', '234643', 7, 'hector.gomez@gmail.com', '1153467892', '2018-07-12', 'Desarrollo de Software', 46, 46000),
                                                                         (4, 'Gabriela', 'Jiménez', 22, 'Femenino', '345754', 4, 'gabriela.jimenez@hotmail.com', '1198765816', '2019-03-02', 'Soporte Técnico', 48, 35000),
                                                                         (5, 'Gustavo', 'Gómez', 30, 'Masculino', '234543', 5, 'gustavo.gomez@gmail.com', '1163761890', '2020-07-07', 'Soporte Técnico', 49, 33000),
                                                                         (6, 'José', 'Pérez', 42, 'Masculino', '076453', 8, 'jose.perez@hotmail.com', '1167543490', '2018-02-01', 'Gerencia de Sistemas', 52, 49000),
                                                                         (7, 'Camila', 'Martínez', 21, 'Femenino', '100231', 2, 'camila.martinez@gmail.com', '1142356789', '2021-03-15', 'Psicología', 44, 27000),
                                                                         (8, 'Lucas', 'Ramírez', 23, 'Masculino', '100232', 4, 'lucas.ramirez@gmail.com', '1167894321', '2020-08-21', 'Ingeniería Industrial', 45, 30000),
                                                                         (9, 'Valentina', 'López', 26, 'Femenino', '100233', 6, 'valentina.lopez@gmail.com', '1123456789', '2019-07-10', 'Marketing', 46, 31000),
                                                                         (10, 'Martín', 'Sosa', 28, 'Masculino', '100234', 7, 'martin.sosa@gmail.com', '1156781234', '2018-09-05', 'Recursos Humanos', 47, 33000),
                                                                         (11, 'Sofía', 'Díaz', 22, 'Femenino', '100235', 5, 'sofia.diaz@gmail.com', '1176543210', '2020-01-12', 'Diseño Gráfico', 43, 28000),
                                                                         (12, 'Mateo', 'Fernández', 24, 'Masculino', '100236', 6, 'mateo.fernandez@gmail.com', '1132159876', '2019-05-20', 'Finanzas', 46, 34000),
                                                                         (13, 'Florencia', 'Castro', 27, 'Femenino', '100237', 8, 'florencia.castro@gmail.com', '1189076543', '2017-11-18', 'Ingeniería de Software', 50, 37000),
                                                                         (14, 'Tomás', 'Herrera', 29, 'Masculino', '100238', 7, 'tomas.herrera@gmail.com', '1198765432', '2018-04-30', 'Economía', 48, 36000),
                                                                         (15, 'Agustina', 'Ríos', 20, 'Femenino', '100239', 1, 'agustina.rios@gmail.com', '1112345678', '2022-03-01', 'Biotecnología', 40, 25000),
                                                                         (16, 'Bruno', 'Silva', 31, 'Masculino', '100240', 8, 'bruno.silva@gmail.com', '1178912345', '2017-02-10', 'Administración', 51, 39000);


INSERT INTO desarrolladores (id, id_estudiantes, puesto, certificaciones, habilidades, proyectos_en_produccion) VALUES
                                                                                                                    (1, 2, 'Front End Dev', 'Design UX, dev Responsive, Web Service it', 'Infraestructura, diseño Eficiente', 1),
                                                                                                                    (2, 3, 'Back End Dev', 'Ethical Hacker, ArquitectSoftware', 'Autodidacta, Experiencia, Organizacion', 3);


INSERT INTO soporte_tecnico (id, id_estudiantes, puesto, formacion, certificaciones) VALUES
                                                                                         (1, 4, 'NetworkingAdmin', 'Tecnico en Redes', 'NetworkingAdvanced, Protocolos Locales'),
                                                                                         (2, 5, 'NetworkingEngineer', 'Licenciatura en Telecomunicaciones', 'Linux Arquitect, adminNAS, Industry 4.0');


INSERT INTO administracion (id, id_estudiantes, puesto, habilidades) VALUES
    (1, 1, 'Administradora General', 'Predisposicion, Actitud, Flexibilidad');


INSERT INTO gerentes (id, id_estudiantes, sector, formacion, antiguedad) VALUES
    (1, 6, 'soporte_tecnico', 'Licenciado en Administración', 2);
