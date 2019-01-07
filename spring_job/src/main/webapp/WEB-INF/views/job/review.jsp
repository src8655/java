<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
<div class="write_hide" id="review_write" style="display:none;">
<div class="write_hide_scroll">
    <form action="review_write_post.o" method="post" onsubmit="return review_write_submit(this);">
    <input type="hidden" name="pages_rc" value="${pages_rc}" />
    <input type="hidden" name="pages" value="${pages}" />
    <input type="hidden" name="member_no" value="${member_no}" />
    <input type="hidden" name="searchValue" value="${searchValue_utf}" />
    <input type="hidden" name="search" value="${search}" />
    <input type="hidden" name="searchType" value="${searchType}" />
    <input type="hidden" name="searchSort" value="${searchSort}" />
    <div class="write_hide_scroll2">
    <div class="review_write_box">
      <h1>기업리뷰 작성</h1>
      <div class="review_write_box_line">
	      <div>
	    	기업 총 평점<br />
	    	<span>(선택)</span>
	      </div>
	      <p>
	        <a href="#100" onclick="rw_stars_btn(1,'rw_star','stars','stars_msg');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star1" /></a>
	        <a href="#100" onclick="rw_stars_btn(2,'rw_star','stars','stars_msg');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star2" /></a>
	        <a href="#100" onclick="rw_stars_btn(3,'rw_star','stars','stars_msg');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star3" /></a>
	        <a href="#100" onclick="rw_stars_btn(4,'rw_star','stars','stars_msg');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star4" /></a>
	        <a href="#100" onclick="rw_stars_btn(5,'rw_star','stars','stars_msg');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star5" /></a>
	        <input type="hidden" name="stars" id="stars" value="-1" onchange="rw_stars_check(this);" />
	        <span id="stars_msg" style="font-weight:bold;">평가해주세요.</span>
	      </p>
      </div>
      
      <div class="review_write_box_line">
	      <div>
	    	현 직장/전 직장<br />
	    	<span>(선택)</span>
	      </div>
	      <p>
	        <select name="types" class="join_select" onchange="rw_types_check(this);">
	  			<option value="-1">선택</option>
	  			<option value="1">현 직장</option>
	  			<option value="2" >전 직장</option>
  			</select>
  			<span id="types_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	직종<br />
	    	<span>(선택)</span>
	      </div>
	      <p>
	        <select name="prof" class="join_select" onchange="rw_prof_check(this);">
	  			<option value="-1">선택</option>
	  			<option value="1">IT/인터넷</option>
	  			<option value="2" >경영/기획/컨설팅</option>
	  			<option value="3" >교육</option>
	  			<option value="4" >금융/재무</option>
	  			<option value="5" >디자인</option>
	  			<option value="6" >마케팅/시장조사</option>
	  			<option value="7" >미디어/홍보</option>
	  			<option value="8" >법률/법무</option>
	  			<option value="9" >생산/제조</option>
	  			<option value="10" >기타</option>
  			</select>
  			<span id="prof_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	기업한줄평<br />
	    	<span>최소 20자</span>
	      </div>
	      <p>
	        <textarea rows="100" cols="100" class="edit_textarea" name="memo1" onchange="rw_memo1_check(this);" placeholder="예) 개발자가 대우받으며 보람차게 일할 수 있는 곳. 다양한 개발 환경을 경험하고, 서버와 클라이언트 양쪽에서 커리어를 쌓고 싶은 사람에게 추천."></textarea>
      		<span id="memo1_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	기업의 장점<br />
	    	<span>최소 30자</span>
	      </div>
	      <p>
	        <textarea rows="100" cols="100" class="edit_textarea" name="memo2" onchange="rw_memo2_check(this);" placeholder="예) 연차를 윗사람 눈치 안 보고 쓸 수 있음, 도서구입비, 학원 수강료 등 자기 계발 비용 지원, 야근 식대 1만원까지 제공, 수평적인 사무실 분위기. 업무 분담 체계가 확실해 자기 분야 전문성을 기를 수 있음."></textarea>
	      	<span id="memo2_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	기업의 단점<br />
	    	<span>최소 30자</span>
	      </div>
	      <p>
	        <textarea rows="100" cols="100" class="edit_textarea" name="memo3" onchange="rw_memo3_check(this);" placeholder="예) 단순 보고를 위한 문서 작업이 많아 비효율적. 복지 제도가 다양하지만 실제로 쓸 수 없음. 출근 시간은 8시인데 퇴근 시간은 ???. 연봉이 많다지만 시간급은 형편없음. 과장 차장이 많아 승진이 힘들다."></textarea>
	      	<span id="memo3_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	승진기회 및 가능성
	      </div>
	      <p>
	        <a href="#100" onclick="rw_stars_btn(1,'rw_star1_','stars1','stars_msg1');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star1_1" /></a>
	        <a href="#100" onclick="rw_stars_btn(2,'rw_star1_','stars1','stars_msg1');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star1_2" /></a>
	        <a href="#100" onclick="rw_stars_btn(3,'rw_star1_','stars1','stars_msg1');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star1_3" /></a>
	        <a href="#100" onclick="rw_stars_btn(4,'rw_star1_','stars1','stars_msg1');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star1_4" /></a>
	        <a href="#100" onclick="rw_stars_btn(5,'rw_star1_','stars1','stars_msg1');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star1_5" /></a>
	        <input type="hidden" name="stars1" id="stars1" value="-1" onchange="rw_stars1_check(this);" />
	        <span id="stars_msg1" style="font-weight:bold;">평가해주세요.</span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	복지 및 급여
	      </div>
	      <p>
	        <a href="#100" onclick="rw_stars_btn(1,'rw_star2_','stars2','stars_msg2');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star2_1" /></a>
	        <a href="#100" onclick="rw_stars_btn(2,'rw_star2_','stars2','stars_msg2');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star2_2" /></a>
	        <a href="#100" onclick="rw_stars_btn(3,'rw_star2_','stars2','stars_msg2');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star2_3" /></a>
	        <a href="#100" onclick="rw_stars_btn(4,'rw_star2_','stars2','stars_msg2');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star2_4" /></a>
	        <a href="#100" onclick="rw_stars_btn(5,'rw_star2_','stars2','stars_msg2');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star2_5" /></a>
	        <input type="hidden" name="stars2" id="stars2" value="-1" onchange="rw_stars2_check(this);" />
	        <span id="stars_msg2" style="font-weight:bold;">평가해주세요.</span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	업무와 삶의 균형
	      </div>
	      <p>
	        <a href="#100" onclick="rw_stars_btn(1,'rw_star3_','stars3','stars_msg3');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star3_1" /></a>
	        <a href="#100" onclick="rw_stars_btn(2,'rw_star3_','stars3','stars_msg3');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star3_2" /></a>
	        <a href="#100" onclick="rw_stars_btn(3,'rw_star3_','stars3','stars_msg3');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star3_3" /></a>
	        <a href="#100" onclick="rw_stars_btn(4,'rw_star3_','stars3','stars_msg3');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star3_4" /></a>
	        <a href="#100" onclick="rw_stars_btn(5,'rw_star3_','stars3','stars_msg3');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star3_5" /></a>
	        <input type="hidden" name="stars3" id="stars3" value="-1" onchange="rw_stars3_check(this);" />
	        <span id="stars_msg3" style="font-weight:bold;">평가해주세요.</span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	사내문화
	      </div>
	      <p>
	        <a href="#100" onclick="rw_stars_btn(1,'rw_star4_','stars4','stars_msg4');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star4_1" /></a>
	        <a href="#100" onclick="rw_stars_btn(2,'rw_star4_','stars4','stars_msg4');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star4_2" /></a>
	        <a href="#100" onclick="rw_stars_btn(3,'rw_star4_','stars4','stars_msg4');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star4_3" /></a>
	        <a href="#100" onclick="rw_stars_btn(4,'rw_star4_','stars4','stars_msg4');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star4_4" /></a>
	        <a href="#100" onclick="rw_stars_btn(5,'rw_star4_','stars4','stars_msg4');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star4_5" /></a>
	        <input type="hidden" name="stars4" id="stars4" value="-1" onchange="rw_stars4_check(this);" />
	        <span id="stars_msg4" style="font-weight:bold;">평가해주세요.</span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	경영진
	      </div>
	      <p>
	        <a href="#100" onclick="rw_stars_btn(1,'rw_star5_','stars5','stars_msg5');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star5_1" /></a>
	        <a href="#100" onclick="rw_stars_btn(2,'rw_star5_','stars5','stars_msg5');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star5_2" /></a>
	        <a href="#100" onclick="rw_stars_btn(3,'rw_star5_','stars5','stars_msg5');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star5_3" /></a>
	        <a href="#100" onclick="rw_stars_btn(4,'rw_star5_','stars5','stars_msg5');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star5_4" /></a>
	        <a href="#100" onclick="rw_stars_btn(5,'rw_star5_','stars5','stars_msg5');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star5_5" /></a>
	        <input type="hidden" name="stars5" id="stars5" value="-1" onchange="rw_stars5_check(this);" />
	        <span id="stars_msg5" style="font-weight:bold;">평가해주세요.</span>
	      </p>
      </div>
      
      <div class="review_write_box_line align-center">
	      <input type="button" value="닫기" onclick="hide2('review_write');document.body.style.overflow = 'scroll';" class="review_write_btn2" />
	      <input type="submit" value="제출하기" class="review_write_btn1" />
      </div>
    </div>
    </div>
    </form>
