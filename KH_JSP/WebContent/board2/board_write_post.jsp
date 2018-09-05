<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<%@ page import = "board2.Board_DB_Bean" %>
<%@ page import = "java.io.*" %>
<%@ page import="com.oreilly.servlet.MultipartRequest,
                   com.oreilly.servlet.multipart.DefaultFileRenamePolicy,
                   java.util.*" 
%>
<jsp:useBean id="bdata" class="board2.Board_Data_Bean">
    <jsp:setProperty name="bdata" property="*" />
</jsp:useBean>

<%

Board_DB_Bean manager = Board_DB_Bean.getInstance();
if(!manager.insert(request, session)) {
	out.println("<script>");
	out.println("alert('작성 실패')");
	out.println("history.go(-1)");
	out.println("</script>");
	
	return;
}


response.sendRedirect("board.jsp?id="+id+"&searchs="+searchs+"&searchs_value="+searchs_value);

%>

<%@ include file="foot.jsp" %>