<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@ include file="head.jsp" %>
<%@ include file="lib.jsp" %>
<%
String id = request.getParameter("id");

if(request.getParameter("subject").equals("")) {
	out.println("<script>");
	out.println("alert('제목을 입력하세요.')");
	out.println("history.go(-1)");
	out.println("</script>");
	
	return;
}
if(request.getParameter("name").equals("")) {
	out.println("<script>");
	out.println("alert('이름을 입력하세요.')");
	out.println("history.go(-1)");
	out.println("</script>");
	
	return;
}
if(request.getParameter("passwords").equals("")) {
	out.println("<script>");
	out.println("alert('비밀번호를 입력하세요.')");
	out.println("history.go(-1)");
	out.println("</script>");
	
	return;
}
if(request.getParameter("memo").equals("")) {
	out.println("<script>");
	out.println("alert('내용을 입력하세요.')");
	out.println("history.go(-1)");
	out.println("</script>");
	
	return;
}


//날짜 가져오기
Calendar cal = Calendar.getInstance();
String date = cal.get(Calendar.YEAR)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.DATE);

try {
	pstmt = conn.prepareStatement("insert into MIN_TBOARD_DATA(SUBJECT, MEMO, NAME, PASSWORD, DATES, HIT, ID)"
			+" values(?,?,?,?,?,?,?)");
	pstmt.setString(1, request.getParameter("subject"));
	pstmt.setString(2, request.getParameter("memo"));
	pstmt.setString(3, request.getParameter("name"));
	pstmt.setString(4, request.getParameter("passwords"));
	pstmt.setString(5, date);
	pstmt.setInt(6, 0);
	pstmt.setString(7, id);
	pstmt.executeUpdate();
	
	pstmt.close();
	conn.close();
}catch(Exception e) {
	
}finally {
	if(pstmt != null) pstmt.close();
	if(conn != null) conn.close();
}

response.sendRedirect("board.jsp?id="+id);
%>

<%@ include file="foot.jsp" %>