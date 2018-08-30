<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ page import = "board2.Member_Data_Bean" %>
<%@ page import = "board2.Member_DB_Bean" %>
<%@ page import = "board2.Md5Enc" %>
<%
//로그인정보 불러오기
Member_Data_Bean member_info = null;
if(session.getAttribute("user_id") != null && session.getAttribute("user_pw") != null) {
	Member_DB_Bean mem_db = Member_DB_Bean.getInstance();
	member_info = mem_db.login_info((String)session.getAttribute("user_id"), (String)session.getAttribute("user_pw"));
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="tboard_css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="tboard_js.js"></script>


</head>
<body>