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
<h2>공지사항 목록</h2>
	<table width="100%">
		<tr><td align="right">${START } ~ ${END } / ${TOTAL }</td></tr>
	</table>
	<table width="100%">
		<tr><th>번 호</th><th>제 목</th><th>작성자</th>
			<th>작성일</th></tr>
		<c:forEach items="${LIST }" var="notice">
		<tr><td>${notice.seqno }</td>
			<td><a href="../notice/detail.html?SEQ=${notice.seqno }">${notice.title }</a></td>
			<td>${notice.writer }</td>
			<td>${notice.reg_date }</td></tr>
		</c:forEach>
	</table>
	<c:forEach begin="1" end="${PAGES }" var="page">
		<a href="../read/readNotice.html?pageNo=${page }">${page }</a>
	</c:forEach>
</div>
</body>
</html>









