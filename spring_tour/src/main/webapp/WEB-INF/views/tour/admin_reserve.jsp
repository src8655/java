<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="basket_top">
	<h1 style="width:300px;">
		<div><img src="./images/basket.jpg" alt="예약리스트" /></div>
		<p>&nbsp;예약리스트</p>
	</h1>
</div>


<table cellpadding="5" cellspacing="0" class="basket_table" style="width:770px;margin:0 auto;">
<col width="100" />
<col width="100" />
<col width="300" />
<col width="100" />
<col width="100" />
<col width="100" />
<col width="100" />
	<tr>
		<th>예약일자</th>
		<th colspan="2">예약상품정보</th>
		<th>출발/도착일</th>
		<th>금액(인원)</th>
		<th>
			<select onchange="ctrl_select('admin_reserve.o?pages=${pages}&searchs=${searchs_utf}&status=',this);">
				<option value="-1">전체보기</option>
				<option value="1" <c:if test="${status eq 1}">selected</c:if>>입금대기중</option>
				<option value="2" <c:if test="${status eq 2}">selected</c:if>>결제완료</option>
				<option value="3" <c:if test="${status eq 3}">selected</c:if>>리뷰완료</option>
				<option value="4" <c:if test="${status eq 4}">selected</c:if>>예약취소</option>
			</select>
		</th>
		<th>입금확인</th>
	</tr>
	<tr>
	<c:forEach items="${list}" var="rdata">
		<td>
			${rdata.dates}<br />
			<input type="button" value="상세보기" class="basket_delete" onclick="location.href='admin_reserve_view.o?no=${rdata.no}&pages=${pages}&status=${status}&searchs=${searchs_utf}'" />
		</td>
		<td><a href="view.o?no=${rdata.list_no}" target="_BLANK"><img src="./upload/${rdata.file1}" alt="${sdata.file1}" width="50px" height="50px" /></a></td>
		<td style="text-align:left;"><a href="view.o?no=${rdata.list_no}" target="_BLANK">${rdata.subject}</a></td>
		<td>
			${rdata.startdates}
			${rdata.enddates}
		</td>
		<td>
			${rdata.moneys}원<br />
			(${rdata.cnts}명)
		</td>
		<td>
			<c:if test="${rdata.status eq 1}">입금대기중</c:if>
			<c:if test="${rdata.status eq 2}">결제완료</c:if>
			<c:if test="${rdata.status eq 3}">리뷰완료</c:if>
			<c:if test="${rdata.status eq 4}">예약취소</c:if>
		</td>
		<td>
			<c:if test="${rdata.status eq 1}"><input type="button" value="입금확인" class="basket_order" onclick="location.href='admin_reserve_pay.o?no=${rdata.no}&pages=${pages}&status=${status}&searchs=${searchs_utf}'" /><br /></c:if>
		</td>
	</tr>
	</c:forEach>
</table>



  <div class="list_page">
	<a href="admin_reserve.o?pages=1&status=${status}&searchs=${searchs_utf}" class="list_page_a">◀</a>
	<c:forEach begin="${paging.pstarts}" end="${paging.pends}" step="1" var="i">
		<a href="admin_reserve.o?pages=${i}&status=${status}&searchs=${searchs_utf}" <c:if test="${i ne pages}"> class="list_page_a"</c:if> <c:if test="${i eq pages}"> class="list_page_a_hover"</c:if>>${i}</a>
	</c:forEach>
	<a href="admin_reserve.o?pages=${paging.board_paging}&status=${status}&searchs=${searchs_utf}" class="list_page_a">▶</a>
  </div>
  
   
   