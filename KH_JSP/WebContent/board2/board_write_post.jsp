<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<%@ page import = "board2.Board_DB_Bean" %>
<jsp:useBean id="bdata" class="board2.Board_Data_Bean">
    <jsp:setProperty name="bdata" property="*" />
</jsp:useBean>
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

//암호화
bdata.setPasswords(Md5Enc.getEncMD5(bdata.getPasswords().getBytes()));


Board_DB_Bean manager = Board_DB_Bean.getInstance();
manager.insert(bdata);






response.sendRedirect("board.jsp?id="+id);
%>

<%@ include file="foot.jsp" %>