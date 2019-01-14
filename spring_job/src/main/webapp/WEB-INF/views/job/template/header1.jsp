<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="xs_menu hidden-sm hidden-md hidden-lg" id="xs_menu_id" style="display:none;">
	<ul id="login_btn_bg2">
		<li><a href="#100" onclick="hide2('xs_menu_id');document.body.style.overflow='scroll';" style="color:#666666;font-weight:bold;padding:5px 0 5px 0;text-align:center;font-size:20px;">X</a></li>
        <c:if test="${memberInfo eq null}">
		<li><a href="#100" onclick="addloginbg(${member_no});hide2('xs_menu_id');">로그인</a></li>
		<li><a href="#100" onclick="show2('join_float_bg');document.body.style.overflow = 'hidden';hide2('xs_menu_id');">회원가입</a></li>
        </c:if>
        <c:if test="${memberInfo ne null}">
          <li onclick="toggle2('top_sub_id2');">
            <a href="#100">${memberInfo.name} 님</a>
          </li>
          <div id="top_sub_id2" style="display:none;">
          	<li><a href="#100" style="background:#e6e6e6;" onclick="logout_ajax(${member_no});">&nbsp;&nbsp;로그아웃</a></li>
          	<li><a href="#100" style="background:#e6e6e6;" onclick="login_edit_btn_ajax();hide2('xs_menu_id');">&nbsp;&nbsp;회원수정</a></li>
          </div>
          <c:if test="${memberInfo.orders eq 1}">
            <li><a href="#100" onclick="$('#main_load').load('mypage.o');mypage=1;hide2('xs_menu_id');">마이페이지</a></li>
          </c:if>
          <c:if test="${memberInfo.orders eq 2}">
            <li><a href="view.o?member_no=${memberInfo.no}">내 기업</a></li>
          </c:if>
          <c:if test="${memberInfo.orders eq 3}">
            <li><a href="adminpage.o">관리페이지</a></li>
          </c:if>
        </c:if>
	    <li><a href="#100" onclick="$('#main_load').load('list.o?search=1');hide2('xs_menu_id');">기업정보</a></li>
	    <li><a href="#100" onclick="$('#main_load').load('list.o?search=2');hide2('xs_menu_id');">채용정보</a></li>
	</ul>
</div>

<div class="header">
  <div class="container">
    <div class="row">
    
      <div class="col-sm-1"></div>
      <div class="col-sm-4 top_menu_align_left">
        <ul class="header_ul hidden-xs">
          <li class="header_ul_li"><a href="#100" onclick="$('#main_load').load('list.o?search=1');" class="header_ul_li_a">기업정보</a></li>
          <li class="header_ul_li"><a href="#100" onclick="$('#main_load').load('list.o?search=2');" class="header_ul_li_a">채용정보</a></li>
        </ul>
      </div>
      <div class="col-sm-2">
	  	<div class="header_logo_bg">
			<a href="#100" onclick="show2('xs_menu_id');document.body.style.overflow='hidden';" class="hidden-sm hidden-md hidden-lg nav_menu" style="margin-bottom:10px;">
				<div></div>
				<div></div>
				<div></div>
			</a>
	      	<h1 class="logo_float"><a href="#100" onclick="$('#main_load').load('index_load.o');"><img src="./images/logo.jpg" alt="logo" /></a></h1>
      	</div>
	  </div>
      <div class="col-sm-4 top_menu_align">
        <ul class="header_ul hidden-xs" id="login_btn_bg">
        <c:if test="${memberInfo eq null}">
          <li class="header_ul_li"><a href="#100" class="header_ul_li_a" onclick="addloginbg(${member_no});">로그인</a></li>
          <li class="header_ul_li"><a href="#100" class="header_ul_li_a" onclick="show2('join_float_bg');document.body.style.overflow = 'hidden';">회원가입</a></li>
        </c:if>
        <c:if test="${memberInfo ne null}">
          <li class="header_ul_li" onmousemove="show('top_sub_id');" onmouseleave="hide('top_sub_id')"><a href="#100" class="header_ul_li_a">${memberInfo.name} 님</a>
          	<div id="top_sub_id" class="top_sub" style="display:none;">
          		<a href="#100" onclick="logout_ajax(${member_no});">로그아웃</a>
          		<a href="#100" onclick="login_edit_btn_ajax();">회원수정</a>
          	</div>
          </li>
          <c:if test="${memberInfo.orders eq 1}">
            <li class="header_ul_li"><a href="#100" onclick="$('#main_load').load('mypage.o');mypage=1;" class="header_ul_li_a">마이페이지</a></li>
          </c:if>
          <c:if test="${memberInfo.orders eq 2}">
            <li class="header_ul_li"><a href="view.o?member_no=${memberInfo.no}" class="header_ul_li_a">내 기업</a></li>
          </c:if>
          <c:if test="${memberInfo.orders eq 3}">
            <li class="header_ul_li"><a href="adminpage.o" class="header_ul_li_a">관리페이지</a></li>
          </c:if>
        </c:if>
        </ul>
      </div>
      <div class="col-sm-1"></div>
      
      
    </div>
  </div>
</div>
