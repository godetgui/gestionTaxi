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
		System.out.println("DANS GESTION_RESERVATION");

		//String idClient = "SELECT idClient FROM CLIENT WHERE  nom="+"'"+nom+"'"+ "and prenom="+"'"+prenom+"'";
		String reservations = "SELECT * FROM Reservation WHERE Reservation.idClient="+"'"+idClient+"'";
		
		ArrayList<ReservationTaxi> listReservations = new ArrayList<ReservationTaxi>();
		try {
			Statement stat = connexionBDD().createStatement();

			stat.executeQuery(reservations);
			ResultSet rset = stat.getResultSet();
			while(rset.next()) {
				ReservationTaxi reservation = new ReservationTaxi();
				reservation.setIdReservation(Integer.parseInt(rset.getString("idReservation")));
				reservation.setDateReservation(rset.getString("dateReservation"));
				reservation.setDestination("destination");
				reservation.setPaiementEffectue(false);
				listReservations.add(reservation);
			}
			for(int i=0;i<listReservations.size();i++) {
				System.out.println("Dans GestionResa: ");
				System.out.println(listReservations.get(i).getIdReservation());
				System.out.println(listReservations.get(i).getDateReservation());
				System.out.println(listReservations.get(i).getDestination());
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
		
