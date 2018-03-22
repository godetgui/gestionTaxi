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
 * Servlet implementation class GererClient
 */
@WebServlet("/GererNouveauClient")
public class GererNouveauClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GererNouveauClient() {
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
		String adresse = request.getParameter("adresse");
		String numeroTel = request.getParameter("telephone");
		
		GestionClient gestionClient = new GestionClient();
		try {
			gestionClient.creerNouveauClient(nom, prenom, adresse, numeroTel);
			
			int idClient = gestionClient.trouverClient(nom, prenom).getIdClient();
			HttpSession session = request.getSession();
			session.setAttribute("idClient", idClient);
			RequestDispatcher dispat = request.getRequestDispatcher("accueil.jsp");
			dispat.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
