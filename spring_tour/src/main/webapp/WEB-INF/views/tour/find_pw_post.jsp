<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="find_pw_change.o" method="post" name="login">
<input type="hidden" name="user_id" value="${user_id}" />
<input type="hidden" name="name" value="${name}" />
<input type="hidden" name="phone1" value="${phone1}" />
<input type="hidden" name="phone2" value="${phone2}" />
<input type="hidden" name="phone3" value="${phone3}" />
<input type="hidden" name="quest" value="${quest}" />
<input type="hidden" name="answer" value="${answer}" />
<div class="login_find_bg">
	<h1><span style="color:#4e6cce;">내 회원정보</span>로 찾기</h1>
	<p class="login_find_p">
		<c:if test="${res eq 0}">
			등록되어 있는 <span style="font-weight:bold;">회원정보</span>를 찾을 수 없습니다.<br />
			다시 시도해주세요.
		</c:if>
		<c:if test="${res eq 1}">
			등록되어 있는 <span style="font-weight:bold;">회원정보</span>를 찾았습니다.<br />
			재설정할 비밀번호를 입력해주세요.
		</c:if>
	</p>
	<c:if test="${res eq 1}">
		<div class="login_find_c">
			<div class="login_find_c_l">비밀번호</div>
			<div class="login_find_c_r"><input type="password" name="user_pw" class="login_find_input" /></div>
		</div>
		<div class="login_find_c">
			<div class="login_find_c_l">비밀번호확인</div>
			<div class="login_find_c_r"><input type="password" name="user_pw2" class="login_find_input" /></div>
		</div>
	</c:if>
	<div class="login_find_b">
		<input type="button" value="뒤로가기" onclick="history.go(-1);" />
		<c:if test="${res eq 1}"><input type="submit" value="비밀번호 변경" /></c:if>
	</div>
</div>
</form>

