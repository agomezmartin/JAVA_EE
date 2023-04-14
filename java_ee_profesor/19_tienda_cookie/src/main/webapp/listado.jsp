<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,model.Producto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%List<Producto> productos=(List<Producto>)request.getAttribute("productos");
String usuario=(String)session.getAttribute("usuario");%>
<p align="right">
<%if(usuario!=null){ %>
	Hola <%=usuario %>
	<%}else{%>
		<jsp:forward page="timeout.html"/>
	<%} %>
</p>
<center>
<table border='1'><tr><th>Nombre</th><th>Precio</th><th>Stock</th></tr>
<%for(Producto p:productos){ %>
	<tr>
		<td><%=p.getNombre() %></td>
		<td><%=p.getPrecio() %></td>
		<td><%=p.getStock() %></td>
	</tr>

<%} %>
<%-- 
<%for(int i=0;i<productos.size();i++){ %>
	<tr>
		<td><%=productos.get(i).getNombre() %></td>
		<td><%=productos.get(i).getPrecio() %></td>
		<td><%=productos.get(i).getStock() %></td>
	</tr>

<%} %>
--%>
</table>
<a href="datos.html">Volver</a>

</center>
</body>
</html>