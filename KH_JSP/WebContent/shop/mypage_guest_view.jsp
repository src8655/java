<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>

<div class="basket_top" style="width:800px;margin:0 auto;margin-top:10px;margin-bottom:20px;">
	<h1 style="width:300px;">
		<div><img src="./images/basket.jpg" alt="장바구니" /></div>
		<p>&nbsp;상세정보</p>
	</h1>
</div>

<table cellpadding="5" cellspacing="0" class="basket_table" style="width:800px;margin:0 auto;margin-bottom:20px;">
<col width="100" />
<col width="100" />

	<tr>
		<th>주문일(주문번호)</th>
		<td>${sgdata.dates}(${sgdata.no})</td>
	</tr>
	<tr>
		<th>주문금액</th>
		<td>${sgdata.rmoneys}원</td>
	</tr>
	<tr>
		<th>배송비</th>
		<td>${sgdata.ship_moneys}원</td>
	</tr>
	<tr>
		<th>총 결제금액</th>
		<td><span style="color:red;">${sgdata.totals}원</span></td>
	</tr>
	<tr>
		<th>가상계좌</th>
		<td>[${sgdata.bank}] <span style="color:blue;">${sgdata.bank_num}</span></td>
	</tr>
</table>


<table cellpadding="5" cellspacing="0" class="basket_table" style="width:800px;margin:0 auto;">
<col width="300" />
<col width="100" />
<col width="100" />
<col width="100" />
	<tr>
		<th>주문상품정보</th>
		<th>금액(수량)</th>
		<th>배송비</th>
		<th>주문상태</th>
	</tr>
<c:forEach var="sdata" items="${list}">
	<tr>
		<td style="text-align:left;"><a href="view.o?no=${sdata.product_no}" target="_BLANK">${sdata.product_name}</a></td>
		<td>
			${sdata.rmoneys}원
			<br />
			(${sdata.counts}개)
		</td>
		<td>
			<c:if test="${sdata.ship_money eq 0}">
        	무료배송
	        </c:if>
	        <c:if test="${sdata.ship_money ne 0}">
	        ${sdata.ship_moneys}원
	        </c:if>
	        <br />
	        (${sdata.ship_company})
		</td>
		<td>
			<c:if test="${sdata.status eq 1}">입금대기중</c:if>
			<c:if test="${sdata.status eq 2}">결제완료</c:if>
			<c:if test="${sdata.status eq 3}">배송준비중</c:if>
			<c:if test="${sdata.status eq 4}">배송중</c:if>
			<c:if test="${sdata.status eq 5}">배송완료</c:if>
		</td>
	</tr>
</c:forEach>
</table>


<table cellpadding="5" cellspacing="0" class="basket_table" style="width:800px;margin:0 auto;margin-top:20px;">
<col width="50" />
<col width="100" />

	<tr>
		<th>받는사람</th>
		<td style="text-align:left;">
			<span style="font-weight:bold;">${sgdata.name}</span><br />
			(${sgdata.zipcode}) ${sgdata.addr}<br />
			${sgdata.phone1}-${sgdata.phone2}-${sgdata.phone3}<br />
			<br />
			배송시 요청사항 : ${sgdata.ship_memo}
		</td>
	</tr>
</table>

<div class="join_red_button" style="margin:0 auto;">
		<a href="mypage_guest.o?pages=${pages}">확인완료</a>
</div>
<%@ include file="foot.jsp" %>