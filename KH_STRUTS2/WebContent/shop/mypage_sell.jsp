<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="basket_top" style="width:965px;margin:0 auto;margin-top:10px;margin-bottom:20px;">
	<h1 style="width:600px;">
		<div><img src="./images/basket.jpg" alt="장바구니" /></div>
		<p>&nbsp;판매된 상품</p>
	</h1>
</div>

<table cellpadding="5" cellspacing="0" class="basket_table" style="width:965px;margin:0 auto;">
<col width="100" />
<col width="50" />
<col width="200" />
<col width="100" />
<col width="100" />
<col width="100" />
<col width="100" />
<col width="100" />
<col width="150" />
	<tr>
		<th>주문번호</th>
		<th colspan="2">상품정보</th>
		<th>주문일자</th>
		<th>구매자</th>
		<th>수량</th>
		<th>금액</th>
		<th>
			<select onchange="ctrl_select('mypage_sell.o?cate=',this);">
				<option value="-1">전체</option>
				<option value="1" <c:if test="${cate eq 1}">selected</c:if>>입금대기중</option>
				<option value="2" <c:if test="${cate eq 2}">selected</c:if>>결제완료</option>
				<option value="3" <c:if test="${cate eq 3}">selected</c:if>>배송준비중</option>
				<option value="4" <c:if test="${cate eq 4}">selected</c:if>>배송중</option>
			</select>
		</th>
		<th>상태변경</th>
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
			<c:if test="${sdata.status eq 1}">입금대기중</c:if>
			<c:if test="${sdata.status eq 2}">결제완료</c:if>
			<c:if test="${sdata.status eq 3}">배송준비중</c:if>
			<c:if test="${sdata.status eq 4}">배송중</c:if>
		</td>
		<td>
			<c:if test="${sdata.status eq 2}">
				<input type="button" value="배송준비중으로 변경" style="width:95%;" class="basket_delete" onclick="location.href='mypage_sell_post.o?no=${sdata.no}&status=${sdata.status}&pages=${pages}&cate=${cate}'" />
			</c:if>
			<c:if test="${sdata.status eq 3}">
				<form action="mypage_sell_post.o" method="post">
					<input type="hidden" name="cate" value="${cate}" />
					<input type="hidden" name="pages" value="${pages}" />
					<input type="hidden" name="no" value="${sdata.no}" />
					<input type="hidden" name="status" value="${sdata.status}" />
					운송장번호<br />
					<input type="text" name="ship_num" class="ship_num_input" /><br />
					<input type="submit" value="배송중으로 변경" style="width:95%;" class="basket_order" />
				</form>
			</c:if>
			<c:if test="${sdata.status eq 4}">
				${sdata.ship_company}<br />
				(${sdata.ship_num})
			</c:if>
		</td>
	</tr>
</c:forEach>
</table>

<div class="list_page">
	<a href="mypage_sell.o?pages=1&cate=${cate}" class="list_page_a">◀</a>
	<c:forEach begin="${paging.pstarts}" end="${paging.pends}" step="1" var="i">
		<a href="mypage_sell.o?pages=${i}&cate=${cate}" <c:if test="${i ne pages_int}"> class="list_page_a"</c:if> <c:if test="${i eq pages_int}"> class="list_page_a_hover"</c:if>>${i}</a>
	</c:forEach>
	<a href="mypage_sell.o?pages=${paging.board_paging}&cate=${cate}" class="list_page_a">▶</a>
</div>