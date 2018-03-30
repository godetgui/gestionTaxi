<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.ArrayList"%>
<%@page import="fr.eseo.jee.beans.Client"%>
<%@page import="fr.eseo.jee.beans.ReservationTaxi"%>
<html>
<head>
	<link rel="stylesheet" href="Style.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Paiement</title>
	<link rel="stylesheet" href='<c:url value="/css/bootstrap.min.css"/>'>
	<link rel="stylesheet" href='<c:url value="/css/style.css"/>'>
</head>
<body>
	<c:import url="/inc/header.jsp" />
	<c:import url="/inc/navbar.jsp" />
	<div class="container">
		<div class="col-xl-1">
			<h1>Votre commande a bien été enregistrée !</h1>
			<form method="post" action="GererDejaClient">
				<fieldset class="form-group">
					<div class="form-group">
					<input type="submit" class="btn btn-warning" value="Retour accueil">
					<input type="hidden" name="idClient" id="idClient" value=<%=session.getAttribute("idClient")%>>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>