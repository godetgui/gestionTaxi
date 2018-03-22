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
<form method="post" action="Reservation">
<% %>
<% ArrayList<Client> clients = (ArrayList<Client>)(session.getAttribute("clients"));%>
<% for(int i=0;i<clients.size();i++){%>
	Client n°<%=i%> : <%=clients.get(i).getNom()%> <%=clients.get(i).getPrenom()%>
<%}%>

</br>
</br>
</br>
</br>
<table>
   <tr>
       <td>Nom</td>
       <td>Prenom</td>
       <td>idClient</td>
       <td>Adresse</td>
       <td>Telephone</td>
   </tr>
   <tr>
 
   </tr>
</table>


Etes vous client ?

<input type="radio" id="radioButton" name="radioButton">Oui
<input type="radio" id="radioButton" name="radioButton">Non
<br>
<button name="button">Envoyer</button>

 </form>
</body>
</html>