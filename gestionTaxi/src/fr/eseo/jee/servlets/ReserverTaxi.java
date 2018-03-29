package fr.eseo.jee.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eseo.jee.beans.ReservationTaxi;
import fr.eseo.jee.beans.Taxi;
import fr.eseo.jee.ws.GestionTaxi;

/**
 * Servlet implementation class ReserverTaxi
 */
@WebServlet("/ReserverTaxi")
public class ReserverTaxi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReserverTaxi() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    boolean booleanPaiementEffectue;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		int idTaxi = Integer.parseInt(request.getParameter("idTaxi"));
		
		Taxi taxi = new Taxi();
		taxi.setIdTaxi(idTaxi);
		
		GestionTaxi gestionTaxi = new GestionTaxi();
		ArrayList<Taxi> taxiReservation = gestionTaxi.trouverTaxi(taxi);
		HttpSession session = request.getSession();
		session.setAttribute("taxiReservation", taxiReservation);
		session.setAttribute("idTaxi", idTaxi);
		
		
		RequestDispatcher dispat = request.getRequestDispatcher("DetailsReservation.jsp");
		dispat.forward(request, response);
		
	}



}
