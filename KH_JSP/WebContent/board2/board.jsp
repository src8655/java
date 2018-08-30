<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<%@ page import = "java.util.*" %>
<%@ page import = "board2.Board_DB_Bean" %>
<%@ page import = "board2.Board_Data_Bean" %>



<%
String id = request.getParameter("id");
String pages = "1";
if(request.getParameter("pages") != null)
	pages = request.getParameter("pages");


Board_DB_Bean manager = Board_DB_Bean.getInstance();

%>

<%@ include file="board_bar.jsp" %>

<table cellpadding="7" cellspacing="0" class="boards">
<col width="60" />
<col width="1" />
<col width="240" />
<col width="1" />
<col width="70" />
<col width="1" />
<col width="70" />
<col width="1" />
<col width="60" />
	<tr>
		<th>번호</th>
		<th><span style="font-weight:normal;">|</span></th>
		<th>제목</th>
		<th><span style="font-weight:normal;">|</span></th>
		<th>이름</th>
		<th><span style="font-weight:normal;">|</span></th>
		<th>날짜</th>
		<th><span style="font-weight:normal;">|</span></th>
		<th>조회</th>
	</tr>

<%

	
List list = manager.getArticles(board_starts, board_ends, id);	//리스트받아오기

board_cnt = board_starts;
for(int i=0;i<list.size();i++) {
Board_Data_Bean bdb = (Board_Data_Bean)list.get(i);
%>
	<tr>
		<td align="center"><%=board_total-board_cnt+1 %></td>
		<td></td>
		<td>
		  <a href="board_view.jsp?id=<%=bdb.getId() %>&amp;no=<%=bdb.getNo() %>&amp;pages=<%=pages %>">
		    <%=bdb.getSubject() %>
		  	<% if(bdb.getComments() != 0) { %><span style="font-size:11px;color:red;"><%=bdb.getComments() %></span><% }%>
		  </a></td>
		<td></td>
		<td align="center"><%=bdb.getName() %></td>
		<td></td>
		<td align="center"><%=bdb.getDates() %></td>
		<td></td>
		<td align="center"><%=bdb.getHit() %></td>
	</tr>
<%
	board_cnt++;
}
%>
</table>
<div class="boards_b">
	<div class="boards_bl">
		&nbsp;
	</div>
	<div class="boards_bc">
		<a href="board.jsp?id=<%=id %>&amp;pages=1">&lt;&lt;</a>
		<%
		int pstarts = Integer.parseInt(pages)-5;
		int pends = Integer.parseInt(pages)+5;
		for(int i=pstarts;i<=pends;i++) {
			if(i <= 0) continue;
			if(i > board_paging) continue;
		%>
		<a href="board.jsp?id=<%=id %>&amp;pages=<%=i %>" <% if(i==Integer.parseInt(pages)) { %>style="font-weight:bold;color:red;"<% } %>><%=i %></a>
		<% } %>
		<a href="board.jsp?id=<%=id %>&amp;pages=<%=board_paging %>">&gt;&gt;</a>
	</div>
	<div class="boards_br">
		<a href="board_write.jsp?id=<%=id %>&amp;pages=<%=pages %>" class="btn_st" style="float:right;margin:0 10px 0 0;">작성하기</a>
	</div>
</div>

<%@ include file="foot.jsp" %>