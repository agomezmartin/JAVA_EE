
<!DOCTYPE HTML><%@page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	
	%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<html>
<head>
<title>libros</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	
	<center>
		
		<br/><br/>
		
		 
		
				<table border="1">
				    <tr><th></th><th>Titulo</th><th>Autor</th><th>Precio</th></tr>		    	
				    	<c:forEach var="lb" items="${requestScope.libros}">
				    		<tr>
				    			<td><a href="agregar?idTema=${param.idTema}&isbn=${lb.isbn}">A�adir</a></td>
				    			<td>${lb.titulo }</td>
								<td>${lb.autor }</td>
								<td>${lb.precio }</td>
								
							</tr>		    	
				    	</c:forEach>
				</table>
				
				<br/><br/>
				<c:if test="${! empty sessionScope.carrito}">
					<h1>Carrito</h1>
					<table border="1">
					    <tr><th></th><th>Titulo</th><th>Autor</th><th>Precio</th></tr>		    	
					    	<c:forEach var="lb" items="${sessionScope.carrito}" varStatus="s">
					    		<tr>
					    			<td>
					    				<form action="eliminar" method="get">
					    					<input type="hidden" name="idTema" value="${param.idTema }">
					    					<input type="hidden" name="posicion" value="${s.index}">
					    					<input type="submit" value="Eliminar">
					    				</form>
					    			
					    			
					    			
					    			</td> 			
					    			<td>${lb.titulo }</td>
									<td>${lb.autor }</td>
									<td>${lb.precio }</td>
									
								</tr>		    	
					    	</c:forEach>
					</table>
				
				</c:if>
			
		<br/><br/>
	</center>
<a href="temas">Otro tema</a>
</body>
</html>