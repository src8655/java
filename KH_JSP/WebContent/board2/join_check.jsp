<%@page import="board2.Member_DB_Bean"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>아이디 중복확인</title>
<script type="text/javascript">
//값 리턴해주기
function returnValue(result){
	opener.btn_check_return(result);	//결과를 리턴
	self.close();	//창닫기
}
</script>
</head>
<body style="text-align:center;padding:30px 0 0 0;">
<%
String user_id = request.getParameter("user_id");
String result = "0";	//결과코드


Member_DB_Bean mdb = Member_DB_Bean.getInstance();
int count = mdb.selectId(user_id);
	
if(count == 0) {
	result = "1";	//사용 가능한 상태로 설정
	out.print("사용할 수 있는 아이디 입니다.");
}else out.print("이미 존재하는 아이디 입니다.");
%>
<input type="button" onclick="returnValue('<%=result %>');" value="완료" />
</body>
</html>