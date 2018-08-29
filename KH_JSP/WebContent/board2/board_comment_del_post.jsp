<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<%@page import="board2.Board_DB_Bean"%>
<%@page import="board2.Comment_DB_Bean"%>


<%
String id = request.getParameter("id");
String pages = request.getParameter("pages");
String no = request.getParameter("no");
String data_no = request.getParameter("data_no");

Comment_DB_Bean cdb = Comment_DB_Bean.getInstance();
if(cdb.delete(Integer.parseInt(no), request.getParameter("passwords"))) {
	response.sendRedirect("board_view.jsp?id="+id+"&pages="+pages+"&no="+data_no);


	//댓글카운트갱신
	Board_DB_Bean bdb = Board_DB_Bean.getInstance();
	bdb.updateComment(Integer.parseInt(data_no));
}else {
	out.println("<script>");
	out.println("alert('비밀번호가 다릅니다.')");
	out.println("history.go(-1)");
	out.println("</script>");
	
	return;
}
%>

<%@ include file="foot.jsp" %>