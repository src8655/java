<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>

<div class="basket_top" style="width:800px;margin:0 auto;margin-top:10px;margin-bottom:20px;">
	<h1 style="width:600px;">
		<div><img src="./images/basket.jpg" alt="장바구니" /></div>
		<p>&nbsp;판매상품 입금확인</p>
	</h1>
</div>

<table cellpadding="5" cellspacing="0" class="basket_table" style="width:800px;margin:0 auto;">
<col width="200" />
<col width="100" />
<col width="100" />
<col width="300" />
<col width="100" />
<col width="100" />
<col width="100" />
	<tr>
		<th>주문번호</th>
		<th>주문일자</th>
		<th>구매자</th>
		<th>가상계좌</th>
		<th>금액</th>
		<th>상태</th>
		<th>입금확인</th>
	</tr>
<c:forEach var="sgdata" items="${list}">
	<tr>
		<td>${sgdata.no}</td>
		<td>${sgdata.dates}</td>
		<td>
			(${sgdata.guest_no})<br />
			${sgdata.name}
		</td>
		<td>[${sgdata.bank}] ${sgdata.bank_num}</td>
		<td>${sgdata.totals}원</td>
		<td>입금대기중</td>
		<td>
			<input type="button" value="입금확인" class="basket_order" onclick="location.href='mypage_admin_payment_post.o?times=${sgdata.times}'" />
		</td>
	</tr>
</c:forEach>
</table>

<%@ include file="foot.jsp" %>