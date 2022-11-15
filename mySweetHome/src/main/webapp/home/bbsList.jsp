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
<h2>게시글 목록</h2>
<table width="100%">
	<tr><th>글번호</th><th>제 목</th><th>작성자</th>
		<th>작성일</th></tr>
	<c:forEach items="${bbsList }" var="bbs">
	<tr><td>${bbs.seqno }</td>
		<td><a href="../read/detail.html?NO=${bbs.seqno }">${bbs.title }</a></td>
		<td>${bbs.writer }</td><td>${bbs.reg_date }</td></tr>
	</c:forEach>
</table>
<c:forEach begin="1" end="${pageCount }" var="page">
	<a href="../read/read.html?pageNo=${page }">${page }</a>
</c:forEach>
</div>
</body>
</html>









