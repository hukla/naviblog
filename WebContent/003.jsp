<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>화면003</title>
</head>
<body>
  <table>
    <tr>
      <td colspan="2" align="center" bgcolor="gray" height="200px">
        <font size="8" color="white">${requestScope.blog.title}</font><br/>
        <font size="5" color="white">${requestScope.blog.tag}</font>
      </td>
    </tr>
    <tr>
      <td width="70%">
        <table>
          <tr><td><font size="5">${requestScope.post.title}</font></td></tr>
          <tr><td><font size="3">${requestScope.post.createdDate}</font></td></tr>
          <tr><td><font size="3">${requestScope.post.content}</font></td></tr>
        </table>
      </td>
      <td width="30%">
        <a href="#">마이 페이지</a><br/>
        <a href="#">로그인</a><br/>
        <a href="#">블로그 관리</a><br/>
      </td>
    </tr>
    <tr>
      <td>
        <table>
          <tr>
            <td>
              <a href="#">수정</a>&nbsp; &nbsp;
              <a href="#">삭제</a>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
              posted by ${requestScope.post.userId} in "${requestScope.blog.title}"
            </td>
          </tr>
        </table>
      </td>
    </tr>
    <tr>
      <td width="70%">
        <table>
          <tr><td colspan="2">덧글 ${requestScope.replycnt}</td></tr>
            <c:forEach items="${requestScope.replyList}" var="reply">
            <tr>
              <td width="10%"></td>
              <td width="90%">
                <table>
                  <tr><td colspan="2">commented by <strong>${reply.nickname}</strong> at <fmt:parseDate value="${reply.createdDate }" pattern="MM/dd/yyyy" var="datefmt"/><fmt:formatDate value="${datefmt}" pattern="yyyy/MM/dd"/></td></tr>
            	  <tr><td width="10%"></td><td width="90%">${reply.content} <img src="http://bookriotcom.c.presscdn.com/wp-content/uploads/2013/07/x.png" height="10"/></td></tr>
                </table>
              </td>
              </tr>
            </c:forEach>
        </table>
      <td width="30%">
        <table>
          <tr><td align="center"><strong>카테고리</strong></td></tr>
          <c:forEach items="${requestScope.categoryList}" var="category">
            <tr><td align="right">${category.categoryName}</td></tr>
          </c:forEach>
        </table>
      </td>
    </tr>
    <tr>
      <td width="70%">
        <form name="reply" action="regreply.navi" method="post" onSubmit="return inputCheck(this)">
        <input type="hidden" name="blogId" value="${requestScope.blog.blogId }">
        <input type="hidden" name="postId" value="${requestScope.post.postId }">
        <table>
          <tr>
            <td>닉네임 : </td>
            <td><input type="text" name="nickname"></td>
            <td> &nbsp; &nbsp; &nbsp;덧글 공개 여부</td>
            <td><input type="checkbox" name="public_reply"></td>
            <td><input type="submit" value="덧글추가"></td>
          </tr>
          <tr>
            <td colspan="5">
              <textarea rows="2" cols="80" name="content"></textarea>
            </td>
          </tr>
        </table>
        </form>
      </td>
        
      <td width="30%" align="center"><strong>Butterfly Blog</strong></td>
    </tr>
  </table>
</body>
<script type="text/javascript">
function inputCheck(element) {
	var nickname = document.getElementsByName("nickname");
	var content = document.getElementsByName("content");
	if(nickname[0].value == "") {
		alert("닉네임을 입력하여 주세요.");
		nickname[0].focus();
		return false;
	} else if(content[0].value == "") {
		alert("내용을 입력하세요.");
		content[0].focus();
		return false;
	}
	return true;
}
</script>
</html>