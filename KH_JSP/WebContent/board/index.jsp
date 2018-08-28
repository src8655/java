<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ include file="head.jsp" %>

<%

Connection conn = null;
PreparedStatement pstmt = null;

try {
	String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";
	conn = DriverManager.getConnection(jdbcDriver);
	
	pstmt = conn.prepareStatement("insert into MYTABLE(NO, NAME) values(?,?)");
	pstmt.setInt(1, 6);
	pstmt.setString(2, "testss");
	
	pstmt.executeUpdate();

}finally {
	if(pstmt != null) pstmt.close();
	if(conn != null) conn.close();
}
%>

<%@ include file="foot.jsp" %>