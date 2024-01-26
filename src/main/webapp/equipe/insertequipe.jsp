<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List" %>
<%@ page import="entites.Equipe" %>
<html>
<head>
    <title>Liste des Équipes</title>
</head>
<body>
    <h1>Ajouter une équipe</h1>
    <form action="/matchs-infos/addEquipe" method="post">
    <fieldset class="form-group">
        <label>Nom de l'équipe</label> 
        <input type="text" class="form-control" name="nomEquipe" required="required">
    </fieldset>

    <fieldset class="form-group">
        <label for="lieuAccueil">Lieu d'accueil</label>
        <select name="lieuAccueil" class="form-control" required="required">
            <c:forEach items="${listLieux}" var="lieu">
                <option value="${lieu.id}">${lieu.nom}</option>
            </c:forEach>
        </select>
    </fieldset>

    <button type="submit" class="btn btn-success">Enregistrer</button>
</form>

</body>
</html>
