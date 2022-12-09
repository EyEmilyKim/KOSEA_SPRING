<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<c:if test="${message != null}">
	<font color="red" size="2">${message }</font><br/>
</c:if>
<div align="right">
<a href="../home/userentry.html">가입하기</a></div>
<form:form action="../login/cart.html" method="post"
	modelAttribute="member">
계정 : <form:input path="id" size="15" placeHolder="계정을 입력하세요."/>
	<font color="red"><form:errors path="id"/></font><br/>
암호 : <form:password path="pwd" size="15"/>
	<font color="red"><form:errors path="pwd"/></font><br/>
<input type="submit" value="로그인"/>
<input type="reset" value="취 소"/>
</form:form>

</body>
</html>








