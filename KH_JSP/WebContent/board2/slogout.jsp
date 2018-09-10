<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import = "java.util.*" %>
<%@ page import = "board2.*" %>
<%

//로그인정보 불러오기
Member_DB_Bean mem_db = Member_DB_Bean.getInstance();
Member_Data_Bean member_info = mem_db.getLogin(session);

request.setAttribute("member_info", member_info);
////////////////////////////////////////////////////////////////

session.setAttribute("user_id", null);
session.setAttribute("user_pw", null);
%>
<jsp:forward page="logout.jsp" />