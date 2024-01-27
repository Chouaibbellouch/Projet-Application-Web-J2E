<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List" %>
<%@ page import="entites.Equipe" %>
<html>
<head>
    <title>Ajouter un Joueur</title>
</head>
<body>
    <h1>Ajouter un Joueur</h1>
    <form action="/matchs-infos/addJoueur" method="post">
        <fieldset class="form-group">
            <label>Nom</label> 
            <input type="text" class="form-control" name="nom" required="required">
        </fieldset>

        <fieldset class="form-group">
            <label>Prénom</label> 
            <input type="text" class="form-control" name="prenom" required="required">
        </fieldset>

        <fieldset class="form-group">
            <label>Âge</label> 
            <input type="number" class="form-control" name="age">
        </fieldset>

        <fieldset class="form-group">
            <label>Année de naissance</label> 
            <input type="number" class="form-control" name="anneeDeNaissance">
        </fieldset>

        <fieldset class="form-group">
            <label>Nationalité</label> 
            <input type="text" class="form-control" name="nationalite">
        </fieldset>

        <fieldset class="form-group">
            <label>Poste</label> 
            <input type="text" class="form-control" name="poste">
        </fieldset>

        <fieldset class="form-group">
            <label>Numéro de maillot</label> 
            <input type="number" class="form-control" name="numeroDeMaillot">
        </fieldset>

        <fieldset class="form-group">
            <label for="equipeId">Équipe</label>
            <select name="equipeId" class="form-control">
                <c:forEach items="${listEquipes}" var="equipe">
                    <option value="${equipe.id}">${equipe.nom}</option>
                </c:forEach>
            </select>
        </fieldset>

        <button type="submit" class="btn btn-success">Enregistrer</button>
    </form>
</body>
</html>
