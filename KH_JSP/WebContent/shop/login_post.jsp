<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<c:if test="${res == 1}">
	<script>
		alert("로그인 성공");
		location.href="index.o";
	</script>
</c:if>
<c:if test="${res == 0}">
	<script>
		alert("로그인 실패");
		history.go(-1);
	</script>
</c:if>
<%@ include file="foot.jsp" %>