<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Document</title>
</head>
<body>
	<jsp:include page="../../view/main/header.jsp" flush="true" />
	<section class="main clearfix" style="background-color:black">
		<jsp:include page="../../view/main/logo.jsp" flush="true" />
		<div>
			<table width="100%">
				<tr height="50">
					<td></td>
				</tr>
			</table>
<%-- 			<table	border="1">
  			<tr>
	  				
  			</tr>
  		<c:forEach	var="data"	items="${GOODS_LIST}">
  			<tr>
  				<td>
  					<a	href="../Goods/GoodsDetailView.ust?GOODS_NO=${data.no}">
	  					<div class="goods"	id="goods${data.no}">
	  						<input type="hidden" id="goodsNo${data.no}" value="${data.no}">
	  						<div	id="thumnail${data.no}">			<img src="">			</div>
	  						<div	id="name${data.no}">				${data.name}			</div>
	  						<div	id="type${data.no}">				${data.type}			</div>
	  						<div	id="releaseDate${data.no}">			${data.releaseDate}		</div>
	  						<div	id="price${data.no}">				${data.price}원			</div>
	  						<div	id="os${data.no}">					${data.os_name}			</div>
	  						<c:forEach var="tag"	items="${data.tag_list}">
	  			  				<div class="tags${data.no}" id="tag${tag.tag_no}">
	  			  														${tag.tag_name}			</div>
	  			  			</c:forEach>
	  						<!--  ${data.no}-->  						
	  						<!--${data.type_no }-->
	  						<!--  ${data.registDate}--> 						
		  					<!--${data.smallText}-->
		  					<!--  ${data.bigText}-->
		  					<!--${data.installFileName }-->
	  			  		</div>
  			  		</a>
  			  	</td>
  			</tr>
  		</c:forEach>
  		</table> --%>
  	<c:forEach	var="data"	items="${GOODS_LIST}">
  	<div align="center">
  	<a	href="../Goods/GoodsDetailView.ust?GOODS_NO=${data.no}&USER_ID=${sessionScope.UID}">
		<table style="height:180px; width: 90%; background-color:#001638;">
			<tr><td>
     <input type="hidden" id="goodsNo${data.no}" value="${data.no}">
      <div class="row">
        <div class="col-sm-2 text-center">
    		 <img src="../img/GoodsImg/${data.img_name}"  height="180" alt="구매상품사진" align="left">
   	 	</div>

			<br>
          <h4>${data.name}  <small> &nbsp;&nbsp;${data.price}원</small> &nbsp;&nbsp;가능OS : ${data.os_name}<br><small>태그 :
          		<c:forEach var="tag"	items="${data.tag_list}">
         		 <div class="tags${data.no}" id="tag${tag.tag_no}" style="display:inline;"> ${tag.tag_name}</div>
	  			</c:forEach></small> </h4>
          <p>${data.smallText}</p>
	        <br>

	        </a>
	   </div>
	   </td> </tr>
      </table>
      <br>
      </div>
	 </c:forEach>	
  
  

		</div>
	</section>
</body>
</html>




