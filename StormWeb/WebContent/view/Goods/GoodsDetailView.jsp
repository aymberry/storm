<%-- <%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Document</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		$("#buyButton").click(function(){
			$("#bfrm").submit();
		});
	});
</script>
<body>
	<jsp:include page="../../view/main/header.jsp" flush="true" />
	<section class="main clearfix">
		<jsp:include page="../../view/main/logo.jsp" flush="true" />
		<div>
			<table width="100%">
				<tr height="50">
					<td></td>
				</tr>
			</table>
<div	id="header">
		<h1>헤더다아아아아아</h1>
	</div>
	
	<div	id="content">
		<div id="page">
			<div id="topDetail">
				<div	id="gameName">
					<h1>${GOODS_INFO.name}</h1>
				</div>
				<div	id="smallText">
					${GOODS_INFO.smallText}
				</div>
				<div>
					사용자 평가:	총 ${GOODS_INFO.reviewCnt}개의 사용자 평가가 있습니다.
				</div>
				<div	id="userAvgScore">
					사용자 평균 점수 : ${GOODS_INFO.avgScore}점
				</div>
				<div	id="reviewCount">
					총 <% %>개의 사용자 평가가 있습니다.
				</div>
				<div	id="smallText">
					${GOODS_INFO.smallText}
				</div>
				<div	id="releaseDate">
					출시 날짜:${GOODS_INFO.releaseDate}
				</div>
				<div	id="tagList">
					<br>이 제품의 태그<br>
					<c:forEach var="tag"	items="${GOODS_INFO.tag_list}">
						<div id="tag${tag.tag_no}">
									${tag.tag_name}
						</div>
					</c:forEach>
					<br>
				</div>
			</div>
			
			본문 출력부
			<div	id="midDetail">
				<table>
					<tr>
						<th	id="price">	${GOODS_INFO.price}	</th>
						<th	id="buy">
							<input type="button" id="buyButton"	 value="구매하기">							
						</th>
					</tr>
				</table>				
				<div	id="bigText">
					${GOODS_INFO.bigText}
				</div>
			</div>
			
			상품평 출력부
			<div	id="WriteReview">
					
			</div>
			
			<div	id="botDetail">
				<div	id="reviews">
					<table	border="1">
						<c:forEach var="review"		items="${REVIEW_LIST}"		varStatus="status">
							<tr	id	="review${status.index}">
								<td>작성자</td>
								<td>${review.user_nickname}</td>
								<td>작성일</td>
								<td>${review.wdate}</td>
							</tr>
							<tr>
								<td>		제품									</td>
								<td>		${review.goods_name}	</td>
								<td>		구매일									</td>
								<td>		${review.buy_date}			</td>
							</tr>
							<tr>
								<td>점수</td>
								<td colspan="3">${review.score}</td>
							</tr>
							<tr>
								<td>내용</td>
								<td colspan="3">${review.content}</td>
							</tr>
							<tr>
								<td colspan="4">
									<a	href="../Goods/ReviewDetailView.ust?g_no=${GOODS_INFO.no}&originUser=${review.user_no}">
										댓글보기
									</a>									
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div	id="footer">
		<h1>푸터다아아아아아</h1>
	</div>
	<form method="POST" id="bfrm" action="../Sales/SalesOrderForm.ust">
		<input type="hidden" name="g_no" value="${GOODS_INFO.no}">
	</form>

		</div>
	</section>
</body>
</html> --%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
	$(document).ready(function()
	{
		$("#buyButton").click(function()
		{
			$("#bfrm").submit();
		});
	});
