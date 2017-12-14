<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Document</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	$(document).ready(function()
	{
		$("#buyButton").click(function()
		{
			$("#bfrm").submit();
		});
	});
</script>  
<body bgcolor="white">
	<jsp:include page="../../view/main/header.jsp" flush="true" />
	<section class="main clearfix" style="background-color:black">
		<jsp:include page="../../view/main/logo.jsp" flush="true" />
		<br><br>
		<div	id="content">
			<table>
				<tr>
				<c:if	test="${not empty sessionScope.UID}">
  							<h4>댓글쓰기</h4>
  								<form role="form"	action="../Goods/CommentWriteProcess.ust">
  									<input type="hidden" id="gno" name="gno" value="${REVIEW_DETAIL.goods_no}">
  									<input type="hidden" id="originUID" name="originUID" value="${REVIEW_DETAIL.user_no}">
  									<input type="hidden"	id="writerNo"	name="writerNo"	value="${sessionScope.UID}">
    								<div class="form-group">
      									<textarea class="form-control" id="content" name="content" rows="3" required></textarea>
    								</div>
    								<button type="submit" class="btn btn-success">Submit</button>
  								</form>
  							<br><br>
				</c:if>
			</tr>
			
			
				<tr>
					<table style="width: 100%; border: 0px solid gray;" >
						<tr>
							<td>
							<div class="row">
							<div class="col-sm-2 text-center">
								<img src="../img/commu/iyou.jpg" class="img-circle" height="150" width="150" alt="Avatar">
 							</div>
 							<div class="col-sm-10">
 								<h4>
 									<small>닉네임 :</small>${REVIEW_DETAIL.user_nickname}
 									<small>구매한 제품 :</small>${REVIEW_DETAIL.goods_name} &nbsp;&nbsp;<br>
 									<small>${REVIEW_DETAIL.wdate} &nbsp;&nbsp; 평가점수 : ${REVIEW_DETAIL.score}</small>
 								</h4>
     							<p>${REVIEW_DETAIL.content}</p>
									<br>
						
  									</div>
							</div>
						</td>
					</tr>
				</table>
			</tr>
			</table>
		</div>
		<div>
			
		</div>
		<br><br>
		<div	id="comments">
			댓글
			<%-- <c:forEach	var="comment"	items="${REVIEW_DETAIL.commentList}" varStatus="i">
				<table	id="comment${i.index}" width="800" align="center" border="1" style="background-color:white">
					<tr>
						<td>	작성자	</td>
						<td>	${comment.writer_name}</td>
						<td>	작성일	</td>
						<td>	${comment.wdate}	</td>
					</tr>
					<tr>
						<td>	내용	</td>
						<td colspan="3">
							${comment.content}
						</td>
					</tr>				
				</table>
			</c:forEach> --%>
			<table width="100%" align="center" style="color:silver;background-color:#151515">
				<tr height="30" style="border-bottom: 2px solid gray">
					<th style="vertical-align:middle"	width="8%">	작성자	</th>
					<th style="vertical-align:middle"	width="84%">	내용		</th>
					<th style="vertical-align:middle"	>	작성일	</th>
				</tr>
				
				<c:forEach	var="comment"	items="${REVIEW_DETAIL.commentList}" varStatus="i">
					<tr	id="comment${i.index}"  style="border-bottom: 1px dotted #ccc" height="50" >
						<td	style="vertical-align:middle" 	width="8%">${comment.writer_name}</td>
						<td style="vertical-align:middle"	width="84%">${comment.content}</td>
						<td style="vertical-align:middle">${comment.wdate}</td>
					</tr>			
				</c:forEach>
			</table>
		</div>
		
		<div	id="footer">
		</div>
	</section>
</body>
</html>