<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<h2>공지사항 쓰기</h2>
<form:form action="../notice/noticeInput.html" method="post" 
		modelAttribute="notice" onSubmit="return check()">
	<table>
		<tr><th>제 목</th>
			<td><form:input path="title" size="20" placeHolder="제목을 입력하세요."/>
				<font color="red"><form:errors path="title"/></font>
			</td></tr>
		<tr><th>내 용</th>
			<td><form:textarea rows="6" cols="40" path="content" placeHolder="내용을 입력하세요."></form:textarea>
				<font color="red"><form:errors path="content"/></font>
			</td></tr>
		<tr><td colspan="2" align="center"><input type="submit"
			value="공지글 올리기"/> 
			<input type="reset" value="취 소"/></td></tr>
	</table>
</form:form>
</div>
<script type="text/javascript">
function check(){
// 	if(fm.TITLE.value == ''){
// 		alert("제목을 입력하세요."); return false;
// 	}else{
// 		if(fm.TITLE.value.length > 30){
// 			alert("30자 이내로 작성하세요"); return false;
// 		}
// 	}
// 	if(fm.CONTENT.value == ''){
// 		alert("내용을 입력하세요."); return false;
// 	}else{
// 		if(fm.CONTENT.value.length > 100){
// 			alert("100자 이내로 작성하세요.");return false;
// 		}
// 	}
	if( ! confirm("정말로 올리시겠습니까?"))
			return false;
}
</script>
</body>
</html>