<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="basket_top" style="width:770px;margin:0 auto;margin-top:10px;margin-bottom:20px;">
	<h1 style="width:300px;">
		<div><img src="./images/basket.jpg" alt="상세정보" /></div>
		<p>&nbsp;상세정보</p>
	</h1>
</div>

<table cellpadding="5" cellspacing="0" class="basket_table" style="width:770px;margin:0 auto;margin-bottom:20px;">
<col width="100" />
<col width="100" />

	<tr>
		<th>주문일(예약번호)</th>
		<td>${rdata.dates}(${rdata.no})</td>
	</tr>
	<tr>
		<th>가상계좌</th>
		<td>[${rdata.bank}] <span style="color:blue;">${rdata.bank_num}</span></td>
	</tr>
	<tr>
		<th>결제금액</th>
		<td>${rdata.moneys}원</td>
	</tr>
	<tr>
		<th>상태</th>
		<td>
			<c:if test="${rdata.status eq 1}">입금대기중</c:if>
			<c:if test="${rdata.status eq 2}">결제완료</c:if>
			<c:if test="${rdata.status eq 3}">리뷰완료</c:if>
			<c:if test="${rdata.status eq 4}">예약취소</c:if>
		</td>
	</tr>
</table>


	<div class="basket_con">
		<h1 class="basket_con_h">
			<div></div>
			<p>예약 상세정보</p>
		</h1>
		
		
		<div class="basket_con_data">
			<h1>${rdata.subject}</h1>
			<div class="basket_con_data_l">
				<a href="view.o?no=${rdata.list_no}" target="_BLANK"><img src="./upload/${rdata.file1}" alt="img" width="200px" height="135px" /></a>
			</div>
			<div class="basket_con_data_r">
				<table cellspacing="0" cellpadding="10" border="0">
				<col width="110px" />
				<col width="130px" />
				<col width="80px" />
				<col width="140px" />
					<tr>
						<th colspan="4" style="text-align:center;">
							상품번호&nbsp;&nbsp;<span style="color:#029c14;">${rdata.list_no}</span>&nbsp;&nbsp;&nbsp;&nbsp;
							예약상품번호&nbsp;&nbsp;<span style="color:#029c14;">${rdata.list_reserve_no}</span>
						</th>
					</tr>
					<tr>
						<th>도시</th>
						<td colspan="3">${rdata.city}</td>
					</tr>
					<tr>
						<th>출발일(여행기간)</th>
						<td colspan="3">${rdata.startdates} ~ ${rdata.enddates}(${rdata.days}일)</td>
					</tr>
					<tr>
						<th>항공사</th>
						<td colspan="3">${rdata.air}</td>
					</tr>
					<tr>
						<th>여행요금</th>
						<td>${rdata.moneys}원</td>
						<th>인원</th>
						<td>${rdata.cnts}</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
		
		

<div class="join_red_button" style="margin:0 auto;margin-bottom:40px;">
		<a href="mypage.o?pages=${pages}">확인완료</a>
</div>