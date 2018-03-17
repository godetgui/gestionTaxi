package fr.eseo.jee.ws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.eseo.jee.modele.Taxi;

public class GestionTaxi {
		
	public ArrayList<Taxi> trouverTaxi(String ville, String categorie) {
		ArrayList<Taxi> result = new ArrayList<Taxi>();
//		String request = "SELECT * FROM Taxi WHERE NOT EXISTS (SELECT * FROM Reservation WHERE Taxi.idTaxi=Reservation.idTaxi) AND Taxi.ville="+"'"+ville+"'"+ "and Taxi.categorie="+"'"+categorie+"'";
		String request = "SELECT * FROM Taxi WHERE NOT EXISTS (SELECT * FROM Reservation WHERE Taxi.idTaxi=Reservation.idTaxi) AND Taxi.ville="+"'"+ville+"'"+ "and Taxi.categorie="+"'"+categorie+"'";
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/GestionTaxi?&characterEncoding=UTF8&useSSL=true&user=user&password=user");
			Statement stat = connect.createStatement();
			stat.executeQuery(request);
			ResultSet rset = stat.getResultSet();
			while(rset.next()) {
				result.add(new Taxi(rset.getInt("idTaxi"),rset.getString("categorie"),rset.getString("tarifDeBase"),rset.getString("ville")));
			}
			rset.close();
			stat.close();
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	
	
}


