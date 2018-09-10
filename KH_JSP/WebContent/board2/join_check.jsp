<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
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
<c:if test="${result eq '1'}">
	사용할 수 있는 아이디 입니다.
</c:if>
<c:if test="${result eq '0'}">
	이미 존재하는 아이디 입니다.
</c:if>
<input type="button" onclick="returnValue('${result}');" value="완료" />
</body>
</html>