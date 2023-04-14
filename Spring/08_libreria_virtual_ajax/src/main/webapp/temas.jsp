<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="model.Cliente"%>
<%@page import="model.Tema"%>
<%@page import="java.util.List"%>
<%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	
	pageEncoding="ISO-8859-1" %>
	
<html>
<head>
<title>seleccion</title>
<meta http-equiv="Content-Type" content="text/html;  charset=ISO-8859-1" >

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	function mostrarLibros(){
		var dir="libros";
		$.get(dir,{"idTema":$("#idTema").val()},function(data,status){
			var tabla="<table border='1'><tr><th></th><th>Titulo</th><th>Autor</th><th>Precio</th></tr>";
			for(var c of data){
				tabla+="<tr><td><a href='#' onclick='agregarCarrito("+c.isbn+")'>Añadir</a></td><td>"+c.titulo+"</td><td>"+c.autor+"</td><td>"+c.precio+"</td></tr>";
			}
			tabla+="</table>";
			$("#libros").html(tabla);
			
		});
	}
	function agregarCarrito(isbn){
		var dir="agregar";
		$.get(dir,{"isbn":isbn},function(data,status){
			var tabla="<table border='1'><tr><th></th><th>Titulo</th><th>Autor</th><th>Precio</th></tr>";
			var pos=0;
			for(var c of data){
				tabla+="<tr><td><a href='#' onclick='eliminarCarrito("+pos+")'>Eliminar</a></td><td>"+c.titulo+"</td><td>"+c.autor+"</td><td>"+c.precio+"</td></tr>";
				pos++;
			}
			tabla+="</table>";
			$("#carrito").html(tabla);
		});
	}
	
	function eliminarCarrito(pos){
		var dir="eliminar";
		$.get(dir,{"posicion":pos},function(data,status){
			var tabla="<table border='1'><tr><th></th><th>Titulo</th><th>Autor</th><th>Precio</th></tr>";
			var pos=0;
			for(var c of data){
				tabla+="<tr><td><a href='#' onclick='eliminarCarrito("+pos+")'>Eliminar</a></td><td>"+c.titulo+"</td><td>"+c.autor+"</td><td>"+c.precio+"</td></tr>";
				pos++;
			}
			tabla+="</table>";
			$("#carrito").html(tabla);
		});
	}
	

</script>

</head>
<body>
	

	
	<%List<Tema> temas=(List<Tema>)request.getAttribute("temas"); %>
	
	<center>
            <h1>Seleccione Tema</h1>
            <br/>
		
			<select name="idTema" id="idTema" onchange="mostrarLibros();">
				<option value="0">-Todos-</option>
				<%for(Tema t:temas){ %>
					<option value="<%=t.getIdTema()%>"><%=t.getTema()%></option>				
				<%} %>
				
			</select>
			<br><br>
			
		
			
		<div id="libros">
		
		</div>
		<br><br><br>
		<div id="carrito">
		
		</div>
	
	</center>

</body>
</html>