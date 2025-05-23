-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //////Base de datos de Empleados, dividido por sectores(administración, soporte técnico, desarrolladores y gerentes)///////////
-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

use db_alumnos;

insert into alumnos (id, nombre, apellido, edad, genero,
 semestre, matricula, correo, telefono,
 inicio_semestre, fin_semestre, promedio ) values

(1, 'Raul', 'Pereira', 25 , 'Femenino', 1, 37087123 , 'romi2@gmail.com', '9955228844', '2020-09-12',  '09-12' , 100 ),-- Adm
(2, 'Jhon', 'Gonzalez', 32 , 'Masculino', 5, 26768765 , 'javiBoquita@gmail.com', '1122556644', '2019-10-02',  '09-12' , 70 ),-- Dev
(3, 'Hector', 'Gomez', 34 , 'Masculino', 8, 21765827 , 'hectorGomez78@gmail.com', '5522883366', '2018-07-12',  '09-12' , 55 ),-- Dev
(4, 'Gabriela', 'Jimenez', 22 , 'Femenino', 6, 41087123 , 'gabriela.consultas@hotmail.com', '8899556611', '2020-03-02',  '09-12' , 80 ),-- soporte
(5, 'Gustavo', 'Gomez', 30 , 'Masculino', 2, 74800022 , 'gustavo_andaluz@gmail.com', '4488557722', '2020-07-07',  '09-12' , 90 ),-- soporte
(6, 'Jose', 'Perez', 42 , 'Masculino', 3, 22287680 , 'consultasInternas@hotmail.com', '5588226644', '2018-02-01',  '09-12' , 86 ),-- gerente
(7, 'xime', 'Gonzalez', 25 , 'Masculino', 5, 26768765 , 'ximeBoquita@gmail.com', '7788445599', '2019-10-02',  '09-12' , 70 ),-- Dev
(8, 'jenny', 'Gomez', 30 , 'Masculino', 8, 21765827 , 'jennyGomez78@gmail.com', '4455228847', '2018-07-12',  '09-12' , 55 );



insert into administradores (id, id_alumno, puesto, formacion, conocimientos, area) values

(1, 3, 'contador', 'LCC', 'office, Web Service it'),
(2, 4, 'soporte', 'Ethical Hacker, ArquitectSoftware', 'Autodidacta', 'soporte');



insert into coordinadores (id, id_alumno, puesto, formacion, certificaciones) values

(5, 6, 'NetworkingAdmin', 'Tecnico en Redes', 'NetworkingAdvanced, Protocolos Locales'),
(7, 8, 'NetworkingEngineer', 'Licenciatura en Telecomunicaciones', 'Linux Arquitect, adminNAS, Industry 4.0');


insert into profesores (id, id_alumno, puesto, habilidades) values

(1, 1, 'Administradora General', 'Predisposicion, Actitud, Flexibilidad');



