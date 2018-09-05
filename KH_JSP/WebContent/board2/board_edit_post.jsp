<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<%@ page import = "board2.Board_DB_Bean" %>
<%
String no = request.getParameter("no");



Board_DB_Bean bdb = Board_DB_Bean.getInstance();
if(bdb.update(request)) 
	response.sendRedirect("board_view.jsp?id="+id+"&pages="+pages+"&no="+no);
else {
	out.println("<script>");
	out.println("alert('작성 실패')");
	out.println("history.go(-1)");
	out.println("</script>");
	
	return;
}

%>

<%@ include file="foot.jsp" %>