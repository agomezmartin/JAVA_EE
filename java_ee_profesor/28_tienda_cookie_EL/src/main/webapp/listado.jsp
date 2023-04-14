<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,model.Producto"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%-- 
<%List<Producto> productos=(List<Producto>)request.getAttribute("productos");
String usuario=(String)session.getAttribute("usuario");%>
<p align="right">
<%if(usuario!=null){ %>
	Hola <%=usuario %>
	<%}else{%>
		<jsp:forward page="timeout.html"/>
	<%} %>
</p>
--%>
<p align="right">
<c:choose>
	<c:when test="${!empty sessionScope.usuario}">
		Hola ${sessionScope.usuario}
	</c:when>
	<c:otherwise>
		<jsp:forward page="timeout.html"/>
	</c:otherwise>
</c:choose>
</p>
<center>

<table border='1'><tr><th>Nombre</th><th>Precio</th><th>Stock</th></tr>
<c:forEach var="p" items="${requestScope.productos}">
	<tr>
		<td>${p.nombre}</td>
		<td>${p.precio}</td>
		<td>${p.stock}</td>
	</tr>

</c:forEach>
<%-- 
<%for(Producto p:productos){ %>
	<tr>
		<td><%=p.getNombre() %></td>
		<td><%=p.getPrecio() %></td>
		<td><%=p.getStock() %></td>
	</tr>

<%} %>
--%>
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