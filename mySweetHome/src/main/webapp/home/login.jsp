<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="right">
<a href="../home/userentry.html">�����ϱ�</a></div>
<form:form action="../login/template.html" method="post"
	modelAttribute="member">
���� : <form:input path="id" size="15" placeHolder="������ �Է��ϼ���."/>
	<font color="red"><form:errors path="id"/></font><br/>
��ȣ : <form:password path="pwd" size="15"/>
	<font color="red"><form:errors path="pwd"/></font><br/>
<input type="submit" value="�α���"/>
<input type="reset" value="�� ��"/>
</form:form>

</body>
</html>








