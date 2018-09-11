<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<c:if test="${res eq 1}">
	<c:redirect url="board_view.do?id=${id}&pages=${pages}&no=${data_no}" />
</c:if>
<c:if test="${res eq 0}">
	<script>
		alert('비밀번호가 다릅니다.');
		history.go(-1);
	</script>
</c:if>
<%@ include file="foot.jsp" %>