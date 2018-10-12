<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</div>

<div class="join_agree_bg">

<div class="join_agree">
	<div class="join_agree_header">
		<h1>
			<c:if test="${order eq 1}">개인 구매회원 가입</c:if>
			<c:if test="${order eq 2}">사업자 판매회원 가입</c:if>
		</h1>
		<ul>
			<li>4 가입완료</li>
			<li>3 정보입력</li>
			<li style="color:#ea0000;border-bottom:2px solid #ea0000;">2 약관동의</li>
			<li>1 회원선택</li>
		</ul>
	</div>
	<p class="join_agree_c">개인 구매회원/사업자 판매회원은 개인정보 수집 및 이용에 동의하셔야 회원가입이 가능합니다.</p>
	<div class="join_agree_b">
		<div class="join_agree_b_t">
			<h1>12번가 개인정보 이용 약관 동의</h1>
			<input type="checkbox" name="agrees" id="agrees" />
			<label for="agrees"></label>
			<p>모두동의</p>
		</div>
		<div class="join_agree_b_b">
			<div>
				<%@ include file="agrees.jsp" %>
			</div>
		</div>
	</div>
	<div class="join_red_button">
		<a href="#10" onclick="join_agree_next('${order}')">다음</a>
	</div>
</div>

</div>

<div>