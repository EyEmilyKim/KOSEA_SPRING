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
<form:form modelAttribute="item" action="delete.html" onSubmit="return deleteConfirm()">
<form:hidden path="itemId"/>
<div align="center" class="body">
<h2><font color="green"><spring:message code="itemDelete.title"/></font></h2>
<table>
<tr height="40px"><th>상품명</th>
	<td><form:input path="itemName" cssClass="itemName" disabled="true"/></td></tr>
<tr height="40px"><th>상품가격</th>
	<td><form:input path="price" cssClass="price" disabled="true"/>원</td></tr>
<tr height="40px"><th>이미지</th>
	<td><img alt="" src="${pageContext.request.contextPath }/upload/${imageName}"
			width="210" height="210" /></td></tr>
<tr height="40px"><th>상품설명</th>
	<td><form:textarea path="description" cssClass="description" disabled="true"/></td></tr>
</table><br/>
<input type="submit" value="삭 제"/><br/>
</div>
</form:form>
<a href="index.html">돌아가기</a>
</body>
<script type="text/javascript">
function deleteConfirm(){
	if( ! confirm("정말로 삭제하시겠습니까?")) return false;
}
</script>
</html>