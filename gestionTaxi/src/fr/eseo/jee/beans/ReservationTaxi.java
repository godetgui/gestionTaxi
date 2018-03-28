package fr.eseo.jee.beans;

import java.util.Date;

public class ReservationTaxi {
	
	private int idReservation;
	private String dateReservation;
	private String destination;
	private boolean paiementEffectue;
	private int idTaxi;
	private int idClient;
	
	//Constructeur 
	public ReservationTaxi() {
		super();
	}

	public int getIdReservation() {
		return idReservation;
	}
	public void setIdReservation(int idReservation) {
		this.idReservation = idReservation;
	}
	public String getDateReservation() {
		return dateReservation;
	}
	public void setDateReservation(String dateReservation) {
		this.dateReservation = dateReservation;
	}
	
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public boolean isPaiementEffectue() {
		return paiementEffectue;
	}
	public void setPaiementEffectue(boolean paiementEffectue) {
		this.paiementEffectue = paiementEffectue;
	}


	public int getIdTaxi() {
		return idTaxi;
	}


	public void setIdTaxi(int idTaxi) {
		this.idTaxi = idTaxi;
	}


	public int getIdClient() {
		return idClient;
	}


	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

}
