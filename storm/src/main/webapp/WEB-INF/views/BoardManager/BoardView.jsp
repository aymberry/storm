<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
	$(document)
			.ready(
					function() {
						$("#mBtn")
								.click(
										function() {
											$(location)
													.attr(
															"href",
															"../BoardManager/ModifyForm.storm?boardNo=${MAP.VIEW.board_no}&nowPage=${nowPage}");
										});

						$("#dBtn").click(function() {

							$("#ifrm").submit();
						});
					});
</script>
<body>
	<div class="container">
		<table class="table table-bordered" width="800" border="1"
			align="center">
			<col valign="middle">
			<tr>
				<td height="20" style="background-color: #191970" align="center">
					<p style="font-weight: bold">
						<font face="verdana" size="5" color="#FFFFFF"> 상세화면 </font>
					</p>
				</td>
			</tr>
		</table>
		<table class="table table-bordered" width="800" border="1"
			align="center">
			<col valign="middle">
			<tr>
				<td height="20" width="200" bgcolor="#C0C0C0">
					<p style="font-weight: bold">게시글번호</p>
				</td>
				<td>${MAP.VIEW.board_no}</td>
			</tr>
			<tr>
				<td height="20" width="200" bgcolor="#C0C0C0">
					<p style="font-weight: bold">상품번호</p>
				</td>
				<td>${MAP.VIEW.board_app_id}</td>
			</tr>
			<tr>
				<td height="20" width="200" bgcolor="#C0C0C0">
					<p style="font-weight: bold">사용자번호</p>
				</td>
				<td>${MAP.VIEW.board_user_key}</td>
			</tr>
			<tr>
				<td height="20" width="200" bgcolor="#C0C0C0">
					<p style="font-weight: bold">제목</p>
				</td>
				<td>${MAP.VIEW.board_title}</td>
			</tr>
			<tr>
				<td height="20" width="200" bgcolor="#C0C0C0">
					<p style="font-weight: bold">작성일</p>
				</td>
				<td>${MAP.VIEW.board_wdate}</td>
			</tr>
			<tr>
				<td  height="200" width="200" bgcolor="#C0C0C0">
					<p style="font-weight: bold">본문</p>
				</td>
				<td height="200" width="500">
				<textarea readonly rows="15"
						cols="120" id="board_text" name="board_text"> ${MAP.VIEW.board_text}</textarea>
				</td>
			</tr>
			<tr>
				<td height="20" width="200" bgcolor="#C0C0C0">
					<p style="font-weight: bold">삭제여부</p>
				</td>
				<td>${MAP.VIEW.board_isshow}</td>
			</tr>
		</table>

		<table class="table table-bordered" width="800" border="1"
			align="center">
			<tr>
				<td align="center"><input class="btn btn-primary btn-md"
					type="button" id="mBtn" value="수정하기"> <input
					class="btn btn-primary btn-md" type="button" id="dBtn" value="삭제하기"></td>
			</tr>
		</table>
		<!-- 	
			이처럼 중요한 정보를 GET 방식으로 보내면 보안에 취약하다.
			
			임시 폼을 만들어서 전달할 값을 모두 폼 안에 입력한 후
			그 폼을 submit 방식으로 전달하여 보안에 주의 해야 한다,
	-->
		<form method="POST" id="ifrm"
			action="../BoardManager/DeleteProc.storm">
			<input type="hidden" id="boardNo" name="boardNo"
				value="${MAP.VIEW.board_no}">
			<input type="hidden"
				id="nowPage" name="nowPage" value="${nowPage}">
		</form>
	</div>
</body>
</html>
