<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${memberInfo.no eq member_no}">
<!-- 수정 -->
<div class="write_hide" id="recruit_edit" style="display:none;">
<div class="write_hide_scroll">
    <form action="recruit_edit_post.o" method="post" onsubmit="return recruit_edit_submit(this);">
    <input type="hidden" name="pages_rc" value="${pages_rc}" />
    <input type="hidden" name="pages" value="${pages}" />
    <input type="hidden" name="member_no" value="${member_no}" />
    <input type="hidden" name="searchValue" value="${searchValue_utf}" />
    <input type="hidden" name="search" value="${search}" />
    <input type="hidden" name="searchType" value="${searchType}" />
    <input type="hidden" name="searchSort" value="${searchSort}" />
    <input type="hidden" name="recruit_no" value="${recruit_no}" />
    <div class="write_hide_scroll2">
    <div class="review_write_box">
      <h1>채용정보 수정</h1>
      <div class="review_write_box_line">
	      <div>
	    	채용 제목
	      </div>
	      <p>
	        <input type="text" name="subject" placeholder="채용 제목" class="login_input" onchange="rc2_subject_check(this);" value="${rcdata.subject}" />
      		<span id="rc2_subject_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	마감일<br />
	    	<span>날짜입력</span>
	      </div>
	      <p>
	        <input type="text" name="enddates" placeholder="예) 2000-00-00" class="login_input" onchange="rc2_enddates_check(this);" value="${rcdata.enddates}" />
      		<span id="rc2_enddates_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	키워드<br />
	    	<span>쉼표(,)로 구분</span>
	      </div>
	      <p>
	        <input type="text" name="keyword" placeholder="예) SW엔지니어,웹개발,서울,정규직" class="login_input" onchange="rc2_keyword_check(this);" value="${rcdata.keyword}" />
      		<span id="rc2_keyword_msg"></span>
	      </p>
      </div>
      
      
      <div class="review_write_box_line">
	      <div>
	    	기업소개
	      </div>
	      <p>
	        <textarea rows="100" cols="100" class="edit_textarea" name="memo1" id="memo1" onchange="rc2_memo1_check(this);" style="height:300px;" placeholder="예) 코인 전문 암호화폐 거래소 00000 입니다. ">${rcdata.memo1}</textarea>
	      	<span id="rc2_memo1_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	주요업무
	      </div>
	      <p>
	        <textarea rows="100" cols="100" class="edit_textarea" name="memo2" onchange="rc2_memo2_check(this);" style="height:300px;" placeholder="예) 백엔드개발. ">${rcdata.memo2}</textarea>
	      	<span id="rc2_memo2_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	자격요건
	      </div>
	      <p>
	        <textarea rows="100" cols="100" class="edit_textarea" name="memo3" onchange="rc2_memo3_check(this);" style="height:300px;" placeholder="핵심 직무 역량과 우대 사항 입력 ">${rcdata.memo3}</textarea>
	      	<span id="rc2_memo3_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	채용절차
	      </div>
	      <p>
	        <textarea rows="100" cols="100" class="edit_textarea" name="memo4" onchange="rc2_memo4_check(this);" style="height:300px;" placeholder="예) 서류전형 - 임원면접 - 합격통보 ">${rcdata.memo4}</textarea>
	      	<span id="rc2_memo4_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	복리후생
	      </div>
	      <p>
	        <textarea rows="100" cols="100" class="edit_textarea" name="memo5" onchange="rc2_memo5_check(this);" style="height:300px;" placeholder="혜택 및 복지 ">${rcdata.memo5}</textarea>
	      	<span id="rc2_memo5_msg"></span>
	      </p>
      </div>
      
      
      
      
      <div class="review_write_box_line">
	      <div>
	    	문의처<br />
	    	<span>쉼표(,)로 구분</span>
	      </div>
	      <p>
	        <input type="text" name="contact" placeholder="예) 00000@naver.com,02-000-0000,http://naver.com/" class="login_input" onchange="rc2_contact_check(this);" value="${rcdata.contact}" />
      		<span id="rc2_contact_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	직종
	      </div>
	      <p>
	        <input type="text" name="prof" placeholder="예) SW엔지니어,시스템엔지니어,웹개발" class="login_input" onchange="rc2_prof_check(this);" value="${rcdata.prof}" />
      		<span id="rc2_prof_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	고용형태
	      </div>
	      <p>
	        <input type="text" name="empl" placeholder="예) 정규직" class="login_input" onchange="rc2_empl_check(this);" value="${rcdata.empl}" />
      		<span id="rc2_empl_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	최종 학력
	      </div>
	      <p>
	        <input type="text" name="grade" placeholder="예) 해당없음 고졸이상 대졸이상" class="login_input" onchange="rc2_grade_check(this);" value="${rcdata.grade}" />
      		<span id="rc2_grade_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	급여
	      </div>
	      <p>
	        <input type="text" name="money" placeholder="예) 연봉(최소 3,000만원 ~ 최대 5,000만원)" class="login_input" onchange="rc2_money_check(this);" value="${rcdata.money}" />
      		<span id="rc2_money_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	직급
	      </div>
	      <p>
	        <input type="text" name="positions1" placeholder="예) 사원 주임 대리" class="login_input" onchange="rc2_positions1_check(this);" value="${rcdata.positions1}" />
      		<span id="rc2_positions1_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	직책
	      </div>
	      <p>
	        <input type="text" name="positions2" placeholder="예) 팀장 실장 팀장급" class="login_input" onchange="rc2_positions2_check(this);" value="${rcdata.positions2}" />
      		<span id="rc2_positions2_msg"></span>
	      </p>
      </div>
      
      <div class="review_write_box_line align-center">
	      <input type="button" value="닫기" onclick="hide2('recruit_edit');document.body.style.overflow = 'scroll';" class="review_write_btn2" />
	      <input type="submit" value="수정하기" class="review_write_btn1" />
      </div>
    </div>
    </div>
    </form>
