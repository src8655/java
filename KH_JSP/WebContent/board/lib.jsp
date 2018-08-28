<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
String jdbcdriver = "oracle.jdbc.driver.OracleDriver";
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String user = "LSM8655";
String password = "minho123";

Connection conn = null;
PreparedStatement pstmt = null;

Class.forName(jdbcdriver);
conn = DriverManager.getConnection(url, user, password);
%>