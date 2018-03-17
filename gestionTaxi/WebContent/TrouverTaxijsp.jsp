<%@page import="java.util.ArrayList"%>
<%@page import="fr.eseo.jee.modele.Taxi"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Resultat de la recherche de taxis</title>
</head>
<body>
<% %>
<% ArrayList<Taxi> taxis = (ArrayList<Taxi>)(session.getAttribute("taxis"));%>
<label>Voici les taxis de catégorie <%=taxis.get(0).getCategorie()%> disponibles à <%=taxis.get(0).getVille()%> :</label></br></br>
<% for(int i=0;i<taxis.size();i++){%>
	Taxi n°<%=i%> : <%=taxis.get(i).getIdTaxi()%>
	<form method="post" action="">
		<input type="submit" value="Réserver" name="Réserver">"/><br/></br>
	</form>
<%}%>
</body>
</html>