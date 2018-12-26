<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="header">
  <div class="container">
    <div class="row">
    
      <div class="col-sm-1"></div>
      <div class="col-sm-4 top_menu_align_left">
        <ul class="header_ul">
          <li class="header_ul_li"><a href="#" class="header_ul_li_a">기업정보</a></li>
          <li class="header_ul_li"><a href="#" class="header_ul_li_a">채용정보</a></li>
        </ul>
      </div>
      <div class="col-sm-2"><h1><a href="#"><img src="./images/logo.jpg" alt="logo" /></a></h1></div>
      <div class="col-sm-4 top_menu_align">
        <ul class="header_ul">
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
            <select class="c_list_select">
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
        </div>
        <div class="col-xs-12 col-sm-6 align-center">
          <div class="list_search">
            <form>
              <div class="list_search_l">
                <select>
                  <option value="-1">통합</option>
                  <option value="1">기업</option>
                  <option value="2">채용</option>
                </select>
              </div>
              <div class="list_search_c">
                <input type="text" />
              </div>
              <div class="list_search_r">
                <input type="submit" value="" />
              </div>
            </form>
          </div>
        </div>
        
        <div class="col-xs-12 col-sm-3 c_list_select_align_r">
          <select class="hidden-sm hidden-md hidden-lg c_list_select">
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
          <select class="c_list_select">
            <option value="-1">정렬선택</option>
            <option value="1">총 만족도 순</option>
            <option value="2">리뷰 많은 순</option>
          </select>
        </div>
      
      
      </div>
    </div>
  </div>
</div>