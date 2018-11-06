<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul class="customer_menu">
	<li><a href="notice.o" class="customer_menu_li_a_hover">공지사항</a></li>
	<li><a href="qna.o" class="customer_menu_li_a">문의게시판</a></li>
</ul>

<h1 class="customer_center_h">
	<img src="./images/notice.jpg" alt="notice" />
</h1>

<table cellspacing="0" cellpadding="10" border="0" class="qna_board">
	<col width="80px" />
	<col width="300px" />
	<col width="100px" />
	
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성일</th>
	</tr>
<c:forEach var="ndata" items="${list}">
	<tr>
		<td>${paging.board_total-board_cnt}</td>
		<td style="text-align:left;"><a href="notice_view.o?no=${ndata.no}&pages=${pages}">${ndata.subject}</a></td>
		<td>${ndata.dates}</td>
	</tr>
	<c:set var="board_cnt" value="${board_cnt+1}" scope="request"></c:set>
</c:forEach>
</table>

  <div class="list_page">
	<a href="notice.o?pages=1" class="list_page_a">◀</a>
	<c:forEach begin="${paging.pstarts}" end="${paging.pends}" step="1" var="i">
		<a href="notice.o?pages=${i}" <c:if test="${i ne pages}"> class="list_page_a"</c:if> <c:if test="${i eq pages}"> class="list_page_a_hover"</c:if>>${i}</a>
	</c:forEach>
	<a href="notice.o?pages=${paging.board_paging}" class="list_page_a">▶</a>
  </div>
  <c:if test="${level eq 3}">
  <div class="customer_center_btn" style="margin-bottom:30px;">
	<a href="notice_write.o" class="customer_center_btn1">작성하기</a>
  </div>
  </c:if>