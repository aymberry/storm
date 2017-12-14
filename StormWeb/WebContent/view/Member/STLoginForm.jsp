<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>Storm Login</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script>
	
</script>

<body style="background-color:black">
<jsp:include page="../../view/main/header.jsp" flush="true" />
	<section class="main clearfix" style="background-color:black">
		<jsp:include page="../../view/main/logo.jsp" flush="true" />
		<div style="background-color:black">
			<table width="100%" >
				<tr height="50">
					<td></td>
				</tr>
			</table>
<div class="w3-container" style="background-color:black">
  <div class="w3-image w3-center w3-display-middle">
  </br> </br> </br> </br> </br> </br> </br> </br> </br> </br> </br> </br> </br> </br> </br> </br> </br> </br> </br> </br> </br> </br> </br> </br>
  </br></br></br></br></br></br> </br></br></br></br></br></br> </br></br></br></br></br></br>
  <img src="https://www.w3schools.com/w3images/avatar3.png" alt="Avatar" style="width:30%" class="w3-circle w3-section w3-center"></br>
  <button onclick="document.getElementById('id01').style.display='block'" class="w3-button w3-blue-gray w3-large w3-center  w3-round w3-section">이메일로 로그인</button></br>
  <button onclick="document.getElementById('id01').style.display='block'" class="w3-button w3-yellow w3-large w3-center  ">카카오톡 로그인</button></br>
  <button onclick="document.getElementById('id01').style.display='block'" class="w3-button w3-indigo w3-large w3-center  ">페이스북 로그인</button></br>
  <button onclick="document.getElementById('id01').style.display='block'" class="w3-button w3-green w3-large w3-center  ">네이버로 로그인</button>
  </div>
  
  <div id="id01" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:600px">
  
      <div class="w3-center"><br>
        <span onclick="document.getElementById('id01').style.display='none'" class="w3-button w3-xlarge w3-transparent w3-display-topright" title="Close Modal">×</span>
      </div>

      <form class="w3-container" action="../member/STLoginProcess.ust" >
        <div class="w3-section">
          <label><b>ID</b></label>
          <input class="w3-input" type="text" name="id" placeholder="이메일을 입력하세요" required>
          <label><b>Password</b></label>
          <input class="w3-input" type="password" name="pw" placeholder="비밀번호를 입력하세요" required>
          <button class="w3-button w3-block w3-blue-gray w3-section w3-padding" type="submit">Login</button>
          
        </div>
      </form>

      <div class="w3-container w3-border-top w3-padding-16 w3-blue-gray">
      <input class="w3-check w3-margin-top" type="checkbox" checked="checked"> 로그인 상태 유지
       <!-- <button onclick="document.getElementById('id01').style.display='none'" type="button" class="w3-button w3-red">Cancel</button>--> 
        <span class="w3-right w3-padding w3-hide-small w3-light-gray"><a href="../Member/NewMemberForm.ust">회원가입</a></span>
      </div>

    </div>
  </div>
</div>
            
</body>
</html>
	