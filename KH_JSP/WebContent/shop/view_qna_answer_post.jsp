<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>문의내용 작성</title>
<script type="text/javascript">
//값 리턴해주기
function returnValue(result){
	opener.view_qna_answer_result(result);	//결과를 리턴
	self.close();	//창닫기
}
</script>
</head>
<body>
<c:if test="${res eq 0}">
	<script>
		alert('작성 실패');
		history.go(-1);
	</script>
</c:if>
<c:if test="${res eq 1}">
	<script>
		alert('작성 성공');
		returnValue('${product_no}&pages=${pages}');
	</script>
</c:if>
</body>
</html>