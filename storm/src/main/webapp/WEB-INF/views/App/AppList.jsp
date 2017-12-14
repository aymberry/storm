<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
	<style>
			/* DivTable.com */
			.divTable{
				display: table;
				width: 100%;
			}
			.divTableRow {
				display: table-row;
			}
			.divTableHeading {
				background-color: #EEE;
				display: table-header-group;
			}
			.divTableCell, .divTableHead {
				border: 1px;
				border-color: black;
				display: table-cell;
				padding: 3px 10px;
				margin: auto;
			}
			.divTableHeading {
				background-color: #EEE;
				display: table-header-group;
				font-weight: bold;
			}
			.divTableFoot {
				background-color: #EEE;
				display: table-footer-group;
				font-weight: bold;
			}
			.divTableBody {
				display: table-row-group;
			}
	</style>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href=" ${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css" media="screen" />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	$(document).ready(function()
	{
		$("#header").load("../header.jsp");
		$("#searchBar").load("../App/AppSearchForm.storm");
		
	});
</script>

<body>

	  <div style="position: absolute; top: 10px; right:50px">
  			<a href="../Member/MemberForm.storm">ȸ������&nbsp;&nbsp;</a>
		<c:if test="${empty sessionScope.UID}">
		<a href="./Login/LoginForm.storm" class="selected">�α���</a><br>
		</c:if>
		<c:if test="${not empty sessionScope.UID}">
		<a href="./Login/Logout.storm" class="selected"></i> �α׾ƿ�</a><br>
		</c:if>
			</div>

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
			<li><a href="/storm">Ȩ</a></li>
			<li class="current_page_item"><a id="gameSearch" href="/storm/App/AppList.storm">���Ӱ˻�</a></li>
			<li><a href="/storm/Chart/ChartView.storm">���Ӻм�</a></li>
			<li><a href="/storm/Commu/CommuMain.storm">Ŀ�´�Ƽ</a></li>
			<li><a href="/storm/Mypage/MypageList.storm">����������</a></li>
		</ul>
	</div>
	<!-- end #menu -->
	<!-- ���� -->
	<div id="page">




	<form	id="searchForm"	action="../App/SearchProc.storm">
		<div class="container">
	  		<div class="row">
	    		<nav class="col-sm-3">
					<ul class="nav nav-pills nav-stacked"  data-offset-top="205">
						<li class="active">
							<a href="#section1">��ǰ �˻�</a>
						</li>
						<li>
							<a href="#section2">
								<div class="container">
									<font style="margin:0px 10px 0px 0px">�帣�� �˻��ϱ�</font>
									<button type="button" id="genreButton" class="btn btn-info" data-toggle="collapse" data-target="#genreList">
										��ġ��
									</button>
									<div id="genreList" class="collapse">
										<c:forEach	var="GENRE"	items="${GENRE_LIST}"  varStatus="cnt">
											<div>
		  										<input type="checkBox"	name="GENRE_VALUES" value="${GENRE.id}">${GENRE.name}
		  									</div>
		  								</c:forEach>
									</div>
								</div>
							</a>
						</li>
						<li>
							<a href="#section3">
								<div class="container">
									<font style="margin:0px 10px 0px 0px">
										ī�װ��� �˻�
									</font>
									<button type="button" id="categoryButton" class="btn btn-info" data-toggle="collapse" data-target="#categoryList">
										��ġ��
									</button>
									<div id="categoryList" class="collapse">
										<c:forEach	var="CATEGORY"	items="${CATEGORY_LIST}"  varStatus="cnt">
											<div>
												<input type="checkBox"	name="CATEGORY_VALUES" value="${CATEGORY.id}">
													${CATEGORY.name}
											</div>
			  							</c:forEach>
									</div>
							</div>
						</a>
					</li>
					<li>
						<a href="#section4">
							<div class="container">
									<font style="margin:0px 40px 0px 0px">
										�±׷� �˻�
									</font>
									<button id="tagButton" type="button" class="btn btn-info" data-toggle="collapse" data-target="#tagList">
										��ġ��
									</button>
									<div id="tagList" class="collapse">
										<br>
										<div class="input-group">
											<input type="text" id="tagSearchText" placeholder="�� ���� �±�ã��"  style="width:150px;">
											<input type="button" 	id="tagSearchButton" value="�±װ˻�">
											<script>
												$(document).ready(function(){
													$("#tagButton").click(function(){
														var temp = $("#tagButton").text();
														var real = $.trim(temp);

														if(real == '��ġ��')
															$("#tagButton").text("��   ��");
														else
															$("#tagButton").text("��ġ��");
													});
													
													$("#genreButton").click(function(){
														var temp = $("#genreButton").text();
														var real = $.trim(temp);

														if(real == '��ġ��')
															$("#genreButton").text("��   ��");
														else
															$("#genreButton").text("��ġ��");
													});
													
													$("#categoryButton").click(function(){
														var temp = $("#categoryButton").text();
														var real = $.trim(temp);

														if(real == '��ġ��')
															$("#categoryButton").text("��   ��");
														else
															$("#categoryButton").text("��ġ��");
													});
													
													
													$("#tagSearchButton").click(function()	{
														//tagSearchText
														var input =$("#tagSearchText").val();
														
														$.ajax({
														    url: "../App/AjaxTagSearch.storm", // Ŭ���̾�Ʈ�� ��û�� ���� ������ URL �ּ�
														    data: input,                // HTTP ��û�� �Բ� ������ ���� ������
														    type: "POST",                             // HTTP ��û ���(GET, POST)
														    dataType: "JSON",                         // �������� ������ �������� Ÿ��
														    success:function(response){
														    	//alert("����\n"+data);
														    	$("#tagDiv").html("");
														    	
														    	var temp="";
														    	$.each(response, function(index, value){
														    		temp+='<div class="tags"> <input type="checkBox" name="TAG_VALUES" value='+value.id+'>'+value.name+'</div>';
														    	});
														    	$("#tagDiv").html(temp);
															},
															error:function(request, status, error){
																alert(request);
																alert(status);
																alert(error);
															}
														});
													});
												});
											</script>
										</div>
										<div id="tagDiv">
										<c:forEach	var="TAG"	items="${TAG_LIST}"  varStatus="cnt">
												<div class="tags">
												<input type="checkBox"	name="TAG_VALUES"		value="${TAG.id}">
				  									${TAG.name}
				  									</div>
										</c:forEach>
										</div>
									</div>
							</div>
						</a>
					</li>
					<li><!-- �˻� -->
						<a href="#section3">
								<div class="container" >
									<input type="submit" value="�˻�">										
								</div>
						</a>
					</li>
	      		</ul>
	    	</nav>
	    </form>
    <div class="col-sm-9">   
	    <div class="divTable"	>
			<div	class="divTableBody">
				<div	class="divTableRow" >
					
				</div>
				<c:forEach	var="data"	items="${APP_LIST}">
					<div	class="divTableRow" >
					<a	href="../App/AppView.storm?nowPage=${PINFO.nowPage}&app_id=${data.id}">
						<div class="divTableCell" >
							<img src="${data.imgURL}" width="300px" >
						</div><!-- APP IMG -->
						<div class="divTableCell"  style="vertical-align:top">
							
								<h3>${data.cuttedTitle}</h3>
								<br>
								${data.realDate} ���
								<c:if test="${data.price eq 0}">
								����
							</c:if>
							<c:if test="${data.price ne 0}">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<Strong>${data.price}��</Strong>
							</c:if>
						</div>
					</div>
				</a>
				</c:forEach>
			</div>
		</div>
		<nav>
  			<ul class="pagination">
    			<li>
    				<c:if test="${PINFO.startPage eq 1}">
    					<span aria-hidden="true">&laquo;</span>
    				</c:if>
    				<c:if test="${PINFO.startPage ne 1}">
						<a href="../App/AppList.storm?nowPage=${PINFO.startPage-1}" aria-label="Previous">
        					<span aria-hidden="true">&laquo;</span>
      					</a>
					</c:if>
    			</li>
    			<c:forEach var="page" begin="${PINFO.startPage}" end="${PINFO.endPage}">
						<li>
							<a href="../App/AppList.storm?nowPage=${page}">
								${page}
							</a>
						</li>
				</c:forEach>
    		<li>
      			<c:if test="${PINFO.endPage eq PINFO.totalPage}">
					<span aria-hidden="true">&raquo;</span>
				</c:if>
				<c:if test="${PINFO.endPage ne PINFO.totalPage}">
					<a href="../App/AppList.storm?nowPage=${PINFO.endPage+1}" aria-label="Next">
						<span aria-hidden="true">&raquo;</span>
					</a>
				</c:if>      			
    		</li>
  		</ul>
	</nav>
    </div>
  </div>
</div>


	<!-- ������ #page --> 
</div>

<div id="footer">
	<p>&copy; Untitled. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a> | Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</p>
</div>
<!-- end #footer -->
</body>
</html>