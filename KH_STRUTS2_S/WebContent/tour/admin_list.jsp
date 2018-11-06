<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="basket_top">
	<h1 style="width:400px;">
		<div><img src="./images/basket.jpg" alt="여행상품리스트" /></div>
		<p>여행상품리스트</p>
	</h1>
	<ul style="width:200px;">
		<li>상품 : ${paging.board_total} 건</li>
	</ul>
</div>
  
<table cellpadding="10" cellspacing="0" class="basket_table" style="width:770px;margin:0 auto;">
<col width="100" />
<col width="100" />
<col width="300" />
<col width="100" />
<col width="100" />
<col width="100" />
	<tr>
		<th>
			<select onchange="ctrl_select('admin_list.o?pages=${pages}&searchs=${searchs_utf}&category=',this);">
				<option value="-1">전체보기</option>
				<option value="1" <c:if test="${category eq 1}">selected</c:if>>국내여행</option>
				<option value="2" <c:if test="${category eq 2}">selected</c:if>>중국/몽골</option>
				<option value="3" <c:if test="${category eq 3}">selected</c:if>>동남아</option>
				<option value="4" <c:if test="${category eq 4}">selected</c:if>>괌/사이판</option>
				<option value="5" <c:if test="${category eq 5}">selected</c:if>>남태평양</option>
				<option value="6" <c:if test="${category eq 6}">selected</c:if>>미주/중남미</option>
				<option value="7" <c:if test="${category eq 7}">selected</c:if>>유럽/중동</option>
			</select>
		</th>
		<th colspan="2">여행상품정보</th>
		<th>여행기간</th>
		<th>금액</th>
		<th>수정/삭제</th>
	</tr>
<c:forEach var="ldata" items="${list}">
	<tr>
		<td>
			<c:if test="${ldata.category eq 1}">국내여행</c:if>
			<c:if test="${ldata.category eq 2}">중국/몽골</c:if>
			<c:if test="${ldata.category eq 3}">동남아</c:if>
			<c:if test="${ldata.category eq 4}">괌/사이판</c:if>
			<c:if test="${ldata.category eq 5}">남태평양</c:if>
			<c:if test="${ldata.category eq 6}">미주/중남미</c:if>
			<c:if test="${ldata.category eq 7}">유럽/중동</c:if>
		</td>
		<td><a href="view.o?no=${ldata.no}" target="_BLANK"><img src="./upload/${ldata.file1}" alt="${ldata.subject}" width="100px" height="100px" /></a></td>
		<td style="text-align:left;"><a href="view.o?no=${ldata.no}" target="_BLANK">${ldata.subject}</a></td>
		<td>${ldata.days}일</td>
		<td>${ldata.moneys}원</td>
		<td>
			<input type="button" value="수정하기" onclick="location.href='admin_list_edit.o?no=${ldata.no}&pages=${pages}&searchs=${searchs_utf}'" class="basket_order" /><br />
			<input type="button" value="삭제하기" onclick="location.href='admin_list_del.o?no=${ldata.no}&pages=${pages}&searchs=${searchs_utf}'" class="basket_delete" />
		</td>
	</tr>
</c:forEach>
</table>

<div class="list_page">
	<a href="admin_list.o?pages=1&amp;searchs=${searchs_utf}" class="list_page_a">◀</a>
	<c:forEach begin="${paging.pstarts}" end="${paging.pends}" step="1" var="i">
		<a href="admin_list.o?pages=${i}&amp;searchs=${searchs_utf}" <c:if test="${i ne pages}"> class="list_page_a"</c:if> <c:if test="${i eq pages}"> class="list_page_a_hover"</c:if>>${i}</a>
	</c:forEach>
	<a href="admin_list.o?pages=${paging.board_paging}&amp;searchs=${searchs_utf}" class="list_page_a">▶</a>
</div>

<div class="basket_b" style="display:none;">
	<a href="write.o">등록하기</a>
</div>