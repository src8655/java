<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="basket_top" style="width:770px;margin:0 auto;margin-top:10px;margin-bottom:20px;">
	<h1 style="width:600px;">
		<div><img src="./images/basket.jpg" alt="회원목록 관리" /></div>
		<p>&nbsp;회원목록 관리</p>
	</h1>
</div>
<table cellpadding="5" cellspacing="0" class="basket_table" style="width:770px;margin:0 auto;">
<col width="100" />
<col width="100" />
<col width="100" />
<col width="150" />
<col width="150" />
<col width="100" />
	<tr>
		<th>회원번호</th>
		<th>이름</th>
		<th>아이디</th>
		<th>이메일</th>
		<th>전화번호</th>
		<th>상세보기</th>
	</tr>
<c:forEach var="mdata" items="${list}">
	<tr>
		<td>${mdata.no}</td>
		<td>${mdata.name}</td>
		<td>${mdata.user_id}</td>
		<td>${mdata.email}</td>
		<td>${mdata.phone1}-${mdata.phone2}-${mdata.phone3}</td>
		<td>
			<input type="button" value="상세보기" class="basket_order" onclick="location.href='admin_member_edit.o?no=${mdata.no}&pages=${pages}&amp;searchs=${searchs_utf}'" />
			<input type="button" value="삭제하기" class="basket_delete" onclick="location.href='admin_member_del.o?no=${mdata.no}&pages=${pages}&amp;searchs=${searchs_utf}'" />
		</td>
	</tr>
</c:forEach>
</table>
  <div class="list_page">
	<a href="admin_member.o?pages=1&amp;searchs=${searchs_utf}" class="list_page_a">◀</a>
	<c:forEach begin="${paging.pstarts}" end="${paging.pends}" step="1" var="i">
		<a href="admin_member.o?pages=${i}&amp;searchs=${searchs_utf}" <c:if test="${i ne pages}"> class="list_page_a"</c:if> <c:if test="${i eq pages}"> class="list_page_a_hover"</c:if>>${i}</a>
	</c:forEach>
	<a href="admin_member.o?pages=${paging.board_paging}&amp;searchs=${searchs_utf}" class="list_page_a">▶</a>
  </div>
  