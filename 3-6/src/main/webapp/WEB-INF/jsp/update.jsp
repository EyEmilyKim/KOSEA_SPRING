<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="item" action="update.html" 
	method="post" enctype="multipart/form-data">
<form:hidden path="itemId"/>
<form:hidden path="pictureUrl"/>
<div align="center" class="body">
<h2><font color="green"><spring:message code="itemEdit.title"/></font></h2>
<table>
<tr height="40"><th>상품명</th>
	<td><form:input path="itemName" cssClass="itemName" maxlength="20"/></td></tr>
<tr height="40px"><th>상품가격</th>
	<td><form:input path="price" cssClass="price" maxlength="8"/>원</td></tr>
<tr height="40px"><th>이미지 파일</th>
	<td><input type="file" name="pictureUrl"/></td></tr>
<tr height="40px"><th>상품설명</th>
	<td><form:textarea path="description" cssClass="description"/></td></tr>
</table><br/>
<input type="submit" value="변 경"/>
<input type="reset" value="취 소"/><br/>
</div>
</form:form>
<a href="index.html">돌아가기</a>
</body>
</html>