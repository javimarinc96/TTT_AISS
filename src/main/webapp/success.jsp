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


<c:forEach items="${items}" var="item">

	<h2><c:out value="${item.snippet.title}"/></h2><br/>
	<iframe src= "http://www.youtube.com/embed/${item.id.videoId}"></iframe> 
	
	<div id="commentDiv">
		<form id="commentForm" action="YoutubeAddComment" method="post">
			Add your comment: <input type="text" name="texto" required/> 
			<input type="hidden" name="videoId" value="${item.id.videoId}" required>
			<input type="submit" name="commentBtn" title="comment" value="comment">
		</form>
	</div>
	
</c:forEach>

</fieldset>


</body>
</html>