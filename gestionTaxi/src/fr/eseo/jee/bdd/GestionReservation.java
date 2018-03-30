package fr.eseo.jee.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.eseo.jee.beans.Client;
import fr.eseo.jee.beans.ReservationTaxi;

public class GestionReservation {
	
	public GestionReservation() {
		super();
	}

	public Connection connexionBDD() throws SQLException {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/gestionTaxi?user=root&password=root");
		return connect;
		
	}
	
	public ArrayList<ReservationTaxi> trouverReservation(int idClient) {

		String reservations = "SELECT * FROM Reservation  WHERE Reservation.idClient="+idClient;
		ArrayList<ReservationTaxi> listReservations = new ArrayList<ReservationTaxi>();
		
		try {
			Statement stat = connexionBDD().createStatement();
			stat.executeQuery(reservations);
			ResultSet rset = stat.getResultSet();
			while(rset.next()) {
				ReservationTaxi reservation = new ReservationTaxi();
				reservation.setIdReservation(rset.getInt("idReservation"));
				reservation.setDateReservation(rset.getString("dateReservation"));
				reservation.setDestination(rset.getString("destination"));
				reservation.setIdTaxi(rset.getInt("idTaxi"));
				if(rset.getInt("booleenPaiementEffectue")==1) {
					reservation.setPaiementEffectue(true);
				}
				if(rset.getInt("booleenPaiementEffectue")==0) {
					reservation.setPaiementEffectue(false);
				}
				
				listReservations.add(reservation);
			}
			
			rset.close();
			stat.close();
			connexionBDD().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listReservations;
	}
		
		
	}
		
