<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<%@ include file="board_bar.jsp" %>

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
		<th>번호</th>
		<th><span style="font-weight:normal;">|</span></th>
		<th>제목</th>
		<th><span style="font-weight:normal;">|</span></th>
		<th>이름</th>
		<th><span style="font-weight:normal;">|</span></th>
		<th>날짜</th>
		<th><span style="font-weight:normal;">|</span></th>
		<th>조회</th>
	</tr>
<c:forEach var="bdb" items="${list}">
	<tr <c:if test="${!(bdb.rt_no eq 1)}">class="rt_bg"</c:if>>
		<td align="center">${board_total-board_cnt+1}</td>
		<td></td>
		<td>
			<c:if test="${bdb.deletes ne 2}">
				<a href="board_view.do?id=${bdb.id}&amp;no=${bdb.no}&amp;pages=${pages}&amp;searchs=${searchs}&amp;searchs_value=${searchs_value}">
			    <c:if test="${bdb.rt_no ne 1}">ㄴ<span style="font-weight:bold;">[답글]&nbsp;</span></c:if>
			    ${bdb.subject}
			  	<c:if test="${bdb.comments ne 0}"><span style="font-size:11px;color:red;">${bdb.comments}</span></c:if>
			  	</a>
		  	</c:if>
		  	<c:if test="${bdb.deletes eq 2}">
			  	${bdb.subject}
		  	</c:if>
		 </td>
		<td></td>
		<td align="center">${bdb.name}</td>
		<td></td>
		<td align="center">${bdb.dates}</td>
		<td></td>
		<td align="center">${bdb.hit}</td>
	</tr>
	<c:set var="board_cnt" value="${board_cnt+1}" scope="request"></c:set>
</c:forEach>

</table>
<div class="boards_b">
	<div class="boards_bsearch">
		<form action="board.do" method="get">
			<input type="hidden" name="id" value="${id}" />
			<input type="hidden" name="pages" value="${pages}" />
			<div class="boards_bsearch_l">
				<select name="searchs">
					<option value="subject" <c:if test="${searchs eq 'subject'}">selected</c:if>>제목</option>
					<option value="memo" <c:if test="${searchs eq 'memo'}">selected</c:if>>내용</option>
					<option value="subject_memo" <c:if test="${searchs eq 'subject_memo'}">selected</c:if>>제목+내용</option>
				</select>
			</div>
		  	<div class="boards_bsearch_c">
		    	<input type="text" name="searchs_value" value="${searchs_value}" />
			</div>
		  	<div class="boards_bsearch_r">
		    	<input type="submit" value="검색하기" />
			</div>
		</form>
	</div>
</div>
<div class="boards_b">
	<div class="boards_bl">
		&nbsp;
	</div>
	<div class="boards_bc">
		<a href="board.do?id=${id}&amp;pages=1&amp;searchs=${searchs}&amp;searchs_value=${searchs_value}">&lt;&lt;</a>
		<c:forEach begin="${pstarts}" end="${pends}" step="1" var="i">
				<a href="board.do?id=${id}&amp;pages=${i}&amp;searchs=${searchs}&amp;searchs_value=${searchs_value}" <c:if test="${i eq pages_int}">style="font-weight:bold;color:red;"</c:if>>${i}</a>
		</c:forEach>
		<a href="board.do?id=${id}&amp;pages=${board_paging}&amp;searchs=${searchs}&amp;searchs_value=${searchs_value}">&gt;&gt;</a>
	</div>
	<div class="boards_br">
		<a href="board_write.do?id=${id}&amp;pages=${pages}&amp;searchs=${searchs}&amp;searchs_value=${searchs_value}" class="btn_st" style="float:right;margin:0 10px 0 0;">작성하기</a>
	</div>
</div>
<%@ include file="foot.jsp" %>