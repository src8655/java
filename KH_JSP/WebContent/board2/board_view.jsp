<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<%@ page import = "java.util.*" %>
<%@ page import = "board2.Board_DB_Bean" %>
<%@ page import = "board2.Board_Data_Bean" %>

<%@ page import = "board2.Comment_DB_Bean" %>
<%@ page import = "board2.Comment_Data_Bean" %>


<%
String id = request.getParameter("id");
String pages = request.getParameter("pages");
String no = request.getParameter("no");
%>


<%
Board_DB_Bean manager = Board_DB_Bean.getInstance();

//조회수추가
manager.updateHit(Integer.parseInt(no));

//데이터받기
Board_Data_Bean bdb = manager.getArticle(Integer.parseInt(no));

//줄바꿈
String memos = bdb.getMemo().replaceAll("\n", "<br />");



%>



<table cellpadding="7" cellspacing="0" class="boards">
<col width="100" />
<col width="380" />
<col width="100" />
<col width="120" />
	<tr class="boards_t">
		<th style="background:#d5e9ff;">제목</th>
		<th align="left" style="padding:0 0 0 10px;"><%=bdb.getSubject() %></th>
		<th style="background:#d5e9ff;">조회</th>
		<th align="right" style="padding:0 10px 0 0;"><%=bdb.getHit() %></th>
	</tr>
	<tr>
		<th style="background:#d5e9ff;border:none;border-bottom:1px solid #A0A0A0;">이름</th>
	  <td style="padding:0 0 0 10px;font-weight:bold;"><%=bdb.getName() %></td>
		<th style="background:#d5e9ff;border:none;border-bottom:1px solid #A0A0A0;">날짜</th>
	  <td align="right" style="padding:0 10px 0 0;font-weight:bold;"><%=bdb.getDates() %></td>
	</tr>
	<tr>
		<td colspan="4" style="padding:30px 7px 30px 7px;"><%=memos %></td>
	</tr>
</table>




<table cellpadding="7" cellspacing="0" class="comments">
<col width="100" />
<col width="400" />

<%
Comment_DB_Bean cdb = Comment_DB_Bean.getInstance();
List list = cdb.getArticles(Integer.parseInt(no));
for(int i=0;i<list.size();i++) {
	Comment_Data_Bean data = (Comment_Data_Bean)list.get(i);
	String c_memos = data.getMemo().replaceAll("\n", "<br />");
%>
	<tr>
		<th style="background:#d5e9ff;border:none;border:1px solid #A0A0A0;"><%=data.getName() %>
			<span style="font-weight:normal;">
				<br /><%=data.getDates() %><br />
				
			</span>
		</th>
		<td valign="top">
			<%=c_memos %>
			<a href="board_comment_del.jsp?no=<%=data.getNo() %>&amp;id=<%=id %>&amp;data_no=<%=no %>&amp;pages=<%=pages %>">ⓧ</a>
		</td>
	</tr>
<%
}
%>
	
</table>




<form name="cm_b" action="board_comment_post.jsp">
<input type="hidden" name="data_no" value="<%=no %>" />
<input type="hidden" name="id" value="<%=id %>" />
<input type="hidden" name="pages" value="<%=pages %>" />
<table cellpadding="7" cellspacing="0" class="comments">
<col width="20%" />
<col width="30%" />
<col width="20%" />
<col width="20%" />
	<tr style="<? if($dlog[no]) {?>display:none;<? }?>">
		<th style="background:#d5e9ff;border-left:1px solid #bbbbbb;">이름</th>
		<td style="border-top:1px solid #122942;"><input type="text" name="name" value="" /></td>
		<th style="background:#d5e9ff;">비밀번호</th>
		<td style="border-top:1px solid #122942;" colspan="2"><input type="password" name="passwords" value="" /></td>
	</tr>
	<tr>
		<td style="border-left:none;border-right:none;" colspan="4"><textarea name="memo" rows="100" cols="100" editable="0" style="width:98%;height:40px;"></textarea></td>
		<td style="width:80px;border-left:none;border-right:none;"><input type="submit" value="등록" style="background:#d5e9ff;border:1px solid #122942;width:70px;height:45px;font-size:12px;font-weight:bold;" /></td>
	</tr>
</table>
</form>

<div class="boards_b">
	<div class="boards_bl">
		<a href="board.jsp?id=<%=id %>&amp;pages=<%=pages %>" class="btn_st"  style="margin:0 0 0 10px;">목록보기</a>
	</div>
	<div class="boards_br" style="width:50%;">
		<a href="board_edit.jsp?id=<%=id %>&amp;pages=<%=pages %>&amp;no=<%=bdb.getNo() %>" class="btn_st"  style="float:right;margin:0 10px 0 0;">수정하기</a>
		<a href="board_del.jsp?id=<%=id %>&amp;pages=<%=pages %>&amp;no=<%=bdb.getNo() %>" class="btn_st"  style="float:right;margin:0 10px 0 0;">삭제하기</a>
	</div>
</div>

<%@ include file="foot.jsp" %>