<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import = "java.util.*" %>
<%@ page import = "board2.*" %>
<%
String user_id = request.getParameter("user_id");


Member_DB_Bean mdb = Member_DB_Bean.getInstance();
int count = mdb.selectId(user_id);


//성공시 1 실패시 0
String result = "0";	//결과코드
if(count == 0) result = "1";

request.setAttribute("result", result);
%>
<jsp:forward page="join_check.jsp" />