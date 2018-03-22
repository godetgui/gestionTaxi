package fr.eseo.jee.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Driver;

import fr.eseo.jee.beans.Taxi;

public class GestionTable {
	
	
	public static ArrayList<String> getVille() {
		ArrayList<String> result=new ArrayList<String>();
		try {
			DriverManager.registerDriver(new Driver());
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/gestionTaxi?&characterEncoding=UTF8&useSSL=true&user=user&password=user");
			Statement stat = connect.createStatement();
//			stat.executeQuery("SELECT COUNT(DISTINCT Taxi.ville) AS nombre FROM TAXI");
			stat.executeQuery("SELECT Taxi.ville FROM Taxi GROUP BY Taxi.ville");
			ResultSet rset = stat.getResultSet();
			while(rset.next()) {
				result.add(rset.getString("ville"));
			}
			System.out.println("RESULT="+result);
			rset.close();
			stat.close();
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
