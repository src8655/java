<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 class="customer_center_h">
	<img src="./images/qna2.jpg" alt="qna" />
</h1>

<form action="customer_center_qna_edit_post.o" method="post" id="qna_write_form">
<input type="hidden" name="no" value="${no}" />
<input type="hidden" name="pages" value="${pages}" />
<table cellspacing="0" cellpadding="10" border="0" class="qna_write_board">
	<col width="150px" />
	<col width="500px" />
	<tr>
		<th>분류</th>
		<td>
			<select name="category">
				<option value="1" <c:if test="${qdata.category eq 1}">selected</c:if>>주문/결제</option>
				<option value="2" <c:if test="${qdata.category eq 2}">selected</c:if>>배송</option>
				<option value="3" <c:if test="${qdata.category eq 3}">selected</c:if>>취소/환불</option>
				<option value="4" <c:if test="${qdata.category eq 4}">selected</c:if>>반품/교환</option>
				<option value="5" <c:if test="${qdata.category eq 5}">selected</c:if>>기타</option>
			</select>
		</td>
	</tr>
	<tr>
		<th>문의제목</th>
		<td><input type="text" name="subject" value="${qdata.subject}" /></td>
	</tr>
	<tr>
		<td colspan="2">
			<textarea name="memo" id="memo">${qdata.memo}</textarea>
			<script>
		        CKEDITOR.replace( 'memo', {
			    	 uiColor : '#d5e9ff',
			    	 height : 350
			    });
			</script>
		</td>
	</tr>
</table>
<div class="customer_center_btn">
	<a href="#10" class="customer_center_btn1" onclick="qna_write_form.submit();">수정완료</a>
	<a href="#10" class="customer_center_btn2" onclick="history.go(-1);">취소</a>
</div>
</form>
