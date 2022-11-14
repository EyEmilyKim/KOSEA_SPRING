<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2>회원 정보 입력</h2>
<form:form action="entryMember.do" method="post" name="fr"
		onSubmit="return check(this)" modelAttribute="member">
<input type="hidden" name="idChecked"/>
이 름 : <form:input path="name" /><br/>
계 정 : <form:input path="id" id="ID"/>
<input type="button" value="중복 검사" 
		onClick="idCheck()"/><br/>
주 소 : <form:input path="addr"/><br/>
연락처 : <form:input path="tel"/><br/>
암 호 : <form:input path="pwd"/><br/>
암호 확인 : <input type="password" name="CONF"/><br/>
성 별 : 남<form:radiobutton path="gender" value="M"/>,
	여<form:radiobutton path="gender" value="F"/><br/>
이메일 : <form:input path="email" /><br/>
직 업 : <form:select path="job">
	<form:option value="--선택하세요--"/>
	<form:option value="학생"/>
	<form:option value="회사원"/>
	<form:option value="기타"/>
		</form:select><br/><br/>
<input type="submit" value="회원 가입"/>
<input type="reset" value="취 소"/>
</form:form>
</div>
<script type="text/javascript">
function idCheck(){
	if(document.fr.id.value == ""){
		alert("계정을 입력하세요."); return;
	}
	var url="../idcheck/idchek.html?USER_ID="+document.fr.id.value;
	window.open(url,"_blank_","width=450,height=250");
}
function check(frm){
	if(frm.name.value == ""){
		alert("이름을 입력하세요."); return false;
	}
	if(frm.id.value == ""){
		alert("계정을 입력하세요."); return false;
	}
	if(frm.idChecked.value == ""){
		alert("계정 중복검사를 해주세요."); return false;
	}
	if(frm.tel.value == ""){
		alert("연락처를 입력하세요."); return false;
	}
	if(frm.pwd.value == ""){
		alert("암호를 입력하세요."); return false;
	}
	if(frm.pwd.value != frm.CONF.value){
		alert("암호가 일치하지 않습니다."); return false;
	}
	if( ! frm.gender[0].checked && 
			! frm.gender[1].checked){
		alert("성별을 선택하세요."); return false;
	}
	if(frm.job.selectedIndex < 1){
		alert("직업을 선택하세요."); return false;
	}
	if( ! confirm("가입하시겠습니까?")) return false;
}
</script>
</body>
</html>









