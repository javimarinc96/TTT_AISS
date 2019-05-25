<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My first mashup</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>


<h1>TTT PROJECT</h1>

	<p>${message}</p>

	<div id="searchDiv">
		<form id="searchForm" action="YoutubeSearch" method="post">
			Introduce tu busqueda: <input type="text" name="query" required/> 
			<button type="submit" class="button">Buscar</button>
		</form>
	</div>

</body>
</html>