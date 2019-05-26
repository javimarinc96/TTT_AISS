<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 
<!DOCTYPE html> 
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search results</title>
</head>

<body>
<fieldset id="game-data">

<h3>Informacion del juego</h3>

<c:forEach items="${gdata}" var="gdata">

<img src="${gdata.boxArtUrl}" width="350" height="400">
<br/> 
Titulo del juego: <c:out value="${gdata.name}"/><br/>
<br/>
Id de Referencia: <c:out value="${gdata.id}"/><br/>


</c:forEach>

</fieldset>
<fieldset id="youtube">

<h3>Videos de YouTube para: <c:out value="${param.query}"/></h3>


<c:forEach items="${requestScope.items}" var="item">

	<h2><c:out value="${item.snippet.title}"/></h2><br/>
	<iframe src= "http://www.youtube.com/embed/${item.id.videoId}" ></iframe> 
	 

	
	<div id="commentDiv">
	
		<form id="commentForm" action="YoutubeAddComment" method="post">
			Add your comment: <input name="texto" type="text" required="required"> 
			<input name="videoId" type="hidden" value="${item.id.videoId}">
			<button type="submit" class="button">Comentar</button>
		</form>
		
	</div>
	
</c:forEach>

</fieldset>


<fieldset id="twitch-embed">

<h3>Streams de Twitch para: <c:out value="${param.query}"/></h3>

<c:forEach items="${data}" var="data">
    
    <h2><c:out value="${data.userName}"/></h2><br/>
	<h2><c:out value="${data.title}"/></h2><br/>
	
 <!-- Add a placeholder for the Twitch embed -->
    <div id="twitch-embed"></div>
    

    <!-- Load the Twitch embed script -->
    <script src="https://embed.twitch.tv/embed/v1.js"></script>

    <!-- Create a Twitch.Embed object that will render within the "twitch-embed" root element. -->
    <script type="text/javascript">
    new Twitch.Embed("twitch-embed", {
        width: 800,
        height: 800,
        channel: "${data.userName}",
        autoplay: false,
        theme: "dark"
      });
    </script>
</c:forEach>

<c:forEach items="${vdata}" var="vdata">
    
    Usuario:<h2><c:out value="${vdata.userName}"/></h2><br/>
	Video:<h2><c:out value="${vdata.title}"/></h2><br/>
	
 	<!-- Add a placeholder for the Twitch embed -->
    <div id="twitch-embed"></div>
    

    <!-- Load the Twitch embed script -->
    <script src="https://embed.twitch.tv/embed/v1.js"></script>

    <!-- Create a Twitch.Embed object that will render within the "twitch-embed" root element. -->
    <script type="text/javascript">
      new Twitch.Embed("twitch-embed", {
        width: 800,
        height: 800,
        video: "${vdata.id}",
        autoplay: false,
        theme: "dark"
      });
    </script>
    
</c:forEach>

</fieldset>

<fieldset id="aliexpress">

<h3>Merchandising de AliExpress para: <c:out value="${param.query}"/></h3>

		
		<c:forEach items="${requestScope.productos}" var="producto" begin="1" end="5">
		
			<a target="_blank" href="<c:out value="${producto.productUrl}"/>">${producto.productTitle}</a>
			<br><br>
			<img src="<c:out value = "${producto.imageUrl}"/>" height="300"	width="350" />
			<br>
			<br>
			<span style="font-size: 24px; font-family: arial; color:#E84B15; font-weight: 700; align: left; ">
			<c:out value="${producto.localPrice}"/></span>
			<br>
			<br>
			
		</c:forEach>
	</fieldset>
	

</body>
</html></html>