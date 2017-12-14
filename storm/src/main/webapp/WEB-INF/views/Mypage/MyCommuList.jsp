<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	$(function() {
		
		$(".unfBtn").click(function() {
			var data = $(this).attr("data-1");
			alert(data);
		$(location).attr("href", "../Mypage/CommuUnFollow.storm?whatdo=unfollow&data2="+data+"&nowpage=${PINFO.nowPage}");
		});


	});
</script>
<body>
<div style="display: inline-block;">
<c:forEach var="data" items="${LIST}">
 	<div class="panel panel-warning" style="width:600px; margin:auto; float:left; ">
		<div class="panel-heading">
  		<h3 class="panel-title">게임 - ${data.communame}</h3>
		</div>
		<div class="panel-body" style="margin:auto; text-align:center;">
  					<img src="${data.imgname}" alt="게임사진" width="300"/><br><br>
					<input type="button" data-1="${data.communo}" value="언팔로우" class="unfBtn" align="center" style="color:black">
		</div>
	</div>
		</c:forEach>
</div>
		

</body>
</html>
