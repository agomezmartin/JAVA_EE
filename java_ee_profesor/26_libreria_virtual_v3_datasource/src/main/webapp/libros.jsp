
<!DOCTYPE HTML><%@page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	
	%>
<%@page import="model.Libro,model.Cliente"%>
<%@page import="java.util.List"%>
<html>
<head>
<title>libros</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	
	<center>
		
		<br/><br/>
		
		 
		 <%List<Libro> libros=(List<Libro>)request.getAttribute("libros"); %>
				<table border="1">
				    <tr><th></th><th>Titulo</th><th>Autor</th><th>Precio</th></tr>		    	
				    	<%for(Libro lb:libros){ %>
				    		<tr>
				    			<td><a href="Controller?idTema=<%=request.getParameter("idTema")%>&option=doAgregar&isbn=<%=lb.getIsbn()%>">Añadir</a></td>
				    			<td><%=lb.getTitulo() %></td>
								<td><%=lb.getAutor() %></td>
								<td><%=lb.getPrecio() %></td>
								
							</tr>		    	
				    	<%} %>
				</table>
				
				<br/><br/>
				<%List<Libro> carrito=(List<Libro>)session.getAttribute("carrito");
				if(carrito!=null){%>
				<h1>Carrito</h1>
				<table border="1">
				    <tr><th></th><th>Titulo</th><th>Autor</th><th>Precio</th></tr>		    	
				    	<%for(int i=0;i<carrito.size();i++){ %>
				    		<tr>
				    			<td>
				    				<form action="Controller?option=doEliminar" method="POST">
				    					<input type="hidden" name="idTema" value="<%=request.getParameter("idTema")%>">
				    					<input type="hidden" name="posicion" value="<%=i%>">
				    					<input type="submit" value="Eliminar">
				    				</form>
				    			
				    			
				    			
				    			</td> 			
				    			<td><%=carrito.get(i).getTitulo() %></td>
								<td><%=carrito.get(i).getAutor() %></td>
								<td><%=carrito.get(i).getPrecio() %></td>
								
							</tr>		    	
				    	<%} %>
				</table>
				
				<%} %>
			
		<br/><br/>
	</center>
<a href="Controller?option=doTemas">Otro tema</a>
</body>
</html>