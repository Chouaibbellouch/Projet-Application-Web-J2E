<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List" %>
<%@ page import="entites.Joueur" %>
<html>
<head>
    <title>Liste des Joueurs</title>
</head>
<body>
    <div>
        <a href="<%=request.getContextPath()%>/afficherFormulaireAjoutJoueur" class="btn btn-success">Ajouter un joueur</a>
    </div>
    <h1>Liste des Joueurs</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Age</th>
            <th>Année de Naissance</th>
            <th>Nationalité</th>
            <th>Poste</th>
            <th>Numéro de Maillot</th>
            <th>Équipe</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${joueurs}" var="joueur">
            <tr>
                <td>${joueur.id}</td>
                <td>${joueur.nom}</td>
                <td>${joueur.prenom}</td>
                <td>${joueur.age}</td>
                <td>${joueur.anneeDeNaissance}</td>
                <td>${joueur.nationalite}</td>
                <td>${joueur.poste}</td>
                <td>${joueur.numeroDeMaillot}</td>
                <td>${joueur.equipe.nom}</td>
                <td>
                    <form action="/matchs-infos/getJoueur" method="post" style="display: inline;">
                        <input type="hidden" name="joueurId" value="${joueur.id}" />
                        <button type="submit" class="btn btn-primary btn-sm">Update</button>
                    </form>
                    <form action="/matchs-infos/deleteJoueur" method="post" style="display: inline;">
                        <input type="hidden" name="joueurId" value="${joueur.id}" />
                        <button type="submit" class="btn btn-danger btn-sm">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
