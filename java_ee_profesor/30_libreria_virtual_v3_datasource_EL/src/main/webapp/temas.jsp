<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="model.Cliente"%>
<%@page import="model.Tema"%>
<%@page import="java.util.List"%>
<%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	
	pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<html>
<head>
<title>seleccion</title>
<meta http-equiv="Content-Type" content="text/html;  charset=ISO-8859-1" >
</head>
<body>
<%--  
<%@include file="menu.html" %>

<jsp:include page="menu.jsp"/>
--%>		
	
	<center>
            <h1>Seleccione Tema</h1>
            <br/>
		<form action="Controller?option=doLibros" method="post">
			<select name="idTema">
				<option value="0">-Todos-</option>
				<c:forEach var="t" items="${requestScope.temas}">
					<option value="${t.idTema }">${t.tema }</option>				
				</c:forEach>
				
			</select>
			<br/><br/>
			<input type="submit" value="Libros"/>
		</form>	
			
		

	
	</center>

</body>
</html>