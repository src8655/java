<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 class="customer_center_h">
	<img src="./images/faq.jpg" alt="qna" />
</h1>

<form action="customer_center_faq_write_post.o" method="post" id="faq_write_form">
<table cellspacing="0" cellpadding="10" border="0" class="qna_write_board">
	<col width="150px" />
	<col width="500px" />
	<tr>
		<th>분류</th>
		<td>
			<select name="category">
				<option value="1">주문/결제</option>
				<option value="2">배송</option>
				<option value="3">취소/환불</option>
				<option value="4">반품/교환</option>
				<option value="5">기타</option>
			</select>
		</td>
	</tr>
	<tr>
		<th>제목</th>
		<td><input type="text" name="subject" /></td>
	</tr>
	<tr>
		<td colspan="2">
			<textarea name="memo" rows="100" cols="100" id="memo"></textarea>
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
	<a href="#10" class="customer_center_btn1" onclick="faq_write_form.submit();">작성완료</a>
	<a href="#10" class="customer_center_btn2" onclick="history.go(-1);">취소</a>
</div>
</form>
