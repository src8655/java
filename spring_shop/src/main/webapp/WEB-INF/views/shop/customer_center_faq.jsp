<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 class="customer_center_h">
	<img src="./images/faq.jpg" alt="faq" />
</h1>

<table cellspacing="0" cellpadding="10" border="0" class="qna_board">
	<col width="60px" />
	<col width="80px" />
	<col width="400px" />
	<c:if test="${member_info.orders eq 3}">
		<col width="100px" />
	</c:if>
	
	<tr>
		<th>번호</th>
		<th>
			<select onchange="ctrl_select('customer_center_faq.o?p_search=${p_search}&p_search_value=${p_search_values}&category=',this);">
				<option value="-1" <c:if test="${category eq -1}">selected</c:if>>전체</option>
				<option value="1" <c:if test="${category eq 1}">selected</c:if>>주문/결제</option>
				<option value="2" <c:if test="${category eq 2}">selected</c:if>>배송</option>
				<option value="3" <c:if test="${category eq 3}">selected</c:if>>취소/환불</option>
				<option value="4" <c:if test="${category eq 4}">selected</c:if>>반품/교환</option>
				<option value="5" <c:if test="${category eq 5}">selected</c:if>>기타</option>
			</select>
		</th>
		<th>제목</th>
		<c:if test="${member_info.orders eq 3}">
			<th>편집</th>
		</c:if>
	</tr>
<c:forEach var="fdata" items="${list}">
	<tr>
		<td>${paging.board_total-board_cnt}</td>
		<td>
			<c:if test="${fdata.category eq 1}">[주문/결제]</c:if>
			<c:if test="${fdata.category eq 2}">[배송]</c:if>
			<c:if test="${fdata.category eq 3}">[취소/환불]</c:if>
			<c:if test="${fdata.category eq 4}">[반품/교환]</c:if>
			<c:if test="${fdata.category eq 5}">[기타]</c:if>
		</td>
		<td style="text-align:left;"><a href="#10" onclick="showhide('faq_list_${fdata.no}');">${fdata.subject}</a></td>
		
		<c:if test="${member_info.orders eq 3}">
			<td>
				<a href="customer_center_faq_edit.o?no=${fdata.no}&pages=${pages}&p_search=${p_search}&p_search_value=${p_search_values}&category=${category}">[수정]</a>
				<a href="customer_center_faq_del.o?no=${fdata.no}&pages=${pages}&p_search=${p_search}&p_search_value=${p_search_values}&category=${category}">[삭제]</a>
			</td>
		</c:if>
	</tr>
	<tr style="display:none;" id="faq_list_${fdata.no}">
		<td <c:if test="${member_info.orders ne 3}">colspan="3"</c:if><c:if test="${member_info.orders eq 3}">colspan="4"</c:if>>
			<div style="width:680px;padding:10px;border:1px solid #676767;margin:0 auto;overflow:hidden;">${fdata.memo}</div>
		</td>
	</tr>
	<c:set var="board_cnt" value="${board_cnt+1}" scope="request"></c:set>
</c:forEach>
</table>

	<div class="boards_bsearch">
		<form action="customer_center_faq.o" method="get">
			<input type="hidden" name="pages" value="${pages}" />
			<input type="hidden" name="category" value="${category}" />
			<div class="boards_bsearch_l">
				<select name="p_search">
					<option value="1" <c:if test="${p_search eq 1}">selected</c:if>>제목</option>
					<option value="2" <c:if test="${p_search eq 2}">selected</c:if>>답변</option>
					<option value="3" <c:if test="${p_search eq 3}">selected</c:if>>제목+답변</option>
				</select>
			</div>
		  	<div class="boards_bsearch_c">
		    	<input type="text" name="p_search_value" value="${p_search_value}" />
			</div>
		  	<div class="boards_bsearch_r">
		    	<input type="submit" value="검색하기" />
			</div>
		</form>
	</div>

  <div class="list_page">
	<a href="customer_center_faq.o?pages=1&p_search=${p_search}&p_search_value=${p_search_values}&category=${category}" class="list_page_a">◀</a>
	<c:forEach begin="${paging.pstarts}" end="${paging.pends}" step="1" var="i">
		<a href="customer_center_faq.o?pages=${i}&p_search=${p_search}&p_search_value=${p_search_values}&category=${category}" <c:if test="${i ne pages_int}"> class="list_page_a"</c:if> <c:if test="${i eq pages_int}"> class="list_page_a_hover"</c:if>>${i}</a>
	</c:forEach>
	<a href="customer_center_faq.o?pages=${paging.board_paging}&p_search=${p_search}&p_search_value=${p_search_values}&category=${category}" class="list_page_a">▶</a>
  </div>
  
<c:if test="${member_info.orders eq 3}">
<div class="customer_center_btn">
	<a href="customer_center_faq_write.o" class="customer_center_btn1">작성하기</a>
</div>
</c:if>