<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<form action="find_pw.o" method="post" id="find_pw_form">
	<input type="hidden" name="user_id" value="${user_id}" />
	<input type="hidden" name="name" value="${name}" />
	<input type="hidden" name="phone1" value="${phone1}" />
	<input type="hidden" name="phone2" value="${phone2}" />
	<input type="hidden" name="phone3" value="${phone3}" />
</form>
<div class="login_find_bg">
	<h1><span style="color:#4e6cce;">내 회원정보</span>로 찾기</h1>
	<p class="login_find_p" style="font-size:15px;">
		<c:if test="${user_id eq ''}">
			아이디를 찾을 수 없습니다.<br />
			<span style="font-weight:bold;">이름</span>과 <span style="font-weight:bold;">휴대전화번호</span>를 확인해주세요.
		</c:if>
		<c:if test="${user_id ne ''}">
			회원님의 아이디는 <span style="font-weight:bold;">${user_id}</span> 입니다<br />
		</c:if>
	</p>
	<div class="login_find_b">
		<input type="button" value="다시찾기" onclick="location.href='find_id.o'" />
		<input type="button" value="비밀번호찾기" onclick="find_pw_form.submit();" />
	</div>
</div>

