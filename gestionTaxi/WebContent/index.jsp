<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">
<title>Bienvenue sur Gestion Taxi !</title>
</head>
<body>
	<h1>Commandez votre taxi</h1>
	
	<form methode=get action= FormulaireCommande >
	<label>Ville</label><input type=text name=ville id=ville/>
	Date:<label>Année</label><select name=date id=date>
		<option>2022
		<option>2021
		<option>2020
		<option>2019
		<option>2018
		</select>
	<label>Mois</label><select name=mois id=mois>
		<option>septembre
		<option>octobre
		<option>novembre
		<option>decembre
		<option>janvier
		<option>fevrier
		<option>avril
		<option>mai
		<option>juin
		<option>juillet
		<option>aout
		</select>
	<label>Mois</label><select name=mois id=mois>
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
	
	<label>Catégorie</label>
		<select name=categorie id=categorie>
		<option>Touktouk (2 places)
		<option>Citadine (4 places)
		<option>Mini Bus (8 places)
		<option>Limousine (8 places)
		</select></br></br>
	<button type=submit value=reserverMaintenant>Réserver maintenant</button>
	
	</form>
	
	
	
	
	
	
	
	
</body>
</html>