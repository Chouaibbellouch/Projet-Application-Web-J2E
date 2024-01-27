package servlet;

import dao.EquipeDao;
import dao.JoueurDao;
import entites.Equipe;
import entites.Joueur;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.Column;

@WebServlet("/")
public class JoueurServlet extends HttpServlet {
    // ...

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EquipeDao EquipeDao;
	private JoueurDao JoueurDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoueurServlet() {
        super(); 
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
        EquipeDao = new EquipeDao();
        JoueurDao = new JoueurDao();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		
		  
	String action = request.getServletPath();
		

        try {
            switch (action) {
            	case "/addJoueur":
            		AjouterJoueur(request, response);
            		break;
            	case "/afficherFormulaireAjoutJoueur":
            		afficherFormulaireAjoutJoueur(request, response);
                	break;
                case "/deleteJoueur":
                	DeleteJoueur(request, response);
                    break;
                case "/updateJoueur":
                	updateJoueur(request, response);
                    break;
                case "/getJoueur":
                	getJoueur(request, response);
                    break;
                
                default:
                	list_Joueur(request, response);
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
	
	
	private void afficherFormulaireAjoutJoueur(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    List<Equipe> listEquipes = EquipeDao.findAll();
	    request.setAttribute("listEquipes", listEquipes);

	    RequestDispatcher dispatcher = request.getRequestDispatcher("joueur/insertJoueur.jsp");
	    dispatcher.forward(request,response);
	}
	
	private void list_Joueur(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List<Joueur> listJoueurs = JoueurDao.findAll();
		        request.setAttribute("joueurs", listJoueurs);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("joueur/listeJoueurs.jsp");
		        dispatcher.forward(request,response);
		    }
	
	private void getJoueur(HttpServletRequest request, HttpServletResponse response)
	        throws SQLException, IOException, ServletException {
	    
	    // Récupérer l'ID d'équipe à partir des paramètres de requête
	    long joueurId = Integer.parseInt(request.getParameter("joueurId"));
	    
	    List<Equipe> listEquipes = EquipeDao.findAll();

	    // Appeler la méthode pour obtenir l'équipe par ID
	    Joueur joueur = JoueurDao.findById(joueurId);

	    // Mettre l'équipe dans la portée de la requête
	    request.setAttribute("joueur", joueur);
	    request.setAttribute("listEquipes", listEquipes);
	    // Dispatch vers la page de détails de l'équipe
	    RequestDispatcher dispatcher = request.getRequestDispatcher("joueur/updatejoueur.jsp");
	    dispatcher.forward(request, response);
	    //response.sendRedirect("pwa_Application/Admin/Equipe/modifierEquipe.jsp");
	}


	
	private void AjouterJoueur(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		
		
				
		        String nom = request.getParameter("nom");
		        String prenom = request.getParameter("prenom");
		        int age = Integer.parseInt(request.getParameter("age"));
		        int anneeDeNaissance =  Integer.parseInt(request.getParameter("anneeDeNaissance"));
		        String nationalite = request.getParameter("nationalite");
		        String poste = request.getParameter("poste");
				int numeroDeMaillot = Integer.parseInt(request.getParameter("numeroDeMaillot"));
				
				long equipeId = Integer.parseInt(request.getParameter("equipeId"));
				
				
		        Equipe equipe = EquipeDao.findById(equipeId);
		       
		        
		        Joueur newJoueur = new Joueur( nom,  prenom,  age,  anneeDeNaissance, 
		                   nationalite,  poste,  numeroDeMaillot,  equipe);
		        
		        
		        System.out.println("newJoueur :" + newJoueur.getNom());
		        JoueurDao.create(newJoueur);
		        response.sendRedirect("listJoueur");
		    }
	
	private void DeleteJoueur(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		
		        long joueurId =Integer.parseInt(request.getParameter("joueurId"));
		        JoueurDao.delete(joueurId);
		        response.sendRedirect("listJoueur");

		    }
	

		    
	private void updateJoueur(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		long joueurId = Integer.parseInt(request.getParameter("joueurId"));
		  String nom = request.getParameter("nom");
	        String prenom = request.getParameter("prenom");
	        int age = Integer.parseInt(request.getParameter("age"));
	        int anneeDeNaissance =  Integer.parseInt(request.getParameter("anneeDeNaissance"));
	        String nationalite = request.getParameter("nationalite");
	        String poste = request.getParameter("poste");
			int numeroDeMaillot = Integer.parseInt(request.getParameter("numeroDeMaillot"));
			

		
		
	 	
	 	long equipeId = Integer.parseInt(request.getParameter("equipeId"));
	 	
	 	Equipe equipe = EquipeDao.findById(equipeId);
	 	
	 	Joueur newJoueur = new Joueur(nom,  prenom,  age,  anneeDeNaissance, 
                nationalite,  poste,  numeroDeMaillot,  equipe);   
	 	newJoueur.setId(joueurId);
       

        JoueurDao.update(newJoueur);
        response.sendRedirect("listJoueur");
	}
		
		 	
	
}
	
	


