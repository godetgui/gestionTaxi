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

import fr.eseo.jee.bdd.GestionClient;
import fr.eseo.jee.bdd.GestionReservation;
import fr.eseo.jee.beans.Client;
import fr.eseo.jee.beans.ReservationTaxi;

/**
 * Servlet implementation class GererDejaClient
 */
@WebServlet("/GererDejaClient")
public class GererDejaClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GererDejaClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String idClient = request.getParameter("idClient");
		System.out.println("nom: "+nom);
		System.out.println("nom: "+prenom);
		System.out.println("nom: "+idClient);
		
		
		//On envoie l'idClient dans la session
		GestionClient gestionClient = new GestionClient();
		//Client client = gestionClient.trouverClient(nom, prenom);
		if(nom==null && prenom==null && idClient.equals(null)){
			//améliorer affichage erreur
			System.out.println("Le client n'existe pas dans la base de données");
		}
		if(idClient==null && !nom.equals(null) && prenom!=(null)) {
			HttpSession session = request.getSession();
			Client client = gestionClient.trouverClient(nom, prenom);
			session.setAttribute("idClient", client.getIdClient());
			//On recupere les reservations assosciées à cet idClient
			GestionReservation gestionReservation = new GestionReservation();
			ArrayList<ReservationTaxi> listReservations = gestionReservation.trouverReservation(client.getIdClient());
			session.setAttribute("listReservations", listReservations);
			
			RequestDispatcher dispat = request.getRequestDispatcher("accueil.jsp");
			dispat.forward(request, response);
		}
		if(!idClient.equals(null) && nom==null && prenom==null) {
			System.out.println("nom: "+nom);
			System.out.println("nom: "+prenom);
			System.out.println("nom: "+idClient);
			HttpSession session = request.getSession();
			Client client = gestionClient.trouverClientByID(Integer.parseInt(idClient));
			session.setAttribute("idClient", client.getIdClient());
			//On recupere les reservations assosciées à cet idClient
			GestionReservation gestionReservation = new GestionReservation();
			ArrayList<ReservationTaxi> listReservations = gestionReservation.trouverReservation(client.getIdClient());
			session.setAttribute("listReservations", listReservations);
			
			RequestDispatcher dispat = request.getRequestDispatcher("accueil.jsp");
			dispat.forward(request, response);
		}
		
	}
	

}