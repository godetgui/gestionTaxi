package fr.eseo.jee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory {

	private static final String FICHIER_PROPERTIES = "fr/eseo/jee/dao/dao.properties";
	private static final String PROPERTY_URL = "url";
	private static final String PROPERTY_DRIVER = "driver";
	private static final String PROPERTY_NOM_UTILISATEUR = "nomUtilisateur";
	private static final String PROPERTY_MOT_DE_PASSE = "motDePasse";

	private String url;
	private String nomUtilisateur;
	private String motDePasse;
	
	public Connection getConnection() throws SQLException {
		// si on souhaite une simple connexion à la BDD
		if (this.url != null || this.nomUtilisateur != null || this.motDePasse != null) {
			return DriverManager.getConnection(this.url, this.nomUtilisateur, this.motDePasse);
		} else { // sinon, on souhaite une connexion au pool de connexions
			return this.dataSource.getConnection();
		}
	}
}
