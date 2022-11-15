<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2>계정 중복 확인</h2>
<form action="../idcheck/idcheck.html" name="idCheck">
<input type="hidden" name="OkId" value="${ID }"/>
계 정 : <input type="text" name="USER_ID"
			value="${ID }"/>
<input type="submit" value="중복 검사"/>
</form>
<c:if test="${ DUP == 'YES' }">
	${ID }는 이미 사용 중입니다. 
	<script type="text/javascript">
		opener.document.fr.ID.value = "";
	</script>
</c:if>
<c:if test="${ DUP == 'NO' }">
	${ID }는 사용 가능합니다.
	<input type="button" value="사용"
		onClick="idOk()"/>
</c:if>
<script type="text/javascript">
function idOk(){
	opener.document.fr.id.value = 
		document.idCheck.OkId.value;
	opener.document.fr.idChecked.value = "OK";
	opener.document.getElementById("ID").readOnly = true;
	self.close();
}
</script>
</div>
</body>
</html>








