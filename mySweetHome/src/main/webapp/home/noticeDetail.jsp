<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>    
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
	<h3>공지글 상세보기</h3>
	<form:form action="../notice/modify.html" method="post"
			modelAttribute="notice" onSubmit="return check(this)">
	<table width="100%">
	<tr><th>글번호</th>
		<td><form:input path="seqno" readOnly="readonly"/></td></tr>
	<tr><th>제 목</th>
		<td><form:input path="title" /></td></tr>
	<tr><th>작성자</th>
		<td><form:input path="writer" readOnly="readonly"/></td></tr>
	<tr><th>작성일</th>
		<td><form:input path="reg_date" readOnly="readonly"/></td></tr>
	<tr><th>내 용</th>
		<td><form:textarea rows="5" cols="40" path="content"></form:textarea></td></tr>
	<c:if test="${ ! empty sessionScope.MANAGER }">
	<tr><td colspan="2" align="center">
		<input type="submit" value="삭 제" name="BTN"/>
		<input type="submit" value="수 정" name="BTN"/>
		<input type="reset" value="취 소"/></td></tr>
	</c:if>	
	</table>
	</form:form>
</div>
<script type="text/javascript">
function check(frm){
	if(frm.TITLE.value == ''){
		alert("제목을 입력하세요."); return false;
	}
	if(frm.CONTENT.value == ''){
		alert("내용을 입력하세요."); return false;
	}
	if( ! confirm("작업을 진행하시겠습니까?")) return false;
}
</script>
</body>
</html>










