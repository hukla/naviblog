<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȭ��001</title>
</head>
<body>
<form action="login.navi" onSubmit="checkInput()">
<table>
<tr align="center">
<td colspan="4" align="center"><h1>Butterfly Blog</h1></td>
</tr>
<tr>
<td>���̵� : </td>
<td><input type="text" id="id" name="userid"></td>
<td>��й�ȣ : </td>
<td><input type="password" id="pwd" name="password"></td>
</tr>
<tr>
</tr>
<tr>
<td colspan="4" align="center">
<input type="submit" value="�α���">
</td>
</tr>
</table>
</form>
<script>
function checkInput(element) {
	var id = document.getElementById("id");
	var pwd = document.getElementById("pwd");
	
	if(id.value == "") {
		alert("���̵� �Է��Ͽ� �ּ���.");
		id.focus();
		return false;
	} else if(pwd.value == "") {
		alert("��й�ȣ�� �Է��ϼ���.");
		pwd.focus();
		return false;
	}
	return true;
}
</script>
</body>
</html>