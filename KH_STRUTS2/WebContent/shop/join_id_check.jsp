<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="font-size:12px;text-align:center;padding:30px 0 0 0;">
<c:if test="${result eq '1'}">
	사용할 수 있는 아이디 입니다.<br />
</c:if>
<c:if test="${result eq '0'}">
	이미 존재하는 아이디 입니다.<br />
</c:if>
<input type="button" onclick="returnValue('${result}');" class="red_button" value="확인" />
</div>
