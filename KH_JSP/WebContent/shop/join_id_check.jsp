<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>아이디 중복확인</title>
<style type="text/css">
.red_button {
background:#eb2b2b;
font-size:15px;
font-weight:bold;
color:#ffffff;
text-decoration:none;
display:block;
width:150px;
height:45px;
line-height:45px;
text-align:center;
margin:0 auto;
margin-top:20px;
border-top:1px solid #d81818;
border-right:1px solid #d81818;
border-bottom:1px solid #9e1212;
border-left:1px solid #d81818;
}
</style>
<script type="text/javascript">
//값 리턴해주기
function returnValue(result){
	opener.btn_check_return(result);	//결과를 리턴
	self.close();	//창닫기
}
</script>
</head>
<body style="font-size:12px;text-align:center;padding:30px 0 0 0;">
<c:if test="${result eq '1'}">
	사용할 수 있는 아이디 입니다.<br />
</c:if>
<c:if test="${result eq '0'}">
	이미 존재하는 아이디 입니다.<br />
</c:if>
<input type="button" onclick="returnValue('${result}');" class="red_button" value="확인" />
</body>
</html>