<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!-- <link rel="stylesheet" href="../css/commu/css/main.css" />
		<style>#change:hover{opacity:0.6}
		</style> -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  	h2{
  		color:silver
  	}
  	th{
  		color:silver
  		
  	}
  	td{
  		color:silver
  	}
  </style>
</head>
<body>
	<jsp:include page="../../view/main/header.jsp" flush="true" />
	<section class="main clearfix" style="background-color:black;">
		<jsp:include page="../../view/main/logo.jsp" flush="true" />
		<div>
				<table width="100%">
				<tr height="50">
					<td></td>
				</tr>
			</table>
			<!-- Main -->
				<div id="main">
					<div class="inner">

					<!-- Boxes -->
						<div class="thumbnails">
<c:if test="${empty MyLIST}">
	<table width="1000" border="1" align="center">
		<tr>
			<td align="center">
				<h3><font color=silver>구매내역이 없습니다.</font></h3>
			</td>
		</tr>
	</table>
</c:if>
	<c:if test="${not empty MyLIST}">
		
							<%-- <div class="box"  style="cursor: pointer;  color:silver; background-color:#0B091C;" onclick="location.href='../Commu/CommuView.ust?commuNo=${data.commuNo}&nowpage=${PINFO.nowPage}'"> --%>
						<%-- 	<div class="box"  style="cursor: pointer;  color:silver; background-color:#0B091C;" onclick="location.href='#'">
								<!-- <div id="change">  -->
								<div> 
									<h2>${data. g_no}</h2>
								</div>
								<!-- <div class="inner"> -->
								<div>
									<h2>${data. g_name}</h2>
									<h2>${data.g_price}</h2>
									<h2>${data.sales_buydate}</h2>
								</div>
							</div> --%>
<div class="container">
  <h2><font color=silver>구매 목록</font></h2>

  <table class="table">
    <thead>
      <tr>
        <th>상품번호</th>
        <th>상품명</th>
        <th>가격</th>
        <th>구입날짜</th>
      </tr>
    </thead>
  <c:forEach var="data" items="${MyLIST}">    
    <tbody>
      <tr>
        <td>${data. g_no}</td>
        <td>${data. g_name}</td>
        <td>${data.g_price}</td>
        <td>${data.sales_buydate}</td>
      <td><a href="../My/DownloadProc.ust">다운로드</a></td>
      </tr>
    </tbody>
</c:forEach>
  </table>
</div>
							

	</c:if>
		</div>
					</div>
				</div>
		</div>
	</section>
</body>
</html>




