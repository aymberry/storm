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
	$(document).ready(function() {
 		$("#rBtn").click(function() {
			//	입력상자에 입력한 내용을 취소하고 다시 기록할 수 
			//	있도록 한다.
			//	JQuery는 폼 전체를 한번에 지우는 기능이 없다.
			//	편법		form에 있는 input를 하나씩 찾아서 지워야 한다.
			//			$("form").each(function(){
			//				this.reset();
			//			});

			//	자바 스크립트는 한번에 지우는 기능이 있다.
			document.form.reset()

		});

		$("#wBtn").click(function() {
			//	무결성 검사(상품번호)
			/* 			$g_no = $("#g_no").val();
			 if ($g_no == "") {
			 alert("상품을 입력해 주세요");
			 return;
			

			 //	무결성 검사(사용자번호)
			 $usr_no = $("#usr_no").val();
			 if ($usr_no == "") {
			 alert("사용자번호를 입력해 주세요");
			 return;
			 } */

			//	무결성 검사(주문수량)
			$sales_qty = $("#sales_qty").val();
			if ($sales_qty == "") {
				alert("주문수량을 입력해 주세요");
				return;
			}

			//	무결성검사(결제계좌)
			$sales_account = $("#sales_account").val();
			if ($sales_account == "") {
				alert("결제계좌를 입력해 주세요");
				return;
			}

			//	무결성검사(은행명)
			$sales_bankname = $("#sales_bankname").val();
			if ($sales_bankname == "") {
				alert("은행명을 입력해 주세요");
				return;
			}

			//	무결성검사(지불자명)
			$payer = $("#payer").val();
			if ($payer == "") {
				alert("지불자명을 입력해 주세요");
				return;
			}

			//	서브밋 시킨다.
			$("#wfrm").submit(); //
		});

		$("#lBtn").click(function() {
			//	GET 방식으로 목록보기를 다시 요청한다.
			$(location).attr("href", "../Sales/SalesList.ust");
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
	<%-- <img src="image1.jpg" alt="image1" width="200" height="300"> --%>

	<div class="container">
		<%--	여기서는 제대로된 주문 폼을 보여준다. --%>
		<form class="form-horizontal" method="POST" id="wfrm"
			action="../Sales/SalesPayProc.ust">
			<%--			<tr>
	우리는 주문한 이는 로그인 한 사람의 아이디를 자동으로 입력하도록
	약속했다.
		
		즉, 세션에 저장된 주문한 사람을 불러와서 입력하도록 한다.
		
		★ 세션에 있는 데이터를 뷰에서 사용하는 방법
		결론
			${sessionScope.키값}
			
			예>		session.setAttribute("ID", "isundol");
			 		
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
 			<div class="form-group">
				<label class="col-sm-2 control-label"> 상품번호 </label> <input
					type="number" name="g_no" id="g_no" value="${g_no}"
					style="background-color: transparent; border: 0 solid black; text-align: left"
					readonly>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label"> 사용자번호 </label> <input
					type="number" name="usr_no" id="usr_no" value="${usr_no}"
					style="background-color: transparent; border: 0 solid black; text-align: left"
					readonly>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label"> 주문일자 </label> <input
					type="date" name="sales_buydate" id="sales_buydate"
					style="background-color: transparent; border: 0 solid black; text-align: left"
					readonly>
			</div>


			<div class="form-group">
				<label class="col-sm-2 control-label"> 주문수량 </label> <input
					type="number" name="sales_qty" id="sales_qty"
					style="background-color: transparent; border: 1 solid black; text-align: left">
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label"> 결제계좌 </label> <input
					type="text" name="sales_account" id="sales_account"
					style="background-color: transparent; border: 1 solid black; text-align: left">
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label"> 은행명 </label> <input
					type="text" name="sales_bankname" id="sales_bankname"
					style="background-color: transparent; border: 1 solid black; text-align: left">
			</div>


			<div class="form-group">
				<label class="col-sm-2 control-label"> 지불자명 </label> <input
					type="text" name="payer" id="payer"
					style="background-color: transparent; border: 1 solid black; text-align: left">
			</div>

			<div class="btn-group">
<%--				<button type="button" class="btn btn-primary" id="rBtn">다시쓰기</button> --%>
				<button type="button" class="btn btn-primary" id="wBtn">주문결제하기</button>
   		<button type="button" class="btn btn-primary" id="lBtn">목록보기</button>
			</div>
	</div>

	</form>
	</div>
	<footer class="Storm-copywrite">
		<p>Storm Project All Rights Reserved.</p>
	</footer>

		</div>
	</section>
</body>
</html>