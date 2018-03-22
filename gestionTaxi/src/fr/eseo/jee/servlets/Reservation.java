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

import fr.eseo.jee.beans.Client;

import fr.eseo.jee.ws.GestionClient;


/**
 * Servlet implementation class Reservation
 */
@WebServlet("/Reservation")
public class Reservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reservation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		//int idClient = Integer.parseInt(request.getParameter("idClient"));
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		//String adresse = request.getParameter("adresse");
		//String telephone = request.getParameter("telephone");
		GestionClient gestionClient = new GestionClient();
		ArrayList<Client> clients = gestionClient.trouverClient(nom, prenom);
		for(int i=0;i<clients.size();i++) {
			System.out.println("clients from servlet="+clients.get(i).getIdClient());
			System.out.println("nombre de clients dans la liste="+clients.size());
		}
		HttpSession session = request.getSession();
		session.setAttribute("clients", clients);
		
		RequestDispatcher dispat = request.getRequestDispatcher("ConnexionClient.jsp");
		dispat.forward(request, response);
	}

}
