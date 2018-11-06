<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <div id="header">
    <div id="header_l">
      <a href="#"><img src="./images/header_add.jpg" alt="즐겨찾기에 추가" /></a>
    </div>
    <h1><a href="index.o"><img src="./images/logo.jpg" alt="로고" /></a></h1>
    <ul>
      <li style="border:0px;"><a href="notice.o">고객센터</a></li>
      <c:if test="${level eq 3}">
      <li><a href="admin.o" style="color:#00c8db;">관리자페이지</a></li>
      </c:if>
      <c:if test="${level ne 3}">
      <li><a href="mypage.o" style="color:#00c8db;">예약확인</a></li>
      </c:if>
      <li><a href="basket.o">상품바구니
      <c:if test="${basket_size ne 0}"><span style="color:red;">(${basket_size})</span></c:if>
      </a></li>
      <c:if test="${member_info eq null}">
	      <li><a href="join.o">회원가입</a></li>
	      <li><a href="login.o">로그인</a></li>
      </c:if>
      <c:if test="${member_info ne null}">
	      <li><a href="logout.o">로그아웃</a></li>
	      <li><a href="login_edit.o">${member_info.name}님</a></li>
      </c:if>
    </ul>
  </div>
  <div id="main_menu">
	  <ul>
	  	<li><a href="#" class="main_menu_a_sitemap"><img src="./images/menu_01.png" alt="main_menu_01" /></a></li>
	  	<li><a href="list.o?category=1" <c:if test="${category eq 1}">class="main_menu_a_hover"</c:if><c:if test="${category ne 1}">class="main_menu_a"</c:if>><img src="./images/menu_02.png" alt="main_menu_02" /></a></li>
	  	<li class="main_menu_line"><img src="./images/menu_line.jpg" alt="main_menu_line" /></li>
	  	<li><a href="list.o?category=2" <c:if test="${category eq 2}">class="main_menu_a_hover"</c:if><c:if test="${category ne 2}">class="main_menu_a"</c:if>><img src="./images/menu_03.png" alt="main_menu_03" /></a></li>
	  	<li class="main_menu_line"><img src="./images/menu_line.jpg" alt="main_menu_line" /></li>
	  	<li><a href="list.o?category=3" <c:if test="${category eq 3}">class="main_menu_a_hover"</c:if><c:if test="${category ne 3}">class="main_menu_a"</c:if>><img src="./images/menu_04.png" alt="main_menu_04" /></a></li>
	  	<li class="main_menu_line"><img src="./images/menu_line.jpg" alt="main_menu_line" /></li>
	  	<li><a href="list.o?category=4" <c:if test="${category eq 4}">class="main_menu_a_hover"</c:if><c:if test="${category ne 4}">class="main_menu_a"</c:if>><img src="./images/menu_05.png" alt="main_menu_05" /></a></li>
	  	<li class="main_menu_line"><img src="./images/menu_line.jpg" alt="main_menu_line" /></li>
	  	<li><a href="list.o?category=5" <c:if test="${category eq 5}">class="main_menu_a_hover"</c:if><c:if test="${category ne 5}">class="main_menu_a"</c:if>><img src="./images/menu_06.png" alt="main_menu_06" /></a></li>
	  	<li class="main_menu_line"><img src="./images/menu_line.jpg" alt="main_menu_line" /></li>
	  	<li><a href="list.o?category=6" <c:if test="${category eq 6}">class="main_menu_a_hover"</c:if><c:if test="${category ne 6}">class="main_menu_a"</c:if>><img src="./images/menu_07.png" alt="main_menu_07" /></a></li>
	  	<li class="main_menu_line"><img src="./images/menu_line.jpg" alt="main_menu_line" /></li>
	  	<li><a href="list.o?category=7" <c:if test="${category eq 7}">class="main_menu_a_hover"</c:if><c:if test="${category ne 7}">class="main_menu_a"</c:if>><img src="./images/menu_08.png" alt="main_menu_08" /></a></li>
	  	<li class="main_menu_line"><img src="./images/menu_line.jpg" alt="main_menu_line" /></li>
	  </ul>
	  <div id="main_menu_form">
	  	<form action="list.o" method="get">
	  		<div id="main_menu_form_l">
	  			<input type="text" name="searchs" placeholder="검색어를 입력해주세요." value="${searchs}" />
	  		</div>
	  		<div id="main_menu_form_r">
	  			<input type="submit" value="&nbsp;" />
	  		</div>
	  	</form>
	  </div>
  </div>