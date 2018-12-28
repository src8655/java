<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="header">
  <div class="container">
    <div class="row">
    
      <div class="col-sm-1"></div>
      <div class="col-sm-3"><h1><a href="#"><img src="./images/logo.jpg" alt="logo" /></a></h1></div>
      <div class="col-sm-3 search_box_align">
        <div class="search_box">
          <input type="text" />
          <a href="#"><img src="./images/search_btn.jpg" alt="search" /></a>
        </div>
      </div>
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

<c:if test="${cdata.file2 eq ''}"><div class="main_subject_bg" style="background:url(./images/office_bk.jpg) no-repeat center top;"></c:if>
<c:if test="${cdata.file2 ne ''}"><div class="main_subject_bg" style="background:url(./upload/${cdata.file2}) no-repeat center top;"></c:if>
  <div class="main_subject">
    <div class="container">
      <div class="row">
      
        <div class="col-sm-1"></div>
        <div class="col-sm-7">
          <p class="m_s_left">
          	<c:if test="${cdata.file1 eq ''}"><img src="./images/company_logo.jpg" width="100px" height="100px" alt="logo" /></c:if>
          	<c:if test="${cdata.file1 ne ''}"><img src="./upload/${cdata.file1}" width="100px" height="100px" alt="logo" /></c:if>
          </p>
          <p class="m_s_right">
            <h3>${cdata.company}</h3>
              <c:if test="${cdata.company_cate eq 1}">서비스업</c:if>
              <c:if test="${cdata.company_cate eq 2}">제조/화학</c:if>
              <c:if test="${cdata.company_cate eq 3}">의료/제약/복지</c:if>
              <c:if test="${cdata.company_cate eq 4}">유통/무역/운송</c:if>
              <c:if test="${cdata.company_cate eq 5}">교육업</c:if>
              <c:if test="${cdata.company_cate eq 6}">건설업</c:if>
              <c:if test="${cdata.company_cate eq 7}">IT/웹/통신</c:if>
              <c:if test="${cdata.company_cate eq 8}">미디어/디자인</c:if>
              <c:if test="${cdata.company_cate eq 9}">은행/금융업</c:if>
              <c:if test="${cdata.company_cate eq 10}">기관/협회</c:if>
            <br />
            <a href="#" class="follow_btn"><img src="./images/heart.jpg" alt="heart" />팔로우</a>
            <img src="./images/star.png" alt="star" /> 4.7
            <br />
            <a href="${cdata.url}" class="url_btn">${cdata.url}</a>
          </p>
        </div>
        <div class="col-sm-3 cover_img_align">
          <c:if test="${memberInfo ne null}">
          <c:if test="${memberInfo.no eq cdata.member_no}">
          <a href="edit.o?member_no=${cdata.member_no}&pages=${pages}&searchValue=${searchValue_utf}" class="cover_img_btn">
            <img src="./images/camera.png" alt="camera" />기업정보 관리</a>
          </c:if>
          </c:if>
        </div>
        <div class="col-sm-1"></div>
      
      
      </div>
    </div>
  </div>
</div>


<nav>
  <div class="container">
    <div class="row">
      
        <div class="col-sm-1"></div>
        
        
        <div class="col-sm-10">
          <ul>
            <li><a href="view.o?member_no=${member_no}&pages=${pages}&searchValue=${searchValue_utf}" <c:if test="${tab eq 1}">class="nav_ul_li_a_hover"</c:if><c:if test="${tab ne 1}">class="nav_ul_li_a"</c:if>>
              <span>Info</span><br />
              기업정보
            </a></li>
            <li><a href="review.o?member_no=${member_no}&pages=${pages}&searchValue=${searchValue_utf}" <c:if test="${tab eq 2}">class="nav_ul_li_a_hover"</c:if><c:if test="${tab ne 2}">class="nav_ul_li_a"</c:if>>
              <span>${count2}</span><br />
              기업리뷰
            </a></li>
            <li><a href="income.o?member_no=${member_no}&pages=${pages}&searchValue=${searchValue_utf}" <c:if test="${tab eq 3}">class="nav_ul_li_a_hover"</c:if><c:if test="${tab ne 3}">class="nav_ul_li_a"</c:if>>
              <span>${count3}</span><br />
              연봉정보
            </a></li>
            <li><a href="interview.o?member_no=${member_no}&pages=${pages}&searchValue=${searchValue_utf}" <c:if test="${tab eq 4}">class="nav_ul_li_a_hover"</c:if><c:if test="${tab ne 4}">class="nav_ul_li_a"</c:if>>
              <span>${count4}</span><br />
              면접후기
            </a></li>
            <li><a href="#" <c:if test="${tab eq 5}">class="nav_ul_li_a_hover"</c:if><c:if test="${tab ne 5}">class="nav_ul_li_a"</c:if>>
              <span>D-1</span><br />
              채용공고
            </a></li>
          </ul>
        </div>
        
        
        <div class="col-sm-1"></div>
    
    </div>
  </div>
</nav>