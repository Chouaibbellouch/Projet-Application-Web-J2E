<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List" %>
<%@ page import="entites.Joueur" %>
<%@ page import="entites.Equipe" %>
<html>
<head>
    <title>Mettre à jour un joueur</title>
</head>
<body>
    <h1>Mettre à jour un joueur</h1>
    <form action="/matchs-infos/updateJoueur" method="post">
        <input type="hidden" name="joueurId" value="${joueur.id}" />

        <fieldset class="form-group">
            <label>Nom</label> 
            <input type="text" class="form-control" name="nom" value="${joueur.nom}" required="required">
        </fieldset>

        <fieldset class="form-group">
            <label>Prénom</label> 
            <input type="text" class="form-control" name="prenom" value="${joueur.prenom}" required="required">
        </fieldset>

        <fieldset class="form-group">
            <label>Age</label> 
            <input type="number" class="form-control" name="age" value="${joueur.age}">
        </fieldset>

        <fieldset class="form-group">
            <label>Année de Naissance</label> 
            <input type="number" class="form-control" name="anneeDeNaissance" value="${joueur.anneeDeNaissance}">
        </fieldset>

        <fieldset class="form-group">
            <label>Nationalité</label> 
            <input type="text" class="form-control" name="nationalite" value="${joueur.nationalite}">
        </fieldset>

        <fieldset class="form-group">
            <label>Poste</label> 
            <input type="text" class="form-control" name="poste" value="${joueur.poste}">
        </fieldset>

        <fieldset class="form-group">
            <label>Numéro de Maillot</label> 
            <input type="number" class="form-control" name="numeroDeMaillot" value="${joueur.numeroDeMaillot}">
        </fieldset>

        <fieldset class="form-group">
            <label for="equipe">Équipe</label>
            <select name="equipeId" class="form-control">
                <c:forEach items="${listEquipes}" var="equipe">
                    <option value="${equipe.id}" ${equipe.id == joueur.equipe.id ? 'selected' : ''}>${equipe.nom}</option>
                </c:forEach>
            </select>
        </fieldset>

        <button type="submit" class="btn btn-success">Mettre à jour</button>
    </form>
</body>
</html>
