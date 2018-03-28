package fr.eseo.jee.beans;

/**
 * @author Julien
 *
 */
public class Taxi {

	private int idTaxi;
	private String categorie;
	private String ville;
	private Float tarifDeBase;

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
	
	public Float getTarifDeBase() {
		return tarifDeBase;
	}
	
	public void setTarifDeBase(Float tarifDeBase) {
		this.tarifDeBase = tarifDeBase;
	}
	
	public String toString(){
		return "Taxi numéro "+this.idTaxi+ " catégorie : "+this.categorie+" ville : "+this.ville+ "tarif : "+this.tarifDeBase;
	}
}
