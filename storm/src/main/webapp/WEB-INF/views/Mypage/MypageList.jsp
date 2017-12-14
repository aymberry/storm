<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Document</title>
	<meta name="mypage" content="width=device-width, initial-scale=1" />
</head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600' rel='stylesheet' type='text/css' />
	<link href=" ${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css" media="screen" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
$(function() {
	
	$(".unfBtn").click(function() {
		var data = $(this).attr("data-1");
	$(location).attr("href", "../Mypage/CommuUnFollow.storm?whatdo=unfollow&data2="+data+"&nowpage=${PINFO.nowPage}");
	});


});
</script>
<style>
	#aa {	text-align:center;
			margin:auto;}
</style>
<body>

		  <div style="position: absolute; top: 10px; right:50px">
  			<a href="/storm/Member/MemberForm.storm">회원가입&nbsp;&nbsp;</a>
		<c:if test="${empty sessionScope.UID}">
		<a href="./Login/LoginForm.storm" class="selected">로그인</a><br>
		</c:if>
		<c:if test="${not empty sessionScope.UID}">
		<a href=../Login/Logout.storm class="selected">로그아웃</a><br>
		</c:if>
			</div>
<div id="wrapper">
	<div id="header-wrapper">
		<div id="header">

			<div id="logo">
				<h1><a href="/storm">St0rm2.0</a></h1>
			</div>
		</div>
	</div>

	<!-- end #header -->
	<div id="menu">
		<ul>
			<li><a href="/storm">홈</a></li>
			<li><a id="gameSearch" href="/storm/App/AppList.storm">게임검색</a></li>
			<li><a href="/storm/Chart/ChartView.storm">게임분석</a></li>
			<li><a href="/storm/Commu/CommuMain.storm">커뮤니티</a></li>
			<li class="current_page_item"><a href="/storm/Mypage/MypageList.storm">마이페이지</a></li>
		</ul>
	</div>
	<!-- end #menu -->
	<!-- 본문 -->
	<div id="page">
	
	
<div id="aa">
	<h3>${VO.nick}님의 커뮤니티</h3>
<!-- 		<div id="commudiv" style="margin:auto;">	 -->
	
	
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
	
	
	
	
	
	
		</div>
		<div style="display: inline-block;">
	<h3>회원정보수정</h3>
		이메일 : ${VO.id}<br><br>
		닉네임 : ${VO.nick}<br><br>
	     <button type="button" id="mBtn" value="수정">수정</button><br><br>
	     </div>
</div>
</div>



	<!-- 본문끝 #page --> 
</div>

<div id="footer">
	<p>&copy; Untitled. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a> | Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</p>
</div>
<!-- end #footer -->

</body>
</html>




