<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="STVo.*"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Document</title>
</head>
<script>
	function CheckSend() {

		var frm = document.getElementById("lfrm");

		frm.submit();

	}
	
</script>


<body>
	<header></header>
	<div class=nav></div>

	<%
		STMemberVo mVO = (STMemberVo) session.getAttribute("USER");
	%>
	<%
		if (mVO == null) {
	%>
	<div class="LoginForm" >
		<form method="POST" id="lfrm" action="./STLoginProcess.ust">
			<table border="0" width="300" height="150" align="center" bgcolor="#0B3861" >
			
			<tr>
				<td width="150" >Storm account name</td>
			    <td width="150"></td>
			
			</tr>
			
			<tr>
				
				<td td width="150"><input type="text" name="id" id="id"></td>
				 <td td width="150"></td>
			</tr>		
			
			<tr>
		        <td td width="150">Password</td>
			    <td td width="150"></td>
			</tr>
			
			
			<tr>
				
				<td td width="150"><input type="password" name="pw" id="pw"></td> 
				 <td td width="150"></td>
			</tr>		
			<tr>
				<td align="center">
					<input type="button" value="Log in" onClick="CheckSend()">
				</td>
				
				<td rowspan="4" align="center">
					<input type="button" value="Join storm" onClick="">
				</td>
				
				
				
			</tr>		
		</table>
	</form>
         <aside width="500"></aside>
		</form>
	</div>



	<%
		} else {
			//	닉네임을 보여주도록 한다.
	%>
	<table border="0" width="300" height="150" align="center" bgcolor="#0B3861">
		<tr>
			<td align="center" ><%=mVO.getEname()%> 님 환영합니다.</td>
		</tr>
		<tr>
			<td align="center" height="100"><a href="../index.jsp">Main</a> <a
				href="./STLogoutProcess.ust">Logout</a></td>
		</tr>
	</table>
	<%
		}
	%>
	
	<div class=footer></div>
	
</body>
</html>





