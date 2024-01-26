<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Mettre à jour le Lieu d'Accueil</title>
</head>
<body>
    <h1>Mettre à jour le Lieu d'Accueil</h1>
    <form action="/matchs-infos/updateLieu" method="post">
        <input type="hidden" name="lieuId" value="${lieuAccueil.id}" />

        <fieldset class="form-group">
            <label>Type</label> 
            <input type="text" class="form-control" name="type" value="${lieuAccueil.type}" required="required">
        </fieldset>

        <fieldset class="form-group">
            <label>Nom</label> 
            <input type="text" class="form-control" name="nom" value="${lieuAccueil.nom}" required="required">
        </fieldset>

        <fieldset class="form-group">
            <label>Adresse</label> 
            <input type="text" class="form-control" name="adresse" value="${lieuAccueil.adresse}" required="required">
        </fieldset>

        <fieldset class="form-group">
            <label>Téléphone</label> 
            <input type="text" class="form-control" name="telephone" value="${lieuAccueil.telephone}">
        </fieldset>

        <fieldset class="form-group">
            <label>Courriel</label> 
            <input type="email" class="form-control" name="courriel" value="${lieuAccueil.courriel}">
        </fieldset>

        <fieldset class="form-group">
            <label>Site Internet</label> 
            <input type="url" class="form-control" name="siteInternet" value="${lieuAccueil.siteInternet}">
        </fieldset>

        <fieldset class="form-group">
            <label>Informations pour les personnes à mobilité réduite (PMR)</label> 
            <input type="text" class="form-control" name="infosPMR" value="${lieuAccueil.infosPMR}">
        </fieldset>

        <fieldset class="form-group">
            <label>Capacité</label> 
            <input type="number" class="form-control" name="capacite" value="${lieuAccueil.capacite}" min="0">
        </fieldset>

        <fieldset class="form-group">
            <label>Commentaires</label> 
            <textarea class="form-control" name="commentaires">${lieuAccueil.commentaires}</textarea>
        </fieldset>

        <button type="submit" class="btn btn-success">Mettre à jour</button>
    </form>
</body>
</html>
