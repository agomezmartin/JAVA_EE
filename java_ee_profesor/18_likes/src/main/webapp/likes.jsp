<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%Integer contador=(Integer)application.getAttribute("contador"); 
	if(contador!=null){%>
		<h1>Total likes: <%=contador%></h1>
	<%}else{ %>
		<h1>No le gustas a nadie</h1>
	<%} %>
	<br><br>
	<a href="inicio.html">Volver</a>
	
</body>
</html>