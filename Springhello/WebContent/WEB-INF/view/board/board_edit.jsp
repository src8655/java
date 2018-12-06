<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

<spring:hasBindErrors name="ldata" />
<form name="wt_b" action="board_edit_post.do" method="post" enctype="multipart/form-data">
<input type="hidden" name="pages" value="${pages}" />
<input type="hidden" name="lang" value="${lang}" />
<input type="hidden" name="no" value="${no}" />
<table cellpadding="7" cellspacing="0" class="boards">
<col width="90" />
<col width="410" />
	<tr class="boards_t">
		<th style="background:#d5e9ff;"><spring:message code="board.subject" /></th>
		<th align="left"><input type="text" name="subject" style="width:80%;" value="${ldata.subject}" />
		<form:errors path="ldata.subject" /></th>
	</tr>
	<tr>
		<th style="background:#d5e9ff;border:none;border-bottom:1px solid #A0A0A0;"><spring:message code="board.name" /></th>
		<td style="padding:0 0 0 3px;"><input type="text" name="name" value="${ldata.name}" />
		<form:errors path="ldata.name" />
		</td>
	</tr>
	<tr>
		<th style="background:#d5e9ff;border:none;border-bottom:1px solid #A0A0A0;"><spring:message code="board.password" /></th>
		<td style="padding:0 0 0 3px;"><input type="password" name="password" />
		<form:errors path="ldata.password" />
		</td>
	</tr>
</table>
<table cellpadding="7" cellspacing="0" style="width:100%;">
	<tr>
		<td align="center"><textarea name="memo" id="memo" rows="100" cols="100" class="b_memo">${ldata.memo}</textarea>
		<script>
		        CKEDITOR.replace( 'memo', {
			    	 uiColor : '#d5e9ff',
			    	 height : 250
			    });
			</script>
		</td>
	</tr>
</table>

<table cellpadding="7" cellspacing="0" style="width:100%;" class="boards">
<col width="90" />
<col width="410" />
	<tr>
		<th style="background:#d5e9ff;border:none;border-bottom:1px solid #A0A0A0;border-top:1px solid #A0A0A0;">
			<spring:message code="board.file1" />
		</th>
		<td style="padding:0 0 0 3px;border-top:1px solid #A0A0A0;">
			<c:if test="${ldata.file1 ne null}"><input type="checkbox" name="del1" value="1" style="width:15px;height:15px;" />&nbsp;삭제&nbsp;&nbsp; ${ldata.file1}</c:if>
			<c:if test="${ldata.file1 eq null}"><input type="file" name="files1" style="width:98%;" /></c:if>
		</td>
	</tr>
	<tr>
		<th style="background:#d5e9ff;border:none;border-bottom:1px solid #A0A0A0;">
			<spring:message code="board.file2" />
		</th>
		<td style="padding:0 0 0 3px;">
			<c:if test="${ldata.file2 ne null}"><input type="checkbox" name="del2" value="1" style="width:15px;height:15px;" />&nbsp;삭제&nbsp;&nbsp; ${ldata.file2}</c:if>
			<c:if test="${ldata.file2 eq null}"><input type="file" name="files2" style="width:98%;" /></c:if>
		</td>
	</tr>
</table>
<div class="boards_b">
	<div class="boards_bl">
		<a href="board.do?pages=${pages}&lang=${lang}" class="btn_st"  style="margin:0 0 0 10px;"><spring:message code="board.list" /></a>
	</div>
	<div class="boards_br">
		<input type="submit" value='<spring:message code="board.edit" />' class="btn_st"  style="float:right;margin:0 10px 0 0; height:26px;" />
	</div>
</div>
</form>
