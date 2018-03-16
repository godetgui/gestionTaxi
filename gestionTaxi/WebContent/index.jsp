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
	<label>Date: </label><input type=date name=date id=date/>
	<label>Catégorie</label>
		<select name=categorie id=categorie>
		<option>Touktouk (2 places)
		<option>Citadine (4 places)
		<option>Van (8 places)
		<option>Limousine (8 places)
		</select></br></br>
	<button type=submit value=reserverMaintenant>Réserver maintenant</button>
	
	</form>
	
	
	
	
	
	
	
	
</body>
</html>