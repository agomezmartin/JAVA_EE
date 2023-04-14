<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.time.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%LocalDateTime ldt=LocalDateTime.now(); %>
<%=ldt %>
	<center>
	<h1><%int num= Integer.parseInt(request.getParameter("numero"));%>
	Tabla de multiplicar del <%=num%></h1>
	<table border=1>
	<%for(int i=1;i<=10;i++){ %>
		<tr>
		    <td><%=i%>x<%=num%></td>
			<td><%=i*num%></td>
		</tr>
		<%}%>
	</table>
	</center>
	<a href="inicio.html">Volver</a>
</body>
</html>