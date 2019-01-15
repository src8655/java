<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<div class="xs_menu" id="xs_menu_id" style="display:none;">
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
            <li><a href="index.o?index_page=3">마이페이지</a></li>
          </c:if>
          <c:if test="${memberInfo.orders eq 2}">
            <li><a href="view.o?member_no=${memberInfo.no}">내 기업</a></li>
          </c:if>
	      <c:if test="${memberInfo.orders eq 3}">
	        <li><a href="index.o?index_page=4">관리페이지</a></li>
	      </c:if>
        </c:if>
	    <li><a href="index.o?index_page=1">기업정보</a></li>
	    <li><a href="index.o?index_page=2">채용정보</a></li>
	</ul>
</div>
<div class="header">
  <div class="container">
    <div class="row">
    
      <div class="col-sm-1"></div>
      <div class="hidden-sm hidden-md hidden-lg">
      	<div class="header_logo_bg ">
			<a href="#100" onclick="show2('xs_menu_id');document.body.style.overflow='hidden';" class=" nav_menu">
				<div></div>
				<div></div>
				<div></div>
			</a>
	      	<h1 class="logo_float"><a href="index.o"><img src="./images/logo.jpg" alt="logo" /></a></h1>
      	</div>
      </div>
      <div class="search_box_align hidden-sm hidden-md hidden-lg">
        <div class="search_box">
          <form action="list.o" id="top_search">
          <input type="text" name="searchValue" />
          <a href="#100" onclick="top_search.submit();"><img src="./images/search_btn.jpg" alt="search" /></a>
          </form>
        </div>
      </div>
      
      <div class="col-sm-10 hidden-xs">
	      <div class="last_align_l top_menu_align_left">
	        <ul class="header_ul hidden-xs">
	          <li class="header_ul_li"><a href="index.o?index_page=1" class="header_ul_li_a">기업정보</a></li>
	          <li class="header_ul_li"><a href="index.o?index_page=2" class="header_ul_li_a">채용정보</a></li>
	        </ul>
	      </div>
	      
	      <div class="last_align_c">
	      	<div class="search_box_bg">
		        <form action="list.o" id="top_search">
		      	<h2 class="logo_float"><a href="index.o"><img src="./images/logo.jpg" alt="logo" /></a></h2>
		        <div class="search_box2">
		          <input type="text" name="searchValue" />
		          <a href="#100" onclick="top_search.submit();"><img src="./images/search_btn.jpg" alt="search" /></a>
		        </div>
		        </form>
	        </div>
	      </div>
	      
	      <div class="last_align_r top_menu_align">
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
	            <li class="header_ul_li"><a href="index.o?index_page=3" class="header_ul_li_a">마이페이지</a></li>
	          </c:if>
	          <c:if test="${memberInfo.orders eq 2}">
	            <li class="header_ul_li"><a href="view.o?member_no=${memberInfo.no}" class="header_ul_li_a">내 기업</a></li>
	          </c:if>
	          <c:if test="${memberInfo.orders eq 3}">
	            <li class="header_ul_li"><a href="index.o?index_page=4" class="header_ul_li_a">관리페이지</a></li>
	          </c:if>
	        </c:if>
	        </ul>
	      </div>
	  </div>
      <div class="col-sm-1"></div>
      
      
    </div>
  </div>
</div>

