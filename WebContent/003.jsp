<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>ȭ��003</title>
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
        <a href="#">���� ������</a><br/>
        <a href="#">�α���</a><br/>
        <a href="#">��α� ����</a><br/>
      </td>
    </tr>
    <tr>
      <td>
        <table>
          <tr>
            <td>
              <a href="#">����</a>&nbsp; &nbsp;
              <a href="#">����</a>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
              posted by ${requestScope.post.userId} in "${requestScope.blog.title}"
            </td>
          </tr>
        </table>
      </td>
    </tr>
    <tr>
      <td width="70%">
        <table>
          <tr><td colspan="2">���� ${requestScope.replycnt}</td></tr>
          <tr> 
            <c:forEach items="${requestScope.replyList}" var="reply">
              <td width="10%"></td>
              <td>
                <table>
                  <tr><td>commented by <strong>${reply.userId}</strong> at ${reply.createdDate}</font></td></tr>
            <tr><td width="10%"></td><td width="90%">${reply.content} <img src="http://bookriotcom.c.presscdn.com/wp-content/uploads/2013/07/x.png" height="10"/></td></tr>
                </table>
              </td>
            </c:forEach>
          </tr>
        </table>
      <td width="30%">
        <table>
          <tr><td align="center"><strong>ī�װ�</strong></td></tr>
          <c:forEach items="${requestScope.categoryList}" var="category">
            <tr><td align="right">${category.categoryName}</td></tr>
          </c:forEach>
        </table>
      </td>
    </tr>
    <tr>
      <td width="70%">
        <form name="reply" action="">
        <table>
          <tr>
            <td>�г��� : </td>
            <td><input type="text" name="nickname"></td>
            <td> &nbsp; &nbsp; &nbsp;���� ���� ����</td>
            <td><input type="checkbox" name="public_reply"></td>
            <td><input type="submit" value="�����߰�"></td>
          </tr>
          <tr>
            <td colspan="5">
              <textarea rows="2" cols="80"></textarea>
            </td>
          </tr>
        </table>
        </form>
      </td>
        
      <td width="30%" align="center"><strong>Butterfly Blog</strong></td>
    </tr>
  </table>
</body>
</html>