<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.ArrayList"%>
<%@page import="fr.eseo.jee.beans.Client"%>

<html>
<head>
	<link rel="stylesheet" href="Style.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bienvenue sur Gestion Taxi !</title>
	<link rel="stylesheet" href='<c:url value="/css/bootstrap.min.css"/>'>
	<link rel="stylesheet" href='<c:url value="/css/style.css"/>'>
</head>
<body>
	<c:import url="/inc/header.jsp" />
	<c:import url="/inc/navbar.jsp" />
	<div class="container">
		<div class="col-xl-1">
			<form method="post" action="Formulaire">
				<fieldset class="form-group">
    				<legend>Êtes-vous client ?</legend>
    				<div class="form-check">
      					<label class="form-check-label">Oui
        					<input type="radio" class="form-check-input"  name="choix" id="choix" value="Oui" checked>
      					</label>
    				</div>
    				<div class="form-check">
    					<label class="form-check-label">Non
        					<input type="radio" class="form-check-input" name="choix" id="choix" value="Non">
      					</label>
    				</div>
  				</fieldset>
  				<button type="submit" class="btn btn-warning">Valider</button>
 			</form>
 		</div>
 	</div>
</body>
</html>