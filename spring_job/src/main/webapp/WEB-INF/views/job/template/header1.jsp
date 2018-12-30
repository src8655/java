<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="xs_menu" id="xs_menu_id" style="display:none;">
	<ul>
		<li><a href="#100" onclick="hide2('xs_menu_id');document.body.style.overflow='scroll';" style="color:#666666;font-weight:bold;padding:5px 0 5px 0;text-align:center;font-size:20px;">X</a></li>
        <c:if test="${memberInfo eq null}">
		<li><a href="login.o">로그인</a></li>
		<li><a href="join.o">회원가입</a></li>
        </c:if>
        <c:if test="${memberInfo ne null}">
          <li onclick="toggle2('top_sub_id');">
            <a href="#100">${memberInfo.name} 님</a>
          </li>
          <div id="top_sub_id" style="display:none;">
          	<li><a href="logout.o" style="background:#e6e6e6;">&nbsp;&nbsp;로그아웃</a></li>
          	<li><a href="login_edit.o" style="background:#e6e6e6;">&nbsp;&nbsp;회원수정</a></li>
          </div>
          <c:if test="${memberInfo.orders eq 1}">
            <li><a href="#100">마이페이지</a></li>
          </c:if>
          <c:if test="${memberInfo.orders eq 2}">
            <li><a href="view.o?member_no=${memberInfo.no}">내 기업</a></li>
          </c:if>
        </c:if>
	    <li><a href="">기업정보</a></li>
	    <li><a href="">채용정보</a></li>
	</ul>
</div>

<div class="header">
  <div class="container">
    <div class="row">
    
      <div class="col-sm-1"></div>
      <div class="col-sm-4 top_menu_align_left">
        <ul class="header_ul hidden-xs">
          <li class="header_ul_li"><a href="#" class="header_ul_li_a">기업정보</a></li>
          <li class="header_ul_li"><a href="#" class="header_ul_li_a">채용정보</a></li>
        </ul>
      </div>
      <div class="col-sm-2">
	  	<div class="header_logo_bg">
			<a href="#100" onclick="show2('xs_menu_id');document.body.style.overflow='hidden';" class="hidden-sm hidden-md hidden-lg nav_menu" style="margin-bottom:10px;">
				<div></div>
				<div></div>
				<div></div>
			</a>
	      	<h1 class="logo_float"><a href="#"><img src="./images/logo.jpg" alt="logo" /></a></h1>
      	</div>
	  </div>
      <div class="col-sm-4 top_menu_align">
        <ul class="header_ul hidden-xs">
        <c:if test="${memberInfo eq null}">
          <li class="header_ul_li"><a href="login.o" class="header_ul_li_a">로그인</a></li>
          <li class="header_ul_li"><a href="join.o" class="header_ul_li_a">회원가입</a></li>
        </c:if>
        <c:if test="${memberInfo ne null}">
          <li class="header_ul_li" onmousemove="show('top_sub_id');" onmouseleave="hide('top_sub_id')"><a href="#100" class="header_ul_li_a">${memberInfo.name} 님</a>
          	<div id="top_sub_id" class="top_sub" style="display:none;">
          		<a href="logout.o">로그아웃</a>
          		<a href="login_edit.o">회원수정</a>
          	</div>
          </li>
          <c:if test="${memberInfo.orders eq 1}">
            <li class="header_ul_li"><a href="#100" class="header_ul_li_a">마이페이지</a></li>
          </c:if>
          <c:if test="${memberInfo.orders eq 2}">
            <li class="header_ul_li"><a href="view.o?member_no=${memberInfo.no}" class="header_ul_li_a">내 기업</a></li>
          </c:if>
        </c:if>
        </ul>
      </div>
      <div class="col-sm-1"></div>
      
      
    </div>
  </div>
</div>

