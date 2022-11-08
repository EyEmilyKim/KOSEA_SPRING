<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과일 목록 화면</title>
<link rel="stylesheet" type="text/css" href="css/3-5.css">
</head>
<body>
<%@ include file="/WEB-INF/jsp/menu_header.jsp" %>
<div align="center" class="body">
	<h2>과일 목록 화면</h2>
	<table border="1">
		<tr class="header">
			<th align="center" width="80">상품번호</th>
			<th align="center" width="320">상품이름</th>
			<th align="center" width="100">가 격</th></tr>
		<c:forEach items="${itemList }" var="item">
		<tr class="record">
			<td align="center">${item.itemId }</td>
			<td align="center">
				<a href="../detail/detail.html?itemId=${item.itemId }">${item.itemName }</a></td>
			<td align="center">${item.price }</td></tr>
		</c:forEach>
	</table>
</div>
</body>
</html>