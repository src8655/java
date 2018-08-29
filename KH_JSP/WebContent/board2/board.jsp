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

int total = manager.getCount(id);	//총 개수
int cnt = 0;						//no를 위한 카운트

int lengths = 3;	//한번에 보일 리스트 개수
int starts = (Integer.parseInt(pages))*lengths-lengths;		//시작지점
int paging = (int)Math.ceil(total/(Integer.parseInt(pages)));

%>

<div class="boards_header">
	<p style="float:left;">전체게시물 : <%=total %></p>
	<p style="float:right;text-align:right;">
<% if(member_info == null) {%>
		<a href="login.jsp?id=<%=id %>&pages=<%=pages %>">로그인</a>
		&nbsp;
		<a href="join.jsp?id=<%=id %>&pages=<%=pages %>">회원가입</a>
<% }else{%>
		<span style="font-weight:bold;"><%=member_info.getName() %></span>님 환영합니다.
		&nbsp;
		<a href="logout.jsp?id=<%=id %>&pages=<%=pages %>">로그아웃</a>
<% }%>
	</p>
</div>

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

	
List list = manager.getArticles(1, 5, id);	//리스트받아오기

for(int i=0;i<list.size();i++) {
Board_Data_Bean bdb = (Board_Data_Bean)list.get(i);
%>
	<tr>
		<td align="center"><%=total-cnt %></td>
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
	cnt++;
}
%>
</table>
<div class="boards_b">
	<div class="boards_bl">
		&nbsp;
	</div>
	<div class="boards_bc">
		<a href="board.php?id=<?=$id?>&amp;page=1">&lt;&lt;</a>
			
		<a href="board.php?id=<?=$id?>&amp;page=<?=$paging?>">&gt;&gt;</a>
	</div>
	<div class="boards_br">
		<a href="board_write.jsp?id=<%=id %>&amp;pages=<%=pages %>" class="btn_st" style="float:right;margin:0 10px 0 0;">작성하기</a>
	</div>
</div>

<%@ include file="foot.jsp" %>