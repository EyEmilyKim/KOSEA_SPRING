<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center" class="body">
<h2>ȸ�� ���� �Ϸ� ȭ��</h2>
<b><font color="red">������ �Ϸ�Ǿ����ϴ�~</font></b>
<table>
	<tr height="40px"><th>������ID</th><td>${user.userId }</td></tr>
	<tr height="40px"><th>�� ȣ</th><td>${user.password }</td></tr>
	<tr height="40px"><th>�� ��</th><td>${user.userName }</td></tr>
	<tr height="40px"><th>�� ��</th><td>${user.address }</td></tr>
	<tr height="40px"><th>�̸���</th><td>${user.email }</td></tr>
	<tr height="40px"><th>�� ��</th><td>${user.job }</td></tr>
	<tr height="40px"><th>�������</th><td>${user.birthday }</td></tr>
</table>
</div>
</body>
</html>