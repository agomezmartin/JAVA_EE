<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="p" items="${requestScope.resultado}">
	<h2><a href="${p.direccion}">${p.direccion}</a></h2>
	<h4>${p.descripcion}</h4>
</c:forEach>

<br><br>
<a href="toInicio">Volver</a>
</body>
</html>