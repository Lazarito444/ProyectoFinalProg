-- CREACIÓN DE LA BASE DE DATOS
CREATE DATABASE Gestor_Hospital;
USE Gestor_Hospital;


-- CREACIÓN DE LAS TABLAS 

CREATE TABLE Pacientes (
	ID_Paciente INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	Nombre VARCHAR (40) NOT NULL,
	Apellido VARCHAR (40) NOT NULL,
	FechaNacimiento VARCHAR(15) NOT NULL,
	Enfermedad VARCHAR (40) NOT NULL,
	Direccion VARCHAR (40) NOT NULL,
	Telefono VARCHAR (20) NOT NULL,
	Genero VARCHAR(20) NOT NULL
);

CREATE TABLE Personal(
	ID_Personal INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	Nombre VARCHAR (40) NOT NULL,
	Apellido VARCHAR (40) NOT NULL,
	FechaNacimiento VARCHAR(15) NOT NULL,
	Direccion VARCHAR (40) NOT NULL,
	Usuario VARCHAR (20) NOT NULL,
	Contraseña VARCHAR (30) NOT NULL,
	Telefono VARCHAR (20) NOT NULL,
	Genero VARCHAR (20) NOT NULL
);

CREATE TABLE Medicamentos (
	ID_Medicamento INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    Nombre VARCHAR(40) NOT NULL,
    Precio DOUBLE NOT NULL,
    Stock INT NOT NULL
);

-- INSERCIÓN DE USUARIOS
INSERT INTO Personal (Nombre, Apellido, FechaNacimiento, Direccion, Usuario, Contraseña, Telefono, Genero) VALUES ("Ariel", "Lázaro", "13-10-2005", "Los Frailes, Santo Domingo" ,"Lazarito444", "admin", "8099993911", "M");
INSERT INTO Personal (Nombre, Apellido, FechaNacimiento, Direccion, Usuario, Contraseña, Telefono, Genero) VALUES ("Jefherson", "Sosa", "04-02-2005", "La Isabelita, Santo Domingo" ,"tugoboss", "tugo123", "1231231234", "M");
INSERT INTO Personal (Nombre, Apellido, FechaNacimiento, Direccion, Usuario, Contraseña, Telefono, Genero) VALUES ("Yael", "Ruiz", "01-01-2004", "no se, Santo Domingo" ,"yr123", "pokemon", "1234123412", "M");


-- INSERCIÓN DE MEDICAMENTOS

INSERT INTO Medicamentos (Nombre, Precio, Stock) VALUES ("Paracetamol", 24.99, 50);
INSERT INTO Medicamentos (Nombre, Precio, Stock) VALUES ("Ibuprofeno", 35.00, 30);
INSERT INTO Medicamentos (Nombre, Precio, Stock) VALUES ("Omeprazol", 29.99, 35);
INSERT INTO Medicamentos (Nombre, Precio, Stock) VALUES ("Acetaminofen", 24.99, 60);
INSERT INTO Medicamentos (Nombre, Precio, Stock) VALUES ("Loratadina", 35.00, 50);

SELECT * FROM Medicamentos;
SELECT * FROM Pacientes WHERE Telefono LIKE '%567%';
   
    