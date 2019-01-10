<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
  <div class="row">
    <div class="col-sm-1 col-md-1 col-lg-1"></div>
    <div class="col-sm-10 col-md-10 col-lg-10">
    
    
    
        <div class="c_lists c_lists_left">
      <div class="index_list_top">
      	<a href="list.o?search=1" style="background:#ffffff;color:#333333;border-bottom:1px solid #e6e6e6;text-align:left;padding-left:20px;">팔로우 기업 (${count})</a>
      </div>
      <ul class="c_lists_ul2">
      <c:forEach items="${list}" var="cdata">
        <li><a href="view.o?member_no=${cdata.member_no}&pages=${pages}&searchValue=${searchValue_utf}&search=${search}&searchType=${searchType}&searchSort=${searchSort}">
          <div class="c_lists_l">
          	<c:if test="${cdata.file1 eq ''}"><img src="./images/company_logo.jpg" alt="company_logo" width="78px" height="78px" /></c:if>
          	<c:if test="${cdata.file1 ne ''}"><img src="./upload/${cdata.file1}" alt="company_logo" width="78px" height="78px" /></c:if>
          </div>
          <div class="c_lists_c">
            <h4>
              ${cdata.company}
              <c:if test="${cdata.isfollow eq -1}"><img src="./images/list_heart.jpg" class="list_follow_img list_follow_img_${cdata.member_no}" alt="하트" /></c:if>
              <c:if test="${cdata.isfollow eq 1}"><img src="./images/list_heart2.jpg" class="list_follow_img list_follow_img_${cdata.member_no}" alt="하트" /></c:if>
            </h4>
            <p class="hidden-md">
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
            </p>
            <p class="hidden-lg hidden-sm hidden-xs">
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
              <img src="./images/star0.jpg" alt="star" />
            	<span style="color:#32aa46;">${cdata.avg_stars}</span> | 
            	평균 연봉 <span style="color:#32aa46;">${cdata.avg_moneys}</span>만원 | 
            	총 만족도 <span style="font-weight:bold;">${cdata.avg_stars}</span>
            </p>
            <p class="hidden-xs">${cdata.count_review} 기업리뷰 | ${cdata.count_income} 연봉정보 | ${cdata.count_interview} 면접정보</p>
            <p class="hidden-sm hidden-md hidden-lg">${cdata.count_review} 기업 | ${cdata.count_income} 연봉 | ${cdata.count_interview} 면접</p>
          </div>
          <div class="c_lists_r hidden-md">
            <h4>총 만족도 <span style="font-weight:bold;">${cdata.avg_stars}</span></h4>
            <div class="list_star_r">
              <div class="list_star_line0"><div class="list_star_line1" style="width:${cdata.avg_stars_p}px;"></div></div>
              <!-- 92px -->
              
            </div>
            <p>평균 <span style="font-size:15px;">${cdata.avg_moneys}</span> 만원</p>
          </div>
        </a></li>
        </c:forEach>
      </ul>
      <div class="index_list_bottom">
      <div class="paging">
        <a href="mypage.o?pages=1&pages_r=${pages_r}" style="color:#d0d0d0;" class="paging_radius_l">&lt;</a>
        <c:forEach begin="${paging.pstarts}" end="${paging.pends}" step="1" var="i">
        	<a href="mypage.o?pages=${i}&pages_r=${pages_r}"
        		<c:if test="${i ne pages}"> class="paging_a"</c:if> <c:if test="${i eq pages}"> class="paging_a_hover"</c:if>>
        		${i}
        	</a>
        </c:forEach>
        <a href="mypage.o?pages=${paging.board_paging}&pages_r=${pages_r}" style="color:#d0d0d0;" class="paging_radius_r">&gt;</a>
      </div>
      </div>
    </div>
	<!-- 채용정보 -->
	
	
	<div class="c_lists c_lists_right">
      <div class="index_list_top">
      	<a href="list.o?search=2" style="background:#ffffff;color:#333333;border-bottom:1px solid #e6e6e6;text-align:left;padding-left:20px;">지원한 채용정보 (${count2})</a>
      </div>
      <ul class="c_lists_ul2">
      <c:forEach items="${list2}" var="rcdata">
        <li><a href="view.o?member_no=${rcdata.member_no}&recruit_no=${rcdata.no}">
          <div class="c_lists2_l hidden-lg hidden-md hidden-xs">
          	<c:if test="${rcdata.file1 eq ''}"><img src="./images/company_logo.jpg" alt="company_logo" width="78px" height="78px" /></c:if>
          	<c:if test="${rcdata.file1 ne ''}"><img src="./upload/${rcdata.file1}" alt="company_logo" width="78px" height="78px" /></c:if>
          </div>
          </a>
          
          <div class="c_lists2_c">
          <a href="view.o?member_no=${rcdata.member_no}&recruit_no=${rcdata.no}">
            <h4>
              ${rcdata.subject}
            </h4>
            <p>
            	<span style="color:#666666;font-weight:bold;">${rcdata.company}</span>&nbsp;
            	<img src="./images/star0.jpg" alt="star" />
            	<span style="color:#32aa46;">${rcdata.avg_stars}</span> | 
            	평균 연봉 <span style="color:#32aa46;">${rcdata.avg_moneys}</span>만원 | 
              <c:if test="${rcdata.company_cate eq 1}">서비스업</c:if>
              <c:if test="${rcdata.company_cate eq 2}">제조/화학</c:if>
              <c:if test="${rcdata.company_cate eq 3}">의료/제약/복지</c:if>
              <c:if test="${rcdata.company_cate eq 4}">유통/무역/운송</c:if>
              <c:if test="${rcdata.company_cate eq 5}">교육업</c:if>
              <c:if test="${rcdata.company_cate eq 6}">건설업</c:if>
              <c:if test="${rcdata.company_cate eq 7}">IT/웹/통신</c:if>
              <c:if test="${rcdata.company_cate eq 8}">미디어/디자인</c:if>
              <c:if test="${rcdata.company_cate eq 9}">은행/금융업</c:if>
              <c:if test="${rcdata.company_cate eq 10}">기관/협회</c:if>
              <span style="font-weight:bold;color:#fba208;">D-${rcdata.dday}</span>
            </p>
            <p>
            	<img src="./images/keyword.jpg" alt="keyword" />
            	${rcdata.keyword}
            </p>
	        <p style="">
		        <a href="download.o?filename=${rcdata.fi1}" style="height:25px;line-height:25px;border-radius:10px;background:#3ac453;color:#ffffff;font-weight:bold;padding:0 10px 0 10px;font-size:13px;display:inline-block;">이력서 보기</a>
		        <c:if test="${rcdata.fi2 ne null}">
		        <c:if test="${rcdata.fi2 ne ''}">
		        <a href="download.o?filename=${rcdata.fi2}" style="height:25px;line-height:25px;border-radius:10px;background:#3ac453;color:#ffffff;font-weight:bold;padding:0 10px 0 10px;font-size:13px;display:inline-block;">첨부파일</a>
	        	</c:if>
	        	</c:if>
	        </p>
            </a>
          </div>
      	
        </li>
        </c:forEach>
      </ul>
      <div class="index_list_bottom">
      <div class="paging">
        <a href="mypage.o?pages_rc1&pages=${pages}&mypage=1" style="color:#d0d0d0;" class="paging_radius_l">&lt;</a>
        <c:forEach begin="${paging2.pstarts}" end="${paging2.pends}" step="1" var="i">
        	<a href="mypage.o?pages_r=${i}&pages=${pages}&mypage=1"
        		<c:if test="${i ne pages_r}"> class="paging_a"</c:if> <c:if test="${i eq pages_r}"> class="paging_a_hover"</c:if>>
        		${i}
        	</a>
        </c:forEach>
        <a href="mypage.o?pages_r=${paging2.board_paging}&pages=${pages}&mypage=1" style="color:#d0d0d0;" class="paging_radius_r">&gt;</a>
      </div>
      </div>
    </div>
    
    
    
    </div>
    <div class="col-sm-1 col-md-2 col-lg-2"></div>
  </div>
</div>