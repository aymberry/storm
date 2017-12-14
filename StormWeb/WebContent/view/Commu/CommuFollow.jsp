<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Document</title>
</head>
<body>
  	<c:redirect url="/Commu/CommuView.ust">
	 	<c:param name="commuNo" value="${cNo}"/>
	 	 <%-- name="nowpage" value="${nowpage}"  --%>
	</c:redirect>
</body>
</html>
