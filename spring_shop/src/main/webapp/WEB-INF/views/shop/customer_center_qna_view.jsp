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
		<th>상태</th>
		<td>
			<c:if test="${qdata.isanswer eq 0}"><div class="view_qna_table_label1" style="float:left;margin:0px;">미답변</div></c:if>
			<c:if test="${qdata.isanswer eq 1}"><div class="view_qna_table_label2" style="float:left;margin:0px;">답변완료</div></c:if>
		</td>
	</tr>
	<tr>
		<th>작성일</th>
		<td>${qdata.dates}</td>
	</tr>
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
<c:if test="${qdata.guest_no eq member_info.no}">
	<tr>
		<th>편집</th>
		<td>
			<a href="customer_center_qna_edit.o?no=${qdata.no}&pages=${pages}">[수정]</a>
			<a href="customer_center_qna_del.o?no=${qdata.no}&pages=${pages}">[삭제]</a>
		</td>
	</tr>
</c:if>
</table>
<c:if test="${qdata.isanswer eq 0}">
<c:if test="${member_info.orders eq 3}">
<form action="customer_center_qna_answer.o" method="post" id="qna_answer_form">
<input type="hidden" name="no" value="${qdata.no}" />
<input type="hidden" name="pages" value="${pages}" />
<table cellspacing="0" cellpadding="10" border="0" class="qna_write_board">

	<tr>
		<td>
			<textarea name="answer" id="answer"></textarea>
			<script>
		        CKEDITOR.replace( 'answer', {
			    	 uiColor : '#d5e9ff',
			    	 height : 350
			    });
			</script>
		</td>
	</tr>
</table>
</form>
</c:if>
</c:if>

<c:if test="${qdata.isanswer eq 1}">
<table cellspacing="0" cellpadding="10" border="0" class="qna_write_board">
	<col width="150px" />
	<col width="500px" />
	<tr>
		<th>
			문의답변
			<c:if test="${member_info.orders eq 3}">
				<br />
				<a href="#10" onclick="showhide('answer_result');showhide('answer_edit');showhide('qna_answer_edit_form_btn');">[수정]</a>
				<a href="customer_center_qna_answer_del.o?no=${qdata.no}&pages=${pages}">[삭제]</a>
			</c:if>
		</th>
		<td id="answer_result">
			${qdata.answer}
		</td>
		<td id="answer_edit" style="display:none;">
			<form action="customer_center_qna_answer.o" method="post" id="qna_answer_edit_form">
				<input type="hidden" name="no" value="${qdata.no}" />
				<input type="hidden" name="pages" value="${pages}" />
				<textarea name="answer" id="answer">${qdata.answer}</textarea>
				<script>
		        	CKEDITOR.replace( 'answer', {
			    	    uiColor : '#d5e9ff',
			    	    height : 350
			        });
			    </script>
			</form>
		</td>
	</tr>
</table>
</c:if>

<div class="customer_center_btn">
	<a href="customer_center_qna.o?pages=${pages}" class="customer_center_btn2">목록보기</a>

<c:if test="${qdata.isanswer eq 0}">
<c:if test="${member_info.orders eq 3}">
	<a href="#10" class="customer_center_btn1" onclick="qna_answer_form.submit();">답변하기</a>
</c:if>
</c:if>

<c:if test="${qdata.isanswer eq 1}">
<c:if test="${member_info.orders eq 3}">
	<a href="#10" class="customer_center_btn1" style="display:none;" id="qna_answer_edit_form_btn" onclick="qna_answer_edit_form.submit();">답변수정완료</a>
</c:if>
</c:if>
</div>

