package servlet;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;

import entites.Equipe;
import service.EquipeService;

import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EquipeServlet", urlPatterns = {"/equipes"})
public class EquipeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private EquipeService equipeService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            // Récupérer la liste des équipes depuis la base de données via le service
            List<Equipe> listeDesEquipes = equipeService.findAllEquipes();
            
            // Stocker la liste des équipes dans l'attribut de requête pour la vue JSP
            request.setAttribute("equipes", listeDesEquipes);
            
            // Transférer la requête à la vue JSP (qui doit être placée dans le dossier WEB-INF)
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/equipes/list.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

}
