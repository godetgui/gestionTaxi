<%@page import="java.util.ArrayList"%>
<%@page import="fr.eseo.jee.beans.ReservationTaxi"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" href="Style.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bienvenue sur Gestion Taxi !</title>
	<link rel="stylesheet" href='<c:url value="/css/bootstrap.min.css"/>'>
	<link rel="stylesheet" href='<c:url value="/css/style.css"/>'>

</head>
<body>
	<h1>Commandez votre taxi !</h1>
	
	<form methode="post" action="RechercherTaxi">
	<label>Ville : </label>
	<%java.util.ArrayList<String> villes = fr.eseo.jee.bdd.GestionTable.getVille();%>
	<select name="ville">
	<%for(int i=0;i<villes.size();i++) {%>
		<option><%=villes.get(i)%></option>
	<%}%>
	</select>
	</br>
	</br>
	Date : <label> Année </label><select name="annee" id="annee">
		<% for(int annee=2018;annee<=2022;annee++){ %>
		<option><%=annee%></option>
		<% } %>
		</select>
	<label>Mois </label><select name="mois" id="mois">
		<option>01</option>
		<option>02</option>
		<option>03</option>
		<option>04</option>
		<option>05</option>
		<option>06</option>
		<option>07</option>
		<option>08</option>
		<option>09</option>
		<option>10</option>
		<option>11</option>
		<option>12</option>
		</select>
	<label>Jour </label><select name="jour" id="jour">
		<option>01
		<option>02
		<option>03
		<option>04
		<option>05
		<option>06
		<option>07
		<option>08
		<option>09
		<option>10
		<option>11
		<option>12
		<option>13
		<option>14
		<option>15
		<option>16
		<option>17
		<option>18
		<option>19
		<option>20
		<option>21
		<option>22
		<option>23
		<option>24
		<option>25
		<option>26
		<option>27
		<option>28
		<option>29
		<option>30
		<option>31
		</select>
		<label>hh </label><select name="heure" id="heure">
		<option>00
		<option>01
		<option>02
		<option>03
		<option>04
		<option>05
		<option>06
		<option>07
		<option>08
		<option>09
		<option>10
		<option>11
		<option>12
		<option>13
		<option>14
		<option>15
		<option>16
		<option>17
		<option>18
		<option>19
		<option>20
		<option>21
		<option>22
		<option>23
		</select>
		<label> mn </label><select name="minute" id="minute">
		<% for(int mn=0;mn<=59;mn++){ %>
		<option><%=mn%></option>
		<% } %>
		</select>
	</br>
	</br>
	<label>Catégorie</label>
		<select name="categorie" id="categorie">
		<option>Touktouk 
		<option>Citadine 
		<option>Minibus 
		<option>Limousine 
		</select></br></br>
	<button type="submit" value="reserverMaintenant">Rechercher les taxis disponibles</button>
	
	</form>
	<h1>Gerer vos réservations !</h1>
	<table>
   <tr>
       <td>Resa n°</td>
       <td>Date</td>
       <td>Ville</td>
       <td>Destination</td>
       <td>Payement</td> 
       <td>Payer</td> 
       <td>Annuler</td> 
            
   </tr>
  
	
<!-- 	< -->
 <tr>
 <% ArrayList<ReservationTaxi> listreservations = (ArrayList<ReservationTaxi>)(session.getAttribute("listReservations"));%>
<% for(int i=0;i<listreservations.size();i++){%>
       <td><%=listreservations.get(i).getIdReservation()%></td>
       <td><%=listreservations.get(i).getDateReservation()%></td>
       <td><%=listreservations.get(i).getDestination()%></td>
       <td><%=listreservations.get(i).isPaiementEffectue()%></td>
		<td ><input type="button" value="Payer"> <form methode="post" action="PayerReservation"></form></td>
		<td ><input type="button" value="Annuler"> <form methode="post" action="AnnulerReservation"></form></td>

 </tr>
 <%}%>

</table>
	
</body>
</html>