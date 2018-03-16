package fr.eseo.jee.bdd;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class GestionTable {
	
	public static void main(String[] args) throws SQLException {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection db = DriverManager.getConnection("jdbc:mysql://localhost/gestionTaxi?user=root&password=");
		Statement s1 = db.createStatement();
		s1.executeUpdate("Insert into Client values(1,'godet','guillaume','XX','0102030400')");
	}
	
	
}
