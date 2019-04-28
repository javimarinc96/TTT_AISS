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


<fieldset id="youtube">

<legend>Youtube search for <c:out value="${param.query}"/></legend>


<c:forEach items="${requestScope.items}" var="item">
	<span>Video title: <c:out value="${item.snippet.title}"/></span><br/>
</c:forEach>

</fieldset>

</body>
</html>