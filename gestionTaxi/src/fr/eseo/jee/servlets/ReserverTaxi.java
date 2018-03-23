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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String date = request.getParameter("date");
		String destination = request.getParameter("destination");
		int paimentEffectue = Integer.parseInt(request.getParameter("paimentEffectue"));
		int idClient = Integer.parseInt(request.getParameter("idClient"));
		int idTaxi = Integer.parseInt(request.getParameter("idTaxi"));
		System.out.println("DATE dans ReserverTaxi: "+date);
		System.out.println("DESTINATION dans ReserverTaxi: "+destination);
		System.out.println("PAIEMENT dans ReserverTaxi: "+paimentEffectue);
		System.out.println("IDCLIENT dans ReserverTaxi: "+idClient);
		System.out.println("IDTAXI dans ReserverTaxi: "+idTaxi);
		GestionTaxi gestionTaxi = new GestionTaxi();
		try {
			gestionTaxi.reserverTaxi(idTaxi, date, destination, idClient);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dispat = request.getRequestDispatcher("ConfirmationReservation.jsp");
		dispat.forward(request, response);
		
	}



}
