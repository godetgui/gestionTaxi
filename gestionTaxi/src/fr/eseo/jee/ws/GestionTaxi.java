package fr.eseo.jee.ws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.eseo.jee.beans.Taxi;

public class GestionTaxi {
		
	public ArrayList<Taxi> trouverTaxi(String ville, String categorie) {
		ArrayList<Taxi> result = new ArrayList<Taxi>();
		String request = "SELECT * FROM Taxi WHERE NOT EXISTS (SELECT * FROM Reservation WHERE Taxi.idTaxi=Reservation.idTaxi) AND Taxi.ville="+"'"+ville+"'"+ "and Taxi.categorie="+"'"+categorie+"'";
		Taxi taxi = new Taxi();
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/gestionTaxi?&characterEncoding=UTF8&useSSL=true&user=root&password=root");
			Statement stat = connect.createStatement();
			stat.executeQuery(request);
			ResultSet rset = stat.getResultSet();
			while(rset.next()) {
				taxi.setIdTaxi(rset.getInt("idTaxi"));
				taxi.setCategorie(rset.getString("categorie"));
				taxi.setVille(rset.getString("ville"));
				taxi.setTarifDeBase(rset.getString("tarifDeBase"));
				result.add(taxi);
			}
			for(int i=0;i<result.size();i++) {
				System.out.println("taxis="+result.get(i).getIdTaxi());
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


