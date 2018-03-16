package fr.eseo.jee.ws;

import java.util.ArrayList;

import fr.eseo.jee.bdd.GestionTable;
import fr.eseo.jee.modele.Taxi;

public class GestionTaxi {
	
	public GestionTable gestionTable;
	
	public GestionTaxi() {
		this.gestionTable=new GestionTable();
	}
	
	public Taxi[] trouverTaxi(ArrayList<Taxi> taxis) {
		
		Taxi[] result = new Taxi[5];
		return result;
	}

	public GestionTable getGestionTable() {
		return gestionTable;
	}

	public void setGestionTable(GestionTable gestionTable) {
		this.gestionTable = gestionTable;
	}
	
	
	
}


