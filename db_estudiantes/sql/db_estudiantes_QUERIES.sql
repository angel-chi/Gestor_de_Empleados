-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //////Base de datos de Estudiantes, dividido por sectores(administración, soporte técnico, desarrolladores y gerentes)////////
-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

USE db_estudiantes;

-- -----------SELECT----------------
-- todos los campos
SELECT * FROM estudiantes;
SELECT * FROM administracion;
SELECT * FROM desarrolladores;
SELECT * FROM soporte_tecnico;
SELECT * FROM gerentes;

-- estudiantes por área
SELECT * FROM estudiantes est, administracion adm WHERE est.id = adm.id_estudiantes;
SELECT * FROM estudiantes est, desarrolladores dev WHERE est.id = dev.id_estudiantes;
SELECT * FROM estudiantes est, soporte_tecnico sop WHERE est.id = sop.id_estudiantes;
SELECT * FROM estudiantes est, gerentes ger WHERE est.id = ger.id_estudiantes;

-- estudiantes ordenados por nombre
SELECT * FROM estudiantes ORDER BY nombre;

-- estudiantes ordenados por edad
SELECT * FROM estudiantes ORDER BY edad;

-- estudiantes ordenados por fecha de inicio
SELECT * FROM estudiantes ORDER BY fecha_inicio;

-- estudiantes ordenados por sueldo
SELECT * FROM estudiantes ORDER BY gastada;

-- -----------FIN SELECT----------------

-- -----------INSERT----------------
-- La inserción se realizó en el DML
-- -----------FIN INSERT----------------

-- -----------UPDATE----------------
UPDATE estudiantes SET edad = 33 WHERE id = 2;
UPDATE soporte_tecnico SET certificaciones = 'Protocolos Locales, Fibra Óptica' WHERE id = 4;
UPDATE desarrolladores SET habilidades = 'Autodidacta, metodologías ágiles' WHERE id = 3;
-- -----------FIN UPDATE----------------
