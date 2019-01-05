<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="container">
  <div class="row">
    <div class="col-sm-1 col-md-2 col-lg-2"></div>
    <div class="col-sm-10 col-md-8 col-lg-8 align-center">
    
    
    
    
    
    
      
    
    <div class="login_box" id="join_01">
      <h1 id="join_h">회원 수정</h1>
      <form action="login_edit_post.o" method="post" onsubmit="return login_edit_submit(this);">
      	<input type="hidden" name="orders" value="${memberInfo.orders}" />
      	${memberInfo.email}
        <div id="email_msg" class="join_msg"></div>
        <input type="password" name="password" placeholder="비밀번호" class="login_input" onchange="password_checks(this);" />
        <div id="password_msg" class="join_msg"></div>
        <input type="password" name="password2" placeholder="비밀번호 확인" class="login_input" onchange="password2_checks(this);" />
        <div id="password2_msg" class="join_msg"></div>
        
        <c:if test="${memberInfo.orders eq 2}">
        <div id="join_02">
        	<br /><br />
	        <input type="text" name="company" placeholder="기업명" class="login_input" onchange="company_check(this);" value="${memberInfo.company}" />
	        <div id="company_msg" class="join_msg"></div>
	        <select name="company_cate" class="join_select" onchange="company_cate_check(this);">
	          <option value="-1">산업군</option>
	          <option value="1" <c:if test="${memberInfo.company_cate eq 1}">selected</c:if>>서비스업</option>
	          <option value="2" <c:if test="${memberInfo.company_cate eq 2}">selected</c:if>>제조/화학</option>
	          <option value="3" <c:if test="${memberInfo.company_cate eq 3}">selected</c:if>>의료/제약/복지</option>
	          <option value="4" <c:if test="${memberInfo.company_cate eq 4}">selected</c:if>>유통/무역/운송</option>
	          <option value="5" <c:if test="${memberInfo.company_cate eq 5}">selected</c:if>>교육업</option>
	          <option value="6" <c:if test="${memberInfo.company_cate eq 6}">selected</c:if>>건설업</option>
	          <option value="7" <c:if test="${memberInfo.company_cate eq 7}">selected</c:if>>IT/웹/통신</option>
	          <option value="8" <c:if test="${memberInfo.company_cate eq 8}">selected</c:if>>미디어/디자인</option>
	          <option value="9" <c:if test="${memberInfo.company_cate eq 9}">selected</c:if>>은행/금융업</option>
	          <option value="10" <c:if test="${memberInfo.company_cate eq 10}">selected</c:if>>기관/협회</option>
	        </select>
	        <div id="company_cate_msg" class="join_msg"></div>
	        <input type="text" name="company_num" placeholder="사업자등록번호" class="login_input" onchange="company_num_check(this);" value="${memberInfo.company_num}" />
	        <div id="company_num_msg" class="join_msg"></div>
	        <br /><br />
        </div>
        </c:if>
        
        <input type="text" name="name" placeholder="이름" class="login_input" onchange="name_check(this);" value="${memberInfo.name}" />
        <div id="name_msg" class="join_msg"></div>
        <div class="join_phone" style="overflow:hidden;">
          <h4>전화번호</h4>
          <input type="text" name="phone1" placeholder="010" class="login_input" style="float:left;padding-left:10px;width:20%;" onchange="phone1_check(this);" value="${memberInfo.phone1}" />
          <div>-</div>
          <input type="text" name="phone2" placeholder="0000" class="login_input" style="float:left;padding-left:10px;width:20%;" onchange="phone2_check(this);" value="${memberInfo.phone2}" />
          <div>-</div>
          <input type="text" name="phone3" placeholder="0000" class="login_input" style="float:left;padding-left:10px;width:20%;" onchange="phone3_check(this);" value="${memberInfo.phone3}" />
        </div>
        <div id="phone_msg" class="join_msg"></div>
        <div class="join_quest">
          <h4>질문/답변</h4>
          <select name="quest" class="join_select" onchange="quest_check(this);">
  			<option value="-1">질문을 선택해 주세요.</option>
  			<option value="1" <c:if test="${memberInfo.quest eq 1}">selected</c:if>>나의 아버지 이름은?</option>
  			<option value="2" <c:if test="${memberInfo.quest eq 2}">selected</c:if>>내가 다니던 학교 이름은?</option>
  			<option value="3" <c:if test="${memberInfo.quest eq 3}">selected</c:if>>나의 취미는?</option>
  			<option value="4" <c:if test="${memberInfo.quest eq 4}">selected</c:if>>내가 좋아하던 게임은?</option>
  			<option value="5" <c:if test="${memberInfo.quest eq 5}">selected</c:if>>나의 직업은?</option>
  			</select>
        	<div id="quest_msg" class="join_msg"></div>
  			<input type="text" name="answer" placeholder="답변" class="login_input" onchange="answer_check(this);" value="${memberInfo.answer}" />
        	<div id="answer_msg" class="join_msg"></div>
        </div>
        <input type="submit" value="수정완료" class="login_btn" />
      </form>
    </div>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    </div>
    <div class="col-sm-1 col-md-2 col-lg-2"></div>
  </div>
</div>