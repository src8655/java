<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>


<%
String id = request.getParameter("id");
String pages = request.getParameter("pages");
String no = request.getParameter("no");
%>

<%@ include file="board_bar.jsp" %>

<form action="board_del_post.jsp" method="post">
<input type="hidden" name="id" value="<%=id %>" />
<input type="hidden" name="no" value="<%=no %>" />
<input type="hidden" name="pages" value="<%=pages %>" />
<table cellpadding="7" cellspacing="0" class="boards" style="margin:0 auto;margin-top:50px;width:300px;">
  <tr class="boards_t">
    <th colspan="2">비밀번호를 입력해주세요</th>
  </tr>
  <tr>
    <td><input type="password" name="passwords" /></td>
    <td><input type="submit" value="입력" /></td>
  </tr>
</table>
</form>

<%@ include file="foot.jsp" %>