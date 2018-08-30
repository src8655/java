<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<%@ page import = "board2.Member_DB_Bean" %>


<jsp:useBean id="mdata" class="board2.Member_Data_Bean">
    <jsp:setProperty name="mdata" property="*" />
</jsp:useBean>


<%
//비로그인 접근금지
if(member_info == null) {
	out.println("<script>");
	out.println("alert('잘못된 접근입니다.')");
	out.println("history.go(-1)");
	out.println("</script>");
	
	return;
}

String id = request.getParameter("id");
String pages = request.getParameter("pages");

if(request.getParameter("passwords").equals("")) {
	out.println("<script>");
	out.println("alert('비밀번호를 입력하세요.')");
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
if(request.getParameter("email").equals("")) {
	out.println("<script>");
	out.println("alert('이메일을 입력하세요.')");
	out.println("history.go(-1)");
	out.println("</script>");
	
	return;
}



//암호화
mdata.setPasswords(Md5Enc.getEncMD5(mdata.getPasswords().getBytes()));


//회원no전달

Member_DB_Bean manager = Member_DB_Bean.getInstance();

if(!manager.update(mdata, member_info.getNo())) {
	out.println("<script>");
	out.println("alert('비밀번호가 다릅니다.')");
	out.println("history.go(-1)");
	out.println("</script>");
	
	return;
}







response.sendRedirect("board.jsp?id="+id+"&pages="+pages);
%>

<%@ include file="foot.jsp" %>