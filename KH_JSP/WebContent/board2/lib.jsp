<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
Connection conn = null;
PreparedStatement pstmt = null;


String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";
conn = DriverManager.getConnection(jdbcDriver);
%>