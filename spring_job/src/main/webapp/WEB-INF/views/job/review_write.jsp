<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="container">
  <div class="row">
    <div class="col-sm-1 col-md-2 col-lg-2"></div>
    <div class="col-sm-10 col-md-8 col-lg-8 align-center">
    

    
    
    <form action="review_write_post.o" method="post" onsubmit="return review_write_submit(this);">
    <input type="hidden" name="pages" value="${pages}" />
    <input type="hidden" name="member_no" value="${member_no}" />
    <input type="hidden" name="searchValue" value="${searchValue_utf}" />
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
	      <input type="button" value="뒤로가기" onclick="history.go(-1);" class="review_write_btn2" />
	      <input type="submit" value="제출하기" class="review_write_btn1" />
      </div>
    </div>
    </form>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    </div>
    <div class="col-sm-1 col-md-2 col-lg-2"></div>
  </div>
</div>