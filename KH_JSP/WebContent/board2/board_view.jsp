<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<%@ include file="board_bar.jsp" %>

<table cellpadding="7" cellspacing="0" class="boards">
<col width="100" />
<col width="380" />
<col width="100" />
<col width="120" />
	<tr class="boards_t">
		<th style="background:#d5e9ff;">제목</th>
		<th align="left" style="padding:0 0 0 10px;">${bdb.subject}</th>
		<th style="background:#d5e9ff;">조회</th>
		<th align="right" style="padding:0 10px 0 0;">${bdb.hit}</th>
	</tr>
	<tr>
		<th style="background:#d5e9ff;border:none;border-bottom:1px solid #A0A0A0;">이름</th>
	  <td style="padding:0 0 0 10px;font-weight:bold;">${bdb.name}</td>
		<th style="background:#d5e9ff;border:none;border-bottom:1px solid #A0A0A0;">날짜</th>
	  <td align="right" style="padding:0 10px 0 0;font-weight:bold;">${bdb.dates}</td>
	</tr>
	<tr>
		<td colspan="4" style="padding:30px 7px 30px 7px;" class="b_memos">${bdb.memo}</td>
	</tr>
<c:if test="${!(bdb.file1 eq null)}">
	<tr>
		<th>파일첨부1</th>
		<td colspan="3"><a href="./upload/${bdb.file1}">${bdb.file1}</a></td>
	</tr>
</c:if>
<c:if test="${!(bdb.file2 eq null)}">
	<tr>
		<th>파일첨부2</th>
		<td colspan="3"><a href="./upload/${bdb.file2}">${bdb.file2}</a></td>
	</tr>
</c:if>
</table>
<c:forEach var="data" items="${list}">
<c:if test="${data.rt_no eq 1}">
<table cellpadding="7" cellspacing="0" class="comments">
<col width="100" />
<col width="400" />
	<tr>
		<th style="background:#d5e9ff;border:none;border:1px solid #A0A0A0;">${data.name}
			<span style="font-weight:normal;">
				<br />${data.dates}<br />
			</span>
		</th>
		<td valign="top">
			${data.memo}
			<c:if test="${member_info eq null}">
			<a href="board_comment_del?no=${data.no}&amp;id=${id}&amp;data_no=${no}&amp;pages=${pages}">ⓧ</a>
			</c:if>
			<c:if test="${!(member_info eq null)}">
			<a href="board_comment_del_post?no=${data.no}&amp;id=${id}&amp;data_no=${no}&amp;pages=${pages}">ⓧ</a>
			</c:if>
			
			
			<a href="#100" onclick="shsh('cmm${data.no}')">[답글]</a>
			
			
			<form action="board_comment_post" id="cmm${data.no}" style="display:none;">
			<input type="hidden" name="rt_no" value="${data.no}" />
			<input type="hidden" name="data_no" value="${no}" />
			<input type="hidden" name="id" value="${id}" />
			<input type="hidden" name="pages" value="${pages}" />
			<table cellpadding="7" cellspacing="0" class="comments">
			<col width="20%" />
			<col width="30%" />
			<col width="20%" />
			<col width="20%" />
				<tr <c:if test="${!(member_info eq null)}">style="display:none;"</c:if>>
					<th style="background:#d5e9ff;border-left:1px solid #bbbbbb;">이름</th>
					<td style="border-top:1px solid #122942;"><input type="text" name="name" value="${name_tmp}" /></td>
					<th style="background:#d5e9ff;">비밀번호</th>
					<td style="border-top:1px solid #122942;" colspan="2"><input type="password" name="passwords" value="${passwords_tmp}" /></td>
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
</c:if>
<c:if test="${!(data.rt_no eq 1)}">
<table cellpadding="7" cellspacing="0" class="comments">
<col width="50" />
<col width="100" />
<col width="350" />
	<tr>
		<td>ㄴ<span style="font-weight:bold;">[답글]</span></td>
		<th style="background:#eeeeee;border:none;border:1px solid #A0A0A0;">${data.name}
			<span style="font-weight:normal;">
				<br />${data.dates}<br />
				
			</span>
		</th>
		<td valign="top">
			${data.memo}
			<c:if test="${member_info eq null}">
			<a href="board_comment_del?no=${data.no}&amp;id=${id}&amp;data_no=${no}&amp;pages=${pages}">ⓧ</a>
			</c:if>
			<c:if test="${!(member_info eq null)}">
			<a href="board_comment_del_post?no=${data.no}&amp;id=${id}&amp;data_no=${no}&amp;pages=${pages}">ⓧ</a>
			</c:if>
		</td>
	</tr>
