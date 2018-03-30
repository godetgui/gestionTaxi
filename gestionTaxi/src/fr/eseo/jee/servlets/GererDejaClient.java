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
		
		
		GestionClient gestionClient = new GestionClient();
		Client client = null;
		
		HttpSession session = request.getSession();
		
		if(nom==null && prenom==null && idClient==null){
			System.out.println("ERREUR : Vous n'avez rempli aucun champ.");
		} else if(nom==null && prenom==null && idClient!=null){
			client = gestionClient.trouverClientByID(Integer.parseInt(idClient));
			if(client.getIdClient()==0){
				System.out.println("Le client n'existe pas dans la base de données");
			} else {
				session.setAttribute("idClient", client.getIdClient());
				//On recupere les reservations assosciées à cet idClient
				GestionReservation gestionReservation = new GestionReservation();
				ArrayList<ReservationTaxi> listReservations = gestionReservation.trouverReservation(client.getIdClient());
				session.setAttribute("listReservations", listReservations);
				RequestDispatcher dispat = request.getRequestDispatcher("accueil.jsp");
				dispat.forward(request, response);
			}
		} else if(nom!=null && prenom!=null && idClient==null){
			client = gestionClient.trouverClient(nom, prenom);
			if(client.getIdClient()==0){
				System.out.println("Le client n'existe pas dans la base de données");
			} else {
				session.setAttribute("idClient", client.getIdClient());
				//On recupere les reservations assosciées à cet idClient
				GestionReservation gestionReservation = new GestionReservation();
				ArrayList<ReservationTaxi> listReservations = gestionReservation.trouverReservation(client.getIdClient());
				session.setAttribute("listReservations", listReservations);
				RequestDispatcher dispat = request.getRequestDispatcher("accueil.jsp");
				dispat.forward(request, response);
			}
		} else if(nom==null && prenom!=null && idClient==null){
			System.out.println("ERREUR : Vous n'avez pas rempli votre nom");
		} else if (nom!=null && prenom==null && idClient==null){
			System.out.println("ERREUR : vous n'avez pas rentré votre prénom");
		} else if(nom!=null && prenom!=null && idClient!=null){
			System.out.println("ERREUR : cette situation ne devrait pas être possible");
		}
		
	}
	

}