<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- 
	<%String seccion=request.getParameter("seccion"); %>
	<h1>La secci�n <%=seccion %> no tiene productos</h1>
	--%>
	<h1>La secci�n ${param.seccion} no tiene productos</h1>
	<a href="datos.html">Volver</a>
</body>
</html>