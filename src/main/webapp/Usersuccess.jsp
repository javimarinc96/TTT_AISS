<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Search results</title>
</head>

<body>


<fieldset id="Twitch">

<legend><c:out value="${param.query}"/></legend>


<c:forEach items="${data}" var="data">
	<h2><c:out value="${data.title}"/></h2><br/>
	<h2><c:out value="${data.id}"/></h2><br/>
	<iframe src= "https://www.twitch.tv/${data.user_name}"></iframe> 
</c:forEach>

</fieldset>


</body>
</html>