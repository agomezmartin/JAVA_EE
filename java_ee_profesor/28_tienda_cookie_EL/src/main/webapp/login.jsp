<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%--recuperamos y mostramos la cookie de fecha 
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
Fecha �ltima visita:<%=valor %>
<%} %>
--%>
<c:if test="${!empty cookie.fechaultima}">
	Fecha �ltima visita:${cookie.fechaultima.value}
</c:if>


	<center>
		<img alt="sin imagen" src="imgGoogle.png">
		<form action="Login" method="POST">
			Usuario:<input type="text" name="usuario"><br>
			Contrase�a:<input type="password" name="pwd"><br>
			<input type="submit" value="Entrar">
		</form>
	
	</center>
</body>
</html>