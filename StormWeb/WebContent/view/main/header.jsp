<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Document</title>
</head>
<link rel="stylesheet" type="text/css" href="../css/main/reset.css">
<link rel="stylesheet" type="text/css" href="../css/main/main.css">
<body  style="background-color:black;">
	<header style="background-color:black;">
		<section>
		<div class="logo">
			<a href="../main/StormMain.ust"><img src="../img/logo/logo.png" title="Magnetic" alt="Magnetic"/></a>
		</div>
		<div id="menu_icon"></div>
		<nav>
			<ul>
				<c:if test="${empty sessionScope.UID}">
					<li><a href="../member/STLoginForm.ust" class="selected"><font color=silver>Login</font></a></li>
				</c:if>
				<c:if test="${not empty sessionScope.UID}">
					<li><a href="../member/STLogoutProcess.ust" class="selected"><font color=silver>Logout</font></a></li>
				</c:if>
				<li><a href="../Goods/GoodsList.ust"><font color=silver>Goods</font></a></li>
				<li><a href="../Commu/CommuList.ust"><font color=silver>Community</font></a></li>
				<li><a href="../Member/NewMemberForm.ust"><font color=silver>Join Us</font></a></li>
				<c:if test="${not empty sessionScope.UID}">
				<li><a href="../My/MyPageList.ust"><font color=silver>My Page</font></a></li>
				</c:if>
			</ul>
		</nav>
		<div class="footer clearfix">
			<div class="rights">
				<p>Copyright © 2017 Storm.</p>
				<p></p>
			</div>
		</div >
				</section>

	</header>  
</body>
</html>
