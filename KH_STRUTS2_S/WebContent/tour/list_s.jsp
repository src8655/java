<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>






<script type="text/javascript">
<c:forEach items="${list}" var="lrdata">
var times_${lrdata.no} = ${lrdata.times_tmp};
function settime_${lrdata.no}() {
	var times_data = times_${lrdata.no};
	var times_second = times_data%60;		//초
	times_data = Math.floor(times_data/60);
	var times_minute = times_data%60;		//분
	times_data = Math.floor(times_data/60);
	var times_hour = times_data%24;			//시
	times_data = Math.floor(times_data/24);

	if(times_second < 10) times_second = "0"+times_second;
	if(times_minute < 10) times_minute = "0"+times_minute;
	if(times_hour < 10) times_hour = "0"+times_hour;
	
	document.getElementById("left_time_${lrdata.no}").innerHTML = "<span style='font-weight:bold;'>"+times_data+"</span> 일 <span style='font-weight:bold;'>"+times_hour+":"+times_minute+":"+times_second+"</span>";
	times_${lrdata.no} = times_${lrdata.no} - 1;
	setTimeout ("settime_${lrdata.no}();", 1000); 
}
</c:forEach>
function timers() {
	<c:forEach items="${list}" var="lrdata">
	settime_${lrdata.no}();
	</c:forEach>
}
</script>










		<div id="con_search" style="margin-left:300px;margin-top:30px;margin-bottom:30px;">
	  		<div id="con_search_top">
	  			<h1><img src="./images/main_search_h1.jpg" alt="여행상품 검색" /></h1>
	  			<p><img src="./images/main_search_h2.jpg" alt="상품검색" /></p>
	  		</div>
	  		<form action="list_s.o" method="get">
	  			<div class="con_search_line">
		  			<div>
		  				<h1>출발일</h1>
		  				<p><input type="text" name="startdates" value="${startdates}" /></p>
		  			</div>
		  			<div>
		  				<h1>여행기간</h1>
		  				<p><input type="text" name="days" value="${days}" /></p>
		  			</div>
	  			</div>
	  			<div class="con_search_line">
		  			<div>
		  				<h1>카테고리</h1>
		  				<p>
		  					<select name="category">
		  						<option value="-1">선택</option>
		  						<option value="1" <c:if test="${category eq 1}">selected</c:if>>국내여행
		  						<option value="2" <c:if test="${category eq 2}">selected</c:if>>중국/몽골</option>
		  						<option value="3" <c:if test="${category eq 3}">selected</c:if>>동남아</option>
		  						<option value="4" <c:if test="${category eq 4}">selected</c:if>>괌/사이판</option>
		  						<option value="5" <c:if test="${category eq 5}">selected</c:if>>남태평양</option>
		  						<option value="6" <c:if test="${category eq 6}">selected</c:if>>미주/중남미</option>
		  						<option value="7" <c:if test="${category eq 7}">selected</c:if>>유럽/중동</option>
		  					</select>
		  				</p>
		  			</div>
		  			<div>
		  				<h1>예상금액</h1>
		  				<p><input type="text" name="money" value="${money}" /></p>
		  			</div>
	  			</div>
	  			<div class="con_search_line">
		  			<div>
		  				<h1>검색어</h1>
		  				<p><input type="text" name="subject" value="${subject}" /></p>
		  			</div>
		  			<input type="submit" value="&nbsp;" class="con_search_btn" />
	  			</div>
	  		</form>
	  	</div>
	
	<div class="basket_con">
		<h1 class="basket_con_h">
			<div></div>
			<p>상품예약 검색 결과</p>
		</h1>
		
		
		<c:forEach var="lrdata" items="${list}">
		
		<form action="basket_add.o" method="post" id="list_s_form_${lrdata.no}">
		<input type="hidden" name="no" value="${lrdata.no}" />
		<div class="basket_con_data">
			<h1><c:if test="${lrdata.special eq 1}"><span style="font-weight:bold;color:red;">[!특가!]</span></c:if>${lrdata.subject}</h1>
			<div class="basket_con_data_l">
				<a href="view.o?no=${lrdata.list_no}" target="_BLANK"><img src="./upload/${lrdata.file1}" alt="img" width="200px" height="135px" /></a>
				<a href="#100" onclick="list_s_form_${lrdata.no}.submit();" class="basket_btn1">상품바구니 담기</a>
			</div>
			<div class="basket_con_data_r">
				<table cellspacing="0" cellpadding="10" border="0">
				<col width="110px" />
				<col width="130px" />
				<col width="80px" />
				<col width="140px" />
					<tr>
						<th colspan="4" style="text-align:center;">
							상품번호&nbsp;&nbsp;<span style="color:#029c14;">${lrdata.list_no}</span>&nbsp;&nbsp;&nbsp;&nbsp;
							예약상품번호&nbsp;&nbsp;<span style="color:#029c14;">${lrdata.no}</span>
						</th>
					</tr>
					<tr>
						<th>도시</th>
						<td>${lrdata.city}</td>
						<th>마감일</th>
						<td><div class="left_time" id="left_time_${lrdata.no}" style="border:0px;padding-bottom:0px;margin:0px;"></div></td>
					</tr>
					<tr>
						<th>출발일(여행기간)</th>
						<td colspan="3">${lrdata.startdates} ~ ${lrdata.enddates}(${lrdata.days}일)</td>
					</tr>
					<tr>
						<th>항공사</th>
						<td colspan="3">${lrdata.air}</td>
					</tr>
					<tr>
						<th>여행요금</th>
						<td>${lrdata.moneys}원</td>
						<th>인원</th>
						<td>
								<div style="float:left;">
								<select name="max_cnts">
									<c:forEach begin="1" end="${lrdata.max_cnts}" step="1" var="i">
									<option value="${i}">${i}명</option>
									</c:forEach>
								</select>
								</div>
						</td>
					</tr>
				</table>
			</div>
		</div>
		</form>
		</c:forEach>
	</div>
	
	
	
	<div class="list_page">
		<a href="list_s.o?pages=1&category=${category}&subject=${subject_utf}&days=${days}&startdates=${startdates}&money=${money}" class="list_page_a">◀</a>
		<c:forEach begin="${paging.pstarts}" end="${paging.pends}" step="1" var="i">
			<a href="list_s.o?pages=${i}&category=${category}&subject=${subject_utf}&days=${days}&startdates=${startdates}&money=${money}" <c:if test="${i ne pages}"> class="list_page_a"</c:if> <c:if test="${i eq pages}"> class="list_page_a_hover"</c:if>>${i}</a>
		</c:forEach>
		<a href="list_s.o?pages=${paging.board_paging}&category=${category}&subject=${subject_utf}&days=${days}&startdates=${startdates}&money=${money}" class="list_page_a">▶</a>
	</div>

