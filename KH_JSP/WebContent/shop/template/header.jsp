<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="top_bg">
  <ul>
    <li><a href="customer_center.o">고객센터</a></li>
    <li>
    <c:if test="${member_info eq null}">
    	<a href="login.o" style="color:#adc12c;">나의 쇼핑정보 <img src="./images/myinfo.jpg" alt="나의 쇼핑정보" /></a>
    </c:if>
    <c:if test="${member_info.orders eq 1}">
    	<a href="mypage_guest.o" style="color:#adc12c;">나의 쇼핑정보 <img src="./images/myinfo.jpg" alt="나의 쇼핑정보" /></a>
    </c:if>
    <c:if test="${member_info.orders eq 2}">
    	<a href="mypage.o" style="color:#adc12c;">나의 판매정보 <img src="./images/myinfo.jpg" alt="나의 판매정보" /></a>
    </c:if>
    <c:if test="${member_info.orders eq 3}">
    	<a href="mypage_admin.o" style="color:#adc12c;">관리자 페이지 <img src="./images/myinfo.jpg" alt="관리자 페이지" /></a>
    </c:if>
    </li>
    <li>
    	<a href="basket.o">
    		장바구니
    		<c:if test="${basket_cnt ne 0}">
    			<span style="font-weight:bold;color:blue;font-family:'Arial';">(${basket_cnt})</span>
    		</c:if>
    	</a>
    </li>
    <c:if test="${member_info eq null}">
    <li><a href="join.o">회원가입</a></li>
    <li><a href="login.o" style="border:0px;">로그인</a></li>
    </c:if>
    <c:if test="${member_info ne null}">
    <li><a href="logout.o">로그아웃</a></li>
    <li><a href="join_edit.o" style="border:0px;font-weight:bold;">회원정보 수정</a></li>
    <li><a style="border:0px;"><span style="font-weight:bold;">${member_info.name}</span>님 환영합니다.</a></li>
    </c:if>
  </ul>
</div>
<div id="header">
  <h1><a href="index.o"><img src="./images/logo.jpg" alt="logo" /></a></h1>
  <div id="header_c">
    <ul id="header_c_t">
      <li><a href="#100" onclick="quick_search('산삼/장뇌삼','');">산삼/장뇌삼</a></li>
      <li><a href="#100" onclick="quick_search('약용버섯','');">약용버섯</a></li>
      <li><a href="#100" onclick="quick_search('식물','');">식물</a></li>
      <li><a href="#100" onclick="quick_search('진액','');">진액</a></li>
      <li><a href="#100" onclick="quick_search('액기스','');">액기스</a></li>
      <li><a href="#100" onclick="quick_search('홍삼가공','');" style="border:0px;">홍삼가공</a></li>
    </ul>
    <div id="header_c_c">
    <form action="list.o" method="get" id="header_c_c_l_search">
      <input type="hidden" name="order" value="${order}" />
      <input type="hidden" name="searchs" value="${searchs}" />
      <div id="header_c_c_l">
        <input type="text" name="searchs_value" value="${searchs_value}" id="header_c_c_l_text" />
      </div>
      <div id="header_c_c_r">
        <input type="submit" value="" id="header_c_c_l_button" />
      </div>
    </form>
    </div>
    <ul id="header_c_b">
      <li><a href="list.o?order=1"><img src="./images/top_menu_01.jpg" alt="베스트셀러" /></a></li>
      <li><a href="list.o?order=2"><img src="./images/top_menu_02.jpg" alt="영카트 추천상품" /></a></li>
      <li><a href="list.o?order=3" style="border:0px;"><img src="./images/top_menu_03.jpg" alt="무료배송상품" /></a></li>
    </ul>
  </div>
  <div id="header_r">
    <a href="#100" onclick="quick_search('박광희김치','');"><img src="./images/top_right_menu.jpg" alt="박광희김치" /></a>
  </div>
</div>
