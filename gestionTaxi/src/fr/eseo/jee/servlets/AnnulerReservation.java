package fr.eseo.jee.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eseo.jee.beans.Taxi;
import fr.eseo.jee.ws.GestionTaxi;

/**
 * Servlet implementation class AnnulerReservation
 */
@WebServlet("/AnnulerReservation")
public class AnnulerReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnnulerReservation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int idReservation = Integer.parseInt(request.getParameter("idReservation"));
		String dateReservation =request.getParameter("dateReservation");
		String ville =request.getParameter("ville");
		String destination =request.getParameter("destination");
		String paiement =request.getParameter("paiement");
		
		GestionTaxi gestionTaxi = new GestionTaxi();
		boolean resas;
		try {
			resas = gestionTaxi.annulerTaxi(idReservation);
			HttpSession session = request.getSession();
			session.setAttribute("resas", resas);
			session.setAttribute("dateReservation", dateReservation);
			session.setAttribute("ville", ville);
			session.setAttribute("destination", destination);
			session.setAttribute("paiement", paiement);
			RequestDispatcher dispat = request.getRequestDispatcher("Annuler.jsp");
			dispat.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
