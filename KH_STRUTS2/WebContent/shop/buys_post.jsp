<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${res eq 0}">
	<script>
		alert('가입 실패');
		history.go(-1);
	</script>
</c:if>

<div class="basket_top">
	<h1>
		<div><img src="./images/basket.jpg" alt="장바구니" /></div>
		<p>주문완료</p>
	</h1>
	<ul>
		<li>주문완료</li>
		<li><img src="./images/basket_03_red.jpg" alt="lev_03" /></li>
		<li><img src="./images/basket_r.jpg" alt="lev_r" /></li>
		<li>주문/결제</li>
		<li><img src="./images/basket_02_gray.jpg" alt="lev_02" /></li>
		<li><img src="./images/basket_r.jpg" alt="lev_r" /></li>
		<li>장바구니</li>
		<li><img src="./images/basket_01_gray.jpg" alt="lev_01" /></li>
		
	</ul>
</div>

<div class="join_agree">


	<p class="join_agree_end">
	
	주문이 완료되었습니다.
	<br />
	<br />
	입금하실 가상계좌<br />
	[${admin_bank}] <span style="color:blue;">${admin_bank_num}</span>
	<br />
	<br />
	입금금액 : <span style="color:red;">${totals}원</span>
	</p>


	<div class="join_red_button">
		<a href="mypage_guest.o">나의 쇼핑정보</a>
	</div>

</div>


