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
<div align="center">
<c:choose>
	<c:when test="${NOID == 'YES' }">
		<h3 align="center">������ �������� �ʽ��ϴ�.</h3>
	</c:when>
	<c:when test="${NOPWD == 'YES' }">
		<h3 align="center">��ȣ�� ��ġ���� �ʽ��ϴ�.</h3>
	</c:when>
	<c:otherwise>
		<h3 align="center">�α��� �Ǿ����ϴ�.</h3>
		<h3 align="center">ȯ���մϴ�~ ${sessionScope.LOGIN }��~</h3>
	</c:otherwise>
</c:choose>
</div>
</body>
</html>





