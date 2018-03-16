package fr.eseo.jee.modele;

/**
 * @author Julien
 *
 */
public class Taxi {

	int idTaxi;
	String categorie;
	String ville;
	String tarifDeBase;

	public Taxi(int idTaxi, String categorie, String ville, String tarifDeBase) {
		this.idTaxi = idTaxi;
		this.categorie = categorie;
		this.ville = ville;
		this.tarifDeBase = tarifDeBase;
	}

	public int getIdTaxi() {
		return idTaxi;
	}

	public void setIdTaxi(int idTaxi) {
		this.idTaxi = idTaxi;
	}

	public String getCategorie() {
		return categorie;
	}
	
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
	public String getVille() {
		return ville;
	}
	
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public String getTarifDeBase() {
		return tarifDeBase;
	}
	
	public void setTarifDeBase(String tarifDeBase) {
		this.tarifDeBase = tarifDeBase;
	}
	
}
