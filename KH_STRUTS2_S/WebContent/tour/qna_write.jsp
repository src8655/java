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

<form action="qna_write_post.o" method="post" id="qna_write_form">
<table cellspacing="0" cellpadding="10" border="0" class="qna_write_board">
	<col width="150px" />
	<col width="500px" />
	<tr>
		<th>문의제목</th>
		<td><input type="text" name="subject" /></td>
	</tr>
	<tr>
		<th>이름</th>
		<td>${member_info.name}</td>
	</tr>
	<tr>
		<th>전화번호</th>
		<td>${member_info.phone1}-${member_info.phone2}-${member_info.phone3}</td>
	</tr>
	<tr>
		<td colspan="2">
			<textarea name="quest" id="quest"></textarea>
			<script>
		        CKEDITOR.replace( 'quest', {
			    	 uiColor : '#d5e9ff',
			    	 height : 350
			    });
			</script>
		</td>
	</tr>
</table>
<div class="customer_center_btn" style="margin-bottom:30px;">
	<a href="#10" class="customer_center_btn1" onclick="qna_write_form.submit();">문의</a>
	<a href="#10" class="customer_center_btn2" onclick="history.go(-1);">취소</a>
</div>
</form>
