 <%@ page contentType="text/html; charset=UTF-8" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600' rel='stylesheet' type='text/css' />
	<link href=" ${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css" media="screen" />
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<body>
		  <div style="position: absolute; top: 10px; right:50px">
  			<a href="./Member/MemberForm.storm">회원가입&nbsp;&nbsp;</a>
		<c:if test="${empty sessionScope.UID}">
		<a href="./Login/LoginForm.storm" class="selected">로그인</a><br>
		</c:if>
		<c:if test="${not empty sessionScope.UID}">
		<a href="./Login/Logout.storm" class="selected"></i> 로그아웃</a><br>
		</c:if>
			</div>

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
			<li class="current_page_item"><a href="/storm">홈</a></li>
			<li><a id="gameSearch" href="/storm/App/AppList.storm">게임검색</a></li>
			<li><a href="/storm/Chart/ChartView.storm">게임분석</a></li>
			<li><a href="/storm/Commu/CommuMain.storm">커뮤니티</a></li>
			<li><a href="/storm/Mypage/MypageList.storm">마이페이지</a></li>
		</ul>
	</div>
	<!-- end #menu -->
	<!-- 본문 -->
	<div id="page" >
	

    
    <a	href="./App/AppView.storm?app_id=${RECENT.id}">
    <div class="panel panel-warning" style="width:33%; margin:auto; float:left;">
	<div class="panel-heading">
  		<h3 class="panel-title">최신게임 - ${RECENT.title}</h3>
	</div>
	<div class="panel-body" style="margin:auto; text-align:center;">
  					<img src="${RECENT.imgURL}" alt="게임사진" width="300"/><br><br>
  					<b>
  						<c:if test="${RECENT.price eq 0}">
								무료
							</c:if>
							<c:if test="${RECENT.price ne 0}">
								 ${data.price} 원
							</c:if>
  					</b> 
  					<br>
  					${RECENT.realDate} 출시<br>
  				
		</div>
	</div>
	</a>
	
	<a	href="./App/AppView.storm?app_id=${HOT.id}">
    <div class="panel panel-warning" style="width:33%; margin:auto; float:left;">
	<div class="panel-heading">
  		<h3 class="panel-title">핫 게임 - ${HOT.title}</h3>
	</div>
	<div class="panel-body" style="margin:auto; text-align:center;">
  					<img src="${HOT.imgURL}" alt="게임사진" width="300"/><br><br>
  					<b>
  						<c:if test="${HOT.price eq 0}">
								무료
							</c:if>
							<c:if test="${HOT.price ne 0}">
								 ${HOT.price} 원
							</c:if>
  					</b> 
  					<br>
  					${HOT.realDate} 출시<br>
  				
	</div>
	</div>
	</a>
	
	<a	href="./App/AppView.storm?app_id=${SOON.id}">
    <div class="panel panel-warning" style="width:33%; margin:auto; float:left;">
	<div class="panel-heading">
  		<h3 class="panel-title">발매 예정 - ${SOON.title}</h3>
	</div>
	<div class="panel-body" style="margin:auto; text-align:center;">
  					<img src="${SOON.imgURL}" alt="게임사진" width="300"/><br><br>
  					<b>
  						<c:if test="${SOON.price eq 0}">
								무료
							</c:if>
							<c:if test="${SOON.price ne 0}">
								 ${SOON.price} 원
							</c:if>
  					</b> 
  					<br>
  					${SOON.realDate} 출시<br>
  				
	</div>
</div>
</a>





	<!-- 본문끝 #page --> 
</div>

<div id="footer">
	<p>&copy; Untitled. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a> | Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</p>
</div>
<!-- end #footer -->
</body>
</html>
 