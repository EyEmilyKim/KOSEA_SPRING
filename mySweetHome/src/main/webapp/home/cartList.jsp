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
<style type="text/css">
#num { width : 50px; }
</style>
</head>
<body>
<div align="center">
	<h2>장바구니 목록</h2>
<c:if test="${CARTLIST == null }">
	<h3>장바구니가 비었습니다.</h3>
</c:if>
<c:if test="${CARTLIST != null }">
	<table>
	<tr><th>상품번호</th><th>상품이름</th><th>가 격</th>
		<th>상품갯수</th>
		<th>합 계</th><th>수정/삭제</th></tr>
	<c:forEach items="${CARTLIST }" var="item">
	<form action="../cart/modify.html" method="post">
	<input type="hidden" name="CODE" value="${item.code }"/>
	<tr><td>${item.code }</td><td>${item.name }</td>
		<td><fmt:formatNumber groupingUsed="true">${item.price }</fmt:formatNumber></td>
		<td><input type="number" name="NUM" min="0" 
			value="${item.num }" id="num"/></td>
		<td><fmt:formatNumber groupingUsed="true">000</fmt:formatNumber></td><td>
			<input type="submit" value="수정" name="BTN"/>
			<input type="submit" value="삭제" name="BTN"/></td></tr>		
	</form>
	</c:forEach>
	</table><br/>
	<form action="">
	총 계 : <fmt:formatNumber groupingUsed="true">
			${TOTAL }</fmt:formatNumber>원 <input type="submit" value="결제하기"/>
	</form>
</c:if>
</div>
</body>
</html>









