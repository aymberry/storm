<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

	<link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600' rel='stylesheet' type='text/css' />
	<link href=" ${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css" media="screen" />

	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		if(${DOLOGIN != null}){
			alert("�α����ϼ���");
		}
		$("#lBtn").click(function(){
					$("#lfrm").submit();
		});
	});
</script>
<body>
	<div style="position: absolute; top: 10px; right:50px">
  		<a href="../Member/MemberForm.storm">ȸ������&nbsp;&nbsp;</a>
		<c:if test="${empty sessionScope.UID}">
		<a href="../Login/LoginForm.storm" class="selected">�α���</a><br>
		</c:if>
		<c:if test="${not empty sessionScope.UID}">
		<a href="./Login/Logout.storm" class="selected">�α׾ƿ�</a><br>
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
			<li><a href="/storm">Ȩ</a></li>
			<li><a id="gameSearch" href="/storm/App/AppList.storm">���Ӱ˻�</a></li>
			<li><a href="/storm/Chart/ChartView.storm">���Ӻм�</a></li>
			<li><a href="/storm/Commu/CommuMain.storm">Ŀ�´�Ƽ</a></li>
			<li><a href="/storm/Mypage/MypageList.storm">����������</a></li>
		</ul>
	</div>
	<!-- end #menu -->
	<!-- ���� -->
	<div id="page">
	
 <div class="w3-container w3-amber" >
 <h2>Please Log In</h2>
 </div>
  <form class="w3-container" Id="lfrm" method="POST" action="../Login/LoginProc.storm" >
        <div class="w3-section">
          <label><b>ID</b></label>
          <input class="w3-input" type="text" name="id" placeholder="�̸����� �Է��ϼ���" required>
          <label><b>Password</b></label>
          <input class="w3-input" type="password" name="pw" placeholder="��й�ȣ�� �Է��ϼ���" required>
      
          <input type="button" class="w3-button w3-block w3-amber w3-section w3-padding" id="lBtn"  value="Login" />
          
        </div>
      </form>
      
      	<!-- ������ #page --> 
</div>

<div id="footer">
	<p>&copy; Untitled. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a> | Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</p>
</div>
<!-- end #footer -->

</body>
</html>










