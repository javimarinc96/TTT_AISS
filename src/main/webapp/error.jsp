<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error page</title>
<link rel="stylesheet" type="text/css" href="css/Style.css">
</head>
<body>

<div id="error">

<h3>Por favor, haz login en las siguientes APIS antes de realizar tu busqueda</h3>

   <table>
      <tr>
        <td colspan="2" style="font-weight:bold;">Enlaces de Login:</td>        
      </tr>
      <tr>
        <td><a href="/AuthController/YouTube">YouTube</a></td>
      </tr>
       <tr>
        <td><a href="/AuthController/Twitch">Twitch</a></td>
      </tr>
    </table>
    
    <br/>
    
    <a href="/index.jsp">Volver a la busqueda</a>
    
 </div>
    
</body>
</html>