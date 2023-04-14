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
	<c:choose>
		<c:when test="${!empty applicationScope.contador}">
			<h1>Total likes: ${applicationScope.contador}</h1>
		</c:when>
		<c:otherwise>
			<h1>No le gustas a nadie</h1>
		</c:otherwise>
	</c:choose>
	<br><br>
	<a href="inicio.html">Volver</a>
	
</body>
</html>