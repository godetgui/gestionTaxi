package fr.eseo.jee.ws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.eseo.jee.beans.Client;

public class GestionClient {
	
	
	public ArrayList<Client> trouverClient(String nom, String prenom) {
		ArrayList<Client> result = new ArrayList<Client>();
		String request = "SELECT nom, prenom FROM Client ORDER BY idClient";
		Client client = new Client();
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/gestionTaxi?&characterEncoding=UTF8&useSSL=true&user=user&password=user");
			Statement stat = connect.createStatement();
			stat.executeQuery(request);
			ResultSet rset = stat.getResultSet();
			while(rset.next()) {
				client.setNom(rset.getString("nom"));
				client.setPrenom(rset.getString("prenom"));
				result.add(client);
			}
			for(int i=0;i<result.size();i++) {
				System.out.println("clients="+result.get(i).getNom());
				System.out.println("taille list clients="+result.size());
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
