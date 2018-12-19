<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 	<div class="con_line">
	  	<div id="con_hot">
	  		<h1><img src="./images/main_hot.jpg" alt="주목상품" /></h1>
	  		<div><a href="view.o?no=${ldata_hot.no}&category=${ldata_hot.category}"><img src="./upload/${ldata_hot.file1}" width="289px" alt="${ldata_hot.subject}" /></a></div>
	  	</div>
	  	<div id="con_search">
	  		<div id="con_search_top">
	  			<h1><img src="./images/main_search_h1.jpg" alt="여행상품 검색" /></h1>
	  			<p><img src="./images/main_search_h2.jpg" alt="상품검색" /></p>
	  		</div>
	  		<form action="list_s.o" method="get">
	  			<div class="con_search_line">
		  			<div>
		  				<h1>출발일</h1>
		  				<p><input type="date" name="startdates" /></p>
		  			</div>
		  			<div>
		  				<h1>여행기간</h1>
		  				<p><input type="text" name="days" /></p>
		  			</div>
	  			</div>
	  			<div class="con_search_line">
		  			<div>
		  				<h1>카테고리</h1>
		  				<p>
		  					<select name="category">
		  						<option value="-1">선택</option>
		  						<option value="1">국내여행</option>
		  						<option value="2">중국/몽골</option>
		  						<option value="3">동남아</option>
		  						<option value="4">괌/사이판</option>
		  						<option value="5">남태평양</option>
		  						<option value="6">미주/중남미</option>
		  						<option value="7">유럽/중동</option>
		  					</select>
		  				</p>
		  			</div>
		  			<div>
		  				<h1>예상금액</h1>
		  				<p><input type="text" name="money" /></p>
		  			</div>
	  			</div>
	  			<div class="con_search_line">
		  			<div>
		  				<h1>검색어</h1>
		  				<p><input type="text" name="subject" /></p>
		  			</div>
		  			<input type="submit" value="&nbsp;" class="con_search_btn" />
	  			</div>
	  		</form>
	  	</div>
	  	<div id="con_special">
	  		<h1><img src="./images/main_special.jpg" alt="파격특가" /></h1>
	  		<ul>
	  			<c:forEach items="${list_special}" var="lrdata">
		  			<li><div></div><a href="view.o?no=${lrdata.list_no}&category=${lrdata.category}">
		  				<p style="float:left;width:155px;">${lrdata.startdates} ${lrdata.subject}</p><p style="float:right;width:80px;text-align:right;">${lrdata.moneys}원</p></a>
		  			</li>
	  			</c:forEach>
	  		</ul>
	  	</div>
  	</div>
  	
  	<div class="con_line">
  		<div id="con_notice">
	  		<h1><p><img src="./images/main_notice.jpg" alt="공지사항" /></p><a href="notice.o"><img src="./images/main_more.jpg" alt="더보기" /></a></h1>
	  		<ul>
	  			<c:forEach items="${list_notice}" var="ndata">
	  			<li><div></div><a href="notice_view.o?no=${ndata.no}"><p style="float:left;width:185px;">${ndata.subject}</p><p style="float:right;width:90px;text-align:right;">[${ndata.dates}]</p></a></li>
	  			</c:forEach>
	  		</ul>
	  	</div>
	  	<div class="con_tab">
	  		<ul class="con_tab_ul">
	  			<li style="float:left;margin-left:5px;"><a href="#" id="con_tab_a1" class="con_tab_a_hover" onmouseover="con_tab_hover(this,1);" style="width:150px;"><img src="./images/main_hit_01.jpg" alt="tab_01" /></a></li>
	  			
	  			<li style="margin-right:5px;"><a href="#" id="con_tab_a8" class="con_tab_a" onmouseover="con_tab_hover(this,8);"><img src="./images/main_hit_08.jpg" alt="tab_08" /></a></li>
	  			<li><a href="list.o?category=6" id="con_tab_a7" class="con_tab_a" onmouseover="con_tab_hover(this,7);"><img src="./images/main_hit_07.jpg" alt="tab_07" /></a></li>
	  			<li><a href="list.o?category=5" id="con_tab_a6" class="con_tab_a" onmouseover="con_tab_hover(this,6);"><img src="./images/main_hit_06.jpg" alt="tab_06" /></a></li>
	  			<li><a href="list.o?category=4" id="con_tab_a5" class="con_tab_a" onmouseover="con_tab_hover(this,5);"><img src="./images/main_hit_05.jpg" alt="tab_05" /></a></li>
	  			<li><a href="list.o?category=3" id="con_tab_a4" class="con_tab_a" onmouseover="con_tab_hover(this,4);"><img src="./images/main_hit_04.jpg" alt="tab_04" /></a></li>
	  			<li><a href="list.o?category=2" id="con_tab_a3" class="con_tab_a" onmouseover="con_tab_hover(this,3);"><img src="./images/main_hit_03.jpg" alt="tab_03" /></a></li>
	  			<li><a href="list.o?category=1" id="con_tab_a2" class="con_tab_a" onmouseover="con_tab_hover(this,2);"><img src="./images/main_hit_02.jpg" alt="tab_02" /></a></li>
	  		</ul>
	  		<ul class="con_tab_data_ul" id="con_tab_data_01">
	  			<c:forEach items="${list_hit}" var="ldata">
	  			<li><a href="view.o?no=${ldata.no}&category=${ldata.category}" onmouseenter="tour_show('tour_f_${ldata.no}_1','tour_ff_${ldata.no}_1')" onmouseleave="tour_hide('tour_f_${ldata.no}_1','tour_ff_${ldata.no}_1')">
	  				<div class="tour_floating" style="display:none;" id="tour_f_${ldata.no}_1"></div>
  					<div class="tour_floating_btn" style="display:none;" id="tour_ff_${ldata.no}_1">자세히보기</div>
	  				<img src="./upload/${ldata.file1}" alt="${ldata.subject}" width="185px" height="125px" /><br />${ldata.subject}<br /><span style="font-weight:bold;">${ldata.moneys}원</span></a></li>
	  			</c:forEach>
	  			</ul>
	  		<ul class="con_tab_data_ul" id="con_tab_data_02" style="display:none;">
	  			<c:forEach items="${list_hit1}" var="ldata">
	  			<li><a href="view.o?no=${ldata.no}&category=${ldata.category}" onmouseenter="tour_show('tour_f_${ldata.no}_2','tour_ff_${ldata.no}_2')" onmouseleave="tour_hide('tour_f_${ldata.no}_2','tour_ff_${ldata.no}_2')">
	  				<div class="tour_floating" style="display:none;" id="tour_f_${ldata.no}_2"></div>
  					<div class="tour_floating_btn" style="display:none;" id="tour_ff_${ldata.no}_2">자세히보기</div>
	  				<img src="./upload/${ldata.file1}" alt="${ldata.subject}" width="185px" height="125px" /><br />${ldata.subject}<br /><span style="font-weight:bold;">${ldata.moneys}원</span></a></li>
	  			</c:forEach>
	  			</ul>
	  		<ul class="con_tab_data_ul" id="con_tab_data_03" style="display:none;">
	  			<c:forEach items="${list_hit2}" var="ldata">
	  			<li><a href="view.o?no=${ldata.no}&category=${ldata.category}" onmouseenter="tour_show('tour_f_${ldata.no}_3','tour_ff_${ldata.no}_3')" onmouseleave="tour_hide('tour_f_${ldata.no}_3','tour_ff_${ldata.no}_3')">
	  				<div class="tour_floating" style="display:none;" id="tour_f_${ldata.no}_3"></div>
  					<div class="tour_floating_btn" style="display:none;" id="tour_ff_${ldata.no}_3">자세히보기</div>
	  				<img src="./upload/${ldata.file1}" alt="${ldata.subject}" width="185px" height="125px" /><br />${ldata.subject}<br /><span style="font-weight:bold;">${ldata.moneys}원</span></a></li>
	  			</c:forEach>
	  			</ul>
	  		<ul class="con_tab_data_ul" id="con_tab_data_04" style="display:none;">
	  			<c:forEach items="${list_hit3}" var="ldata">
	  			<li><a href="view.o?no=${ldata.no}&category=${ldata.category}" onmouseenter="tour_show('tour_f_${ldata.no}_4','tour_ff_${ldata.no}_4')" onmouseleave="tour_hide('tour_f_${ldata.no}_4','tour_ff_${ldata.no}_4')">
	  				<div class="tour_floating" style="display:none;" id="tour_f_${ldata.no}_4"></div>
  					<div class="tour_floating_btn" style="display:none;" id="tour_ff_${ldata.no}_4">자세히보기</div>
	  				<img src="./upload/${ldata.file1}" alt="${ldata.subject}" width="185px" height="125px" /><br />${ldata.subject}<br /><span style="font-weight:bold;">${ldata.moneys}원</span></a></li>
	  			</c:forEach>
	  			</ul>
	  		<ul class="con_tab_data_ul" id="con_tab_data_05" style="display:none;">
	  			<c:forEach items="${list_hit4}" var="ldata">
	  			<li><a href="view.o?no=${ldata.no}&category=${ldata.category}" onmouseenter="tour_show('tour_f_${ldata.no}_5','tour_ff_${ldata.no}_5')" onmouseleave="tour_hide('tour_f_${ldata.no}_5','tour_ff_${ldata.no}_5')">
	  				<div class="tour_floating" style="display:none;" id="tour_f_${ldata.no}_5"></div>
  					<div class="tour_floating_btn" style="display:none;" id="tour_ff_${ldata.no}_5">자세히보기</div>
	  				<img src="./upload/${ldata.file1}" alt="${ldata.subject}" width="185px" height="125px" /><br />${ldata.subject}<br /><span style="font-weight:bold;">${ldata.moneys}원</span></a></li>
	  			</c:forEach>
	  			</ul>
	  		<ul class="con_tab_data_ul" id="con_tab_data_06" style="display:none;">
	  			<c:forEach items="${list_hit5}" var="ldata">
	  			<li><a href="view.o?no=${ldata.no}&category=${ldata.category}" onmouseenter="tour_show('tour_f_${ldata.no}_6','tour_ff_${ldata.no}_6')" onmouseleave="tour_hide('tour_f_${ldata.no}_6','tour_ff_${ldata.no}_6')">
	  				<div class="tour_floating" style="display:none;" id="tour_f_${ldata.no}_6"></div>
  					<div class="tour_floating_btn" style="display:none;" id="tour_ff_${ldata.no}_6">자세히보기</div>
	  				<img src="./upload/${ldata.file1}" alt="${ldata.subject}" width="185px" height="125px" /><br />${ldata.subject}<br /><span style="font-weight:bold;">${ldata.moneys}원</span></a></li>
	  			</c:forEach>
	  			</ul>
	  		<ul class="con_tab_data_ul" id="con_tab_data_07" style="display:none;">
	  			<c:forEach items="${list_hit6}" var="ldata">
	  			<li><a href="view.o?no=${ldata.no}&category=${ldata.category}" onmouseenter="tour_show('tour_f_${ldata.no}_7','tour_ff_${ldata.no}_7')" onmouseleave="tour_hide('tour_f_${ldata.no}_7','tour_ff_${ldata.no}_7')">
	  				<div class="tour_floating" style="display:none;" id="tour_f_${ldata.no}_7"></div>
  					<div class="tour_floating_btn" style="display:none;" id="tour_ff_${ldata.no}_7">자세히보기</div>
	  				<img src="./upload/${ldata.file1}" alt="${ldata.subject}" width="185px" height="125px" /><br />${ldata.subject}<br /><span style="font-weight:bold;">${ldata.moneys}원</span></a></li>
	  			</c:forEach>
	  			</ul>
	  		<ul class="con_tab_data_ul" id="con_tab_data_08" style="display:none;">
	  			<c:forEach items="${list_hit7}" var="ldata">
	  			<li><a href="view.o?no=${ldata.no}&category=${ldata.category}" onmouseenter="tour_show('tour_f_${ldata.no}_8','tour_ff_${ldata.no}_8')" onmouseleave="tour_hide('tour_f_${ldata.no}_8','tour_ff_${ldata.no}_8')">
	  				<div class="tour_floating" style="display:none;" id="tour_f_${ldata.no}_8"></div>
  					<div class="tour_floating_btn" style="display:none;" id="tour_ff_${ldata.no}_8">자세히보기</div>
	  				<img src="./upload/${ldata.file1}" alt="${ldata.subject}" width="185px" height="125px" /><br />${ldata.subject}<br /><span style="font-weight:bold;">${ldata.moneys}원</span></a></li>
	  			</c:forEach>
	  			</ul>
	  	</div>
  	</div>
  	<div class="con_line" style="margin-bottom:40px;">
  		<div id="main_phone"><img src="./images/main_phone.jpg" alt="문의" />	</div>
	  	<div class="con_tab">
	  		<ul class="con_tab_ul">
	  			<li style="float:left;margin-left:5px;"><a href="#" id="con_tab_a1" class="con_tab_a_hover" style="width:150px;"><img src="./images/main_reserve.jpg" alt="reserve" /></a></li>
	  		</ul>
	  		<ul class="con_tab_data_ul" id="con_tab_data_01">
	  			<c:forEach items="${list_buy}" var="ldata">
	  				<li><a href="view.o?no=${ldata.no}&category=${ldata.category}" onmouseenter="tour_show('tour_f_${ldata.no}','tour_ff_${ldata.no}')" onmouseleave="tour_hide('tour_f_${ldata.no}','tour_ff_${ldata.no}')">
	  				<div class="tour_floating" style="display:none;" id="tour_f_${ldata.no}"></div>
  					<div class="tour_floating_btn" style="display:none;" id="tour_ff_${ldata.no}">자세히보기</div>
	  				<img src="./upload/${ldata.file1}" alt="${ldata.subject}" width="185px" height="125px" /><br />${ldata.subject}<br /><span style="font-weight:bold;">${ldata.moneys}원</span></a></li>
	  			</c:forEach>
			</ul>
	  	</div>
  	</div>