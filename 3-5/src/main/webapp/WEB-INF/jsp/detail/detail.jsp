<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과일 상세 정보</title>
<link rel="styleshiie" type="text/css" href="css/3-5.css">
<style type="text/css">
#num {width:30px;} 
</style>
</head>
<body>
<%@ include file="/WEB-INF/jsp/menu_header.jsp" %>
<div align="center" class="body">
<table>
	<tr><td><img alt="" src="../img/${item.pictureUrl }"></td>
		<td align="center">
			<table>
			<tr height="50"><td width="80">상품명</td>
				<td width="160">${item.itemName }</td></tr>
			<tr height="50"><td width="80">가 격</td>
				<td width="160">${item.price }원</td></tr>
			<tr height="50"><td width="80">설 명</td>
				<td width="160">${item.description }</td></tr>
			<tr><td colspan="2" align="center" width="230">
				<form action="../cart/cartAdd.html">
				<input type="hidden" name="itemId" value="${item.itemId}"/>
				<table>
				<tr><td><input type="number" min="1" name="quantity" id="num" value="1"/>
				개</td>
					<td><input type="submit" value="카트에 담기"></td></tr>
				</table>
				</form>
				</td></tr>	
			</table>
		</td></tr>
</table>
</div>
</body>
</html>