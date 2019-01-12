<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="container">
  <div class="row">
    <div class="col-sm-1 col-md-1 col-lg-1"></div>
    <div class="col-sm-10 col-md-10 col-lg-10">
    
    
    
    
    
    
    <div class="main_category_bg">
	    <div class="main_category">
	    	<h3>산업군</h3>
	    	<div class="main_category_items">
	    		<a href="list.o">전체</a>
	    		<a href="list.o?searchType=1">서비스업</a>
				<a href="list.o?searchType=2">제조/화학</a>
				<a href="list.o?searchType=3">의료/제약/복지</a>
				<a href="list.o?searchType=4">유통/무역/운송</a>
				<a href="list.o?searchType=5">교육업</a>
				<a href="list.o?searchType=6">건설업</a>
				<a href="list.o?searchType=7">IT/웹/통신</a>
				<a href="list.o?searchType=8">미디어/디자인</a>
				<a href="list.o?searchType=9">은행/금융업</a>
				<a href="list.o?searchType=10">기관/협회</a>
	    	</div>
	    </div>
    </div>
    
    
    
    
    
    <%-- 
    <div class="c_lists c_lists_left">
      <div class="index_list_top">
      	<a href="list.o?search=1">기업정보</a>
      </div>
      <ul class="c_lists_ul">
      <c:forEach items="${list}" var="cdata">
        <li><a href="view.o?member_no=${cdata.member_no}&pages=${pages}&searchValue=${searchValue_utf}&search=${search}&searchType=${searchType}&searchSort=${searchSort}">
          <div class="c_lists_l">
          	<c:if test="${cdata.file1 eq ''}"><img src="./images/company_logo.jpg" alt="company_logo" width="78px" height="78px" /></c:if>
          	<c:if test="${cdata.file1 ne ''}"><img src="./upload/${cdata.file1}" alt="company_logo" width="78px" height="78px" /></c:if>
          </div>
          <div class="c_lists_c">
            <h4>
              ${cdata.company}
              <c:if test="${cdata.isfollow eq -1}"><img src="./images/list_heart.jpg" alt="하트" class="list_follow_img list_follow_img_${cdata.member_no}" /></c:if>
              <c:if test="${cdata.isfollow eq 1}"><img src="./images/list_heart2.jpg" alt="하트" class="list_follow_img list_follow_img_${cdata.member_no}" /></c:if>
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
      <div class="index_list_more" style="z-index:6000;">
      	<a></a>
      </div>
    </div>
	<!-- 채용정보 -->
	<div class="c_lists c_lists_right">
      <div class="index_list_top">
      	<a href="list.o?search=2">채용정보</a>
      </div>
      <ul class="c_lists_ul">
      <c:forEach items="${list2}" var="rcdata">
        <li><a href="view.o?member_no=${rcdata.member_no}&recruit_no=${rcdata.no}">
          <div class="c_lists2_l hidden-lg hidden-md hidden-xs">
          	<c:if test="${rcdata.file1 eq ''}"><img src="./images/company_logo.jpg" alt="company_logo" width="78px" height="78px" /></c:if>
          	<c:if test="${rcdata.file1 ne ''}"><img src="./upload/${rcdata.file1}" alt="company_logo" width="78px" height="78px" /></c:if>
          </div>
          <div class="c_lists2_c">
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
          </div>
        </a></li>
        </c:forEach>
      </ul>
      <div class="index_list_more">
      	<a></a>
      </div>
    </div> --%>
    
    
    
    
    
    
    
    
    
    <div class="best_review_bg">
      <div class="best_review_top">
      	<h3>베스트기업 리뷰</h3>
      	<p>익명으로 작성된 솔직한 기업평가 Best</p>
      </div>
      
      
      <div class="best_scroll">
      
      <c:forEach items="${list}" var="cdata">
      <div class="best_review_header">
      	<a href="view.o?member_no=${cdata.member_no}">
      	<div class="best_review_header_l">
      		<c:if test="${cdata.file1 eq ''}"><img src="./images/company_logo.jpg" alt="company_logo" width="55px" height="55px" /></c:if>
          	<c:if test="${cdata.file1 ne ''}"><img src="./upload/${cdata.file1}" alt="company_logo" width="55px" height="55px" /></c:if>
      	</div>
      	<div class="best_review_header_r">
      		<h5>
      			${cdata.company}
            	<c:if test="${cdata.isfollow eq -1}"><img src="./images/list_heart.jpg" alt="하트" class="list_follow_img list_follow_img_${cdata.member_no}" /></c:if>
            	<c:if test="${cdata.isfollow eq 1}"><img src="./images/list_heart2.jpg" alt="하트" class="list_follow_img list_follow_img_${cdata.member_no}" /></c:if>
      		</h5>
      		<div class="list_star_r">
              <div class="list_star_line0"><div class="list_star_line1" style="width:${cdata.avg_stars_p}px;"></div></div>
              <!-- 92px -->
            </div>
            <p>
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
            	 | 
            	${cdata.count_review} 기업리뷰
            </p>
      	</div>
        </a>
      </div>
      <c:if test="${cdata.rdata ne null}">
      <div class="best_review_body">
        <h3>"${cdata.rdata.memo1}"</h3>
        <h5 style="color:#0f7ccf;">장점</h5>
        <p>
        	${cdata.rdata.memo2}
        </p>
        <h5 style="color:#fc4a13;">단점</h5>
        <p>
        	${cdata.rdata.memo3}
        </p>
      </div>
      </c:if>
      </c:forEach>
      
      </div>
      
      
      
      
      
    </div>
    
    
    <div class="best_recruit_bg">
      <div class="best_review_top">
      	<h3>베스트 채용정보</h3>
      	<p>만족도가 높은 기업의 채용공고</p>
      </div>
      
      <div class="best_scroll">
      
      <ul>
      <c:forEach items="${list2}" var="rcdata">
        <li><a href="view.o?member_no=${rcdata.member_no}&recruit_no=${rcdata.no}">
          <div class="c_lists2_c">
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
          </div>
        </a></li>
        </c:forEach>
      </ul>
      
      </div>
      
    </div>
    
    
    
    
    
    
    
    </div>
    <div class="col-sm-1 col-md-1 col-lg-1"></div>
  </div>
</div>