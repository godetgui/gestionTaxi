<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
header,.panel,.panel-body{
	background-color:black;
}
#titre{
	color:#ffc34d;
	position:relative;
    text-align:center;
}
#taxi{
	position:relative;
	left:200px
}
</style>
<header class="row">
	<div class="panel">
		<div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
				<img id="taxi" src="<c:url value="/images/taxi.png"/>" width=50% />
		</div>
		<div class="col-lg-6 col-md-6 col-sm-4 col-xs-2">
			<h1 id="titre"> Bienvenue sur GestionTaxi ! </h1>
		</div>
	</div>

</header>