</div>
</div> --%>




<div id="view_contents">
    
</div>






<%-- 
<div class="container">
  <div class="row">
    <div class="col-sm-1"></div>
    <div class="col-sm-10">
    
    
    <c:if test="${memberInfo eq null}">
    <div class="review_write">
    	<a href="login.o">새로운리뷰 작성하기</a>
    </div>
    </c:if>
    <c:if test="${memberInfo ne null}">
    <c:if test="${memberInfo.orders eq 1}">
    <div class="review_write">
    	<a href="#100" onclick="show2('review_write');document.body.style.overflow = 'hidden';">새로운리뷰 작성하기</a>
    </div>
    </c:if>
    </c:if> --%>
    
    
    
<%--       <div class="contents">
        <div class="container">
          <div class="row">
            <div class="col-sm-4" style="width:220px;">
              <h1><img src="./images/review_h.jpg" alt="전체 리뷰 통계" /><span>전체</span> 리뷰 통계 (${count2}명)</h1>
              <p>
                <div class="review_star_l">${stars}</div>
                <div class="review_star_r">
                  <div class="review_star_line0"></div>
                  <!-- 68px -->
                  <div class="review_star_line1" style="width:${stars_bar}px;"></div>
                  <div class="review_star_line_b">총 만족도</div>
                </div>
              </p>
            </div>
            <div class="col-sm-5 col-md-6 col-lg-7">
              <h5>승진 기회 및 가능성</h5>
              <div class="r_bar_bg">
                <div class="r_bar1"><div class="r_bar2" style="width:${stars_bar1}%;"></div></div>
                <div class="r_bar_score">${stars1}</div>
              </div>
              <div class="r_bar_bg">
                <h5>복지 및 급여</h5>
                <div class="r_bar1"><div class="r_bar2" style="width:${stars_bar2}%;"></div></div>
                <div class="r_bar_score">${stars2}</div>
              </div>
              <div class="r_bar_bg">
                <h5>업무와 삶의 균형</h5>
                <div class="r_bar1"><div class="r_bar2" style="width:${stars_bar3}%;"></div></div>
                <div class="r_bar_score">${stars3}</div>
              </div>
              <div class="r_bar_bg">
                <h5>사내문화</h5>
                <div class="r_bar1"><div class="r_bar2" style="width:${stars_bar4}%;"></div></div>
                <div class="r_bar_score">${stars4}</div>
              </div>
              <div class="r_bar_bg">
                <h5>경영진</h5>
                <div class="r_bar1"><div class="r_bar2" style="width:${stars_bar5}%;"></div></div>
                <div class="r_bar_score">${stars5}</div>
              </div>
            </div>
          </div>
        </div>
      </div> --%>
    
    
    
    <a href="#100" onclick="review_ajax(1, ${member_no});">테스트</a>
    
    
    <%-- 
    
    <c:forEach items="${list}" var="rdata">
    <div class="contents">
      <div class="review_header">
      	<c:if test="${rdata.prof eq 1}">IT/인터넷</c:if>
	  	<c:if test="${rdata.prof eq 2}">경영/기획/컨설팅</c:if>
	  	<c:if test="${rdata.prof eq 3}">교육</c:if>
	  	<c:if test="${rdata.prof eq 4}">금융/재무</c:if>
	  	<c:if test="${rdata.prof eq 5}">디자인</c:if>
	  	<c:if test="${rdata.prof eq 6}">마케팅/시장조사</c:if>
	  	<c:if test="${rdata.prof eq 7}">미디어/홍보</c:if>
	  	<c:if test="${rdata.prof eq 8}">법률/법무</c:if>
	  	<c:if test="${rdata.prof eq 9}">생산/제조</c:if>
	  	<c:if test="${rdata.prof eq 10}">기타</c:if>
         | 
	  	<c:if test="${rdata.types eq 1}">현 직장</c:if>
	  	<c:if test="${rdata.types eq 2}">전 직장</c:if>
         | ${rdata.dates}
      </div>
      <div class="container">
        <div class="row">
          <div class="review_l col-sm-2 col-md-2">
            <div class="review_l_star">
              <c:forEach begin="1" end="${rdata.stars}"><img src="./images/stars00.jpg" alt="star" /> </c:forEach>
              <c:forEach begin="1" end="${5-rdata.stars}"><img src="./images/stars11.jpg" alt="star" /> </c:forEach>
            </div>
            <div class="review_l_list hidden-xs">
              <h5>승진 기회 및 가능성</h5>
              <ul>
              	<c:forEach begin="1" end="${rdata.stars1}"><li></li></c:forEach>
              	<c:forEach begin="1" end="${5-rdata.stars1}"><li style="background:#dddddd;"></li></c:forEach>
              </ul>
              <h5>복지 및 급여</h5>
              <ul>
              	<c:forEach begin="1" end="${rdata.stars2}"><li></li></c:forEach>
              	<c:forEach begin="1" end="${5-rdata.stars2}"><li style="background:#dddddd;"></li></c:forEach>
              </ul>
              <h5>업무와 삶의 균형</h5>
              <ul>
              	<c:forEach begin="1" end="${rdata.stars3}"><li></li></c:forEach>
              	<c:forEach begin="1" end="${5-rdata.stars3}"><li style="background:#dddddd;"></li></c:forEach>
              </ul>
              <h5>사내문화</h5>
              <ul>
              	<c:forEach begin="1" end="${rdata.stars4}"><li></li></c:forEach>
              	<c:forEach begin="1" end="${5-rdata.stars4}"><li style="background:#dddddd;"></li></c:forEach>
              </ul>
              <h5>경영진</h5>
              <ul>
              	<c:forEach begin="1" end="${rdata.stars5}"><li></li></c:forEach>
              	<c:forEach begin="1" end="${5-rdata.stars5}"><li style="background:#dddddd;"></li></c:forEach>
              </ul>
            </div>
          </div>
          <div class="review_r col-sm-6 col-md-7">
            <h3>"${rdata.memo1}"</h3>
            <h5 style="color:#0f7ccf;">장점</h5>
            <p>
              ${rdata.memo2}
            </p>
            <h5 style="color:#fc4a13;">단점</h5>
            <p>
              ${rdata.memo3}
            </p>
          </div>
        </div>
      </div>
    </div>
    </c:forEach>
    
    
      <div class="paging">
        <a href="review.o?member_no=${member_no}&pages_r=1&searchValue=${searchValue_utf}&pages=${pages}&search=${search}&searchType=${searchType}&searchSort=${searchSort}&pages_rc=${pages_rc}" style="color:#d0d0d0;" class="paging_radius_l">&lt;</a>
        <c:forEach begin="${paging.pstarts}" end="${paging.pends}" step="1" var="i">
        	<a href="review.o?member_no=${member_no}&pages_r=${i}&searchValue=${searchValue_utf}&pages=${pages}&search=${search}&searchType=${searchType}&searchSort=${searchSort}&pages_rc=${pages_rc}"
        		<c:if test="${i ne pages}"> class="paging_a"</c:if> <c:if test="${i eq pages}"> class="paging_a_hover"</c:if>>
        		${i}
        	</a>
        </c:forEach>
        <a href="review.o?member_no=${member_no}&pages_r=${paging.board_paging}&searchValue=${searchValue_utf}&pages=${pages}&search=${search}&searchType=${searchType}&searchSort=${searchSort}&pages_rc=${pages_rc}" style="color:#d0d0d0;" class="paging_radius_r">&gt;</a>
      </div>
    
     --%>
    
    
    
    
    
    
    
    
<!--     </div>
    <div class="col-sm-1"></div>
  </div>
</div> -->