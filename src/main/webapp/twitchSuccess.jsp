<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="https://static.twitchcdn.net/assets/pages.directory-game-0d7bac92d906727343d5.css">
<title>Search results</title>
</head>

<body>


<fieldset id="twitch-embed">

<c:forEach items="${gdata}" var="gdata">

<legend><c:out value="${param.query}"/></legend>
<img src="${gdata.boxArtUrl}">
</c:forEach>

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
        width: 1820,
        height: 720,
        channel: "${data.userName}",
        autoplay: false,
        theme: "dark"
      });
    </script>
</c:forEach>

<c:forEach items="${vdata}" var="vdata">
    
    <h2><c:out value="${vdata.userName}"/></h2><br/>
	<h2><c:out value="${vdata.title}"/></h2><br/>
	
 <!-- Add a placeholder for the Twitch embed -->
    <div id="twitch-embed"></div>
    

    <!-- Load the Twitch embed script -->
    <script src="https://embed.twitch.tv/embed/v1.js"></script>

    <!-- Create a Twitch.Embed object that will render within the "twitch-embed" root element. -->
    <script type="text/javascript">
      new Twitch.Embed("twitch-embed", {
        width: 1700,
        height: 720,
        video: "${vdata.id}",
        autoplay: false,
        theme: "dark"
      });
    </script>
    
</c:forEach>

</fieldset>


</body>
</html>