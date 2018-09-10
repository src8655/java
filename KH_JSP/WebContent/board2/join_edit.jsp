<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>

<h1 class="join_header">필수항목</h1>
<form action="join_edit_post" id="join">
<input type="hidden" name="kakao" value="${member_info.kakao}" />
<input type="hidden" name="no" value="${member_info.no}" />
<input type="hidden" name="id" value="${id}" />
<input type="hidden" name="pages" value="${pages}" />
<input type="hidden" name="user_id" value="${member_info.user_id}" />
<table cellpadding="7" cellspacing="0" class="joins" style="margin-bottom:10px;">
	<col width="130" />
	<col width="370" />
	<tr>
		<th>아이디 <span style="font-weight:bold;color:red;font-size:11px;">(*)</span></th>
		<td>
				<div style="float:left;">${member_info.user_id}</div>
		</td>
	</tr>
	<tr>
		<th>비밀번호 <span style="font-weight:bold;color:red;font-size:11px;">(*)</span></th>
		<td>
			<c:if test="${member_info.kakao eq 1}">
			<input type="hidden" name="passwords" class="jinput" value="${member_info.passwords}" />
			카카오 로그인
			</c:if>
			<c:if test="${member_info.kakao ne 1}">
			<input type="password" name="passwords" class="jinput" />
			</c:if>
		</td>
	</tr>
	<tr>
		<th>이름 <span style="font-weight:bold;color:red;font-size:11px;">(*)</span></th>
		<td><input type="text" name="name" class="jinput" value="${member_info.name}" /> 이름을 입력해주세요.</td>
	</tr>
	<tr>
		<th>E-mail <span style="font-weight:bold;color:red;font-size:11px;">(*)</span></th>
		<td><input type="text" name="email" class="jinput" value="${member_info.email}" /> 이메일을 입력해주세요.</td>
	</tr>
	<tr>
		<th>생년월일 <span style="font-weight:bold;color:red;font-size:11px;">(*)</span></th>
		<td>
			<select name="birthy">
				<c:forEach begin="1940" end="${datey}" step="1" var="i">
				<option value="${i}" <c:if test="${member_info.birthy eq i}">selected</c:if>>${i}</option>
				</c:forEach>
			</select>
			년
			<select name="birthm">
				<c:forEach begin="1" end="12" step="1" var="i">
				<option value="${i}" <c:if test="${member_info.birthm eq i}">selected</c:if>>${i}</option>
				</c:forEach>
			</select>
			월
			<select name="birthd">
				<c:forEach begin="1" end="31" step="1" var="i">
				<option value="${i}" <c:if test="${member_info.birthd eq i}">selected</c:if>>${i}</option>
				</c:forEach>
			</select>
			일
		</td>
	</tr>
</table>
<h1 class="join_header">선택항목</h1>
<table cellpadding="7" cellspacing="0" class="joins">
	<col width="130" />
	<col width="370" />
	<tr>
		<th>우편번호</th>
		<td>
			<div style="float:left;"><input type="text" name="addr_code" id="addr_code" style="width:100px;" class="jinput" value="${member_info.addr_code}" /></div>
			<div style="float:left;margin:0 0 0 5px;"><input type="button" value="우편번호 찾기" onclick="btn_find_daum();" class="btn_st" style="width:120px;height:27px;" /></div>
		</td>
	</tr>
	<tr>
		<th>주소</th>
		<td><input type="text" name="addr" id="addr" style="width:350px;" class="jinput" value="${member_info.addr}" /></td>
	</tr>
	<tr>
		<th>휴대전화 <span style="font-weight:bold;color:red;font-size:11px;"></span></th>
		<td><input type="text" name="phone1" style="width:60px;" class="jinput" value="${member_info.phone1}" /> - <input type="text" name="phone2" style="width:60px;" class="jinput" value="${member_info.phone2}" /> - <input type="text" name="phone3" style="width:60px;" class="jinput" value="${member_info.phone3}" /></td>
	</tr>
</table>
<div id="join_b"><input type="submit"  value="정보수정" class="btn_st" style="margin:0 auto;" /></div>
</form>

<%@ include file="foot.jsp" %>