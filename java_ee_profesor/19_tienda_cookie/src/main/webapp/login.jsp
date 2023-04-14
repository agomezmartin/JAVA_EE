<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%--recuperamos y mostramos la cookie de fecha --%>
<%String valor="";
Cookie[] cookies=request.getCookies();
if(cookies!=null){
	for(Cookie ck:cookies){
		if(ck.getName().equals("fechaultima")){
			valor=ck.getValue();
		}
	}
}
if(!valor.equals("")){%>
Fecha última visita:<%=valor %>
<%} %>
	<center>
		<img alt="sin imagen" src="imgGoogle.png">
		<form action="Login" method="POST">
			Usuario:<input type="text" name="usuario"><br>
			Contraseña:<input type="password" name="pwd"><br>
			<input type="submit" value="Entrar">
		</form>
	
	</center>
</body>
</html>