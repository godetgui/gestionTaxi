package fr.eseo.jee.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eseo.jee.bdd.GestionReservation;
import fr.eseo.jee.beans.ReservationTaxi;

/**
 * Servlet implementation class GererReservation
 */
@WebServlet("/GererReservation")
public class GererReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GererReservation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionReservation gestionReservation = new GestionReservation();
		HttpSession session = request.getSession();
		ArrayList<ReservationTaxi> listReservations = gestionReservation.trouverReservation( (Integer) session.getAttribute("idClient"));
		
		session.setAttribute("listReservations", listReservations);
		
		RequestDispatcher dispat = request.getRequestDispatcher("accueil.jsp");
		dispat.forward(request, response);
		
	}

}