</div>
</div>


</c:if>











<!-- 입사지원 -->
<div class="write_hide" id="recruit_add" style="display:none;">
<div class="write_hide_scroll">
    <form action="recruit_add_post.o" method="post" id="rc_f" enctype="multipart/form-data" onsubmit="return recruit_add_submit(this);">
    <input type="hidden" name="pages" value="${pages}" />
    <input type="hidden" name="member_no" value="${member_no}" />
    <input type="hidden" name="searchValue" value="${searchValue_utf}" />
    <input type="hidden" name="search" value="${search}" />
    <input type="hidden" name="searchType" value="${searchType}" />
    <input type="hidden" name="searchSort" value="${searchSort}" />
    <input type="hidden" name="recruit_no" value="${recruit_no}" />
    <div class="write_hide_scroll2s">
    <div class="review_write_box">
      <h1 id="rc_h">지원서 작성</h1>
      <div class="recruit_add_box_line">
	      <h4>
	    	이름
	      </h4>
	      <div class="recruit_phone">
	        <input type="text" name="name" placeholder="이름을 입력해주세요." class="login_input" onchange="rca_name_check(this);" />
	      </div>
	      <p id="rca_name_msg" class="join_msg"></p>
      </div>
      <div class="recruit_add_box_line">
	      <h4>
	    	연락처
	      </h4>
	      <div class="recruit_phone">
	        <input type="text" name="phone1" placeholder="010" class="login_input" style="padding-left:3px;width:25%;float:left;" onchange="rca_phone1_check(this);" />
	        <div>-</div>
	        <input type="text" name="phone2" placeholder="0000" class="login_input" style="padding-left:3px;width:25%;float:left;" onchange="rca_phone2_check(this);" />
	        <div>-</div>
	        <input type="text" name="phone3" placeholder="0000" class="login_input" style="padding-left:3px;width:25%;float:left;" onchange="rca_phone3_check(this);" />
	      </div>
	      <p id="rca_phone_msg" class="join_msg"></p>
      </div>
      <div class="recruit_add_box_line">
	      <h4>
	    	이메일
	      </h4>
	      <div class="recruit_phone">
	        <input type="text" name="email" placeholder="이메일을 입력해주세요." class="login_input" onchange="rca_email_check(this);" />
	      </div>
	      <p id="rca_email_msg" class="join_msg"></p>
      </div>
      <div class="recruit_add_box_line">
	      <h4>
	    	이력서
	      </h4>
	      <div class="recruit_phone">
	      	<input type="button" value="이력서 첨부하기" class="login_input" id="files1_btn" onclick="open_file2('files1');" />
	        <input type="file" name="files1" id="files1" class="login_input" onchange="change_file2('files1_btn',this);rca_files1_check(this);" style="display:none;" />
	      </div>
	      <p id="rca_files1_msg" class="join_msg"></p>
      </div>
      <div class="recruit_add_box_line">
	      <h4>
	    	첨부파일
	      </h4>
	      <div class="recruit_phone">
	      	<input type="button" value="자격증사본,증명서 등 첨부하기" class="login_input" id="files2_btn" onclick="open_file2('files2');" />
	        <input type="file" name="files2" id="files2" class="login_input" onchange="change_file2('files2_btn',this);" style="display:none;" />
	      </div>
      </div>
      
      <div class="review_write_box_line align-center">
	      <input type="button" value="닫기" onclick="hide2('recruit_add');document.body.style.overflow = 'scroll';" class="review_write_btn2" />
	      <input type="submit" value="지원하기" class="review_write_btn1" />
      </div>
    </div>
    </div>
    </form> 
