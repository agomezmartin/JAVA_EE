<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  
  <form action="Transferir" method="post">
  	<div class="input-group">
  	 	<span class="input-group-addon">Cuenta destino</span>
    	<input  type="text" class="form-control" name="destino" placeholder="destino" required="required">
	</div>
  
    <div class="input-group">
  	 	<span class="input-group-addon">Cantidad</span>
    	<input  type="text" class="form-control" name="cantidad" placeholder="cantidad" required="required">
	</div>
	
  	<br/>
    <button type="submit" class="btn btn-default btn-primary" style="width:100%"> Transferir</button>
    
  </form>
  <br/><br/>
  <a href="toMenu">Volver</a>
</div>

</body>
</html>