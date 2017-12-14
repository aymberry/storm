<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Document</title>
</head>
<body>
<%
	
	session.removeAttribute("UID");
	response.sendRedirect("/");
%>  
</body>
</html>
