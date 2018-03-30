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
	<title>Dashboard</title>
	<link rel="stylesheet" href='<c:url value="/css/bootstrap.min.css"/>'>
	<link rel="stylesheet" href='<c:url value="/css/style.css"/>'>
</head>
<body>
	<c:import url="/inc/header.jsp" />
	<c:import url="/inc/navbar.jsp" />
	<div class="container">
		<div class="col-xl-1">
			<h1>Rechercher un taxi : </h1>
			<form method="post" action="RechercherTaxi">
				<fieldset class="form-group">
					<div class="form-group">
	    				<label for="ville">Ville :</label>
	    				<%java.util.ArrayList<String> villes = fr.eseo.jee.bdd.GestionTable.getVille();%>
						<select name="ville" id="ville">
						<option value=null>Indifférent</option>
						<%for(int i=0;i<villes.size();i++) {%>
							<option><%=villes.get(i)%></option>
						<%}%>
						</select>
	  				</div>
	  				<div class="form-group">
	  					<label for="date">Date de réservation : </label>
  						<input class="form-control" value="JJ-MM-AAAA" type="text" name ="date" id="date" aria-describedby="date" placeholder="19-01-2018" >
  					</div>
  					<div class="form-group">
	  					<label for="time">Heure de réservation : </label>
  						<input class="form-control" value="HH:MM:SS" type="text" name ="time" id="time" aria-describedby="time" placeholder="13:45" >
  					</div>
	  				<div class="form-group">
	    				<label for="categorie">Catégorie de taxi : </label>
	    				<%java.util.ArrayList<String> categories = fr.eseo.jee.bdd.GestionTable.getCategories();%>
						<select name="categorie" id="categorie">
						<option value=null>Indifférent</option>
						<%for(int i=0;i<categories.size();i++) {%>
							<option><%=categories.get(i)%></option>
						<%}%>
						</select>
	    			</div>
	    			<div class="form-group">
	    				<label for="tarif">Tarif de base inférieur à : </label>
	    				<%java.util.ArrayList<Float> tarifs = fr.eseo.jee.bdd.GestionTable.getTarifs();%>
						<select name="tarif" id="tarif">
						<option value=null>Indifférent</option>
						<%for(int i=0;i<tarifs.size();i++) {%>
							<option><%=tarifs.get(i)%></option>
						<%}%>
						</select>
	    			</div>
  				</fieldset>
				<button type="submit" class="btn btn-warning">Rechercher</button>
 			</form>
 		</div>
 	<div class="row">
		<!-- Section Gerer les réservations -->
		<h1>Gérer vos réservations : </h1>
		<table class="table">
  			<thead>
    			<tr>
			      <th scope="col">Numéro de réservation</th>
			      <th scope="col">Date</th>
			      
			      <th scope="col">Destination</th>
			      <th scope="col">Paiement</th>
			      <th scope="col">Payer</th>
			      <th scope="col">Annuler</th>
    			</tr>
  			</thead>
  			<tbody>
    			<tr>
				 <% ArrayList<ReservationTaxi> listreservations = (ArrayList<ReservationTaxi>)(session.getAttribute("listReservations"));%>
				<% for(int i=0;i<listreservations.size();i++){%>
				       <td><%=listreservations.get(i).getIdReservation()%></td>
				       <td><%=listreservations.get(i).getDateReservation()%></td>
				       
				       <td><%=listreservations.get(i).getDestination()%></td>
				       <% if(listreservations.get(i).isPaiementEffectue()==true){%>
				       <td>Validé</td>
				       <%}%>
				       <% if(listreservations.get(i).isPaiementEffectue()==false){%>
				       <td>En attente</td>
				       <%}%>
				       <td><form method="post" action="PayerReservation">
							<input type=hidden name=idReservation id=idReservation value=<%=listreservations.get(i).getIdReservation()%>>
							<input type=hidden name=dateReservation id=dateReservation value=<%=listreservations.get(i).getDateReservation()%>>
							
							<input type=hidden name=destination id=destination value=<%=listreservations.get(i).getDestination()%>>
							<input type=hidden name=paiement id=paiement value=<%=listreservations.get(i).isPaiementEffectue()%>>
				       		<input type="submit" class="btn btn-warning" value="Payer"> 
				       </form></td>
     				   <td><form method="post" action="AnnulerReservation">
							<input type=hidden name=idReservation id=idReservation value=<%=listreservations.get(i).getIdReservation()%>>
							<input type=hidden name=dateReservation id=dateReservation value=<%=listreservations.get(i).getDateReservation()%>>
							<input type=hidden name=destination id=destination value=<%=listreservations.get(i).getDestination()%>>
							<input type=hidden name=paiement id=paiement value=<%=listreservations.get(i).isPaiementEffectue()%>>
				       		<input type="submit" class="btn btn-warning" value="Annuler"> 
				       </form></td>
    			</tr>
    			<%}%>
		  </tbody>
		</table>
	</div>
</div>	
</body>
</html>