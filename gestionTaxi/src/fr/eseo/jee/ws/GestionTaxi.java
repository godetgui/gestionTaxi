package fr.eseo.jee.ws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.jws.WebService;

import fr.eseo.jee.beans.Client;
import fr.eseo.jee.beans.ReservationTaxi;
import fr.eseo.jee.beans.Taxi;

@WebService(targetNamespace = "http://ws.jee.eseo.fr/", endpointInterface = "fr.eseo.jee.ws.GestionTaxiSEI", portName = "GestionTaxiPort", serviceName = "GestionTaxiService")
public class GestionTaxi implements GestionTaxiSEI {
	
	
	public Connection connexionBDD() throws SQLException {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/gestionTaxi?user=root&password=root");
		return connect;
		
	}
		
	
	
	public ArrayList<Taxi> trouverTaxi(Taxi taxi) {
		String ville = taxi.getVille();
		String categorie = taxi.getCategorie();
		String tarifDeBase = taxi.getTarifDeBase();
		ArrayList<Taxi> result = new ArrayList<Taxi>();
		
		String requestCategorie = "SELECT * FROM Taxi WHERE NOT EXISTS (SELECT * FROM Reservation WHERE Taxi.idTaxi=Reservation.idTaxi) AND Taxi.categorie="+"'"+categorie+"'";
		String requestCategorieTarif = "SELECT * FROM Taxi WHERE NOT EXISTS (SELECT * FROM Reservation WHERE Taxi.idTaxi=Reservation.idTaxi) "
										+ "AND Taxi.categorie="+"'"+categorie+"' and Taxi.tarifDeBase="+"'"+tarifDeBase+"'";
		String requestVille = "SELECT * FROM Taxi WHERE NOT EXISTS (SELECT * FROM Reservation WHERE Taxi.idTaxi=Reservation.idTaxi) "
				+ "AND Taxi.ville="+"'"+ville+"'";
		String requestVilleTarif = "SELECT * FROM Taxi WHERE NOT EXISTS (SELECT * FROM Reservation WHERE Taxi.idTaxi=Reservation.idTaxi) "
				+ "AND Taxi.ville="+"'"+ville+"' and Taxi.tarifDeBase="+"'"+tarifDeBase+"'";
		String requestVilleCategorie = "SELECT * FROM Taxi WHERE NOT EXISTS (SELECT * FROM Reservation WHERE Taxi.idTaxi=Reservation.idTaxi) "
				+ "AND Taxi.ville="+"'"+ville+"' and Taxi.categorie="+"'"+categorie+"'";
		String requestVilleTarifCategorie = "SELECT * FROM Taxi WHERE NOT EXISTS (SELECT * FROM Reservation WHERE Taxi.idTaxi=Reservation.idTaxi) "
				+ "AND Taxi.ville="+"'"+categorie+"' and Taxi.tarifDeBase="+"'"+tarifDeBase+"' and Taxi.ville="+"'"+categorie+"'";
		
		//Taxi taxi = new Taxi();
		try {
			Statement stat = connexionBDD().createStatement();
			if(ville==null && tarifDeBase==null) {
				stat.executeQuery(requestCategorie);
			}
			if(ville==null) {
				stat.executeQuery(requestCategorieTarif);
			}
			if(categorie==null && tarifDeBase==null) {
				stat.executeQuery(requestVille);
			}
			if(categorie==null && ville!=null &&tarifDeBase!=null ) {
				stat.executeQuery(requestVilleTarif);
			}
			if(tarifDeBase==null) {
				stat.executeQuery(requestVilleCategorie);
			}
			if(tarifDeBase!=null && categorie!=null && ville!=null) {
				stat.executeQuery(requestVilleTarifCategorie);
			}
			

			
			ResultSet rset = stat.getResultSet();
			while(rset.next()) {
				Taxi taxiTrouve = new Taxi();
				taxiTrouve.setIdTaxi(rset.getInt("idTaxi"));
				taxiTrouve.setCategorie(rset.getString("categorie"));
				taxiTrouve.setVille(rset.getString("ville"));
				taxiTrouve.setTarifDeBase(rset.getString("tarifDeBase"));
				result.add(taxiTrouve);
			}
			for(int i=0;i<result.size();i++) {
				System.out.println("taxis="+result.get(i).getIdTaxi());
			}
			rset.close();
			stat.close();
			connexionBDD().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public void reserverTaxi(int idTaxi, String date, String destination, int idClient) throws SQLException {
		int paiementEffectue = 0;
		
		String request = "INSERT INTO Reservation VALUES ('0','"
							+date+"','"
							+destination+"','"
							+paiementEffectue+"','"
							+idClient+"','"
							+idTaxi+"')";
	
		Statement stat = connexionBDD().createStatement();
		stat.executeUpdate(request);
	}
	
	public void annulerTaxi() throws SQLException {
	}
	
	public void payerTaxi() throws SQLException {
	}

	
	
	
}


