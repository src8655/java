<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<c:if test="${res eq 1}">
	<c:redirect url="index.do" />
</c:if>
<c:if test="${res eq 0}">
	<script>
		alert('아이디 또는 비밀번호를 확인해주세요.');
		history.go(-1);
	</script>
</c:if>
<%@ include file="foot.jsp" %>