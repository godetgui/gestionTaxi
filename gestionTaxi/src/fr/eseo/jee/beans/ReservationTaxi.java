package fr.eseo.jee.beans;

import java.util.Date;

public class ReservationTaxi {
	
	private int idReservation;
	private Date dateReservation;
	private String destination;
	private boolean paiementEffectue;
	
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
	public Date getDateReservation() {
		return dateReservation;
	}
	public void setDateReservation(Date dateReservation) {
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

}
