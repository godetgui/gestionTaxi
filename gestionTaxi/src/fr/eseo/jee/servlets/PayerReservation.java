package fr.eseo.jee.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eseo.jee.bdd.GestionReservation;
import fr.eseo.jee.beans.ReservationTaxi;
import fr.eseo.jee.ws.GestionTaxi;

/**
 * Servlet implementation class PayerReservation
 */
@WebServlet("/PayerReservation")
public class PayerReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayerReservation() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je suis dans le servlet PayerReservation()");
		request.setCharacterEncoding("UTF-8");
		int idReservation =Integer.parseInt(request.getParameter("idReservation"));
		System.out.println("ID RESERVATIOOOOOOOOOoN"+idReservation);
		
		
		GestionTaxi gestionTaxi = new GestionTaxi();
		try {
			gestionTaxi.payerTaxi(idReservation);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dispat = request.getRequestDispatcher("Paiement.jsp");
		
		dispat.forward(request, response);
		
	}

}
