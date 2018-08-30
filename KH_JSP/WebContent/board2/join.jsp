<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<%@ page import = "java.util.*" %>



<%
String id = request.getParameter("id");
String pages = request.getParameter("pages");

//날짜 가져오기
Calendar cal = Calendar.getInstance();
int datey = cal.get(Calendar.YEAR);
int datem = cal.get(Calendar.MONTH)+1;
int dated = cal.get(Calendar.DATE);


%>

<h1 class="join_header">필수항목</h1>
<form action="join_post.jsp" id="join">
<input type="hidden" name="id" value="<%=id %>" />
<input type="hidden" name="pages" value="<%=pages %>" />
<table cellpadding="7" cellspacing="0" class="joins" style="margin-bottom:10px;">
	<col width="130" />
	<col width="370" />
	<tr>
		<th>아이디 <span style="font-weight:bold;color:red;font-size:11px;">(*)</span></th>
		<td>
				<div style="float:left;"><input type="text" name="user_id" id="user_ids"  class="jinput" /></div>
				<div style="float:left;margin:0 0 0 5px;"><input type="button" value="중복체크" onclick="btn_check()" class="btn_st" style="height:27px;" /></div>
				<div style="line-height:26px;float:left;margin:0 0 0 5px;"><span style="color:#3985ac;" id="id_ch_value">중복 확인 절차를 거쳐야 합니다.</span></div>
		</td>
	</tr>
	<tr>
		<th>비밀번호 <span style="font-weight:bold;color:red;font-size:11px;">(*)</span></th>
		<td><input type="password" name="passwords" class="jinput" /></td>
	</tr>
	<tr>
		<th>비밀번호 확인 <span style="font-weight:bold;color:red;font-size:11px;">(*)</span></th>
		<td><input type="password" name="passwords2" class="jinput" /> 다시입력해주세요.</td>
	</tr>
	<tr>
		<th>이름 <span style="font-weight:bold;color:red;font-size:11px;">(*)</span></th>
		<td><input type="text" name="name" class="jinput" /> 이름을 입력해주세요.</td>
	</tr>
	<tr>
		<th>E-mail <span style="font-weight:bold;color:red;font-size:11px;">(*)</span></th>
		<td><input type="text" name="email" class="jinput" /> 이메일을 입력해주세요.</td>
	</tr>
	<tr>
		<th>생년월일 <span style="font-weight:bold;color:red;font-size:11px;">(*)</span></th>
		<td>
			<select name="birthy">
				<% for(int i=datey;i>1940;i--) { %>
				<option value="<%=i %>"><%=i %></option>
				<% } %>
			</select>
			년
			<select name="birthm">
				<% for(int i=1;i<13;i++) { %>
				<option value="<%=i %>"><%=i %></option>
				<% } %>
			</select>
			월
			<select name="birthd">
				<% for(int i=1;i<32;i++) { %>
				<option value="<%=i %>"><%=i %></option>
				<% } %>
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
			<div style="float:left;"><input type="text" name="addr_code" id="addr_code" style="width:100px;" class="jinput" /></div>
			<div style="float:left;margin:0 0 0 5px;"><input type="button" value="우편번호 찾기" onclick="btn_find_daum()" class="btn_st" style="width:120px;height:27px;" /></div>
		</td>
	</tr>
	<tr>
		<th>주소</th>
		<td><input type="text" name="addr" id="addr" style="width:350px;" class="jinput" /></td>
	</tr>
	<tr>
		<th>휴대전화 <span style="font-weight:bold;color:red;font-size:11px;"></span></th>
		<td><input type="text" name="phone1" style="width:60px;" class="jinput" /> - <input type="text" name="phone2" style="width:60px;" class="jinput" /> - <input type="text" name="phone3" style="width:60px;" class="jinput" /></td>
	</tr>
</table>
<div id="join_b"><input type="button" onclick="join_submit();" value="회원가입" class="btn_st" style="margin:0 auto;" /></div>
</form>

<%@ include file="foot.jsp" %>