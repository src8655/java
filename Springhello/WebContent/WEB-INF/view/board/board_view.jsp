<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<table cellpadding="7" cellspacing="0" class="boards">
<col width="100" />
<col width="380" />
<col width="100" />
<col width="120" />
	<tr class="boards_t">
		<th style="background:#d5e9ff;"><spring:message code="board.subject" /></th>
		<th align="left" style="padding:0 0 0 10px;">${ldata.subject}</th>
		<th style="background:#d5e9ff;"><spring:message code="board.hit" /></th>
		<th align="right" style="padding:0 10px 0 0;">${ldata.hit}</th>
	</tr>
	<tr>
		<th style="background:#d5e9ff;border:none;border-bottom:1px solid #A0A0A0;"><spring:message code="board.name" /></th>
	  <td style="padding:0 0 0 10px;font-weight:bold;">${ldata.name}</td>
		<th style="background:#d5e9ff;border:none;border-bottom:1px solid #A0A0A0;"><spring:message code="board.date" /></th>
	  <td align="right" style="padding:0 10px 0 0;font-weight:bold;">${ldata.dates}</td>
	</tr>
	<tr>
		<td colspan="4" style="padding:30px 7px 30px 7px;" class="b_memos">${ldata.memo}</td>
	</tr>
<c:if test="${ldata.file1 ne null}">
	<tr>
		<th style="background:#d5e9ff;border:none;border-bottom:1px solid #A0A0A0;border-top:1px solid #A0A0A0;"><spring:message code="board.file1" /></th>
		<td style="padding:0 0 0 3px;border-top:1px solid #A0A0A0;" colspan="3">
			<a href="download.do?filename=${ldata.file1}">${ldata.file1}</a>
		</td>
	</tr>
</c:if>
<c:if test="${ldata.file2 ne null}">
	<tr>
		<th style="background:#d5e9ff;border:none;border-bottom:1px solid #A0A0A0;"><spring:message code="board.file2" /></th>
		<td style="padding:0 0 0 3px;" colspan="3">
			<a href="download.do?filename=${ldata.file2}">${ldata.file2}</a>
		</td>
	</tr>
</c:if>
</table>



<c:forEach var="data" items="${list}">
<table cellpadding="7" cellspacing="0" class="comments">
	<tr>
		<td style="width:${data.levels * 20}px;border:0px;padding:0px;overflow:hidden;"></td>
		<th style="width:100px;background:#d5e9ff;border:none;border:1px solid #A0A0A0;">${data.name}
			<span style="font-weight:normal;">
				<br />${data.dates}<br />
				<a href="board_comment_del.do?no=${data.no}&amp;data_no=${no}&amp;pages=${pages}">[삭제]</a>
				<a href="#100" onclick="showhide('cmm${data.no}')">[답글]</a>
			</span>
		</th>
		<td valign="top">
			${data.memo}
			
			<form action="board_comment_post.do" id="cmm${data.no}" style="display:none;">
			<input type="hidden" name="rt_no" value="${data.no}" />
			<input type="hidden" name="board_no" value="${no}" />
			<input type="hidden" name="pages" value="${pages}" />
			<input type="hidden" name="lang" value="${lang}" />
			<table cellpadding="7" cellspacing="0" class="comments">
			<col width="20%" />
			<col width="30%" />
			<col width="20%" />
			<col width="20%" />
				<tr <c:if test="${!(member_info eq null)}">style="display:none;"</c:if>>
					<th style="background:#d5e9ff;border-left:1px solid #bbbbbb;">이름</th>
					<td style="border-top:1px solid #122942;"><input type="text" name="name" /></td>
					<th style="background:#d5e9ff;">비밀번호</th>
					<td style="border-top:1px solid #122942;" colspan="2"><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td style="border-left:none;border-right:none;" colspan="4"><textarea name="memo" rows="100" cols="100" editable="0" style="border:1px solid #b8c0cc;width:98%;height:40px;"></textarea></td>
					<td style="text-align:center;width:80px;border-left:none;border-right:none;"><input type="submit" value="등록" style="background:#d5e9ff;border:1px solid #122942;width:98%;height:45px;font-size:12px;font-weight:bold;" /></td>
				</tr>
			</table>
			</form>
			
			
		</td>
	</tr>
</table>
</c:forEach>




<form name="cm_b" action="board_comment_post.do">
<input type="hidden" name="rt_no" value="-1" />
<input type="hidden" name="board_no" value="${no}" />
<input type="hidden" name="pages" value="${pages}" />
<input type="hidden" name="lang" value="${lang}" />
<table cellpadding="7" cellspacing="0" class="comments">
<col width="20%" />
<col width="30%" />
<col width="20%" />
<col width="20%" />
	<tr>
		<th style="background:#d5e9ff;border-left:1px solid #bbbbbb;">이름</th>
		<td style=""><input type="text" name="name" /></td>
		<th style="background:#d5e9ff;">비밀번호</th>
		<td style="" colspan="2"><input type="password" name="password" /></td>
	</tr>
	<tr>
		<td style="border-left:none;border-right:none;" colspan="4"><textarea name="memo" rows="100" cols="100" editable="0" style="border:1px solid #b8c0cc;width:98%;height:40px;"></textarea></td>
		<td style="text-align:center;width:80px;border-left:none;border-right:none;"><input type="submit" value="등록" style="background:#d5e9ff;border:1px solid #122942;width:98%;height:45px;font-size:12px;font-weight:bold;" /></td>
	</tr>
</table>
</form>

<div class="boards_b">
	<div class="boards_bl">
		<a href="board.do?pages=${pages}&lang=${lang}" class="btn_st"  style="margin:0 0 0 10px;"><spring:message code="board.list" /></a>
	</div>
	<div class="boards_br" style="width:70%;">
		<a href="board_edit.do?pages=${pages}&lang=${lang}&no=${no}" class="btn_st"  style="float:right;margin:0 10px 0 0;"><spring:message code="board.edit" /></a>
		<a href="board_del.do?pages=${pages}&lang=${lang}&no=${no}" class="btn_st"  style="float:right;margin:0 10px 0 0;"><spring:message code="board.delete" /></a>
	</div>
</div>
