<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Producto,service.Carrito,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Carrito carrito = (Carrito) session.getAttribute("carrito"); 
if (carrito != null) {
	List<Producto> productos = (List<Producto>) carrito.getProductos();
%>
		<table border='1'>
			<tr>
			<th>Nombre</th>
			</tr>
	
	<% for(Producto p : productos ) { %>
		<tr>
			<td><%=p.getNombre() %></td>
		</tr>			
		
	<%} %>

		</table>
<% } else { %>

	<h1>El carrito está vacío</h1>
<%} %>	

	<a href='inicio.html'>Volver</a>
	<a href='Desconexion'>Desconexión</a>

</body>
</html>