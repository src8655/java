<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import = "board2.Board_DB_Bean" %>
<%@ page import = "board2.Board_Data_Bean" %>
<%@ include file="head2.jsp" %>

<%
Board_DB_Bean manager = Board_DB_Bean.getInstance();
%>

	<div id="noticech">
		<h1>공지사항</h1>
		<ul>
<%
String date = cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DATE);




List list = manager.getArticles2(1, 5);	//리스트받아오기

for(int i=0;i<list.size();i++) {
Board_Data_Bean bdb = (Board_Data_Bean)list.get(i);
if(bdb.getDeletes() == 2) continue;
%>
			<li>
				<a href="board_view.jsp?id=<%=bdb.getId() %>&amp;no=<%=bdb.getNo() %>">
				  <span style="font-weight:bold;">[<%=bdb.getName() %>]</span>
				  <%=bdb.getSubject() %>
				  <% if(bdb.getDates().equals(date)) { %><span style="font-size:11px;color:red;">New</span><% } %></a>
				  <p>[<%=bdb.getDates() %>]</p>
			</li>
<%
}
%>
		</ul>
	</div>
	<div class="icons" id="icons_1">
		<a href="board_write.jsp?id=q">온라인문의</a>
	</div>
	<div class="icons" id="icons_2">
		<a href="map.jsp?id=map">오시는길</a>
	</div>
	<div class="icons" id="icons_3">
		<a href="#">전화문의</a>
	</div>
<%@ include file="foot2.jsp" %>