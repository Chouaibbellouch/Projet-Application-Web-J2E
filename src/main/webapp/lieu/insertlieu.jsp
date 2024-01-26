<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Ajouter un Lieu d'Accueil</title>
</head>
<body>
    <h1>Ajouter un Lieu d'Accueil</h1>
    <form action="/matchs-infos/addLieu" method="post">
        <fieldset class="form-group">
            <label>Type</label> 
            <input type="text" class="form-control" name="type" required="required">
        </fieldset>

        <fieldset class="form-group">
            <label>Nom</label> 
            <input type="text" class="form-control" name="nom" required="required">
        </fieldset>

        <fieldset class="form-group">
            <label>Adresse</label> 
            <input type="text" class="form-control" name="adresse" required="required">
        </fieldset>

        <fieldset class="form-group">
            <label>Téléphone</label> 
            <input type="text" class="form-control" name="telephone">
        </fieldset>

        <fieldset class="form-group">
            <label>Courriel</label> 
            <input type="email" class="form-control" name="courriel">
        </fieldset>

        <fieldset class="form-group">
            <label>Site Internet</label> 
            <input type="url" class="form-control" name="siteInternet">
        </fieldset>

        <fieldset class="form-group">
            <label>Informations pour les personnes à mobilité réduite (PMR)</label> 
            <input type="text" class="form-control" name="infosPMR">
        </fieldset>

        <fieldset class="form-group">
            <label>Capacité</label> 
            <input type="text" class="form-control" name="capacite" >
        </fieldset>

        <fieldset class="form-group">
            <label>Commentaires</label> 
            <textarea class="form-control" name="commentaires"></textarea>
        </fieldset>

        <button type="submit" class="btn btn-success">Enregistrer</button>
    </form>
</body>
</html>
