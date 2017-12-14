<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="STDao.*, STVo.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Document</title>
</head>
<body>

 
 <%
	
	String		id = request.getParameter("id");
	String		pw = request.getParameter("pw");	


	STMemberDao	dao =  new STMemberDao();
	STMemberVo 	mVO = dao.loginCheck(id, pw);
	if(mVO != null) {
		session.setAttribute("USER", mVO);
		response.sendRedirect("./STLoginForm.ust");
	}
	

	else {
		response.sendRedirect("./STLoginForm.ust");
	%> <script> alert("로그인 실패"); history.go(-1); </script> <% 

		
		
	}

	%>
	
	

</body>
</html>






