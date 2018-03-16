
DROP TABLE Reservation;
DROP TABLE Client;
DROP TABLE Taxi;

--
-- Base de données :  `gestionTaxi`
--
-- --------------------------------------------------------

--
-- Structure de la table `Taxi`
--
CREATE TABLE Taxi (
	idTaxi int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	categorie varchar(50) NOT NULL,
	tarifDeBase decimal(10,2) NOT NULL,
	ville varchar(50) NOT NULL
);
-- --------------------------------------------------------

--
-- Structure de la table `Client`
--
CREATE TABLE Client (
	idClient int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nom varchar(50) NOT NULL,
	prenom VARCHAR(50) NOT NULL,
	adresse VARCHAR(50) NOT NULL,
	telephone VARCHAR(50) NOT NULL
);

-- --------------------------------------------------------

--
-- Structure de la table `Reservation`;
--

CREATE TABLE Reservation (
	idReservation int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	dateReservation datetime NOT NULL,
	destination VARCHAR(50) NOT NULL,
	booleenPaiementEffectue int DEFAULT 0,
	idClient int NOT NULL,
	idTaxi int NOT NULL,
	FOREIGN KEY (idClient) REFERENCES Client(idClient),
	FOREIGN KEY (idTaxi) REFERENCES Taxi(idTaxi)
);


