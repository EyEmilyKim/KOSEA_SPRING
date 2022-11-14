<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
È¯¿µÇÕ´Ï´Ù~ 
	<c:if test="${sessionScope.LOGIN != null }">
		${sessionScope.LOGIN}´Ô~<br/>
	</c:if>
	<c:if test="${sessionScope.MANAGER != null }">
		${sessionScope.MANAGER}´Ô~<br/>
	</c:if>	
	<input type="submit" value="·Î±× ¾Æ¿ô"/>
</form>
</body>
</html>








