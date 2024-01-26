<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List" %>
<%@ page import="entites.LieuxAccueil" %>
<html>
<head>
    <title>Liste des Lieux d'Accueil</title>
</head>
<body>
    <div>
        <a href="<%=request.getContextPath()%>/lieu/insertlieu.jsp" class="btn btn-success"
           style="margin-bottom: 10px;">Ajouter un Lieu d'Accueil</a>
    </div>
    <h1>Liste des Lieux d'Accueil</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Type</th>
            <th>Nom</th>
            <th>Adresse</th>
            <th>Téléphone</th>
            <th>Courriel</th>
            <th>Site Internet</th>
            <th>Infos PMR</th>
            <th>Capacité</th>
            <th>Commentaires</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${lieuxAccueils}" var="lieu">
            <tr>
                <td>${lieu.id}</td>
                <td>${lieu.type}</td>
                <td>${lieu.nom}</td>
                <td>${lieu.adresse}</td>
                <td>${lieu.telephone}</td>
                <td>${lieu.courriel}</td>
                <td>${lieu.siteInternet}</td>
                <td>${lieu.infosPMR}</td>
                <td>${lieu.capacite}</td>
                <td>${lieu.commentaires}</td>
                <td>
                    <form action="/matchs-infos/getLieu" method="post" style="display: inline;">
                        <input type="hidden" name="lieuAccueilId" value="${lieu.id}" />
                        <button type="submit" class="btn btn-primary btn-sm">Update</button>
                    </form>
                    <form action="/matchs-infos/deleteLieu" method="post" style="display: inline;">
                        <input type="hidden" name="lieuAccueilId" value="${lieu.id}" />
                        <button type="submit" class="btn btn-danger btn-sm">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
