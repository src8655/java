<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 class="customer_center_h">
	<img src="./images/qna2.jpg" alt="qna" />
</h1>

<table cellspacing="0" cellpadding="10" border="0" class="qna_board">
	<col width="60px" />
	<col width="80px" />
	<col width="80px" />
	<col width="300px" />
	<col width="130px" />
	
	<tr>
		<th>번호</th>
		<th>분류</th>
		<th>답변여부</th>
		<th>제목</th>
		<th>작성일</th>
	</tr>
<c:forEach var="qdata" items="${list}">
	<tr>
		<td>${board_total-board_cnt+1}</td>
		<td>
			<c:if test="${qdata.category eq 1}">[주문/결제]</c:if>
			<c:if test="${qdata.category eq 2}">[배송]</c:if>
			<c:if test="${qdata.category eq 3}">[취소/환불]</c:if>
			<c:if test="${qdata.category eq 4}">[반품/교환]</c:if>
			<c:if test="${qdata.category eq 5}">[기타]</c:if>
		</td>
		<td>
			<c:if test="${qdata.isanswer eq 0}"><div class="view_qna_table_label1">미답변</div></c:if>
			<c:if test="${qdata.isanswer eq 1}"><div class="view_qna_table_label2">답변완료</div></c:if>
		</td>
		<td style="text-align:left;"><a href="customer_center_qna_view.o?no=${qdata.no}&pages=${pages}">${qdata.subject}</a></td>
		<td>${qdata.dates}</td>
	</tr>
	<c:set var="board_cnt" value="${board_cnt+1}" scope="request"></c:set>
</c:forEach>
</table>

  <div class="list_page">
	<a href="customer_center_qna.o?pages=1" class="list_page_a">◀</a>
	<c:forEach begin="${pstarts}" end="${pends}" step="1" var="i">
		<a href="customer_center_qna.o?pages=${i}" <c:if test="${i ne pages_int}"> class="list_page_a"</c:if> <c:if test="${i eq pages_int}"> class="list_page_a_hover"</c:if>>${i}</a>
	</c:forEach>
	<a href="customer_center_qna.o?pages=${board_paging}" class="list_page_a">▶</a>
  </div>
  
  <div class="customer_center_btn">
	<a href="customer_center_qna_write.o" class="customer_center_btn1">작성하기</a>
  </div>