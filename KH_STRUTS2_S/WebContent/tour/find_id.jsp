<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<form action="find_id_post.o" method="post" name="login">
<div class="login_find_bg">
	<h1><span style="color:#4e6cce;">내 회원정보</span>로 찾기</h1>
	<p class="login_find_p">
		등록되어 있는 <span style="font-weight:bold;">회원정보</span>로 아이디를 찾을 수 있습니다.<br />
		아래정보를 입력해주세요.
	</p>
	<div class="login_find_c">
		<div class="login_find_c_l">이름</div>
		<div class="login_find_c_r"><input type="text" name="name" class="login_find_input" /></div>
	</div>
	<div class="login_find_c">
		<div class="login_find_c_l">휴대전화</div>
		<div class="login_find_c_r">
			<input type="text" name="phone1" style="width:69px;" class="login_find_input" /> - 
			<input type="text" name="phone2" style="width:69px;" class="login_find_input" /> - 
			<input type="text" name="phone3" style="width:69px;" class="login_find_input" />
		</div>
	</div>
	<div class="login_find_b">
		<input type="submit" value="확인" />
	</div>
</div>
</form>
  	