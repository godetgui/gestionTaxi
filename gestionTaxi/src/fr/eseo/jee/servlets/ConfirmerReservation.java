package fr.eseo.jee.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eseo.jee.beans.ReservationTaxi;
import fr.eseo.jee.ws.GestionTaxi;

/**
 * Servlet implementation class ReserverTaxi
 */
@WebServlet("/ConfirmerReservation")
public class ConfirmerReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmerReservation() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    boolean booleanPaiementEffectue;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String destination = request.getParameter("destination");
		
		HttpSession session = request.getSession();
		
		int idTaxi = (int) session.getAttribute("idTaxi");
		int idClient = (int) session.getAttribute("idClient");
		
		
		if(date.equals("null")){
			System.out.println("Il manque la date");
		}
		if(time.equals("null")){
			System.out.println("Il manque l'horaire");
		}
		if(destination.equals("null")){
			System.out.println("Il manque la destination");
		}
		if(!date.matches(".*-.*-.*")){
			System.out.println("Le format de la date n'est pas bon");
		}
		if(!time.matches(".*:.*:.*")){
			System.out.println("Le format de l'horaire n'est pas le bon");
		}
		
		String dateComplete = date.substring(6, 10) + "-" + date.substring(3,5) + "-" + date.substring(0,2) + " " + time;

		ReservationTaxi reservation = new ReservationTaxi();
		reservation.setDateReservation(dateComplete);
		reservation.setDestination(destination);
		reservation.setIdClient(idClient);
		reservation.setIdTaxi(idTaxi);
		reservation.setPaiementEffectue(false);
		
		GestionTaxi gestionTaxi = new GestionTaxi();
		int idReservation=0;
		try {
			idReservation = gestionTaxi.reserverTaxi(reservation);
			System.out.println("id : "+idReservation);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		session.setAttribute("idReservation", idReservation);
		RequestDispatcher dispat = request.getRequestDispatcher("ConfirmationReservation.jsp");
		dispat.forward(request, response);
		
	}



}
