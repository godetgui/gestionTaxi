<%@page import="java.util.ArrayList"%>
<%@page import="fr.eseo.jee.beans.Client"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="Style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Votre commande :</title>
</head>
<body>

Etes vous client ?
<form method="post" action="Formulaire">
<input type="radio" name="choix" value="Oui"/>Oui
<input type="radio" name="choix" value="Non"/>Non
<br>
<button name="button">Envoyer</button>

 </form>
</body>
</html>