<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "board2.Board_DB_Bean" %>
<%

Board_DB_Bean board_manager = Board_DB_Bean.getInstance();

int board_total = board_manager.getCount(id);	//총 개수
int board_cnt = 0;						//no를 위한 카운트

int board_lengths = 7;	//한번에 보일 리스트 개수
int board_starts = ((Integer.parseInt(pages))*board_lengths)-board_lengths+1;			//시작지점
int board_ends = board_starts+board_lengths-1;										//마지막지점
int board_paging = (int)Math.ceil((double)board_total/(double)board_lengths);	//페이지 링크 개수

%>

<div class="boards_header">
	<p style="float:left;width:30%;">전체게시물 : <%=board_total %></p>
	<p style="float:right;width:70%;text-align:right;">
<% if(member_info == null) {%>
		<a href="login.jsp?id=<%=id %>&pages=<%=pages %>">로그인</a>
		&nbsp;
		<a href="join.jsp?id=<%=id %>&pages=<%=pages %>">회원가입</a>
<% }else{%>
		<span style="font-weight:bold;"><%=member_info.getName() %></span>님 환영합니다.
		<a href="join_edit.jsp?id=<%=id %>&pages=<%=pages %>">[정보수정]</a>
		<a href="logout.jsp?id=<%=id %>&pages=<%=pages %>">[로그아웃]</a>
<% }%>
	</p>
</div>