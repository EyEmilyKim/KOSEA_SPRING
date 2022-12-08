<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" 
	prefix="fmt" %>	   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<c:if test="${ ! empty ITEMS }">
	<h2>상 품 목 록</h2>
	<table width="100%">
	<tr><th>상품번호</th><th>상품이름</th><th>가 격</th>
		<th>등록일</th><th></th></tr>
	<c:forEach items="${ITEMS }" var="item">
	<tr><td>${item.code }</td>
		<td><a href="itemDetail.do?SEQ=${item.code }">${item.name }</a></td>
		<td><fmt:formatNumber
			groupingUsed="true">${item.price }</fmt:formatNumber></td>
		<td>${item.reg_date }</td>
		<td><a href="#"
			onClick="window.open('addCart.do?CODE=${item.code }','my_cart','width=400,height=300,top=200,left=200')">장바구니 담기</a></td>
	</c:forEach>
	</table>
	<c:forEach begin="1" end="${PAGES }" var="page">
		<a href="itemList.do?PAGE=${page }">${page }</a>
	</c:forEach>
</c:if>
</div>
</body>
</html>









