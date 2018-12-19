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
		<th>문의제목</th>
		<td>${qdata.subject}</td>
	</tr>
	<tr>
		<th>이름</th>
		<td>${qdata.name}</td>
	</tr>
	<tr>
		<th>전화번호</th>
		<td>${qdata.phone1}-${qdata.phone2}-${qdata.phone3}</td>
	</tr>
	<tr>
		<th>문의내용</th>
		<td>
			${qdata.quest}
		</td>
	</tr>
	<tr>
		<th>편집</th>
		<td>
			<a href="qna_edit.o?no=${qdata.no}&pages=${pages}&status=${status}">[수정]</a>
			<a href="qna_del.o?no=${qdata.no}&pages=${pages}&status=${status}">[삭제]</a>
		</td>
	</tr>
</table>
<c:if test="${qdata.isanswer eq 0}">
<c:if test="${member_info.orders eq 3}">
<form action="qna_answer.o" method="post" id="qna_answer_form">
<input type="hidden" name="no" value="${qdata.no}" />
<input type="hidden" name="pages" value="${pages}" />
<input type="hidden" name="status" value="${status}" />
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
				<a href="qna_answer_del.o?no=${qdata.no}&pages=${pages}&status=${status}">[삭제]</a>
			</c:if>
		</th>
		<td id="answer_result">
			${qdata.answer}
		</td>
	</tr>
</table>
</c:if>

<div class="customer_center_btn" style="margin-bottom:30px;">
	<a href="qna.o?pages=${pages}&status=${status}" class="customer_center_btn2">목록보기</a>

<c:if test="${qdata.isanswer eq 0}">
<c:if test="${member_info.orders eq 3}">
	<a href="#10" class="customer_center_btn1" onclick="qna_answer_form.submit();">답변하기</a>
</c:if>
</c:if>
</div>

