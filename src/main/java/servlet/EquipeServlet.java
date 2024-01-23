package servlet;

import entites.Equipe;
import service.EquipeService;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EquipeServlet", urlPatterns = {"/equipes/*"})
public class EquipeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    @EJB
    private EquipeService equipeService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();

        if (pathInfo == null || pathInfo.equals("/")) {
            // Afficher la liste des équipes
            request.setAttribute("equipes", equipeService.findAllEquipes());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/equipes/list.jsp");
            dispatcher.forward(request, response);
        } else {
            // Afficher les détails d'une équipe spécifique
            Long id = Long.parseLong(pathInfo.substring(1));
            Equipe equipe = equipeService.findEquipe(id);
            request.setAttribute("equipe", equipe);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/equipes/detail.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Ajouter une nouvelle équipe
        String nom = request.getParameter("nom");
        Equipe equipe = new Equipe();
        equipe.setNom(nom);
        equipeService.saveEquipe(equipe);
        response.sendRedirect(request.getContextPath() + "/equipes");
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Mettre à jour une équipe
        Long id = Long.parseLong(request.getParameter("id"));
        String nom = request.getParameter("nom");

        Equipe equipe = equipeService.findEquipe(id);
        if (equipe != null) {
            equipe.setNom(nom);
            equipeService.saveEquipe(equipe);
            response.sendRedirect(request.getContextPath() + "/equipes");
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Supprimer une équipe
        Long id = Long.parseLong(request.getParameter("id"));
        equipeService.deleteEquipe(id);
        response.sendRedirect(request.getContextPath() + "/equipes");
    }
}
