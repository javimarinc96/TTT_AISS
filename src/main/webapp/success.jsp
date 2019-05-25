<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css">
<title>Search results</title>
</head>

<body>


<fieldset id="Twitter">

<legend>Twitter search for <c:out value="${param.query}"/></legend>


<c:forEach items="${items}" var="item">
	<h2><c:out value="${item.snippet.title}"/></h2><br/> 
</c:forEach>

</fieldset>


</body>
</html>