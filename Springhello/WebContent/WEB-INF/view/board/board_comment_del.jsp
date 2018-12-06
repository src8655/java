<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<form action="board_comment_del_post.do" method="post">
<input type="hidden" name="no" value="${no}" />
<input type="hidden" name="board_no" value="${board_no}" />
<input type="hidden" name="pages" value="${pages}" />
<input type="hidden" name="lang" value="${lang}" />
<table cellpadding="7" cellspacing="0" class="boards" style="margin:0 auto;margin-top:50px;width:300px;">
  <tr class="boards_t">
    <th colspan="2"><spring:message code="board.delpassword" /></th>
  </tr>
  <tr>
    <td><input type="password" name="password" /></td>
    <td><input type="submit" value='<spring:message code="board.delbtn" />' /></td>
  </tr>
</table>
</form>
