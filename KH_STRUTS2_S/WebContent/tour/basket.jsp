<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="basket_top">
	<h1>
		<div><img src="./images/basket.jpg" alt="상품바구니" /></div>
		<p>상품바구니</p>
	</h1>
	<ul>
		<li>예약완료</li>
		<li><img src="./images/basket_03_gray.jpg" alt="lev_03" /></li>
		<li><img src="./images/basket_r.jpg" alt="lev_r" /></li>
		<li>예약/결제</li>
		<li><img src="./images/basket_02_gray.jpg" alt="lev_02" /></li>
		<li><img src="./images/basket_r.jpg" alt="lev_r" /></li>
		<li>상품바구니</li>
		<li><img src="./images/basket_01_red.jpg" alt="lev_01" /></li>
		
	</ul>
</div>
	
	<div class="basket_con">
		<h1 class="basket_con_h">
			<div></div>
			<p>상품 바구니</p>
		</h1>
		
		
		<c:if test="${isEmpty eq 0}">
		<c:forEach var="lrdata" items="${list}">
		<div class="basket_con_data">
			<h1><c:if test="${lrdata.special eq 1}"><span style="font-weight:bold;color:red;">[!특가!]</span></c:if>${lrdata.subject}</h1>
			<div class="basket_con_data_l">
				<a href="view.o?no=${lrdata.list_no}" target="_BLANK"><img src="./upload/${lrdata.file1}" alt="img" width="200px" height="135px" /></a>
				<a href="reserve.o?no=${lrdata.no}" class="basket_btn1">예약하기</a>
				<a href="basket_del.o?no=${lrdata.no}" class="basket_btn2">삭제하기</a>
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
						<td>
							<form action="basket_edit.o" method="post">
							<input type="hidden" name="no" value="${lrdata.no}" />
								<div style="float:left;">
								<select name="max_cnts">
									<c:forEach begin="1" end="${lrdata.max_cnts}" step="1" var="i">
									<option value="${i}" <c:if test="${i eq lrdata.choice_cnts}">selected</c:if>>${i}명</option>
									</c:forEach>
								</select>
								</div>
								<div style="float:left;"><input type="submit" value="변경" /></div>
							</form>
						</td>
					</tr>
				</table>
			</div>
		</div>
		</c:forEach>
		</c:if>
		
		
	</div>
</div>

