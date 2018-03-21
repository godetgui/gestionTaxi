package fr.eseo.jee.beans;

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
	
	public Client() {
		super();
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
