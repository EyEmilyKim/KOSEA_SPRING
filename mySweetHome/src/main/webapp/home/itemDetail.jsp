<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" 
	prefix="fmt" %>	   
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2>상품 상세 정보</h2>
<form:form action="../item/modify.html" method="post"
	modelAttribute="item" onSubmit="return check(this)">
<table width="100%">
	<tr><th>상품 번호</th>
		<td><form:input path="code" name="CODE" readOnly="readOnly"/></td></tr>
	<tr><th>상품 이름</th>
		<td><form:input path="name" name="NAME"/></td></tr>
	<tr><th>상품 가격</th>
		<td><form:input path="price" name="PRICE"/></td></tr>
	<tr><th>등록일</th>
		<td>${ITEM.reg_date }</td></tr>
	<tr><th>설 명</th>
		<td><form:textarea rows="5" cols="40" path="info"></form:textarea></td></tr>
	<c:if test="${sessionScope.MANAGER != null }">		
	<tr><td colspan="2" align="center">
		<input type="submit" value="삭제" name="BTN"/>
		<input type="submit" value="수정" name="BTN"/></td></tr>
	</c:if>
</table>
</form:form>
</div>
<script type="text/javascript">
function check(frm){
// 	if(frm.NAME.value == ''){
// 		alert("상품이름을 입력하세요."); return false;
// 	}
// 	if(frm.PRICE.value == ''){
// 		alert("가격을 입력하세요."); return false;
// 	}else{
// 		if(isNaN(frm.PRICE.value)){
// 			alert("가격은 숫자로 입력하세요."); return false;
// 		}
// 	}
// 	if(frm.INFO.value == ''){
// 		alert("상품 설명을 입력하세요."); return false;
// 	}
	if( ! confirm("작업을 진행하시겠습니까?")) return false;
}
</script>
</body>
</html>









