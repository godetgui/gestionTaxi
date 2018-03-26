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

import fr.eseo.jee.beans.Taxi;
import fr.eseo.jee.ws.GestionTaxi;

/**
 * Servlet implementation class RechercherTaxi
 */
@WebServlet("/RechercherTaxi")
public class RechercherTaxi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechercherTaxi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String ville = request.getParameter("ville");
		String date = request.getParameter("annee")+"-"+request.getParameter("mois")+"-"+request.getParameter("jour")+"/"+request.getParameter("heure")+":"+request.getParameter("minute")+":00";
		//"2018-03-16/14:20:00"
		String categorie = request.getParameter("categorie");
		String destination = request.getParameter("destination");
		System.out.println("DESTINATIOOOOOOOOON: "+destination);
		GestionTaxi gestionTaxi = new GestionTaxi();
		ArrayList<Taxi> taxis = gestionTaxi.trouverTaxi(new Taxi(categorie, ville));
		HttpSession session = request.getSession();
		session.setAttribute("taxis", taxis);
		session.setAttribute("date", date);
		session.setAttribute("destination", destination);
		session.setAttribute("ville", ville);
		RequestDispatcher dispat = request.getRequestDispatcher("TrouverTaxijsp.jsp");
		dispat.forward(request, response);
	}

}
