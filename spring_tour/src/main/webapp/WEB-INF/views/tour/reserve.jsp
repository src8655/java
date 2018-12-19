<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="basket_top">
	<h1>
		<div><img src="./images/basket.jpg" alt="주문/결제" /></div>
		<p>주문/결제</p>
	</h1>
	<ul>
		<li>주문완료</li>
		<li><img src="./images/basket_03_gray.jpg" alt="lev_03" /></li>
		<li><img src="./images/basket_r.jpg" alt="lev_r" /></li>
		<li>주문/결제</li>
		<li><img src="./images/basket_02_red.jpg" alt="lev_02" /></li>
		<li><img src="./images/basket_r.jpg" alt="lev_r" /></li>
		<li>상품바구니</li>
		<li><img src="./images/basket_01_gray.jpg" alt="lev_01" /></li>
		
	</ul>
</div>


	<div class="basket_con">
		<h1 class="basket_con_h">
			<div></div>
			<p>예약할 상품</p>
		</h1>
		<div class="basket_con_data">
			<h1>${lrdata.subject}</h1>
			<div class="basket_con_data_l">
				<img src="./upload/${lrdata.file1}" alt="img" width="200px" height="135px" />
			</div>
			<div class="basket_con_data_r">
				<table cellspacing="0" cellpadding="10" border="0">
				<col width="110px" />
				<col width="130px" />
				<col width="80px" />
				<col width="140px" />
					<tr>
						<th colspan="4" style="text-align:center;">
							상품번호&nbsp;&nbsp;<span style="color:#029c14;">${lrdata.list_no}</span>&nbsp;&nbsp;&nbsp;&nbsp;
							예약상품번호&nbsp;&nbsp;<span style="color:#029c14;">${lrdata.no}</span>
						</th>
					</tr>
					<tr>
						<th>도시</th>
						<td colspan="3">${lrdata.city}</td>
					</tr>
					<tr>
						<th>출발일(여행기간)</th>
						<td colspan="3">${lrdata.startdates} ~ ${lrdata.enddates}(${lrdata.days}일)</td>
					</tr>
					<tr>
						<th>항공사</th>
						<td colspan="3">${lrdata.air}</td>
					</tr>
					<tr>
						<th>여행요금</th>
						<td>${lrdata.moneys}원</td>
						<th>인원</th>
						<td>${lrdata.choice_cnts}명</td>
					</tr>
				</table>
			</div>
		</div>
	</div>




<div class="basket_b">
	<a href="reserve_post.o?no=${lrdata.no}">결제하기</a>
</div>