<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="head.jsp" %>
<%@ page import="board2.Board_Data_Bean" %>
<%@ page import="board2.Board_DB_Bean" %>
<%
String no = request.getParameter("no");

Board_DB_Bean bdb = Board_DB_Bean.getInstance();
Board_Data_Bean bdata = bdb.getArticle(Integer.parseInt(no));
%>

<%@ include file="board_bar.jsp" %>

<form action="board_edit_post.jsp?id=<%=id %>&no=<%=no %>&pages=<%=pages %>" method="post" enctype="multipart/form-data" name="userinput" onsubmit="return checkIt()">
<input type="hidden" name="id" value="<%=id %>" />
<input type="hidden" name="pages" value="<%=pages %>" />
<input type="hidden" name="no" value="<%=no %>" />
<table cellpadding="7" cellspacing="0" class="boards">
<col width="90" />
<col width="410" />
	<tr class="boards_t">
		<th style="background:#d5e9ff;">제목</th>
		<th style="padding:0 0 0 3px;" align="left"><input type="text" name="subject" style="width:98%;" value="<%=bdata.getSubject() %>" /></th>
	</tr>
<% 
String name_tmp = bdata.getName();
String passwords_tmp = "";
if(member_info != null) {
	name_tmp = member_info.getName();
	passwords_tmp = member_info.getPasswords();
}
%>
	<tr <% if(member_info != null) { %>style="display:none;"<% } %>>
		<th style="background:#d5e9ff;border:none;border-bottom:1px solid #A0A0A0;">이름</th>
		<td style="padding:0 0 0 3px;"><input type="text" name="name" value="<%=name_tmp %>" /></td>
	</tr>
	<tr <% if(member_info != null) { %>style="display:none;"<% } %>>
		<th style="background:#d5e9ff;border:none;border-bottom:1px solid #A0A0A0;">비밀번호</th>
		<td style="padding:0 0 0 3px;"><input type="password" name="passwords" value="<%=passwords_tmp %>" /></td>
	</tr>
	
	<tr>
		<td align="center" colspan="2">
		<textarea name="memo" rows="200" cols="200" class="b_memo" id="memo"><%=bdata.getMemo() %></textarea>
			<script>
				CKEDITOR.replace( 'memo', {
	            	uiColor : '#d5e9ff',
	            	height : 350
	            });
            </script>
		</td>
	</tr>
	
	
	<tr>
		<th rowspan="2" style="background:#d5e9ff;border:none;border-bottom:1px solid #A0A0A0;">파일첨부1</th>
		<% if(bdata.getFile1() != null) { %>
		<td style="padding:0 0 0 3px;height:30px;line-height:30px;">
			<input type="checkbox" name="file1_del" value="del" style="width:15px;height:15px;" />
			<%=bdata.getFile1() %>
		</td>
		<% } %>
	</tr>
	<tr>
		<td style="padding:0 0 0 3px;"><input type="file" name="file1" style="width:98%;" /></td>
	</tr>
	<tr>
		<th rowspan="2" style="background:#d5e9ff;border:none;border-bottom:1px solid #A0A0A0;">파일첨부2</th>
		<% if(bdata.getFile2() != null) { %>
		<td style="padding:0 0 0 3px;height:30px;line-height:30px;">
			<input type="checkbox" name="file2_del" value="del" style="width:15px;height:15px;" />
			<%=bdata.getFile2() %>
		</td>
		<% } %>
	</tr>
	<tr>
		<td style="padding:0 0 0 3px;"><input type="file" name="file2" style="width:98%;" /></td>
	</tr>
</table>

<div class="boards_b">
	<div class="boards_bl">
		<a href="board.jsp?id=<%=id %>&amp;pages=<%=pages %>" class="btn_st"  style="margin:0 0 0 10px;">목록보기</a>
	</div>
	<div class="boards_br">
		<input type="submit" value="수정하기" class="btn_st"  style="float:right;margin:0 10px 0 0; height:26px;" />
	</div>
</div>
</form>

<%@ include file="foot.jsp" %>