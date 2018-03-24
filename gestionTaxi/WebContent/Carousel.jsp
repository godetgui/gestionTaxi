<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" href="Style.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bienvenue sur GestionTaxi !</title>
	<link rel="stylesheet" href='<c:url value="/css/bootstrap.min.css"/>'>
	<link rel="stylesheet" href='<c:url value="/css/style.css"/>'>
</head>
<body>
	<c:import url="/inc/header.jsp" />
	<c:import url="/inc/navbar.jsp" />
		<div class="container">
			<div class="col-xl-1">
				<div id="carousel" class="carousel slide" data-ride="carousel">
				  <ol class="carousel-indicators">
				    <li data-target="#carousel" data-slide-to="0" class="active"></li>
				    <li data-target="#carousel" data-slide-to="1"></li>
				    <li data-target="#carousel" data-slide-to="2"></li>
				  </ol>
				  <div class="carousel-inner">
				    <div class="carousel-item active">
				      <img class="d-block w-100" src="<c:url value="/images/bienvenue.png"/>" alt="First slide">
				      <div class="carousel-caption">
        				<h3><a href="">Réserver un taxi</a></h3>
     				  </div>
				    </div>
				    <div class="carousel-item">
				      <img class="d-block w-100" src="<c:url value="/images/angers.png"/>" alt="Second slide">
				      <div class="carousel-caption">
        				<h3><a href="">Nouvelle ville disponible : Angers !</a></h3>
     				  </div>
				    </div>
				    <div class="carousel-item">
				      <img class="d-block w-100" src="<c:url value="/images/tuktuk.png"/>" alt="Third slide">
				      <div class="carousel-caption">
        				<h3><a href="">Le tuk-tuk débarque à Paris !</a></h3>
     				  </div>
				    </div>
				  </div>
				  <a class="carousel-control-prev" href="#carousel" role="button" data-slide="prev">
				    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
				    <span class="sr-only">Précédent</span>
				  </a>
				  <a class="carousel-control-next" href="#carousel" role="button" data-slide="next">
				    <span class="carousel-control-next-icon" aria-hidden="true"></span>
				    <span class="sr-only">Suivant</span>
				  </a>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="<c:url value="/js/jquery-3.2.0.min.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/js/bootstrap.min.js"/>"></script>
</body>
</html>