</script>  
<style>
</style>
</head>
<body>
	<jsp:include page="../../view/main/header.jsp" flush="true" />
	<section class="main clearfix" style="background-color:black;">
		<jsp:include page="../../view/main/logo.jsp" flush="true" />
		<div>
			<div class="container-fluid">
  				<div class="row content">
				    <div class="col-sm-9">
				          <hr>
				               <table width="1300">
      <tr>
      <th width="300">
      <br>
      <img src="../img/GoodsImg/${GOODS_INFO.img_name}" height="300">
      <br>
      </th>
      <th>
      <div class ="h2" style="display:inline">&nbsp;${GOODS_INFO.name}</div>

	<c:forEach var="tag"	items="${GOODS_INFO.tag_list}">
		<div id="tag${tag.tag_no}" style="display:inline"><span class="label label-danger">&nbsp;&nbsp;${tag.tag_name}</span></div>
	</c:forEach>
		
	     <div class ="h5" >&nbsp;${GOODS_INFO.smallText}</div>
      <h5>&nbsp;&nbsp;사용자 평균 점수 :<span class="label label-primary">${GOODS_INFO.avgScore}</span></h5><br>
      <div	id="bigText">&nbsp;&nbsp;${GOODS_INFO.bigText}</div>
      </th>
      </tr>
      <tr>
      		<div	id="midDetail">

					
						<th	id="price"></th>
						<th	id="buy">
						&nbsp;	가격 ${GOODS_INFO.price}원	&nbsp;&nbsp; <c:if test="${not empty sessionScope.UID}"><input type="button" id="buyButton"	class="btn btn-success" value="구매하기">							
						</c:if></th>
			</div>
	</tr>
	</table>

							<div class="container">
          						<table class="table table-bordered">
									<tbody>
									      <tr>
									      	<td rowspan="2">
									      		<video src="http://cdn.edgecast.steamstatic.com/steam/apps/256685332/movie480.webm?t=1496662148"
									      					controls="controls" height="400" autoplay="autoplay" loop>
									      		</video>
											</td>
											
											<td>
												<img src="http://cdn.edgecast.steamstatic.com/steam/apps/392110/header.jpg?t=1505238403">
											</td>
										</tr>
										<tr>
											<td>
												Endless Space 2 is a strategic space opera, featuring the compelling “just one more turn” gameplay, set in the mysterious Endless universe. As the leader of your civilization, will you impose your vision and build the greatest stellar empire?
												User reviews:
												RECENT:	Mostly Positive (100 reviews)
												OVERALL:	Mostly Positive (2,854 reviews)
												Release Date: 19 May, 2017
												Popular user-defined tags for this product:
												Strategy Space Sci-fi 4X Turn-Based Indie +
											</td>
										</tr>
    								</tbody>
    							 </table>
							</div>

							<c:if	test="${WRITABLE eq true }">
      							<h4>구매평작성</h4>
      								<form role="form"	action="../Goods/ReviewWriteProcess.ust">
      									<input type="hidden" id="gno" name="gno" value="${GOODS_INFO.no}">
      									<input type="hidden" id="uid" name="uid" value="${sessionScope.UID}">
        								<div class="form-group">
        									<table>
        										<tr>
	        										<th>점수</th>
	        									</tr>
	        									<tr>
	        										<td>
	        											<select name="newScore" id="newScore">
	        												<option value="">점수선택</option>
	        												<c:forEach var="i"	begin="1" end="100" step="1">
	        													<option value="${i}">
	        														${i}점
	        													</option>
	        												</c:forEach>
	        											</select>
	        										</td>
	        									</tr>
											</table>
											
          									<textarea class="form-control" id="content" name="content" rows="3" required></textarea>
        								</div>
        								<button type="submit" class="btn btn-success">Submit</button>
      								</form>
      							<br><br>
							</c:if>
							
							<c:forEach var="review"		items="${REVIEW_LIST}"		varStatus="status">
							    	<table style="width: 100%; border: 0px solid gray;">
     									<tr>
     										<td>
      											<div class="row">
	        										<div class="col-sm-2 text-center">
	        											<img src="../img/logo/profile.png" class="img-circle" height="150" width="150" alt="Avatar">
			        								</div>
			        								
								         			<div class="col-sm-10">
	          											<h4>
	          												<small>닉네임 :</small>${review.user_nickname}
	          												<small>구매한 제품 :</small>${review.goods_name} &nbsp;&nbsp;<br>
	          												<small>${review.wdate} &nbsp;&nbsp; 평가점수 : ${review.score}</small>
	          												
	          											</h4>
		    			      							<p>${review.content}<br><br>
		    			      							<a	href="../Goods/ReviewDetailView.ust?g_no=${GOODS_INFO.no}&originUser=${review.user_no}">댓글보기</a>
		    			      							</p>
		        										<!-- <br> -->
																
	  	        									</div>
			      								</div>
	      									</td>
		      							</tr>
      								</table>
    						</c:forEach>
    					</div>
    				 </div>
				</div>
				<form method="POST" id="bfrm" action="../Sales/SalesOrderForm.ust">
					<input type="hidden" name="g_no" value="${GOODS_INFO.no}">
				<input type="hidden" name="g_imgname" value="${GOODS_INFO.img_name}">
				</form>
			</div>
	</section>
</body>
</html>
