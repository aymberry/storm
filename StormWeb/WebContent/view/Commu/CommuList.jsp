<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="../css/commu/css/main.css" />
		<style>#change:hover{opacity:0.6}
		</style>
	</head>
	<body id="top" style="background-color:black;">
		<jsp:include page="../../view/main/header.jsp" flush="true" />
			<section class="main clearfix" style="background-color:black">
		<jsp:include page="../../view/main/logo.jsp" flush="true" />
		<div>
			<!-- Main -->
				<div id="main">
					<div class="inner">

					<!-- Boxes -->
						<div class="thumbnails">
<c:if test="${empty CLIST}">
	<table width="1000" border="1" align="center">
		<tr>
			<td align="center">
				커뮤니티가 없습니다. 당신이 첫번째 주인공이 되세요
			</td>
		</tr>
	</table>
</c:if>
	<c:if test="${not empty CLIST}">
		<c:forEach var="data" items="${CLIST}">
							<div class="box"  style="cursor: pointer;  color:silver; background-color:#001638;" onclick="location.href='../Commu/CommuView.ust?commuNo=${data.commuNo}&nowpage=${PINFO.nowPage}'">
								<div id="change"> 
								<img src="../img/commu/${data.commuImgName}" alt="" width="380"/>
								</div>
								<div class="inner">
									<h3>${data.commuName}</h3>
									<p>${data.commuText}</p>
								</div>
							</div>
		</c:forEach>
	</c:if>
						</div>
					</div>
				</div>
	<table width="800" border="2" align="center">
		<tr style="color:silver">
			<td align="center">
		<c:if test="${PINFO.startPage eq 1}">
			[이전]
		</c:if>	
		<c:if test="${PINFO.startPage ne 1}">
			<a href="../Commu/CommuList.ust?nowPage=${PINFO.startPage - 1}">[이전]</a>
		</c:if>		
		<c:forEach var="i" begin="${PINFO.startPage}" 
												end="${PINFO.endPage}">
				[<a href="../Commu/CommuList.ust?nowPage=${i}">${i}</a>]								
		</c:forEach>
		<c:if test="${PINFO.endPage eq PINFO.totalPage}">
			[다음]
		</c:if>
		<c:if test="${PINFO.endPage ne PINFO.totalPage}">
			<a href="../Commu/CommuList.ust?nowPage=${PINFO.endPage + 1}">[다음]</a>
		</c:if>
			</td>
		</tr>
	</table>
	<table width="1000" border="2">
		<tr >
			<td align="center">
				<a href="./CommuForm.ust">커뮤니티만들기</a>
			</td>
		</tr>
	</table>
	</div>
</section>
 	</body>


		<!-- Scripts -->
			<script src="../css/commu/js/jquery.min.js"></script>
			<script src="../css/commu/js/jquery.scrolly.min.js"></script>
			<script src="../css/commu/js/jquery.poptrox.min.js"></script>
			<script src="../css/commu/js/skel.min.js"></script>
			<script src="../css/commu/js/util.js"></script>
			<script src="../css/commu/js/main.js"></script>


</html>

