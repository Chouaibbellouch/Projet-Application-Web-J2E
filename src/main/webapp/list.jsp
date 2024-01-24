<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="java.util.List" %>
<%@ page import="entites.Equipe" %>

<!DOCTYPE html>
<html>
<head>
    <title>Liste des Équipes</title>
    <!-- Ajoutez ici vos liens CSS ou JS si nécessaire -->
</head>
<body>
<div align="center">
    <h1>Liste des Équipes</h1>
    <a href="${pageContext.request.contextPath}/equipes/new">Créer Nouvelle Équipe</a>
    <br/><br/>
    <table border="1">
        <thead>
            <tr>
                <th>ID Équipe</th>
                <th>Nom</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${equipes}" var="equipe">
                <tr>
                    <td>${equipe.id}</td>
                    <td>${equipe.nom}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/equipes/edit?id=${equipe.id}">Modifier</a>
                        &nbsp;&nbsp;&nbsp;
                        <a href="${pageContext.request.contextPath}/equipes/delete?id=${equipe.id}">Supprimer</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
