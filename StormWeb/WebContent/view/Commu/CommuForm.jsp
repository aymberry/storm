<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="../css/commu/css/main.css" />
		<style>#change:hover{opacity:0.6}
		</style>
	</head>
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>

	$(document).ready(function(){	
		$("#wBtn").click(function(){			
			$("#wfrm").submit();
		});
	});
</script>
<body id="top" style="background-color:black;">
		<jsp:include page="../../view/main/header.jsp" flush="true" />
			<section class="main clearfix" style="background-color:black">
		<jsp:include page="../../view/main/logo.jsp" flush="true" />
		
  	<form method="POST" id="wfrm" action="../Commu/CommuProc.ust" encType="multipart/form-data">
		<table style="width:70%;color:white;" align="center" border="1">
			<tr>
				<td>커뮤니티 이름</td>
				<td><input type="text" id="title" name="title" style="background-color:gray"></td>
			</tr>
			<tr>
				<td>커뮤니티소개</td>
				<td><textarea id="body" name="body" style="background-color:gray"></textarea></td>
			</tr>			

<%--
	첨부파일을 등록하기 위해서는 <input type="file" 이라는 입력상자를
	사용해야 한다.
--%>			
			<tr>
				<td>사진파일</td>
				<td><input type="file" id="file1" name="file1"></td>
			</tr>
			<tr id="files">
				<td colspan="2" align="center">
					<input type="button" id="wBtn" value="커뮤니티만들기">
				</td>
			</tr>
		</table>	
	</form>
	</section>
</body>
</html>
