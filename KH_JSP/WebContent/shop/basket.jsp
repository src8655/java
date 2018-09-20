<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>

<div class="basket_top">
	<h1>
		<div><img src="./images/basket.jpg" alt="장바구니" /></div>
		<p>장바구니</p>
	</h1>
	<ul>
		<li>주문완료</li>
		<li><img src="./images/basket_03_gray.jpg" alt="lev_03" /></li>
		<li><img src="./images/basket_r.jpg" alt="lev_r" /></li>
		<li>주문/결제</li>
		<li><img src="./images/basket_02_gray.jpg" alt="lev_02" /></li>
		<li><img src="./images/basket_r.jpg" alt="lev_r" /></li>
		<li>장바구니</li>
		<li><img src="./images/basket_01_red.jpg" alt="lev_01" /></li>
		
	</ul>
</div>

<table cellpadding="10" cellspacing="0" class="basket_table">
<col width="100" />
<col width="300" />
<col width="50" />
<col width="100" />
<col width="100" />
<col width="100" />
<col width="100" />
	<tr>
		<th colspan="2">상품/옵션정보</th>
		<th>수량</th>
		<th>상품금액</th>
		<th>할인금액</th>
		<th>할인후금액</th>
		<th>배송비</th>
		<th>주문</th>
	</tr>
<c:forEach var="ldata" items="${list}">
	<tr>
		<td><a href="view.o?no=${ldata.no}"><img src="./upload/${ldata.file1}" alt="${ldata.name}" width="100px" height="100px" /></a></td>
		<td style="text-align:left;"><a href="view.o?no=${ldata.no}">${ldata.name}</a></td>
		<td>
			<input type="text" name="counts" value="${ldata.basket_cnt}" id="counts${ldata.no}" class="basket_input" /><br />
			<input type="button" value="변경" onclick="basket_change('${ldata.no}','counts${ldata.no}')" class="basket_button" />
		</td>
		<td>${ldata.moneys}원</td>
		<td>${ldata.discount_moneys}원</td>
		<td><span style="font-weight:bold;color:#ea0000;">${ldata.rmoneys}원</span></td>
		<td>
			<c:if test="${ldata.ship_money eq 0}">
        	무료배송
	        </c:if>
	        <c:if test="${ldata.ship_money ne 0}">
	        ${ldata.ship_moneys}원
	        </c:if>
	        <br />
	        (${ldata.ship_company})
		</td>
		<td>
			<input type="button" value="주문하기" class="basket_order" onclick="location.href='buys.o?order=3&no=${ldata.no}&counts=${ldata.basket_cnt}'" /><br />
			<input type="button" value="삭제하기" onclick="basket_delete('${ldata.no}')" class="basket_delete" />
		</td>
	</tr>
</c:forEach>
</table>


<table cellpadding="0" cellspacing="0" class="basket_b_table">
<col width="100" />
<col width="100" />
<col width="100" />
<col width="100" />
<col width="100" />
<col width="100" />
<col width="100" />
<col width="100" />
	<tr>
		<td>주문금액</td>
		<td style="border-right:1px solid #dedfe2;text-align:right;font-size:18px;">${total_moneys}원</td>
		<td>할인금액</td>
		<td style="border-right:1px solid #dedfe2;text-align:right;font-size:18px;">${total_discount_moneys}원</td>
		<td>배송비</td>
		<td style="border-right:1px solid #dedfe2;text-align:right;font-size:18px;">${total_ship_moneys}원</td>
		<td style="background:#e9edf6;">할인후금액</td>
		<td style="text-align:right;font-size:18px;color:#ea0000;background:#e9edf6;">${total_rmoneys}원</td>
	</tr>
</table>

<div class="basket_b">
	<a href="buys.o?order=2">주문하기</a>
</div>
<%@ include file="foot.jsp" %>