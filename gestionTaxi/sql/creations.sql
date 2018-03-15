DROP TABLE Client cascade constraints;
DROP TABLE Reservation cascade constraints;
DROP TABLE Taxi cascade constraints;

CREATE TABLE Client(
	idClient INT,
	nom VARCHAR(50),
	prenom VARCHAR(50),
	adresse VARCHAR(250),
	telephone VARCHAR(10),
	PRIMARY KEY(idClient)
);

CREATE TABLE Reservation(
	idReservation INT,
	dateReservation DATE,
	heure TIME,
	destination VARCHAR(50),
	booleenPaiementEffectue BOOLEAN,
	idClient INT,
	idTaxi INT,
	PRIMARY KEY(idReservation),
	FOREIGN KEY(idClient) REFERENCES Client(idClient),
	FOREIGN KEY(idTaxi) REFERENCES Taxi(idTaxi)
);

CREATE TABLE Taxi(
	idTaxi INT,
	categorie VARCHAR(150),
	tarifDeBase VARCHAR(10),
	ville VARCHAR(50),
	PRIMARY KEY(idTaxi)
);


