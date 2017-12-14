<%@ page contentType="text/html; charset=UTF-8"%>
<%--  주문입력 화면 --%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Document</title>
<style>
div.fixed {
	position: fixed;
	top: 100px;
	left: 300px;
	width: 250px;
	height: 200px;
}

img {
	border-radius: 8px;
}

.btn-default {
	box-shadow: 1px 2px 5px #000000;
}
</style>
</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	$(document)
			.ready(
					function() {

						$("#oBtn")
								.click(
										function() {
											//	수정하기 폼을 요청하면 된다.
											//	파라메터가 두개 있다는 사실 명심하자.
											$(location)
													.attr(
															"href",
															"../Sales/SalesPayForm.ust?g_no=${OLIST.g_no}&usr_no=${OLIST.usr_no}&nowPage=${NOWPAGE}");

										});

					});
</script>
<body>
	<jsp:include page="../../view/main/header.jsp" flush="true" />
	<section class="main clearfix" style="background-color:black; color:silver;">
		<jsp:include page="../../view/main/logo.jsp" flush="true" />
		<div>
			<table width="100%">
				<tr height="50">
					<td></td>
				</tr>
			</table>
<%-- img src="D:\프로젝트\1차프로젝트\1조\이미지\게임\image1.jpg" alt="image1" width="200" height="300" --%>
	<%--	<img src="image1.jpg" alt="image1" width="200" height="300"> --%>
	<div class="container">
   	<img src="../img/GoodsImg/${imgname}" class="img-rounded" alt="이미지" width="200" height="250">
		<%--	여기서는 제대로된 주문 폼을 보여준다. --%>
		<%-- <form method="POST" id="ofrm" action="../Sales/SalesOrderProc.ust"> --%>
		<%--			
	우리는 주문한 이는 로그인 한 사람의 아이디를 자동으로 입력하도록
	약속했다.
		
	즉, 세션에 저장된 주문한 사람을 불러와서 입력하도록 한다.
		
	★ 세션에 있는 데이터를 뷰에서 사용하는 방법
	결론
			${sessionScope.키값}
			
	예>	session.setAttribute("ID", "isundol");	
			${sessionScope.ID}		isundol이 출력된다.
			 		
		문제	우리는 세션에 하나의 데이터만 입력해 놓은 것이 아니고
				VO 전체를 입력해 놓았다.
				
				금요일에 배운 원리를 이용하면 VO의 데이터를 사용하기 
				위해서는 VO 클래스 안에 데이터를 사용할 수 있는
				getXXX()가 필요하다.
		 <input type="text" value="${sessionScope.USER.id}" readonly>
				</td>
			</tr>
--%>

		<form class="form-horizontal">
			<div class="form-group">
				<label class="col-sm-2 control-label"> 상품번호 </label> <input
					type="number" name="g_no" id="g_no" value="${OLIST.g_no}"
					style="background-color: transparent; border: 0 solid black; text-align: left"
					readonly>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">상품명</label> <input type="text"
					name="g_name" id="g_name" value="${OLIST.g_name}"
					style="background-color: transparent; border: 0 solid black; text-align: left"
					readonly>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label"> 출시일자</label> <input
					type="date" name="g_releasedate" id="g_releasedate"
					value="${OLIST.g_releasedate}"
					style="background-color: transparent; border: 0 solid black; text-align: left"
					readonly>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">가격</label> <input
					type="number" name="g_price" id="g_price" value="${OLIST.g_price}"
					style="background-color: transparent; border: 0 solid black; text-align: left"
					readonly>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">상품소개(간략)</label>
				<pre class="pre-scrollable">
				<input type="text" name="g_smalltext" id="g_smalltext"
						value="${OLIST.g_smalltext}"
						style="background-color: transparent; border: 0 solid black; text-align: left"
						readonly>
					</pre>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">상품소개(상세)</label>
				<pre class="pre-scrollable">
				<input type="text" name="g_bigtext" id="g_bigtext"
						value="${OLIST.g_bigtext}"
						style="background-color: transparent; border: 0 solid black; text-align: left"
						readonly>
					</pre>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">설치파일이름</label> <input
					type="text" name="g_installfile_name" id="g_installfile_name"
					value="${OLIST.g_installfile_name}"
					style="background-color: transparent; border: 0 solid black; text-align: left"
					readonly>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">지원운영체제</label> <input
					type="text" name="g_os_name" id="g_os_name"
					value="${OLIST.g_os_name}"
					style="background-color: transparent; border: 0 solid black; text-align: left"
					readonly>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="button" class="btn btn-primary" id="oBtn">주문하기</button>
				</div>
			</div>

		</form>
	</div>

		</div>
	</section>
</body>
</html>



