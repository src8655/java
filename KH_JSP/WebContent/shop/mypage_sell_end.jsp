<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="basket_top" style="width:800px;margin:0 auto;margin-top:10px;margin-bottom:20px;">
	<h1 style="width:600px;">
		<div><img src="./images/basket.jpg" alt="장바구니" /></div>
		<p>&nbsp;판매완료 상품</p>
	</h1>
</div>

<table cellpadding="5" cellspacing="0" class="basket_table" style="width:800px;margin:0 auto;">
<col width="100" />
<col width="50" />
<col width="200" />
<col width="100" />
<col width="100" />
<col width="100" />
<col width="100" />
<col width="100" />
	<tr>
		<th>주문번호</th>
		<th colspan="2">상품정보</th>
		<th>주문일자</th>
		<th>구매자</th>
		<th>수량</th>
		<th>금액</th>
		<th>
			상태
		</th>
	</tr>
<c:forEach var="sdata" items="${list}">
	<tr>
		<td>${sdata.no}</td>
		<td><a href="view.o?no=${sdata.product_no}" target="_BLANK"><img src="./upload/${sdata.file1}" alt="${sdata.product_name}" width="80px" height="80px" /></a></td>
		<td><a href="view.o?no=${sdata.product_no}" target="_BLANK">${sdata.product_name}</a></td>
		<td>${sdata.dates}</td>
		<td>
			(${sdata.guest_no})<br />
			${sdata.name}
		</td>
		<td>${sdata.counts}개</td>
		<td>${sdata.totals}원</td>
		<td>
			배송완료
		</td>
	</tr>
</c:forEach>
</table>

<div class="list_page">
	<a href="mypage_sell_end.o?pages=1" class="list_page_a">◀</a>
	<c:forEach begin="${pstarts}" end="${pends}" step="1" var="i">
		<a href="mypage_sell_end.o?pages=${i}" <c:if test="${i ne pages_int}"> class="list_page_a"</c:if> <c:if test="${i eq pages_int}"> class="list_page_a_hover"</c:if>>${i}</a>
	</c:forEach>
	<a href="mypage_sell_end.o?pages=${board_paging}" class="list_page_a">▶</a>
</div>