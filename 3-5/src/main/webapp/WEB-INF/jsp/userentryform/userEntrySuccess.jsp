<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center" class="body">
<h2>회원 가입 완료 화면</h2>
<b><font color="red">가입이 완료되었습니다~</font></b>
<table>
	<tr height="40px"><th>가입자ID</th><td>${user.userId }</td></tr>
	<tr height="40px"><th>이 름</th><td>${user.userName }</td></tr>
	<tr height="40px"><th>주 소</th><td>${user.address }</td></tr>
	<tr height="40px"><th>이메일</th><td>${user.email }</td></tr>
	<tr height="40px"><th>직 업</th><td>${user.job }</td></tr>
	<tr height="40px"><th>생년월일</th><td>${user.birthday }</td></tr>
</table>
</div>
</body>
</html>