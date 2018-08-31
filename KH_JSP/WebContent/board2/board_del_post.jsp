<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<%@page import="board2.Board_DB_Bean"%>


<%
String no = request.getParameter("no");

//멤버일 경우
String passwords = "";
if(member_info != null) {
	passwords = member_info.getPasswords();
}else{
	passwords = request.getParameter("passwords");
}

//암호화
passwords = Md5Enc.getEncMD5(passwords.getBytes());



Board_DB_Bean bdb = Board_DB_Bean.getInstance();
if(bdb.delete(Integer.parseInt(no), passwords)) 
	response.sendRedirect("board.jsp?id="+id+"&pages="+pages);
else {
	out.println("<script>");
	out.println("alert('비밀번호가 다릅니다.')");
	out.println("history.go(-1)");
	out.println("</script>");
	
	return;
}
%>

<%@ include file="foot.jsp" %>