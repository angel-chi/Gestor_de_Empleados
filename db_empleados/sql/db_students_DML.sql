-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //////Base de datos de Estudiantes, dividido por sectores(administración, soporte técnico, desarrolladores y gerentes)///////////
-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

use db_students;

INSERT INTO students (id, nombre, apellido, edad, genero, grado, matricula, correo_electronico, numero_telefono, semestre, cantidad_hs_escolares, mesada) VALUES
(1, 'Romina', 'Pereira', 21, 'Femenino', 'Licenciatura en Administración', 'MAT-2020-101', 'romina.pereira@universidad.edu', '1123467895', '2020-2', 48, 32000),
(2, 'Javier', 'Gonzalez', 22, 'Masculino', 'Ingeniería Informática', 'MAT-2019-205', 'javier.gonzalez@universidad.edu', '1163464891', '2019-2', 52, 33000),
(3, 'Hector', 'Gomez', 24, 'Masculino', 'Maestría en Data Science', 'MAT-2018-301', 'hector.gomez@universidad.edu', '1153467892', '2018-1', 60, 46000),
(4, 'Gabriela', 'Jimenez', 20, 'Femenino', 'Licenciatura en Derecho', 'MAT-2019-102', 'gabriela.jimenez@universidad.edu', '1198765816', '2019-1', 45, 35000),
(5, 'Gustavo', 'Gomez', 23, 'Masculino', 'Ingeniería Mecánica', 'MAT-2020-207', 'gustavo.gomez@universidad.edu', '1163761890', '2020-1', 55, 33000),
(6, 'Jose', 'Perez', 25, 'Masculino', 'Doctorado en Economía', 'MAT-2018-401', 'jose.perez@universidad.edu', '1167543490', '2018-1', 65, 49000),
(7, 'Laura', 'Mendoza', 20, 'Femenino', 'Licenciatura en Biología', 'MAT-2023-001', 'laura.mendoza@universidad.edu', '1155443322', '2023-1', 48, 28000),
(8, 'Carlos', 'Vega', 22, 'Masculino', 'Ingeniería Civil', 'MAT-2023-002', 'carlos.vega@universidad.edu', '1166554433', '2023-2', 52, 35000),
(9, 'Sofía', 'Ríos', 21, 'Femenino', 'Licenciatura en Derecho', 'MAT-2023-003', 'sofia.rios@universidad.edu', '1177665544', '2023-1', 45, 26500),
(10, 'Andrés', 'Castro', 24, 'Masculino', 'Maestría en Educación', 'MAT-2023-004', 'andres.castro@universidad.edu', '1188776655', '2023-2', 60, 42000),
(11, 'Valeria', 'Ortega', 19, 'Femenino', 'Licenciatura en Psicología', 'MAT-2023-005', 'valeria.ortega@universidad.edu', '1199887766', '2023-1', 48, 29000),
(12, 'Daniel', 'Silva', 23, 'Masculino', 'Ingeniería en Sistemas', 'MAT-2023-006', 'daniel.silva@universidad.edu', '1122334455', '2023-2', 55, 38000),
(13, 'Mariana', 'Paredes', 20, 'Femenino', 'Licenciatura en Diseño', 'MAT-2023-007', 'mariana.paredes@universidad.edu', '1133445566', '2023-1', 46, 27500),
(14, 'Julián', 'Fuentes', 25, 'Masculino', 'Doctorado en Física', 'MAT-2023-008', 'julian.fuentes@universidad.edu', '1144556677', '2023-2', 65, 45000),
(15, 'Camila', 'Navarro', 22, 'Femenino', 'Licenciatura en Marketing', 'MAT-2023-009', 'camila.navarro@universidad.edu', '1155667788', '2023-1', 50, 31000),
(16, 'Lucas', 'Moya', 21, 'Masculino', 'Ingeniería Química', 'MAT-2023-010', 'lucas.moya@universidad.edu', '1166778899', '2023-2', 58, 37000);


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



