<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${memberInfo.no eq member_no}">
<div class="write_hide" id="recruit_write" style="display:none;">
<div class="write_hide_scroll">
    <form action="recruit_write_post.o" method="post" id="rc_f" onsubmit="return recruit_write_submit(this);">
    <input type="hidden" name="pages_rc" value="${pages_rc}" />
    <input type="hidden" name="pages" value="${pages}" />
    <input type="hidden" name="member_no" value="${member_no}" />
    <input type="hidden" name="searchValue" value="${searchValue_utf}" />
    <input type="hidden" name="search" value="${search}" />
    <input type="hidden" name="searchType" value="${searchType}" />
    <input type="hidden" name="searchSort" value="${searchSort}" />
    <div class="write_hide_scroll2">
    <div class="review_write_box">
      <h1 id="rc_h">채용정보 작성</h1>
      <div class="review_write_box_line">
	      <div>
	    	채용 제목
	      </div>
	      <p>
	        <input type="text" name="subject" placeholder="채용 제목" class="login_input" onchange="rc_subject_check(this);" />
      		<span id="rc_subject_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	마감일<br />
	    	<span>날짜입력</span>
	      </div>
	      <p>
	        <input type="text" name="enddates" placeholder="예) 2000-00-00" class="login_input" onchange="rc_enddates_check(this);" />
      		<span id="rc_enddates_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	키워드<br />
	    	<span>쉼표(,)로 구분</span>
	      </div>
	      <p>
	        <input type="text" name="keyword" placeholder="예) SW엔지니어,웹개발,서울,정규직" class="login_input" onchange="rc_keyword_check(this);" />
      		<span id="rc_keyword_msg"></span>
	      </p>
      </div>
      
      
      <div class="review_write_box_line">
	      <div>
	    	기업소개
	      </div>
	      <p>
	        <textarea rows="100" cols="100" class="edit_textarea" name="memo1" id="memo1" onchange="rc_memo1_check(this);" style="height:300px;" placeholder="예) 코인 전문 암호화폐 거래소 00000 입니다. "></textarea>
	      	<span id="rc_memo1_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	주요업무
	      </div>
	      <p>
	        <textarea rows="100" cols="100" class="edit_textarea" name="memo2" onchange="rc_memo2_check(this);" style="height:300px;" placeholder="예) 백엔드개발. "></textarea>
	      	<span id="rc_memo2_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	자격요건
	      </div>
	      <p>
	        <textarea rows="100" cols="100" class="edit_textarea" name="memo3" onchange="rc_memo3_check(this);" style="height:300px;" placeholder="핵심 직무 역량과 우대 사항 입력 "></textarea>
	      	<span id="rc_memo3_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	채용절차
	      </div>
	      <p>
	        <textarea rows="100" cols="100" class="edit_textarea" name="memo4" onchange="rc_memo4_check(this);" style="height:300px;" placeholder="예) 서류전형 - 임원면접 - 합격통보 "></textarea>
	      	<span id="rc_memo4_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	복리후생
	      </div>
	      <p>
	        <textarea rows="100" cols="100" class="edit_textarea" name="memo5" onchange="rc_memo5_check(this);" style="height:300px;" placeholder="혜택 및 복지 "></textarea>
	      	<span id="rc_memo5_msg"></span>
	      </p>
      </div>
      
      
      
      
      <div class="review_write_box_line">
	      <div>
	    	문의처<br />
	    	<span>쉼표(,)로 구분</span>
	      </div>
	      <p>
	        <input type="text" name="contact" placeholder="예) 00000@naver.com,02-000-0000,http://naver.com/" class="login_input" onchange="rc_contact_check(this);" />
      		<span id="rc_contact_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	직종
	      </div>
	      <p>
	        <input type="text" name="prof" placeholder="예) SW엔지니어,시스템엔지니어,웹개발" class="login_input" onchange="rc_prof_check(this);" />
      		<span id="rc_prof_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	고용형태
	      </div>
	      <p>
	        <input type="text" name="empl" placeholder="예) 정규직" class="login_input" onchange="rc_empl_check(this);" />
      		<span id="rc_empl_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	최종 학력
	      </div>
	      <p>
	        <input type="text" name="grade" placeholder="예) 해당없음 고졸이상 대졸이상" class="login_input" onchange="rc_grade_check(this);" />
      		<span id="rc_grade_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	급여
	      </div>
	      <p>
	        <input type="text" name="money" placeholder="예) 연봉(최소 3,000만원 ~ 최대 5,000만원)" class="login_input" onchange="rc_money_check(this);" />
      		<span id="rc_money_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	직급
	      </div>
	      <p>
	        <input type="text" name="positions1" placeholder="예) 사원 주임 대리" class="login_input" onchange="rc_positions1_check(this);" />
      		<span id="rc_positions1_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	직책
	      </div>
	      <p>
	        <input type="text" name="positions2" placeholder="예) 팀장 실장 팀장급" class="login_input" onchange="rc_positions2_check(this);" />
      		<span id="rc_positions2_msg"></span>
	      </p>
      </div>
      
      <div class="review_write_box_line align-center">
	      <input type="button" value="닫기" onclick="hide2('recruit_write');document.body.style.overflow = 'scroll';" class="review_write_btn2" />
	      <input type="submit" value="제출하기" class="review_write_btn1" />
      </div>
    </div>
    </div>
    </form> 
