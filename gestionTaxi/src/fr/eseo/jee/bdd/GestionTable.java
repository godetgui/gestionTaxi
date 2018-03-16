package fr.eseo.jee.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.eseo.jee.modele.Taxi;

public class GestionTable {
	
	public static void main(String[] args) throws SQLException {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection db = DriverManager.getConnection("jdbc:mysql://localhost/gestionTaxi?user=root&password=");
		Statement s1 = db.createStatement();
		s1.executeUpdate("Insert into Client values(1,'godet','guillaume','XX','0102030400')");
	}
	
	public ArrayList<Taxi> getTaxis() {
		ArrayList<Taxi>  result = new ArrayList<Taxi>(); 
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/Sujet4?&characterEncoding=UTF8&useSSL=true&user=root&password=password");
			Statement stat = connect.createStatement();
			stat.executeQuery("SELECT * FROM Taxi");
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
