<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<center>
<table border='1'><tr><th>Nombre</th><th>Precio</th><th>Stock</th></tr>
<c:forEach var="p" items="${requestScope.productos}">
	<tr>
		<td>${p.nombre }</td>
		<td>${p.precio }</td>
		<td>${p.stock }</td>
	</tr>

</c:forEach>

</table>
<a href="toInicio">Volver</a>

</center>
</body>
</html>