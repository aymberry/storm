<%@ page contentType="text/html; charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!Doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600' rel='stylesheet' type='text/css' />
	<link href=" ${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		$("#searchBar").load("App/AppSearchForm.storm");
		$("#singup").click(function(){
			//	무결성 검사를 한다.
			
			$("#cFrm").submit();
		});	
	});

</script>
<body>
  <div style="position: absolute; top: 10px; right:50px">
  			<a href="/storm//Member/MemberForm.storm">회원가입&nbsp;&nbsp;</a>
		<c:if test="${empty sessionScope.UID}">
		<a href="/storm/Login/LoginForm.storm" class="selected">로그인</a><br>
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
	
	
	

<div class="row">
  <div class="column middle" id="mainBody">
  	<div	id="searchBar">
  	</div>
    <h2>게시판등록</h2>
    <form method="POST" id="cFrm" action="../Commu/WriteProc.storm">
    	<table align="left">
    		<tr>
	    		<td>커뮤니티번호</td>
    			<td>
    				<input type="text" id="communo" name="communo" value="${MAP.VIEW.communo }" readonly>
	    		</td>
   				<td>글쓴이</td>
				<td>
				<input type="text" id="writer" name="writer" value="${sessionScope.UID}" readonly>
				</td>
    		</tr>
			<tr>
				<td>제목</td>
				<td>
					<textarea id="boardname" name="boardname"></textarea>
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea id="boardtext" name="boardtext"></textarea>
				</td>
			</tr>
    	</table><br><br><br><br><br><br><br><br>
    	<input type="button" id="singup" value="글쓰기">
    </form>
  </div>
</div>

<div id="footer">
	<p>&copy; Untitled. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a> | Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</p>
</div>
<!-- end #footer -->
</body>
</html>
 