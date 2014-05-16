<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>화면001</title>
</head>
<body>
<form action="login.navi" onSubmit="checkInput()">
<table>
<tr align="center">
<td colspan="4" align="center"><h1>Butterfly Blog</h1></td>
</tr>
<tr>
<td>아이디 : </td>
<td><input type="text" id="id" name="userid"></td>
<td>비밀번호 : </td>
<td><input type="password" id="pwd" name="password"></td>
</tr>
<tr>
</tr>
<tr>
<td colspan="4" align="center">
<input type="submit" value="로그인">
</td>
</tr>
</table>
</form>
<script>
function checkInput(element) {
	var id = document.getElementById("id");
	var pwd = document.getElementById("pwd");
	
	if(id.value == "") {
		alert("아이디를 입력하여 주세요.");
		id.focus();
		return false;
	} else if(pwd.value == "") {
		alert("비밀번호를 입력하세요.");
		pwd.focus();
		return false;
	}
	return true;
}
</script>
</body>
</html>