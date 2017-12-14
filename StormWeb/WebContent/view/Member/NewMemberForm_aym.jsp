<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 가입</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>

<style>
	textarea#agr {
		width : 99%;
		height : 300px;
	}
	body {background-color : black; }
	table {background-color : black; }
	div {background-color : black; color : silver;}

</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	//이메일 중복 검사
	$(document).ready(function(){
		$("#sBtn").click(function(){
			$("#afrm").submit();
		}
	});
	$(document).ready(function(){
		$("#vBtn1").click(function(){
			var	target = $(this);
			var	id = $("#email").val();
			if(id == "") {
				alert("이메일 주소를 입력하세요");
				return;
			}
			$.ajax({
				url : '../Member/EmailCheck.ust',
				data : 'email=' + id,
				dataType : 'json',
				type : 'get',
				success : function(data) {
					var	result = data.result;
					if(result == "0") {
						alert("사용가능한 이메일입니다.");
					}
					else {
						alert("이미 가입된 이메일입니다.");
						var	tr = target.parent();
						tr = tr.prev();
						tr = tr.children();
						tr.val("");
						tr.focus();
					}
				},
				error : function() {
					alert("나오지 마라");
				}
			});
		});
	});
	
	//닉네임 중복 검사
	$(document).ready(function(){
		$("#vBtn2").click(function(){
			var	target = $(this);
			var	id = $("#nick").val();
			if(id == "") {
				alert("닉네임을 입력하세요");
				return;
			}
			$.ajax({
				url : '../Member/EmailCheck.ust',
				data : 'nick=' + id,
				dataType : 'json',
				type : 'get',
				success : function(data) {
					var	result = data.result;
					if(result == "0") {
						alert("사용가능한 닉네임입니다.");
					}
					else {
						alert("이미 사용하는 닉네임입니다.");
						var	tr = target.parent();
						tr = tr.prev();
						tr = tr.children();
						tr.val("");
						tr.focus();
					}
				},
				error : function() {
					alert("나오지 마라");
				}
			});
		});
	});
</script>

<body>
	<jsp:include page="../../view/main/header.jsp" flush="true" />
	<section class="main clearfix" style="background-color:black;">
		<jsp:include page="../../view/main/logo.jsp" flush="true" />
		<div  style="background-color:black;">
			<table width="100%">
				<tr height="50">
					<td></td>
				</tr>
			</table>
<%-- 회원가입폼 --%>
<div class="container" width="300">
  <br><br><br><br><br>
  <h2>회원가입</h2>
  <br>
  <form method="POST" id="afrm" action="../Member/NewMemberProcess.ust">
    <div class="form-group">
      <label for="email" >이메일</label>
      <input type="email" class="form-control" id="email" name="email">
    </div>
    <button type="button" class="vBtn1 btn-default" id="vBtn1">중복확인</button>
    <div class="form-group">
    <br><br>
      <label for="nick">닉네임</label>
      <input type="text" class="form-control" id="nick" name="nick">
    </div>
    <button type="button" class="vBtn2 btn-default" id="vBtn2">중복 확인</button>
    <div class="form-group">
    <br><br>
      <label for="pw">비밀번호</label>
      <input type="password" class="form-control" id="pw" placeholder="영문,숫자,특수문자 포함 16자리" name="pw">
    </div>
    <div class="pw_re">
      <label for="pw_re">비밀번호 확인</label>
      <input type="password" class="form-control" id="pw_re" name="pw_re">
    </div>
    <br><br>
	<div class="form-group">
	  <label for="agr">회원약관</label>
	  <textarea class="form-control" rows="5" id="comment">약관은 이러하다.</textarea>
	</div>
    <div class="checkbox">
      <label><input type="checkbox" name="remember">동의합니다. 그리고 저는 13세 이상입니다.</label>
    </div>
    <button type="submit" class="btn btn-default" id="sBtn">Submit</button>
  </form>
</div>
		</div>
	</section>
</body>
</html>




