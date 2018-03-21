package fr.eseo.jee.beans;

/**
 * @author Julien
 *
 */
public class Taxi {

	private int idTaxi;
	private String categorie;
	private String ville;
	private String tarifDeBase;

	public Taxi() {
		super();
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
