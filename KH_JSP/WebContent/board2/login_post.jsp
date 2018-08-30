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

//암호화
mdata.setPasswords(Md5Enc.getEncMD5(mdata.getPasswords().getBytes()));



Member_DB_Bean manager = Member_DB_Bean.getInstance();
if(manager.login(mdata.getUser_id(), mdata.getPasswords())) {
	session.setAttribute("user_id", mdata.getUser_id());
	session.setAttribute("user_pw", mdata.getPasswords());
	response.sendRedirect("board.jsp?id="+id+"&pages="+pages);
}else{
	out.println("<script>");
	out.println("alert('아이디 또는 비밀번호가 틀렸습니다.')");
	out.println("history.go(-1)");
	out.println("</script>");
	
	return;
}







%>

<%@ include file="foot.jsp" %>