</div>
</div>






















<div class="container">
  <div class="row">
    <div class="col-sm-1 col-md-2 col-lg-2"></div>
    <div class="col-sm-10 col-md-8 col-lg-8">
    

    
    <c:if test="${memberInfo eq null}">
    <div class="review_write">
    	<a href="login.o" style="background:#219bf0;border:1px solid #219bf0;">지원하기</a>
    </div>
    </c:if>
    
    <c:if test="${memberInfo ne null}">
    <c:if test="${memberInfo.orders eq 1}">
    <div class="review_write">
    	<a href="#100" onclick="show2('recruit_add');document.body.style.overflow = 'hidden';" style="background:#219bf0;border:1px solid #219bf0;">지원하기</a>
    </div>
    </c:if>
    </c:if>
    
    <div class="recruit_subject">
    	<div class="recruit_dates">
    		<span>D-${rcdata.dday}</span> ${rcdata.dates} ~ ${rcdata.enddates}
    		&nbsp;&nbsp;
    		<div>${rcdata.dates} 등록</div>
    		<c:if test="${memberInfo.no eq member_no}">
	    		<a href="#100" onclick="show2('recruit_edit');document.body.style.overflow = 'hidden';" class="recruit_a">수정</a>
	    		<a href="#100" onclick="dialog('정말로 삭제하시겠습니까?','recruit_del.o?member_no=${member_no}&recruit_no=${rcdata.no}&searchValue=${searchValue_utf}&pages=${pages}&search=${search}&searchType=${searchType}&searchSort=${searchSort}');" class="recruit_a">삭제</a>
	    	</c:if>
    	</div>
    	<h2>${rcdata.subject}</h2>
    </div>
    <div class="recruit_keyword">
    	<c:forEach items="${keyword}" var="kw">
    	<div>${kw}</div>
    	</c:forEach>
    </div>
    
    <div class="recruit_body">
    	
    	<h3>기업 소개</h3>
    		<p>${memo1}</p>
    	<h3>주요 업무</h3>
    		<p>${memo2}</p>
    	<h3>자격 요건</h3>
    		<p>${memo3}</p>
    	<h3>채용절차</h3>
    		<p>${memo4}</p>
    	<h3>복리후생</h3>
    		<p>${memo5}</p>
    	<h3>문의처</h3>
    		<div class="recruit_contact">
		    	<c:forEach items="${contact}" var="ct">
		    	<div>${ct}</div>
		    	</c:forEach>
    		</div>
    	<h3>상세정보</h3>
    	<table cellspacing="0" cellpadding="0" class="recruit_table">
    	  <col width="50%" />
    	  <col width="50%" />
          <tr>
            <th>직종</th>
            <th>고용형태</th>
          </tr>
          	<td>${rcdata.prof}</td>
          	<td>${rcdata.empl}</td>
          <tr>
            <th>최종 학력</th>
            <th>급여</th>
          </tr>
          <tr>
          	<td>${rcdata.grade}</td>
          	<td>${rcdata.money}</td>
          </tr>
          <tr>
            <th>직급</th>
            <th>직책</th>
          </tr>
          <tr>
          	<td>${rcdata.positions1}</td>
          	<td>${rcdata.positions2}</td>
          </tr>
        </table>
    </div>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    </div>
    <div class="col-sm-1 col-md-2 col-lg-2"></div>
  </div>
</div>