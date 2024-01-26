<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List" %>
<%@ page import="entites.Equipe" %>
<%@ page import="entites.LieuxAccueil" %>
<html>
<head>
    <title>Mettre à jour une équipe</title>
</head>
<body>
    <h1>Mettre à jour une équipe</h1>
    <form action="/matchs-infos/updateEquipe" method="post">
        <input type="hidden" name="equipeId" value="${equipe.id}" />

        <fieldset class="form-group">
            <label>Nom de l'équipe</label> 
            <input type="text" class="form-control" name="nomEquipe" value="${equipe.nom}" required="required">
        </fieldset>

        <fieldset class="form-group">
            <label for="lieuAccueil">Lieu d'accueil</label>
            <select name="lieuAccueil" class="form-control" required="required">
                <c:forEach items="${listLieux}" var="lieu">
                    <option value="${lieu.id}" ${lieu.id == equipe.lieuxAccueil.id ? 'selected' : ''}>${lieu.nom}</option>
                </c:forEach>
            </select>
        </fieldset>

        <button type="submit" class="btn btn-success">Mettre à jour</button>
    </form>
</body>
</html>
