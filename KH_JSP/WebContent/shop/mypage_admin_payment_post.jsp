<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>

<c:if test="${res eq 1}">
	<script>
		alert('입금확인 완료');
		location.href='mypage_admin_payment.o';
	</script>
</c:if>
<c:if test="${res eq 0}">
	<script>
		alert('입금확인 실패');
		history.go(-1);
	</script>
</c:if>

<%@ include file="foot.jsp" %>