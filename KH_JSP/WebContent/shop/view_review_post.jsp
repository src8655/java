<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${res eq 0}">
	<script>
		alert('작성 실패');
		history.go(-1);
	</script>
</c:if>
<c:if test="${res eq 1}">
	<script>
		alert('작성 성공');
		returnValue4('${product_no}');
	</script>
</c:if>
