<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="ajax_header_bg">

<c:if test="${cdata.file2 eq ''}"><div class="main_subject_bg" style="background:url(./images/office_bk.jpg) no-repeat center center;"></c:if>
<c:if test="${cdata.file2 ne ''}"><div class="main_subject_bg" style="background:url(./upload/${cdata.file2}) no-repeat center center"></c:if>
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
            
            <c:if test="${memberInfo eq null}">
            	<a href="#100" onclick="follow_ajax(${member_no},'follow_heart');" class="follow_btn">
            		<img src="./images/heart.jpg" alt="heart" id="follow_heart" />
            		<p>팔로우</p>
            	</a>
            </c:if>
            <c:if test="${memberInfo ne null}">
            	<a href="#100" onclick="follow_ajax(${member_no},'follow_heart');" class="follow_btn">
            		<c:if test="${cdata.isfollow eq -1}"><img src="./images/heart.jpg" alt="heart" id="follow_heart" /></c:if>
            		<c:if test="${cdata.isfollow eq 1}"><img src="./images/heart2.jpg" alt="heart" id="follow_heart" /></c:if>
            		<p>팔로우</p>
            	</a>
            </c:if>
            
            <img src="./images/star.png" alt="star" /> ${cdata.avg_stars}
            <br />
            <a href="${cdata.url}" class="url_btn">${cdata.url}</a>
          </p>
        </div>
        <div class="col-sm-3 cover_img_align">
        <a href="#100" class="cover_img_btn log_same"
          <c:if test="${memberInfo eq null}"> style="display:none; "</c:if>
          <c:if test="${memberInfo ne null && memberInfo.no ne cdata.member_no}"> style="display:none;" </c:if>
           onclick="show2('view_edit_bg');document.body.style.overflow = 'hidden';">
          기업정보 관리</a>
        </div>
        <div class="col-sm-1"></div>
      
      
      </div>
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
            <li><a href="#100" onclick="view_ajax(${member_no});setmenu(this);" class="nav_ul_li_a_hover" id="nav_btn1">
              <span>Info</span><br />
              기업정보
            </a></li>
            <li><a href="#100" onclick="review_ajax(1, ${member_no});setmenu(this);" class="nav_ul_li_a" id="nav_btn2">
              <span>${count2}</span><br />
              기업리뷰
            </a></li>
            <li><a href="#100" onclick="income_ajax(${member_no});setmenu(this);" class="nav_ul_li_a" id="nav_btn3">
              <span>${count3}</span><br />
              연봉정보
            </a></li>
            <li><a href="#100" onclick="interview_ajax(1, ${member_no});setmenu(this);" class="nav_ul_li_a" id="nav_btn4">
              <span>${count4}</span><br />
              면접후기
            </a></li>
            <li><a href="#100" onclick="recruit_ajax(1, ${member_no});setmenu(this);" class="nav_ul_li_a" id="nav_btn5">
              <span>${count5}</span><br />
              채용공고
            </a></li>
          </ul>
        </div>
        
        
        <div class="col-sm-1"></div>
    
    </div>
  </div>
</nav>



<div class="write_hide" id="view_edit_bg" style="display:none;">
<div class="write_hide_scroll">

	<div class="write_hide_scroll2s">
    <div class="review_write_box">
      <h1 id="rc_h">기업정보 관리</h1>
      <form id="edit_forms" action="edit_post.o" method="post" enctype="multipart/form-data" onsubmit="return edit_submit(this);">
      	<input type="hidden" name="member_no" value="${cdata.member_no}" />
      	<input type="hidden" name="pages" value="${pages}" />
      	<input type="hidden" name="searchValue" value="${searchValue_utf}" />
      	<input type="file" name="files1" id="edit_file1" style="display:none;" onchange="change_img('edit_file1_img', this);" />
      	<input type="file" name="files2" id="edit_file2" style="display:none;" onchange="change_img('edit_file2_img', this);" />
      	
      <div class="recruit_add_box_line">
      	<div class="join_quest" style="width:102px;float:left;">
          <h4>회사로고</h4>
          <a href="#100" onclick="open_file('edit_file1');">
          	<c:if test="${cdata.file1 eq ''}"><img src="./images/company_logo.jpg" width="100px" height="100px" alt="logo" id="edit_file1_img" class="edit_imgs" /></c:if>
          	<c:if test="${cdata.file1 ne ''}"><img src="./upload/${cdata.file1}" width="100px" height="100px" alt="logo" id="edit_file1_img" class="edit_imgs" /></c:if>
          </a>
        </div>
        <div class="join_quest" style="width:202px;float:left;">
          <h4>회사배경</h4>
          <a href="#100" onclick="open_file('edit_file2');">
            <c:if test="${cdata.file2 eq ''}"><img src="./images/office_bk2.jpg" width="200px" height="100px" alt="logo" id="edit_file2_img" class="edit_imgs" /></c:if>
          	<c:if test="${cdata.file2 ne ''}"><img src="./upload/${cdata.file2}" width="200px" height="100px" alt="office_bg" id="edit_file2_img" class="edit_imgs" /></c:if>
          </a>
        </div>
	  </div>
      <div class="recruit_add_box_line">
        <input type="text" name="name" placeholder="대표" value="${cdata.name}" class="login_input" onchange="name_edit_check(this);" />
        <div id="name_edit_msg" class="join_msg"></div>
        <input type="text" name="founding" placeholder="설립일 2000-00-00" value="${cdata.founding}" class="login_input" onchange="founding_edit_check(this);" />
        <div id="founding_edit_msg" class="join_msg"></div>
        <input type="text" name="count" placeholder="사원수 0,000명(2018)" value="${cdata.count}" class="login_input" onchange="count_edit_check(this);" />
        <div id="count_edit_msg" class="join_msg"></div>
        <input type="text" name="money" placeholder="매출액 0,000원(2018)" value="${cdata.money}" class="login_input" onchange="money_edit_check(this);" />
        <div id="money_edit_msg" class="join_msg"></div>
        <input type="text" name="url" placeholder="웹사이트" class="login_input" value="${cdata.url}" onchange="url_edit_check(this);" />
        <div id="url_edit_msg" class="join_msg"></div>
        <input type="text" name="addr" placeholder="본사" class="login_input" value="${cdata.addr}" onchange="addr_edit_check(this);" />
        <div id="addr_edit_msg" class="join_msg"></div>
        <div class="join_quest">
          <h4>기업형태</h4>
          <select name="company_type" class="join_select" onchange="company_type_edit_check(this);">
  			<option value="-1">선택</option>
  			<option value="1" <c:if test="${cdata.company_type eq 1}">selected</c:if>>대기업</option>
  			<option value="2" <c:if test="${cdata.company_type eq 2}">selected</c:if>>중소기업</option>
  			<option value="3" <c:if test="${cdata.company_type eq 3}">selected</c:if>>벤처기업</option>
  			</select>
        	<div id="company_type_edit_msg" class="join_msg"></div>
        </div>
        <div class="join_quest">
          <h4>기업설명</h4>
          <textarea rows="100" cols="100" class="edit_textarea" name="info">${cdata.info}</textarea>
        </div>
        
        <div class="review_write_box_line align-center">
	      <input type="button" value="닫기" onclick="hide2('view_edit_bg');document.body.style.overflow = 'scroll';" class="review_write_btn2" />
	      <input type="button" value="수정완료" class="review_write_btn1" onclick="edit_post_ajax(document.getElementById('edit_forms'),${member_no});" />
      	</div>
      </form>
	  </div>
	  
	</div>
	</div>
   

