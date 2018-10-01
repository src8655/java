<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>

<form action="login_post.o" method="post" name="login">
<div class="login_bg">
	<h1>12번가<span style="color:#333333;">로그인</span></h1>
	<div class="login">
		<div class="login_box">
			<div class="login_box_t">
				<div class="login_box_t_l">
					<input type="text" name="user_id" value="${user_id}" placeholder="12번가 아이디 입력" />
					<input type="password" name="user_pw" style="margin-top:3px;" placeholder="비밀번호 입력" />
				</div>
				<a href="#10" onclick="login.submit();">로그인</a>
			</div>
			<div class="login_box_c">
				<input type="checkbox" name="auto_id" value="1" id="auto_id" <c:if test="${user_id ne ''}">checked</c:if> /><label for="auto_id">아이디 저장</label>
			</div>
			<ul>
				<li><a href="join.o" style="color:#6283e3;border:1px solid #6283e3;">회원가입</a></li>
				<li><a href="#10">아이디 찾기</a></li>
				<li><a href="#10">비밀번호 찾기</a></li>
			</ul>
		</div>
	</div>
</div>
<input type="submit" value="로그인" style="display:none;" />
</form>



<%@ include file="foot.jsp" %>