<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ page import = "board2.Member_Data_Bean" %>
<%@ page import = "board2.Member_DB_Bean" %>
<%@ page import = "board2.Md5Enc" %>
<%
//공통으로 받는 파라미터
String id = "";
String pages = "1";
String searchs = "";
String searchs_value = "";

if(request.getParameter("id") != null)
	id = request.getParameter("id");
if(request.getParameter("pages") != null)
	pages = request.getParameter("pages");
if(request.getParameter("searchs") != null)			//검색
	searchs = request.getParameter("searchs");
if(request.getParameter("searchs_value") != null)	//검색어
	searchs_value = request.getParameter("searchs_value");


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
<title>Insert</title>
<link href="tboard_css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="tboard_js.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>


</head>
<body>