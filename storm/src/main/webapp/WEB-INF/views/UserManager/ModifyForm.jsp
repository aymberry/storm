<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	function sendModify() {
		var frm = document.getElementById("mFrm");
		frm.submit();
	}
</script>
<body>
	<div class="container">
		<table class="table table-bordered" width="800" border="1"
			align="center">
			<col valign="middle">
			<tr>
				<td height="20" style="background-color: #191970" align="center">
					<p style="font-weight: bold">
						<font face="verdana" size="5" color="#FFFFFF"> 수정화면 </font>
					</p>
				</td>
			</tr>
		</table>
		
		<form method="POST" id="mFrm" action="../UserManager/ModifyProc.storm">
			<input type="hidden" name="userKey" value="${VIEW.user_key}">
			<input type="hidden" name="nowPage" value="${nowPage}">
			<table class="table table-bordered" width="800" border="1"
				align="center">
				<tr>
					<td height="20" width="200" bgcolor="#C0C0C0">
						<p style="font-weight: bold">사용자번호</p>
					</td>
					<td>${VIEW.user_key}</td>
				</tr>
				<tr>
					<td height="20" width="200" bgcolor="#C0C0C0">
						<p style="font-weight: bold">
							<font color="blue">이메일</font>
						</p>
					</td>
					<td height="20" >
					<input size=50 maxlength=100 type="text" id="user_email"
						name="user_email" value="${VIEW.user_email}"></td>
				</tr>
				<tr>
					<td height="20" width="200" bgcolor="#C0C0C0">
						<p style="font-weight: bold">
							<font color="blue">닉네임</font>
						</p>
					</td>
					<td height="20" >
					<input size=50 maxlength=100 type="text" id="user_nickname"
						name="user_nickname" value="${VIEW.user_nickname}"></td>
				</tr>
				<tr>
					<td height="20" width="200" bgcolor="#C0C0C0">
						<p style="font-weight: bold">사용유무</p>
					</td>
					<td>${VIEW.user_enable}</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input
						class="btn btn-primary btn-md" type="button" id="mBtn"
						value="저장하기" onClick="sendModify()"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>