</div>
</div>
</c:if>















<div class="container">
  <div class="row">
    <div class="col-sm-1 col-md-2 col-lg-2"></div>
    <div class="col-sm-10 col-md-8 col-lg-8">
    

    
    
    
    
    <c:if test="${memberInfo ne null}">
    <c:if test="${memberInfo.no eq member_no}">
    <div class="review_write">
    	<a href="#100" onclick="show2('recruit_write');document.body.style.overflow = 'hidden';">새로운 채용정보 작성하기</a>
    </div>
    </c:if>
    </c:if>
    
    
    <div class="recruit_list">
    	<ul>
    		<c:forEach items="${list}" var="rcdatas">
    		<li>
    			<a href="recruit_view.o?member_no=${member_no}&pages=${pages}&searchValue=${searchValue_utf}&search=${search}&searchType=${searchType}&searchSort=${searchSort}&pages_rc=${pages_rc}&pages_r=${pages_r}&recruit_no=${rcdatas.no}">
    				<div class="recruit_list_dday">D-${rcdatas.dday}</div>
    				<h4>${rcdatas.subject}</h4>
    				<p>${rcdatas.prof}</p>
    				<div class="recruit_list_keywords">
    					<c:forEach items="${rcdatas.keywords}" var="kw">
    						<div>${kw}</div>
    					</c:forEach>
    				</div>
    			</a>
    		</li>
    		</c:forEach>
    	</ul>
    </div>
      <div class="paging">
        <a href="recruit.o?pages_r=1&searchValue=${searchValue_utf}&search=${search}&searchType=${searchType}&searchSort=${searchSort}&pages_rc=${pages_rc}&pages=${pages}" style="color:#d0d0d0;" class="paging_radius_l">&lt;</a>
        <c:forEach begin="${paging.pstarts}" end="${paging.pends}" step="1" var="i">
        	<a href="recruit.o?pages_r=${i}&searchValue=${searchValue_utf}&search=${search}&searchType=${searchType}&searchSort=${searchSort}&pages_rc=${pages_rc}&pages=${pages}"
        		<c:if test="${i ne pages}"> class="paging_a"</c:if> <c:if test="${i eq pages}"> class="paging_a_hover"</c:if>>
        		${i}
        	</a>
        </c:forEach>
        <a href="recruit.o?pages_r=${paging.board_paging}&searchValue=${searchValue_utf}&search=${search}&searchType=${searchType}&searchSort=${searchSort}&pages_rc=${pages_rc}&pages=${pages}" style="color:#d0d0d0;" class="paging_radius_r">&gt;</a>
      </div>


    </div>
    <div class="col-sm-1 col-md-2 col-lg-2"></div>
  </div>
</div>



