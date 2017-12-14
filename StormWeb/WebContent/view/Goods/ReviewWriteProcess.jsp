<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Document</title>
</head>
<body>
  	<c:redirect url="../Goods/GoodsDetailView.ust?GOODS_NO=${GOODS_NO}&USER_ID=${sessionScope.UID}">
	</c:redirect>
</body>
</html>
