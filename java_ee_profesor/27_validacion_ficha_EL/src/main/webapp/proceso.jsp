<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="model.Ficha"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%--<%Ficha ficha=(Ficha)request.getAttribute("ficha"); 
	<h1>Usuario:<%=ficha.getUsuario() %></h1>
	<h1>Email: <%=ficha.getEmail() %></h1>
	<h1>Edad: <%=ficha.getEdad() %></h1>
	--%>
	<h1>Usuario:${requestScope.ficha.usuario}</h1>
	<h1>Email: ${requestScope.ficha.email}</h1>
	<h1>Edad: ${requestScope.ficha.edad}</h1>
	
	<br>
	<a href="login.html">Volver</a>
</body>
</html>