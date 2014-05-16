<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>화면002</title>
</head>
<body>
<table>
<tr align="center">
	<td align="center"><h1>Butterfly Blog</h1></td>
</tr>
<tr><td height="10"></td></tr>
<tr>
	<td align="center">
	<c:if test="${sessionScope.user != null}">
	<a href="#">로그아웃</a>&nbsp;
	</c:if>
	<a href="detailpost.navi?blogId=test&postId=1">포스트 보기</a>
	</td>
</tr>
</table>
</body>
</html>