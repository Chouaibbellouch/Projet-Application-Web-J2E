<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List" %>
<%@ page import="entites.Equipe" %>
<html>
<head>
    <title>Liste des Équipes</title>
</head>
<body>
    <div>
        <a href="<%=request.getContextPath()%>/afficherFormulaireAjoutEquipe" class="btn btn-success"
           style="background-color: #b9885; border-color: #ff000096">Ajouter Equipes</a>
    </div>
    <h1>Liste des Équipes</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Lieu</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${equipes}" var="equipe">
            <tr>
                <td>${equipe.id}</td>
                <td>${equipe.nom}</td>
                <td>${equipe.lieuxAccueil.nom}</td>
                <td>
                    <form action="/matchs-infos/getEquipe" method="post" style="display: inline;">
                        <input type="hidden" name="equipeId" value="${equipe.id}" />
                        <button type="submit" class="btn btn-primary btn-sm">Update</button>
                    </form>
                    <form action="/matchs-infos/deleteEquipe" method="post" style="display: inline;">
                        <input type="hidden" name="equipeId" value="${equipe.id}" />
                        <button type="submit" class="btn btn-danger btn-sm">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
