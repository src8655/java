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

<table cellspacing="0" cellpadding="10" border="0" class="qna_write_board">
	<col width="150px" />
	<col width="500px" />
	<tr>
		<th>제목</th>
		<td>${ndata.subject}</td>
	</tr>
	<tr>
		<th>작성일</th>
		<td>${ndata.dates}</td>
	</tr>
	<tr>
		<td colspan="2">
			${ndata.memo}
		</td>
	</tr>
<c:if test="${level eq 3}">
	<tr>
		<th>편집</th>
		<td>
			<a href="notice_edit.o?no=${ndata.no}&pages=${pages}">[수정]</a>
			<a href="notice_del.o?no=${ndata.no}&pages=${pages}">[삭제]</a>
		</td>
	</tr>
</c:if>
</table>


<div class="customer_center_btn" style="margin-bottom:30px;">
	<a href="notice.o?pages=${pages}" class="customer_center_btn2">목록보기</a>
</div>

