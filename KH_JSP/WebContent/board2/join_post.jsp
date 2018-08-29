<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<%@ page import = "board2.Member_DB_Bean" %>


<jsp:useBean id="mdata" class="board2.Member_Data_Bean">
    <jsp:setProperty name="mdata" property="*" />
</jsp:useBean>


<%
String id = request.getParameter("id");
String pages = request.getParameter("pages");

if(request.getParameter("user_id").equals("")) {
	out.println("<script>");
	out.println("alert('아이디를 입력하세요.')");
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
if(request.getParameter("passwords2").equals("")) {
	out.println("<script>");
	out.println("alert('비밀번호 확인을 입력하세요.')");
	out.println("history.go(-1)");
	out.println("</script>");
	
	return;
}
if(!request.getParameter("passwords").equals(request.getParameter("passwords2"))) {
	out.println("<script>");
	out.println("alert('비밀번호가 다릅니다.')");
	out.println("history.go(-1)");
	out.println("</script>");
	
	return;
}
if(request.getParameter("email").equals("")) {
	out.println("<script>");
	out.println("alert('이메일을 입력하세요.')");
	out.println("history.go(-1)");
	out.println("</script>");
	
	return;
}


//중복확인된 아이디인지 확인할것



Member_DB_Bean manager = Member_DB_Bean.getInstance();
manager.insert(mdata);






response.sendRedirect("board.jsp?id="+id+"&pages="+pages);
%>

<%@ include file="foot.jsp" %>