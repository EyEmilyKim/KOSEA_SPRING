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
<h2>ȸ�� ���� �Է�</h2>
<form:form action="entryMember.do" method="post" name="fr"
		onSubmit="return check(this)" modelAttribute="member">
<input type="hidden" name="idChecked"/>
�� �� : <form:input path="name" /><br/>
�� �� : <form:input path="id" id="ID"/>
<input type="button" value="�ߺ� �˻�" 
		onClick="idCheck()"/><br/>
�� �� : <form:input path="addr"/><br/>
����ó : <form:input path="tel"/><br/>
�� ȣ : <form:input path="pwd"/><br/>
��ȣ Ȯ�� : <input type="password" name="CONF"/><br/>
�� �� : ��<form:radiobutton path="gender" value="M"/>,
	��<form:radiobutton path="gender" value="F"/><br/>
�̸��� : <form:input path="email" /><br/>
�� �� : <form:select path="job">
	<form:option value="--�����ϼ���--"/>
	<form:option value="�л�"/>
	<form:option value="ȸ���"/>
	<form:option value="��Ÿ"/>
		</form:select><br/><br/>
<input type="submit" value="ȸ�� ����"/>
<input type="reset" value="�� ��"/>
</form:form>
</div>
<script type="text/javascript">
function idCheck(){
	if(document.fr.id.value == ""){
		alert("������ �Է��ϼ���."); return;
	}
	var url="../idcheck/idchek.html?USER_ID="+document.fr.id.value;
	window.open(url,"_blank_","width=450,height=250");
}
function check(frm){
	if(frm.name.value == ""){
		alert("�̸��� �Է��ϼ���."); return false;
	}
	if(frm.id.value == ""){
		alert("������ �Է��ϼ���."); return false;
	}
	if(frm.idChecked.value == ""){
		alert("���� �ߺ��˻縦 ���ּ���."); return false;
	}
	if(frm.tel.value == ""){
		alert("����ó�� �Է��ϼ���."); return false;
	}
	if(frm.pwd.value == ""){
		alert("��ȣ�� �Է��ϼ���."); return false;
	}
	if(frm.pwd.value != frm.CONF.value){
		alert("��ȣ�� ��ġ���� �ʽ��ϴ�."); return false;
	}
	if( ! frm.gender[0].checked && 
			! frm.gender[1].checked){
		alert("������ �����ϼ���."); return false;
	}
	if(frm.job.selectedIndex < 1){
		alert("������ �����ϼ���."); return false;
	}
	if( ! confirm("�����Ͻðڽ��ϱ�?")) return false;
}
</script>
</body>
</html>









