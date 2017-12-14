<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
	<link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600' rel='stylesheet' type='text/css' />
	<link href=" ${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css" media="screen" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">


 



 //유효성검사
function checkfield(){
 
 if(document.addjoin.id.value==""){ //id값이 없을 경우
 alert("아이디를 입력하세요");         //메세지 경고창을 띄운 후
 document.addjoin.id.focus();     // id 텍스트박스에 커서를 위치
 exit;
 
 }else if(document.addjoin.pw.value==""){
 alert("비밀번호를 입력하세요");
 document.addjoin.pw.focus();
 exit;
 
 }else if(document.addjoin.pw2.value==""){
 alert("비밀번호확인을 입력하세요");
 document.addjoin.pw2.focus();
 exit;
 
 }else if(document.addjoin.nick.value==""){
 alert("닉네임을 입력하세요");
 document.addjoin.nick.focus();
 exit;
 
 }
 
 
 if(document.addjoin.pw.value!=document.addjoin.pw2.value){
 //비밀번호와 비밀번호확인의 값이 다를 경우
 
 alert("입력한 2개의 비밀번호가 일치하지 않습니다.");
 document.addjoin.pw.focus();
 exit;
 
 }
 
 
 var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
 
 if(exptext.test(document.addjoin.id.value)==false){
 //이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐경우
 
 alert("이 메일형식이 올바르지 않습니다.");
 document.addjoin.id.focus();
 exit;
 }
 
 else if(document.addjoin.checkbtn.value==""){
	 alert("중복검사 체크하세요");
	 document.addjoin.checkbtn.focus();
	 exit;
 
 }
 
 document.addjoin.submit();
 
}


 
 //중복검사

$(document).ready(function(){
    $('#checkbtn').on('click', function(){
   
        $.ajax({
            type: 'POST',
            url: 'Member/CheckProc.storm',            
            data: {
                "id" : $('#id').val()
            },            
            success: function(data, statusText, xhr){
            	console.log(data + ", " + statusText);
               
            	if($.trim(data) == 0){
                    $('#checkMsg').html('<p style="color:blue">사용가능</p>');
                }
                else{
                    $('#checkMsg').html('<p style="color:red">사용불가능</p>');
                }
            },
            error : function(xhr, statusText, error) {
          		console.log("에라 : " + statusText + ", " + error);
            }
        });    //end ajax        
        
    });    //end on    
});





</script>





</head>
<body>
		  <div style="position: absolute; top: 10px; right:50px">
  			<a href="../Member/MemberForm.storm">회원가입&nbsp;&nbsp;</a>
		<c:if test="${empty sessionScope.UID}">
		<a href="../Login/LoginForm.storm" class="selected">로그인</a><br>
		</c:if>
		<c:if test="${not empty sessionScope.UID}">
		<a href="../Login/Logout.storm" class="selected">로그아웃</a><br>
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
			<li><a href="/storm">홈</a></li>
			<li><a id="gameSearch" href="/storm/App/AppList.storm">게임검색</a></li>
			<li><a href="/storm/Chart/ChartView.storm">게임분석</a></li>
			<li><a href="/storm/Commu/CommuMain.storm">커뮤니티</a></li>
			<li><a href="/storm/Mypage/MypageList.storm">마이페이지</a></li>
		</ul>
	</div>
	<!-- end #menu -->
	<!-- 본문 -->
	<div id="page">
	
 
 <div class="w3-container w3-amber" >
 <h2>Please Sign up</h2>
</div>

 
<form class="w3-container w3-card-4" action="../Member/MemberProc.storm" name="addjoin" methid="post">

<p>
<label>E-Mail</label>
<tr>
<div><input class="w3-input" type="text" style="width:90%" required name="id" id="id"  placeholder="이메일을 입력하세요"><button class="w3-button w3-section w3-amber w3-round-xxlarge 	
w3-dark-grey w3-ripple"  id="checkbtn"> Check </button></div>
<div id="checkMsg"></div>

<p>
<label>Password</label>
<input class="w3-input" type="password" style="width:90%" required name="pw" id="pw" placeholder="비밀번호를 입력하세요">
</p>
<p>
<label>Re-Password</label>
<input class="w3-input" type="password" style="width:90%" required name="pw2" id="pw2" placeholder="비밀번호를 확인하세요">
</p>

<p>
<label>Nick-Name</label>
<input class="w3-input" type="text" style="width:90%" required name="nick" id="nick" placeholder="이름을 입력하세요">
</p>


<p>
<input type="button" class="w3-button w3-block w3-amber w3-section w3-padding" onclick="checkfield()" value="Sign UP" />
</p>
</form>

    

<!-- <label for="email">이메일 주소</label>
<input type="email" class="form-control" id="id" name="id" placeholder="이메일을 입력하세요"/>
<div id="checkMsg"></div>
 
<button type="submit" id="checkbtn" class="btn btn-default">중복확인</button> -->

<!-- 본문 -->



	<!-- 본문끝 #page --> 
</div>

<div id="footer">
	<p>&copy; Untitled. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a> | Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</p>
</div>
<!-- end #footer -->
</body>
</html>
