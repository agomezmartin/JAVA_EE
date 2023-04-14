<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Datos de la cuenta</h2>
  <form action="validar" method="post">
    <div class="input-group">
  	 	<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
    	<input type="text" class="form-control" name="idCuenta" placeholder="Numero cuenta" required="required">
	</div>
	
  	<br/>
    <button type="submit" class="btn btn-default btn-primary" style="width:100%"> Entrar</button>
    
  </form>
</div>

</body>
</html>