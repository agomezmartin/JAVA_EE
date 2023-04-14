<!DOCTYPE html>
<html>
<head>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<script type="text/javascript">
	function recuperarMovimientos(){
		var dir="movimientosSaldo";
		$.get(dir,function(data,status){
			var tabla="<table class='table table-striped table-bordered'><tr><th>Cantidad</th><th>Operación</th><th>Fecha</th></tr>";
			for(var m of data){
				tabla+="<tr><td>"+m.cantidad+"</td><td>"+m.operacion+"</td><td>"+m.fecha+"</td></tr>";
			}
			tabla+="</table>";
			$("#movimientos").html(tabla);
			
		});
	}
</script>
</head>
<body>
<div class="container">
<form action="" method="post" class="form-horizontal">

	<h1>Opciones</h1>
	
	<a href="toIngresar" class="btn btn-primary" style="width:25%" >Ingreso </a>
	<a href="toExtraer" class="btn btn-primary" style="width:25%" >Extraer </a>
	<a href="toTransferencia" class="btn btn-primary" style="width:25%" >Transferencia </a>
	<a href="#" class="btn btn-primary" onclick="recuperarMovimientos();" style="width:25%" >Movimientos y saldo </a>
	
</form>
<br/><br/>
<div id="movimientos">

</div>
</div>
</body>
</html>