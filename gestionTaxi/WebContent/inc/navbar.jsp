<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<style>
.navbar{
	overflow: hidden;
    background-color: #333;
    font-family: Arial, Helvetica, sans-serif;
    border-radius:0px;
}

#menu, #connexion{
	color:#ffc34d;
}

#menu:hover, #connexion:hover{
	color:black;
}


.navbar-brand, .navbar-brand:hover{
	color:white;
}


</style>
</head>
<body>
<nav class="navbar navbar-expand-sm">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/index.jsp">GestionTaxi</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a id="menu" href="/index.jsp">Réserver un taxi</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    	<%-- <c:choose> --%>
    		<%-- <c:when test="${empty sessionScope.client}"> --%>
					<li><a href="#" id="connexion"><span class="glyphicon glyphicon-log-in"></span> Se connecter</a></li>	
			<%-- </c:when> --%>
			<%-- <c:otherwise></c:otherwise> --%>
      <%-- </c:choose> --%>
    </ul>
  </div>
</nav>
</body>