<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600' rel='stylesheet' type='text/css' />
<link href=" ${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css" media="screen" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src= "https://cdn.zingchart.com/zingchart.min.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script>

google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart);


function drawChart() {
	  var data = google.visualization.arrayToDataTable([
		    ['Task', 'Hours per Day'],
		    ["${LIST[0].genreName}", ${LIST[0].cnt}],
		    ["${LIST[1].genreName}", ${LIST[1].cnt}],
		    ["${LIST[2].genreName}", ${LIST[2].cnt}],
		    ["${LIST[3].genreName}", ${LIST[3].cnt}],
		    ["${LIST[4].genreName}", ${LIST[4].cnt}],
		    ["${LIST[5].genreName}", ${LIST[5].cnt}],
		    ["${LIST[6].genreName}", ${LIST[6].cnt}],
		    ["${LIST[7].genreName}", ${LIST[7].cnt}],
		    ["${LIST[8].genreName}", ${LIST[8].cnt}]
		  ]);	  

	  var options = {
	    title: '장르별게임수'
	  };
	  var chart = new google.visualization.PieChart(document.getElementById('piechart'));
	  chart.draw(data, options);
	 }
	 
	 
google.charts.load('current', {packages: ['corechart', 'bar']});
google.charts.setOnLoadCallback(drawBasic);
function drawBasic() {
	
    var data = google.visualization.arrayToDataTable([
      ['언어', '언어별게임수',],
      ["${LANG[0].get('LANGUAGENAME')}", ${LANG[0].get('CNT')}],
      ["${LANG[1].get('LANGUAGENAME')}", ${LANG[1].get('CNT')}],
      ["${LANG[2].get('LANGUAGENAME')}", ${LANG[2].get('CNT')}],
      ["${LANG[3].get('LANGUAGENAME')}", ${LANG[3].get('CNT')}],
      ["${LANG[4].get('LANGUAGENAME')}", ${LANG[4].get('CNT')}],
      ["${LANG[5].get('LANGUAGENAME')}", ${LANG[5].get('CNT')}],
      ["${LANG[6].get('LANGUAGENAME')}", ${LANG[6].get('CNT')}],
      ["${LANG[7].get('LANGUAGENAME')}", ${LANG[7].get('CNT')}],
      ["${LANG[8].get('LANGUAGENAME')}", ${LANG[8].get('CNT')}],
      ["${LANG[9].get('LANGUAGENAME')}", ${LANG[9].get('CNT')}],
      ["${LANG[10].get('LANGUAGENAME')}", ${LANG[10].get('CNT')}],
      ["${LANG[11].get('LANGUAGENAME')}", ${LANG[11].get('CNT')}]
    ]);
    var options = {
      title: '지원언어별게임수',
      chartArea: {width: '50%'},
      hAxis: {
        title: '게임수',
        minValue: 0
      },
      vAxis: {
        title: '언어'
      }
    };

    var chart = new google.visualization.BarChart(document.getElementById('chart_div'));
    chart.draw(data, options);
    
   }
//  https://www.zingchart.com/docs/chart-types/wordcloud/

$(function() {
	var myConfig = {
			"graphset":[
			{
			"type":"wordcloud",
			"options":{
			  "style":{
			    "tooltip":{
			      visible: true,
			      text: '%text: %hits'
			    }
			  },
			"words":	${TAG}
			}}]
	};
	zingchart.render({ 
		id: 'myChart', 
		data: myConfig, 
		height: '100%', 
		width: '100%' 
	});
	});

  
  </script>
      
<body>
		  <div style="position: absolute; top: 10px; right:50px">
  			<a href="../Member/MemberForm.storm">회원가입&nbsp;&nbsp;</a>
		<c:if test="${empty sessionScope.UID}">
		<a href="./Login/LoginForm.storm" class="selected">로그인</a><br>
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
			<li class="current_page_item"><a href="/storm/Chart/ChartView.storm">게임분석</a></li>
			<li><a href="/storm/Commu/CommuMain.storm">커뮤니티</a></li>
			<li><a href="/storm/Mypage/MypageList.storm">마이페이지</a></li>
		</ul>
	</div>
	<!-- end #menu -->
	<!-- 본문 -->
	<div id="page">
	
	
	
	
<div style= "width: 1200px; margin:auto;">
 <div id="piechart" style="float:left; width: 600px; height: 600px; align:left;"></div>
  <div id="chart_div" style="display: inline-block; width: 600px; height: 600px; align:right;"></div>
</div>
<div align="center"><h3 style="font-weight: 800;">인기태그</h3></div>
<div id="myChart" style="width: 1200px; height: 600px; margin:auto;"></div>


	<!-- 본문끝 #page --> 
</div>

<div id="footer">
	<p>&copy; Untitled. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a> | Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</p>
</div>
<!-- end #footer -->
</body>
</html>