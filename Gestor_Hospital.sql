CREATE DATABASE Gestor_Hospital
-- DROP DATABASE Gestor_Hospital
USE Gestor_Hospital

CREATE TABLE Paciente (
Id_Paciente INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
Nombre_Paciente VARCHAR (20) NOT NULL,
Apellido_Paciente VARCHAR (20) NOT NULL,
FechaNacimiento_Paciente DATE NOT NULL,
Historial_Medico VARCHAR (20) NOT NULL,
Dirección VARCHAR (20) NOT NULL,
Teléfono VARCHAR (20) NOT NULL,
INDEX idx_nombre_paciente (Nombre_Paciente) 
);

CREATE TABLE Personal(
Id_Personal INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
Nombre_Personal VARCHAR (20) NOT NULL,
Apellido_Personal VARCHAR (20) NOT NULL,
Usuario VARCHAR (20) NOT NULL,
Contraseña VARCHAR (20) NOT NULL,
INDEX idx_nombre_personal (Nombre_Personal)
);

CREATE TABLE Cita_Medica(
NúmeroCita INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
Fecha DATE NOT NULL,
Hora TIME NOT NULL,
Paciente INT NOT NULL,
FOREIGN KEY (Paciente) REFERENCES Paciente(Id_Paciente),
Nombre_Paciente_C VARCHAR(20),
FOREIGN KEY (Nombre_Paciente_C) REFERENCES Paciente(Nombre_Paciente),
Medico_ID INT,
FOREIGN KEY (Medico_ID) REFERENCES Personal(Id_Personal),
Medico_Nombre VARCHAR (20),
FOREIGN KEY (Medico_Nombre) REFERENCES Personal(Nombre_Personal)
);

CREATE TABLE Historial_Medico(
Paciente_ID_His INT NOT NULL, 
FOREIGN KEY (Paciente_ID_His) REFERENCES Paciente(Id_Paciente),
Paciente_Nombre_His VARCHAR (20),
FOREIGN KEY (Paciente_Nombre_His) REFERENCES Paciente(Nombre_Paciente),
Entradas VARCHAR (20)
);

CREATE TABLE Medicamento(
Id_Medicamento INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
Nombre_Medicamento VARCHAR (20) NOT NULL,
Precio INT NOT NULL,
Stock INT NOT NULL,
INDEX idx_nombre_medicamento (Nombre_Medicamento)
);

CREATE TABLE Venta_Medicamento(
Medicamento_ID_Venta INT NOT NULL,
FOREIGN KEY (Medicamento_ID_Venta) REFERENCES Medicamento(Id_Medicamento),
Medicamento_Nombre VARCHAR (20),
FOREIGN KEY (Medicamento_Nombre) REFERENCES Medicamento(Nombre_Medicamento),
Cantidad INT NOT NULL,
Cliente_Paciente_ID INT NOT NULL,
FOREIGN KEY (Cliente_Paciente_ID) REFERENCES Paciente(Id_Paciente),
Cliente_Paciente_Nombre VARCHAR (20),
FOREIGN KEY (Cliente_Paciente_Nombre) REFERENCES Paciente(Nombre_Paciente)
);

CREATE TABLE Facturación(
Id_Factura INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
TipoFactura VARCHAR (20) NOT NULL,
Monto INT NOT NULL,
EstadoPago VARCHAR (20) NOT NULL
);

CREATE TABLE Informe(
Id_Informe INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
Tipo VARCHAR (20) NOT NULL,
Contenido VARCHAR (20) NOT NULL
);

INSERT INTO Personal (Nombre_Personal, Apellido_Personal, Usuario, Contraseña) VALUES ("Ariel", "Lázaro", "Lazarito444", "admin");
INSERT INTO Personal (Nombre_Personal, Apellido_Personal, Usuario, Contraseña) VALUES ("Jefherson", "Sosa", "tugoboss", "tugo123");
INSERT INTO Personal (Nombre_Personal, Apellido_Personal, Usuario, Contraseña) VALUES ("Yael", "Ruiz", "yr123", "pokemon");