-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //////Base de datos de Empleados, dividido por sectores(administración, soporte técnico, desarrolladores y gerentes)///////////
-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

use db_empleados;

insert into empleados (id, nombre, apellido, edad, genero, correo_electronico, numero_telefono,
 num_materias, matricula, semestre ) values

(1, 'Romina', 'Pereira', 25 , 'Femenino', 'romi2@gmail.com', '1123467895', 7 ,  '13152765' , 7 ),-- Adm
(2, 'Javier', 'Gonzalez', 32 , 'Masculino', 'javiBoquita@gmail.com', '1163464891', 6 ,  '20201564' , 5 ),-- Dev
(3, 'Hector', 'Gomez', 34 , 'Masculino', 'hectorGomez78@gmail.com', '1153467892', 6 ,  '18201639' , 3 ),-- Dev
(4, 'Gabriela', 'Jimenez', 22 , 'Femenino', 'gabriela.consultas@hotmail.com', '1198765816', 5 ,  '19173461' , 3 ),-- soporte
(5, 'Gustavo', 'Gomez', 30 , 'Masculino', 'gustavo_andaluz@gmail.com', '116376189', 5 ,  '19203685' , 1 ),-- soporte
(6, 'Jose', 'Perez', 42 , 'Masculino', 'jose_consuI@hotmail.com', '1167543490', 4 ,  '19182345' , 1 );-- gerente



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



