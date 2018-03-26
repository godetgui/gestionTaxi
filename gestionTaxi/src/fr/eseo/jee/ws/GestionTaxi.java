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
		ArrayList<Taxi> result = new ArrayList<Taxi>();
		
		String requestCategorie = "SELECT * FROM Taxi WHERE NOT EXISTS (SELECT * FROM Reservation WHERE Taxi.idTaxi=Reservation.idTaxi) AND Taxi.categorie="+"'"+categorie+"'";
		String requestVille = "SELECT * FROM Taxi WHERE NOT EXISTS (SELECT * FROM Reservation WHERE Taxi.idTaxi=Reservation.idTaxi) AND Taxi.ville="+"'"+ville+"'";
		String requestVilleCategorie = "SELECT * FROM Taxi WHERE NOT EXISTS (SELECT * FROM Reservation WHERE Taxi.idTaxi=Reservation.idTaxi) "
				+ "AND Taxi.ville="+"'"+ville+"' and Taxi.categorie="+"'"+categorie+"'";
		String request = "SELECT * FROM Taxi WHERE NOT EXISTS (SELECT * FROM Reservation WHERE Taxi.idTaxi=Reservation.idTaxi)";
		
		//Taxi taxi = new Taxi();
		System.out.println("Ville: "+ville);
		System.out.println("Categorie: "+categorie);
		try {
			Statement stat = connexionBDD().createStatement();
			if(ville.equals("null") && !categorie.equals("null")) {
				stat.executeQuery(requestCategorie); //OK
				System.out.println("RequeteCategorie effecuée");
			}
			if(categorie.equals("null") && !ville.equals("null")) {
				stat.executeQuery(requestVille); //OK
				System.out.println("RequeteVille effecuée");
			}
			if(ville.equals("null") && categorie.equals("null")) {
				stat.executeQuery(request); //OK
			}
			if(!categorie.equals("null") && !ville.equals("null")) {
				stat.executeQuery(requestVilleCategorie); //OK
				System.out.println("RequeteVilleCategorie effecuée");	
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
	
	
	public void reserverTaxi(ReservationTaxi reservation) throws SQLException {
		//int idTaxi, String date, String destination, int idClient
		String date = reservation.getDateReservation();
		String ville = reservation.getVille();
		String destination = reservation.getDestination();
		int paiementEffectue;
		if(reservation.isPaiementEffectue()==false) {
			paiementEffectue = 0;
		}
		else {
			paiementEffectue = 1;
		}
		int idClient = reservation.getIdClient();
		int idTaxi = reservation.getIdTaxi();
		
		
		String request = "INSERT INTO Reservation VALUES ('0','"
				+date+"','"
                +ville+"','"
				+destination+"','"
				+paiementEffectue+"','"
				+idClient+"','"
				+idTaxi+"')";
	
		Statement stat = connexionBDD().createStatement();
		stat.executeUpdate(request);
	}

	
	
	
}


