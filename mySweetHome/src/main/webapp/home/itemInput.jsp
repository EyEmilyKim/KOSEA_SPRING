<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<h2>상품 정보 등록</h2>
<form:form action="../item/register.html" method="post"  name="itemFrm"
 modelAttribute="item" onSubmit="return check(this)">
<input type="hidden" name="CODECHK"/>
<table>
<tr><th>상품 번호</th>
	<td><form:input path="code" id="code" name="code"/>
	<input type="button" value="중복 검사" onClick="codeCheck()"/>
	<font color="red"><form:errors path="code"/></font>
	</td></tr>
<tr><th>상품 이름</th>
	<td><form:input path="name" name="name"/>
	<font color="red"><form:errors path="name"/></font>
	</td></tr>
<tr><th>상품 가격</th>
	<td><form:input path="price" name="price"/>
	<font color="red"><form:errors path="price"/></font>
	</td></tr>
<tr><th>상품 정보</th>
	<td><form:textarea rows="4" cols="50" path="info" name="info"></form:textarea>
	<font color="red"><form:errors path="info"/></font>
	</td></tr>
<tr><td colspan="2" align="center">
	<input type="submit" value="상품 등록"/>
	<input type="reset" value="취 소"/>
	</td></tr>
</table>
</form:form>	
</div>
<script type="text/javascript">
function codeCheck(){
	if(document.itemFrm.code.value == ''){
		alert("상품번호를 입력하세요."); return;//함수 종료
	}
	var url="../item/codecheck.html?CODE="+document.itemFrm.code.value;
	window.open(url,"_blank_",
			"width=450,height=200,top=150,left=200");
}//void 함수
function check(fm){
// 	if(fm.code.value == ''){
// 		alert("상품 번호를 입력하세요."); return false;
// 	}
	if(fm.CODECHK.value == ''){
		alert("상품번호 중복검사를 해주세요."); return false;
	}
// 	if(fm.name.value == ''){
// 		alert("상품 이름을 입력하세요."); return false;
// 	}
// 	if(fm.price.value == ''){
// 		alert("가격을 입력하세요."); return false;
// 	}else{
// 		if(isNaN(fm.price.value)){
// 			alert("가격은 숫자로 입력하세요."); return false;
// 		}
// 	}
// 	if(fm.info.value == ''){
// 		alert("상품 설명을 입력하세요."); return false;
// 	}
	if(! confirm("입력한 내용이 맞습니까?")) return false;
}
</script>
</body>
</html>










