package servlet;

import dao.EquipeDao;
import dao.LieuxAccueilDao;
import entites.Equipe;
import entites.LieuxAccueil;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/equipe")
public class EquipeServlet extends HttpServlet {
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
    public EquipeServlet() {
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
            	case "/addEquipe":
            		AjouterEquipe(request, response);
            		break;
            	case "/afficherFormulaireAjoutEquipe":
            		afficherFormulaireAjoutEquipe(request, response);
                	break;
                case "/deleteEquipe":
                	DeleteEquipe(request, response);
                    break;
                case "/updateEquipe":
                	updateEquipe(request, response);
                    break;
                case "/getEquipe":
                	getEquipe(request, response);
                    break;
                
                default:
                	list_Equipe(request, response);
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
	
	
	private void afficherFormulaireAjoutEquipe(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    List<LieuxAccueil> listLieux = LieuxAccueilDao.findAll();
	    request.setAttribute("listLieux", listLieux);

	    RequestDispatcher dispatcher = request.getRequestDispatcher("equipe/insertequipe.jsp");
	    dispatcher.forward(request,response);
	}
	
	private void list_Equipe(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List<Equipe> listEquipes = EquipeDao.findAll();
		        request.setAttribute("equipes", listEquipes);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("equipe/listeEquipes.jsp");
		        dispatcher.forward(request, response);
		    }
	
	private void getEquipe(HttpServletRequest request, HttpServletResponse response)
	        throws SQLException, IOException, ServletException {
	    
	    // Récupérer l'ID d'équipe à partir des paramètres de requête
	    long equipeId = Integer.parseInt(request.getParameter("equipeId"));
	    List<LieuxAccueil> listlieuAccueil = LieuxAccueilDao.findAll();

	    // Appeler la méthode pour obtenir l'équipe par ID
	    Equipe equipe = EquipeDao.findById(equipeId);

	    // Mettre l'équipe dans la portée de la requête
	    request.setAttribute("equipe", equipe);
	    request.setAttribute("listLieux", listlieuAccueil);
	    // Dispatch vers la page de détails de l'équipe
	    RequestDispatcher dispatcher = request.getRequestDispatcher("equipe/updateequipe.jsp");
	    dispatcher.forward(request, response);
	    //response.sendRedirect("pwa_Application/Admin/Equipe/modifierEquipe.jsp");
	}


	
	private void AjouterEquipe(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		
				
		        String nomEquipe = request.getParameter("nomEquipe");
				long lieuAccueilId = Integer.parseInt(request.getParameter("lieuAccueil"));
		        LieuxAccueil lieuAccueil = LieuxAccueilDao.findById(lieuAccueilId);
		       
		        System.out.println("newequipe :" + lieuAccueilId);
		        Equipe newEquipe = new Equipe(nomEquipe);
		        newEquipe.setLieuxAccueil(lieuAccueil);
		        System.out.println("newequipe :" + newEquipe.getLieuxAccueil().getNom());
		        EquipeDao.create(newEquipe);
		        response.sendRedirect("listEquipe");
		    }
	
	private void DeleteEquipe(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		
		        long equipeId =Integer.parseInt(request.getParameter("equipeId"));
		        EquipeDao.delete(equipeId);
		        response.sendRedirect("listEquipe");

		    }
	

		    
	private void updateEquipe(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		long equipeId = Integer.parseInt(request.getParameter("equipeId"));
	 	String nomEquipe = request.getParameter("nomEquipe");
	 	long lieuAccueilId = Integer.parseInt(request.getParameter("lieuAccueil"));
	 	LieuxAccueil lieuAccueil = LieuxAccueilDao.findById(lieuAccueilId);
	 	Equipe newEquipe = new Equipe(nomEquipe);   
	 	newEquipe.setLieuxAccueil(lieuAccueil);
	 	newEquipe.setId(equipeId);
       

        EquipeDao.update(newEquipe);
        response.sendRedirect("listEquipe");
	}
		
		 	
	
}
	
	


