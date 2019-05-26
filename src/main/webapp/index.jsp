<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PROJECT TTT</title>
<link rel="stylesheet" type="text/css" href="css/Style.css">
</head>
<body>


<h1>TTT PROJECT</h1>

	<img src=https://cdn.discordapp.com/attachments/470003850343088129/581906848463192085/Sin_titulo-1.png class="center">

	<p>${message}</p>

	<div id="searchDiv">
		<form id="searchForm" action="Search" method="post">
			Introduce el nombre del juego: <input type="text" name="query" required/> 
			<button type="submit" class="button">Buscar</button>
		</form>
	</div>

</body>
</html>