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
<form action="../logout/logout.html">
환영합니다~ 
	<c:if test="${sessionScope.LOGIN != null }">
		${sessionScope.LOGIN}님~<br/>
	</c:if>
	<c:if test="${sessionScope.MANAGER != null }">
		${sessionScope.MANAGER}님~<br/>
	</c:if>	
	<input type="submit" value="로그 아웃"/>
</form>
</body>
</html>








