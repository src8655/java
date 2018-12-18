<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<table cellpadding="7" cellspacing="0" class="boards">
<col width="60" />
<col width="1" />
<col width="240" />
<col width="1" />
<col width="70" />
<col width="1" />
<col width="70" />
<col width="1" />
<col width="60" />
	<tr>
		<th><spring:message code="board.num" /></th>
		<th><span style="font-weight:normal;">|</span></th>
		<th><spring:message code="board.subject" /></th>
		<th><span style="font-weight:normal;">|</span></th>
		<th><spring:message code="board.name" /></th>
		<th><span style="font-weight:normal;">|</span></th>
		<th><spring:message code="board.date" /></th>
		<th><span style="font-weight:normal;">|</span></th>
		<th><spring:message code="board.hit" /></th>
	</tr>

<c:forEach items="${list}" var="ldata">
	<tr>
		<td align="center">${paging.board_total-board_cnt-(pages*paging.board_lengths-paging.board_lengths)}</td>
		<td></td>
		<td>
		  <a href="board_view.do?pages=${pages}&amp;no=${ldata.no}&lang=${lang}">
		    ${ldata.subject}
		  </a></td>
		<td></td>
		<td align="center">${ldata.name}</td>
		<td></td>
		<td align="center">${ldata.dates}</td>
		<td></td>
		<td align="center">${ldata.hit}</td>
	</tr>
	<c:set var="board_cnt" value="${board_cnt+1}" scope="request"></c:set>
</c:forEach>
</table>

<div class="boards_b">
	<div class="boards_bl">
		<a href="download_excel.do?pages=${pages}&lang=${lang}" class="btn_st" style="float:left;margin:0 10px 0 0;"><spring:message code="board.toexcel" /></a>
		<a href="toxml.do?pages=${pages}&lang=${lang}" class="btn_st" style="float:left;margin:0 10px 0 0;">RSS</a>
	</div>
	<div class="boards_bc">
		<a href="board.do?pages=1&lang=${lang}" class="list_page_a">◀</a>
		<c:forEach begin="${paging.pstarts}" end="${paging.pends}" step="1" var="i">
			<a href="board.do?pages=${i}&lang=${lang}" <c:if test="${i eq pages}"> style="color:red;font-weight:bold;"</c:if>>${i}</a>
		</c:forEach>
		<a href="board.do?pages=${paging.board_paging}&lang=${lang}" class="list_page_a">▶</a>
	</div>
	<div class="boards_br">
		<a href="board_write.do?pages=${pages}&lang=${lang}" class="btn_st" style="float:right;margin:0 10px 0 0;"><spring:message code="board.write" /></a>
	</div>
</div>


<input type="text" onclick="ajaxs()" name="search_value" placeholder='<spring:message code="board.search" />' id="search_value" style="display:block;margin:0 auto;" />
<div id="search_resultsss" style="overflow:hidden">
</div>
