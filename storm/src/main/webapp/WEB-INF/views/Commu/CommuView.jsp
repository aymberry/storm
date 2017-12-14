<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<meta name="viewport" content="width=device-width, initial-scale=1" />
</head>
	<link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600' rel='stylesheet' type='text/css' />
	<link href=" ${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css" media="screen" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$(".fbt").click(function() {
			var whatdo = $(this).attr("data-1");
			$(location).attr("href", "../Commu/CommuFollow.storm?whatdo="+whatdo+"&data2=${MAP.VIEW.communo}&nowpage=${nowPage}");
		});
		$("#clbtn").click(function(){
			//	목록보기 요청을 하면 된다.
			$(location).attr("href", "../Commu/CommuMain.storm?");
		});
		$("#Mbtn").click(function(){
			//	목록보기 요청을 하면 된다.
			$(location).attr("href", "../Commu/WriteCommu.storm?nowPage=${nowPage}&communo=${MAP.VIEW.communo}");
		});
	});
</script>

<body>
  <div style="position: absolute; top: 10px; right:50px">
  			<a href="/storm//Member/MemberForm.storm">회원가입&nbsp;&nbsp;</a>
		<c:if test="${empty sessionScope.UID}">
		<a href="/storm/Login/LoginForm.storm" class="selected"> 로그인</a><br>
		</c:if>
		<c:if test="${not empty sessionScope.UID}">
		<a href="/storm/Login/Logout.storm" class="selected">로그아웃</a><br>
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
			<li><a href="/storm">홈</a></li>
			<li><a id="gameSearch" href="/storm/App/AppList.storm">게임검색</a></li>
			<li><a href="/storm/Chart/ChartView.storm">게임분석</a></li>
			<li class="current_page_item"><a href="/storm/Commu/CommuMain.storm">커뮤니티</a></li>
			<li><a href="/storm/Mypage/MypageList.storm">마이페이지</a></li>
		</ul>
	</div>
	<!-- end #menu -->
	<!-- 본문 -->
	<div id="page">
	
			<div class="thumbnails">
			<div class="box"  style="color:black; background-color:#D8D8D8;">
				<div id="change">
					<h3>커뮤니티명 : ${MAP.VIEW.communame}</h3>
					<img src="${MAP.VIEW.commuimgName}" alt="커뮤니티이미지" width="300"/>
					<br><br>${MAP.VIEW.commutext}							
				</div>
				<div class="inner">
					출시일 : ${MAP.VIEW.commudate}<br>
					가격 : ${MAP.VIEW.commuprice}
				</div>
			</div>	<br>

	
	<div style="text-align:center; margin:auto;">
		<c:if test="${not empty sessionScope.UID and empty SHOWLIST}">
			<input class="fbt btn btn-dafault"type="button" data-1="add" value="팔로우" style="color:black">
		</c:if>
		<c:if test="${not empty sessionScope.UID and SHOWLIST eq 'N'}">
			<input class="fbt btn btn-dafault"type="button" data-1="follow" value="팔로우재등록" style="color:black" >
		</c:if>
		<c:if test="${not empty sessionScope.UID and SHOWLIST eq 'Y'}">
			<input class="fbt btn btn-dafault"type="button" data-1="unfollow" value="팔로우취소" style="color:black">
		</c:if>
		<c:if test="${not empty sessionScope.UID and SHOWLIST eq 'Y'}">
			<input class="btn btn-dafault" type="button" id="Mbtn" value="게시판등록" align="center" style="color:black">
		</c:if>
		<input class="btn btn-dafault"  type="button" id="clbtn" value="커뮤니티목록보기" align="center" style="color:black">
	</div>
	<div>
		<br><br><br>
	</div>
	
	
	 <table style="width:1000px; margin:auto;" class="table table-striped "> 
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>작성일</th>
		</tr>
		<c:forEach var="data" items="${BLIST}">
			<tr>
				<td>${data.boardno}	</td>
				<td>
<%-- 					<a href=
					"../Commu/BoardView.storm?nowPage=
					${PINFO.nowPage }&barodno=${data.boardno}"> --%>
					${data.boardname }<!-- </a> -->
				</td>
				<td>${sessionScope.UID}</td>
				<td>${data.bdate}</td>
				</tr>
		</c:forEach>
	</table> 

	<table width="800" align="center">
		<tr style="color:silver">
			<td align="center">
				<c:if test="${PINFO.startPage eq 1}">
					[이전]
				</c:if>	
				<c:if test="${PINFO.startPage ne 1}">
					<a href="../Commu/CommuView.storm?nowPage=${PINFO.startPage - 1}">[이전]</a>
				</c:if>		
				<c:forEach var="i" begin="${PINFO.startPage}" end="${PINFO.endPage}">
					[<a href="#">${i}</a>]								
				</c:forEach>
				<c:if test="${PINFO.endPage eq PINFO.totalPage}">
					[다음]
				</c:if>
				<c:if test="${PINFO.endPage ne PINFO.totalPage}">
					<a href="../Commu/CommuView.storm?nowPage=${PINFO.endPage + 1}">[다음]</a>
				</c:if>
			</td>
		</tr>
	</table>
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