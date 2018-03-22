<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<form method ="post" action="GererNouveauClient">
Inscription :
<br>
Nom :<input type="text" name="nom" required/>
<br>
Prenom :<input type="text" name="prenom" required/>
<br>
Téléphone :<input type="text" name="telephone" required/>
<br>
Adresse :<input type="text" name="adresse" required/>
<br>
<input type="submit" name="Inscription" value="Inscription" required/>

</body>
</html>