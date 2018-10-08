<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="login_find_id_post.o" method="post" name="login">
<div class="login_find_bg">
	<h1><span style="color:#4e6cce;">내 회원정보</span>로 찾기</h1>
	<p class="login_find_p" style="font-size:15px;">
		<c:if test="${user_id eq null}">
			아이디를 찾을 수 없습니다.<br />
			<span style="font-weight:bold;">이름</span>과 <span style="font-weight:bold;">휴대전화번호</span>를 확인해주세요.
		</c:if>
		<c:if test="${user_id ne null}">
			회원님의 아이디는 <span style="font-weight:bold;">${user_id}</span> 입니다<br />
		</c:if>
	</p>
	<div class="login_find_b">
		<input type="button" value="다시찾기" onclick="location.href='login_find_id.o'" />
		<input type="button" value="비밀번호찾기" onclick="location.href='login_find_pw.o'" />
	</div>
</div>
</form>

