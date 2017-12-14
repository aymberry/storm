<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Document</title>
			<meta name="viewport" content="width=device-width, initial-scale=1" />
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$(".fbt").click(function() {
		var whatdo = $(this).attr("data-1");
		$(location).attr("href", "../Commu/CommuFollow.ust?whatdo="+whatdo+"&data2=${CLIST.commuNo}&nowpage=${NOWPAGE}");
		});
		$("#clbtn").click(function(){
			//	목록보기 요청을 하면 된다.
			$(location).attr("href", "../Commu/CommuList.ust?nowPage=${NOWPAGE}");
		});
	});
</script>
<body>
<jsp:include page="../../view/main/header.jsp" flush="true" />
	<section class="main clearfix" style="background-color:black; color:silver;" >
		<jsp:include page="../../view/main/logo.jsp" flush="true" />
		<div align="center">
			<table width="100%">
				<tr height="50">
					<td></td>
				</tr>
			</table>
  
<!-- 		<tr>
			<th>커뮤니티번호</th>
			<th>이름</th>
			<th>소개</th>
			<th>사진파일</th>
			<th>만든이번호</th>
		</tr> -->
		<table width="1000" border="1">
		<tr>
				<%--	컨트롤로에서 정보받기	--%>
			<td><img src="../img/commu/${CLIST.commuImgName}" width="350"></td>
	 		<td><h1>${CLIST.commuName}</h1>${CLIST.commuText}</td>
<%-- 			<td>${CLIST.commuNo}</td>
			<td>${CLIST.commuUsrNo}</td> --%>
		</tr>

		<%--	상세보기 누를때 컨트롤러에서 리스트가 있는지 없는지 정보받아서 버튼 뛰우기--%>
		</table>
<div align="center">
			<c:if test="${not empty sessionScope.UID and empty SHOWLIST}">
			<input type="button" data-1="add" value="팔로우등록" class="fbt" align="center" style="color:black">
			</c:if>
			<c:if test="${not empty sessionScope.UID and SHOWLIST eq 'N'}">
			<input type="button" data-1="follow" value="팔로우재등록" class="fbt" align="center" style="color:black" >
			</c:if>
			<c:if test="${not empty sessionScope.UID and SHOWLIST eq 'Y'}">
			<input type="button" data-1="unfollow" value="팔로우취소" class="fbt" align="center" style="color:black">
			</c:if>
			<input type="button" id="clbtn" value="커뮤니티목록보기" align="center" style="color:black">
</div>
<div><br><br><br></div>
<%--   	<table width="1000" border="1" align="center">
		<tr>
			<th>상품명</th>
			<th>닉네임</th>
			<th>상품평</th>
			<th>평점</th>
		</tr>
		</table>
		<c:forEach var="review" items="${REVIEWLIST}">
		<table width="1000" border="1" align="center">
		<tr>
			<td>${review.gname}</td>
			<td>${review.nickname}</td>
			<td>${review.content}</td>
			<td>${review.score}</td>
		</tr>
		</table>
		</c:forEach> --%>
		<c:forEach var="review"		items="${REVIEWLIST}">
     <table style="width: 80%; background-color:#001638;">
     <tr><td>
      <div class="row">
        <div class="col-sm-2 text-center">
    		 <img src="../img/GoodsImg/${review.usrimgname}"  height="150" width="150" alt="구매상품사진" align="rigth">
   	 	</div>
 		 <div class="col-sm-2 text-center">
 		 <br> <img src="../img/logo/profile.png" class="img-circle" height="100" width="100" alt="회원사진"align="left">
        </div>
			<br>
          <h4><small>닉네임 :</small>${review.nickname}  <small>구매한 제품 :</small>${review.gname} &nbsp;&nbsp;<small>평가점수 : ${review.score}</small> </h4>
          <p>${review.content}</p>
	        <br>
<%-- 	<a	href="../Goods/ReviewDetailView.ust?g_no=${GOODS_INFO.no}&originUser=${review.user_no}">
	댓글보기	</a> --%>		
  
  
      </div></td>
      </tr>
      </table>
    </c:forEach>
 
		</div>
	</section>


</body>
</html>