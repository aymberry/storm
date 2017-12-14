<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Document</title>
</head>
<body>
	<%--	글쓰기 작업의 뷰 문서인데... 
 		글쓴 후에는 보여줄 내용없고 목록보기로 redirect 시키면 된다.
 --%>
	<c:redirect url="../main/StormMain.ust" />
</body>
</html>