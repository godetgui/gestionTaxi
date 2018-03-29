<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.ArrayList"%>
<%@page import="fr.eseo.jee.beans.Client"%>
<%@page import="fr.eseo.jee.beans.ReservationTaxi"%>
<%@page import="fr.eseo.jee.beans.Taxi"%>
<html>
<head>
<link rel="stylesheet" href="Style.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Inscription</title>
	<link rel="stylesheet" href='<c:url value="/css/bootstrap.min.css"/>'>
	<link rel="stylesheet" href='<c:url value="/css/style.css"/>'>
</head>

<body>
	<c:import url="/inc/header.jsp" />
	<c:import url="/inc/navbar.jsp" />
	<div class="container">
		<div class="col-xl-1">
			<h1>Confirmation Réservation </h1>
			<div class="row">
				<h3>Taxi concerné : </h3>
				<table class="table">
	  			<thead>
	    			<tr>
				      <th scope="col">Numéro de taxi</th>
				      <th scope="col">Ville de départ</th>
				      <th scope="col">Catégorie</th>
				      <th scope="col">Tarif de Base</th>
	    			</tr>
	  			</thead>
	  			<tbody>
	    			<tr>
						<% ArrayList<Taxi> taxiReservation = (ArrayList<Taxi>)(session.getAttribute("taxiReservation"));%>
						<% for(int i=0;i<taxiReservation.size();i++){%>
						<td><%=taxiReservation.get(i).getIdTaxi()%></td>
						<td><%=taxiReservation.get(i).getVille()%></td>
						<td><%=taxiReservation.get(i).getCategorie()%></td>
						<td><%=taxiReservation.get(i).getTarifDeBase()%></td>
					</tr>
					<%}%>
			  	</tbody>
				</table>
			
			</div>
			<div class="row">
			<h3>Veuillez confirmer ou modifier les informations suivantes :</h3>
			<form method ="post" action="ConfirmerReservation">
				<fieldset class="form-group">
					<div class="form-group">
	  					<label for="date">Date de réservation : </label>
  						<input class="form-control" value="JJ-MM-AAAA" type="text" name ="date" id="date" aria-describedby="date" placeholder="19-01-2018" >
  					</div>
  					<div class="form-group">
	  					<label for="time">Heure de réservation : </label>
  						<input class="form-control" value="HH:MM:SS" type="text" name ="time" id="time" aria-describedby="time" placeholder="13:45" >
  					</div>
	  				<div class="form-group">
	    				<label for="destination">Destination : </label>
	    				<input type="text" class="form-control" name="destination" id="destination" aria-describedby="votretdestination" placeholder="Votre destination" required>
	  				</div>
  				</fieldset>
				<button type="submit" class="btn btn-warning">Confirmer</button>
			</form>
			</div>
		</div>
	</div>
</body>
</html>