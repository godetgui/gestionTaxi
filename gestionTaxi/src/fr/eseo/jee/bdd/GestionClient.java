package fr.eseo.jee.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.eseo.jee.beans.Client;

public class GestionClient {
	
	
	public Connection connexionBDD() throws SQLException {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/gestionTaxi?user=root&password=root");
		return connect;
		
	}
	
	public Client trouverClient(String nom, String prenom) {
		String request = "SELECT * FROM Client WHERE nom="+"'"+nom+"'"+ "and prenom="+"'"+prenom+"'";
		Client client = new Client();
		try {
			Statement stat = connexionBDD().createStatement();
			stat.executeQuery(request);
			ResultSet rset = stat.getResultSet();
			while(rset.next()) {
				client.setNom(rset.getString("nom"));
				client.setPrenom(rset.getString("prenom"));
				client.setIdClient(Integer.parseInt(rset.getString("idClient")));
				client.setAdresse(rset.getString("adresse"));
				client.setTelephone(rset.getString("telephone"));
			}
			rset.close();
			stat.close();
			connexionBDD().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return client;
	}
	
	public void creerNouveauClient(String nom, String prenom, String adresse, String numeroTel) throws SQLException {
		String request = "INSERT INTO Client VALUES('0','"+ nom+"','"+prenom+"','"+adresse+"','"+numeroTel+"');";
		
		Statement stat = connexionBDD().createStatement();
		stat.executeUpdate(request);
	}

}