</table>

</c:if>
</c:forEach>




<form name="cm_b" action="board_comment_post">
<input type="hidden" name="rt_no" value="1" />
<input type="hidden" name="data_no" value="${no}" />
<input type="hidden" name="id" value="${id}" />
<input type="hidden" name="pages" value="${pages}" />
<table cellpadding="7" cellspacing="0" class="comments">
<col width="20%" />
<col width="30%" />
<col width="20%" />
<col width="20%" />
	<tr <c:if test="${!(member_info eq null)}">style="display:none;"</c:if>>
		<th style="background:#d5e9ff;border-left:1px solid #bbbbbb;">이름</th>
		<td style="border-top:1px solid #122942;"><input type="text" name="name" value="${name_tmp}" /></td>
		<th style="background:#d5e9ff;">비밀번호</th>
		<td style="border-top:1px solid #122942;" colspan="2"><input type="password" name="passwords" value="${passwords_tmp}" /></td>
	</tr>
	<tr>
		<td style="border-left:none;border-right:none;" colspan="4"><textarea name="memo" rows="100" cols="100" editable="0" style="border:1px solid #b8c0cc;width:98%;height:40px;"></textarea></td>
		<td style="text-align:center;width:80px;border-left:none;border-right:none;"><input type="submit" value="등록" style="background:#d5e9ff;border:1px solid #122942;width:98%;height:45px;font-size:12px;font-weight:bold;" /></td>
	</tr>
</table>
</form>

<div class="boards_b">
	<div class="boards_bl">
		<a href="board?id=${id}&amp;pages=${pages}&amp;searchs=${searchs}&amp;searchs_value=${searchs_value}" class="btn_st"  style="margin:0 0 0 10px;">목록보기</a>
	</div>
	<div class="boards_br" style="width:70%;">
		<c:if test="${bdb.rt_no eq 1}">
		<a href="board_write?id=${id}&amp;pages=${pages}&amp;rt_no=${rt_no}&amp;searchs=${searchs}&amp;searchs_value=${searchs_value}" class="btn_st"  style="float:right;margin:0 10px 0 0;">답글달기</a>
		</c:if>
	
		<a href="board_edit?id=${id}&amp;pages=${pages}&amp;no=${bdb.no}&amp;searchs=${searchs}&amp;searchs_value=${searchs_value}" class="btn_st"  style="float:right;margin:0 10px 0 0;">수정하기</a>
		
		<c:if test="${member_info eq null}">
		<a href="board_del?id=${id}&amp;pages=${pages}&amp;no=${bdb.no}&amp;searchs=${searchs}&amp;searchs_value=${searchs_value}" class="btn_st"  style="float:right;margin:0 10px 0 0;">삭제하기</a>
		</c:if>
		<c:if test="${!(member_info eq null)}">
		<a href="board_del_post?id=${id}&amp;pages=${pages}&amp;no=${bdb.no}&amp;searchs=${searchs}&amp;searchs_value=${searchs_value}&amp;rt_no=${bdb.no}" class="btn_st"  style="float:right;margin:0 10px 0 0;">삭제하기</a>
		</c:if>
		
	</div>
</div>

<%@ include file="foot.jsp" %>