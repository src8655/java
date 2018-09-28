<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>

<div class="basket_top" style="width:800px;margin:0 auto;margin-top:10px;margin-bottom:20px;">
	<h1 style="width:600px;">
		<div><img src="./images/basket.jpg" alt="장바구니" /></div>
		<p>&nbsp;회원목록 상세보기</p>
	</h1>
</div>

<div class="join_agree">

<form action="mypage_admin_member_edit_post.o" method="post" id="join">
<input type="hidden" name="pages" value="${pages}" />
<input type="hidden" name="no" value="${mdata.no}" />
	<table cellpadding="15" cellspacing="0" class="joins" style="margin-bottom:10px;">
		<col width="130" />
		<col width="370" />
		<tr>
			<th><span style="color:#e61337;">•</span> 회원분류</th>
			<td>
				<select name="orders" class="join_input" style="width:200px;">
					<option value="1" <c:if test="${mdata.orders eq 1}">selected</c:if>>일반회원</option>
					<option value="2" <c:if test="${mdata.orders eq 2}">selected</c:if>>판매회원</option>
					<option value="3" <c:if test="${mdata.orders eq 3}">selected</c:if>>관리자</option>
				</select>
			</td>
		</tr>
		<tr>
			<th><span style="color:#e61337;">•</span> 사업자등록번호</th>
			<td><input type="text" name="company_number" class="join_input" placeholder="- 를 빼고 입력" value="${mdata.company_number}" /></td>
		</tr>
		<tr>
			<th><span style="color:#e61337;">•</span> 이름</th>
			<td><input type="text" name="name" class="join_input" placeholder="이름을 입력해 주세요" value="${mdata.name}" /></td>
		</tr>
		<tr>
			<th><span style="color:#e61337;">•</span> 아이디</th>
			<td>
					<div style="width:100%;overflow:hidden;">
					<div style="float:left;width:253px;overflow:hidden;">${mdata.user_id}</div>
					</div>
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
			<td><input type="text" name="email" class="join_input" placeholder="이메일을 입력해 주세요" value="${mdata.email}" /></td>
		</tr>
		<tr>
			<th><span style="color:#e61337;">•</span> 우편번호</th>
			<td>
				<div style="float:left;"><input type="text" name="zipcode" id="addr_code" style="width:100px;" class="join_input" value="${mdata.zipcode}" /></div>
				<div style="float:left;margin:0 0 0 5px;"><input type="button" value="우편번호 찾기" onclick="btn_find_daum()" class="join_id_button" /></div>
			</td>
		</tr>
		<tr>
			<th><span style="color:#e61337;">•</span> 주소</th>
			<td><input type="text" name="addr" id="addr" style="width:350px;" class="join_input" value="${mdata.addr}" /></td>
		</tr>
		<tr>
			<th><span style="color:#e61337;">•</span> 휴대폰 <span style="font-weight:bold;color:red;font-size:11px;"></span></th>
			<td><input type="text" name="phone1" style="width:60px;" class="join_input" value="${mdata.phone1}" /> - <input type="text" name="phone2" style="width:60px;" class="join_input" value="${mdata.phone2}" /> - <input type="text" name="phone3" style="width:60px;" class="join_input" value="${mdata.phone3}" /></td>
		</tr>
		<tr>
			<th><span style="color:#e61337;">•</span> 입금은행</th>
			<td><input type="text" name="bank" class="join_input" placeholder="은행명을 입력해 주세요" value="${mdata.bank}" /></td>
		</tr>
		<tr>
			<th><span style="color:#e61337;">•</span> 입금계좌번호</th>
			<td><input type="text" name="bank_num" class="join_input" placeholder="- 를 빼고 입력" value="${mdata.bank_num}" /></td>
		</tr>
	</table>
	<div class="join_red_button">
		<a href="#10" onclick="join.submit();">수정하기</a>
	</div>
</form>
</div>


<%@ include file="foot.jsp" %>