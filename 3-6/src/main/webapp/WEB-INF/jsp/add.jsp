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
<form:form modelAttribute="item" action="register.html"
	mthod="post" enctype="multipart/form-data" name="frm" onsubmit="return check(this)">
<div align="center" class="body">
<h2><font color="green"><spring:message code="itemAdd.title"/></font></h2>
<table>
	<tr height="40px"><th>상품ID</th>
		<td><form:input path="itemId" cssClass="itemId" maxlength="20"/></td></tr>
	<tr height="40px"><th>상품이름</th>
		<td><form:input path="itemName" cssClass="itemName" maxlength="30"/></td></tr>
	<tr height="40px"><th>상품가격</th>
		<td><form:input path="price" cssClass="price" maxlength="6"/>원</td></tr>
	<tr height="40px"><th>이미지 파일</th>
		<td><input type="file" name="pictureUrl"/></td></tr>
	<tr height="40px"><th>상품설명</th>
		<td><form:textarea path="description"/></td></tr>
</table>
<input type="submit" value="등 록"/>
<input type="reset" value="취 소"/><br/><br/>
</div>
</form:form>
<a href="index.html">돌아가기</a>
</body>
<script type="text/javascript">
function check(frm){
	if(frm.itemId.value==''){alert("번호를 입력하세요."); return false;}
	if(frm.itemName.value==''){alert("이름을 입력하세요."); return false;}
	if(frm.price.value==''){alert("가격을 입력하세요."); return false;}
	if(frm.description.value==''){alert("설명를 입력하세요."); return false;}
	if(frm.pictureUrl.value==''){alert("파일을 선택하세요."); return false;}
	if( ! confirm("입력한 내용이 맞습니까?")) return false;
}
</script>
</html>