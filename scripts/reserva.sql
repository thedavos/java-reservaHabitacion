CREATE TABLE Habitacion (
	idHabitacion int PRIMARY KEY AUTO_INCREMENT,
	numero varchar(4),
	piso char(2),
	descripcion varchar(255),
	estado char(1)
);

INSERT INTO Habitacion (numero, piso, descripcion, estado) VALUES (1, 1, "La habitación del barrendero", "E");
INSERT INTO Habitacion (numero, piso, descripcion, estado) VALUES (3, 1, "La habitación de la cocinera", "A");
INSERT INTO Habitacion (numero, piso, descripcion, estado) VALUES (12, 2, "La habitación de mi sobrino", "S");
