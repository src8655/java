<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="basket_top">
	<h1 style="width:400px;">
		<div><img src="./images/basket.jpg" alt="장바구니" /></div>
		<p>판매상품 목록</p>
	</h1>
	<ul style="width:400px;">
		<li>상품 : ${board_total} 건</li>
	</ul>
</div>
<ul id="list_tab" style="border-bottom:0px;">
  <li><a href="mypage_list.o?searchs_value=${searchs_values}" <c:if test="${searchs ne -1}">class="list_tab_a"</c:if> <c:if test="${searchs eq -1}">class="list_tab_a_hover"</c:if>>전체상품</a></li>
  <li><a href="mypage_list.o?searchs=1&amp;searchs_value=${searchs_values}" <c:if test="${searchs eq 1}">class="list_tab_a_hover"</c:if><c:if test="${searchs ne 1}">class="list_tab_a"</c:if>>쌀/잡곡</a></li>
  <li><a href="mypage_list.o?searchs=2&amp;searchs_value=${searchs_values}" <c:if test="${searchs eq 2}">class="list_tab_a_hover"</c:if><c:if test="${searchs ne 2}">class="list_tab_a"</c:if>>과일/채소</a></li>
  <li><a href="mypage_list.o?searchs=3&amp;searchs_value=${searchs_values}" <c:if test="${searchs eq 3}">class="list_tab_a_hover"</c:if><c:if test="${searchs ne 3}">class="list_tab_a"</c:if>>축산물</a></li>
  <li><a href="mypage_list.o?searchs=4&amp;searchs_value=${searchs_values}" <c:if test="${searchs eq 4}">class="list_tab_a_hover"</c:if><c:if test="${searchs ne 4}">class="list_tab_a"</c:if>>건강식품</a></li>
  <li><a href="mypage_list.o?searchs=5&amp;searchs_value=${searchs_values}" <c:if test="${searchs eq 5}">class="list_tab_a_hover"</c:if><c:if test="${searchs ne 5}">class="list_tab_a"</c:if>>가공식품</a></li>
  <li><a href="mypage_list.o?searchs=6&amp;searchs_value=${searchs_values}" <c:if test="${searchs eq 6}">class="list_tab_a_hover"</c:if><c:if test="${searchs ne 6}">class="list_tab_a"</c:if>>수산물</a></li>
  <li><a href="mypage_list.o?searchs=7&amp;searchs_value=${searchs_values}" <c:if test="${searchs eq 7}">class="list_tab_a_hover"</c:if><c:if test="${searchs ne 7}">class="list_tab_a"</c:if>>김치/장류</a></li>
  <li><a href="mypage_list.o?searchs=8&amp;searchs_value=${searchs_values}" <c:if test="${searchs eq 8}">class="list_tab_a_hover"</c:if><c:if test="${searchs ne 8}">class="list_tab_a"</c:if>>공예/공산품</a></li>
</ul>
  
<table cellpadding="10" cellspacing="0" class="basket_table" style="width:964px;">
<col width="100" />
<col width="300" />
<col width="100" />
<col width="100" />
<col width="100" />
<col width="100" />
	<tr>
		<th colspan="2">상품/옵션정보</th>
		<th>상품금액</th>
		<th>할인금액</th>
		<th>할인후금액</th>
		<th>배송비</th>
		<th>수정/삭제</th>
	</tr>
<c:forEach var="ldata" items="${list}">
	<tr>
		<td><a href="view.o?no=${ldata.no}"><img src="./upload/${ldata.file1}" alt="${ldata.name}" width="100px" height="100px" /></a></td>
		<td style="text-align:left;"><a href="view.o?no=${ldata.no}">${ldata.name}</a></td>
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
			<input type="button" value="수정하기" onclick="location.href='edit.o?no=${ldata.no}'" class="basket_order" /><br />
			<input type="button" value="삭제하기" onclick="location.href='del.o?no=${ldata.no}'" class="basket_delete" />
		</td>
	</tr>
</c:forEach>
</table>

<div class="list_page">
	<a href="mypage_list.o?pages=1&amp;searchs=${searchs}&amp;searchs_value=${searchs_value}" class="list_page_a">◀</a>
	<c:forEach begin="${pstarts}" end="${pends}" step="1" var="i">
		<a href="mypage_list.o?pages=${i}&amp;searchs=${searchs}&amp;searchs_value=${searchs_value}" <c:if test="${i ne pages_int}"> class="list_page_a"</c:if> <c:if test="${i eq pages_int}"> class="list_page_a_hover"</c:if>>${i}</a>
	</c:forEach>
	<a href="mypage_list.o?pages=${board_paging}&amp;searchs=${searchs}&amp;searchs_value=${searchs_value}" class="list_page_a">▶</a>
</div>

<div class="basket_b" style="display:none;">
	<a href="write.o">등록하기</a>
</div>