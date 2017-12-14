<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600' rel='stylesheet' type='text/css' />
	<link href=" ${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css" media="screen" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	function Search() {
		//	무결성 검사 하고
		$("#sfrm").submit();
	}
	$(document).ready(function(){
		
		$("#sBtn").click(Search);
		
	});
</script>
<style>
.thumbnails {
		display: -moz-flex;
		display: -webkit-flex;
		display: -ms-flex;
		display: flex;
		-moz-align-items: stretch;
		-webkit-align-items: stretch;
		-ms-align-items: stretch;
		align-items: stretch;
		-moz-justify-content: center;
		-webkit-justify-content: center;
		-ms-justify-content: center;
		justify-content: center;
		-moz-flex-wrap: wrap;
		-webkit-flex-wrap: wrap;
		-ms-flex-wrap: wrap;
		flex-wrap: wrap;
	}

		.thumbnails .box {
			margin: 1em 1em 1em 1em;
			width: 1000px;
		}
			
			.box {
		border-radius: 4px;
		margin-bottom: 2em;
		background: #fff;
		text-align: center;
	}

		.box > :last-child,
		.box > :last-child > :last-child,
		.box > :last-child > :last-child > :last-child {
			margin-bottom: 0;
		}

		.box .image.fit {
			margin: 0;
		}

		.box .image img {
			border-radius: 4px 4px 0 0;
		}

		.box .inner {
			padding: 1.5em;
			width: 100% !important;
		}

			@media screen and (max-width: 480px) {

				.box .inner {
					padding: 1em;
				}

			}

		.box.alt {
			border: 0;
			border-radius: 0;
			padding: 0;
		}
</style>
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
	
	<div class="thumbnails">
<!-- 	검색창을 만든다. -->
		<form method="POST" id="sfrm" action="../Commu/CommuSearch.storm">
			<input type="hidden" name="nowPage" value="1">
			<table width="1000" align="center">
				<tr>
					<td align="center">
						<select id="target" name="target">
							<option value="category">카테고리</option>
							<option value="genre">장르</option>
							<option value="tag">태그</option>
						</select>
						<input type="text" id="word" name="word">
						<input type="button" id="sBtn" value="검색하기">					
					</td>
				</tr>
			</table>
		</form>
	<!--<img src="../img/commu/${data.commuImgName}" alt="" width="380"/>  -->
<!-- 	목록보기를 보여준다. -->

		<c:forEach var="data" items="${LIST}">
			<div class="box"  style="cursor: pointer;  color:black; background-color:#D8D8D8" onclick="location.href='../Commu/CommuView.storm?communo=${data.communo}&nowPage=${PINFO.nowPage}'">
				<div id="change">
					<h3>${data.communame}</h3>
					<img src="${data.commuimgName}" alt="커뮤니티이미지" width="300"/><br><br>${data.commutext} 								
				</div>
				<div class="inner">
				</div>
			</div>
		</c:forEach>


						
	<table width="800" border="1" align="center">
		<tr style="color:silver">
			<td align="center">
				<c:if test="${PINFO.startPage eq 1}">
					[이전]
				</c:if>	
				<c:if test="${PINFO.startPage ne 1}">
					<a href="../Commu/CommuMain.storm?nowPage=${PINFO.startPage - 1}">[이전]</a>
				</c:if>		
				<c:forEach var="i" begin="${PINFO.startPage}" end="${PINFO.endPage}">
					[<a href="../Commu/CommuMain.storm?nowPage=${i}">${i}</a>]								
				</c:forEach>
				<c:if test="${PINFO.endPage eq PINFO.totalPage}">
					[다음]
				</c:if>
				<c:if test="${PINFO.endPage ne PINFO.totalPage}">
					<a href="../Commu/CommuMain.storm?nowPage=${PINFO.endPage + 1}">[다음]</a>
				</c:if>
			</td>
		</tr>
	</table>
			

	<!-- 본문끝 #page --> 
</div>

<div id="footer">
	<p>&copy; Untitled. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a> | Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</p>
</div>
<!-- end #footer -->
</body>
</html>