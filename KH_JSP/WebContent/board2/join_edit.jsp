<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<%@ page import = "java.util.*" %>



<%
//비로그인 접근금지
if(member_info == null) {
	out.println("<script>");
	out.println("alert('잘못된 접근입니다.')");
	out.println("history.go(-1)");
	out.println("</script>");
	
	return;
}


//날짜 가져오기
Calendar cal = Calendar.getInstance();
int datey = cal.get(Calendar.YEAR);
int datem = cal.get(Calendar.MONTH)+1;
int dated = cal.get(Calendar.DATE);


%>

<h1 class="join_header">필수항목</h1>
<form action="join_edit_post.jsp" id="join">
<input type="hidden" name="id" value="<%=id %>" />
<input type="hidden" name="pages" value="<%=pages %>" />
<input type="hidden" name="user_id" value="<%=member_info.getUser_id() %>" />
<table cellpadding="7" cellspacing="0" class="joins" style="margin-bottom:10px;">
	<col width="130" />
	<col width="370" />
	<tr>
		<th>아이디 <span style="font-weight:bold;color:red;font-size:11px;">(*)</span></th>
		<td>
				<div style="float:left;"><%=member_info.getUser_id() %></div>
		</td>
	</tr>
	<tr>
		<th>비밀번호 <span style="font-weight:bold;color:red;font-size:11px;">(*)</span></th>
		<td><input type="password" name="passwords" class="jinput" /></td>
	</tr>
	<tr>
		<th>이름 <span style="font-weight:bold;color:red;font-size:11px;">(*)</span></th>
		<td><input type="text" name="name" class="jinput" value="<%=member_info.getName() %>" /> 이름을 입력해주세요.</td>
	</tr>
	<tr>
		<th>E-mail <span style="font-weight:bold;color:red;font-size:11px;">(*)</span></th>
		<td><input type="text" name="email" class="jinput" value="<%=member_info.getEmail() %>" /> 이메일을 입력해주세요.</td>
	</tr>
	<tr>
		<th>생년월일 <span style="font-weight:bold;color:red;font-size:11px;">(*)</span></th>
		<td>
			<select name="birthy">
				<% for(int i=datey;i>1940;i--) { %>
				<option value="<%=i %>" <% if(Integer.parseInt(member_info.getBirthy()) == i) { %>selected<% } %>><%=i %></option>
				<% } %>
			</select>
			년
			<select name="birthm">
				<% for(int i=1;i<13;i++) { %>
				<option value="<%=i %>" <% if(Integer.parseInt(member_info.getBirthm()) == i) { %>selected<% } %>><%=i %></option>
				<% } %>
			</select>
			월
			<select name="birthd">
				<% for(int i=1;i<32;i++) { %>
				<option value="<%=i %>" <% if(Integer.parseInt(member_info.getBirthd()) == i) { %>selected<% } %>><%=i %></option>
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
			<div style="float:left;"><input type="text" name="addr_code" id="addr_code" style="width:100px;" class="jinput" value="<%=member_info.getAddr_code() %>" /></div>
			<div style="float:left;margin:0 0 0 5px;"><input type="button" value="우편번호 찾기" onclick="btn_find_daum();" class="btn_st" style="width:120px;height:27px;" /></div>
		</td>
	</tr>
	<tr>
		<th>주소</th>
		<td><input type="text" name="addr" id="addr" style="width:350px;" class="jinput" value="<%=member_info.getAddr() %>" /></td>
	</tr>
<%
String phone1 = member_info.getPhone1();
String phone2 = member_info.getPhone2();
String phone3 = member_info.getPhone3();

if(phone1 == null) phone1 = "";
else if(phone1.equals("null")) phone1 = "";
if(phone2 == null) phone2 = "";
else if(phone2.equals("null")) phone2 = "";
if(phone3 == null) phone3 = "";
else if(phone3.equals("null")) phone3 = "";

%>
	<tr>
		<th>휴대전화 <span style="font-weight:bold;color:red;font-size:11px;"></span></th>
		<td><input type="text" name="phone1" style="width:60px;" class="jinput" value="<%=phone1 %>" /> - <input type="text" name="phone2" style="width:60px;" class="jinput" value="<%=phone2 %>" /> - <input type="text" name="phone3" style="width:60px;" class="jinput" value="<%=phone3 %>" /></td>
	</tr>
</table>
<div id="join_b"><input type="submit"  value="정보수정" class="btn_st" style="margin:0 auto;" /></div>
</form>

<%@ include file="foot.jsp" %>