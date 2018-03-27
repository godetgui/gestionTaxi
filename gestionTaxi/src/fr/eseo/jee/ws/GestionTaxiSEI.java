package fr.eseo.jee.ws;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.jws.WebService;

import fr.eseo.jee.beans.ReservationTaxi;
import fr.eseo.jee.beans.Taxi;

@WebService(name = "GestionTaxiSEI", targetNamespace = "http://ws.jee.eseo.fr/")
public interface GestionTaxiSEI {

	ArrayList<Taxi> trouverTaxi(Taxi taxi);

	int reserverTaxi(ReservationTaxi reservation) throws SQLException;

}