<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>

<div class="basket_top" style="width:800px;margin:0 auto;margin-top:10px;margin-bottom:20px;">
	<h1 style="width:300px;">
		<div><img src="./images/basket.jpg" alt="장바구니" /></div>
		<p>&nbsp;나의 쇼핑정보</p>
	</h1>
</div>


<h1 class="mypage_h"><img src="./images/mypage_h_01.jpg" alt="진행 중인 주문" /></h1>
<ul class="mypage_p">
	<li class="mypage_p_01">
		<img src="./images/mypage_t_h_01.jpg" alt="입금대기중" />
		<div>
			<p>${process1}</p>
			<img src="./images/mypage_t_01.jpg" alt="입금대기중" />
		</div>
	</li>
	<li class="mypage_p_02"></li>
	<li class="mypage_p_01">
		<img src="./images/mypage_t_h_02.jpg" alt="결제완료" />
		<div>
			<p>${process2}</p>
			<img src="./images/mypage_t_02.jpg" alt="결제완료" />
		</div>
	</li>
	<li class="mypage_p_02"></li>
	<li class="mypage_p_01">
		<img src="./images/mypage_t_h_03.jpg" alt="배송준비중" />
		<div>
			<p>${process3}</p>
			<img src="./images/mypage_t_03.jpg" alt="배송준비중" />
		</div>
	</li>
	<li class="mypage_p_02"></li>
	<li class="mypage_p_01">
		<img src="./images/mypage_t_h_04.jpg" alt="배송중" />
		<div>
			<p>${process4}</p>
			<img src="./images/mypage_t_04.jpg" alt="배송중" />
		</div>
	</li>
	<li class="mypage_p_02"></li>
	<li class="mypage_p_01">
		<img src="./images/mypage_t_h_05.jpg" alt="배송완료" />
		<div>
			<p>${process5}</p>
			<img src="./images/mypage_t_05.jpg" alt="배송완료" />
		</div>
	</li>
</ul>
<h1 class="mypage_h"><img src="./images/mypage_h_02.jpg" alt="최근 주문 정보" /></h1>
<table cellpadding="5" cellspacing="0" class="basket_table" style="width:800px;margin:0 auto;">
<col width="100" />
<col width="100" />
<col width="300" />
<col width="100" />
<col width="100" />
<col width="100" />
<col width="100" />
	<tr>
		<th>주문일자</th>
		<th colspan="2">주문상품정보</th>
		<th>금액(수량)</th>
		<th>배송비</th>
		<th>주문상태</th>
		<th>확인/취소</th>
	</tr>
<c:forEach var="sdata" items="${list}">
	<tr>
		<c:if test="${sdata.rowspans ne -1}">
		<td rowspan="${sdata.rowspans}">
			${sdata.dates}<br />
			<input type="button" value="상세보기" class="basket_delete" onclick="location.href='mypage_guest_view.o?times=${sdata.times}&pages=${pages}'" />
		</td>
		</c:if>
		<td><a href="view.o?no=${sdata.product_no}" target="_BLANK"><img src="./upload/${sdata.file1}" alt="${sdata.file1}" width="50px" height="50px" /></a></td>
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
			<c:if test="${sdata.status eq 4}">
				배송중<br />
				${sdata.ship_company}<br />
				(${sdata.ship_num})
			</c:if>
			<c:if test="${sdata.status eq 5}">배송완료</c:if>
		</td>
		<td>
			<c:if test="${sdata.status eq 4}"><input type="button" value="구매확정" class="basket_order" onclick="location.href='mypage_guest_post1.o?no=${sdata.no}&pages=${pages}'" /><br /></c:if>
			<c:if test="${sdata.status eq 1}"><input type="button" value="주문취소" class="basket_delete" onclick="location.href='mypage_guest_post2.o?no=${sdata.no}&pages=${pages}'" /></c:if>
		</td>
	</tr>
</c:forEach>
</table>

  <div class="list_page">
	<a href="mypage_guest.o?pages=1" class="list_page_a">◀</a>
	<c:forEach begin="${pstarts}" end="${pends}" step="1" var="i">
		<a href="mypage_guest.o?pages=${i}" <c:if test="${i ne pages_int}"> class="list_page_a"</c:if> <c:if test="${i eq pages_int}"> class="list_page_a_hover"</c:if>>${i}</a>
	</c:forEach>
	<a href="mypage_guest.o?pages=${board_paging}" class="list_page_a">▶</a>
  </div>
<%@ include file="foot.jsp" %>