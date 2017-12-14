<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600' rel='stylesheet' type='text/css' />
	<link href=" ${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css" media="screen" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
</script>
<script>
	$(document).ready(function(){
		$(".reBtn").click(function(){
			alert("댓글이 등록되었습니다.");
			$(".form-control").attr("action", "../Commu/commureplyProc.storm");
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
	
	
	
	
<!--	상세보기를 보여준다. 
		넘어온 데이터는 MAP이라는 키값으로 MAP형태로 넘어왔고 이 중
		상세보기 내용은 VIEW라는 키값으로 묶여 있다.
		${MAP.VIEW} ==>묶인 AnBoardVO 가 나온다.
		이 중 번호는 getNo() 함수로 제공되고 있으므로 번호를 출력하려면
		${MAP.VIEW.no} -->
	<table width="800" border="1" align="center">
		<tr>
			<td>글번호</td>
			<td colspan="3">${CVO.boardno}</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${sessionScope.UID}</td>
			<td>작성일</td>
			<td>${CVO.boardwdate}</td>
		</tr>
		<tr>
			<td>제목</td>
			<td colspan="3">${CVO.boardname}</td>
		</tr>
		<tr>
			<td colspan="4">내용</td>
		</tr>
		<tr>	
			<td colspan="4">${CVO.boardtext}</td>
		</tr>
		<tr>
		</tr>
		
	</table>
	
	<div id="content" align="center">
		<table>
			<tr>
				<c:if	test="${not empty sessionScope.UID}">
  					<h4>댓글쓰기</h4>
  						<form role="form">
    						<div class="form-group">
      							<textarea class="form-control" id="content" name="content" rows="3" required></textarea>
    						</div>
    						<button type="button" class="reBtn">댓글등록</button>
  						</form>
  						<br><br>
				</c:if>
			</tr>
			<tr>
				<table>
					<tr>
						<td>
							<div class="row">
								<div class="col-sm-2 text-center">
								</div>
 								<div class="col-sm-10">
 <!-- 								<h4>
 										<small>닉네임 : ${CVO.nick}</small>
 										<small>${CVO.boardwdate} &nbsp;&nbsp; </small>
 									</h4> -->	
     								<p>${CVO.reply}</p><br>
								</div>
							</div>
						</td>
					</tr>
				</table>
			</tr>
		</table>
	</div>
		<br><br>
		<div id="comments">
			댓글
			<table width="100%" align="center">
				<tr>
					<th>	작성자	</th>
					<th>	내용		</th>
					<th>	작성일	</th>
				</tr>
				
				<c:forEach	var="comment"	items="${CVO.reply}" varStatus="i">
					<tr	id="comment${i.index}">
						<td>${CVO.nick}</td>
						<td>${CVO.reply}</td>
						<td>${CVO.boardwdate}</td>
					</tr>			
				</c:forEach>
			</table>


		
		
			<!-- 본문끝 #page --> 
</div>

<div id="footer">
	<p>&copy; Untitled. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a> | Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</p>
</div>
<!-- end #footer -->


</body>
</html>