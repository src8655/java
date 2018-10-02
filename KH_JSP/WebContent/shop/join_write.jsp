<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</div>

<div class="join_agree_bg">

<div class="join_agree">
	<div class="join_agree_header">
		<h1>
			<c:if test="${order eq 1}">개인 구매회원 가입</c:if>
			<c:if test="${order eq 2}">사업자 판매회원 가입</c:if>
		</h1>
		<ul>
			<li>4 가입완료</li>
			<li style="color:#ea0000;border-bottom:2px solid #ea0000;">3 정보입력</li>
			<li>2 약관동의</li>
			<li>1 회원선택</li>
		</ul>
	</div>
	<p class="join_agree_c">회원정보를 입력해주세요. 모두 입력하셔야 가입이 가능합니다.</p>
<form action="join_write_post.o" method="post" id="join">
<input type="hidden" name="order" value="${order}" />
	<table cellpadding="15" cellspacing="0" class="joins" style="margin-bottom:10px;">
		<col width="130" />
		<col width="370" />
		<c:if test="${order eq 1}">
			<input type="hidden" name="company_number" value="" />
			<input type="hidden" name="bank" value="" />
			<input type="hidden" name="bank_num" value="" />
		</c:if>
		<c:if test="${order eq 2}">
		<tr>
			<th><span style="color:#e61337;">•</span> 사업자등록번호</th>
			<td><input type="text" name="company_number" class="join_input" placeholder="- 를 빼고 입력" /></td>
		</tr>
		</c:if>
		<c:if test="${order eq 2}">
		<tr>
			<th><span style="color:#e61337;">•</span> 입금은행</th>
			<td><input type="text" name="bank" class="join_input" placeholder="은행명을 입력해 주세요" /></td>
		</tr>
		</c:if>
		<c:if test="${order eq 2}">
		<tr>
			<th><span style="color:#e61337;">•</span> 입금계좌번호</th>
			<td><input type="text" name="bank_num" class="join_input" placeholder="- 를 빼고 입력" /></td>
		</tr>
		</c:if>
		<tr>
			<th><span style="color:#e61337;">•</span> 이름</th>
			<td><input type="text" name="name" class="join_input" placeholder="이름을 입력해 주세요" /></td>
		</tr>
		<tr>
			<th><span style="color:#e61337;">•</span> 아이디</th>
			<td>
					<div style="width:100%;overflow:hidden;">
					<div style="float:left;width:253px;overflow:hidden;"><input type="text" name="user_id" id="user_ids"  class="join_input" placeholder="ID를 입력해 주세요" style="width:228px;" /></div>
					<div style="float:left;margin:0 0 0 5px;width:30%;overflow:hidden;"><input type="button" value="중복확인" onclick="btn_check()" class="join_id_button" /></div>
					</div>
					<div style="line-height:26px;float:left;margin:0 0 0 5px;"><span style="color:#3985ac;font-size:12px;" id="id_ch_value">아이디를 입력해 주세요</span></div>
			</td>
		</tr>
		<tr>
			<th><span style="color:#e61337;">•</span> 비밀번호</th>
			<td><input type="password" name="user_pw" class="join_input" placeholder="비밀번호를 입력해 주세요" /></td>
		</tr>
		<tr>
			<th><span style="color:#e61337;">•</span> 비밀번호 확인</th>
			<td><input type="password" name="user_pw2" class="join_input" placeholder="비밀번호를 다시 한번 입력해 주세요" /></td>
		</tr>
		<tr>
			<th><span style="color:#e61337;">•</span> 이메일</th>
			<td><input type="text" name="email" class="join_input" placeholder="이메일을 입력해 주세요" /></td>
		</tr>
		<tr>
			<th><span style="color:#e61337;">•</span> 우편번호</th>
			<td>
				<div style="float:left;"><input type="text" name="zipcode" id="addr_code" style="width:100px;" class="join_input" /></div>
				<div style="float:left;margin:0 0 0 5px;"><input type="button" value="우편번호 찾기" onclick="btn_find_daum()" class="join_id_button" /></div>
			</td>
		</tr>
		<tr>
			<th><span style="color:#e61337;">•</span> 주소</th>
			<td><input type="text" name="addr" id="addr" style="width:350px;" class="join_input" /></td>
		</tr>
		<tr>
			<th><span style="color:#e61337;">•</span> 휴대폰 <span style="font-weight:bold;color:red;font-size:11px;"></span></th>
			<td><input type="text" name="phone1" style="width:60px;" class="join_input" /> - <input type="text" name="phone2" style="width:60px;" class="join_input" /> - <input type="text" name="phone3" style="width:60px;" class="join_input" /></td>
		</tr>
	</table>
	<div class="join_red_button">
		<a href="#10" onclick="join_submit();">회원가입</a>
	</div>
</form>
</div>

</div>

<div>