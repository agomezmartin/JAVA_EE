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
	<h1>La combinación usuario: <%=usuario %> con contraseña <%=pwd %> no es correcta</h1>
	<a href="login.html">volver</a>
</body>
</html>