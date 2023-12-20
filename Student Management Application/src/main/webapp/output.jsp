<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
  @keyframes wave {
    0% { transform: rotate(0); }
    100% { transform: rotate(360deg); }
  }

  .centered-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh; /* Set height to occupy full viewport height */
  }

  .wave-effect {
    animation: wave 2s infinite linear;
    display: inline-block;
  }
</style>
</head>
<body>
<div class="centered-container">

  <%boolean result = (Boolean)request.getAttribute("OUTPUT"); %>
  <% if(result){ %>
  <h1 class="wave-effect">&#x1F601; STUDENT DATA ADDED &#x1F601;</h1>
  <%}else{ %>
  <h1 class="wave-effect">SOMETHING WENT WRONG!</h1>
  <%} %>
</div>
</body>
</html>
