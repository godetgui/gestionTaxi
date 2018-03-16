package fr.eseo.jee.modele;

import java.util.Calendar;

public class ReservationTaxi {
	
	int idReservation;
	Calendar date;
	Calendar heure;
	String destination;
	boolean paiementEffectue;
	
	public int getIdReservation() {
		return idReservation;
	}
	public void setIdReservation(int idReservation) {
		this.idReservation = idReservation;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public Calendar getHeure() {
		return heure;
	}
	public void setHeure(Calendar heure) {
		this.heure = heure;
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
	
	
	public ReservationTaxi(int idReservation, Calendar date, Calendar heure, String destination,
			boolean paiementEffectue) {
		super();
		this.idReservation = idReservation;
		this.date = date;
		this.heure = heure;
		this.destination = destination;
		this.paiementEffectue = paiementEffectue;
	}
	
	

}
