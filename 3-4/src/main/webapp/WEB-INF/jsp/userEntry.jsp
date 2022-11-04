<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center" class="body">
<h2>회원 가입</h2>
<form:form modelAttribute="user" method="post" action="userEntry.html">
<spring:hasBindErrors name="">
	<font color="red">
		<c:forEach items="${errors.globalErrors }" var="err">
			<spring:message code="${err.code }"/>
		</c:forEach>
	</font>
</spring:hasBindErrors>
<table>
	<tr height="40px"><th>가입자ID</th>
		<td><form:input path="userId" maxlength="20" cssClass="userId"/>
			<font color="red"><form:errors path="userId"/></font></td></tr>
	<tr height="40px"><th>암 호</th>
		<td><form:password path="password" maxlength="20" cssClass="password"/>
			<font color="red"><form:errors path="password"/></font></td></tr>
	<tr height="40px"><th>이 름</th>
		<td><form:input path="userName" maxlength="30" cssClass="userName"/>
			<font color="red"><form:errors path="userName"/></font></td></tr>
	<tr height="40px"><th>주 소</th>
		<td><form:input path="address" maxlength="50" cssClass="address"/>
			<font color="red"><form:errors path="address"/></font></td></tr>
	<tr height="40px"><th>이메일</th>
		<td><form:input path="email" maxlength="50" cssClass="email"/>
			<font color="red"><form:errors path="email"/></font></td></tr>
	<tr height="40px"><th>직 업</th>
		<td><form:select path="job" cssClass="job">
				<form:option value="회사원" label="회사원"/>
				<form:option value="학생" label="학생"/>
				<form:option value="주부" label="주부"/>
				<form:option value="기타" label="기타"/>
			</form:select></td></tr>
	<tr height="40px"><th>생년월일</th>
		<td><form:input path="birthday" maxlength="10" cssClass="birthday"/>
			<font color="red"><form:errors path="birthday"/></font></td></tr>
</table>
<table>
	<tr><td height="40px" align="center">
		<input type="submit" value="회원가입"/></td>
		<td height="40px" align="center">
		<input type="reset" value="취 소"/></td></tr>
</table>
</form:form>
</div>
</body>
</html>