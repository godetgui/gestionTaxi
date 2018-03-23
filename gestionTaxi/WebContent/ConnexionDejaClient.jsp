<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" href="Style.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Connexion</title>
	<link rel="stylesheet" href='<c:url value="/css/bootstrap.min.css"/>'>
	<link rel="stylesheet" href='<c:url value="/css/style.css"/>'>
</head>
<body>
	<c:import url="/inc/header.jsp" />
	<c:import url="/inc/navbar.jsp" />
		<div class="container">
			<div class="col-xl-1">
				<form method ="post" action="GererDejaClient">
					<fieldset class="form-group">
		    			<legend>Veuillez entrer vos informations:</legend>
						<div class="form-group">
		    				<label for="nom">Nom:</label>
		    				<input type="text" class="form-control" id="nom" name="nom" aria-describedby="votrenom" placeholder="Votre nom de famille" required>
		  				</div>
		  				<div class="form-group">
		    				<label for="prenom">Prénom:</label>
		    				<input type="text" class="form-control" id="prenom" name="prenom" aria-describedby="votreprenom" placeholder="Votre prénom" required>
		  				</div>
	  				</fieldset>
					<button type="submit" class="btn btn-warning">Connexion</button>
				</form>
			</div>
		</div>
</body>
</html>