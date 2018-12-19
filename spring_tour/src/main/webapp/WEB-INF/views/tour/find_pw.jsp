<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="find_pw_post.o" method="post" name="login">
<div class="login_find_bg">
	<h1><span style="color:#4e6cce;">내 회원정보</span>로 찾기</h1>
	<p class="login_find_p">
		등록되어 있는 <span style="font-weight:bold;">회원정보</span>로 비밀번호를 재설정 할 수 있습니다.<br />
		아래정보를 입력해주세요.
	</p>
	<div class="login_find_c">
		<div class="login_find_c_l">아이디</div>
		<div class="login_find_c_r"><input type="text" name="user_id" class="login_find_input" value="${user_id}" /></div>
	</div>
	<div class="login_find_c">
		<div class="login_find_c_l">이름</div>
		<div class="login_find_c_r"><input type="text" name="name" class="login_find_input" value="${name}" /></div>
	</div>
	<div class="login_find_c">
		<div class="login_find_c_l">휴대전화</div>
		<div class="login_find_c_r">
			<input type="text" name="phone1" style="width:69px;" class="login_find_input" value="${phone1}" /> - 
			<input type="text" name="phone2" style="width:69px;" class="login_find_input" value="${phone2}" /> - 
			<input type="text" name="phone3" style="width:69px;" class="login_find_input" value="${phone3}" />
		</div>
	</div>
	<div class="login_find_c">
		<div class="login_find_c_l">질문/답변</div>
		<div class="login_find_c_r">
			<select name="quest" style="width:250px;margin-bottom:3px;" class="login_find_input">
				<option value="-1">질문을 선택해 주세요.</option>
				<option value="1">나의 아버지 이름은?</option>
				<option value="2">내가 다니던 학교 이름은?</option>
				<option value="3">나의 취미는?</option>
				<option value="4">내가 좋아하던 게임은?</option>
				<option value="5">나의 직업은?</option>
			</select>
		</div>
	</div>
	<div class="login_find_c">
		<div class="login_find_c_l">&nbsp;</div>
		<div class="login_find_c_r">
			<input type="text" name="answer" style="width:250px;" class="login_find_input" placeholder="답변을 작성해 주세요." />
		</div>
	</div>
	<div class="login_find_b">
		<input type="submit" value="확인" />
	</div>
</div>
</form>

