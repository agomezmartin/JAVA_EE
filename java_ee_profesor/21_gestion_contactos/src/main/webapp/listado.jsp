<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,model.Contacto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% List<Contacto> lista = (List<Contacto>) request.getAttribute("contactos"); %>

<center>
	<h1>Listado de contactos</h1>
	<table border="1">
		<tr>
		<th>Id</th>
		<th>Nombre</th>
		<th>Email</th>
		<th>Edad</th>
		</tr>
	<% for(Contacto contacto: lista) { %>
		<tr>
			<td><%= contacto.getIdContacto() %></td>
			<td><%= contacto.getNombre() %></td>
			<td><%= contacto.getEmail() %></td>
			<td><%= contacto.getEdad() %></td>
		</tr>
	<%} %>
	</table>
	
	<h2><a href="menu.html">Volver a menú</a></h2>
	
</center>

</body>
</html>