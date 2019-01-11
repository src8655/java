<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="write_hide" id="review_write" style="display:none;">
<div class="write_hide_scroll">
    <form action="interview_write_post.o" method="post" onsubmit="return interview_write_submit(this);">
    <input type="hidden" name="pages_rc" value="${pages_rc}" />
    <input type="hidden" name="pages" value="${pages}" />
    <input type="hidden" name="member_no" value="${member_no}" />
    <input type="hidden" name="searchValue" value="${searchValue_utf}" />
    <input type="hidden" name="search" value="${search}" />
    <input type="hidden" name="searchType" value="${searchType}" />
    <input type="hidden" name="searchSort" value="${searchSort}" />
    <div class="write_hide_scroll2">
    <div class="review_write_box">
      <h1>면접후기 작성</h1>
      <div class="review_write_box_line">
	      <div>
	    	직종<br />
	    	<span>(선택)</span>
	      </div>
	      <p>
	        <select name="prof" class="join_select" onchange="itw_prof_check(this);">
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
  			<span id="itw_prof_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	직급<br />
	    	<span>(선택)</span>
	      </div>
	      <p>
	        <select name="positions" class="join_select" onchange="itw_positions_check(this);">
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
  			<span id="itw_positions_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	면접난이도<br />
	    	<span>(선택)</span>
	      </div>
	      <p>
	      	<ul class="interview_write_bar">
			  <li class="interview_bk_0" id="itw_difficulty_1"><a href="#100" onclick="itw_difficulty_btn(1,'itw_difficulty_','itw_difficulty','itw_difficulty_msg');"></a></li>
			  <li class="interview_bk_0" id="itw_difficulty_2"><a href="#100" onclick="itw_difficulty_btn(2,'itw_difficulty_','itw_difficulty','itw_difficulty_msg');"></a></li>
			  <li class="interview_bk_0" id="itw_difficulty_3"><a href="#100" onclick="itw_difficulty_btn(3,'itw_difficulty_','itw_difficulty','itw_difficulty_msg');"></a></li>
			  <li class="interview_bk_0" id="itw_difficulty_4"><a href="#100" onclick="itw_difficulty_btn(4,'itw_difficulty_','itw_difficulty','itw_difficulty_msg');"></a></li>
			  <li class="interview_bk_0" id="itw_difficulty_5"><a href="#100" onclick="itw_difficulty_btn(5,'itw_difficulty_','itw_difficulty','itw_difficulty_msg');"></a></li>
		    </ul>
		    <input type="hidden" name="difficulty" id="itw_difficulty" value="-1" onchange="itw_difficulty_check(this);" />
  			<span id="itw_difficulty_msg">선택해주세요.</span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	면접일자<br />
	    	<span>(0000-00)</span>
	      </div>
	      <p>
	        <input type="text" name="interviewdate" placeholder="면접일자(0000-00)" class="login_input" onchange="itw_interviewdate_check(this);" />
  			<span id="itw_interviewdate_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	면접경로<br />
	    	<span>(선택)</span>
	      </div>
	      <p>
	        <select name="interviewdir" class="join_select" onchange="itw_interviewdir_check(this);">
	  			<option value="-1">선택</option>
	  			<option value="1">온라인 지원</option>
	  			<option value="2">직원추천</option>
	  			<option value="3">헤드헌터</option>
	  			<option value="4">공개채용</option>
	  			<option value="5">학교 취업지원 센터</option>
	  			<option value="6">기타</option>
  			</select>
  			<span id="itw_interviewdir_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	면접에서 채용까지의 과정 요약
	      </div>
	      <p>
	        <textarea rows="100" cols="100" class="edit_textarea" name="memo1" onchange="itw_memo1_check(this);" placeholder="최대한 자세하게 작성해주세요. 최초 연락부터 인터뷰 횟수, 분위기, 면접관의 특징, 면접 팁 등"></textarea>
	      	<span id="itw_memo1_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	면접질문 입력하기
	      </div>
	      <p>
	        <textarea rows="100" cols="100" class="edit_textarea" name="memo2" onchange="itw_memo2_check(this);" placeholder="조별 주제, 개별 과제, 대면 질문 등 가장 어려웠던 질문을 정확하고 구체적으로 작성해 주세요."></textarea>
	      	<span id="itw_memo2_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	작성한 면접질문에 대한 답변을 입력하세요.
	      </div>
	      <p>
	        <textarea rows="100" cols="100" class="edit_textarea" name="memo3" onchange="itw_memo3_check(this);" placeholder="작성한 면접질문에 대한 답변을 입력하세요."></textarea>
	      	<span id="itw_memo3_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	채용방식
	      </div>
	      <p>
	        <input type="text" name="memo4" placeholder="예) 필기시험, 논술 시험, PT면접, 그룹면접, 토론면접, 개인면접, 산행, 체육대회" class="login_input" onchange="itw_memo4_check(this);" />
  			<span id="itw_memo4_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	발표시기
	      </div>
	      <p>
	        <input type="text" name="memo5" placeholder="예) 10일 후, 일주일 후" class="login_input" onchange="itw_memo5_check(this);" />
  			<span id="itw_memo5_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	이 기업에 합격하셨나요?<br />
	    	<span>(선택)</span>
	      </div>
	      <p>
	        <select name="interviewresult" class="join_select" onchange="itw_interviewresult_check(this);">
	  			<option value="-1">선택</option>
	  			<option value="1">합격</option>
	  			<option value="2">불합격</option>
	  			<option value="3">대기중</option>
  			</select>
  			<span id="itw_interviewresult_msg"></span>
	      </p>
      </div>
      <div class="review_write_box_line">
	      <div>
	    	면접경험<br />
	    	<span>(선택)</span>
	      </div>
	      <p>
	        <select name="interviewex" class="join_select" onchange="itw_interviewex_check(this);">
	  			<option value="-1">선택</option>
	  			<option value="1">긍정적</option>
	  			<option value="2">보통</option>
	  			<option value="3">부정적</option>
  			</select>
  			<span id="itw_interviewex_msg"></span>
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
    <div class="col-sm-1"></div>
    <div class="col-sm-10">
    
    
    <c:if test="${memberInfo eq null}">
    <div class="review_write">
    	<a href="login.o">새로운 면접후기 작성하기</a>
    </div>
    </c:if>
    <c:if test="${memberInfo ne null}">
    <c:if test="${memberInfo.orders eq 1}">
    <div class="review_write">
    	<a href="#100" onclick="show2('review_write');document.body.style.overflow = 'hidden';">새로운 면접후기 작성하기</a>
    </div>
    </c:if>
    </c:if>
    
    
    
    <div class="income_header" style="margin-bottom:0px;border-bottom:1px solid #e6e6e6;">
      <div class="income_header_l">
        <h5>면접 난이도</h5>
        <div class="interview_bar_bg">
          <h1>${difficulty}</h1>
          <span>${difficultys}</span>
          <div class="interview_bar">
            <div class="income_bar_l" style="color:#0f7ccf;">쉬움</div>
            <div class="income_bar_r" style="color:#fd4a12;">어려움</div>
            <div class="income_bar_bg1" style="overflow:hidden;"><div class="income_bar_bg2"><div class="income_bar_bg3">
              <div class="income_bar" style="width:${difficultybar}%;"><div></div></div>
            </div></div></div>
            <div class="income_bar_l" style="color:#0f7ccf;">0</div>
            <div class="income_bar_r" style="color:#fd4a12;">5</div>
          </div>
        </div>
      </div>
      <div class="income_header_r">
        <h5>면접경로</h5>
        <div class="interview_table">
          <table cellspacing="0" cellpadding="0">
            <tr>
              <th>온라인 지원</th>
              <td>${dirs1}%</td>
              <th>직원추천</th>
              <td>${dirs2}%</td>
            </tr>
            <tr>
              <th>헤드헌터</th>
              <td>${dirs3}%</td>
              <th>공개채용</th>
              <td>${dirs4}%</td>
            </tr>
            <tr>
              <th>학교 취업지원 센터</th>
              <td>${dirs5}%</td>
              <th>기타</th>
              <td>${dirs6}%</td>
            </tr>
          </table>
        </div>
      </div>
    </div>
    <div class="income_header" style="margin-top:0px;">
      <div class="income_header_l">
        <h5>면접경험</h5>
        <div class="chart_div">
          <div id="piechart_1" class="piechart"></div>
          <script type="text/javascript">
            google.charts.load('current', {'packages':['corechart']});
            google.charts.setOnLoadCallback(drawPieChart_1);
            function drawPieChart_1() {
                var piedata_1 = google.visualization.arrayToDataTable([
                    ['', ''],
                    ['긍정적',     datas1],
                    ['부정적',    datas2],
                    ['보통', datas3]
                  ]);
      
              var options = {
                title: '',
                chartArea:{left:0,top:0,width:'100%',height:100},
                legend:{position: 'right', textStyle: {color: '#666666', fontSize: 14}},
                slices: {
                  0: { color: '#00bfd9' },
                  1: { color: '#e03a36' },
                  2: { color: '#78c700' }
                }
              };
      
              var piechart_1 = new google.visualization.PieChart(document.getElementById('piechart_1'));
      
              piechart_1.draw(piedata_1, options);
            }
          </script>
        </div>
      </div>
      <div class="income_header_r">
        <h5>면접결과</h5>
        <div class="chart_div">
          <div id="piechart_2" class="piechart"></div>
          <script type="text/javascript">
            google.charts.load('current', {'packages':['corechart']});
            google.charts.setOnLoadCallback(drawPieChart_2);
      
            function drawPieChart_2() {
      
              var piedata_2 = google.visualization.arrayToDataTable([
                ['', ''],
                ['합격',     datas_r1],
                ['불합격',    datas_r2],
                ['대기중', datas_r3]
              ]);
      
              var options = {
                title: '',
                chartArea:{left:0,top:0,width:'100%',height:100},
                legend:{position: 'right', textStyle: {color: '#666666', fontSize: 14}},
                slices: {
                  0: { color: '#00bfd9' },
                  1: { color: '#e03a36' },
                  2: { color: '#78c700' }
                }
              };
      
              var piechart_2 = new google.visualization.PieChart(document.getElementById('piechart_2'));
      
              piechart_2.draw(piedata_2, options);
            }
          </script>
        </div>
      </div>
    </div>
    
    
    
    
    
    
    
    <c:forEach items="${list}" var="itdata">
    <div class="contents">
      <div class="review_header">
        <c:if test="${itdata.prof eq 1}">IT/인터넷</c:if>
		<c:if test="${itdata.prof eq 2}">경영/기획/컨설팅</c:if>
		<c:if test="${itdata.prof eq 3}">교육</c:if>
		<c:if test="${itdata.prof eq 4}">금융/재무</c:if>
		<c:if test="${itdata.prof eq 5}">디자인</c:if>
		<c:if test="${itdata.prof eq 6}">마케팅/시장조사</c:if>
		<c:if test="${itdata.prof eq 7}">미디어/홍보</c:if>
		<c:if test="${itdata.prof eq 8}">법률/법무</c:if>
		<c:if test="${itdata.prof eq 9}">생산/제조</c:if>
		<c:if test="${itdata.prof eq 10}">기타</c:if>
         / 
		<c:if test="${itdata.positions eq 1}">사원-대졸</c:if>
		<c:if test="${itdata.positions eq 2}">사원-전문대졸</c:if>
		<c:if test="${itdata.positions eq 3}">사원-고졸</c:if>
		<c:if test="${itdata.positions eq 4}">주임/계장</c:if>
		<c:if test="${itdata.positions eq 5}">대리</c:if>
		<c:if test="${itdata.positions eq 6}">과장</c:if>
		<c:if test="${itdata.positions eq 7}">차장</c:if>
		<c:if test="${itdata.positions eq 8}">부장</c:if>
		<c:if test="${itdata.positions eq 9}">이사</c:if>
		<c:if test="${itdata.positions eq 10}">기타</c:if>
        | 
        ${itdata.dates}
      </div>
      <div class="container">
        <div class="row">
          <div class="interview_l col-sm-2 col-md-2">
            <div class="interview_l_list">
              <div>
                <h5>면접난이도</h5>
                <h6>보통</h6>
                <ul>
                  <c:forEach begin="1" end="${itdata.difficulty}" step="1"><li class="interview_bk_1"></li></c:forEach>
                  <c:forEach begin="1" end="${5-itdata.difficulty}" step="1"><li class="interview_bk_0"></li></c:forEach>
                </ul>
              </div>
              <div class="hidden-xs" style="margin-top:20px;"></div>
              <div>
                <h5>면접일자</h5>
                <h6>${itdata.interviewdate}</h6>
              </div>
              <div class="hidden-xs" style="margin-top:20px;"></div>
              <div>
                <h5>면접경로</h5>
                <h6>
                	<c:if test="${itdata.interviewdir eq 1}">온라인 지원</c:if>
					<c:if test="${itdata.interviewdir eq 2}">직원추천</c:if>
					<c:if test="${itdata.interviewdir eq 3}">헤드헌터</c:if>
					<c:if test="${itdata.interviewdir eq 4}">공개채용</c:if>
					<c:if test="${itdata.interviewdir eq 5}">학교 취업지원 센터</c:if>
					<c:if test="${itdata.interviewdir eq 6}">기타</c:if>
                </h6>
              </div>
            </div>
          </div>
          <div class="review_r col-sm-6 col-md-7">
            <h3>"${itdata.memo1}"</h3>
            <h5>면접질문</h5>
            <p>${itdata.memo2}</p>
            <h5>면접답변</h5>
            <p>${itdata.memo3}</p>
            <h5>채용방식</h5>
            <p>${itdata.memo4}</p>
            <h5>발표시기</h5>
            <p>${itdata.memo5}</p>
            <table cellspacing="0" cellpadding="0" class="interview_b_table">
              <tr>
                <th>면접결과</th>
                <td>
	                <c:if test="${itdata.interviewresult eq 1}"><img src="./images/interview_l_1.jpg" alt="img" /> 합격</c:if>
					<c:if test="${itdata.interviewresult eq 2}"><img src="./images/interview_l_2.jpg" alt="img" /> 불합격</c:if>
					<c:if test="${itdata.interviewresult eq 3}"><img src="./images/interview_l_3.jpg" alt="img" /> 대기중</c:if>
                </td>
                <th>면접경험</th>
                <td>
	                <c:if test="${itdata.interviewex eq 1}"><img src="./images/interview_r_1.jpg" alt="img" /> 긍정적</c:if>
					<c:if test="${itdata.interviewex eq 2}"><img src="./images/interview_r_3.jpg" alt="img" /> 보통</c:if>
					<c:if test="${itdata.interviewex eq 3}"><img src="./images/interview_r_2.jpg" alt="img" /> 부정적</c:if>
                </td>
              </tr>
            </table>
          </div>
        </div>
      </div>
    </div>
    </c:forEach>
    
    
    
    
      <div class="paging">
        <a href="interview.o?member_no=${member_no}&pages_r=1&searchValue=${searchValue_utf}&pages=${pages}&search=${search}&searchType=${searchType}&searchSort=${searchSort}&pages_rc=${pages_rc}" style="color:#d0d0d0;" class="paging_radius_l">&lt;</a>
        <c:forEach begin="${paging.pstarts}" end="${paging.pends}" step="1" var="i">
        	<a href="interview.o?member_no=${member_no}&pages_r=${i}&searchValue=${searchValue_utf}&pages=${pages}&search=${search}&searchType=${searchType}&searchSort=${searchSort}&pages_rc=${pages_rc}"
        		<c:if test="${i ne pages}"> class="paging_a"</c:if> <c:if test="${i eq pages}"> class="paging_a_hover"</c:if>>
        		${i}
        	</a>
        </c:forEach>
        <a href="interview.o?member_no=${member_no}&pages_r=${paging.board_paging}&searchValue=${searchValue_utf}&pages=${pages}&search=${search}&searchType=${searchType}&searchSort=${searchSort}&pages_rc=${pages_rc}" style="color:#d0d0d0;" class="paging_radius_r">&gt;</a>
      </div>
    
    
    
    
    
    
    
    
    
    
    </div>
    <div class="col-sm-1"></div>
  </div>
</div>