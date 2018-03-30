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
		Float tarif = taxi.getTarifDeBase();
		int idTaxi = taxi.getIdTaxi();
		
		
		ArrayList<Taxi> result = new ArrayList<Taxi>();
		
		String request = "SELECT * FROM Taxi"; 
		String requestVilleCategorieTarif = "SELECT * FROM Taxi WHERE ville="+"'"+ville+"' and categorie="+"'"+categorie+"' and tarifDeBase<"+tarif;
		String requestVilleCategorie = "SELECT * FROM Taxi WHERE ville="+"'"+ville+"' and categorie="+"'"+categorie+"'";
		String requestVilleTarif = "SELECT * FROM Taxi WHERE ville="+"'"+ville+"' and tarifDeBase="+tarif;
		String requestCategorieTarif = "SELECT * FROM Taxi WHERE categorie="+"'"+categorie+"' and tarifDeBase<"+tarif;
		String requestCategorie = "SELECT * FROM Taxi WHERE categorie="+"'"+categorie+"'";
		String requestVille = "SELECT * FROM Taxi WHERE ville="+"'"+ville+"'";
		String requestTarif = "SELECT * FROM Taxi WHERE tarifDeBase<"+tarif;
		
		try {
			Statement stat = connexionBDD().createStatement();
			if(idTaxi==0){
				if(ville.equals("null") && tarif==null && categorie.equals("null")){
					stat.executeQuery(request);
				} else if (ville.equals("null") && categorie.equals("null")){
					stat.executeQuery(requestTarif);
				} else if (ville.equals("null") && tarif==null){
					stat.executeQuery(requestCategorie);
				} else if (categorie.equals("null") && tarif==null){
					stat.executeQuery(requestVille);
				} else if (ville.equals("null")){
					stat.executeQuery(requestCategorieTarif);
				} else if (categorie.equals("null")){
					stat.executeQuery(requestVilleTarif);
				} else if (tarif==null){
					stat.executeQuery(requestVilleCategorie);
				} else {
					stat.executeQuery(requestVilleCategorieTarif);
				}	
			} else {
				stat.executeQuery("SELECT * FROM Taxi WHERE idTaxi ="+idTaxi);
			}
			
			ResultSet rset = stat.getResultSet();
			while(rset.next()) {
				Taxi taxiTrouve = new Taxi();
				taxiTrouve.setIdTaxi(rset.getInt("idTaxi"));
				taxiTrouve.setCategorie(rset.getString("categorie"));
				taxiTrouve.setVille(rset.getString("ville"));
				taxiTrouve.setTarifDeBase(rset.getFloat("tarifDeBase"));
				result.add(taxiTrouve);
			}
			rset.close();
			stat.close();
			connexionBDD().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public int reserverTaxi(ReservationTaxi reservation) throws SQLException {
		
		String date = reservation.getDateReservation();
		int idTaxi = reservation.getIdTaxi();
		String destination = reservation.getDestination();
		int idClient = reservation.getIdClient();
		Boolean paiementEffectue = reservation.isPaiementEffectue();
		int paiement=0;
		
		if(paiementEffectue){
			paiement = 1;
		} else {
			paiement = 0;
		}
		
		System.out.println(date);
		System.out.println(idTaxi);
		
		
		//On vérifie qu'il n'existe pas déjà une réservation pour le même taxi à la même date
		//On se place dans le cas ou une réservation = 1h
		String requestVerification = "SELECT * FROM Reservation WHERE idTaxi="+idTaxi+" AND dateReservation='"+date+"' OR  idTaxi="+idTaxi+" AND ABS(TIMESTAMPDIFF(MINUTE,'"+date+"',dateReservation))<60";
		Statement stat3 = connexionBDD().createStatement();
		System.out.println("test1");
		ResultSet rs =  stat3.executeQuery(requestVerification);
		System.out.println("test1");
		if(rs.next()){
			System.out.println("Il existe déjà une réservation à la même heure. Veuillez sélectionner une autre heure ou un autre taxi");
		} 
			//Requetes
			
			String requestInsert = "INSERT INTO Reservation(dateReservation,destination,booleenPaiementEffectue,idClient,idTaxi) VALUES ('"
					+date+"','"
					+destination+"',"
					+paiementEffectue+","
					+idClient+","
					+idTaxi+")";
			
			String requestIdReservation = "SELECT idReservation FROM Reservation WHERE Reservation.idClient="+idClient
					+" and Reservation.idTaxi="+idTaxi
					+" and Reservation.booleenPaiementEffectue="+paiementEffectue
					+" and Reservation.destination= '"+destination
					+"' and Reservation.dateReservation= '"+date+"'";
				
			System.out.println("test1");
			Statement stat1 = connexionBDD().createStatement();
			System.out.println("test2");
			Statement stat2 = connexionBDD().createStatement();
			System.out.println("test3");
			stat1.executeUpdate(requestInsert);
			System.out.println("test4");
			stat2.executeQuery(requestIdReservation);
			System.out.println("test5");
		
	
		return Integer.parseInt(stat2.getResultSet().getString("idReservation"));
	}
	
	
	

	public boolean annulerTaxi(int idReservation) throws SQLException {
		boolean annuler=false;
		
		String requeteAnnuler = "DELETE FROM Reservation WHERE Reservation.idReservation= '"+idReservation+"'";
		String requeteVerification = "DELETE FROM Reservation WHERE Reservation.idReservation= '"+idReservation+"'";
		
		Statement stat1 = connexionBDD().createStatement();
		Statement stat2 = connexionBDD().createStatement();
		stat1.executeUpdate(requeteAnnuler);
		System.out.println("test6");
		
		if((stat2.executeUpdate(requeteVerification))==0) {
			annuler = true;
			System.out.println("test7");
		}
		else{
			annuler = false;
		}
		return annuler;
	}
	
	
	public String payerTaxi(int idReservation) throws SQLException {
		String requetePaiement = "UPDATE Reservation SET booleenPaiementEffectue = '1' WHERE idReservation="+idReservation;
		Statement stat = connexionBDD().createStatement();
		stat.executeUpdate(requetePaiement);
		System.out.println("Je suis dans PayerTaxi()");
		
		return "Paiement Effectué pour la réservation n° "+idReservation;
	}
	
	
}