</div>
</div>


































<div id="view_contents">
    


<div class="container">
  <div class="row">
    <div class="col-sm-1"></div>
    <div class="col-sm-10">
    
    
    
    
      <div class="contents">
        
        <h3>기업정보</h3>
        <p>
          ${cdata.info}
        </p>
        <table cellspacing="0" cellpadding="0" class="info_table">
          <tr>
            <th width="10%"><div style="width:60px;overflow:hidden;">대표</div></th>
            <td width="40%">${cdata.name}</td>
            <th width="10%"><div style="width:50px;overflow:hidden;">설립일</div></th>
            <td width="40%">${cdata.founding}</td>
          </tr>
          <tr>
            <th>카테고리</th>
            <td>
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
			</td>
            <th>사원수</th>
            <td>${cdata.count}</td>
          </tr>
          <tr>
            <th>기업형태</th>
            <td>
            	<c:if test="${cdata.company_type eq 1}">대기업</c:if>
	  			<c:if test="${cdata.company_type eq 2}">중소기업</c:if>
	  			<c:if test="${cdata.company_type eq 3}">벤처기업</c:if>
            </td>
            <th>매출액</th>
            <td>${cdata.money}</td>
          </tr>
          <tr>
            <th>웹사이트</th>
            <td colspan="3">${cdata.url}</td>
          </tr>
          <tr>
            <th>본사</th>
            <td colspan="3">${cdata.addr}</td>
          </tr>
        </table>
      </div>


    </div>
    <div class="col-sm-1"></div>
  </div>
</div>

</div>


<div class="container" id="hitcount_bg" style="">
  <div class="row">
    <div class="col-sm-1"></div>
    <div class="col-sm-10">
      <div class="contents">
        <h3>기업 콘텐츠 조회수</h3>
        
        <script type="text/javascript">
          google.charts.load('current', {'packages':['bar']});
          google.charts.setOnLoadCallback(drawChart);
          function drawChart() {
            var data = google.visualization.arrayToDataTable([
              ['Month', 'HIT'],
              ['${dates5}', ${counts5}],
              ['${dates4}', ${counts4}],
              ['${dates3}', ${counts3}],
              ['${dates2}', ${counts2}],
              ['${dates1}', ${counts1}],
              ['${dates0}', ${counts0}]
            ]);
            var options = {
              chart: {
                title: '기업 콘텐츠 조회수',
                subtitle: '최근 6일간 조회수',
              },
              legend: { position: "none" },
            };
            var chart = new google.charts.Bar(document.getElementById('columnchart_material'));
            chart.draw(data, google.charts.Bar.convertOptions(options));
          }
        </script>
        <div id="columnchart_material" style="width:100%; height:500px;"></div>
      </div>
      
      
      
      
    </div>
    <div class="col-sm-1"></div>
  </div>
</div>




 <div class="container" id="interview_all" style="display:none;">
  <div class="row">
    <div class="col-sm-1"></div>
    <div class="col-sm-10">
    
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
    
    </div>
    <div class="col-sm-1"></div>
  </div>
</div>



<div id="view_contents2">

</div>