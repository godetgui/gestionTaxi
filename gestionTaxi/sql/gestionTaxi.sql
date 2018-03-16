
DROP TABLE Reservation;
DROP TABLE Client;
DROP TABLE Taxi;

--
-- Base de données :  `gestionTaxi`
--

-- --------------------------------------------------------

--
-- Structure de la table `Client`
--

CREATE TABLE `Client` (
  `idClient` int AUTO_INCREMENT NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `adresse` varchar(200) NOT NULL,
  `telephone` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `Reservation`
--

CREATE TABLE `Reservation` (
  `idReservation` int AUTO_INCREMENT NOT NULL,
  `dateReservation` datetime NOT NULL,
  `destination` varchar(50) NOT NULL,
  `booleenPaiementEffectue` tinyint DEFAULT 0,
  `idClient` int NOT NULL,
  `idTaxi` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `Taxi`
--

CREATE TABLE `Taxi` (
  `idTaxi` int NOT NULL,
  `categorie` varchar(50) NOT NULL,
  `tarifDeBase` decimal(10,2) NOT NULL,
  `ville` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



--
-- Index pour la table `Client`
--
ALTER TABLE `Client`
  ADD PRIMARY KEY (`idClient`);

--
-- Index pour la table `Reservation`
--
ALTER TABLE `Reservation`
  ADD PRIMARY KEY (`idReservation`),
  ADD KEY `idClient` (`idClient`),
  ADD KEY `idTaxi` (`idTaxi`);

--
-- Index pour la table `Taxi`
--
ALTER TABLE `Taxi`
  ADD PRIMARY KEY (`idTaxi`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `Reservation`
--
ALTER TABLE `Reservation`
  ADD CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`idClient`) REFERENCES `Client` (`idClient`),
  ADD CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`idTaxi`) REFERENCES `Taxi` (`idTaxi`);
COMMIT;

