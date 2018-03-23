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

import fr.eseo.jee.bdd.GestionClient;

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
		
		GestionClient gestionClient = new GestionClient();
		int idClient = gestionClient.trouverClient(nom, prenom).getIdClient();
		System.out.println("Dans GererDejaClient: id du client: "+idClient);
		HttpSession session = request.getSession();
		session.setAttribute("idClient", idClient);
		RequestDispatcher dispat = request.getRequestDispatcher("accueil.jsp");
		dispat.forward(request, response);
	}
	

}
