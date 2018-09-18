<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<c:if test="${res eq 0}">
	<script>
		alert('가입 실패');
		history.go(-1);
	</script>
</c:if>

</div>

<div class="join_agree_bg">

<div class="join_agree">
	<div class="join_agree_header">
		<h1>
			<c:if test="${order eq 1}">개인 구매회원 가입</c:if>
			<c:if test="${order eq 2}">사업자 판매회원 가입</c:if>
		</h1>
		<ul>
			<li style="color:#ea0000;border-bottom:2px solid #ea0000;">4 가입완료</li>
			<li>3 정보입력</li>
			<li>2 약관동의</li>
			<li>1 회원선택</li>
		</ul>
	</div>
	<p class="join_agree_c">회원정보를 입력해주세요. 모두 입력하셔야 가입이 가능합니다.</p>


	<p class="join_agree_end"><span style="color:blue;">${name}님</span>의 회원가입이 완료되었습니다.</p>


	<div class="join_red_button">
		<a href="login.o">로그인</a>
	</div>
</form>
</div>

</div>

<div>
<%@ include file="foot.jsp" %>