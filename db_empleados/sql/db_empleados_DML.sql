-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //////Base de datos de Empleados, dividido por sectores(administración, soporte técnico, desarrolladores y gerentes)///////////
-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

use db_alumnos;

insert into alumnos (id, nombre, apellido, edad, genero,
 semestre, matricula, correo, telefono,
 inicio_semestre, fin_semestre, promedio ) values

(1, 'Raul', 'Pereira', 20 , 'Femenino', 1, 37087123 , 'romi2@gmail.com', '1123467895', '2020-09-12',  '2020-09-12' , 100 ),-- Adm
(2, 'Jhon', 'Gonzalez', 25 , 'Masculino', 5, 26768765 , 'javiBoquita@gmail.com', '1163464891', '2019-10-02',  '2020-09-12' , 70 ),-- Dev
(3, 'Hector', 'Gomez', 30 , 'Masculino', 8, 21765827 , 'hectorGomez78@gmail.com', '1153467892', '2018-07-12',  '2020-09-12' , 55 ),-- Dev
(4, 'Gabriela', 'Jimenez', 22 , 'Femenino', 6, 41087123 , 'gabriela.consultas@hotmail.com', '1198765816', '2019-03-02',  '2020-09-12' , 80 ),-- soporte
(5, 'Gustavo', 'Gomez', 21 , 'Masculino', 2, 74800022 , 'gustavo_andaluz@gmail.com', '116376189', '2020-07-07',  '2020-09-12' , 90 ),-- soporte
(6, 'Jose', 'Perez', 50 , 'Masculino', 3, 22287680 , 'jose_consultasInternas@hotmail.com', '1167543490', '2018-02-01',  '2020-09-12' , 86 ),-- gerente
(7, 'xime', 'Gonzalez', 25 , 'Masculino', 5, 26768765 , 'ximeBoquita@gmail.com', '1163464891', '2019-10-02',  '2020-09-12' , 70 ),-- Dev
(8, 'jenny', 'Gomez', 30 , 'Masculino', 8, 21765827 , 'jennyGomez78@gmail.com', '1153467892', '2018-07-12',  '2020-09-12' , 55 );


insert into administradores (id, id_alumno, puesto, formacion, conocimientos, area) values

(1, 3, 'contador', 'LCC', 'office, Web Service it', 'cubiculo'),
(2, 4, 'soporte', 'Ethical Hacker, ArquitectSoftware', 'Autodidacta','soporte' );



insert into coordinadores (id, id_alumno, puesto, formacion, certificaciones) values

(5, 6, 'NetworkingAdmin', 'Tecnico en Redes', 'NetworkingAdvanced, Protocolos Locales'),
(7, 8, 'NetworkingEngineer', 'Licenciatura en Telecomunicaciones', 'Linux Arquitect, adminNAS, Industry 4.0');


insert into profesores (id, id_alumno, puesto, habilidades) values

(1, 1, 'Administradora General', 'Predisposicion, Flexibilidad' );




