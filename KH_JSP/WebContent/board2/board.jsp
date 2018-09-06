<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<%@ page import = "java.util.*" %>
<%@ page import = "board2.Board_DB_Bean" %>
<%@ page import = "board2.Board_Data_Bean" %>



<%



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

	
List list = manager.getArticles(board_starts, board_ends, id, searchs, searchs_value);	//리스트받아오기

board_cnt = board_starts;
for(int i=0;i<list.size();i++) {
Board_Data_Bean bdb = (Board_Data_Bean)list.get(i);
%>
	<tr <% if(bdb.getRt_no() != 1){ %>class="rt_bg"<% } %>>
		<td align="center"><%=board_total-board_cnt+1 %></td>
		<td></td>
		<td>
			<% if(bdb.getDeletes() != 2) { %>
		  <a href="board_view.jsp?id=<%=bdb.getId() %>&amp;no=<%=bdb.getNo() %>&amp;pages=<%=pages %>&amp;searchs=<%=searchs %>&amp;searchs_value=<%=searchs_value %>">
		    <% if(bdb.getRt_no() != 1){ %>ㄴ<span style="font-weight:bold;">[답글]&nbsp;</span><% } %>
		    <%=bdb.getSubject() %>
		  	<% if(bdb.getComments() != 0) { %><span style="font-size:11px;color:red;"><%=bdb.getComments() %></span><% }%>
		  </a></td>
		  	<% }else{ %>
		  	<%=bdb.getSubject() %>
		  	<% } %>
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
	<div class="boards_bsearch">
		<form action="board.jsp" method="get">
			<input type="hidden" name="id" value="<%=id %>" />
			<input type="hidden" name="pages" value="<%=pages %>" />
			<div class="boards_bsearch_l">
				<select name="searchs">
					<option value="subject" <% if(searchs.equals("subject")){ %>selected<% } %>>제목</option>
					<option value="memo" <% if(searchs.equals("memo")){ %>selected<% } %>>내용</option>
					<option value="subject_memo" <% if(searchs.equals("subject_memo")){ %>selected<% } %>>제목+내용</option>
				</select>
			</div>
		  	<div class="boards_bsearch_c">
		    	<input type="text" name="searchs_value" value="<%=searchs_value %>" />
			</div>
		  	<div class="boards_bsearch_r">
		    	<input type="submit" value="검색하기" />
			</div>
		</form>
	</div>
</div>
<div class="boards_b">
	<div class="boards_bl">
		&nbsp;
	</div>
	<div class="boards_bc">
		<a href="board.jsp?id=<%=id %>&amp;pages=1&amp;searchs=<%=searchs %>&amp;searchs_value=<%=searchs_value %>">&lt;&lt;</a>
		<%
		int pstarts = Integer.parseInt(pages)-5;
		int pends = Integer.parseInt(pages)+5;
		for(int i=pstarts;i<=pends;i++) {
			if(i <= 0) continue;
			if(i > board_paging) continue;
		%>
		<a href="board.jsp?id=<%=id %>&amp;pages=<%=i %>&amp;searchs=<%=searchs %>&amp;searchs_value=<%=searchs_value %>" <% if(i==Integer.parseInt(pages)) { %>style="font-weight:bold;color:red;"<% } %>><%=i %></a>
		<% } %>
		<a href="board.jsp?id=<%=id %>&amp;pages=<%=board_paging %>&amp;searchs=<%=searchs %>&amp;searchs_value=<%=searchs_value %>">&gt;&gt;</a>
	</div>
	<div class="boards_br">
		<a href="board_write.jsp?id=<%=id %>&amp;pages=<%=pages %>&amp;searchs=<%=searchs %>&amp;searchs_value=<%=searchs_value %>" class="btn_st" style="float:right;margin:0 10px 0 0;">작성하기</a>
	</div>
</div>

<%@ include file="foot.jsp" %>