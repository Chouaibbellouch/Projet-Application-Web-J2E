<%@ page import="entites.Equipe" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des Équipes</title>
    <!-- Ajoutez ici vos liens CSS ou JS si nécessaire -->
</head>
<body>
    <h1>Liste des Équipes</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Actions</th>
        </tr>
        <%-- Boucle pour afficher les équipes --%>
        <% for (Equipe equipe : (List<Equipe>)request.getAttribute("equipes")) { %>
            <tr>
                <td><%= equipe.getId() %></td>
                <td><%= equipe.getNom() %></td>
                <td><a href="equipes/detail?id=<%= equipe.getId() %>">Voir détails</a></td>
            </tr>
        <% } %>
    </table>
</body>
</html>
