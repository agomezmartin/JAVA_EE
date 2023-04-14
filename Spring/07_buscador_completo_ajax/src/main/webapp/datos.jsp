<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	function buscarPaginas(){
		var dir="Buscador";
		$.post(dir,{"tema":$("#tema").val()},function(data,status){
			var res="";
			for(var p of data){
				res+="<h2><a href='"+p.direccion+"'>"+p.direccion+"</a></h2><h4>"+p.descripcion+"</h4>";
			}
			
			$("#resultados").html(res);
			
		});
	}

</script>



</head>
<body>
	<center>
		
			Introduce temática:<input type="text" name="tema" id="tema"><br><br>
			<input type="button" value="Buscar" onclick="buscarPaginas();">
			<br><br>
			<div id="resultados">
			
			
			</div>
		
	
	</center>
</body>
</html>