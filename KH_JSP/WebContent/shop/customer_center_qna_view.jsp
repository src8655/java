<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 class="customer_center_h">
	<img src="./images/qna2.jpg" alt="qna" />
</h1>

<table cellspacing="0" cellpadding="10" border="0" class="qna_write_board">
	<col width="150px" />
	<col width="500px" />
	<tr>
		<th>분류</th>
		<td>
			<c:if test="${qdata.category eq 1}">[주문/결제]</c:if>
			<c:if test="${qdata.category eq 2}">[배송]</c:if>
			<c:if test="${qdata.category eq 3}">[취소/환불]</c:if>
			<c:if test="${qdata.category eq 4}">[반품/교환]</c:if>
			<c:if test="${qdata.category eq 5}">[기타]</c:if>
		</td>
	</tr>
	<tr>
		<th>문의제목</th>
		<td>${qdata.subject}</td>
	</tr>
	<tr>
		<th>문의내용</th>
		<td>
			${qdata.memo}
		</td>
	</tr>
</table>
<c:if test="${qdata.isanswer eq 0}">
<c:if test="${member_info.orders eq 3}">
<form action="customer_center_qna_answer.o" method="post" id="qna_answer_form">
<input type="hidden" name="no" value="${qdata.no}" />
<input type="hidden" name="pages" value="${pages}" />
<table cellspacing="0" cellpadding="10" border="0" class="qna_write_board">
	<col width="150px" />
	<col width="500px" />
	<tr>
		<th>문의답변</th>
		<td>
			<textarea name="answer"></textarea>
		</td>
	</tr>
</table>
<div class="customer_center_btn">
	<a href="#10" class="customer_center_btn1" onclick="qna_answer_form.submit();">답변하기</a>
</div>
</form>
</c:if>
</c:if>

<c:if test="${qdata.isanswer eq 1}">
<table cellspacing="0" cellpadding="10" border="0" class="qna_write_board">
	<col width="150px" />
	<col width="500px" />
	<tr>
		<th>문의답변</th>
		<td>
			${qdata.answer}
		</td>
	</tr>
</table>
</c:if>


