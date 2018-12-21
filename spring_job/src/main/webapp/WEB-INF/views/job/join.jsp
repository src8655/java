<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="container">
  <div class="row">
    <div class="col-sm-1 col-md-2 col-lg-2"></div>
    <div class="col-sm-10 col-md-8 col-lg-8 align-center">
    
    
    
    
    
    
    
    <ul class="join_t">
      <li><a href="#" class="join_t_li_a_hover" id="join_btn_01" onclick="join_tab(this, false);">개인회원</a></li>
      <li><a href="#" class="join_t_li_a" id="join_btn_02" onclick="join_tab(this, true);">기업회원</a></li>
    </ul>
    
    
    <div class="login_box" id="join_01">
      <h1 id="join_h">회원가입</h1>
      <form action="join_post.o" method="post" onsubmit="return join_submit(this)">
      	<input type="hidden" name="orders" value="1" class="login_input" id="join_orders" />
        <input type="text" name="email" placeholder="이메일 주소" class="login_input" onchange="email_check(this);" />
        <div id="email_msg" class="join_msg"></div>
        <input type="password" name="password" placeholder="비밀번호" class="login_input" onchange="password_check(this);" />
        <div id="password_msg" class="join_msg"></div>
        <input type="password" name="password2" placeholder="비밀번호 확인" class="login_input" onchange="password2_check(this);" />
        <div id="password2_msg" class="join_msg"></div>
        
        <div id="join_02" style="display:none;">
        	<br /><br />
	        <input type="text" name="company" placeholder="기업명" class="login_input" onchange="company_check(this);" />
	        <div id="company_msg" class="join_msg"></div>
	        <select name="company_cate" class="join_select" onchange="company_cate_check(this);">
	          <option value="-1">산업군</option>
	          <option value="1">서비스업</option>
	          <option value="2">제조/화학</option>
	          <option value="3">의료/제약/복지</option>
	          <option value="4">유통/무역/운송</option>
	          <option value="5">교육업</option>
	          <option value="6">건설업</option>
	          <option value="7">IT/웹/통신</option>
	          <option value="8">미디어/디자인</option>
	          <option value="9">은행/금융업</option>
	          <option value="10">기관/협회</option>
	        </select>
	        <div id="company_cate_msg" class="join_msg"></div>
	        <input type="text" name="company_num" placeholder="사업자등록번호" class="login_input" onchange="company_num_check(this);" />
	        <div id="company_num_msg" class="join_msg"></div>
	        <br /><br />
        </div>
        
        <input type="text" name="name" placeholder="이름" class="login_input" onchange="name_check(this);" />
        <div id="name_msg" class="join_msg"></div>
        <div class="join_phone" style="overflow:hidden;">
          <h4>전화번호</h4>
          <input type="text" name="phone1" placeholder="010" class="login_input" style="padding-left:10px;width:20%;float:left;" onchange="phone1_check(this);" />
          <div>-</div>
          <input type="text" name="phone2" placeholder="0000" class="login_input" style="padding-left:10px;width:20%;float:left;" onchange="phone2_check(this);" />
          <div>-</div>
          <input type="text" name="phone3" placeholder="0000" class="login_input" style="padding-left:10px;width:20%;float:left;" onchange="phone3_check(this);" />
        </div>
        <div id="phone_msg" class="join_msg"></div>
        <div class="join_quest">
          <h4>질문/답변</h4>
          <select name="quest" class="join_select" onchange="quest_check(this);">
  			<option value="-1">질문을 선택해 주세요.</option>
  			<option value="1">나의 아버지 이름은?</option>
  			<option value="2">내가 다니던 학교 이름은?</option>
  			<option value="3">나의 취미는?</option>
  			<option value="4">내가 좋아하던 게임은?</option>
  			<option value="5">나의 직업은?</option>
  			</select>
        	<div id="quest_msg" class="join_msg"></div>
  			<input type="text" name="answer" placeholder="답변" class="login_input" onchange="answer_check(this);" />
        	<div id="answer_msg" class="join_msg"></div>
        </div>
        <input type="submit" value="회원가입" class="login_btn" />
      </form>
    </div>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    </div>
    <div class="col-sm-1 col-md-2 col-lg-2"></div>
  </div>
</div>