<div class="list_top_bg">
  <div class="list_top">
    <div class="container">
      <div class="row">
      
        <div class="hidden-xs col-sm-3 c_list_select_align_l">
            <select class="c_list_select" name="searchType" onchange="location.href='list.o?search=${search}&searchValue=${searchValue}&searchSort=${searchSort}&searchType='+this.value;">
              <option value="-1">산업군</option>
              <option value="1" <c:if test="${searchType eq 1}">selected</c:if>>서비스업</option>
              <option value="2" <c:if test="${searchType eq 2}">selected</c:if>>제조/화학</option>
              <option value="3" <c:if test="${searchType eq 3}">selected</c:if>>의료/제약/복지</option>
              <option value="4" <c:if test="${searchType eq 4}">selected</c:if>>유통/무역/운송</option>
              <option value="5" <c:if test="${searchType eq 5}">selected</c:if>>교육업</option>
              <option value="6" <c:if test="${searchType eq 6}">selected</c:if>>건설업</option>
              <option value="7" <c:if test="${searchType eq 7}">selected</c:if>>IT/웹/통신</option>
              <option value="8" <c:if test="${searchType eq 8}">selected</c:if>>미디어/디자인</option>
              <option value="9" <c:if test="${searchType eq 9}">selected</c:if>>은행/금융업</option>
              <option value="10" <c:if test="${searchType eq 10}">selected</c:if>>기관/협회</option>
            </select>
        </div>
        <div class="col-xs-12 col-sm-6 align-center">
          <div class="list_search">
            <form action="list.o">
              <input type="hidden" name="searchType" value="${searchType}" />
              <input type="hidden" name="searchSort" value="${searchSort}" />
              <div class="list_search_l">
                <select name="search">
                  <option value="-1">통합</option>
                  <option value="1" <c:if test="${search eq 1}">selected</c:if>>기업</option>
                  <option value="2" <c:if test="${search eq 2}">selected</c:if>>채용</option>
                </select>
              </div>
              <div class="list_search_c">
                <input type="text" name="searchValue" value="${searchValue}" />
              </div>
              <div class="list_search_r">
                <input type="submit" value="" />
              </div>
            </form>
          </div>
        </div>
        
        <div class="col-xs-12 col-sm-3 c_list_select_align_r">
          <select class="hidden-sm hidden-md hidden-lg c_list_select" name="searchType" onchange="location.href='list.o?search=${search}&searchValue=${searchValue}&searchSort=${searchSort}&searchType='+this.value;">
            <option value="-1">산업군</option>
              <option value="1" <c:if test="${searchType eq 1}">selected</c:if>>서비스업</option>
              <option value="2" <c:if test="${searchType eq 2}">selected</c:if>>제조/화학</option>
              <option value="3" <c:if test="${searchType eq 3}">selected</c:if>>의료/제약/복지</option>
              <option value="4" <c:if test="${searchType eq 4}">selected</c:if>>유통/무역/운송</option>
              <option value="5" <c:if test="${searchType eq 5}">selected</c:if>>교육업</option>
              <option value="6" <c:if test="${searchType eq 6}">selected</c:if>>건설업</option>
              <option value="7" <c:if test="${searchType eq 7}">selected</c:if>>IT/웹/통신</option>
              <option value="8" <c:if test="${searchType eq 8}">selected</c:if>>미디어/디자인</option>
              <option value="9" <c:if test="${searchType eq 9}">selected</c:if>>은행/금융업</option>
              <option value="10" <c:if test="${searchType eq 10}">selected</c:if>>기관/협회</option>
          </select>
          <select class="c_list_select" name="searchSort" onchange="location.href='list.o?search=${search}&searchValue=${searchValue}&searchType=${searchType}&searchSort='+this.value;">
            <option value="-1">정렬선택</option>
            <option value="1" <c:if test="${searchSort eq 1}">selected</c:if>>총 만족도 순</option>
            <option value="2" <c:if test="${searchSort eq 2}">selected</c:if>>연봉 금액 순</option>
            <option value="3" <c:if test="${searchSort eq 3}">selected</c:if>>리뷰 많은 순</option>
            <option value="4" <c:if test="${searchSort eq 4}">selected</c:if>>연봉 정보 순</option>
            <option value="5" <c:if test="${searchSort eq 5}">selected</c:if>>면접 정보 순</option>
          </select>
        </div>
      
      
      </div>
    </div>
  </div>
</div>