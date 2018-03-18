package fr.eseo.jee.modele;

/**
 * 
 * @author alexaupetit
 *
 */

public class Client {
	
	private int idClient;
	private String nom;
	private String prenom;
	private String adresse;
	private String telephone;
	
	public Client(int idClient, String nom, String prenom, String adresse, String telephone) {
		super();
		this.idClient=idClient;
		this.nom=nom;
		this.prenom=prenom;
		this.adresse=adresse;
		this.telephone=telephone;
	}

	public int getIdClient() {
		return this.idClient;
	}
		
	public void setIdClient(int idClient) {
		this.idClient=idClient;
	}
		
	public String getNom() {
		return this.nom;
	}
	
	public void setNom(String nom) {
		this.nom=nom;
	}
	
	public String getPrenom() {
		return this.prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom=prenom;
	}
	
	public String getAdresse() {
		return this.adresse;
	}
	
	public void setAdresse(String adresse) {
		this.adresse=adresse;
	}
	
	public String getTelephone() {
		return this.telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone=telephone;
	}

}
