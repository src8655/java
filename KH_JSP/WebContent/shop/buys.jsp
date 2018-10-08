<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="basket_top">
	<h1>
		<div><img src="./images/basket.jpg" alt="장바구니" /></div>
		<p>주문/결제</p>
	</h1>
	<ul>
		<li>주문완료</li>
		<li><img src="./images/basket_03_gray.jpg" alt="lev_03" /></li>
		<li><img src="./images/basket_r.jpg" alt="lev_r" /></li>
		<li>주문/결제</li>
		<li><img src="./images/basket_02_red.jpg" alt="lev_02" /></li>
		<li><img src="./images/basket_r.jpg" alt="lev_r" /></li>
		<li>장바구니</li>
		<li><img src="./images/basket_01_gray.jpg" alt="lev_01" /></li>
		
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
	</tr>
<c:forEach var="ldata" items="${list}">
	<tr>
		<td><a href="view.o?no=${ldata.no}" target="_BLANK"><img src="./upload/${ldata.file1}" alt="${ldata.name}" width="100px" height="100px" /></a></td>
		<td style="text-align:left;"><a href="view.o?no=${ldata.no}" target="_BLANK">${ldata.name}</a></td>
		<td>${ldata.basket_cnt}</td>
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
	</tr>
</c:forEach>
</table>



<div class="join_agree">
	<div class="join_agree_header">
		<h1>받는사람 정보 입력</h1>
		<ul>
			<li style="color:#ea0000;border-bottom:2px solid #ea0000;">정보입력</li>
		</ul>
	</div>
	<p class="join_agree_c">받는사람 정보를 모두 입력해주세요. 모두 입력하셔야 결제가 가능합니다.</p>

<form action="buys_post.o" method="post" id="join" name="buys">
<input type="hidden" name="order" value="${order}" />
	<table cellpadding="15" cellspacing="0" class="joins" style="margin-bottom:10px;">
		<col width="130" />
		<col width="370" />
		<tr>
			<th><span style="color:#e61337;">•</span> 받는사람 이름</th>
			<td><input type="text" name="name" class="join_input" placeholder="이름을 입력해 주세요" value="${member_info.name}" /></td>
		</tr>
		<tr>
			<th><span style="color:#e61337;">•</span> 우편번호</th>
			<td>
				<div style="float:left;"><input type="text" name="zipcode" id="addr_code" style="width:100px;" class="join_input" value="${member_info.zipcode}" /></div>
				<div style="float:left;margin:0 0 0 5px;"><input type="button" value="우편번호 찾기" onclick="btn_find_daum()" class="join_id_button" /></div>
			</td>
		</tr>
		<tr>
			<th><span style="color:#e61337;">•</span> 주소</th>
			<td><input type="text" name="addr" id="addr" style="width:350px;" class="join_input" value="${member_info.addr}" /></td>
		</tr>
		<tr>
			<th><span style="color:#e61337;">•</span> 휴대폰 <span style="font-weight:bold;color:red;font-size:11px;"></span></th>
			<td><input type="text" name="phone1" style="width:60px;" class="join_input" value="${member_info.phone1}" /> - <input type="text" name="phone2" style="width:60px;" class="join_input" value="${member_info.phone2}" /> - <input type="text" name="phone3" style="width:60px;" class="join_input" value="${member_info.phone3}" /></td>
		</tr>
		<tr>
			<th><span style="color:#e61337;"></span> 배송시 요청사항</th>
			<td><input type="text" name="ship_memo" id="ship_memo" style="width:350px;" class="join_input" /></td>
		</tr>
		<tr>
			<th><span style="color:#e61337;"></span> 포인트 사용</th>
			<td>
				<input type="text" name="point_num" id="point_num" style="width:70px;" value="0" class="join_input" />
				<input type="button" value="적용" onclick="point_checkbox(this, ${member_info.point}, ${total_rmoney}, 0);" class="join_id_button" />
				<input type="checkbox" name="point" id="point" value="1" onchange="point_checkbox(this, ${member_info.point}, ${total_rmoney}, 1);" />
				<label for="point">모두사용 (${member_info.point} point)</label>
			</td>
		</tr>
	</table>
</form>
</div>



<table cellpadding="0" cellspacing="0" class="basket_b_table" id="bstable1">
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
<table cellpadding="0" cellspacing="0" class="basket_b_table" id="bstable2" style="display:none;">
<col width="70" />
<col width="100" />
<col width="70" />
<col width="100" />
<col width="70" />
<col width="100" />
<col width="70" />
<col width="100" />
<col width="70" />
<col width="100" />
	<tr>
		<td style="padding-left:0px;padding-right:0px;">주문금액</td>
		<td style="padding-left:0px;padding-right:0px;border-right:1px solid #dedfe2;text-align:right;font-size:18px;">${total_moneys}원</td>
		<td style="padding-left:0px;padding-right:0px;">할인금액</td>
		<td style="padding-left:0px;padding-right:0px;border-right:1px solid #dedfe2;text-align:right;font-size:18px;">${total_discount_moneys}원</td>
		<td style="padding-left:0px;padding-right:0px;">배송비</td>
		<td style="padding-left:0px;padding-right:0px;border-right:1px solid #dedfe2;text-align:right;font-size:18px;">${total_ship_moneys}원</td>
		<td style="padding-left:0px;padding-right:0px;">포인트</td>
		<td style="padding-left:0px;padding-right:0px;border-right:1px solid #dedfe2;text-align:right;font-size:18px;color:red;" id="point_td1"></td>
		<td style="padding-left:0px;padding-right:0px;background:#e9edf6;">할인후<br />금액</td>
		<td style="padding-left:0px;padding-right:0px;text-align:right;font-size:18px;color:#ea0000;background:#e9edf6;" id="point_td2"></td>
	</tr>
</table>


<div class="basket_b">
	<a href="#" onclick="buys.submit()">구입하기</a>
</div>