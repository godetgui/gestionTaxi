<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">
<title>Bienvenue sur Gestion Taxi !</title>
<link rel="stylesheet" href='<c:url value="/css/bootstrap.min.css"/>'>
<link rel="stylesheet" href='<c:url value="/css/style.css"/>'>
</head>
<body>
	<c:import url="/inc/header.jsp" />
	<c:import url="/inc/navbar.jsp" />
	<div class="container">
		<div class="col-xl-1">
			<form methode="post" action="RechercherTaxi">
  				<div class="form-group">
    				<label for="ville">Ville de départ</label>
    					<%java.util.ArrayList<String> villes = fr.eseo.jee.bdd.GestionTable.getVille();%>
						<select name="ville">
						<%for(int i=0;i<villes.size();i++) {%>
							<option><%=villes.get(i)%></option>
						<%}%>
						</select>
  				</div>
  				<div class="form-group">
    			<label for="date">Date et heure de départ</label>
    				<div class='input-group date' id='datetime'>
                    	<input type='text' class="form-control" />
                    	<span class="input-group-addon">
                        	<span class="glyphicon glyphicon-calendar"></span>
                    	</span>
                	</div>
    
  				</div>
  				<div class="form-group">
    				<label for="categorie">Categorie</label>
    					<select multiple class="form-control" id="listecategories">
      						<option>Touktouk</option>
      						<option>Citadine</option>
      						<option>Minibus</option>
      						<option>Limousine</option>
    					</select>
  				</div>
  		</form>
	</div>
	<script src="<c:url value="/js/jquery-3.2.0.min.js"/>"></script>
	<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/js/dragAndDrop.js"/>"></script>
</body>
</html>