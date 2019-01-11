<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<div class="write_hide" id="review_write" style="display:none;">
<div class="write_hide_scroll">
    <form action="income_write_post.o" method="post" onsubmit="return income_write_submit(this);">
    <input type="hidden" name="pages_rc" value="${pages_rc}" />
    <input type="hidden" name="pages" value="${pages}" />
    <input type="hidden" name="member_no" value="${member_no}" />
    <input type="hidden" name="searchValue" value="${searchValue_utf}" />
    <input type="hidden" name="search" value="${search}" />
    <input type="hidden" name="searchType" value="${searchType}" />
    <input type="hidden" name="searchSort" value="${searchSort}" />
    <div class="write_hide_scroll2">
    <div class="review_write_box">
      <h1>기업연봉 작성</h1>
      <div class="review_write_box_line">
	      <div>
	    	직종<br />
	    	<span>(선택)</span>
	      </div>
	      <p>
	        <select name="prof" class="join_select" onchange="iw_prof_check(this);">
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
  			<span id="iw_prof_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	직급<br />
	    	<span>(선택)</span>
	      </div>
	      <p>
	        <select name="positions" class="join_select" onchange="iw_positions_check(this);">
	  			<option value="-1">선택</option>
	  			<option value="1">사원-대졸</option>
	  			<option value="2">사원-전문대졸</option>
	  			<option value="3">사원-고졸</option>
	  			<option value="4">주임/계장</option>
	  			<option value="5">대리</option>
	  			<option value="6">과장</option>
	  			<option value="7">차장</option>
	  			<option value="8">부장</option>
	  			<option value="9">이사</option>
	  			<option value="10">기타</option>
  			</select>
  			<span id="iw_positions_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	고용형태<br />
	    	<span>(선택)</span>
	      </div>
	      <p>
	        <select name="empl" class="join_select" onchange="iw_empl_check(this);">
	  			<option value="-1">선택</option>
	  			<option value="1">인턴직</option>
	  			<option value="2" >아르바이트</option>
	  			<option value="3" >정규직</option>
	  			<option value="4" >계약직</option>
	  			<option value="5" >프리렌서</option>
	  			<option value="6" >기타</option>
  			</select>
  			<span id="iw_empl_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	기본급여(연봉)<br />
	    	<span>(만원)</span>
	      </div>
	      <p>
	        <input type="text" name="money" placeholder="기본급여 (연봉)" class="login_input" onchange="iw_money_check(this);" />
      		<span id="iw_money_msg"></span>
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
</div>





























<div class="container">
  <div class="row">
    <div class="col-sm-1 col-md-2 col-lg-2"></div>
    <div class="col-sm-10 col-md-8 col-lg-8">
    
    <c:if test="${memberInfo eq null}">
    <div class="review_write">
    	<a href="login.o">새로운 연봉정보 작성하기</a>
    </div>
    </c:if>
    <c:if test="${memberInfo ne null}">
    <c:if test="${memberInfo.orders eq 1}">
    <div class="review_write">
    	<a href="#100" onclick="show2('review_write');document.body.style.overflow = 'hidden';">새로운 연봉정보 작성하기</a>
    </div>
    </c:if>
    </c:if>
    
    
    <div class="income_header">
      <div class="income_header_l">
        <h5>평균연봉</h5>
        <p>
          ${avgs}
          <span>만원</span>
        </p>
      </div>
      <div class="income_header_r">
        <h5>전체 순위</h5>
        <p>
          ${rank}
          <span>위</span>
        </p>
      </div>
    </div>
    
    
    
    
    
    
    
    
    <div class="contents income">
      <h2>연봉 평균 통계</h2>
      <h6>만원/단위</h6>
      <table cellspacing="0" cellpadding="0" class="income_table">
      	<c:forEach items="${list}" var="idata">
        <tr class="income_table_b_0">
          <th style="width:150px;border-top:1px solid #777777;">
	  		<c:if test="${idata.positions eq 1}">사원-대졸</c:if>
	  		<c:if test="${idata.positions eq 2}">사원-전문대졸</c:if>
	  		<c:if test="${idata.positions eq 3}">사원-고졸</c:if>
	  		<c:if test="${idata.positions eq 4}">주임/계장</c:if>
	  		<c:if test="${idata.positions eq 5}">대리</c:if>
	  		<c:if test="${idata.positions eq 6}">과장</c:if>
	  		<c:if test="${idata.positions eq 7}">차장</c:if>
	  		<c:if test="${idata.positions eq 8}">부장</c:if>
	  		<c:if test="${idata.positions eq 9}">이사</c:if>
	  		<c:if test="${idata.positions eq 10}">기타</c:if>
	  		<br />
            <span>${idata.count} 연봉정보</span>
          </th>
          <td style="border-top:1px solid #777777;">
            <div class="income_td_l col-sm-1">
              ${idata.moneys} 만원
            </div>
            <div class="col-sm-8 col-md-8 col-lg-9">
              <div class="income_bar_bg1"><div class="income_bar_bg2"><div class="income_bar_bg3">
                <div class="income_bar" style="width:${idata.barline}%;"><div></div></div>
              </div></div></div>
              <div class="income_bar_l">
                ${mins}
              </div>
              <div class="income_bar_r">
                ${maxs}
              </div>
            </div>
          </td>
        </tr>
        </c:forEach>
      </table>
    </div>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    </div>
    <div class="col-sm-1 col-md-2 col-lg-2"></div>
  </div>
</div>