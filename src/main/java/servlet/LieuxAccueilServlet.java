package servlet;

import dao.EquipeDao;
import dao.LieuxAccueilDao;
import entites.LieuxAccueil;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class LieuxAccueilServlet extends HttpServlet {
    // ...

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EquipeDao EquipeDao;
	private LieuxAccueilDao LieuxAccueilDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LieuxAccueilServlet() {
        super(); 
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
        EquipeDao = new EquipeDao();
        LieuxAccueilDao = new LieuxAccueilDao();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		
		  
	String action = request.getServletPath();
		

        try {
            switch (action) {
            	case "/addLieu":
            		AjouterLieu(request, response);
            		break;
                case "/deleteLieu":
                	DeleteLieu(request, response);
                    break;
                case "/updateLieu":
                	updateLieu(request, response);
                    break;
                case "/getLieu":
                	getLieu(request, response);
                    break;
                
                default:
                	list_Lieu(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
		
		
		
		
		
	}
	
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		doGet(request, response);
	}
	
	
	
	
	private void list_Lieu(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List<LieuxAccueil> listlieux = LieuxAccueilDao.findAll();
		        request.setAttribute("lieuxAccueils", listlieux);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("lieu/listeLieux.jsp");
		        dispatcher.forward(request, response);
		    }
	
	private void getLieu(HttpServletRequest request, HttpServletResponse response)
	        throws SQLException, IOException, ServletException {
	    
	    // Récupérer l'ID d'équipe à partir des paramètres de requête
	    long lieuAccueilId = Integer.parseInt(request.getParameter("lieuAccueilId"));

	    // Appeler la méthode pour obtenir l'équipe par ID
	    LieuxAccueil lieuAccueil = LieuxAccueilDao.findById(lieuAccueilId);

	    // Mettre l'équipe dans la portée de la requête
	    request.setAttribute("lieuAccueil",lieuAccueil);
	    // Dispatch vers la page de détails de l'équipe
	    RequestDispatcher dispatcher = request.getRequestDispatcher("lieu/updatelieu.jsp");
	    dispatcher.forward(request, response);
	    //response.sendRedirect("pwa_Application/Admin/Equipe/modifierEquipe.jsp");
	}


	
	private void AjouterLieu(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		
				
		String nom = request.getParameter("nom");
        String type = request.getParameter("type");
        String adresse = request.getParameter("adresse");
        String telephone = request.getParameter("telephone");
        String courriel = request.getParameter("courriel");
        String siteInternet = request.getParameter("siteInternet");
        String infosPMR = request.getParameter("infosPMR");
        int capacite = Integer.parseInt(request.getParameter("capacite"));
        String commentaires = request.getParameter("commentaires");

        

        LieuxAccueil nouveauLieuxAccueil = new LieuxAccueil();
        nouveauLieuxAccueil.setNom(nom);
        nouveauLieuxAccueil.setType(type);
        nouveauLieuxAccueil.setAdresse(adresse);
        nouveauLieuxAccueil.setTelephone(telephone);
        nouveauLieuxAccueil.setCourriel(courriel);
        nouveauLieuxAccueil.setSiteInternet(siteInternet);
        nouveauLieuxAccueil.setInfosPMR(infosPMR);
        nouveauLieuxAccueil.setCapacite(capacite);
        nouveauLieuxAccueil.setCommentaires(commentaires);

        LieuxAccueilDao.create(nouveauLieuxAccueil);
		        response.sendRedirect("listLieu");
		    }
	
	private void DeleteLieu(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		
		        long lieuId =Integer.parseInt(request.getParameter("lieuAccueilId"));
		        LieuxAccueilDao.delete(lieuId);
		        response.sendRedirect("listLieu");

		    }
	

		    
	private void updateLieu(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		long lieuId = Integer.parseInt(request.getParameter("lieuId"));
		String nom = request.getParameter("nom");
        String type = request.getParameter("type");
        String adresse = request.getParameter("adresse");
        String telephone = request.getParameter("telephone");
        String courriel = request.getParameter("courriel");
        String siteInternet = request.getParameter("siteInternet");
        String infosPMR = request.getParameter("infosPMR");
        String capaciteStr = request.getParameter("capacite");
        String commentaires = request.getParameter("commentaires");

        Integer capacite = capaciteStr.isEmpty() ? null : Integer.parseInt(capaciteStr);

        LieuxAccueil nouveauLieuxAccueil = new LieuxAccueil();
        nouveauLieuxAccueil.setId(lieuId);
        nouveauLieuxAccueil.setNom(nom);
        nouveauLieuxAccueil.setType(type);
        nouveauLieuxAccueil.setAdresse(adresse);
        nouveauLieuxAccueil.setTelephone(telephone);
        nouveauLieuxAccueil.setCourriel(courriel);
        nouveauLieuxAccueil.setSiteInternet(siteInternet);
        nouveauLieuxAccueil.setInfosPMR(infosPMR);
        nouveauLieuxAccueil.setCapacite(capacite);
        nouveauLieuxAccueil.setCommentaires(commentaires);
       

        LieuxAccueilDao.update(nouveauLieuxAccueil);
        response.sendRedirect("listLieu");
	}
}