<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>


<%
String id = request.getParameter("id");
String pages = request.getParameter("pages");

session.setAttribute("user_id", null);
session.setAttribute("user_pw", null);

response.sendRedirect("board.jsp?id="+id+"&pages="+pages);


%>

<%@ include file="foot.jsp" %>