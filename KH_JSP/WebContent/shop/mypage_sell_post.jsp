<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>

<c:if test="${res eq 1}">
	<script>
		alert('수정 완료');
		location.href='mypage_sell.o?pages=${pages}&cate=${cate}';
	</script>
</c:if>
<c:if test="${res eq 0}">
	<script>
		alert('수정 실패');
		history.go(-1);
	</script>
</c:if>

<%@ include file="foot.jsp" %>