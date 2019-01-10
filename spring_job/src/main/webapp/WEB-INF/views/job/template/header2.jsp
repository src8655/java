<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<div class="xs_menu" id="xs_menu_id" style="display:none;">
	<ul id="login_btn_bg2">
		<li><a href="#100" onclick="hide2('xs_menu_id');document.body.style.overflow='scroll';" style="color:#666666;font-weight:bold;padding:5px 0 5px 0;text-align:center;font-size:20px;">X</a></li>
        <c:if test="${memberInfo eq null}">
		<li><a href="#100" onclick="show2('login_float_bg');document.body.style.overflow = 'hidden';hide2('xs_menu_id');">로그인</a></li>
		<li><a href="#100" onclick="show2('join_float_bg');document.body.style.overflow = 'hidden';">회원가입</a></li>
        </c:if>
        <c:if test="${memberInfo ne null}">
          <li onclick="toggle2('top_sub_id2');">
            <a href="#100">${memberInfo.name} 님</a>
          </li>
          <div id="top_sub_id2" style="display:none;">
          	<li><a href="#100" style="background:#e6e6e6;" onclick="logout_ajax(${member_no});">&nbsp;&nbsp;로그아웃</a></li>
          	<li><a href="#100" style="background:#e6e6e6;" onclick="login_edit_btn_ajax();">&nbsp;&nbsp;회원수정</a></li>
          </div>
          <c:if test="${memberInfo.orders eq 1}">
            <li><a href="mypage.o?mypage=1">마이페이지</a></li>
          </c:if>
          <c:if test="${memberInfo.orders eq 2}">
            <li><a href="view.o?member_no=${memberInfo.no}">내 기업</a></li>
          </c:if>
        </c:if>
	    <li><a href="list.o?search=1">기업정보</a></li>
	    <li><a href="list.o?search=2">채용정보</a></li>
	</ul>
</div>
<div class="header">
  <div class="container">
    <div class="row">
    
      <div class="col-sm-1"></div>
      <div class="hidden-sm hidden-md hidden-lg">
      	<div class="header_logo_bg ">
			<a href="#100" onclick="show2('xs_menu_id');document.body.style.overflow='hidden';" class=" nav_menu">
				<div></div>
				<div></div>
				<div></div>
			</a>
	      	<h1 class="logo_float"><a href="index.o"><img src="./images/logo.jpg" alt="logo" /></a></h1>
      	</div>
      </div>
      <div class="search_box_align hidden-sm hidden-md hidden-lg">
        <div class="search_box">
          <form action="list.o" id="top_search">
          <input type="text" name="searchValue" />
          <a href="#100" onclick="top_search.submit();"><img src="./images/search_btn.jpg" alt="search" /></a>
          </form>
        </div>
      </div>
      
      <div class="col-sm-10 hidden-xs">
	      <div class="last_align_l top_menu_align_left">
	        <ul class="header_ul hidden-xs">
	          <li class="header_ul_li"><a href="list.o?search=1" class="header_ul_li_a">기업정보</a></li>
	          <li class="header_ul_li"><a href="list.o?search=2" class="header_ul_li_a">채용정보</a></li>
	        </ul>
	      </div>
	      
	      <div class="last_align_c">
	      	<div class="search_box_bg">
		        <form action="list.o" id="top_search">
		      	<h2 class="logo_float"><a href="index.o"><img src="./images/logo.jpg" alt="logo" /></a></h2>
		        <div class="search_box2">
		          <input type="text" name="searchValue" />
		          <a href="#100" onclick="top_search.submit();"><img src="./images/search_btn.jpg" alt="search" /></a>
		        </div>
		        </form>
	        </div>
	      </div>
	      
	      <div class="last_align_r top_menu_align">
	        <ul class="header_ul hidden-xs" id="login_btn_bg">
	        <c:if test="${memberInfo eq null}">
	          <li class="header_ul_li"><a href="#100" class="header_ul_li_a" onclick="show2('login_float_bg');document.body.style.overflow = 'hidden';">로그인</a></li>
	          <li class="header_ul_li"><a href="#100" class="header_ul_li_a" onclick="show2('join_float_bg');document.body.style.overflow = 'hidden';">회원가입</a></li>
	        </c:if>
	        <c:if test="${memberInfo ne null}">
	          <li class="header_ul_li" onmousemove="show('top_sub_id');" onmouseleave="hide('top_sub_id')"><a href="#100" class="header_ul_li_a">${memberInfo.name} 님</a>
	          	<div id="top_sub_id" class="top_sub" style="display:none;">
	          		<a href="#100" onclick="logout_ajax(${member_no});">로그아웃</a>
	          		<a href="#100" onclick="login_edit_btn_ajax();">회원수정</a>
	          	</div>
	          </li>
	          <c:if test="${memberInfo.orders eq 1}">
	            <li class="header_ul_li"><a href="mypage.o?mypage=1" class="header_ul_li_a">마이페이지</a></li>
	          </c:if>
	          <c:if test="${memberInfo.orders eq 2}">
	            <li class="header_ul_li"><a href="view.o?member_no=${memberInfo.no}" class="header_ul_li_a">내 기업</a></li>
	          </c:if>
	        </c:if>
	        </ul>
	      </div>
	  </div>
      <div class="col-sm-1"></div>
      
      
    </div>
  </div>
</div>

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
