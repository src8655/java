<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<%
String id = request.getParameter("id");
String pages = request.getParameter("pages");
if(pages == null) pages = "1";
%>
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

<%@ include file="lib.jsp" %>
<%
ResultSet rs = null;
try {
	int total = 0;	//총개수 출력
	pstmt = conn.prepareStatement("select count(*) from MIN_TBOARD_DATA where id=?");
	pstmt.setString(1, id);
	rs = pstmt.executeQuery();
	if(rs.next()) total = rs.getInt(1);
	
	
	int cnt = 0;		//no를 위한 카운트
	int lengths = 3;	//한번에 보일 리스트 개수
	int starts = (Integer.parseInt(pages))*lengths-lengths;		//시작지점
	int paging = (int)Math.ceil(total/(Integer.parseInt(pages)));
	
	//리스트출력
	/*
	pstmt = conn.prepareStatement("select * from MIN_TBOARD_DATA where id=? order by NO desc");
	pstmt.setString(1, id);
	*/
	pstmt = conn.prepareStatement("select * from MIN_TBOARD_DATA where id=? order by NO desc");
	pstmt.setString(1, id);
	rs = pstmt.executeQuery();
	while(rs.next()) {
%>
	<tr>
		<td align="center"><%=total-cnt %></td>
		<td></td>
		<td>
		  <a href="board_view.jsp?id=<?=$ddmz[id]?>&amp;no=<?=$ddmz[no]?>&amp;page=<?=$page?>">
		    <%=rs.getString("SUBJECT") %>
		  </a></td>
		<td></td>
		<td align="center"><%=rs.getString("NAME") %></td>
		<td></td>
		<td align="center"><%=rs.getString("DATES") %></td>
		<td></td>
		<td align="center"><%=rs.getInt("HIT") %></td>
	</tr>
<%
		cnt++;
	}
}catch(Exception e) {
	
}finally {
	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();
	if(conn != null) conn.close();
}
%>
</table>
<div class="boards_b">
	<div class="boards_bl">
		&nbsp;
	</div>
	<div class="boards_bc">
		<a href="board.php?id=<?=$id?>&amp;page=1">&lt;&lt;</a>
			1 2 3
		<a href="board.php?id=<?=$id?>&amp;page=<?=$paging?>">&gt;&gt;</a>
	</div>
	<div class="boards_br">
		<a href="board_write.jsp?id=<%=id %>" class="btn_st" style="float:right;margin:0 10px 0 0;">작성하기</a>
	</div>
</div>

<%@ include file="foot.jsp" %>