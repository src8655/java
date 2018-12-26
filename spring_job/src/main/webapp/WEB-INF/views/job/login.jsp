<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="container">
  <div class="row">
    <div class="col-sm-1 col-md-2 col-lg-2"></div>
    <div class="col-sm-10 col-md-8 col-lg-8 align-center">
    
    
    
    
    
    
    
    
    
    
    <div class="login_box" style="margin-top:50px;">
      <h1>로그인</h1>
      <form action="login_post.o" method="post" onsubmit="return login_submit(this)">
        <input type="text" name="email" placeholder="이메일 주소" class="login_input" value="${save_id_auth}" onchange="login_email_check(this);" />
        <div id="login_email_msg" class="join_msg"></div>
        <input type="password" name="password" placeholder="비밀번호" class="login_input" onchange="login_password_check(this);" />
        <div id="login_password_msg" class="join_msg"></div>
        <input type="submit" value="로그인" class="login_btn" />
        <div id="login_msg" class="join_msg"></div>
        <input type="checkbox" name="save_id" id="save_id" value="1" <c:if test="${save_id_auth ne ''}">checked</c:if> />
        <label for="save_id">아이디 저장</label>
      </form>
      <div class="login_find">
        <a href="#100">아이디 찾기</a> /
        <a href="#100">비밀번호 찾기</a>
      </div>
      <div class="login_box_b">
        아직 회원이 아니세요?
        &nbsp;&nbsp;
        <a href="join.o">회원가입</a>
      </div>
    </div>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    </div>
    <div class="col-sm-1 col-md-2 col-lg-2"></div>
  </div>
</div>