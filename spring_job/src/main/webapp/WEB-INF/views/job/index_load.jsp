<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>





<div class="list_top_bg">
  <div class="list_top">
    <div class="container">
      <div class="row">
      
        <div class="hidden-xs col-sm-3 c_list_select_align_l">
            <select class="c_list_select" name="searchType" onchange="$('#main_load').load('list.o?search=${search}&searchValue=${searchValue_utf}&searchSort=${searchSort}&searchType='+this.value);">
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
            <form id="list_search_forms" onsubmit="return list_search(this);">
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
                <input type="button" value="" onclick="list_search(document.getElementById('list_search_forms'));" />
              </div>
            </form>
          </div>
        </div>
        
        <div class="col-xs-12 col-sm-3 c_list_select_align_r">
          <select class="hidden-sm hidden-md hidden-lg c_list_select" name="searchType" onchange="$('#main_load').load('list.o?search=${search}&searchValue=${searchValue_utf}&searchSort=${searchSort}&searchType='+this.value);">
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
          <select class="c_list_select" name="searchSort" onchange="$('#main_load').load('list.o?search=${search}&searchValue=${searchValue_utf}&searchType=${searchType}&searchSort='+this.value);">
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








<div class="container">
  <div class="row">
    <div class="col-sm-1 col-md-1 col-lg-1"></div>
    <div class="col-sm-10 col-md-10 col-lg-10">
    
    
    
    
    
    
    <div class="main_category_bg">
	    <div class="main_category">
	    	<h3>산업군</h3>
	    	<div class="main_category_items">
	    		<a href="#100" onclick="$('#main_load').load('list.o');">전체</a>
	    		<a href="#100" onclick="$('#main_load').load('list.o?searchType=1');">서비스업</a>
				<a href="#100" onclick="$('#main_load').load('list.o?searchType=2');">제조/화학</a>
				<a href="#100" onclick="$('#main_load').load('list.o?searchType=3');">의료/제약/복지</a>
				<a href="#100" onclick="$('#main_load').load('list.o?searchType=4');">유통/무역/운송</a>
				<a href="#100" onclick="$('#main_load').load('list.o?searchType=5');">교육업</a>
				<a href="#100" onclick="$('#main_load').load('list.o?searchType=6');">건설업</a>
				<a href="#100" onclick="$('#main_load').load('list.o?searchType=7');">IT/웹/통신</a>
				<a href="#100" onclick="$('#main_load').load('list.o?searchType=8');">미디어/디자인</a>
				<a href="#100" onclick="$('#main_load').load('list.o?searchType=9');">은행/금융업</a>
				<a href="#100" onclick="$('#main_load').load('list.o?searchType=10');">기관/협회</a>
	    	</div>
	    </div>
    </div>
    
    
    
    <div class="best_review_bg hidden-xs hidden-sm">
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
    
    
    <div class="best_recruit_bg hidden-xs hidden-sm">
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    <!-- 모바일용 -->
    <div class="best_review_bg hidden-md hidden-lg">
      <div class="best_review_top">
      	<h3>베스트기업 리뷰</h3>
      	<p>익명으로 작성된 솔직한 기업평가 Best</p>
      </div>
      
      
      <div class="best_scroll" id="best_scroll_1">
      <div class="best_scroll_bottom_bg" id="best_scroll_bottom_bg_1"></div>
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
      
      <div class="best_bottom_btn hidden-md hidden-lg" id="best_bottom_btn_1">
      	<a href="#100" onclick="best_more('best_scroll_1','best_scroll_bottom_bg_1','best_bottom_btn_1')">더보기</a>
      </div>
      
      
      
      
    </div>
    
    
    <div class="best_recruit_bg hidden-md hidden-lg">
      <div class="best_review_top">
      	<h3>베스트 채용정보</h3>
      	<p>만족도가 높은 기업의 채용공고</p>
      </div>
      
      <div class="best_scroll" id="best_scroll_2">
      <div class="best_scroll_bottom_bg" id="best_scroll_bottom_bg_2"></div>
      
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
      
      <div class="best_bottom_btn hidden-md hidden-lg" id="best_bottom_btn_2">
      	<a href="#100" onclick="best_more('best_scroll_2','best_scroll_bottom_bg_2','best_bottom_btn_2')">더보기</a>
      </div>
      
    </div>
    
    
    
    
    
    
    
    </div>
    <div class="col-sm-1 col-md-1 col-lg-1"></div>
  </div>
</div>
