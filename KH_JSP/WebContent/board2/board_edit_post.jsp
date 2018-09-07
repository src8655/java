<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<c:if test="${res eq 1}">
	<c:redirect url="sboard_view.jsp?id=${id}&pages=${pages}&no=${no}" />
</c:if>
<c:if test="${res eq 0}">
	<script>
		alert('작성 실패');
		history.go(-1);
	</script>
</c:if>
<%@ include file="foot.jsp" %>