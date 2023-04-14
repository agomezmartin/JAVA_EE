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
	<h1>Listado de contactos</h1>
	<table border="1">
		<tr>
		<th></th>
		<th>Id</th>
		<th>Nombre</th>
		<th>Email</th>
		<th>Edad</th>
		</tr>
	<c:forEach var="contacto" items="${requestScope.contactos}">
		<tr>
			<td><a href="eliminarid?idContacto=${contacto.idContacto}">Eliminar</a></td>
			<td>${contacto.idContacto}</td>
			<td>${contacto.nombre}</td>
			<td>${contacto.email}</td>
			<td>${contacto.edad}</td>
		</tr>
	</c:forEach>
	</table>
	
	<h2><a href="toMenu">Volver a menú</a></h2>
	
</center>

</body>
</html>