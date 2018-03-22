<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">
<title>Bienvenue sur Gestion Taxi !</title>
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
		<option>janvier</option>
		<option>février</option>
		<option>mars</option>
		<option>avril</option>
		<option>mai</option>
		<option>juin</option>
		<option>juillet</option>
		<option>août</option>
		<option>septembre</option>
		<option>octobre</option>
		<option>novembre</option>
		<option>decembre</option>
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
	</br>
	</br>
	<label>Catégorie</label>
		<select name="categorie" id="categorie">
<<<<<<< HEAD
		<option>Touktouk 
		<option>Citadine 
		<option>Minibus 
		<option>Limousine 
=======
			<option>Touktouk</option>
			<option>Citadine</option>
			<option>Minibus</option>
			<option>Limousine</option>
>>>>>>> branch 'master' of https://github.com/godetgui/gestionTaxi.git
		</select></br></br>
	<button type="submit" value="reserverMaintenant">Rechercher les taxis disponibles</button>
	
	</form>

</body>
</html>