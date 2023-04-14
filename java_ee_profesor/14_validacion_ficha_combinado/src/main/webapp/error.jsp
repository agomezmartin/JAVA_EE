<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String usuario=request.getParameter("usuario");
String pwd=request.getParameter("pwd"); %>
<center>
	<h1>La combinación usuario <%=usuario %> y contraseña <%=pwd %> no es correcta</h1>
	<br>
	<a href="login.html">Volver</a>
</center>
</body>
</html>