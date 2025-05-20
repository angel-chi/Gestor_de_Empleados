DROP DATABASE IF EXISTS db_estudiantes;
CREATE DATABASE db_estudiantes;
USE db_estudiantes;

DROP TABLE IF EXISTS estudiantes;
DROP TABLE IF EXISTS desarrolladores;
DROP TABLE IF EXISTS soporte_tecnico;
DROP TABLE IF EXISTS carrera;
DROP TABLE IF EXISTS gerentes;

CREATE TABLE estudiantes(
                            id                  INT AUTO_INCREMENT PRIMARY KEY,
                            nombre              VARCHAR(40) NOT NULL,
                            apellido            VARCHAR(40) NOT NULL,
                            edad                INT(3) NOT NULL,
                            genero              VARCHAR(10) NOT NULL,
                            tipo_documento      VARCHAR(17) NOT NULL,
                            numero_documento    VARCHAR(15) NOT NULL,
                            correo_electronico  VARCHAR(30) NOT NULL,
                            numero_telefono     VARCHAR(25),
                            fecha_inicio        DATE NOT NULL,
                            cantidad_hs_semanales INT NOT NULL,
                            matricula           FLOAT NOT NULL,
                            calificacion        float NOT NULL,
                            semestre               int(3) NOT NULL
);

CREATE TABLE desarrolladores(
                                id                      INT AUTO_INCREMENT PRIMARY KEY,
                                id_estudiantes          INT NOT NULL UNIQUE,
                                FOREIGN KEY(id_estudiantes) REFERENCES estudiantes(id),
                                puesto                  VARCHAR(30) NOT NULL,
                                certificaciones         VARCHAR(80),
                                habilidades             VARCHAR(60) NOT NULL,
                                proyectos_en_produccion INT,

);

CREATE TABLE soporte_tecnico(
                                id                  INT AUTO_INCREMENT PRIMARY KEY,
                                id_estudiantes      INT NOT NULL UNIQUE,
                                FOREIGN KEY(id_estudiantes) REFERENCES estudiantes(id),
                                puesto              VARCHAR(30) NOT NULL,
                                formacion           VARCHAR(50),
                                certificaciones     VARCHAR(80)
);

CREATE TABLE carrera(
                        id                  INT AUTO_INCREMENT PRIMARY KEY,
                        id_estudiantes      INT NOT NULL UNIQUE,
                        FOREIGN KEY(id_estudiantes) REFERENCES estudiantes(id),
                        puesto              VARCHAR(30) NOT NULL,
                        habilidades         VARCHAR(50) NOT NULL
);

CREATE TABLE gerentes(
                         id                  INT AUTO_INCREMENT PRIMARY KEY,
                         id_estudiantes      INT NOT NULL UNIQUE,
                         FOREIGN KEY(id_estudiantes) REFERENCES estudiantes(id),
                         sector              VARCHAR(30) NOT NULL,
                         formacion           VARCHAR(60),
                         antiguedad          INT NOT NULL
);
