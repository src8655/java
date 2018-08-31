<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<%@ page import = "board2.Comment_DB_Bean" %>
<%@ page import = "board2.Board_DB_Bean" %>


<jsp:useBean id="cdata" class="board2.Comment_Data_Bean">
    <jsp:setProperty name="cdata" property="*" />
</jsp:useBean>


<%
String data_no = request.getParameter("data_no");

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
cdata.setPasswords(Md5Enc.getEncMD5(cdata.getPasswords().getBytes()));


Comment_DB_Bean manager = Comment_DB_Bean.getInstance();
manager.insert(cdata);


//댓글카운트갱신
Board_DB_Bean bdb = Board_DB_Bean.getInstance();
bdb.updateComment(Integer.parseInt(data_no));



response.sendRedirect("board_view.jsp?id="+id+"&pages="+pages+"&no="+data_no);
%>

<%@ include file="foot.jsp" %>