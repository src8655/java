<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="basket_top" style="width:800px;margin:0 auto;margin-top:10px;margin-bottom:20px;">
	<h1 style="width:600px;">
		<div><img src="./images/basket.jpg" alt="장바구니" /></div>
		<p>&nbsp;회원목록 관리</p>
	</h1>
</div>
<table cellpadding="5" cellspacing="0" class="basket_table" style="width:800px;margin:0 auto;">
<col width="100" />
<col width="100" />
<col width="100" />
<col width="100" />
<col width="150" />
<col width="150" />
<col width="100" />
	<tr>
		<th>회원번호</th>
		<th>회원분류</th>
		<th>이름</th>
		<th>아이디</th>
		<th>이메일</th>
		<th>전화번호</th>
		<th>상세보기</th>
	</tr>
<c:forEach var="mdata" items="${list}">
	<tr>
		<td>${mdata.no}</td>
		<td>
			<c:if test="${mdata.orders eq 1}">[일반회원]</c:if>
			<c:if test="${mdata.orders eq 2}">[판매회원]</c:if>
			<c:if test="${mdata.orders eq 3}">[관리자]</c:if>
		</td>
		<td>${mdata.name}</td>
		<td>${mdata.user_id}</td>
		<td>${mdata.email}</td>
		<td>${mdata.phone1}-${mdata.phone2}-${mdata.phone3}</td>
		<td>
			<input type="button" value="상세보기" class="basket_order" onclick="location.href='mypage_admin_member_edit.o?no=${mdata.no}&pages=${pages}'" />
		</td>
	</tr>
</c:forEach>
</table>
  <div class="list_page">
	<a href="mypage_admin_member.o?pages=1&amp;searchs=${searchs}&amp;searchs_value=${searchs_value}" class="list_page_a">◀</a>
	<c:forEach begin="${paging.pstarts}" end="${paging.pends}" step="1" var="i">
		<a href="mypage_admin_member.o?pages=${i}&amp;searchs=${searchs}&amp;searchs_value=${searchs_value}" <c:if test="${i ne pages_int}"> class="list_page_a"</c:if> <c:if test="${i eq pages_int}"> class="list_page_a_hover"</c:if>>${i}</a>
	</c:forEach>
	<a href="mypage_admin_member.o?pages=${paging.board_paging}&amp;searchs=${searchs}&amp;searchs_value=${searchs_value}" class="list_page_a">▶</a>
  </div>
  