<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul class="customer_menu">
	<li><a href="notice.o" class="customer_menu_li_a">공지사항</a></li>
	<li><a href="qna.o" class="customer_menu_li_a_hover">문의게시판</a></li>
</ul>

<h1 class="customer_center_h">
	<img src="./images/qna2.jpg" alt="qna" />
</h1>

<table cellspacing="0" cellpadding="10" border="0" class="qna_board">
	<col width="60px" />
	<col width="80px" />
	<col width="300px" />
	<col width="130px" />
	
	<tr>
		<th>번호</th>
		<th>
			<select onchange="ctrl_select('qna.o?pages=${pages}&status=',this);">
				<option value="-1">전체보기</option>
				<option value="0" <c:if test="${status eq 0}">selected</c:if>>미답변</option>
				<option value="1" <c:if test="${status eq 1}">selected</c:if>>답변완료</option>
			</select>
		</th>
		<th>제목</th>
		<th>작성일</th>
	</tr>
<c:forEach var="qdata" items="${list}">
	<tr>
		<td>${paging.board_total-board_cnt}</td>
		<td>
			<c:if test="${qdata.isanswer eq 0}"><div class="view_qna_table_label1">미답변</div></c:if>
			<c:if test="${qdata.isanswer eq 1}"><div class="view_qna_table_label2">답변완료</div></c:if>
		</td>
		<td style="text-align:left;"><a href="qna_view.o?no=${qdata.no}&pages=${pages}&status=${status}">${qdata.subject}</a></td>
		<td>${qdata.dates}</td>
	</tr>
	<c:set var="board_cnt" value="${board_cnt+1}" scope="request"></c:set>
</c:forEach>
</table>

  <div class="list_page">
	<a href="qna.o?pages=1&status=${status}" class="list_page_a">◀</a>
	<c:forEach begin="${paging.pstarts}" end="${paging.pends}" step="1" var="i">
		<a href="qna.o?pages=${i}&status=${status}" <c:if test="${i ne pages}"> class="list_page_a"</c:if> <c:if test="${i eq pages}"> class="list_page_a_hover"</c:if>>${i}</a>
	</c:forEach>
	<a href="qna.o?pages=${paging.board_paging}&status=${status}" class="list_page_a">▶</a>
  </div>
  
  <div class="customer_center_btn" style="margin-bottom:30px;">
	<a href="qna_write.o" class="customer_center_btn1">작성하기</a>
  </div>