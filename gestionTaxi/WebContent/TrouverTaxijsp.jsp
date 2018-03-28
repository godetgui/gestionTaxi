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
	<title>Dashboard</title>
	<link rel="stylesheet" href='<c:url value="/css/bootstrap.min.css"/>'>
	<link rel="stylesheet" href='<c:url value="/css/style.css"/>'>
</head>
<body>
	<c:import url="/inc/header.jsp" />
	<c:import url="/inc/navbar.jsp" />
	<div class="container">
		<div class="col-xl-1">
			<div class='row'>
			<h1>Résultat de la recherche :  </h1>
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
    			<% ArrayList<Taxi> taxis = (ArrayList<Taxi>)(session.getAttribute("taxis"));%>
				<% for(int i=0;i<taxis.size();i++){%>
					<td><%=taxis.get(i).getIdTaxi()%></td>
					<td><%=taxis.get(i).getVille()%></td>
					<td><%=taxis.get(i).getCategorie()%></td>
					<td><%=taxis.get(i).getTarifDeBase()%></td>
					<td><form method="post" action="ReserverTaxi">
							<input type=hidden name=date value=<%=session.getAttribute("date") %>>
							<input type=hidden name=time value=<%=session.getAttribute("time") %>>
							<input type=hidden name=ville value=<%=session.getAttribute("ville") %>>
							<input type=hidden name=idClient value=<%=session.getAttribute("idClient") %>>
							<input type=hidden name=idTaxi value=<%=taxis.get(i).getIdTaxi()%>>
							<input type="submit" value="Reserver">
						</form></td>
				</tr>
				<%}%>
		  </tbody>
		</table>
		</div>
	</div>
</div>
</body>
</html>